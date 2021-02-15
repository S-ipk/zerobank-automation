package com.zerobank.stepdefnitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AddNewPayee_stepDef {

    @Given("Add a Payee tab")
    public void add_a_Payee_tab() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitFor(3);

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.login(username, password);

        BrowserUtils.waitFor(3);

        HomePage homePage = new HomePage();
        homePage.clickOnlineBanking();
        BrowserUtils.waitFor(3);
        homePage.clickPayBills();
        BrowserUtils.waitFor(3);
        new PayBillsPage().clickAddNewPayee();
        BrowserUtils.waitFor(3);


    }

    @Given("creates payee using following information")
    public void creates_payee_using_following_information(Map<String,String> newPayeeInfo) {

        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.payeeName.click();
        payBillsPage.payeeName.sendKeys(newPayeeInfo.get("Payee Name"));
        BrowserUtils.waitFor(3);


        payBillsPage.payeeAddress.click();
        payBillsPage.payeeAddress.sendKeys(newPayeeInfo.get("Payee Address"));
        BrowserUtils.waitFor(3);


        payBillsPage.account.click();
        payBillsPage.account.sendKeys(newPayeeInfo.get("Account"));
        BrowserUtils.waitFor(3);


        payBillsPage.payeeDetails.click();
        payBillsPage.payeeDetails.sendKeys(newPayeeInfo.get("Payee details"));
        BrowserUtils.waitFor(3);

        payBillsPage.submit.click();
        BrowserUtils.waitFor(3);

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created.should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

        BrowserUtils.verifyElementDisplayed(new PayBillsPage().submitMessage);

    }

}
