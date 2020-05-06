package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Entities.Location.*;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class CancelAddingLocation extends BaseTest {
    Location locationForFillingTable = generateLocation().build();
    Location locationForCancelAddingLocation = generateLocation().build();

    @Test
    public void cancelAddingLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationForFillingTable);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickAddLocation();

        locationInfoPage.insertLocationDetails(locationForCancelAddingLocation);
        locationInfoPage.clickCancelAddingLocation();

        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationForCancelAddingLocation.getName())));
    }
}
