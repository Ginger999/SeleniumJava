/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
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
public class Test_09_SortingCountries {

    public WebDriver driver;
    public WebDriverWait wait;
    public static String website;

    public Test_09_SortingCountries() {
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
        //Login   
        driver.get(website);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        //go to the page
        driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        wait.until(titleIs("Countries | My Store"));

        //CSS selectors
        String cssContries = "tr.row > td > a:not([title=Edit])[href*='country']";
        String cssZones = "tr.row > td:nth-child(6)";

        //xPath
        //label[contains(@class, 'error') and contains(@class, 'fatal') and @for='email']
        String xPathContries = "tr[contains(@class, 'row')/td]";
        
        //find Contries
        List<WebElement> Contries = driver.findElements(By.cssSelector(cssContries));
        int Contries_Count = Contries.size();
        //scan Contries
        List<String> displayedNames = new ArrayList();
        List<String> SortedNames = new ArrayList();
        String getData;
        for (int i = 0; i < Contries_Count; i++) {
            getData = Contries.get(i).getText();
            displayedNames.add(getData);
            SortedNames.add(getData);

            System.out.println(String.valueOf(i + 1) + ": " + getData);
        }
        // check sorting contries
        List<String> sortingOperation = displayedNames;
        Collections.sort(sortingOperation);
        assertEquals(SortedNames, sortingOperation);
    }
}
