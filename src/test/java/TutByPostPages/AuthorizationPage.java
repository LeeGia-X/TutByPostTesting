package TutByPostPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Кемко on 14.03.2017.
 */
public class AuthorizationPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#Username")
    private WebElement usernameBox;

    @FindBy(css = "#Password")
    private WebElement passwordBox;

    @FindBy(css = ".loginButton")
    private WebElement loginButton;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void mailAvtorization(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.urlContains("leex#inbox"));
    }
}
