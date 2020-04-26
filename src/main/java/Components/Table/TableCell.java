package Components.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.CONST.SECONDS_TO_WAIT;

public class TableCell {
    WebElement cell;
    WebDriver driver;
    WebDriverWait wait;

    private final String cellTag = "td";

    public TableCell(WebDriver driver, WebElement cell) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS_TO_WAIT);
        this.cell = cell;
    }

    public void clickOnTagInsideCell(String tag) {
        cell.findElement(By.tagName(tag)).click();
    }

    public String getText() {
        return cell.getText();
    }
}
