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
    public WebElement loginInputBox;

    @FindBy(xpath ="//input[@name='USER_EMAIL']" )
    public WebElement emailInputBox;


    @FindBy(xpath ="//button[@value='Reset password']" )
    public WebElement resetButton;

    @FindBy(xpath ="//div[@class='notetext']" )
    public WebElement messageText;

    @FindBy(xpath ="//div[@class='errortext']" )
    public WebElement errorMessage;

    @FindBy(xpath ="//a[.='Authorization']" )
    public WebElement authorizationLink;





}
