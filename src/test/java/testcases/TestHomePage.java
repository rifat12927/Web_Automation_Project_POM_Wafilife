package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {
    HomePage homePage=new HomePage();
    @Test
    public void testHomePageUrl(){
        getDriver().get(homePage.baseUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.wafilife.com/");
        Assert.assertEquals(getDriver().getTitle(),"Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife");
        homePage.clickOnElement(homePage.myAccount);
        homePage.addScreenshotToReport("After entering to the registration or log in page");

    }
}
