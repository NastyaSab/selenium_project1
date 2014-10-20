package commonElements.mainMenuPages;


import commonElements.BasePage;
import org.openqa.selenium.WebDriver;

public class Menu_BTechPage extends BasePage {

public static final String LOGIN_PAGE_URL="/";
public static final String MENU_BT_URL="http://bt.rozetka.com.ua";

    public Menu_BTechPage(WebDriver driver)
    {
        super(driver,  MENU_BT_URL, LOGIN_PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }
}
