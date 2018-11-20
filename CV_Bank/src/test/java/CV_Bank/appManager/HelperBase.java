package CV_Bank.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    public WebDriver driver;
    public Select select;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        type(locator, text, true);
    }

    public void type(By locator, String text, Boolean clear) {
        if (text != null) {
            click(locator);
            if (clear) {
                driver.findElement(locator).clear();
            }
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}
