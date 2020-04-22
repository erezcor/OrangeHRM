package Pages.rightMenuFramePages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class rightMenuFramePage extends BasePage {
    @FindBy (id = "rightMenu")
    WebElement pageFrame;

    public rightMenuFramePage(WebDriver driver) {
        super(driver);
        switchToPageFrame();
    }

    private void switchToPageFrame() {
        try {
            driver.switchTo().frame(pageFrame);
        }
        catch (Exception exception) {}
    }
}
