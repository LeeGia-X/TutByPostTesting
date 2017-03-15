package TutByPostPages;

import org.openqa.selenium.By;
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
    private WebElement emailBox;

    @FindBy(css = "input[name='subj']")
    private WebElement subjectBox;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void emailAndSubjectInput (String email, String subject){
        emailBox.sendKeys(email);
        subjectBox.sendKeys(subject);

    }
}
