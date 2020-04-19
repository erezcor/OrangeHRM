package Pages.Location;

import Components.Table;
import Pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LocationsPage extends BasePage {
    private final String LOCATION_ALREADY_EXISTS_ERROR_SELECTOR = "#frmLocation > div:nth-child(7) > label";
    private final String LOCATION_NAMES_SELECTOR = "table > tbody > tr > td > a";
    private final String TABLE_SELECTOR = "#frmList_ohrmListComponent > table";

    @FindBy (id = "rightMenu")
    WebElement locationPageFrame;

    @FindBy (id = "btnAdd")
    private WebElement addLocationButton;

    @FindBy (className = "messageBalloon_success")
    private WebElement successMessage;

    @FindBy (css = LOCATION_ALREADY_EXISTS_ERROR_SELECTOR)
    private WebElement locationAlreadyExistsError;

    @FindBy (css = LOCATION_NAMES_SELECTOR)
    private List<WebElement> locationNames;

    private Table locationTable;

    public LocationsPage(WebDriver driver) {
        super(driver);
        wait.until(frameToBeAvailableAndSwitchToIt(locationPageFrame));
    }

    public AddLocationPage clickAddLocation() {
        wait.until(visibilityOf(this.addLocationButton));
        this.addLocationButton.click();
        return (new AddLocationPage(driver));
    }

    public String getErrorMessageText() {
        return (this.locationAlreadyExistsError.getText());
    }

    public String getSuccessMessageText() {
        return (this.successMessage.getText());
    }

    public Table getLocationTable() {
        locationTable = new Table(driver, TABLE_SELECTOR);
        return locationTable;
    }
}
