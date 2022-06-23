package common;

import com.facebook.LoginPageObject;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.util.Set;

public class LoginFacebook extends BaseTest {
    private WebDriver driver;
    LoginPageObject login;
    public static Set<Cookie> allCookies;

    @BeforeTest
    public void beforeTest() {
        driver = getDriver();
        login = new LoginPageObject(driver);
        login.enterEmail(driver, "lan@ziggedy.com");
        login.enterPassword(driver, "vc111!!!");
        login.loginButton(driver);
        Assert.assertTrue(login.isLOGOFaceBookDisplayed(driver));
        allCookies = login.getAllCookie(driver);
    }


    public void login() {

    }

}
