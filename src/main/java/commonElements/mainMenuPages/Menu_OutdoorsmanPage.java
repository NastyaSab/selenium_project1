package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_OutdoorsmanPage extends BasePage {

    private static final String PAGE_URL = "/outdoorsman";

    public Menu_OutdoorsmanPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

}
