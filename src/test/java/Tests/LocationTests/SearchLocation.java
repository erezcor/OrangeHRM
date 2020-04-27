package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class SearchLocation extends BaseTest {
    String locationName = "Las Vegas" + getRandomNumberAsString();
    Country locationCountry = ARGENTINA;

    @Test
    public void searchLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationName, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);
        locationsPage.searchLocation(locationName);

        assertThat(locationsPage.getLocationNameColumnFromTable(), everyItem(containsString(locationName)));
    }
}
