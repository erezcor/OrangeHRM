package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.NO_RECORDS_FOUND_IN_SEARCH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static Constants.Country.EGYPT;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;

public class NonExistLocationSearchTest extends BaseTest {
    String locationNameForFillingTable = "Las Vegas" + getRandomNumberAsString();
    Country locationCountryForFillingTable = EGYPT;
    String locationNameForSearch = "Italy" + getRandomNumberAsString();

    @Test
    public void invalidSearchTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationNameForFillingTable, locationCountryForFillingTable);

        LocationsPage locationsPage = new LocationsPage(driver);
        locationsPage.searchLocation(locationNameForSearch);

        assertThat(locationsPage.getNoRecordsFoundErrorText(), is(NO_RECORDS_FOUND_IN_SEARCH));
    }
}
