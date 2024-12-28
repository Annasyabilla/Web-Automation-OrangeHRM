package com.orangehrmlive.scenariomapping;

public enum ScenarioTests {

    T1("Login With Invalid Username"),
    T2("Login With Invalid Password"),
    T3("Login With Blank Username and Password"),
    T4("Login With Valid Username and Password"),
    T5("Fill in candidate data with blank empty information"),
    T6("Leave empty the first name field"),
    T7("Leave empty the last name field"),
    T8("Leave empty the email field"),
    T9("Fill the email field with invalid email "),
    T10("Validation cancel button on the add recruitment form "),
    T11("Fill in candidate data with valid information");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
