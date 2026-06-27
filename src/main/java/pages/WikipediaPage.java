package pages;

import actiondriver.ActionDriver;
import base.BaseClass;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WikipediaPage {
    private ActionDriver actionDriver;
    WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        this.actionDriver=new ActionDriver(driver);
    }

    public void homePageScreenshot() throws IOException {
        actionDriver.takeScreenshot(BaseClass.prop.getProperty("screenshotName"));
    }
    public void verifyingPageSource() throws IOException {
        actionDriver.pageSource();
    }


}
