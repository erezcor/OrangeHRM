package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.SuccessMessages.DELETE_SUCESS_MESSAGE;
import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteLocationTest extends BaseTest {
    final String LOCATION_DELETE_SUCCESS_MESSAGE = DELETE_SUCESS_MESSAGE;

    Location locationForFillingTable = generateLocation().build();
    Location locationForDeletingLocation = generateLocation().build();

    @Test
    public void deleteLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationForFillingTable);

        addNewLocation(driver, locationForDeletingLocation);
        LocationsPage locationsPage = new LocationsPage(driver);
        locationsPage.clickOnLocationCheckboxOf(locationForDeletingLocation);
        locationsPage.deleteLocation();

        assertThat(locationsPage.getSuccessMessageText(), is(LOCATION_DELETE_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationForDeletingLocation.getName())));
    }
}