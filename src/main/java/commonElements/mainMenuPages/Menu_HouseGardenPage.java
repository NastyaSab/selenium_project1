package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_HouseGardenPage extends BasePage {

    private static final String PAGE_URL = "/house_garden";

    public Menu_HouseGardenPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

}
