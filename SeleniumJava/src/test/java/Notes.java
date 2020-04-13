//
//import org.junit.Test;
//import static org.junit.Assert.*;

//Ожидания
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
//// ...
//WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
//WebElement element = wait.until(presenceOfElementLocated(By.name("q")));


//Исчезновение элемента
//import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
//// ...
//WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
//driver.navigate().refresh();
//wait.until(stalenessOf(element));

//Ожидание видимости
//import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
//// ...
//WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
//wait.until(visibilityOf(element));

//Alert alert = driver.switchTo().alert();
//String alertText = alert.getText();
//alert.accept();
//// либо alert.dismiss();

//Ожидания, окна, диалоги
//String mainWindow = driver.getWindowHandle();
//Set<String> oldWindows = driver.getWindowHandles();
//link.click(); // открывает новое окно
//// ожидание появления нового окна,
//// идентификатор которого отсутствует в списке oldWindows,
//// остаётся в качестве самостоятельного упражнения
//String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
//driver.switchTo().window(newWindow);
//// ...
//driver.close();
//driver.switchTo().window(mainWindow);

// Переключение между окнами
//String mainWindow = driver.getWindowHandle();
//Set<String> oldWindows = driver.getWindowHandles();
//link.click(); // открывает новое окно
//// ожидание появления нового окна,
//// идентификатор которого отсутствует в списке oldWindows,
//// остаётся в качестве самостоятельного упражнения
//String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
//driver.switchTo().window(newWindow);
//// ...
//driver.close();
//driver.switchTo().window(mainWindow);

//Фреймы
//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
//driver.switchTo().defaultContent();

//Размер и положение окна
//WebDriver.Window window = driver.manage().window();
//window.maximize();
//window.setSize(new Dimension(800, 600));


//Удаленный запуск
//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());