package project_Rozetka;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;

import java.util.concurrent.TimeUnit;


public class TestBase {

 public static WebDriver driver;

 //Для запуска параметризированного job в Jenkins
 //private static String browser_name = System.getProperty("browser");

 private static String browser_name = "firefox";

    @BeforeSuite
    public void setUp()
    {
        driver  = new  WebDriverFactory().initDriver(browser_name);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null)
            driver.quit();
        }

}
