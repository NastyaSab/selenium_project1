package project_Rozetka;

import commonElements.MainMenu;
import org.testng.annotations.DataProvider;
import util.ReportWriter;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MenuTest extends TestBase{

    @DataProvider(name = "DataProvider_ForMenuTest")
    public Object[][] provideData()
    {
        return new Object[][]         {
                { 1, "http://rozetka.com.ua/computers-notebooks"},
                { 2, "http://rozetka.com.ua/phones-mp3-gps"},
                { 3, "http://rozetka.com.ua/tv-photo-video"},
                { 4, "http://bt.rozetka.com.ua"},
                { 5, "http://rozetka.com.ua/outdoorsman"},
                { 6, "http://rozetka.com.ua/kids"},
                { 7, "http://rozetka.com.ua/house_garden"},
                { 8, "http://rozetka.com.ua/273290"},
                { 9, "http://rozetka.com.ua/travel"},
        };
    }

    @Test  (dataProvider = "DataProvider_ForMenuTest")
    public void switchMenuTest (int pageMenuNumber, String menuPageUrl)
    {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.open();
            ReportWriter.info("Open MainMenu");
        Assert.assertTrue(mainMenu.switchMenu(pageMenuNumber, menuPageUrl));
    }

}
