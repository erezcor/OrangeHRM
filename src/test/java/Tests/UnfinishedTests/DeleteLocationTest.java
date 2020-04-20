package Tests.UnfinishedTests;

import Constants.Country;
import Pages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.LocationTableColumns.NAME;
import static Constants.SuccessMessages.*;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteLocationTest extends BaseTest {
    String locationName;
    Country locationCountry;
    String LOCATION_DELETE_SUCCESS_MESSAGE = DELETE_SUCESS_MESSAGE;

    @Test
    public void deleteLocationTest() {
        goToLocationsPage(driver);
        LocationsPage locationsPage = new LocationsPage(driver);

        locationsPage.clickOnLocationCheckboxOf(locationName);
        locationsPage.deleteLocation();

        assertThat(locationsPage.getSuccessMessageText(), is(LOCATION_DELETE_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationTable().getCellsOfColumnInString(NAME.INDEX), not(hasItem(locationName)));
    }
}
