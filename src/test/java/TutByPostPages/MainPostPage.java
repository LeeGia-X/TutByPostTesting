package TutByPostPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Кемко on 14.03.2017.
 */
public class MainPostPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".ns-view-toolbar-button-compose-go")
    private WebElement writeLetterButton;

    @FindBy(css = ".mail-MessageSnippet-FromText")
    private WebElement messageSnippetFromText;

    @FindAll({
            @FindBy(css = ".mail-MessageSnippet-FromText")
    })
    private List<WebElement> elements;

    public MainPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void clickWriteLetterButton(){
        writeLetterButton.click();
        wait.until(ExpectedConditions.urlContains("leex#compose"));
    }

    public void findLetterByEmail(String email) {
        for (WebElement el:elements) {
            if (el.getAttribute("title").equals(email)){
                el.click();
                break;
            }
        }
    }



}
