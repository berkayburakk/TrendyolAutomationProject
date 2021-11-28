package pages.itemsPage;

import org.openqa.selenium.By;

public class ItemsPageElements {
    protected static By productList = By.xpath("(//span[contains(@class,'prdct-desc-cntnr-name')])[1]");
    protected static By bodyOfPage = By.cssSelector("body");
    protected static By suggestionItem = By.className("suggestion");
    protected static By clearBtn = By.className("clear");
    public static By searchBox = By.className("search-box");
    protected static By suggestionBox = By.className("suggestion-result");
    protected static By colorPopupHeader = By.className("popup-heading");
    protected static By searchProductWrapper = By.className("srch-prdcts-cntnr");
    public static By searchButton = By.className("search-icon");


}
