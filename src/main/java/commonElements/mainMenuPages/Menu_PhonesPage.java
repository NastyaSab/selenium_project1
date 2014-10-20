package commonElements.mainMenuPages;

import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_PhonesPage extends BasePage {

    private static final String PAGE_URL = "/phones-mp3-gps";

    public Menu_PhonesPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }
}
