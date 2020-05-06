package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Constants.SuccessMessages.UPDATE_SUCCESS_MESSAGE;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditLocationTest extends BaseTest {
    String locationName = "Buenos Aires" + getRandomNumberAsString();
    String newLocationName = "Buenos Aires" + getRandomNumberAsString();
    Country locationCountry = ARGENTINA;
    String EDIT_LOCATION_SUCCESS_MESSAGE = UPDATE_SUCCESS_MESSAGE;

    @Test
    public void editLocation() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationName, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickEditLocation(locationName);
        locationInfoPage.editLocation(newLocationName, ARGENTINA.NAME);

        assertThat(locationsPage.getSuccessMessageText(), is(EDIT_LOCATION_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), hasItem(newLocationName));
        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationName)));
    }
}
