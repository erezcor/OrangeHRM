package Pages.Location;

import Components.Table;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Constants.LocationTableColumns.CHECKBOX;
import static Constants.LocationTableColumns.NAME;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LocationsPage extends BasePage {
    private final String LOCATION_NAMES_SELECTOR = "table > tbody > tr > td > a";
    private final String TABLE_SELECTOR = "#frmList_ohrmListComponent > table";

    @FindBy (id = "rightMenu")
    WebElement locationPageFrame;

    @FindBy (id = "btnAdd")
    private WebElement addLocationButton;

    @FindBy (id = "btnDelete")
    private WebElement deleteLocationButton;

    @FindBy (id = "dialogDeleteBtn")
    private WebElement confirmDeleteButton;

    @FindBy (id = "btnSearch")
    private WebElement searchLocationButton;

    @FindBy (className = "messageBalloon_success")
    private WebElement successMessage;

    @FindBy (css = LOCATION_NAMES_SELECTOR)
    private List<WebElement> locationNames;

    private Table locationTable;

    public LocationsPage(WebDriver driver) {
        super(driver);
        wait.until(frameToBeAvailableAndSwitchToIt(locationPageFrame));
    }

    public AddLocationPage clickAddLocation() {
        wait.until(visibilityOf(this.addLocationButton));
        wait.until(elementToBeClickable(this.addLocationButton));
        Actions action = new Actions(driver);
        action.moveToElement(this.addLocationButton).click().perform();
        return (new AddLocationPage(driver));
    }

    public String getSuccessMessageText() {
        return (this.successMessage.getText());
    }

    public Table getLocationTable() {
        locationTable = new Table(driver, TABLE_SELECTOR);
        return locationTable;
    }

    public void deleteLocation() {
        this.deleteLocationButton.click();
        wait.until(elementToBeClickable(this.confirmDeleteButton));
        this.confirmDeleteButton.click();
    }

    public int countHowManyTimesNameAppearsInTable(String locationName) {
        locationTable = getLocationTable();
        return (int) locationTable.getCellsOfColumnInString(NAME.INDEX).stream().filter(name -> name.equals(locationName)).count();
    }

    public void clickOnLocationCheckboxOf(String locationName) {
        locationTable = getLocationTable();
        clickOnTagInsideCell(locationTable.getCellByLocationName(CHECKBOX.INDEX, locationName), "input");
    }

    public void clickEditLocation(String locationName) {
        locationTable = getLocationTable();
        clickOnTagInsideCell(locationTable.getCellByLocationName(NAME.INDEX, locationName), "a");
    }

    public void clickOnTagInsideCell(WebElement cell, String tag) {
        cell.findElement(By.tagName(tag)).click();
    }
}
