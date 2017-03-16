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
public class MainPostPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".ns-view-toolbar-button-compose-go")
    private WebElement writeLetterButton;

    public MainPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void clickWriteLetterButton(){
        writeLetterButton.click();
        wait.until(ExpectedConditions.urlContains("leex#compose"));
    }

}
