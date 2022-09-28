package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    WebElement username;

    @FindBy(xpath ="//input[@name='USER_EMAIL']" )
    WebElement password;


    @FindBy(xpath ="//button[@value='Reset password']" )
    WebElement resetButton;

    @FindBy(xpath ="//div[@class='notetext']" )
    WebElement messageText;

    @FindBy(xpath ="//div[@class='errortext']" )
    WebElement errorMessage;

    @FindBy(xpath ="//a[.='Authorization']" )
    WebElement authorizationLink;



}
