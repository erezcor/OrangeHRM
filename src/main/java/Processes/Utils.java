package Processes;

import Constants.Country;
import Pages.HomePage;
import Pages.rightMenuFramePages.Location.LocationInfoPage;
import Pages.rightMenuFramePages.Location.LocationsPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static Constants.CONST.ADMIN_PASSWORD;
import static Constants.CONST.ADMIN_USERNAME;

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
        LocationInfoPage locationInfoPage = locationsPage.clickAddLocation();
        locationInfoPage.addNewLocation(locationName, country);
    }
}
