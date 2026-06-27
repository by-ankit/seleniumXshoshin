import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JavaScriptAlert_Question3 extends BaseClass {
    JavaScriptAlertPage javaScriptAlertPage;

    @BeforeMethod
    public void objectCreation() {
        javaScriptAlertPage = new JavaScriptAlertPage(driver);
    }

    @Test
    public void verifyingJavaScriptAlert() {
        javaScriptAlertPage.simpleAlert();
        javaScriptAlertPage.confirmAlert();
    }
}
