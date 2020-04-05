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
public class Test_07_FindElemets {

    public WebDriver driver;
    public WebDriverWait wait;
    public static String website;

    public Test_07_FindElemets() {
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
    public void TestMenu() {
        //Login
        driver.get(website);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        //CSS selectors
        String cssMenuLevel_01 = "ul#box-apps-menu li#app-";
        String cssMenuLevel_02 = "ul#box-apps-menu li#app- ul.docs span.name";
        String cssHeader = "h1";

        //find menu items of the first level
        List<WebElement> MenuItems_01 = driver.findElements(By.cssSelector(cssMenuLevel_01));
        int MenuItems_01_Count = MenuItems_01.size();

        System.out.println(MenuItems_01_Count);

        for (int i = 0; i < MenuItems_01_Count; i++) {
            System.out.print(String.valueOf(i + 1) + ": " + MenuItems_01.get(i).getText() + " = ");
            MenuItems_01.get(i).click();

            //find menu items of the second level
            List<WebElement> MenuItems_02 = driver.findElements(By.cssSelector(cssMenuLevel_02));
            int MenuItems_02_Count = MenuItems_02.size();
            System.out.println(MenuItems_02_Count);

            for (int j = 0; j < MenuItems_02_Count; j++) {
                System.out.print(" | " + MenuItems_02.get(j).getText());
                MenuItems_02.get(j).click();
                
                //find and print header 
                List<WebElement> Headers = driver.findElements(By.cssSelector(cssHeader));
                if (Headers.size() > 0) {
                    for (int h = 0; h < Headers.size(); h++) {
                        System.out.println(": h1 -> " + Headers.get(h).getText());
                    }
                } else {
                    System.out.println(": h1 -> no header");
                }
                MenuItems_02 = driver.findElements(By.cssSelector(cssMenuLevel_02));
            }
            MenuItems_01 = driver.findElements(By.cssSelector(cssMenuLevel_01));
        }
    }

}
