package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Constants.Errors.ALREADY_EXISTS_ERROR;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocationThatAlreadyExists extends BaseTest {
    String locationName = "Buenos Aires" + getRandomNumberAsString();
    Country locationCountry = ARGENTINA;
    String LOCATION_ALREADY_EXISTS_ERROR = ALREADY_EXISTS_ERROR;
    int LOCATION_APPEARS_ONE_TIME_COUNT = 1;

    @Before
    public void addLocation() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationName, locationCountry);
    }

    @Test
    public void addLocationThatAlreadyExists() {
        addNewLocation(driver, locationName, locationCountry);

        LocationInfoPage locationInfoPage = new LocationInfoPage(driver);
        assertThat(locationInfoPage.getErrorMessageText(), is(LOCATION_ALREADY_EXISTS_ERROR));

        LocationsPage locationsPage = locationInfoPage.clickCancelAddingLocation();
        assertThat(locationsPage.countHowManyTimesNameAppearsInTable(locationName), is(LOCATION_APPEARS_ONE_TIME_COUNT));
    }
}
