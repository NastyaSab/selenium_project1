package project_Rozetka;


import commonElements.HomePage;
import commonElements.UserCabinetPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ReportWriter;

public class OnlineOrderTest extends TestBase{

    private static final String PRODUCT_FOR_SEARCH = "HP Pavilion 15-n033sr (F4V10EA) с Windows8!";
    private static final String USER_EMAIL = "ivanov5_5@mail.ru";
    private static final String USER_PASSWORD = "123456";
    private static final String USER_NAME = "Ivanov";

    @BeforeMethod
         public void preConditions()
    {
        HomePage homepage = new  HomePage(driver);
        homepage.open();
        homepage.loginAs(USER_EMAIL, USER_PASSWORD);
        homepage.isLogin(USER_NAME);
            ReportWriter.info("HomePage is opened. User is login.");
        homepage.searchProduct(PRODUCT_FOR_SEARCH);
            ReportWriter.info("Search the product: '" + PRODUCT_FOR_SEARCH + "'");
        homepage.isSearch(PRODUCT_FOR_SEARCH);
    }


    @DataProvider(name = "DataProvider_ForOnlineOrderPositiveTest")
        public Object[][] provideData()
    {
        return new Object[][]         {
                {"Ivanov", "050-000-00-00", "", "1"},
        };
    }


    @Test (dataProvider = "DataProvider_ForOnlineOrderPositiveTest")
    public void onlineOrderPositiveTest(String user_name, String user_phone, String action_name, String quantity)
    {
            ReportWriter.info("Start OnlineOrderPositiveTest");
        HomePage homepage = new  HomePage(driver);
        homepage.onlineOrder_Cart(quantity);
        homepage.onlineOrder_1Step(user_name, user_phone);
            ReportWriter.info("Filling data for 1-st step of OnlineOrder");
        Assert.assertTrue(homepage.makeOrderButtonIsActive());
        homepage.onlineOrder_2Step(action_name);
            ReportWriter.info("Filling data for 2-st step of OnlineOrder");
        Assert.assertTrue(homepage.makeOrderButtonIsActive());
    }

    @AfterMethod
    public void postConditions()
    {
        UserCabinetPage userCabinetPage = new  UserCabinetPage(driver);
        userCabinetPage.open();
        userCabinetPage.cleanCart();
            ReportWriter.info("Clean the cart");
        userCabinetPage.logout();
            ReportWriter.info("Logout user: '" + USER_NAME + "'");
    }


}
