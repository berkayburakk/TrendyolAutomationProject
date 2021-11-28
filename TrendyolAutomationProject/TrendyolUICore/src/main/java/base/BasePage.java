package base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BasePage {
   protected WebDriverWait wait;
   protected WebDriver driver;
    LogUtil logger = new LogUtil(this.getClass());

    public BasePage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }
    protected boolean isElementVisible(By element){
        boolean result = true;
        try {
            driver.findElement(element).isDisplayed();
        }catch (Exception e){
            result = false;
        }
        return result;
    }
    protected void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    protected void clickWithJavascript(By elementBy){
        WebElement element = driver.findElement(elementBy);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }


    protected void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    protected void isNotVisible(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }
    public void switchWindow(By elementBy,String pageNumber){
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(Keys.CONTROL+pageNumber);
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        System.out.print(tabs);
    }

    public void closePopUpIfExist(By elementBy,By popupHeader){
        if(isElementVisible(popupHeader)){
            new Actions(driver).moveToElement(driver.findElement(elementBy)).moveByOffset(300, 300).click().perform();
            logger.info("Pop-up kapatılıyor...");
        }
    }

    public List<WebElement> getDriverElements(By elementBy){
        logger.info("Sayfadaki elementler bulunuyor...");
        return driver.findElements(elementBy);
    }

    public boolean traverseListOfWebElements(List<WebElement> webElementList,String keyword){
        for (var element : webElementList) {
            if(element.getText().contains(keyword)){
                logger.info(keyword + " başarıyla bulundu...");
                return true;
            }
        }
        logger.info(keyword + " bulunamadı...");
        return false;

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Maximum sayi minimum sayidan buyuk olmali.");
        }

        Random r = new Random();
        return r.nextInt((max - min) ) + min;
    }

    public String getRandomKey(String key,HashMap<String,ArrayList<String>> myMap){
        int mapKeySize = myMap.get(key).size();
        return myMap.get(key).get(getRandomNumberInRange(0,mapKeySize));
    }
}
