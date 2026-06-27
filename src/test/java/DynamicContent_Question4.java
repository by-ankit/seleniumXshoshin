import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicContentPage;

public class DynamicContent_Question4 extends BaseClass {
    private DynamicContentPage dynamicContentPage;

    @BeforeMethod
    public void objectCreation() {
        dynamicContentPage = new DynamicContentPage(driver);

    }

    @Test
    public void dynamicContent() {
        dynamicContentPage.dynamicContentCheck();

    }
}
