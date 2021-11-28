package UITestScenarios;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.Test;
import pages.homePage.HomePage;
import utils.DataProvider;

import java.util.*;

import static utils.DataProvider.getData;

public class TestCasesForSearchUI extends BaseTest {

    Object[][] map =getData();
    HashMap<String,ArrayList<String>> myKeywordList = (HashMap<String, ArrayList<String>>) map[0][0];

    @Test
    @Description("Purpose of this scenario is: Check is searchbox is exist on homepage screen.")
    public void checkIsSearchBoxExist(){
        HomePage homePage = new HomePage(wait,driver);
        homePage.closeModal()
                .isSearchBoxExist();
    }

    @Test
    @Description("Purpose of this scenario is: Check is search button is exist on searchbox.")
    public void checkIsSearchButtonExistOnSearchBox(){
        HomePage homePage = new HomePage(wait,driver);
        homePage.closeModal()
                .isSearchButtonExist();
    }

    @Test
    @Description("Purpose of this scenario is: Check is placeolder exist inside the searchbox.")
    public void checkPlaceHolderExist(){
        HomePage homePage = new HomePage(wait,driver);
        homePage.closeModal()
                .checkPlaceHolder("Aradığınız ürün, kategori veya markayı yazınız");
    }

    @Test
    @Description("Purpose of this scenario is: When we type a word in the search box, it is the control of whether products related to that word come or not.")
    public void checkSearchedProductIsItVisible(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Ürün",myKeywordList);

        homePage.closeModal()
                .searchOnSearchBox(searchKeyword)
                .checkProductsWithKeyword()
                .switchSecondTab("2")
                .checkSearchedKeywordMatchesWithProduct(searchKeyword);
    }
    @Test
    @Description("Purpose of this scenario is: Checking clear button that located inside searchbox")
    public void checkClearButtonIsWorking(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Ürün",myKeywordList);

        homePage.closeModal()
                .searchOnSearchBox(searchKeyword)
                .checkSearchControlAndPopUpClose()
                .clickSearchBoxBtn()
                .clearInsideText()
                .isSuggestionBoxVisible()
                .clickClearButton()
                .isNotSuggestionBoxVisible();
    }

    @Test
    @Description("Purpose of this scenario is: Control to appear in the search box when words related to the category are searched")
    public void checkIsCategoryExistInSearchBar(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Kategori",myKeywordList);

        homePage.closeModal()
                .searchSomeKeyword(searchKeyword)
                .waitUntilSearchBoxOpen()
                .checkIsFilterShowsOnMenuBar("Kategori");
    }

    @Test
    @Description("Purpose of this scenario is: Control to appear in the search box when words related to the category are searched")
    public void checkIsSubCategoryExistInSearchBar(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Kategori",myKeywordList);

        homePage.closeModal()
                .searchSomeKeyword(searchKeyword)
                .waitUntilSearchBoxOpen()
                .checkIsFilterShowsOnMenuBar("Kategori");
    }

    @Test
    @Description("Purpose of this scenario is: Control to appear in the search box when words related to the brand are searched")
    public void checkIsBrandExistInSearchBar(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Marka",myKeywordList);

        homePage.closeModal()
                .searchSomeKeyword(searchKeyword)
                .waitUntilSearchBoxOpen()
                .checkIsFilterShowsOnMenuBar("Marka");
    }
    @Test
    @Description("Purpose of this scenario is: Control to appear in the search box when words related to the store are searched")
    public void checkIsStoreExistInSearchBar(){
        HomePage homePage = new HomePage(wait,driver);
        String searchKeyword = homePage.getRandomKey("Mağaza",myKeywordList);

        homePage.closeModal()
                .searchSomeKeyword(searchKeyword)
                .waitUntilSearchBoxOpen()
                .checkIsFilterShowsOnMenuBar("Mağaza");
    }
}
