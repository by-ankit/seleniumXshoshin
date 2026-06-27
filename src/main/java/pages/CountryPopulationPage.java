package pages;

import actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryPopulationPage extends ActionDriver {

    WebDriver driver;

    public CountryPopulationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Locators
     */

    private By allRows = By.xpath("//table//tbody//tr");
    private By countryColumn = By.xpath(".//td[2]");
    private By populationColumn =By.xpath(".//td[3]");

    public  void getTopFiveRowData() {
        List<WebElement> rows = getAllRowsData(allRows);

        System.out.println("Top five countries and their population ");

        for(int i=0;i<5;i++) {
            WebElement row = rows.get(i);
            String country = row.findElement(countryColumn).getText();
            String population = row.findElement(populationColumn).getText();
            verifyNumericPopulation(population);

            System.out.println("country ----> " + country + " and their population ----> " + population );
        }





    }
}
