package Tests.UnfinishedTests;

import Pages.HomePage;
import Pages.Location.AddLocationPage;
import Pages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.ARGENTINA;
import static Constants.Errors.SAVE_SUCCESS_MESSAGE;
import static Processes.NumberUtils.getRandomNumberAsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddLocationTest extends BaseTest {
    final String LOCATION_NAME = "Buenos Aires" + getRandomNumberAsString();
    final String SUCCESS_MESSAGE = SAVE_SUCCESS_MESSAGE;
    final int LOCATION_NAME_COLUMN_INDEX = 1;

    @Test
    public void addLocationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLocationsPage();

        LocationsPage locationsPage = new LocationsPage(driver);

        AddLocationPage addLocationPage = locationsPage.clickAddLocation();

        addLocationPage.addNewLocation(LOCATION_NAME, ARGENTINA.NAME);

        assertThat(locationsPage.getSuccessMessageText(), is(SUCCESS_MESSAGE));
        assertThat(locationsPage.getLocationTable().getCellsOfColumn(LOCATION_NAME_COLUMN_INDEX), hasItem(LOCATION_NAME));
    }
}
