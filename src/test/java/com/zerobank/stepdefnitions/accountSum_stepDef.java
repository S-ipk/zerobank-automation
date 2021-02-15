package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class accountSum_stepDef {

    @When("the user clicks on Account Summary on the online banking")
    public void the_user_clicks_on_Account_Summary_on_the_online_banking() {

        new HomePage().clickAccountSummary();
        BrowserUtils.waitForPageToLoad(5);

    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedList) {

        Assert.assertEquals(expectedList,new AccountSummaryPage().getAccountTypes());
    }

    @Then("Credit Accounts table must have following columns")
    public void credit_Accounts_table_must_have_following_columns(List<String> expectedList) {

      Assert.assertEquals(expectedList,new AccountSummaryPage().getCreditAccounts());

    }

    @When("the user clicks on Account Activity on the online banking")
    public void the_user_clicks_on_Account_Activity_on_the_online_banking() {

        new AccountActivityPage().clickAccountActivity();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedList) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.accounts.click();
        BrowserUtils.waitFor(3);

        Assert.assertEquals(expectedList,accountActivityPage.getAllaccounts());

    }

    @Then("transactions table should have following columns names")
    public void transactions_table_should_have_following_columns_names(List<String> expectedList) {

        Assert.assertEquals(expectedList,new AccountActivityPage().getTablesfromShowTrans());
    }


}
