package com.zerobank.pages;

import com.zerobank.utilities.Driver;
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

    @FindBy (xpath = "//strong[.='Online Banking']")
    public WebElement onlineBanking;

    @FindBy (xpath = "//span[@id='account_summary_link']")
    public WebElement accountSummary;

    @FindBy (css = "#account_activity_link")
    public WebElement accountActivity;

    @FindBy (css =" #pay_bills_link")
    public WebElement payBills;


    // clicks on online banking

    public void clickOnlineBanking(){

        onlineBanking.click();
    }

    //clicks on accountSummary
    public  void clickAccountSummary(){

        accountSummary.click();
    }

    //clicks on Account Activity
    public  void  clickAccountActivity(){

        accountActivity.click();
    }

    //clicks on Pay Bills
    public  void  clickPayBills(){

        payBills.click();
    }

    //prints the title of page
    public String getPageTitle(){

        return Driver.get().getTitle();
    }



}
