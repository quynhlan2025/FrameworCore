package facebook;

import com.facebook.RegisterPageObject;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RegisterUnDisplayedTest extends BaseTest {
    RegisterPageObject registerPageObject;

//    @BeforeClass
//    public void beforeClass() {
//        driver = getDriver();
//        registerPageObject = new RegisterPageObject(driver);
//
//        System.out.println(" @BeforeClass : Register_UnDisplayed");
//        //registerPageObject.clickOnRegisterLogin(driver);
//
//    }

    //  @Test
    public void Register_Element_Displayed() {
        //Assert.assertTrue(i);
        // Displayed in UI + exist in DOM
        Assert.assertTrue(registerPageObject.isConfirmEmailDisplayed(driver));
    }

    //@Test
    public void Register_Element_UnDisplayed() {
        //Assert.assertTrue(i);
        // Displayed in UI + exist in DOM
        // registerPageObject.enterToEmailTextBox(driver, "quynhlan123434@gmail.com");
        Assert.assertTrue(registerPageObject.isConfirmEmailDisplayed(driver));

    }

    // @Test
    public void Register_Element_UnDisplayed_DOM_UI() {
        //Assert.assertTrue(i);
        // Displayed in UI + exist in DOM
        Assert.assertFalse(registerPageObject.isButtonLoginUndisplayed(driver));

    }

    @Test
    public void openFacebook() throws InterruptedException {
        registerPageObject = new RegisterPageObject(driver);
      //  System.out.println("Cookie= in Register " + LoginTest.allCookies);
        registerPageObject.setCookie(driver, LoginTest.allCookies);
        driver.get("https://www.facebook.com/groups/feed/");
    }
}
