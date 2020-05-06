package Pages.rightMenuFramePages.Location;

import Constants.Country;
import Entities.Location;
import Pages.rightMenuFramePages.rightMenuFramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LocationInfoPage extends rightMenuFramePage {
    private final int COUNTRY_SELECT_DEFAULT_VALUE_INDEX = 0;
    private final String LOCATION_ALREADY_EXISTS_ERROR_SELECTOR = "#frmLocation > div:nth-child(7) > label";

    @FindBy(id = "location_name")
    private WebElement locationName;

    @FindBy (id = "location_country")
    private WebElement locationCountry;

    @FindBy (id = "btnSave")
    private WebElement saveLocationButton;

    @FindBy (id = "btnSave")
    private WebElement editLocationButton;

    @FindBy (id = "btnCancel")
    private WebElement cancelButton;

    @FindBy (css = LOCATION_ALREADY_EXISTS_ERROR_SELECTOR)
    private WebElement locationAlreadyExistsError;

    @FindBy (id = "location_province")
    private WebElement locationProvince;

    @FindBy (id = "location_city")
    private WebElement locationCity;

    @FindBy (id = "location_address")
    private WebElement locationAddress;

    @FindBy (id = "location_zipCode")
    private WebElement locationZipCode;

    @FindBy (id = "location_phone")
    private WebElement locationPhone;

    @FindBy (id = "location_fax")
    private WebElement locationFax;

    @FindBy (id = "location_notes")
    private WebElement locationNotes;

    public LocationInfoPage(WebDriver driver) {
        super(driver);
    }

    public void addNewLocation(Location location) {
        insertLocationDetails(location);
        saveLocationButton.click();
    }

    public void insertLocationDetails(Location location) {
        locationName.sendKeys(location.getName());
        getCountrySelect().selectByVisibleText(location.getCountry().NAME);
        locationProvince.sendKeys(location.getProvince());
        locationCity.sendKeys(location.getCity());
        locationAddress.sendKeys(location.getAddress());
        locationZipCode.sendKeys(location.getZipCode());
        locationPhone.sendKeys(location.getPhone());
        locationFax.sendKeys(location.getFax());
        locationNotes.sendKeys(location.getNotes());;
    }

    public LocationsPage clickCancelAddingLocation() {
        cancelButton.click();
        return new LocationsPage(driver);
    }

    public void editLocation(Location location) {
        editLocationButton.click();
        clearAllFields();
        addNewLocation(location);
    }

    public void clearAllFields() {
        locationName.clear();
        getCountrySelect().selectByIndex(COUNTRY_SELECT_DEFAULT_VALUE_INDEX);
        locationProvince.clear();
        locationCity.clear();
        locationAddress.clear();
        locationZipCode.clear();
        locationPhone.clear();
        locationFax.clear();
        locationNotes.clear();
    }

    private Select getCountrySelect() {
        return new Select(locationCountry);
    }

    public String getErrorMessageText() {
        return locationAlreadyExistsError.getText();
    }
}
