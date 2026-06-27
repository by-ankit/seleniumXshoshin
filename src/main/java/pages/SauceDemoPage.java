package pages;

import actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoPage {
    private WebDriver webDriver;
    private ActionDriver actionDriver;

    public SauceDemoPage(WebDriver driver) {
        this.actionDriver = new ActionDriver(driver);
    }

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    private By productsTitle = By.className("title");

    public void login(String username,String password) {
        actionDriver.clickButton(usernameInput);
        actionDriver.enterText(usernameInput,username);
        actionDriver.clickButton(passwordInput);
        actionDriver.enterText(passwordInput,password);
        actionDriver.clickButton(loginButton);
    }

    public String getErrorMessage() {
        return actionDriver.extractText(errorMessage);
    }

    public String getProductTitle() {
        return actionDriver.extractText(productsTitle);
    }

}
