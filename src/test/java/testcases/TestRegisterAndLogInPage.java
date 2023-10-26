package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterAndLogInPage;
import utilities.DriverSetup;

public class TestRegisterAndLogInPage extends DriverSetup {
    HomePage homePage=new HomePage();
    RegisterAndLogInPage registerAndLogInPage=new RegisterAndLogInPage();
    @Test
    public void testRegister(){
        getDriver().get(homePage.homePageUrl);
        homePage.clickOnElement(homePage.myAccount);
        registerAndLogInPage.inputElement(registerAndLogInPage.nameField, registerAndLogInPage.randomFirstName());
        registerAndLogInPage.inputElement(registerAndLogInPage.phoneNumberField,registerAndLogInPage.randomPhoneNumber());
        registerAndLogInPage.inputElement(registerAndLogInPage.emailField, registerAndLogInPage.randomEmail());
        registerAndLogInPage.inputElement(registerAndLogInPage.passwordField,"12345678");
        registerAndLogInPage.inputElement(registerAndLogInPage.confirmPasswordField,"12345678");
        registerAndLogInPage.clickOnElement(registerAndLogInPage.registerBtn);
        Assert.assertEquals(registerAndLogInPage.getElementText(registerAndLogInPage.success),registerAndLogInPage.successMsg);
        Assert.assertEquals(getDriver().getTitle(),registerAndLogInPage.registerAndLogInPageTittle);
        Assert.assertTrue(registerAndLogInPage.isElementVisible(registerAndLogInPage.success));
    }
    @Test
    public void testLogInWithValidData(){
        getDriver().get(registerAndLogInPage.registerAndLogInPageUrl);
        registerAndLogInPage.inputElement(registerAndLogInPage.usernameOrEmailFieldForLogIn,"rif420");
        registerAndLogInPage.inputElement(registerAndLogInPage.passwordFieldForLogIn,"12345678");
        registerAndLogInPage.clickOnElement(registerAndLogInPage.logInBtn);
        Assert.assertEquals(registerAndLogInPage.getElementText(registerAndLogInPage.success),registerAndLogInPage.successMsg);
        Assert.assertEquals(getDriver().getTitle(),registerAndLogInPage.registerAndLogInPageTittle);
        Assert.assertTrue(registerAndLogInPage.isElementVisible(registerAndLogInPage.success));
    }
}
