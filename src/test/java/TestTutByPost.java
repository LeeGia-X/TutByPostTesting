import TutByPostPages.TutByPost;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Кемко on 14.03.2017.
 */
public class TestTutByPost {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private WebDriver driver = new FirefoxDriver();
    TutByPost tutByPost = new TutByPost(driver);
    Properties prop = new Properties();

    @BeforeTest
    public void setUp() {
        try {
            prop.load(new FileInputStream(PATH_TO_PROPERTIES));
        } catch (IOException e) {
            System.out.println("Can't get properties");
        }
        driver.get(prop.getProperty("url"));
        Assert.assertTrue(driver.getTitle().contains("TUT.BY | ВАША ПОЧТА ТУТ | Вход"));
        tutByPost.authorizationPagePage().mailAvtorization(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Ignore
    public void sendLetter() {
        tutByPost.mainPostPage().clickWriteLetterButton();
        tutByPost.messagePage().letterWriting("lee_x@mail.ru", "Test","TestTutBy");
        tutByPost.messagePage().clickSendButton();
        Assert.assertTrue(tutByPost.messagePage().notificationMessage.isDisplayed());
    }

    @Ignore
    public void createDraft() {
        tutByPost.mainPostPage().clickWriteLetterButton();
        tutByPost.messagePage().letterWriting("lee_x@mail.ru", "Test","TestTutBy");
        tutByPost.messagePage().clickCloseMessageButton();
        Assert.assertTrue(tutByPost.messagePage().confirmationWindow.isDisplayed());
        tutByPost.messagePage().clickSaveButton();
    }

    @Test
    public void answerLetter() {
        tutByPost.mainPostPage().findLetterByEmail("lee_x@mail.ru");
        tutByPost.messagePage().answerLetter("AnswerTest");
        tutByPost.messagePage().clickSendButton();
        Assert.assertTrue(tutByPost.messagePage().notificationMessage.isDisplayed());
    }
}
