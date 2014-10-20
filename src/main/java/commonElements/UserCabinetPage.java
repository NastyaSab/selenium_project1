package commonElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import util.ReportWriter;

public class UserCabinetPage extends BasePage {

    public static final String PAGE_URL="/";
    public static final String USER_CABINET_URL="http://my.rozetka.com.ua";
    private static final  By profile = By.name("profile");
    private static final  By signout = By.name("signout");

    //Корзина
    private static final  By openCart = By.name("open_cart");
    private static final  By productsFromCart = By.xpath("//*[@name='delete']//img");
    private static final  String xpathDeleteProductsFromCart  =   "(//*[@name='delete']//img)";
    private static final  By popupCloseIcon = By.className("popup-close-icon");


    public UserCabinetPage(WebDriver driver)
    {
        super(driver,  USER_CABINET_URL, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

    public boolean isLogin (String user_name)
    {
        try{
            driver.findElement(profile).getText().contains(user_name);
            ReportWriter.info("User '" + user_name + "' is successfully login");
            return true;
        }
        catch (NoSuchElementException e)
        {
            ReportWriter.info("User '" + user_name + "' is not login");
            return false;
        }
    }

    public void cleanCart ()
    {
        driver.findElement(openCart).click();

        int numberOfProducts = driver.findElements(productsFromCart).size();
                for(int i = numberOfProducts; i > 0; i--)
                    {
                        driver.findElement(By.xpath(xpathDeleteProductsFromCart + "[" + i + "]")).click();
                    }

        //driver.findElement(By.xpath("//*[@id='cart-popup']/div/div/div[1]/div[2]/div/div[1]/a/img")).click();

        driver.findElement(popupCloseIcon).click();
    }

    public void logout ()
    {
        try
        {
            driver.findElement(signout).click();
        }
        catch (NoSuchElementException e)
        {
            ReportWriter.info("User is already logout");
        }
    }

}
