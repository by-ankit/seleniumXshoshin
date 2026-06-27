package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;




    @BeforeSuite
    public void loadConfig() throws IOException {

        prop = new Properties();
        FileInputStream fs = new FileInputStream("src/main/resources/config.properties");
        prop.load(fs);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/resources/Reports/report.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }
    @Parameters("urlKey")
    @BeforeMethod
    public void setUp(@Optional("JavaScriptAlerts_url") String urlKey, ITestResult result) {
        String browser = prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else {
            throw new IllegalArgumentException("Browser not supported. " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(BaseClass.prop.getProperty("implicitWait"))));
        driver.manage().window().maximize();
        /**
         * Url for Question -1
         */
        // driver.get(prop.getProperty("GitHub_url"));

        /**
         * Url for Question -2
         */

        String url = prop.getProperty(urlKey);
        driver.get(url);

        //driver.get(prop.getProperty("QuotesToScrape_url"));
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @AfterSuite
    public void tearDownSuite() {
        extentReports.flush();
    }


}
