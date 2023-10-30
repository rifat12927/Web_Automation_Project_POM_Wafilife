package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class TestPurchaseBook extends DriverSetup {
    HomePage homePage = new HomePage();
    RegisterAndLogInPage registerAndLogInPage = new RegisterAndLogInPage();
    AuthorPage authorPage = new AuthorPage();
    YoussufAliPage youssufAliPage = new YoussufAliPage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeMethod
    public void navigateToHomePage() {
        getDriver().get(homePage.baseUrl);
        homePage.clickOnElement(homePage.myAccount);
        registerAndLogInPage.doLogIn("rif420", "12345678");
    }

    @Test
    public void testPuschaseProduct() {
        registerAndLogInPage.clickOnElement(homePage.author);
        authorPage.addScreenshotToReport("After entering the author page");
        Assert.assertEquals(getDriver().getCurrentUrl(),authorPage.authorPageUrl);
        Assert.assertEquals(getDriver().getTitle(),authorPage.authorPageTittle);
        authorPage.clickOnElement(authorPage.nextPageBtn);
        authorPage.back();
        Assert.assertEquals(getDriver().getCurrentUrl(),authorPage.authorPageUrl);
        authorPage.scrollToElement(authorPage.youssufAli);
        authorPage.clickOnElement(authorPage.youssufAli);
        youssufAliPage.addScreenshotToReport("After going to Youssuf Ali page");
        Assert.assertEquals(getDriver().getCurrentUrl(),youssufAliPage.baseUrl);
        Assert.assertEquals(getDriver().getTitle(),youssufAliPage.pageTittle);
        youssufAliPage.clickOnElement(youssufAliPage.product);
        productPage.addScreenshotToReport("After click on product");
        productPage.clickOnElement(productPage.orderBtn);
        productPage.addScreenshotToReport("After click on Order Button");
        productPage.clickOnElement(productPage.checkoutBtn);
        checkoutPage.addScreenshotToReport("After going to checkout page");
        Assert.assertEquals(getDriver().getCurrentUrl(),checkoutPage.baseUrl);
        Assert.assertEquals(getDriver().getTitle(),checkoutPage.pageTittle);
        checkoutPage.inputElement(checkoutPage.optionalPhoneNumber, "12345678901");
        // checkoutPage.selectWithVisibleText(checkoutPage.zilla,"Dhaka");
        try {
            checkoutPage.selectWithVisibleText(checkoutPage.area, "কাকরাইল");
        } catch (StaleElementReferenceException st) {
            checkoutPage.selectWithVisibleText(By.xpath("//select[@id='billing_area']"), "কাকরাইল");
        }

        checkoutPage.inputElement(checkoutPage.addressField, "12/c road");
        checkoutPage.addScreenshotToReport("After fill up the checkout info. form");
        checkoutPage.clickOnElement(checkoutPage.myAccount);
        registerAndLogInPage.clickOnElement(registerAndLogInPage.logOutBtn);
        registerAndLogInPage.addScreenshotToReport("After Logout");
        Assert.assertEquals(getDriver().getCurrentUrl(),registerAndLogInPage.baseUrl);
        Assert.assertEquals(getDriver().getTitle(),registerAndLogInPage.pageTittle);
    }

}
