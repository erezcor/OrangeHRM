package Tests.LocationTests;

import Entities.Location;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.ALREADY_EXISTS_ERROR;
import static Entities.Location.generateLocation;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocationThatAlreadyExists extends BaseTest {
    String LOCATION_ALREADY_EXISTS_ERROR = ALREADY_EXISTS_ERROR;
    int LOCATION_APPEARS_ONE_TIME_COUNT = 1;
    Location location = generateLocation().build();

    @Test
    public void addLocationThatAlreadyExists() {
        goToLocationsPage(driver);
        addNewLocation(driver, location);

        addNewLocation(driver, location);
        LocationInfoPage locationInfoPage = new LocationInfoPage(driver);
        assertThat(locationInfoPage.getErrorMessageText(), is(LOCATION_ALREADY_EXISTS_ERROR));

        LocationsPage locationsPage = locationInfoPage.clickCancelAddingLocation();
        assertThat(locationsPage.countHowManyTimesNameAppearsInTable(location), is(LOCATION_APPEARS_ONE_TIME_COUNT));
    }
}
