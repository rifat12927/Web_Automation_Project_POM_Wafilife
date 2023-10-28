package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String baseUrl="https://www.wafilife.com/shop/books/fish-water-and-people-reflections-on-inland-openwater-fisheries-resources-of-bangladesh";
    public String pageTittle="Fish, Water and People Reflections on Inland Openwater Fisheries Resources of Bangladesh - M. Youssouf Ali | ফিশ, ওয়াটার এন্ড পিপল রিফ্লেকশন অন ইনল্যান্ড ওপেনওয়াটার ফিশারিজ রিসোর্সেস অব বাংলাদেশ | Wafilife";
    public By orderBtn=By.xpath("//div[@class='body-wrapper']//button[2]");
    public By checkoutBtn=By.xpath("//a[@title='checkout']");
}
