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
    String locationNameForAddingLocation = "Buenos Aires" + getRandomNumberAsString();
    String LocationNameForEditLocation = "Buenos Aires" + getRandomNumberAsString();
    Country locationCountry = ARGENTINA;
    String EDIT_LOCATION_SUCCESS_MESSAGE = UPDATE_SUCCESS_MESSAGE;

    @Test
    public void editLocation() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationNameForAddingLocation, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickEditLocation(locationNameForAddingLocation);
        locationInfoPage.editLocation(LocationNameForEditLocation, ARGENTINA);

        assertThat(locationsPage.getSuccessMessageText(), is(EDIT_LOCATION_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), hasItem(LocationNameForEditLocation));
        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationNameForAddingLocation)));
    }
}
