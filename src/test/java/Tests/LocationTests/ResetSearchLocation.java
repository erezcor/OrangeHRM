package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import java.util.List;

import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ResetSearchLocation extends BaseTest {
    Location location = generateLocation().build();

    @Test
    public void resetLocationSearchTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, location);

        LocationsPage locationsPage = new LocationsPage(driver);
        List<String> locationNamesInTableBeforeSearch = locationsPage.getLocationNameColumnFromTable();

        locationsPage.searchLocation(location);
        locationsPage.resetLocationSearch();

        assertThat(locationsPage.getLocationNameColumnFromTable(), is(locationNamesInTableBeforeSearch));
    }
}
