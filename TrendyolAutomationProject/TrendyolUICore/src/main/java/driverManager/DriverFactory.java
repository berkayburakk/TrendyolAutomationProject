package driverManager;

public class DriverFactory {
    public static DriverManager getManager(DriverTypes type) {
        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                //  TODO
                break;
            case IE:
                //TODO
                break;
            case SAFARI:
                // TODO
                break;
            default:
                //   throw Unsupported Driver Type Exception
                break;
        }
        return driverManager;
    }

}
