package com.nextbasecrm.tests;

import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPageTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage = new LoginPage();
    }

    @Test
    public void login_page_test1(){





    }


}
