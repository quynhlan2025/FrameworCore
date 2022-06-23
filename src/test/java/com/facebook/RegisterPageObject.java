package com.facebook;

import common.BasePage;
import interfaces.facebook.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isEmailTextBoxDisplayed(WebDriver driver) {
        waitForElementVisisble(driver, RegisterPageUI.EMAIL_TEXTBOX);
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);

    }

    public boolean isEmailConfirmTextBoxDisplayed(WebDriver driver) {
        waitForElementVisisble(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);

    }

    public void clickOnRegisterLogin(WebDriver driver) {
        waitForElementVisisble(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

    }

    public boolean isConfirmEmailDisplayed(WebDriver driver) {
        waitForElementVisisble(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);

    }

    public boolean isButtonLoginUndisplayed(WebDriver driver) {
      //  waitForElementVisisble(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);
        return isElementDisplayed(driver, RegisterPageUI.EMAIL_CONFIRM_TEXTBOX);

    }

    public void enterToEmailTextBox(WebDriver driver,String s) {
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,s);
    }
}
