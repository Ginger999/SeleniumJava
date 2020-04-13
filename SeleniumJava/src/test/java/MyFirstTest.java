/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static org.junit.Assert.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;



/**
 *
 * @author Ginger
 */
public class MyFirstTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public static String website;

    public MyFirstTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        website = "https://www.google.com";
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver(caps);
        //driver = new ChromeDriver();
        System.out.println(((HasCapabilities) driver).getCapabilities());
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void OpenBrowser() {
        System.out.println(website);
        driver.get(website);
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
