package common;

import com.noncomercial.HomePageObject;
import com.noncomercial.LoginPageObject;
import com.noncomercial.SearchPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject homepageObject;
    public static SearchPageObject searchPageObject;
    public static LoginPageObject loginPageObject;
    public static SearchPageObject returnSearchPage(WebDriver driver) {
        if (searchPageObject==null){
            searchPageObject=new SearchPageObject(driver);
        }
        return searchPageObject;
    }
    public static LoginPageObject returnLoginPage(WebDriver driver) {
        if (loginPageObject==null){
            loginPageObject=new LoginPageObject(driver);
        }
        return loginPageObject;
    }
}