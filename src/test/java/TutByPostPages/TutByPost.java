package TutByPostPages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Кемко on 14.03.2017.
 */
public class TutByPost {
    WebDriver driver;

    public TutByPost(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage mainPage() {return new MainPage(driver);}
    public AuthorizationPage authorizationPagePage() {return new AuthorizationPage(driver);}
    public MainPostPage mainPostPage() {return new MainPostPage(driver);}
    public MessagePage messagePage() {return  new MessagePage(driver);}

}
