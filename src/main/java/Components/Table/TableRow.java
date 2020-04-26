package Components.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static Constants.CONST.SECONDS_TO_WAIT;
import static java.util.stream.Collectors.toList;

public class TableRow {
    WebElement row;
    WebDriver driver;
    WebDriverWait wait;

    private final String cellTag = "td";

    public TableRow(WebDriver driver, WebElement row) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS_TO_WAIT);
        this.row = row;
    }

    public TableCell getCell(int columnIndex) {
        return getCells().get(columnIndex);
    }

    public List<TableCell> getCells() {
        return row.findElements(By.tagName(cellTag)).stream().map(cell -> new TableCell(driver, cell)).collect(toList());
    }

    public boolean doesRowHaveItemOf(String text, int columnIndex) {
        return getCells().get(columnIndex).getText().equals(text);
    }

}
