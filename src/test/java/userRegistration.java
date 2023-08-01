import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

public class userRegistration {
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
        //open the browser
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
        // Locate the element that contains the text
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
        // Retrieve  the text from the element
        String actualText = element.getText();
        // Verify that the text is what we expected
        String expectedText = "New User Signup!";
        assertEquals(expectedText, actualText);

        String name = "Monika";
        String mail = "email@adres.com";
        String password = "Password1!";

        driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]")).sendKeys(name);
        driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]")).sendKeys(mail);
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        // getting name of page
        System.out.println(driver.getCurrentUrl());
        // comparing text on element
        WebElement element1 = driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/h2[1]"));
        String actualText1 = element1.getText();
        String expectedText1 = "ENTER ACCOUNT INFORMATION";
        assertEquals(expectedText1, actualText1);
        driver.findElement(By.id("id_gender2")).click();

        WebElement checkbox = driver.findElement(By.id("id_gender2"));
        // Check if the checkbox is selected
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }
        //masked password filled
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement passwordField = driver.findElement(By.id("password"));
        String password1 = passwordField.getAttribute("value");
        if (password1.isEmpty()) {
            System.out.println("Password field is empty");
        } else {
            System.out.println("Password field is filled");
        }

        //choose elements in drop list
        WebElement selectDays = driver.findElement(By.id("days"));
        Select select = new Select(selectDays);
        select.selectByVisibleText("28");

        WebElement selectMonths = driver.findElement(By.id("months"));
        Select select1 = new Select(selectMonths);
        select1.selectByIndex(5);

        WebElement selectYears = driver.findElement(By.id("years"));
        Select select2 = new Select(selectYears);
        select2.selectByIndex(28);
        // check if elements are correct


        driver.findElement(By.id("newsletter")).click();
        WebElement checkbox1 = driver.findElement(By.id("newsletter"));
        if (checkbox1.isSelected()) {
            System.out.println("newsletter is selected");
        } else {
            System.out.println("newsletter is not selected");
        }

        driver.findElement(By.id("optin")).click();
        WebElement checkbox2 = driver.findElement(By.id("optin"));
        if (checkbox2.isSelected()) {
            System.out.println("optin is selected");
        } else {
            System.out.println("optin is not selected");
        }

        driver.findElement(By.id("first_name")).sendKeys("M");
        driver.findElement(By.id("last_name")).sendKeys("S");

        WebElement selectelement3 = driver.findElement(By.id("country"));
        Select select3 = new Select(selectelement3);
        select.selectByVisibleText("1");

        driver.findElement(By.id("address1")).sendKeys("A");
        driver.findElement(By.id("state")).sendKeys("A");
        driver.findElement(By.id("city")).sendKeys("A");
        driver.findElement(By.id("zipcode")).sendKeys("A");
        driver.findElement(By.id("mobile_number")).sendKeys("A");

        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

        System.out.println(driver.getCurrentUrl());
        WebElement element2 = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
        String actualText2 = element2.getText();
        String expectedText2 = "ACCOUNT CREATED!";
        assertEquals(expectedText2, actualText2);


        WebElement body = driver.findElement(By.xpath("/html/body"));
        Dimension bodySize = body.getSize();
        int x = ThreadLocalRandom.current().nextInt(bodySize.width);
        int y = ThreadLocalRandom.current().nextInt(bodySize.height);

        // create a Point object with the random coordinates
        Point point = new Point(x, y);

        // use JavaScript to click on the randomly generated coordinates
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + point.x + "," + point.y + ");");
        ((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');" +
                "evt.initMouseEvent('click',true, true, window, 0, 0, 0, " + point.x + ", " + point.y + ", false, false, false, false, 0,null);" +
                "arguments[0].dispatchEvent(evt);", body);

        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();

        System.out.println(driver.getCurrentUrl());
        //driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(5) > a:nth-child(1)")).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}



