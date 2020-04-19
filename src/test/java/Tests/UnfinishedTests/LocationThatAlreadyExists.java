package Tests.UnfinishedTests;

import Pages.HomePage;
import Pages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Constants.Errors.ALREADY_EXISTS_ERROR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocationThatAlreadyExists extends BaseTest {
    String locationName;
    String locationCountry;
    String LOCATION_ALREADY_EXISTS_ERROR = ALREADY_EXISTS_ERROR;

    @Test
    public void addLocationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLocationsPage();

        LocationsPage locationsPage = new LocationsPage(driver);
        //locationName = locationsPage.getRandomLocationNameFromTable();
        //locationsPage.addNewLocation(locationName, ARGENTINA.NAME);

        assertThat(locationsPage.getErrorMessageText(), is(LOCATION_ALREADY_EXISTS_ERROR));
    }
}
