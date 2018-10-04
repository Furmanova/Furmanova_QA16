package TelRan.QA.appManadger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;

    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
        public void attach(By locator, File file) { //вложение файлов
        if(file != null){
            //click(locator);
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }

    }
    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

   /* public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }*/
}
