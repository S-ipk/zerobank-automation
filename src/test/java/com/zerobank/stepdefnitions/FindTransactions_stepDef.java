package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

public class FindTransactions_stepDef {

    public int _userFromDate;
    public int _userToDate;


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

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
        homePage.clickAccountActivity();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.clickFindTransactions();
        BrowserUtils.waitFor(3);
        accountActivityPage.dateRange(fromDate, toDate);

    }

    @When("clicks search")
    public void clicks_search() {

          BrowserUtils.waitFor(2);
          new AccountActivityPage().clickFindButton();
          new AccountActivityPage().clearAllBox();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        Assert.assertTrue(new AccountActivityPage().rangeOfTheDateInTheResult(fromDate,toDate));
        _userFromDate = Integer.parseInt(fromDate.replace("-",""));
        _userToDate = Integer.parseInt(toDate.replace("-",""));
    }


    @Then("the results should be sorted by most recent date")
    public void he_results_should_be_sorted_by_most_recent_date() {

        for (int i = 0; i < new AccountActivityPage().getDatesInTheResultAsInteger().size(); i++) {
            try {
                Assert.assertTrue(new AccountActivityPage().getDatesInTheResultAsInteger().get(i) > new AccountActivityPage().getDatesInTheResultAsInteger().get(i + 1));
            }catch (Exception e){}
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        int dateInteger = Integer.parseInt(string.replace("-",""));
        Assert.assertTrue(dateInteger> _userToDate || dateInteger< _userFromDate);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {

        new AccountActivityPage().descriptionBox.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        while (true) {
            try {
                for (String s :new AccountActivityPage().getAllDescriptionsFromTheResultsAsString()) {
                    Assert.assertTrue(s.contains(string));
                }
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }






}
