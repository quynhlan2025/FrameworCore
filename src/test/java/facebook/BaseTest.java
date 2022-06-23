package facebook;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static com.sun.jna.Platform.isMac;
import static com.sun.jna.Platform.isSolaris;


public class BaseTest {

    public static WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void initTest(String browser, String url) {
       // driver = getBrowserDriver(browser, url);
        driver =getBrowserDriverWThread(browser, url);
        System.out.println("Threadid= "+ Thread.currentThread().getId()+ "with browser :"+ browser);
        System.out.println("Threadid= "+ Thread.currentThread().getId()+ "with driver :"+ driver);
    }

    Log log;

    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }
//
//    public void beforeSuite() {
//        String browser = "chrome";
//        String url = "https://www.facebook.com/";
//
//        System.out.println(" @BeforeClass : BaseTest");
//        if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().cachePath("driver").setup();
//            driver = new FirefoxDriver();
//
//        }
//
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().cachePath("driver").setup();
//            driver = new ChromeDriver();
//
//        } else if (browser.equalsIgnoreCase("chromeheadless")) {
//            WebDriverManager.chromedriver().cachePath("driver").setup();
//            ChromeOptions option = new ChromeOptions();
//            driver = new ChromeDriver(option);
//
//        } else if (browser.equalsIgnoreCase("firefoxheadless")) {
//            WebDriverManager.chromedriver().cachePath("driver").setup();
//            ChromeOptions option = new ChromeOptions();
//            driver = new ChromeDriver(option);
//
//        }
//        driver.get(url);
//        driver.manage().window().maximize();
//    }
//
    public String getDirectorySlash(String folderName) {
        if (isMac() || isSolaris()) {
            folderName = "/" + folderName + "/";
        }

        return folderName;
    }

    public WebDriver getBrowserDriver(String browser, String appUrl) {

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().cachePath("driver").setup();
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("chromeheadless")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            ChromeOptions option = new ChromeOptions();
            driver = new ChromeDriver(option);

        } else if (browser.equalsIgnoreCase("firefoxheadless")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            ChromeOptions option = new ChromeOptions();
            driver = new ChromeDriver(option);

        }

        driver.get(appUrl);
        driver.manage().window().maximize();
        return this.driver;
    }
    private static ThreadLocal<WebDriver> tDriver= new ThreadLocal<WebDriver>();
    public WebDriver getBrowserDriverWThread(String browser, String appUrl) {

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().cachePath("driver").setup();
            tDriver.set( new FirefoxDriver());
        }
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            tDriver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("chromeheadless")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            ChromeOptions option = new ChromeOptions();
            tDriver.set(new ChromeDriver(option));

        } else if (browser.equalsIgnoreCase("firefoxheadless")) {
            WebDriverManager.chromedriver().cachePath("driver").setup();
            ChromeOptions option = new ChromeOptions();
            tDriver.set(new ChromeDriver(option));
        }

        tDriver.get().get(appUrl);
        tDriver.get().manage().window().maximize();
        return  tDriver.get();
    }
//
//    public WebDriver getDriver() {
//        return this.driver;
//    }
//
//    public String getRandomEmail() {
//
//        return "quynhlan" + new Random().nextInt() + "@gmail.com";
//    }
//
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            closeBrowserAndDriver();
          // removeDriverWThread();
            System.out.println("Threadid= "+ Thread.currentThread().getId()+  "Close with driver :"+ driver);
        }

    }
    protected void removeDriverWThread(){
        tDriver.get().quit();
        tDriver.remove();
    }

    protected void closeBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
