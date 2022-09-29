package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Add comment")
    public WebElement getCommentBox;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@style='min-height: 84px;']")
    public WebElement writeCommentBox;

    @FindBy(xpath = "//button[contains(@id, 'submit_blog')]")
    public WebElement sendCommentButton;

    @FindBy(xpath = "//div[@class='feed-add-post-micro']")
    public WebElement sendMessageInputBox;

    @FindBy(xpath = "//body[@style='min-height: 184px;']")
    public WebElement writeMessageBox;

    @FindBy(xpath = "blog-submit-button-save")
    public WebElement sendMessageButton;





}
