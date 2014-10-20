package commonElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_URL="/signin";
    public static final String USER_CABINET_URL="http://my.rozetka.com.ua";

    private static final By userEmail = By.name("login");
    private static final By userPassword = By.name("password");
    private static final By loginButton = By.className("button-css-green");


    public LoginPage(WebDriver driver)
    {
        super(driver,  USER_CABINET_URL, LOGIN_PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

    public void loginAs(String user, String password)
    {
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(user);
        driver.findElement(userPassword).clear();
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
