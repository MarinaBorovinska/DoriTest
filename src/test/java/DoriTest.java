import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoriTest {

        MainSearch mainSearch;
        LoginPage loginPage;

        WebDriver driver;

    String login = "Marina";
    String password = "Marina";

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Марина\\Documents\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        mainSearch = new MainSearch(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(groups = {"functest"})
    public void search() {
        mainSearch.open();
        mainSearch.inputFindName("shampoo");
        mainSearch.findButtonClick();
    }

    @Test(groups = {"login"})
    public void logIn() {
        loginPage.openLoginPage();
        loginPage.clickLogIn();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.userSubmit();
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
