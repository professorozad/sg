package com.nextbasecrm.tests;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.HomePage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    HomePage homePage;

    LoginPage loginPage;

    Faker faker;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();

        // navigate to homePage

        loginPage.loginBox.sendKeys("helpdesk1@cybertekschool.com");
        loginPage.passwordBox.sendKeys("UserUser");
        loginPage.loginButton.click();

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void comment_test(){



        // Verify the title of the page

        String expectedInTitle = "Portal";
        String actualInTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualInTitle.contains(expectedInTitle));


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scroll(0,200)");

        BrowserUtils.sleep(3);

        // Go to first messsage in the activity stream and click " Add comment " box

        homePage.getCommentBox.click();

        BrowserUtils.sleep(3);

        // switch the iframe which is include this input box

        Driver.getDriver().switchTo().frame(homePage.iframe);

        // write a comment with using faker

        homePage.writeCommentBox.sendKeys(faker.chuckNorris().fact());

        // switch to parent frame for able to use send button

        Driver.getDriver().switchTo().parentFrame();

        // click the send button

        homePage.sendCommentButton.click();
        BrowserUtils.sleep(5);
    }

    @Test
    public void message_test(){

        BrowserUtils.sleep(2);

        // Click " Send message " box

        homePage.sendMessageInputBox.click();

        // switch the iframe which is include this input box

        Driver.getDriver().switchTo().frame(homePage.iframe);

        // write a comment with using faker

        homePage.writeMessageBox.sendKeys(faker.chuckNorris().fact());

        // switch to parent frame for able to use send button

        Driver.getDriver().switchTo().parentFrame();

        // click the send button

        homePage.sendMessageButton.click();

        BrowserUtils.sleep(10);



    }


}
