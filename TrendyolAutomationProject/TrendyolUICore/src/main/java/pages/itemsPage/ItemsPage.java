package pages.itemsPage;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.itemDetailPage.ItemDetailPage;
import utils.LogUtil;

import static pages.itemsPage.ItemsPageElements.*;

public class ItemsPage extends BasePage {
    public ItemsPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    LogUtil logger = new LogUtil(this.getClass());

    public ItemsPage checkProductsWithKeyword(){
        logger.info("Listelenen ürün ekranında ilk ürüne tıklanıyor...");
        clickWithJavascript(productList);
        return this;
    }
        public ItemDetailPage switchSecondTab(String pageNumber){
        logger.info("Açılan yeni sekmeye geçiş yapılıyor...");
        switchWindow(ItemsPageElements.bodyOfPage,pageNumber);
        return new ItemDetailPage(wait,driver);
    }

    public ItemsPage checkSearchControlAndPopUpClose(){
        waitVisibility(searchProductWrapper);
        closePopUpIfExist(searchBox,colorPopupHeader);
        return this;
    }

    public ItemsPage clickSearchBoxBtn(){
        click(searchBox);
        return this;
    }

    public ItemsPage clearInsideText(){
        driver.findElement(searchBox).clear();
        writeText(searchBox," ");
        return this;
    }

    public ItemsPage isSuggestionBoxVisible(){
        waitVisibility(suggestionBox);
        return this;
    }

    public ItemsPage clickClearButton(){
        click(clearBtn);
        return this;
    }

    public ItemsPage isNotSuggestionBoxVisible(){
        click(searchBox);
        isNotVisible(suggestionBox);
        return this;
    }

}
