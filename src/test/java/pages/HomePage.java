package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String baseUrl ="https://www.wafilife.com/";
    public String pageTittle ="Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By myAccount=By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public By author=By.xpath("//span[@class='menu-label-level-0'][contains(text(),'লেখক')]");


}
