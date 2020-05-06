package Components.Table;

import Constants.Table.TableColumn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static Constants.CONST.SECONDS_TO_WAIT;
import static java.util.stream.Collectors.toList;

public class Table {
    private final String rowSelector = "tbody > tr";
    final int NO_RECORDS_ROW_INDEX = 0;
    final int NO_RECORDS_COLUMN_INDEX = 0;

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

    public TableRow getRowByTextInColumn(TableColumn column, String text) {
        return getRows().stream().filter(row -> row.hasItemOf(text, column)).collect(toList()).get(0);
    }

    public List<String> getColumnInString(TableColumn column) {
        return getRows().stream().map(row -> row.getCellText(column)).collect(toList());
    }

    private WebElement getTable() {
        return driver.findElement(By.cssSelector(tableSelector));
    }

    public String getNoRecordsFoundErrorText() {
        return getRow(NO_RECORDS_ROW_INDEX).getCellByIndex(NO_RECORDS_COLUMN_INDEX).getText();
    }
}
