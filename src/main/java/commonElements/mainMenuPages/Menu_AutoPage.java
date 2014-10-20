package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_AutoPage extends BasePage {

    private static final String PAGE_URL = "/273290";

    public Menu_AutoPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }
}
