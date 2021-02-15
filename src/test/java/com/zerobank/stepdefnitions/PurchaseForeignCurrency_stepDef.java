package com.zerobank.stepdefnitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class PurchaseForeignCurrency_stepDef {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {

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
        BrowserUtils.waitForPageToLoad(5);
        new PayBillsPage().clickPurchaseForeignCurrency();
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(3);


    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrency){

       PayBillsPage payBillsPage = new PayBillsPage();
       payBillsPage.currencyOptions.click();

      Assert.assertEquals(expectedCurrency,payBillsPage.currencyOptions());
    }

    @When("user tries to calculate cost {string} without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency(String amount) {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.sendAmount(amount);

        BrowserUtils.waitFor(3);
        payBillsPage.selectedCurrency.click();
        BrowserUtils.waitFor(2);
        payBillsPage.calculateCosts.click();



    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        System.out.println(new PayBillsPage().popUpMessage());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.selectedCurrency.click();
        BrowserUtils.waitFor(3);
        payBillsPage.calculateCosts.click();


    }



}
