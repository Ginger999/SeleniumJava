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
import static org.junit.Assert.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 *
 * @author Ginger
 */
public class Test_02_Login {

    public WebDriver driver;
    public WebDriverWait wait;
    public static String website;

    public Test_02_Login() {
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
    public void TestLinkClick() {
        driver.get(website);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/div/a/img")).click();
        wait.until(titleIs("Online Store | My Store"));
    }

    @Test
    public void TestLogin() {
        driver.get(website);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }
}
