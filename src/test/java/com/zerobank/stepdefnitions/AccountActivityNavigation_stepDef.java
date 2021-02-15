package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigation_stepDef {


    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitFor(3);

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.login(username,password);

        BrowserUtils.waitFor(3);

        HomePage homePage = new HomePage();
        homePage.clickOnlineBanking();
        BrowserUtils.waitFor(3);



    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {

        new HomePage().clickAccountSummary();
        BrowserUtils.waitFor(3);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.AccountSummary(link);


    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {

        String actualTitle = new HomePage().getPageTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String dropdownOpt) {

      String actual = new AccountSummaryPage().accountOptions(dropdownOpt);

      Assert.assertEquals(dropdownOpt,actual);



    }




}
