package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.NO_RECORDS_FOUND_IN_SEARCH;
import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NonExistLocationSearchTest extends BaseTest {
    Location locationForFillingTable = generateLocation().build();
    Location locationForSearch = generateLocation().build();

    @Test
    public void invalidSearchTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationForFillingTable);

        LocationsPage locationsPage = new LocationsPage(driver);
        locationsPage.searchLocation(locationForSearch);

        assertThat(locationsPage.getNoRecordsFoundErrorText(), is(NO_RECORDS_FOUND_IN_SEARCH));
    }
}
