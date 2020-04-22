package Tests.UnfinishedTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.CONST.LOCATION_COUNTRY;
import static Constants.CONST.LOCATION_NAME;
import static Constants.SuccessMessages.*;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteLocationTest extends BaseTest {
    String locationName = LOCATION_NAME;
    Country locationCountry = LOCATION_COUNTRY;
    String LOCATION_DELETE_SUCCESS_MESSAGE = DELETE_SUCESS_MESSAGE;

    @Test
    public void deleteLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationName, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);

        locationsPage.clickOnLocationCheckboxOf(locationName);
        locationsPage.deleteLocation();

        assertThat(locationsPage.getSuccessMessageText(), is(LOCATION_DELETE_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationName)));
    }
}
