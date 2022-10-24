package com.nextbasecrm.tests;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ForgotPasswordPage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordPageTest {

    WebDriver driver;
    ForgotPasswordPage forgotPasswordPage;
    Faker faker;

    LoginPage loginPage;
    before

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        forgotPasswordPage = new ForgotPasswordPage();
        loginPage = new LoginPage();
        faker = new Faker();
        driver.get(ConfigurationReader.getProperty("env"));
        loginPage.forgotPasswordLink.click();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void forgotPasswordPage_test_1(){



        forgotPasswordPage.loginInputBox.sendKeys("helpdesk1@cybertekschool.com"+ Keys.ENTER);

        Assert.assertTrue(forgotPasswordPage.messageText.isDisplayed());

    }

    @Test
    public void forgotPasswordPage_test_2(){



        forgotPasswordPage.emailInputBox.sendKeys(faker.internet().emailAddress());
        forgotPasswordPage.resetButton.click();

        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

    }

    @Test
    public void forgotPasswordPage_test_3(){



        forgotPasswordPage.authorizationLink.click();

        String expectedTitle = "Authorization";

       Assert.assertEquals(driver.getTitle(),expectedTitle);
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }







}
