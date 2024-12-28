package com.orangehrmlive;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/27/2024 10:17 PM
@Last Modified 12/27/2024 10:17 PM
Version 1.0
*/

import com.orangehrmlive.pages.DashboardPage;
import com.orangehrmlive.pages.RecruitmentPage;
import com.orangehrmlive.utils.DataGenerator;
import com.orangehrmlive.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Random;

public class RecruitmentPositifTest {
    private static final Logger log = LoggerFactory.getLogger(RecruitmentPositifTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static DashboardPage dashboardpage = new DashboardPage();
    private static RecruitmentPage recruitmentPage = new RecruitmentPage();
    private static DataGenerator dataGenerator = new DataGenerator();

    public RecruitmentPositifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    String firstName = dataGenerator.dataNamaDepan();
    String middleName = dataGenerator.dataNamaTengah();
    String lastName = dataGenerator.dataNamaBelakang();
    String fullName = firstName + " " + middleName + " " + lastName;

    @Given("Open the Recruitment menu")
    public void Open_The_Recruitment_Menu(){
        Utils.delay(2);
        dashboardpage.clickBtnRecruitment();
        extentTest.log(LogStatus.PASS,"Open the Recruitment menu");
    }

    @When("Click the +add button")
    public void Click_The_Add_Button(){
        Utils.delay(2);
        recruitmentPage.clickAdd();
        extentTest.log(LogStatus.PASS,"Click the +add button");
    }

    @And("Fill in the first name field")
    public void Fill_The_First_Name_Field(){
        Utils.delay(2);
        recruitmentPage.fillFirstName(firstName);
        extentTest.log(LogStatus.PASS,"Fill in the first name field");
    }

    @And("Fill in the middle name field")
    public void Fill_The_Middle_Name_Field(){
        Utils.delay(2);
        recruitmentPage.fillMiddleName(middleName);
        extentTest.log(LogStatus.PASS,"Fill in the middle name field");
    }

    @And("Fill in the last name field")
    public void Fill_The_Last_Name_Field(){
        Utils.delay(2);
        recruitmentPage.fillLastName(lastName);
        extentTest.log(LogStatus.PASS,"Fill in the last name field");
    }

    @And("Select Vacancy")
    public void Select_Vacancy(){
        Utils.delay(2);
        recruitmentPage.selectVacancy();
        extentTest.log(LogStatus.PASS,"Select Vacancy");
    }

    @And("Fill in the email")
    public void Fill_in_the_email(){
        Utils.delay(2);
        recruitmentPage.fillEmail(dataGenerator.dataEmail());
        extentTest.log(LogStatus.PASS,"Fill in the email");
    }

    @And("Fill in the contact number")
    public void Fill_in_the_contact_number(){
        Utils.delay(2);
        recruitmentPage.fillContactNumber((dataGenerator.dataNoHp()));
        extentTest.log(LogStatus.PASS,"Fill in the contact number");
    }

    @And("Input resume")
    public void Input_resume(){
        Utils.delay(2);
        recruitmentPage.setFile("C:\\Users\\Lenovo Gk\\OneDrive\\Dokumen\\Bootcamp SQA B18\\resume.doc");
        extentTest.log(LogStatus.PASS,"Input resume");
    }

    @And("Fill in keywords")
    public void Fill_in_keywords(){
        Utils.delay(2);
        recruitmentPage.fillKeywords("example keywords");
        extentTest.log(LogStatus.PASS,"Fill in keywords");
    }

    @And("Select Date of Application")
    public void Select_Date_of_Application(){
        Utils.delay(2);
        recruitmentPage.fillDate();
        extentTest.log(LogStatus.PASS,"Select Date of Application");
    }


    @And("Fill in notes")
    public void Fill_in_notes(){
        Utils.delay(2);
        recruitmentPage.fillNotes("Example notes");
        extentTest.log(LogStatus.PASS,"Fill in notes");
    }

    @And("Click the checkbox consent to keep data")
    public void Click_the_checkbox_consent_to_keep_data(){
        Utils.delay(2);
        recruitmentPage.clickCheckboxAdd();
        extentTest.log(LogStatus.PASS,"Click the checkbox consent to keep data");
    }

    @And("Click the Save button")
    public void Click_the_Save_button(){
        Utils.delay(2);
        recruitmentPage.clickBtnSave();
        extentTest.log(LogStatus.PASS,"Click the Save button");
    }

    @Then("Data successfully added and entered the application stage")
    public void Data_successfully_added_and_entered_the_application_stage(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtApplicationStage(), "Application Stage");
        Assert.assertEquals(recruitmentPage.getTxtValName(), fullName);
        extentTest.log(LogStatus.PASS,"Data successfully added and entered the application stage");
    }


}
