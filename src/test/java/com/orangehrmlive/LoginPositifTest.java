package com.orangehrmlive;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/27/2024 6:42 PM
@Last Modified 12/27/2024 6:42 PM
Version 1.0
*/

import com.orangehrmlive.pages.DashboardPage;
import com.orangehrmlive.pages.LoginPage;
import com.orangehrmlive.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPositifTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPositifTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static DashboardPage dashboard = new DashboardPage();

    public LoginPositifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }


    @When("Input Valid Username")
    public void Input_Valid_Username(){
        Utils.delay(2);
        loginPage.clearUsernameField();
        loginPage.setUsername("Admin");
        extentTest.log(LogStatus.PASS,"Input Valid Username");
    }

    @And("Input Valid Password")
    public void Input_Valid_Password(){
        Utils.delay(2);
        loginPage.clearPasswordField();
        loginPage.setPassword("admin123");
        extentTest.log(LogStatus.PASS,"Input Valid Password");
    }
    @And("Click Login Button")
    public void Click_Login_Button(){
        Utils.delay(2);
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"Click Login Button");
    }

    @Then("Directed to Dashboard Page")
    public void Directed_to_Dashboard_Page(){
        Utils.delay(2);
        Assert.assertEquals(dashboard.getTxtDashboard(),"Dashboard");
        extentTest.log(LogStatus.PASS,"Directed to Dashboard Page");
    }


}

