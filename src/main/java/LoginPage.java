import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    By loginLink = By.xpath(".//*[contains(text(),'Log in')]");
    By loginField = By.xpath(".//*[@id='username']");
    By passwordField = By.xpath(".//*[@id='password']");
    By submitButton = By.xpath(".//*[@class='btn1 submit_button']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLogIn(){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
        return this;
    }

    public LoginPage inputLogin(String login){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(loginField));
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage userSubmit(){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(submitButton).submit();
        return this;
    }

    public LoginPage openLoginPage(){
        driver.get("http://dori.basheg.org.ua/");
        return this;
    }
}
