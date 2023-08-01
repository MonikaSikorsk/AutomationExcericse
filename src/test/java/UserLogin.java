import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

public class UserLogin {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\TestFiles\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void VerifyPageOpen() throws InterruptedException {
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);

        String name = "Monika";
        String mail = "email@adres.com";
        String password = "Password1!";

        //clicking login a user
        driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(4) > a:nth-child(1)")).click();
        //typing username/mail
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(3)")).sendKeys(password);
        //typing password
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(2)")).sendKeys(mail);
        //clicking login
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > button.btn.btn-default:nth-child(4)")).click();


        //verify that user is login

        // Locate the element that contains the text you want to verify
        WebElement element = driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(10) > a:nth-child(1)"));
        // Get the text from the element
        String loggedInText = element.getText();
        // Define the expected text
        String expectedText = "Logged in as Monika";
        // Use TestNG's assertion to check if the text matches the expected text
        assertEquals(loggedInText, expectedText, "Text does not match the expected value.");
        driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(4) > a:nth-child(1)")).click();

        //verify user is logged in
        WebElement element1 = driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form > h2:nth-child(1)"));
        String loggedOutText = element1.getText();
        String expectedText1 = "Login to your account";
        assertEquals(loggedOutText, expectedText1, "Text does not much, user did't loggedout");

        System.out.println(driver.getCurrentUrl());


        String expectedTitle1 = "Automation Exercise - Signup / Login";
        String actualTitle1 = driver.getTitle();
        assertEquals(expectedTitle1, actualTitle1);
        //login with wrong password
        String name1 = "Monika";
        String mail1 = "email@adres.com";
        String wrongPassword = "Password";

        //clicking login a user
        driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(4) > a:nth-child(1)")).click();
        //typing username/mail
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(3)")).sendKeys(wrongPassword);
        //typing password
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(2)")).sendKeys(mail1);
        //clicking login
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > button.btn.btn-default:nth-child(4)")).click();


        // Locate the element that contains the text you want to verify
        WebElement element2 = driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > p:nth-child(4)"));
        // Get the text from the element
        String wrongLoginText = element2.getText();
        // Define the expected text
        String expectedText2 = "Your email or password is incorrect!";
        // Use TestNG's assertion to check if the text matches the expected text
        assertEquals(wrongLoginText, expectedText2, "Text does not match the expected value.");

        String expectedTitle2 = "Automation Exercise - Signup / Login";
        String actualTitle2 = driver.getTitle();
        assertEquals(expectedTitle2, actualTitle2);
        //login with wrong Mail
        String name2 = "Monika";
        String wrongMail = "email1@adres.com";
        String password2 = "Password1!";

        //clicking login a user
        driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(4) > a:nth-child(1)")).click();
        //typing username/mail
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(3)")).sendKeys(password2);
        //typing password
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > input:nth-child(2)")).sendKeys(wrongMail);
        //clicking login
        driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > button.btn.btn-default:nth-child(4)")).click();


        // Locate the element that contains the text you want to verify
        WebElement element3 = driver.findElement(By.cssSelector("div.container div.row div.col-sm-4.col-sm-offset-1:nth-child(1) div.login-form form:nth-child(2) > p:nth-child(4)"));
        // Get the text from the element
        String wrongLoginText3 = element3.getText();
        // Define the expected text
        String expectedText3 = "Your email or password is incorrect!";
        // Use TestNG's assertion to check if the text matches the expected text
        assertEquals(wrongLoginText3, expectedText3, "Text does not match the expected value.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
