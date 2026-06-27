import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.QuotesToScrapePage;

import java.io.IOException;

public class QuotesToScrape_Question6 extends BaseClass {
    private  QuotesToScrapePage quotesToScrapePage;

    @BeforeMethod
    public void objectCreation() {
        quotesToScrapePage = new QuotesToScrapePage(driver);
    }

    @Test()
    public void verifyQuotesToScrape() throws IOException {
        quotesToScrapePage.getAllQuotes();
    }
}
