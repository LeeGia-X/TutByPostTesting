import TutByPostPages.TutByPost;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.UrlChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

/**
 * Created by Кемко on 14.03.2017.
 */
public class TestTutByPost {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private WebDriver driver = new FirefoxDriver();
    TutByPost tutByPost = new TutByPost(driver);
    Properties prop = new Properties();

    @BeforeTest
    public void setUp() throws IOException {
        prop.load(new FileInputStream(PATH_TO_PROPERTIES));
        driver.get(prop.getProperty("url"));
        tutByPost.mainPage().mailLinkClick();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("TUT.BY | ВАША ПОЧТА ТУТ | Вход"));
        tutByPost.authorizationPagePage().mailAvtorization(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void loginPost() {
        tutByPost.mainPostPage().clickWriteLetterButton();
        tutByPost.messagePage().emailAndSubjectInput("Lee_X@mail.ru", "Test");




    }
}
