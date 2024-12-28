package com.orangehrmlive.pages;
/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author Lenovo Gk a.k.a. Anna Syabilla
Java Developer
Created on 12/27/2024 11:29 PM
@Last Modified 12/27/2024 11:29 PM
Version 1.0
*/

import com.orangehrmlive.drivers.DriverSingleton;
import com.orangehrmlive.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RecruitmentPage {
    private WebDriver driver;

    public RecruitmentPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;
    public void clickAdd() {
        btnAdd.click();
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement fieldFirstName;
    public void fillFirstName(String firstName) {
        this.fieldFirstName.sendKeys(firstName);
    }
    public void clearFistName(){
        fieldFirstName.clear();
    }

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    private WebElement fieldMiddleName;
    public void fillMiddleName(String middleName) {
        this.fieldMiddleName.sendKeys(middleName);
    }
    public void clearMiddleName(){
            fieldMiddleName.clear();
    }

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement fieldLastName;
    public void fillLastName(String lastName) {
        this.fieldLastName.sendKeys(lastName);
    }
    public void clearLastName(){
        fieldLastName.click();
        fieldLastName.sendKeys(Keys.CONTROL + "a"); // Pilih semua teks
        fieldLastName.sendKeys(Keys.DELETE);
        fieldLastName.clear();
    }


    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement selectVacancy;
//    public void selectVacancy() {
//        this.selectVacancy.click();
//        this.selectVacancy.sendKeys(Keys.DOWN);
//        this.selectVacancy.sendKeys(Keys.DOWN);
//        this.selectVacancy.sendKeys(Keys.ENTER);
//    }

    public void selectVacancy() {
        Random random = new Random();
        int ran = random.nextInt(0,5) + 1;

        selectVacancy.click();
        while (true) {
            if (selectVacancy != null) {
                for (int i = 0; i <= ran; i++) {
                    selectVacancy.sendKeys(Keys.DOWN);
                    if (i == ran) {
                        selectVacancy.sendKeys(Keys.ENTER);
                        break;
                    }
                }
                break;
            }

        }
    }


//    @FindBy(xpath = "(//input[@placeholder=\"Type here\"])[1]")
//    private WebElement email;
    @FindBy(xpath = "//div[3]/div/div/div/div[2]/input")
    private WebElement fieldEmail;
    public void fillEmail(String email){
        this.fieldEmail.sendKeys(email);
    }
    public void clearEmail(){
        fieldEmail.click();
        fieldEmail.sendKeys(Keys.CONTROL + "a"); // Pilih semua teks
        fieldEmail.sendKeys(Keys.DELETE);
        fieldEmail.clear();
    }

    //div[3]/div/div[2]/div/div[2]/input
    @FindBy(xpath = "//div[3]/div/div[2]/div/div[2]/input")
    private WebElement fieldContactNumber;
    public void fillContactNumber(String contactNumber){
        this.fieldContactNumber.sendKeys(contactNumber);
    }
    public void clearContactNumber(){
        fieldContactNumber.clear();
    }


    @FindBy(xpath = "//input[@type='file']")
    private WebElement btnResume;
    public void setFile(String resume){
        this.btnResume.sendKeys(resume);
    }
    public void clearResume(){
        btnResume.clear();
    }

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    private WebElement fieldKeywords;
    public void fillKeywords(String keywords){
        this.fieldKeywords.sendKeys(keywords);
    }
    public void clearKeywords(){
        fieldKeywords.clear();
    }


    //input[@placeholder='yyyy-dd-mm']
    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    private WebElement selectDate;
    public void fillDate(){
        LocalDate randomDate = getRandomDate(2023 , 2024); // Rentang tahun: 2020-2025
        String formattedDate = randomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        selectDate.click();
        selectDate.clear();
        selectDate.sendKeys(Keys.CONTROL + "a"); // Pilih semua teks
        selectDate.sendKeys(Keys.DELETE);
        selectDate.sendKeys(formattedDate);

    }
    // Fungsi untuk menghasilkan tanggal acak
    private LocalDate getRandomDate(int startYear, int endYear) {
        long startEpochDay = LocalDate.of(startYear, 1, 1).toEpochDay();
        long endEpochDay = LocalDate.of(endYear, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
    public void clearDate(){
        selectDate.click();
        selectDate.clear();
        selectDate.sendKeys(Keys.CONTROL + "a"); // Pilih semua teks
        selectDate.sendKeys(Keys.DELETE);
    }

    //textarea[@placeholder='Type here']
    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    private WebElement fieldNotes;
    public void fillNotes(String notes){
        this.fieldNotes.sendKeys(notes);
    }
    public void clearNotes(){
        fieldNotes.clear();
    }


    //i[@class='oxd-icon bi-check oxd-checkbox-input-icon']
    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    private WebElement checkboxAdd;
    public void clickCheckboxAdd(){
        checkboxAdd.click();
    }


    //button[@type='submit']
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;
    public void clickBtnSave(){
        btnSave.click();
    }


    //validasi

//*[@id="app"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[1]/div/div[2]
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[1]/div/div[2]")
    private WebElement txtValName;
    public String getTxtValName(){
        return txtValName.getText();
    }

    //p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']]")
    private WebElement valSucces;
    public String getValSucces(){
        return valSucces.getText();

    }
    @FindBy(xpath = "//h6[normalize-space()='Application Stage']")
    private WebElement txtApplicatinStage;
    public String getTxtApplicationStage(){
        return txtApplicatinStage.getText();
    }

    //div[@class='oxd-input-group']//div[1]//span[1]
    @FindBy(xpath = "//div[@class='oxd-input-group']//div[1]//span[1]")
    private WebElement txtRequiredFirstName;
    public String getTxtRequiredFirstName(){
        return txtRequiredFirstName.getText();
    }
    //div[@class='oxd-form-row']//div[3]//span[1]
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[3]//span[1]")
    private WebElement txtRequiredLastName;
    public String getTxtRequiredLastName(){
        return txtRequiredLastName.getText();
    }

    //div[@class='oxd-grid-3 orangehrm-full-width-grid']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']
    @FindBy(xpath = " //div[@class='oxd-grid-3 orangehrm-full-width-grid']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']")
    private WebElement txtRequiredEmail;
    public String getTxtRequiredEmail(){
        return txtRequiredEmail.getText();
    }

    //span[normalize-space()='Expected format: admin@example.com']
    @FindBy(xpath = "//span[normalize-space()='Expected format: admin@example.com']")
    private WebElement txtValInvalidEmail;
    public String getTxtValInvalidEmail(){
        return txtValInvalidEmail.getText();
    }

    //button[normalize-space()='Cancel']
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement btnCancel;
    public void clickBtnCancel(){
        btnCancel.click();
    }

    //h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    private WebElement txtCandidate;
    public String getTxtCandidate(){
        return txtCandidate.getText();
    }
}
