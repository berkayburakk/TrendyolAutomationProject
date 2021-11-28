package pages.homePage;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.itemsPage.ItemsPage;
import pages.homePage.HomePageElements;
import utils.LogUtil;


import java.util.List;

import static pages.homePage.HomePageElements.*;

import static pages.itemsPage.ItemsPageElements.searchBox;
import static pages.itemsPage.ItemsPageElements.searchButton;

public class HomePage extends BasePage {
    LogUtil logger = new LogUtil(this.getClass());

    public HomePage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    public HomePage closeModal(){
        logger.info("Pop-up kapatılıyor...");

        click(HomePageElements.modalCloseBtn);
        return this;
    }
    public HomePage isSearchBoxExist(){
        Assert.assertTrue(isElementVisible(searchBox));
        return this;
    }
    public HomePage isSearchButtonExist(){
        Assert.assertTrue(isElementVisible(searchButton));
        return this;
    }

    public HomePage checkPlaceHolder(String placeHolderKey){

        WebElement element = driver.findElement(searchBox);
        String placeHolder = element.getAttribute("placeholder");
        Assert.assertEquals(placeHolderKey,placeHolder);
        return this;
    }
    public ItemsPage searchOnSearchBox(String searchElement){
        logger.info("İstenilen kelime aratılıyor...");
        writeText(HomePageElements.searchBox,searchElement);
        waitVisibility(HomePageElements.suggestionPage);
        click(HomePageElements.searchBtn);
        logger.info("İstenilen kelimeye tıklandı");
        return new ItemsPage(wait,driver);
    }
    public HomePage searchSomeKeyword(String searchElement){
        logger.info("İstenilen kelime aratılıyor...");
        writeText(HomePageElements.searchBox,searchElement);
        return this;
    }
    public HomePage waitUntilSearchBoxOpen(){
        Assert.assertTrue(isElementVisible(searchBox));
        return this;
    }

    public HomePage checkIsFilterShowsOnMenuBar(String filterName){
        List<WebElement> elements = getDriverElements(suggestionMenuList);
        traverseListOfWebElements(elements,filterName);
        return this;
    }


}
