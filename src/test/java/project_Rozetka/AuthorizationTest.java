package project_Rozetka;

import commonElements.HomePage;
import commonElements.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import util.ReportWriter;

public class AuthorizationTest extends TestBase{

      @DataProvider(name = "DataProvider_ForPositiveTest")
    public Object[][] provideData1()
    {
        return new Object[][]         {
                { "ivanov5_5@mail.ru", "123456", "Ivanov" },
        };
    }

    @Test  (dataProvider = "DataProvider_ForPositiveTest")
    public void authorizationTestPositive(String user_email, String user_password, String user_name)
    {
            ReportWriter.info("Start AuthorizationTestPositive");
        HomePage homePage = new HomePage(driver);
        homePage.open();
            ReportWriter.info("Open LoginPage");
        homePage.loginAs(user_email,user_password);
            ReportWriter.info("Login as: '" + user_name + "(" +user_email + ")'");
        Assert.assertTrue(homePage.isLogin(user_name));
        homePage.logout();
            ReportWriter.info("Logout user");
       }

    @DataProvider(name = "DataProvider_ForNegativeTest")
    public Object[][] provideData2()
    {
        return new Object[][]         {
                { "ivanov25@mail.ru", "dxgzf", "Ivanov" }
        };
    }

    @Test  (dataProvider = "DataProvider_ForNegativeTest")
        public void authorizationTestNegative(String user_email, String user_password, String user_name)
    {
            ReportWriter.info("Start AuthorizationTestNegative");
        HomePage homePage = new HomePage(driver);
        homePage.open();
            ReportWriter.info("Open LoginPage");
        homePage.loginAs(user_email,user_password);
            ReportWriter.info("Login as: '" + user_name + "(" +user_email + ")'");
        Assert.assertFalse(homePage.isLogin(user_name));
    }

}
