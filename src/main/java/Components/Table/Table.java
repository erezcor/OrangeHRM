package Components.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static Constants.CONST.SECONDS_TO_WAIT;
import static java.util.stream.Collectors.toList;

public class Table {
    private final String rowSelector = "tbody > tr";

    WebDriver driver;
    WebDriverWait wait;
    String tableSelector;

    public Table(WebDriver driver, String tableSelector) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS_TO_WAIT);
        this.tableSelector = tableSelector;

    }

    public TableRow getRow(int rowIndex) {
        return getRows().get(rowIndex);
    }

    public List<TableRow> getRows() {
        return getTable().findElements(By.cssSelector(rowSelector)).stream().map(row -> new TableRow(driver, row)).collect(toList());
    }

    public TableRow getRowByTextInColumn(int columnIndex, String text) {
        return getRows().stream().filter(row -> row.doesRowHaveItemOf(text, columnIndex)).collect(toList()).get(0);
    }

    public List<String> getColumnInString(int columnIndex) {
        return getRows().stream().map(row -> row.getCell(columnIndex).getText()).collect(toList());
    }

    private WebElement getTable() {
        return driver.findElement(By.cssSelector(tableSelector));
    }
}
