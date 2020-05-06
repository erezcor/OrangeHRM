package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Processes.Utils.loginAsAdmin;

public class BaseTest {
    protected WebDriver driver;
    private final String DRIVER_PATH = "chromedriver.exe";
    private final String PAGE_URL = "https://s1.demo.opensourcecms.com/s/44";

    {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        loginAsAdmin(driver);
    }

    @After
    public void terminate() {
        driver.quit();
    }
}
