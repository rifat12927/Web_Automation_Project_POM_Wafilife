package testcases;

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
        authorPage.clickOnElement(authorPage.youssufAli);
        youssufAliPage.clickOnElement(youssufAliPage.product);
        productPage.clickOnElement(productPage.orderBtn);
        productPage.clickOnElement(productPage.checkoutBtn);
       // checkoutPage.selectWithVisibleText(checkoutPage.zilla,"Dhaka");
        checkoutPage.selectWithVisibleText(checkoutPage.area, "কাকরাইল");
        checkoutPage.inputElement(checkoutPage.addressField, "12/c road");
        checkoutPage.scrollToElement(checkoutPage.finalOrderBtn);
        checkoutPage.clickOnElement(homePage.myAccount);
        registerAndLogInPage.clickOnElement(registerAndLogInPage.logOutBtn);
    }

}
