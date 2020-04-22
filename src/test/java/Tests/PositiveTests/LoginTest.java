package Tests.PositiveTests;

import Pages.BasePage;
import Pages.HomePage;
import Tests.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;

public class LoginTest extends BaseTest {

    @Ignore
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        Assert.assertThat(homePage.getWelcomeToHomePageText(), containsString("Welcome"));
    }
}
