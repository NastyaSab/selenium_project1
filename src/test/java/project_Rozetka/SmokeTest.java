package project_Rozetka;

import commonElements.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ReportWriter;


public class SmokeTest extends TestBase {
    private static final String PRODUCT_FOR_SEARCH = "HP Pavilion 15-n033sr (F4V10EA) с Windows8!";

    @Test
    public void smokeTest()
    {
            ReportWriter.info("Start SmokeTest");
        HomePage homePage = new HomePage(driver);
        homePage.open();
            ReportWriter.info("Open HomePage");
        Assert.assertTrue(homePage.isOpened());

        homePage.searchProduct(PRODUCT_FOR_SEARCH);
            ReportWriter.info("Search the product: '" + PRODUCT_FOR_SEARCH + "'");
        Assert.assertTrue(homePage.isSearch(PRODUCT_FOR_SEARCH));
    }
}
