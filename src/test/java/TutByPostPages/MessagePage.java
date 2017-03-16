package TutByPostPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    @FindBy(css = ".mail-Notification-Content")
    public WebElement notificationMessage;

    @FindBy(css = "div[title='Закрыть']")
    private WebElement closeMessageButton;

    @FindBy(css = "div[class='_nb-popup-i']")
    public WebElement confirmationWindow;

    @FindBy(css = "button[data-action='save']")
    private WebElement saveButton;

    @FindBy(css = ".mail-QuickReply-Placeholder_text")
    private WebElement quickReplyPlaceholderText;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void emailAndSubjectInput (String email, String subject){

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
    }

    public void fillMessageField(String message){
        wait.until(ExpectedConditions.visibilityOf(messageField));
        messageField.sendKeys(message);
    }

    public void letterWriting(String email, String subject, String message){
        emailAndSubjectInput(email, subject);
        fillMessageField(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void clickCloseMessageButton(){
        closeMessageButton.click();
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void answerLetter(String message){
        wait.until(ExpectedConditions.visibilityOf(quickReplyPlaceholderText));
        quickReplyPlaceholderText.click();
        wait.until(ExpectedConditions.visibilityOf(messageField));
        fillMessageField(message);
    }


}
