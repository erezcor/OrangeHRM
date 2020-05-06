package Pages.rightMenuFramePages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class rightMenuFramePage extends BasePage {
    WebElement pageFrame;
    String frameID = "rightMenu";
    By frameSelector = By.id(frameID);

    public rightMenuFramePage(WebDriver driver) {
        super(driver);
        switchToPageFrame();
    }

    private void switchToPageFrame() {
        try {
            driver.switchTo().frame(driver.findElement(frameSelector));
        }
        catch (Exception exception) { }
    }
}
