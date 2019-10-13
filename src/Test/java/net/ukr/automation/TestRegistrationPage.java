package net.ukr.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;

public class TestRegistrationPage {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void testLanguageButtons() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://accounts.ukr.net/registration");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")));

        Assert.assertTrue(driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).isDisplayed());
    }

    @Test
    public void testLanguageButtonsColor() {
        driver.navigate().to("https://accounts.ukr.net/registration");

        driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        String activeButtonUaColor = driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).getCssValue("color");
        String inactiveButtonRuColor = driver.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).getCssValue("color");
        String inactiveButtonEnColor = driver.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).getCssValue("color");

        Assert.assertEquals("rgba(52, 56, 64, 1)", activeButtonUaColor);
        Assert.assertEquals("rgba(102, 153, 0, 1)", inactiveButtonRuColor);
        Assert.assertEquals("rgba(102, 153, 0, 1)", inactiveButtonEnColor);
    }

    @Test
    public void testAccountNameHintAppearing() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);

        driver.navigate().to("https://accounts.ukr.net/registration");

        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-login"))).release().build().perform();
        driver.findElement(By.cssSelector("input#id-login")).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-suggestions")));

        String hintErrorColor = driver.findElement(By.cssSelector(".login-suggestions__error")).getCssValue("color");
        String hintTextColor = driver.findElement(By.cssSelector(".login-suggestions__title")).getCssValue("color");
        String hintSuggestionColor = driver.findElement(By.cssSelector(".login-suggestions__list > li:nth-of-type(1)")).getCssValue("color");

        Assert.assertEquals("rgba(219, 75, 55, 1)", hintErrorColor);
        Assert.assertEquals("rgba(140, 148, 158, 1)", hintTextColor);
        Assert.assertEquals("rgba(78, 78, 78, 1)", hintSuggestionColor);
    }

    @Test
    public void testPersonalInfoHintAppearing() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);

        driver.navigate().to("https://accounts.ukr.net/registration");

        String hintTextUkDesired = "Ваші особисті дані знадобляться для відновлення доступу до пошти за допомогою паспорта, якщо інші способи виявляться неможливими. Тому ім'я, прізвище і дата народження, вказані тут, повинні збігатися з вашими паспортними даними. Інакше ніхто, навіть ми, не зможе допомогти вам – доступ до пошти буде втрачено назавжди.";
        String hintTextRuDesired = "Ваши личные данные понадобятся для восстановления доступа к почте с помощью паспорта, если другие способы окажутся невозможными. Поэтому имя, фамилия и дата рождения, указываемые здесь, должны совпадать с вашими паспортными данными. В противном случае никто, даже мы, не сможет помочь вам – доступ к ящику будет утерян навсегда.";
        String hintTextEnDesired = "You should add your personal information to be able to regain access to your mailbox with your ID if any other recovery options become impossible. Your first name, last name and birthdate specified here, should match those in your ID. Otherwise, this option will also become unavailable, and nobody, not even us, would be capable of recovering access to your account – your mailbox will be permanently unavailable.";


        driver.findElement(By.cssSelector("button:nth-of-type(1) > .header__lang-long-name")).click();
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-first-name"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-login"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        actions.clickAndHold(driver.findElement(By.cssSelector("form .input-group:nth-child(2) .form__field:nth-of-type(2) .input-default__input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-login"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-birth-day"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-login"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        actions.clickAndHold(driver.findElement(By.cssSelector(".input-select__target"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-login"))).release().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        actions.clickAndHold(driver.findElement(By.cssSelector("form .form__field:nth-child(3) .input-default__input"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        String hintTextUkActual = driver.findElement(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")).getText();

        driver.findElement(By.cssSelector("button:nth-of-type(2) > .header__lang-long-name")).click();
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-first-name"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        String hintTextRuActual = driver.findElement(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")).getText();

        driver.findElement(By.cssSelector("button:nth-of-type(3) > .header__lang-long-name")).click();
        actions.clickAndHold(driver.findElement(By.cssSelector("input#id-first-name"))).release().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")));

        String hintTextEnActual = driver.findElement(By.cssSelector(".hint-box.hint-box_expand-x-to-left.hint-box_expand-y-to-bottom")).getText();

        Assert.assertEquals(hintTextUkDesired, hintTextUkActual);
        Assert.assertEquals(hintTextRuDesired, hintTextRuActual);
        Assert.assertEquals(hintTextEnDesired, hintTextEnActual);
    }

    @Test
    public void testEmptyFields() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);

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

    @Test
    public void testPrivacyAgreementAndTerms() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://accounts.ukr.net/registration");
        String parentHandle = driver.getWindowHandle(); // get the registration page handle
        ArrayList<String> agreementPrivacyUrl = new ArrayList<>();
        ArrayList<String> agreementPrivacyUrlToBe = new ArrayList<>(Arrays.asList("https://www.ukr.net/terms/", "https://www.ukr.net/ru/terms/", "https://www.ukr.net/terms/"));
        ArrayList<String> logo = new ArrayList<>();
        ArrayList<String> logoToBe = new ArrayList<>(Arrays.asList("/img/terms-logo-ua.gif", "/img/terms-logo-ru.gif", "/img/terms-logo-ua.gif"));
        ArrayList<String> h2 = new ArrayList<>();
        ArrayList<String> h2ToBe = new ArrayList<>(Arrays.asList("Угода про конфіденційність", "Соглашение о конфиденциальности", "Угода про конфіденційність"));
        ArrayList<String> TermsOfServiceUrl = new ArrayList<>();
        ArrayList<String> TermsOfServiceUrlToBe = new ArrayList<>(Arrays.asList("https://mail.ukr.net/terms_uk.html",
                "https://mail.ukr.net/terms_ru.html",
                "https://mail.ukr.net/terms_en.html"));
        ArrayList<String> h3 = new ArrayList<>();
        ArrayList<String> h3ToBe = new ArrayList<>(Arrays.asList("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)",
                "Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)",
                "Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"));
        ArrayList<String> tabs;

        for (int i = 0; i < 3; i++ ) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button:nth-of-type(" + (i + 1) + ") > .header__lang-long-name")));
            driver.findElement(By.cssSelector("button:nth-of-type(" + (i + 1) + ") > .header__lang-long-name")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form [data-tooltip]")));
            driver.findElement(By.cssSelector("form [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));
            agreementPrivacyUrl.add(driver.getCurrentUrl());
            logo.add(driver.findElement(By.cssSelector("img")).getAttribute("src"));
            h2.add(driver.findElement(By.cssSelector("h2")).getText());
            driver.close();
            driver.switchTo().window(parentHandle);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm-terms [data-tooltip]")));
            driver.findElement(By.cssSelector(".confirm-terms [data-tooltip]")).click(); // click some link that opens a new window
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
            TermsOfServiceUrl.add(driver.getCurrentUrl());
            h3.add(driver.findElement(By.cssSelector("h3")).getText());
            driver.close();
            driver.switchTo().window(parentHandle);

            Assert.assertEquals(agreementPrivacyUrlToBe.get(i), agreementPrivacyUrl.get(i));
            Assert.assertThat(logo.get(i), containsString(logoToBe.get(i)));
            Assert.assertEquals(h2ToBe.get(i), h2.get(i));
            Assert.assertEquals(TermsOfServiceUrlToBe.get(i), TermsOfServiceUrl.get(i));
            Assert.assertEquals(h3ToBe.get(i), h3.get(i));
        }
    }
}