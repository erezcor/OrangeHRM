package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface TableInterface {
    public List<WebElement> getRows();
    public WebElement getCellFromRow(int columnIndex, WebElement row);
}
