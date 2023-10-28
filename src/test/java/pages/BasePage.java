package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Locale;

public class BasePage extends DriverSetup {
    public WebDriverWait wait;

    public WebElement getElement(By locator) {
        return waitForElementPresence(locator);
    }

    public void clickOnElement(By locator) {
        waitForElementClickable(locator);
        getElement(locator).click();
    }

    public void inputElement(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locartor) {
        return getElement(locartor).getText();
    }

    public boolean isElementVisible(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitForElementPresence(By locator) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void waitForElementClickable(By locator) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void selectWithVisibleText(By selectlocator, String visibleText) {
        Select select = new Select(getElement(selectlocator));
        select.selectByVisibleText(visibleText);
    }
    public void selectWithValue(By locator,String value){
        Select select=new Select(getElement(locator));
        select.selectByValue(value);
    }

    public void scrollToElement(By locator) {
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(getElement(locator)).build().perform();
    }

    public void hover(By locator) {
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getElement(locator)).build().perform();
    }

    public void addScreenshotToReport(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    public Faker faker = new Faker(new Locale("en-US"));

    public String randomEmail() {
        return faker.bothify("?????##@gmail.com");
    }

    public String randomPhoneNumber() {
        return faker.numerify("01#########");
    }

    public String randomFirstName() {
        return faker.name().firstName();
    }

}
