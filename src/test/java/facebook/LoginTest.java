package facebook;

import com.facebook.LoginPageObject;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginTest extends BaseTest {

    LoginPageObject login;
    public static Set<Cookie> allCookies;

    @Test
    public void login() {
        login = new LoginPageObject(driver);
        login.enterEmail(driver, "lan@ziggedy.com");
        login.enterPassword(driver, "vc111!!!");
        login.loginButton(driver);
        Assert.assertTrue(login.isLOGOFaceBookDisplayed(driver));
        allCookies = login.getAllCookie(driver);
    }

}
