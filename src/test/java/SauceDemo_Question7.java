import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SauceDemoPage;

public class SauceDemo_Question7 extends BaseClass {
    private SauceDemoPage sauceDemoPage;

    @BeforeMethod
    public void objectCreation() {
        sauceDemoPage = new SauceDemoPage(driver);

    }

    @Test
    public void verifySauceDemoWithValidInput() {
        sauceDemoPage.login(BaseClass.prop.getProperty("validUsername"),BaseClass.prop.getProperty("validPassword"));
        String title = sauceDemoPage.getProductTitle();
        Assert.assertEquals(title,"Products");
    }

    @Test
    public void verifySauceDemoWithInValidInput() {
        sauceDemoPage.login(BaseClass.prop.getProperty("invalidUsername"),BaseClass.prop.getProperty("invalidPassword"));
        String errorMessage = sauceDemoPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"),"Invalid login error message is not displayed as expected.");
    }

}
