package driverManager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;
    public abstract void createDriver();
    public void quitDriver(){
        if(driver != null)
        driver.quit();
    }
    public WebDriver getDriver(){
        if(driver == null)createDriver();
        return driver;
    }
}
