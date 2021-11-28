package pages.itemDetailPage;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtil;

import java.util.Locale;

import static pages.itemDetailPage.ItemDetailPageElements.*;


public class ItemDetailPage extends BasePage {

    LogUtil logger = new LogUtil(this.getClass());

    public ItemDetailPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    public ItemDetailPage checkSearchedKeywordMatchesWithProduct(String searchKeyword){
        logger.info("Arattığınız kelime ile eşleyen ürün kontrol ediliyor...");
        String elementText = readText(exampleItemDetailText);
        logger.info("Aranan kelime : " + searchKeyword + " \n Bulunan Ürün : " + elementText);
        Assert.assertTrue("Bulunan ürün aranan kelimeyi içermiyor",elementText.toLowerCase(Locale.ROOT).contains(searchKeyword));
        return this;
    }
    protected void clickWithJavascript(By elementBy){
        logger.info("Arama butonuna tıklanıyor...");
        WebElement element = driver.findElement(elementBy);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }



}
