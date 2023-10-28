package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{
    public String baseUrl="https://www.wafilife.com/checkout/";
    public String pageTittle="Checkout - Wafilife";
    public By zilla =By.xpath("//span[@id='select2-billing_state-container']");
    public By area=By.xpath("//select[@id='billing_area']");
    public By addressField=By.xpath("//textarea[@id='billing_address_1']");
    public By finalOrderBtn=By.xpath("//button[@id='place_order']");
}
