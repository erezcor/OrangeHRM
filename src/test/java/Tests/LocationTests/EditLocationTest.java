package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.SuccessMessages.UPDATE_SUCCESS_MESSAGE;
import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditLocationTest extends BaseTest {
    String EDIT_LOCATION_SUCCESS_MESSAGE = UPDATE_SUCCESS_MESSAGE;

    Location locationDetailsForAddingLocation = generateLocation().build();
    Location locationDetailsForEditingLocation = generateLocation().build();

    @Test
    public void editLocation() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationDetailsForAddingLocation);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickEditLocation(locationDetailsForAddingLocation);
        locationInfoPage.editLocation(locationDetailsForEditingLocation);

        assertThat(locationsPage.getSuccessMessageText(), is(EDIT_LOCATION_SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), hasItem(locationDetailsForEditingLocation.getName()));
        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationDetailsForAddingLocation.getName())));
    }
}
