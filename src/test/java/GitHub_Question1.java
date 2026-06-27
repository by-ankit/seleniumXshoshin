import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GitHubHomePage;

public class GitHub_Question1 extends BaseClass {

    private GitHubHomePage gitHubHomePage;

    @BeforeMethod
    public void objectCreation() {
        gitHubHomePage = new GitHubHomePage(driver);
    }

    @Test
    public void VerifyingGitHub() {
        gitHubHomePage.getPageTitle();
        gitHubHomePage.signUp();
        gitHubHomePage.getPageTitle();
        gitHubHomePage.signUpPageForm();
        gitHubHomePage.signInPageForm();
    }

}
