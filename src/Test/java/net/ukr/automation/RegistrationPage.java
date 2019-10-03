package net.ukr.automation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 10);
    Actions actions = new Actions(driver);

    @Before
    public void start() {
        ChromeDriverManager.chromedriver().setup();
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void testLanguageButtons() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div/div[2]/button[2]/span[1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div/div[2]/button[3]/span[1]")));

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[2]/span[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[3]/span[1]")).isDisplayed());
    }

    @Test
    public void testLanguageButtonsColor() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")).click();
        String activeButtonUaColor = driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")).getCssValue("color");
        String inactiveButtonRuColor = driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[2]/span[1]")).getCssValue("color");
        String inactiveButtonEnColor = driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[3]/span[1]")).getCssValue("color");

        Assert.assertEquals("rgba(52, 56, 64, 1)", activeButtonUaColor);
        Assert.assertEquals("rgba(102, 153, 0, 1)", inactiveButtonRuColor);
        Assert.assertEquals("rgba(102, 153, 0, 1)", inactiveButtonEnColor);
    }

    @Test
    public void testAccountNameHintAppearing() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-login\"]"))).release().build().perform();
        driver.findElement(By.xpath("//*[@id=\"id-login\"]")).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[1]/div/div")));

        String hintErrorColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/div/p[1]")).getCssValue("color");
        String hintTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/div/p[2]")).getCssValue("color");
        String hintSuggestionColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/div/ul/li[1]")).getCssValue("color");

        Assert.assertEquals("rgba(219, 75, 55, 1)", hintErrorColor);
        Assert.assertEquals("rgba(140, 148, 158, 1)", hintTextColor);
        Assert.assertEquals("rgba(78, 78, 78, 1)", hintSuggestionColor);
    }

    @Test
    public void testPersonalInfoHintAppearing() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        String hintTextUkDesired = "Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе допомогти вам – доступ до пошти буде втрачено назавжди.";
        String hintTextRuDesired = "Ваши личные данные понадобятся для восстановления доступа к почте с помощью паспорта, если другие способы окажутся невозможными. Поэтому имя, фамилия и дата рождения, указываемые здесь, должны совпадать с вашими паспортными данными. В противном случае никто, даже мы, не сможет помочь вам – доступ к ящику будет утерян навсегда.";
        String hintTextEnDesired = "You should add your personal information to be able to regain access to your mailbox with your ID if any other recovery options become impossible. Your first name, last name and birthdate specified here, should match those in your ID. Otherwise, this option will also become unavailable, and nobody, not even us, would be capable of recovering access to your account – your mailbox will be permanently unavailable.";

//        WebElement hint = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[4]"));

        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")).click();
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-first-name\"]"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-login\"]"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/div/div[2]/input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-login\"]"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-birth-day\"]"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-login\"]"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/section/div"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"id-login\"]"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/div[2]/input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        String hintTextUkActual = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")).getText();

        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[2]/span[1]")).click();
        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/div[2]/input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        String hintTextRuActual = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")).getText();

        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[3]/span[1]")).click();
        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/div[2]/input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")));

        String hintTextEnActual = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[4]")).getText();

        // WTF? Not working: no such element: Unable to locate element: {"method":"xpath","selector":"/html/body/div/div/main/form/section[3]/section[4]"}
//        String hintTextEnActual = hint.getText();

        Assert.assertEquals(hintTextUkDesired, hintTextUkActual);
        Assert.assertEquals(hintTextRuDesired, hintTextRuActual);
        Assert.assertEquals(hintTextEnDesired, hintTextEnActual);
    }

    @Test
    public void testEmptyFields() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        String accountNameErrorTextColor;
        String passwordErrorTextColor;
        String passwordRepeatErrorTextColor;
        String firstLastNameErrorTextColor;
        String dateErrorTextColor;
        String genderErrorTextColor;
        String senderNameErrorTextColor;
        String mobileErrorTextColor;

        String accountNameErrorTextUk;
        String passwordErrorTextUk;
        String passwordRepeatErrorTextUk;
        String firstLastNameErrorTextUk;
        String dateErrorTextUk;
        String genderErrorTextUk;
        String senderNameErrorTextUk;
        String mobileErrorTextUk;

        String accountNameErrorTextRu;
        String passwordErrorTextRu;
        String passwordRepeatErrorTextRu;
        String firstLastNameErrorTextRu;
        String dateErrorTextRu;
        String genderErrorTextRu;
        String senderNameErrorTextRu;
        String mobileErrorTextRu;

        String accountNameErrorTextEn;
        String passwordErrorTextEn;
        String passwordRepeatErrorTextEn;
        String firstLastNameErrorTextEn;
        String dateErrorTextEn;
        String genderErrorTextEn;
        String senderNameErrorTextEn;
        String mobileErrorTextEn;

        String accountNameErrorTextUkDesired = "Поле має бути заповнене";
        String passwordErrorTextUkDesired = "Ви не зможете створити поштову скриньку без пароля";
        String passwordRepeatErrorTextUkDesired = "Ви не підтвердили новий пароль";
        String firstLastNameErrorTextUkDesired = "Поле має бути заповнене";
        String dateErrorTextUkDesired = "Поле має бути заповнене";
        String genderErrorTextUkDesired = "Вкажіть стать";
        String senderNameErrorTextUkDesired = "Поле має бути заповнене";
        String mobileErrorTextUkDesired = "Поле має бути заповнене";

        String accountNameErrorTextRuDesired = "Поле должно быть заполнено";
        String passwordErrorTextRuDesired = "Вы не сможете создать почтовый ящик без пароля";
        String passwordRepeatErrorTextRuDesired = "Вы не подтвердили новый пароль";
        String firstLastNameErrorTextRuDesired = "Поле должно быть заполнено";
        String dateErrorTextRuDesired = "Поле должно быть заполнено";
        String genderErrorTextRuDesired = "Укажите пол";
        String senderNameErrorTextRuDesired = "Поле должно быть заполнено";
        String mobileErrorTextRuDesired = "Поле должно быть заполнено";

        String accountNameErrorTextEnDesired = "You can’t leave this empty";
        String passwordErrorTextEnDesired = "You need to think of a password to create a mailbox";
        String passwordRepeatErrorTextEnDesired = "Please confirm your new password";
        String firstLastNameErrorTextEnDesired = "You can’t leave this empty";
        String dateErrorTextEnDesired = "You can’t leave this empty";
        String genderErrorTextEnDesired = "Please specify your gender";
        String senderNameErrorTextEnDesired = "You can’t leave this empty";
        String mobileErrorTextEnDesired = "You can’t leave this empty";

        String accountNameErrorFieldColor;
        String passwordErrorFieldColor;
        String passwordRepeatErrorFieldColor;
        String firstNameErrorFieldColor;
        String lastNameErrorFieldColor;
        String dayErrorFieldColor;
        String monthErrorFieldColor;
        String yearErrorFieldColor;
        String genderMaleErrorRadioColor;
        String genderFemaleErrorRadioColor;
        String senderNameErrorFieldColor;
        String mobileErrorFieldColor;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")));
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[1]/span[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]")));
        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]"))).release().build().perform();

        accountNameErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/p")).getCssValue("color");
        passwordErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[1]/div/p")).getCssValue("color");
        passwordRepeatErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[2]/div/p")).getCssValue("color");
        firstLastNameErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/p")).getCssValue("color");
        dateErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/p")).getCssValue("color");
        genderErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/p")).getCssValue("color");
        senderNameErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[4]/div/p")).getCssValue("color");
        mobileErrorTextColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[6]/div/div/p")).getCssValue("color");

        accountNameErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/p")).getText();
        passwordErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[1]/div/p")).getText();
        passwordRepeatErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[2]/div/p")).getText();
        firstLastNameErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/p")).getText();
        dateErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/p")).getText();
        genderErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/p")).getText();
        senderNameErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[4]/div/p")).getText();
        mobileErrorTextUk = driver.findElement(By.xpath("/html/body/div/div/main/form/section[6]/div/div/p")).getText();


        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[2]/span[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]")));
        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]"))).release().build().perform();

        accountNameErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/p")).getText();
        passwordErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[1]/div/p")).getText();
        passwordRepeatErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[2]/div/p")).getText();
        firstLastNameErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/p")).getText();
        dateErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/p")).getText();
        genderErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/p")).getText();
        senderNameErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[4]/div/p")).getText();
        mobileErrorTextRu = driver.findElement(By.xpath("/html/body/div/div/main/form/section[6]/div/div/p")).getText();


        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/button[3]/span[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]")));
        actions.clickAndHold(driver.findElement(By.xpath("/html/body/div/div/main/form/section[7]/button/span[2]"))).release().build().perform();

        accountNameErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[1]/div/p")).getText();
        passwordErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[1]/div/p")).getText();
        passwordRepeatErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[2]/div[2]/div/p")).getText();
        firstLastNameErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/p")).getText();
        dateErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/p")).getText();
        genderErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/p")).getText();
        senderNameErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[4]/div/p")).getText();
        mobileErrorTextEn = driver.findElement(By.xpath("/html/body/div/div/main/form/section[6]/div/div/p")).getText();


        accountNameErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-login\"]")).getCssValue("border-color");
        passwordErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-password\"]")).getCssValue("border-color");
        passwordRepeatErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-password-repeat\"]")).getCssValue("border-color");
        firstNameErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-first-name\"]")).getCssValue("border-color");
        lastNameErrorFieldColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[1]/div/div[2]/input")).getCssValue("border-color");
        dayErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-birth-day\"]")).getCssValue("border-color");
        monthErrorFieldColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/section")).getCssValue("border-color");
        yearErrorFieldColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[2]/div/div[2]/input")).getCssValue("border-color");
        genderMaleErrorRadioColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/div/div[1]/label[1]")).getCssValue("border-color");
        genderFemaleErrorRadioColor = driver.findElement(By.xpath("/html/body/div/div/main/form/section[3]/section[3]/div/div[2]/label[1]")).getCssValue("border-color");
        senderNameErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-sender-name\"]")).getCssValue("border-color");
        mobileErrorFieldColor = driver.findElement(By.xpath("//*[@id=\"id-mobile\"]")).getCssValue("border-color");


        Assert.assertEquals("rgba(219, 75, 55, 1)", accountNameErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", passwordErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", passwordRepeatErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", firstLastNameErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", dateErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", genderErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", senderNameErrorTextColor);
        Assert.assertEquals("rgba(219, 75, 55, 1)", mobileErrorTextColor);


        Assert.assertEquals("rgb(219, 75, 55)", accountNameErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", passwordErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", passwordRepeatErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", firstNameErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", lastNameErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", dayErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", monthErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", yearErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", genderMaleErrorRadioColor);
        Assert.assertEquals("rgb(219, 75, 55)", genderFemaleErrorRadioColor);
        Assert.assertEquals("rgb(219, 75, 55)", senderNameErrorFieldColor);
        Assert.assertEquals("rgb(219, 75, 55)", mobileErrorFieldColor);


        Assert.assertEquals(accountNameErrorTextUkDesired, accountNameErrorTextUk);
        Assert.assertEquals(passwordErrorTextUkDesired, passwordErrorTextUk);
        Assert.assertEquals(passwordRepeatErrorTextUkDesired, passwordRepeatErrorTextUk);
        Assert.assertEquals(firstLastNameErrorTextUkDesired, firstLastNameErrorTextUk);
        Assert.assertEquals(dateErrorTextUkDesired, dateErrorTextUk);
        Assert.assertEquals(genderErrorTextUkDesired, genderErrorTextUk);
        Assert.assertEquals(senderNameErrorTextUkDesired, senderNameErrorTextUk);
        Assert.assertEquals(mobileErrorTextUkDesired, mobileErrorTextUk);


        Assert.assertEquals(accountNameErrorTextRuDesired, accountNameErrorTextRu);
        Assert.assertEquals(passwordErrorTextRuDesired, passwordErrorTextRu);
        Assert.assertEquals(passwordRepeatErrorTextRuDesired, passwordRepeatErrorTextRu);
        Assert.assertEquals(firstLastNameErrorTextRuDesired, firstLastNameErrorTextRu);
        Assert.assertEquals(dateErrorTextRuDesired, dateErrorTextRu);
        Assert.assertEquals(genderErrorTextRuDesired, genderErrorTextRu);
        Assert.assertEquals(senderNameErrorTextRuDesired, senderNameErrorTextRu);
        Assert.assertEquals(mobileErrorTextRuDesired, mobileErrorTextRu);


        Assert.assertEquals(accountNameErrorTextEnDesired, accountNameErrorTextEn);
        Assert.assertEquals(passwordErrorTextEnDesired, passwordErrorTextEn);
        Assert.assertEquals(passwordRepeatErrorTextEnDesired, passwordRepeatErrorTextEn);
        Assert.assertEquals(firstLastNameErrorTextEnDesired, firstLastNameErrorTextEn);
        Assert.assertEquals(dateErrorTextEnDesired, dateErrorTextEn);
        Assert.assertEquals(genderErrorTextEnDesired, genderErrorTextEn);
        Assert.assertEquals(senderNameErrorTextEnDesired, senderNameErrorTextEn);
        Assert.assertEquals(mobileErrorTextEnDesired, mobileErrorTextEn);


    }
}