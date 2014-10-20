package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_ComputersPage extends BasePage {

private static final String PAGE_URL = "/computers-notebooks";

    public Menu_ComputersPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

}
