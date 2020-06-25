package com.briteerp.pages;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "o_searchview_input'")
    public WebElement searchBox;

    @FindBy(className = "oe_topbar_name")
    public WebElement userNameBtn;

    @FindBy(css = "a[data-menu='settings'")
    public WebElement preferencesBtn;

    @FindBy(css = "a[data-menu='logout'")
    public WebElement logoutBtn;

    @FindBy(css = "[title='Advanced Search...']")
    WebElement advancedSearchBtn;

    @FindBy(css = ".fa.fa-filter")
    WebElement searchFilterBtn;

    @FindBy(css = ".fa.fa-bars")
    WebElement searchGroupByBtn;

    @FindBy(css = ".fa.fa-star")
    WebElement searchFavoriteBtn;

    @FindBy(css = ".fa.fa-comments")
    WebElement conversationsBtn;

    @FindBy(css = ".fa.fa-clock-o")
    WebElement activitiesBtn;

    @FindBy(css = ".o_loading")
    public WebElement loadingBar;

    @FindBy(css = "ul li[class='active']")
    public WebElement activePage;




    /**
     * This method navigate to given pages and wait for loading bar
     * @param page
     */

    public void navigateToPage(String page){
        Driver.get().findElement(By.xpath("//nav[@class='navbar navbar-inverse']//span[contains(text(),'"+page+"')]")).click();
        waitLoadingBar();
    }

    /**
     * This method wait for invisible of Loading bar When navigating another page
     */
    public void waitLoadingBar() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
    }

    /**
     * This method verify that Active/Selected page is @param page
     * @param expectedPage
     */
    public void verifyPageIsDisplay(String expectedPage){
        Assert.assertEquals("Active Page is "+expectedPage+"",expectedPage,activePage.getText().trim());
    }


    /**
     *
     */
    public void getLogout() {
        userNameBtn.click();
        logoutBtn.click();
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userNameBtn.getText();
    }

    /**
     *
     */
    public void getPreferences() {
        userNameBtn.click();
        preferencesBtn.click();
    }


}
