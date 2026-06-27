import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CountryPopulationPage;

public class CountryPopulation_Question2 extends BaseClass {
    private CountryPopulationPage countryPopulationPage;

    @BeforeMethod
    public void objectCreation() {
        countryPopulationPage = new CountryPopulationPage(driver);
    }

    @Test
    public void getTopPopulationCountry() {
        countryPopulationPage.getTopFiveRowData();
    }
}
