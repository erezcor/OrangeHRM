package Pages.rightMenuFramePages.Location;

import Components.Table.Table;
import Pages.rightMenuFramePages.rightMenuFramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Constants.LocationTableColumns.CHECKBOX;
import static Constants.LocationTableColumns.NAME;
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
        wait.until(visibilityOf(this.addLocationButton));
        wait.until(elementToBeClickable(this.addLocationButton));
        Actions action = new Actions(driver);
        action.moveToElement(this.addLocationButton).click().perform();
        return new LocationInfoPage(driver);
    }

    public LocationInfoPage clickEditLocation(String locationName) {
        getLocationTable().getRowByTextInColumn(NAME.INDEX, locationName).getCell(NAME.INDEX).clickOnTagInsideCell("a");
        return new LocationInfoPage(driver);
    }

    public void deleteLocation() {
        this.deleteLocationButton.click();
        wait.until(elementToBeClickable(this.confirmDeleteButton)).click();
    }

    public String getSuccessMessageText() {
        return (this.successMessage.getText());
    }

    private Table getLocationTable() {
        locationTable = new Table(driver, TABLE_SELECTOR);
        return locationTable;
    }

    public int countHowManyTimesNameAppearsInTable(String locationName) {
        return (int) getLocationTable().getColumnInString(NAME.INDEX).stream().filter(name -> name.equals(locationName)).count();
    }

    public void clickOnLocationCheckboxOf(String locationName) {
        getLocationTable().getRowByTextInColumn(CHECKBOX.INDEX, locationName).getCell(CHECKBOX.INDEX).clickOnTagInsideCell(CHECKBOX.SELECTOR);
    }

    public List<String> getLocationNameColumnFromTable() {
        return getLocationTable().getColumnInString(NAME.INDEX);
    }

    public void searchLocation(String locationName) {
        this.searchLocationName.sendKeys(locationName);
        this.searchButton.click();
        wait.until(visibilityOf(this.addLocationButton));
    }

    public void resetLocationSearch() {
        this.resetSearchButton.click();
    }

    public String getNoRecordsFoundErrorText() {
        return this.getLocationTable().getNoRecordsFoundErrorText();
    }
}
