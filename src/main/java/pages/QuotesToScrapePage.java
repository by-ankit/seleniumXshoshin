package pages;

import actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class QuotesToScrapePage {
    WebDriver driver;
    private ActionDriver actionDriver;
    public QuotesToScrapePage(WebDriver driver) {
        this.actionDriver=new ActionDriver(driver);
    }

    private By allQuotes = By.xpath("//div[@class='quote']");

    public void getAllQuotes() throws IOException {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/quotes.csv";
        List<WebElement> quotes =  actionDriver.getAllRowsData(allQuotes);
        FileWriter fw = new FileWriter(filePath);
        fw.write("Quote,Author\n");

        for( WebElement q : quotes) {
            String quoteText = q.findElement(By.className("text")).getText();
            String author = q.findElement(By.className("author")).getText();
            String quote = quoteText.replace(","," ");
            fw.write("\"" + quote + "\"," + author + "\n");
        }
        fw.close();
    }
}
