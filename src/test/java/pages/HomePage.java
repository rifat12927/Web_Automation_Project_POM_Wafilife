package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String homePageUrl="https://www.wafilife.com/";
    public String homePageTittle="Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By myAccount=By.xpath("//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]");

}
