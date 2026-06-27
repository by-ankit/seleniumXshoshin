import base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import java.lang.reflect.Method;

import java.io.IOException;

public class Wikipedia_Question5 extends BaseClass {
    private WikipediaPage wikipediaPage;


    @BeforeMethod
    public void objectCreation(Method method) {
        wikipediaPage = new WikipediaPage(driver);


    }

    @Test
    public void verifyWikipedia() throws IOException {
        wikipediaPage.homePageScreenshot();
        wikipediaPage.verifyingPageSource();
    }
}
