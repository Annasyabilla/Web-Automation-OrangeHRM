package com.orangehrmlive;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/28/2024 8:29 PM
@Last Modified 12/28/2024 8:29 PM
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
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class RecruitmentNegatifTest {
    private static final Logger log = LoggerFactory.getLogger(RecruitmentNegatifTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static DashboardPage dashboardpage = new DashboardPage();
    private static RecruitmentPage recruitmentPage = new RecruitmentPage();
    private static DataGenerator dataGenerator = new DataGenerator();

    public RecruitmentNegatifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @And("leave empty the first name field")
    public void leave_empty_the_first_name_field(){
        Utils.delay(2);
        recruitmentPage.clearFistName();
        recruitmentPage.fillFirstName(" ");
        extentTest.log(LogStatus.PASS,"leave empty the first name field");
    }

    @And("leave empty the middle name field")
    public void leave_empty_the_middle_name_field(){
        Utils.delay(2);
        recruitmentPage.clearMiddleName();
        recruitmentPage.fillMiddleName(" ");
        extentTest.log(LogStatus.PASS,"leave empty the middle name field");
    }

    @And("leave empty the last name field")
    public void leave_empty_the_last_name_field(){
        Utils.delay(2);
        recruitmentPage.clearLastName();
        recruitmentPage.fillLastName(" ");
        extentTest.log(LogStatus.PASS,"leave empty the last name field");
    }

    @And("leave empty the email")
    public void leave_empty_the_email(){
        Utils.delay(2);
        recruitmentPage.clearEmail();
        recruitmentPage.fillEmail(" ");
        extentTest.log(LogStatus.PASS,"leave empty the email");
    }

    @And("leave empty the contact number")
    public void leave_empty_the_contact_number(){
        Utils.delay(2);
        recruitmentPage.clearContactNumber();
        recruitmentPage.fillContactNumber(" ");
        extentTest.log(LogStatus.PASS,"leave empty the contact number");
    }

    @And("leave empty resume")
    public void leave_empty_resume(){
        Utils.delay(2);
        recruitmentPage.clearResume();
        recruitmentPage.setFile(" ");
        extentTest.log(LogStatus.PASS,"leave empty resume");
    }

    @And("leave empty keywords")
    public void leave_empty_keywords(){
        Utils.delay(2);
        recruitmentPage.clearKeywords();
        recruitmentPage.fillKeywords(" ");
        extentTest.log(LogStatus.PASS,"leave empty keywords");
    }

    @And("leave empty Date of Application")
    public void leave_empty_Date_of_Application(){
        Utils.delay(2);
        recruitmentPage.clearDate();
        extentTest.log(LogStatus.PASS,"leave empty Date of Application");
    }

    @And("leave empty notes")
    public void leave_empty_notes(){
        Utils.delay(2);
        recruitmentPage.clearNotes();
        recruitmentPage.fillNotes(" ");
        extentTest.log(LogStatus.PASS,"leave empty notes");
    }

    @Given("Fill in the email with invalid email")
    public void Fill_in_the_email_with_invalid_email(){
        Utils.delay(2);
        recruitmentPage.clearEmail();
        recruitmentPage.fillEmail(dataGenerator.dataNamaDepan());
        extentTest.log(LogStatus.PASS,"Fill in the email with invalid email");
    }

    @Given("Click cancel button")
    public void Click_cancel_button(){
        Utils.delay(2);
        recruitmentPage.clickBtnCancel();
        extentTest.log(LogStatus.PASS,"Click cancel button");
    }

    @Then("Data failed to be added and an alert appears saying required in the mandatory section")
    public void Data_failed_to_be_added_and_an_alert_appears_saying_required_in_the_mandatory_section(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtRequiredFirstName(),"Required");
        Assert.assertEquals(recruitmentPage.getTxtRequiredLastName(),"Required");
        Assert.assertEquals(recruitmentPage.getTxtRequiredEmail(),"Required");
        extentTest.log(LogStatus.PASS,"Data failed to be added and an alert appears saying required in the mandatory section");
    }

    @Then("Data failed to be added and an alert appears saying required in the first name section")
    public void Data_failed_to_be_added_and_an_alert_appears_saying_required_in_the_first_name_section(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtRequiredFirstName(),"Required");
        extentTest.log(LogStatus.PASS,"Data failed to be added and an alert appears saying required in the first name section");
    }

    @Then("Data failed to be added and an alert appears saying required in the last name section")
    public void Data_failed_to_be_added_and_an_alert_appears_saying_required_in_the_last_name_section(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtRequiredLastName(),"Required");
        extentTest.log(LogStatus.PASS,"Data failed to be added and an alert appears saying required in the last name section");
    }

    @Then("Data failed to be added and an alert appears saying required in the email section")
    public void Data_failed_to_be_added_and_an_alert_appears_saying_required_in_the_email_section(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtRequiredEmail(),"Required");
        extentTest.log(LogStatus.PASS,"Data failed to be added and an alert appears saying required in the email section");
    }

    @Then("Data failed to be added and an alert appears showing Expected format in the email section")
    public void Data_failed_to_be_added_and_an_alert_appears_showing_Expected_format_in_the_email_section(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtValInvalidEmail(),"Expected format: admin@example.com");
        extentTest.log(LogStatus.PASS,"Data failed to be added and an alert appears showing Expected format in the email section");

    }

    @Then("The system will return to the previous recruitment page")
    public void The_system_will_return_to_the_previous_recruitment_page(){
        Utils.delay(2);
        Assert.assertEquals(recruitmentPage.getTxtCandidate(),"Candidates");
        extentTest.log(LogStatus.PASS,"The system will return to the previous recruitment page");
    }

}
