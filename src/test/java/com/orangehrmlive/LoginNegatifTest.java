package com.orangehrmlive;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/27/2024 7:51 PM
@Last Modified 12/27/2024 7:51 PM
Version 1.0
*/

import com.orangehrmlive.pages.LoginPage;
import com.orangehrmlive.utils.Constants;
import com.orangehrmlive.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginNegatifTest {
    private static final Logger log = LoggerFactory.getLogger(LoginNegatifTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginNegatifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Go To Login Page")
    public void Go_To_Login_Page(){
        driver.manage().window().maximize(); //untuk full screen
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"Go To Login Page");
    }

    @When("Input Invalid Username")
    public void Input_Invalid_Username(){
        Utils.delay(2);
        loginPage.clearUsernameField();
        loginPage.setUsername("admin1");
        extentTest.log(LogStatus.PASS,"Input_Invalid_Username");
    }

    @And("Input Invalid Password")
    public void Input_Invalid_Password(){
        Utils.delay(2);
        loginPage.clearPasswordField();
        loginPage.setPassword("admin23");
        extentTest.log(LogStatus.PASS,"Input Invalid Password");
    }

    @Given("leave the username field empty")
    public void leave_the_username_field_empty(){
        Utils.delay(2);
        loginPage.clearUsernameField();
        loginPage.setUsername("");
        extentTest.log(LogStatus.PASS,"leave the username field empty");
    }

    @And("leave the password field empty")
    public void leave_the_password_field_empty(){
        Utils.delay(2);
        loginPage.clearPasswordField();
        loginPage.setPassword("");
        extentTest.log(LogStatus.PASS,"leave the password field empty");
    }

    @Then("The system show an invalid credentials alert")
    public void The_system_show_an_invalid_credentials_alert(){
        Utils.delay(2);
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(),"Invalid credentials");
        extentTest.log(LogStatus.PASS,"sistem memunculkan alert invalid credentials");
    }

    @Then("Alert required appears on blank fields")
    public void Alert_required_appears_on_blank_fields(){
        Utils.delay(2);
        Assert.assertEquals(loginPage.getTxtRequired(),"Required");
        extentTest.log(LogStatus.PASS,"Alert required appears on blank fields");
    }
}
