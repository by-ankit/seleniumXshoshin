package pages;

import actiondriver.ActionDriver;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JavaScriptAlertPage extends ActionDriver {

    WebDriver driver;

    public JavaScriptAlertPage(WebDriver driver) {
        super(driver);
    }

    private By simpleAlert = By.xpath("//button[@onclick='jsAlert()']");
    private By confirmAlert = By.xpath("//button[@onclick='jsConfirm()']");
    private By cancelResultMessage = By.xpath("//p[text()='You clicked: Cancel']");

    public void simpleAlert() {
        clickButton(simpleAlert);
        String simpleAlertText = alert().getText();
        System.out.println("Simple alert message --> " + simpleAlertText);
        alert().accept();
    }

    public void confirmAlert() {
        clickButton(confirmAlert);
        String confirmAlertText = alert().getText();
        System.out.println("Confirm alert message --> " + confirmAlertText);
        alert().dismiss();
        String text = extractText(cancelResultMessage);
        Assert.assertEquals(text, BaseClass.prop.getProperty("CancelAlertMessage"));
    }

}
