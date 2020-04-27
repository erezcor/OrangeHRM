package Tests.LocationTests;

import Constants.Country;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Country.*;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.Utils.addNewLocation;
import static Processes.Utils.goToLocationsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class CancelAddingLocation extends BaseTest {
    String locationNameForFillingTable = "Las Vegas" + getRandomNumberAsString();
    String locationNameForCancellingLocation = "Buenos Aires" + getRandomNumberAsString();
    Country locationCountry = ISRAEL;

    @Test
    public void cancelAddingLocationTest() {
        goToLocationsPage(driver);
        addNewLocation(driver, locationNameForFillingTable, locationCountry);

        LocationsPage locationsPage = new LocationsPage(driver);
        LocationInfoPage locationInfoPage = locationsPage.clickAddLocation();

        locationInfoPage.insertLocationDetails(locationNameForCancellingLocation, locationCountry);
        locationInfoPage.clickCancelAddingLocation();

        assertThat(locationsPage.getLocationNameColumnFromTable(), not(hasItem(locationNameForCancellingLocation)));
    }
}
