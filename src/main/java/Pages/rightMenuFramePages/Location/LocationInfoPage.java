package Pages.rightMenuFramePages.Location;

import Constants.Country;
import Pages.rightMenuFramePages.rightMenuFramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LocationInfoPage extends rightMenuFramePage {
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

    public LocationInfoPage(WebDriver driver) {
        super(driver);
    }

    public void addNewLocation(String locationName, Country country) {
        this.insertLocationDetails(locationName, country);
        this.saveLocation();
    }

    public void insertLocationDetails(String locationName, Country country) {
        this.locationName.sendKeys(locationName);
        Select countrySelect = new Select(locationCountry);
        countrySelect.selectByVisibleText(country.NAME);
    }

    private void saveLocation() {
        this.saveLocationButton.click();
    }

    public String getErrorMessageText() {
        return this.locationAlreadyExistsError.getText();
    }

    public LocationsPage clickCancelAddingLocation() {
        this.cancelButton.click();
        return (new LocationsPage(driver));
    }

    public void editLocation(String locationName, Country country) {
        this.editLocationButton.click();
        clearAllFields();
        addNewLocation(locationName, country);
    }

    public void clearAllFields() {
        this.locationName.clear();
    }
}
