package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Constants.SuccessMessages.SAVE_SUCCESS_MESSAGE;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddLocationTest extends BaseTest {
    final String LOCATION_NAME = "Buenos Aires" + getRandomNumberAsString();
    final String SUCCESS_MESSAGE = SAVE_SUCCESS_MESSAGE;
    Country locationCountry = ARGENTINA;

    @Test
    public void addLocationTest() {
        goToLocationsPage(driver);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickAddLocation();
        locationInfoPage.addNewLocation(LOCATION_NAME, locationCountry);

        assertThat(locationsPage.getSuccessMessageText(), is(SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationNameColumnFromTable(), hasItem(LOCATION_NAME));
    }
}
