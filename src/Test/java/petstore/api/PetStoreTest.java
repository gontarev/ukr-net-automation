package petstore.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.swagger.petstore.models.Order;
import io.swagger.petstore.models.Pet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetStoreTest {

    private String BASE_URI = "http://petstore.swagger.io/v2",
            apiKeyValue = "1qa2ws3ed4rfvcxz";

    @Test
    public void itemManipulationsTest() {
        OffsetDateTime currentDateTime = OffsetDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"));
        Long testPetId = Long.parseLong(RandomStringUtils.randomNumeric(10));
        String testPetName = "Pet_" + RandomStringUtils.randomAlphabetic(10);
        Long testOrderId = Long.parseLong(RandomStringUtils.randomNumeric(10));

        // create new pet
        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(new Pet()
                        .name(testPetName)
                        .id(testPetId)
                        .status(Pet.StatusEnum.AVAILABLE)
                        .tags(new ArrayList<>()))
                .header("api_key", apiKeyValue)
                .post("/pet").then().assertThat().body(matchesJsonSchemaInClasspath("AddPetSchema.json"));

        // place order with new pet
        given().baseUri(BASE_URI).
                log().everything()
                .contentType(ContentType.JSON)
                .body(new Order()
                        .id(testOrderId)
                        .petId(testPetId)
                        .quantity(1)
                        .shipDate(currentDateTime.toString())
                        .status(Order.StatusEnum.PLACED)
                        .complete(true))
                .header("api_key", apiKeyValue)
                .post("store/order").then().assertThat().body(matchesJsonSchemaInClasspath("PlaceOrderSchema.json"));

        // update existing pet
        given().baseUri(BASE_URI)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(new Pet()
                        .id(testPetId)
                        .name(testPetName)
                        .status(Pet.StatusEnum.SOLD))
                .header("api_key", apiKeyValue)
                .put("/pet").then().assertThat().body(matchesJsonSchemaInClasspath("UpdatePetSchema.json"));

        // delete order
        given().baseUri(BASE_URI).
                log().everything()
                .header("api_key", apiKeyValue)
                .delete("store/order/" + testOrderId).then().statusCode(200);

        // check that pet status == AVAILABLE
        // !!! WILL FAIL !!! Because of status == SOLD
        String petStatus = given().baseUri(BASE_URI).
                log().everything()
                .header("api_key", apiKeyValue)
                .get("pet/" + testPetId).getBody().jsonPath().getString("status");

        Assert.assertEquals("AVAILABLE", petStatus);

        // delete pet
        given().baseUri(BASE_URI).
                log().everything()
                .header("api_key", apiKeyValue)
                .delete("pet/" + testPetId).then().statusCode(200);

        // place order with deleted pet
        // !!! WILL FAIL !!! Because deleted pet can be ordered
        given().baseUri(BASE_URI).
                log().everything()
                .contentType(ContentType.JSON)
                .body(new Order()
                        .id(testOrderId)
                        .petId(testPetId)
                        .quantity(1)
                        .shipDate(currentDateTime.toString())
                        .status(Order.StatusEnum.PLACED)
                        .complete(true))
                .header("api_key", apiKeyValue)
                .post("store/order").then().statusCode(400);
    }
}
