package com.nextbasecrm.tests;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.HomePage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.By;
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
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void comment_test(){

        // we need to login first.

        loginPage.loginBox.sendKeys("helpdesk1@cybertekschool.com");
        loginPage.passwordBox.sendKeys("UserUser");
        loginPage.loginButton.click();

        // Verify the title of the page

        String expectedInTitle = "Portal";
        String actualInTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualInTitle.contains(expectedInTitle));

        BrowserUtils.sleep(2);

        // Go to first messsage in the activity stream and click " Add comment " box

        homePage.getCommentBox.click();

        // switch the iframe which is include this input box

        Driver.getDriver().switchTo().frame(homePage.iframe1);

        // write a comment with using faker

        homePage.writeCommentBox.sendKeys(faker.chuckNorris().fact());

        // switch to parent frame for able to use send button

        Driver.getDriver().switchTo().parentFrame();

        // click the send button

        homePage.sendButton.click();
        BrowserUtils.sleep(5);
    }


}
