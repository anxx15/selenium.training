//package utils;
//
//import java.awt.AWTException;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.text.ParseException;
//import java.util.Date;
//import java.util.logging.Level;
//
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class WebdriverHelper {
//	public static RemoteWebDriver REAL_DRIVER = null;
//	private static final Thread CLOSE_THREAD = new Thread() {  
//		
//	@Override
//	public void run() {  
//	REAL_DRIVER.quit();                        
//	}
//	
//	private static String BROWSER;
//    private static String DRIVER_PATH;
//    
//    static {
//        BROWSER = ConfigProps.getProp("browser");
//        DRIVER_ROOT_DIR = ConfigProps.getProp("driver.root.dir");
//
//        if (!DRIVER_ROOT_DIR.equals("DEFAULT_PATH")) {
//            System.setProperty("webdriver.chrome.driver", getDriverPath());
//            System.setProperty("webdriver.ie.driver", getDriverPath());                 
//        }
//      
//        try {
//            switch (BROWSER.toLowerCase()) {
//                case ("chrome"):
//                    startChromeDriver();
//                    break;
//                case ("iexplore"):
//                    startIEDriver();
//                    break;
//                
//                default:
//                    throw new IllegalArgumentException("Browser " + BROWSER + " or Platform "
//                            + PLATFORM + " type not supported");
//            }
//
//        } catch (IllegalStateException e) {
//        	e.getStackTrace();
//        }
//        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
//    }
//
//    private WebDriverHelper() {
//        super(REAL_DRIVER);
//    }
//
// 
//    private static String getDriverPath() {
//        DRIVER_PATH = ConfigProps.getProp("driver.root.dir");
//        return DRIVER_PATH;
//    }
//
//    private static void startIEDriver() {
//        DesiredCapabilities capabilities = getInternetExploreDesiredCapabilities();
//        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty()) {
//            REAL_DRIVER = new InternetExplorerDriver(capabilities);
//        }else {
//            try {
//                REAL_DRIVER = getRemoteWebDriver(capabilities);
//            } catch (MalformedURLException e) {
//                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
//            }
//        }
//        REAL_DRIVER.manage().window().setSize(BROWSER_WINDOW_SIZE);
//    }
//
//    private static WebDriver startChromeDriver() {
//        DesiredCapabilities capabilities = getChromeDesiredCapabilities();
//
//        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty()) {
//            REAL_DRIVER = new ChromeDriver(
//                    ChromeDriverService.createDefaultService(), capabilities);
//        }else {
//            try {
//                REAL_DRIVER = getRemoteWebDriver(capabilities);
//            } catch (MalformedURLException e) {
//                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
//            }
//        }
//        //REAL_DRIVER.manage().window().setSize(BROWSER_WINDOW_SIZE);
//        REAL_DRIVER.manage().deleteAllCookies();
//        REAL_DRIVER.manage().window().maximize();
//        return REAL_DRIVER;
//    }
//	
//	
//    private static DesiredCapabilities getChromeDesiredCapabilities() {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
//        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.DISMISS);
//        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE);
//   
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.addArguments("--disable-web-security");
//        chromeOptions.addArguments("disable-infobars");
//        chromeOptions.addArguments("--test-type");
//        capabilities.setCapability("chrome.verbose", false);
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        return capabilities;
//    }
//	
//	private static DesiredCapabilities getInternetExploreDesiredCapabilities() {
//        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        capabilities.setVersion("11");
//        return capabilities;
//	}
//	
//	private static DesiredCapabilities getAppiumDesiredCapabilities() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device", "Android");
////        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
////        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
////        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//        return capabilities;
//    }
