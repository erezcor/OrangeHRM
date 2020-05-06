package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class SearchLocation extends BaseTest {
    Location location = Location.generateLocation().build();

    @Test
    public void searchLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, location);

        LocationsPage locationsPage = new LocationsPage(driver);
        locationsPage.searchLocation(location);

        assertThat(locationsPage.getLocationNameColumnFromTable(), everyItem(containsString(location.getName())));
    }
}
