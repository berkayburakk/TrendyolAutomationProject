package base;

import driverManager.DriverFactory;
import driverManager.DriverManager;
import driverManager.DriverTypes;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtil;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    LogUtil logger = new LogUtil(this.getClass());

    @Before
    public void startDriver(){
        DriverManager manager = DriverFactory.getManager(DriverTypes.CHROME);
         driver = manager.getDriver();
         wait = new WebDriverWait(driver,30);
         driver.get("https://www.trendyol.com");
        logger.info("https://www.trendyol.com web sitesine yonlendiriliyor.....");
    }

    @After
    public void tearDown(){
        driver.quit();
        logger.info("Driver kapatiliyor....");
    }
}
