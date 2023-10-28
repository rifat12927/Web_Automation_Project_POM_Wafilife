package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterAndLogInPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestRegisterAndLogInPage extends DriverSetup {
    HomePage homePage=new HomePage();
    RegisterAndLogInPage registerAndLogInPage=new RegisterAndLogInPage();
    @BeforeMethod
    public void navigateToLogInPage(){
        getDriver().get(registerAndLogInPage.baseUrl);
    }
    @Test
    public void testRegister(){
        homePage.clickOnElement(homePage.myAccount);
        registerAndLogInPage.inputElement(registerAndLogInPage.nameField, registerAndLogInPage.randomFirstName());
        registerAndLogInPage.inputElement(registerAndLogInPage.phoneNumberField,registerAndLogInPage.randomPhoneNumber());
        registerAndLogInPage.inputElement(registerAndLogInPage.emailField, registerAndLogInPage.randomEmail());
        registerAndLogInPage.inputElement(registerAndLogInPage.passwordField,"12345678");
        registerAndLogInPage.inputElement(registerAndLogInPage.confirmPasswordField,"12345678");
        registerAndLogInPage.clickOnElement(registerAndLogInPage.registerBtn);
        Assert.assertEquals(registerAndLogInPage.getElementText(registerAndLogInPage.success),registerAndLogInPage.successMsg);
        Assert.assertEquals(getDriver().getTitle(),registerAndLogInPage.pageTittle);
        Assert.assertTrue(registerAndLogInPage.isElementVisible(registerAndLogInPage.success));
    }
    @Test
    public void testLogInWithValidData(){
        registerAndLogInPage.inputElement(registerAndLogInPage.usernameOrEmailFieldForLogIn,"rif420");
        registerAndLogInPage.inputElement(registerAndLogInPage.passwordFieldForLogIn,"12345678");
        registerAndLogInPage.clickOnElement(registerAndLogInPage.logInBtn);
        Assert.assertEquals(registerAndLogInPage.getElementText(registerAndLogInPage.success),registerAndLogInPage.successMsg);
        Assert.assertEquals(getDriver().getTitle(),registerAndLogInPage.pageTittle);
        Assert.assertTrue(registerAndLogInPage.isElementVisible(registerAndLogInPage.success));
    }
    @Test(dataProvider = "invaliddata",dataProviderClass = DataSet.class)
    public void testLogInWithInvalidData(String username,String password,String errorMsg){
        registerAndLogInPage.inputElement(registerAndLogInPage.usernameOrEmailFieldForLogIn,username);
        registerAndLogInPage.inputElement(registerAndLogInPage.passwordFieldForLogIn,password);
        registerAndLogInPage.clickOnElement(registerAndLogInPage.logInBtn);
        Assert.assertEquals(registerAndLogInPage.getElementText(registerAndLogInPage.error),errorMsg);
    }

}
