import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class AddingProductToCart {
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
        //clicking on product button
        driver.findElement(By.cssSelector("div.header-middle div.container div.row div.col-sm-8 div.shop-menu.pull-right ul.nav.navbar-nav li:nth-child(2) > a:nth-child(1)")).click();
        //Verifying that page with products is open

        WebElement productsTitle = driver.findElement(By.cssSelector("div.container div.row div.col-sm-9.padding-right div.features_items > h2.title.text-center:nth-child(1)"));
        String actualText2 = productsTitle.getText();
        String expectedText2 = "FEATURES ITEMS";
        assertEquals(expectedText2, actualText2);


        WebElement body = driver.findElement(By.xpath("/html/body"));
        Dimension bodySize = body.getSize();
        int x = ThreadLocalRandom.current().nextInt(bodySize.width);
        int y = ThreadLocalRandom.current().nextInt(bodySize.height);

        // create a Point object with the random coordinates
        Point point = new Point(x, y);
//clicking view product
        driver.findElement(By.linkText("View Product")).click();
        //driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
        //cliking add to cart

        driver.findElement(By.cssSelector("div.container div.row div.col-sm-9.padding-right div.features_items div.col-sm-4:nth-child(3) div.product-image-wrapper div.single-products div.product-overlay div.overlay-content > a.btn.btn-default.add-to-cart:nth-child(3)")).click();
        WebElement addToCart = driver.findElement(By.cssSelector("div.container div.row div.col-sm-9.padding-right div.features_items div.modal.show:nth-child(2) div.modal-dialog.modal-confirm div.modal-content div.modal-body > p.text-center:nth-child(1)"));
        String actualText3 = addToCart.getText();
        String expectedText3 = "Your product has been added to cart";
        assertEquals(actualText3, expectedText3,"Product not added to cart");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
