package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;


public class PayBillsPage extends BasePage{

    @FindBy (xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy (css = "#np_new_payee_name")
    public WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(css = "#np_new_payee_account" )
    public WebElement account;

    @FindBy (css = "#np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy (css = "#add_new_payee")
    public WebElement submit;

    @FindBy (xpath = "//div[@id='alert_content']")
    public WebElement submitMessage;

    @FindBy (xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(css ="#pc_currency" )
    public WebElement  currencyOptions;

    @FindBy(css = "#pc_amount")
    public WebElement amountBox;

    @FindBy(css = "#pc_inDollars_false")
    public WebElement selectedCurrency;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateCosts;

    public void clickAddNewPayee(){

        addNewPayee.click();
    }

    public  void  clickPurchaseForeignCurrency(){

        purchaseForeignCurrency.click();

    }



    public List<String> currencyOptions(){

        Select dropdown = new Select(currencyOptions);

        List<WebElement> options = dropdown.getOptions();

        List<String> dropdownAll = new ArrayList<String>();

        for (int i = 1; i < options.size(); i++) {

          String st = options.get(i).getText();

          dropdownAll.add(st);

        }

        return dropdownAll;
    }

    public void sendAmount(String amount){

        amountBox.click();
        BrowserUtils.waitFor(2);
        amountBox.sendKeys(amount);


    }

    public String popUpMessage(){

        Alert message = Driver.get().switchTo().alert();

        String getMessage = message.getText();

        return getMessage;


    }
}
