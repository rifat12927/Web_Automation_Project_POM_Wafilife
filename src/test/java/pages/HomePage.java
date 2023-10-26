package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String homePageUrl="https://www.wafilife.com/";
    public String homePageTittle="Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By myAccount=By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public By author=By.xpath("//a[contains(text(),'লেখক')]");

}
