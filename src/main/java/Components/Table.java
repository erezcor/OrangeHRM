package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final String LOCATION_NAMES_SELECTOR = "table > tbody > tr > td > a";

    WebDriver driver;

    @FindBy (css = LOCATION_NAMES_SELECTOR)
    private List<WebElement> locationNames;

    public Table(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<String> getLocationNames() {
        locationNames = driver.findElements(By.cssSelector(LOCATION_NAMES_SELECTOR));

        ArrayList<String> locationNamesStrings = new ArrayList<>();

        for (WebElement location : this.locationNames) {
            locationNamesStrings.add(location.getText());
        }

        return (locationNamesStrings);
    }
}
