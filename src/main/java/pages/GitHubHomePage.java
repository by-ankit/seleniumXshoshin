package pages;

import actiondriver.ActionDriver;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubHomePage extends ActionDriver{

    //private ActionDriver actionDriver;
    WebDriver driver;

    public GitHubHomePage(WebDriver driver) {
        super(driver);
        //this.actionDriver=new ActionDriver(driver);
    }

    /**
     * Locators
     */
    private By signUpButton = By.cssSelector(".HeaderMenu-link--sign-up");
    private By signUpEmail = By.cssSelector("#email");
    private By signUpPassword = By.cssSelector("#password");
    private By signUpUsername = By.cssSelector("#login");
    private By country = By.cssSelector("#country-dropdown-panel-button");
    private By countryFiled = By.cssSelector("#country-dropdown-panel-filter");
    private By countryDropdown = By.xpath("//button[@data-value='IN']");
    private By createAccountButton = By.xpath("//span[contains(text(),'Create account')]");
    private By signInButton = By.xpath("//a[text()='Sign in →']");
    private By signInUsername = By.cssSelector("#login_field");
    private By signInPassword = By.cssSelector("#password");
    private By signButton = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//div[contains(text(),'Incorrect username or password.')]");

    public void getPageTitle() {
        String title = getTitle();
        System.out.println("Title of the HomePage ----> " + title);
    }

    public void signUp() {
        clickButton(signUpButton);
    }

    public void signUpPageForm() {
        enterText(signUpEmail, BaseClass.prop.getProperty("email"));
        enterText(signUpPassword,BaseClass.prop.getProperty("password"));
        enterText(signUpUsername,BaseClass.prop.getProperty("username"));
        clickButton(country);
        enterText(countryFiled,BaseClass.prop.getProperty("country"));
        clickButton(countryDropdown);
        clickButton(createAccountButton);
    }
    public void signInPageForm() {
        clickButton(signInButton);
        enterText(signInUsername,BaseClass.prop.getProperty("email"));
        enterText(signInPassword,BaseClass.prop.getProperty("password"));
        clickButton(signButton);
        String text = extractText(errorMessage);
        System.out.println(text);
    }
}
