package com.facebook;

import common.BasePage;
import interfaces.facebook.LoginPageUI;
import interfaces.facebook.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(WebDriver driver, String email){
        waitForElementVisisble(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterPassword(WebDriver driver, String password){
        waitForElementVisisble(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void loginButton(WebDriver driver) {
        //waitForElementVisisble(driver, LoginPageUI.LOGIN_BUTTON);
        //waitForElementVisisble(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public boolean isLOGOFaceBookDisplayed(WebDriver driver) {
        waitForElementVisisble(driver, LoginPageUI.LOGO);
        return isElementDisplayed(driver, LoginPageUI.LOGO);

    }
}
