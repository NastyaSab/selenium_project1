package commonElements;

import org.openqa.selenium.WebDriver;
import util.ReportWriter;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;
    protected String mainUrl;

    abstract public void open();

    public boolean isOpened()
    {
        ReportWriter.info("'" + pageUrl + "' is opened!");
        return driver.getCurrentUrl().contains(pageUrl);
    }

    public BasePage(WebDriver driver, String userCabinetUrl, String pageUrl)
    {
        this.pageUrl = userCabinetUrl + pageUrl;
        this.driver = driver;
    }

    public BasePage(WebDriver driver, String pageUrl)
    {
        mainUrl = "http://rozetka.com.ua";
        this.pageUrl = mainUrl + pageUrl;
        this.driver = driver;
    }

}
