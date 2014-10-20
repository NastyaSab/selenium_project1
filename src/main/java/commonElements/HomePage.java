package commonElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;
import util.ReportWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HomePage extends BasePage {
    private static final String PAGE_URL = "/";

    //Поиск продукта
    private static final  By searchInputText = By.name("text");
    private static final  By searchButton = By.className("btn-link-i");
    private static final  By productsFound = By.xpath("(//*[@class=\"g-i-list-title\"]//a)[1]");

    //Логин-Логаут
    private static final  By entrance = By.name("signin");
    private static final  By signout = By.name("signout");
    private static final  By userEmail = By.name("login");
    private static final  By userPassword = By.name("password");
    private static final  By loginButton = By.className("button-css-blue");
    private static final  By profile = By.name("profile");

    //Корзина
    private static final  By cell_quantity = By.name("quantity");

    //Онлайн-заказ
    private static final  By ByButton = By.xpath("(//*[@class=\"ibutton-css-green button\"])[1]");
    private static final  By checkoutButton = By.id("popup-checkout");

    //Онлайн-заказ, оформление заказа (1-й шаг)
    private static final  By reciever_name = By.id("reciever_name");
    private static final  By reciever_phone = By.id("reciever_phone");
    private static final  By suggest_locality = By.id("suggest_locality");
    private static final  By selectCity = By.name("0");
    private static final  By nextStepButton = By.xpath("//*[@id='step_contacts']/div/div[1]/div[3]/div/span/button");

    //Онлайн-заказ, оформление заказа (2-й шаг)
    private static final  By selectCourier = By.name("couriers");
    private static final  By selectCredit = By.name("credit");
    private static final  By recipient_title_field = By.xpath("//*[@name=\"recipient_title_field\"]//Input");
    private static final  By check_quantity = By.className("check-g-i-amount");

    //Признак активности кнопки при онлайн-заказе
    private static final  By InactivityElement = By.xpath("//span[contains(@class, 'opaque')]");

    public HomePage(WebDriver driver)
    {
        super(driver, PAGE_URL);
    }

    public void open()
    {
        driver.get(pageUrl);
    }

    public void searchProduct (String productName)
    {
        driver.findElement(searchInputText).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public boolean isSearch (String productName)
    {
        try {
            driver.findElement(productsFound).isDisplayed();
            ReportWriter.info("Product '" + productName + "' is found");
            return true;
            }
        catch (NoSuchElementException e) {
            ReportWriter.error("Product '" + productName + "' is not found");
            return false;
            }
    }

    public void loginAs (String user, String password)
    {
        try
        {
            driver.findElement(entrance).click();
            driver.findElement(userEmail).clear();
            driver.findElement(userEmail).sendKeys(user);
            driver.findElement(userPassword).clear();
            driver.findElement(userPassword).sendKeys(password);
            driver.findElement(loginButton).click();
        }
        catch (NoSuchElementException e)
        {
            ReportWriter.info("User is already login");
        }


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

    public void onlineOrder_Cart(String quantity)
    {
        driver.findElement(productsFound).click();
        driver.findElement(ByButton).click();
        driver.findElement(cell_quantity).clear();
        driver.findElement(cell_quantity).sendKeys(quantity);
        driver.findElement(checkoutButton).click();
    }


    public void onlineOrder_1Step (String user_name, String user_phone)
    {
        driver.findElement(reciever_name).clear();
        driver.findElement(reciever_name).sendKeys(user_name);

        driver.findElement(suggest_locality).click();
        driver.findElement(selectCity).click();

        driver.findElement(reciever_phone).clear();
        driver.findElement(reciever_phone).sendKeys(user_phone);

        driver.findElement(nextStepButton).click();
    }

    public boolean onlineOrder_CheckQuantity (String quantity)
    {
        String  quantity_string = driver.findElement(check_quantity).getText();
        Pattern pt = Pattern.compile("\\d+");
        Matcher matcher = pt.matcher(quantity_string);
        matcher.find();
        Integer quantity_int = Integer.parseInt(matcher.group());

       if (quantity_int == Integer.parseInt(quantity))
       {
           ReportWriter.error("Quantity of goods in cart and in order are equal");
           return true;}
        else
       {
           ReportWriter.info("Quantity of goods in cart and in order are not equal");
           return false;
       }

    }

    public void onlineOrder_2Step (String action_name)
    {
        if (action_name == "Select courier")
        {
            ReportWriter.info("Select courier but don't fill required fields in the 2-nd step of OnlineOrder");
            driver.findElement(selectCourier).click();
        }

        if (action_name == "Select credit")
        {
            ReportWriter.info("Select credit but don't fill required fields in the 2-nd step of OnlineOrder");
            driver.findElement(selectCredit).click();
        }

        if (action_name == "Invalid user name")
        {
            ReportWriter.info("Fill invalid user name in the 2-nd step of OnlineOrder");
            driver.findElement(recipient_title_field).clear();
            driver.findElement(recipient_title_field).sendKeys("123@");
        }
    }


    public boolean makeOrderButtonIsActive ()
    {
        try{
            driver.findElement(InactivityElement).isEnabled();
            ReportWriter.error("Button '" + driver.findElement(InactivityElement).getText() + "' is inactive");
            return false;
        }
        catch(NoSuchElementException e)
        {
            ReportWriter.info("MakeOrderButton is Active");
            return true;
        }
    }


    public boolean makeOrderButtonIsNotActive ()
    {
        try{
            driver.findElement(InactivityElement).isEnabled();
            ReportWriter.info("Button '" + driver.findElement(InactivityElement).getText() + "' is inactive");
            return true;
        }
        catch(NoSuchElementException e)
        {
            ReportWriter.error("MakeOrderButton is Active");
            return false;
        }
    }


}
