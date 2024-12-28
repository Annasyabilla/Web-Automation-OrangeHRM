package com.orangehrmlive.pages;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/26/2024 6:16 PM
@Last Modified 12/26/2024 6:16 PM
Version 1.0
*/

import com.orangehrmlive.drivers.DriverSingleton;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    public void setUsername(String username){
        this.usernameField.sendKeys(username);
    }
    public void clearUsernameField(){
        this.usernameField.clear();
    }

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    public void setPassword(String password){
        this.passwordField.sendKeys(password);
    }
    public void clearPasswordField(){
        this.passwordField.clear();
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    public void setBtnLogin(){
        this.btnLogin.click();
    }


    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement txtInvalidCredentials;
    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

    @FindBy(xpath = "//*[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
    private WebElement txtRequired;
    public String getTxtRequired(){
        return txtRequired.getText();
    }
}
