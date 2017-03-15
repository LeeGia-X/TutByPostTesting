package TutByPostPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Кемко on 14.03.2017.
 */
public class MessagePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "div[name='to']")
    private WebElement emailField;

    @FindBy(css = "input[name='subj']")
    private WebElement subjectField;

    @FindBy(css = ".cke_contents_ltr")
    private WebElement messageField;

    @FindBy(css = "._nb-action-button")
    private WebElement sendButton;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void emailAndSubjectInput (String email, String subject){
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
    }

    public void fillMessageField(String message){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cke_contents_ltr")));
        wait.until(ExpectedConditions.visibilityOf(messageField));
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //messageField.sendKeys(message);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        messageField.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }
}
