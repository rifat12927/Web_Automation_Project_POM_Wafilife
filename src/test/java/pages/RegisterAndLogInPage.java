package pages;

import org.openqa.selenium.By;

public class RegisterAndLogInPage extends BasePage{
    public String registerAndLogInPageUrl="https://www.wafilife.com/my-account/" ;
    public String registerAndLogInPageTittle= "আমার অ্যাকাউন্ট - Wafilife";

    public By nameField= By.xpath("//input[@id='reg_billing_first_name']");
    public By phoneNumberField= By.xpath("//input[@id='reg_billing_phone']");
    public By emailField= By.xpath("//input[@id='reg_email']");
    public By passwordField= By.xpath("//input[@id='reg_password']");
    public By confirmPasswordField=By.xpath("//input[@id='reg_confirm_password']");
    public By registerBtn=By.xpath("//input[@name='register']");
    public By usernameOrEmailFieldForLogIn= By.xpath("//input[@id='username']");
    public By passwordFieldForLogIn= By.xpath("//input[@id='password']");
    public By logInBtn= By.xpath("//input[@name='login']");
    public By success=By.xpath("//div[@id='template-wrapper']//p[2]");
    public String successMsg="From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.";
}
