package actiondriver;

import base.BaseClass;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ActionDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(BaseClass.prop.getProperty("explicitWait"))));
    }

    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickButton(By by) {
        try {
            waitForElementToBeClickable(by);
            driver.findElement(by).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterText(By by, String value) {
        try {
            waitForElementToBeVisible(by);
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String extractText(By by) {
        try {
            waitForElementToBeVisible(by);
            String text = driver.findElement(by).getText();
            return text;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementToBeVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementToBeClickable(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void isDisplayed(By by) {
        try {
            waitForElementToBeVisible(by);
            driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<WebElement> getAllRowsData(By by) {
        return  driver.findElements(by);
    }

    public void verifyNumericPopulation(String value) {
        boolean clean = value.replaceAll(",","").matches("[0-9]+");
        Assert.assertTrue(clean);
    }

    public Alert alert() {
        return driver.switchTo().alert();
    }

    public void takeScreenshot(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File fs = ts.getScreenshotAs(OutputType.FILE);
        File filePath = new File(System.getProperty("user.dir") +"/src/test/resources/screenshot/" + screenshotName+System.currentTimeMillis()+".png");
        FileUtils.copyFile(fs,filePath);
    }

    public void pageSource() throws IOException {
        String pageSource = driver.getPageSource();
        File fs = new File(System.getProperty("user.dir") + "/src/test/resources/"+System.currentTimeMillis()+".html");
        FileWriter fw = new FileWriter(fs);
        fw.write(pageSource);
        fw.close();
    }
}
