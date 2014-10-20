package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_TvPhotoVideoPage extends BasePage {
    private static final String PAGE_URL = "/tv-photo-video";

    public Menu_TvPhotoVideoPage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }
}
