package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static Constants.CONST.SECONDS_TO_WAIT;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Table {
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

    public List<WebElement> getRows() {
        wait.until(visibilityOf(table));
        return table.findElements(By.cssSelector(rowSelector));
    }

    public List<String> getCellsOfColumn(List<WebElement> rows, int columnIndex) {
        return rows.stream().map(row -> getCellFromRow(columnIndex, row).getText()).collect(Collectors.toList());
    }

    public List<String> getCellsOfColumn(int columnIndex) {
        return getCellsOfColumn(getRows(), columnIndex);
    }

    private WebElement getCellFromRow(int columnIndex, WebElement row) {
        return row.findElements(By.tagName(cellTag)).get(columnIndex);
    }

//    public ArrayList<String> getColumn(String columnSelector) {
//        List<WebElement> column = driver.findElements(By.cssSelector(columnSelector));
//    }
}
