package com.briteerp.stepdefinitions;

import com.briteerp.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("the user logged in")
    public void the_user_logged_in() {
      loginPage.loginAsCrm();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
        loginPage.verifyPageIsDisplay(page);
    }




}
