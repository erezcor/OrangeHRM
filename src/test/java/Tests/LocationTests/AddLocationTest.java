package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.SuccessMessages.SAVE_SUCCESS_MESSAGE;
import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddLocationTest extends BaseTest {
    final String SUCCESS_MESSAGE = SAVE_SUCCESS_MESSAGE;
    Location locationToAdd = generateLocation().build();

    @Test
    public void addLocationTest() {
        goToLocationsPage(driver);

        addNewLocation(driver, locationToAdd);

        LocationsPage locationsPage = new LocationsPage(driver);
        assertThat(locationsPage.getSuccessMessageText(), is(SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), hasItem(locationToAdd.getName()));
    }
}
