import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainSearch {

    By searchField = By.xpath(".//*[@id='search']");
    By searchButton = By.xpath(".//*[@class='fa fa-search']");

    private final WebDriver driver;

    public MainSearch(WebDriver driver){
        this.driver = driver;
    }

    public MainSearch inputFindName(String findName){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(findName);
        return this;
    }

    public MainSearch findButtonClick() {
        driver.findElement(searchButton).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250 )", "");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainSearch open(){
        driver.get("http://dori.basheg.org.ua");
        driver.manage().window().maximize();
        return this;
    }
}

