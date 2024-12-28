package com.orangehrmlive;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {
        "src/main/resources/features/001LoginNegatif.feature",
        "src/main/resources/features/002LoginPositif.feature",
        "src/main/resources/features/003RecruitmentNegatif.feature",
        "src/main/resources/features/004RecruitmentPositif.feature"
        },
        glue = "com.orangehrmlive",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
