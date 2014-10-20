package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_TravelPage extends BasePage {

        private static final String PAGE_URL = "/travel";

        public Menu_TravelPage(WebDriver driver)
        {
            super(driver, PAGE_URL);
        }

        public void open()
        {
            driver.get(pageUrl);
        }
}
