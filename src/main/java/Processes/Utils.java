package Processes;

import static Constants.CONST.ADMIN_USERNAME;
import static Constants.CONST.ADMIN_PASSWORD;
import static Constants.Country.ARGENTINA;

import Constants.Country;
import Pages.HomePage;
import Pages.Location.AddLocationPage;
import Pages.Location.LocationsPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static void loginAsAdmin(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);
        loginPage.clickLogin();
    }

    public static void goToOrganizationInfoPage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.goToOrganizationInfoPage();
    }

    public static void goToLocationsPage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.goToLocationsPage();
    }

    public static void addNewLocation(WebDriver driver, String locationName, Country country) {
        LocationsPage locationsPage = new LocationsPage(driver);
        AddLocationPage addLocationPage = locationsPage.clickAddLocation();
        addLocationPage.addNewLocation(locationName, country.NAME);
    }
}
