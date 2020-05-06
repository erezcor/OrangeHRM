package Pages.rightMenuFramePages.Location;

import Components.Table.Table;
import Entities.Location;
import Pages.rightMenuFramePages.rightMenuFramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Constants.Table.LocationTableColumns.CHECKBOX;
import static Constants.Table.LocationTableColumns.NAME;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LocationsPage extends rightMenuFramePage {
    private final String LOCATION_NAMES_SELECTOR = "table > tbody > tr > td > a";
    private final String TABLE_SELECTOR = "#frmList_ohrmListComponent > table";

    @FindBy (id = "btnAdd")
    private WebElement addLocationButton;

    @FindBy (id = "btnDelete")
    private WebElement deleteLocationButton;

    @FindBy (id = "dialogDeleteBtn")
    private WebElement confirmDeleteButton;

    @FindBy (id = "searchLocation_name")
    private WebElement searchLocationName;

    @FindBy (id = "btnSearch")
    private WebElement searchButton;

    @FindBy (id = "btnReset")
    private WebElement resetSearchButton;

    @FindBy (className = "messageBalloon_success")
    private WebElement successMessage;

    private Table locationTable;

    public LocationsPage(WebDriver driver) {
        super(driver);
    }

    public LocationInfoPage clickAddLocation() {
        addLocationButton.click();
        return new LocationInfoPage(driver);
    }

    public LocationInfoPage clickEditLocation(Location location) {
        getLocationTable().getRowByTextInColumn(NAME, location.getName()).clickOnCell(NAME);
        return new LocationInfoPage(driver);
    }

    public void searchLocation(Location location) {
        searchLocationName.sendKeys(location.getName());
        searchButton.click();
    }

    public void resetLocationSearch() {
        resetSearchButton.click();
    }

    public void clickOnLocationCheckboxOf(Location location) {
        getLocationTable().getRowByTextInColumn(NAME, location.getName()).clickOnCell(CHECKBOX);
    }

    public void deleteLocation() {
        deleteLocationButton.click();
        wait.until(elementToBeClickable(confirmDeleteButton)).click();
    }

    private Table getLocationTable() {
        locationTable = new Table(driver, TABLE_SELECTOR);
        return locationTable;
    }

    public int countHowManyTimesNameAppearsInTable(Location location) {
        return (int) getLocationTable().getColumnInString(NAME).stream().filter(name -> name.equals(location.getName())).count();
    }

    public List<String> getLocationNameColumnFromTable() {
        return getLocationTable().getColumnInString(NAME);
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public String getNoRecordsFoundErrorText() {
        return getLocationTable().getNoRecordsFoundErrorText();
    }
}
