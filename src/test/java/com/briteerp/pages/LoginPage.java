package com.briteerp.pages;

import com.briteerp.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {


    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = ".btn.btn-primary")
    public WebElement loginBtn;

    @FindBy(linkText = "Don't have an account?")
    public WebElement dontHaveAnAccountLink;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordLink;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessageElement;




    public void loginAsCrm(){
        emailInput.sendKeys(ConfigurationReader.get("crm_username"));
        passwordInput.sendKeys(ConfigurationReader.get("crm_password"));
        loginBtn.click();
        waitLoadingBar();
        waitLoadingBar();
    }

    /**
     * This method created for negative login tests
     * @param username
     * @param password
     */
    public void loginAs(String username,String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
      //  waitLoadingBar();
    }


    public void verifyLoginErrorMessage(String expectedMessaage){
        Assert.assertEquals(expectedMessaage,errorMessageElement.getText());
        Assert.assertTrue("Error Message is Displayed",errorMessageElement.isDisplayed());
    }





}
