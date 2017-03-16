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

    @FindBy(linkText = "Черновики")
    private WebElement draftsLink;

    //<span class="mail-NestedList-Item-Name js-folders-item-name">Черновики</span>

    @FindBy(css = ".mail-MessageSnippet-FromText")
    private WebElement messageSnippetFromText;
    //<span class="mail-MessageSnippet-FromText" title="lee_x@mail.ru">Ирина П</span>
    @FindBy(css = ".mail-MessageSnippet-Item_subject")
    private WebElement messageSnippetItemSubject;

    @FindBy(css = ".mail-MessageSnippet-Item_firstline")
    private WebElement messageSnippetItemFirstline;

    public MainPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }

    public void clickWriteLetterButton(){
        //wait.until(ExpectedConditions.urlContains("leex#inbox"));
        writeLetterButton.click();
        wait.until(ExpectedConditions.urlContains("leex#compose"));
    }

    public void clickDraftsLink(){
        draftsLink.click();
    }

    public String getMessageSnippets(){
        return messageSnippetFromText.getAttribute("title");

    }
}
