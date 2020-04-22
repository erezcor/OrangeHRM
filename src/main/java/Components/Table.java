package Components;

import Constants.LocationTableColumns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static Constants.CONST.SECONDS_TO_WAIT;
import static Constants.LocationTableColumns.*;

public class Table implements TableInterface {
    private final String rowSelector = "tbody > tr";
    private final String cellTag = "td";

    WebDriver driver;
    WebDriverWait wait;
    WebElement table;

    public Table(WebDriver driver, String tableSelector) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS_TO_WAIT);
        table = driver.findElement(By.cssSelector(tableSelector));
    }

    public WebElement getCellByLocationName(int cellIndex, String locationName) {
        return getCellFromRow(cellIndex, getRowByTextInColumn(NAME.INDEX, locationName));
    }

    public WebElement getRowByTextInColumn(int columnIndex, String text) {
        return getRow(getRowIndexByTextInColumn(columnIndex, text));
    }

    public int getRowIndexByTextInColumn(int columnIndex, String text) {
        return getCellsOfColumnInString(columnIndex).indexOf(text);
    }

    public WebElement getRow(int rowIndex) {
        return getRows().get(rowIndex);
    }

    public List<WebElement> getRows() {
        return table.findElements(By.cssSelector(rowSelector));
    }

    public List<WebElement> getCellsOfColumn(List<WebElement> rows, int columnIndex) {
        return rows.stream().map(row -> getCellFromRow(columnIndex, row)).collect(Collectors.toList());
    }

    public List<WebElement> getCellsOfColumn(int columnIndex) {
        return getCellsOfColumn(getRows(), columnIndex);
    }

    public List<String> getCellsOfColumnInString(List<WebElement> rows, int columnIndex) {
        return getCellsOfColumn(rows, columnIndex).stream().map(cell -> cell.getText()).collect(Collectors.toList());
    }

    public List<String> getCellsOfColumnInString(int columnIndex) {
        return getCellsOfColumnInString(getRows(), columnIndex);
    }

    public WebElement getCellFromRow(int columnIndex, WebElement row) {
        return row.findElements(By.tagName(cellTag)).get(columnIndex);
    }
}