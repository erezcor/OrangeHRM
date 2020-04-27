package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import java.util.List;

import static Constants.Country.ARGENTINA;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResetSearchLocation extends BaseTest {
    String locationName = "Las Vegas" + getRandomNumberAsString();
    Country locationCountry = ARGENTINA;

    @Test
    public void resetLocationSearchTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationName, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);
        List<String> locationNamesInTableBeforeSearch = locationsPage.getLocationNameColumnFromTable();

        locationsPage.searchLocation(locationName);
        locationsPage.resetLocationSearch();

        assertThat(locationsPage.getLocationNameColumnFromTable(), is(locationNamesInTableBeforeSearch));
    }
}
