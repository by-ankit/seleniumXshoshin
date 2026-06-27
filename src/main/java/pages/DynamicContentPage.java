package pages;

import actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage {
    private ActionDriver actionDriver;
    WebDriver driver;
    public DynamicContentPage(WebDriver driver) {
        this.actionDriver = new ActionDriver(driver);
    }

    private By contentRows = By.xpath("//div[@class='large-10 columns']");

    public void dynamicContentCheck() {
        actionDriver.waitForElementToBeVisible(contentRows);
        List<WebElement> allContent = actionDriver.getAllRowsData(contentRows);

        for(int i=0;i<allContent.size();i++) {
            System.out.println("Content - " + (i+1) + " --> ");
            WebElement rows = allContent.get(i);
            String content = rows.getText();
            System.out.println("Content for the dynamic page ---> " + content);
        }
    }

}
