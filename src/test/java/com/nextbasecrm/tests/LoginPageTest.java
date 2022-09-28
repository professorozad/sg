package com.nextbasecrm.tests;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ForgotPasswordPage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    Faker faker;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("env"));
        loginPage = new LoginPage();
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void login_page_valid_test() {

        loginPage.loginBox.sendKeys("helpdesk1@cybertekschool.com");

        loginPage.passwordBox.sendKeys("UserUser");

        loginPage.loginButton.click();


        String expectedInTitle = "Portal";
        String actualInTitle = driver.getTitle();

        Assert.assertTrue(actualInTitle.contains(expectedInTitle));


    }


    @Test
    public void login_page_invalid_email_test(){


        loginPage.loginBox.sendKeys(faker.internet().emailAddress());

        loginPage.passwordBox.sendKeys("UserUser");

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        System.out.println("loginPage.errorMessage.isDisplayed() = " + loginPage.errorMessage);


    }

    @Test
    public void login_page_invalid_password_test(){


        loginPage.loginBox.sendKeys("helpdesk1@cybertekschool.com");

        loginPage.passwordBox.sendKeys(faker.internet().password());

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());



    }

    @Test
    public void login_page_checkbox_test(){

        loginPage.checkbox.click();

        Assert.assertTrue(loginPage.checkbox.isSelected());

        //System.out.println("loginPage.checkbox.isSelected() = " + loginPage.checkbox.isSelected());

    }

    @Test
    public void login_page_forgot_password_test(){

        loginPage.forgotPasswordLink.click();

        String expectedInTitle = "Get Password";
        String actualInTitle = driver.getTitle();

        Assert.assertTrue(actualInTitle.contains(expectedInTitle));

    }


}


