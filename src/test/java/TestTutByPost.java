import TutByPostPages.TutByPost;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * Created by Кемко on 14.03.2017.
 */
public class TestTutByPost {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private WebDriver driver = new FirefoxDriver();
    TutByPost tutByPost = new TutByPost(driver);
    Properties prop = new Properties();
    Logger log = Logger.getLogger(TestTutByPost.class.getName());


    @BeforeTest
    public void setUp() {
        try {
            prop.load(new FileInputStream(PATH_TO_PROPERTIES));
            log.info("Properties are loaded.");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Error with properties load.");
        }
        log.info("Go to https://mail.tut.by/");
        driver.get(prop.getProperty("url"));
        log.info("Check page title");
        Assert.assertTrue(driver.getTitle().contains("TUT.BY | ВАША ПОЧТА ТУТ | Вход"));
        Assert.assertTrue(driver.getTitle().contains("TUT.BY | ВАША ПОЧТА ТУТ | Вход"),"We are on \"TUT.BY | ВАША ПОЧТА ТУТ | Вход\"");
        log.info("Authorization");
        tutByPost.authorizationPagePage().mailAvtorization(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void createDraft() {
        log.info("Start test #2");
        tutByPost.mainPostPage().clickWriteLetterButton();
        log.info("Fill fields (email, subject, message).");
        tutByPost.messagePage().letterWriting("lee_x@mail.ru", "Test","TestTutBy");
        log.info("Click message close button.");
        tutByPost.messagePage().clickMessageCloseButton();
        log.info("Check if confirmation window is displayed.");
        Assert.assertTrue(tutByPost.messagePage().confirmationWindow.isDisplayed());
        log.info("Confirm draft retention.");
        tutByPost.messagePage().clickSaveButton();
    }

    @Test
    public void answerLetter() {
        log.info("Start test #3");
        log.info("Select a letter by e-mail address.");
        tutByPost.mainPostPage().findLetterByEmail("lee_x@mail.ru");
        log.info("Fill message field.");
        tutByPost.messagePage().answerLetter("AnswerTest");
        log.info("Click send button.");
        tutByPost.messagePage().clickSendButton();
        log.info("Check if notification message is displayed.");
        Assert.assertTrue(tutByPost.messagePage().notificationMessage.isDisplayed(),"The letter is sent");
    }

    @Test
    public void sendLetter() {
        log.info("Start test #1");
        tutByPost.mainPostPage().clickWriteLetterButton();
        log.info("Fill fields (email, subject, message).");
        tutByPost.messagePage().letterWriting("lee_x@mail.ru", "Test","TestTutBy");
        log.info("Click send button.");
        tutByPost.messagePage().clickSendButton();
        log.info("Check if notification message is displayed.");
        Assert.assertTrue(tutByPost.messagePage().notificationMessage.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
        log.info("Browser closed");
    }




}
