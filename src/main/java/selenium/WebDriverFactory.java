package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;


public class WebDriverFactory {

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

 public  WebDriver driver;

    public  WebDriver initDriver (String browser)
    {
        if (browser.equals(FIREFOX))
        {
            driver = new FirefoxDriver();
        } else
        if (browser.equals(CHROME))
        {
            File file = new File("src\\main\\resources\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
        }

        return driver;
    }



}
