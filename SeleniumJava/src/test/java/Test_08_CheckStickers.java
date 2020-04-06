/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 *
 * @author Ginger
 */
public class Test_08_CheckStickers {

    public WebDriver driver;
    public WebDriverWait wait;
    public static String website;

    public Test_08_CheckStickers() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        website = "http://localhost:8080/litecart/admin";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void TestStickers() {
        //go to the page
        driver.get(website);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/div/a/img")).click();
        wait.until(titleIs("Online Store | My Store"));

        //CSS selectors
        String cssProducts = ".product";
        String cssStickers = "div.sticker";

        //find products
        List<WebElement> Products = driver.findElements(By.cssSelector(cssProducts));
        int Products_Count = Products.size();

        //scan products
        for (int i = 0; i < Products_Count; i++) {
            //find stickers
            List<WebElement> Stickers = Products.get(i).findElements(By.cssSelector(cssStickers));
            assertEquals(1, Stickers.size());
        }
    }
}
