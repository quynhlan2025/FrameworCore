package com.noncomercial;

import common.BasePage;
import common.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePageFactory {


    @CacheLookup
    @FindBy()
    WebElement homePageSlider;
    void HomePageObject(WebDriver driver){
        this.driver=driver;
    }
    public WebDriver driver ;

    public boolean isHomePageSliderDisplayed(){
        return false;
    }

    public void enterFirstName(String firstName){

    }

}