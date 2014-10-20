package commonElements;


import commonElements.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import util.ReportWriter;

public class MainMenu extends BasePage {

private static final String PAGE_URL = "/";
private static final String xpathMenuTitles = "(//*[@class=\"m-main-title\"])";
private static final String greenColor = "rgba(50, 154, 28, 1)";

    public MainMenu(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

    public boolean switchMenu(int pageMenuNumber, String menuPageUrl)
    {
     try{
            driver.findElement(By.xpath(xpathMenuTitles + "[" + pageMenuNumber + "]")).click();
                ReportWriter.info("Switching on: '" + driver.findElement(By.xpath(xpathMenuTitles + "[" + pageMenuNumber + "]")).getText() + "' menu");
                    if (!driver.findElement(By.xpath(xpathMenuTitles + "[" + pageMenuNumber + "]")).getCssValue("background-color").equals(greenColor))
                    {
                        ReportWriter.error("Active menu item isn't green color");
                        return false;
                    }

                    if (!driver.getCurrentUrl().contains(menuPageUrl))
                    {
                        ReportWriter.error("Active menu item has wrong URL");
                        return false;
                    }
                    else
                        return true;

     }
     catch(NoSuchElementException e)
     {return false;}
    }

}
