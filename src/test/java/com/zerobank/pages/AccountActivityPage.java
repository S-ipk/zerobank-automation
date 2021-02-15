package com.zerobank.pages;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy (xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    //dates from
    @FindBy (css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    public  WebElement toDate;

    @FindBy(id = "aa_accountId")
    public WebElement accounts;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(id = "aa_fromDate")
    public WebElement datesBox_From;

    @FindBy(id = "aa_toDate")
    public WebElement datesBox_To;

    @FindBy(xpath = "(//tbody)[1]//tr")
    public WebElement datesofTrans;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> datesInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> descriptionsInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> depositsInTheResult;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> withdrawalsInTheResult;



    //click Find Transactions
    public void clickFindTransactions(){

        findTransactions.click();
    }

    public void dateRange(String date1, String date2){

        fromDate.click();
        fromDate.sendKeys(date1);
        BrowserUtils.waitFor(3);
        toDate.click();
        toDate.sendKeys(date2);
    }

    public List<String> getAllaccounts(){

        Select dropdownElement = new Select(Driver.get().findElement(By.id("aa_accountId")));

        List<WebElement> options = dropdownElement.getOptions();

        List<String> actualList = new ArrayList<String>();

        for (WebElement option : options) {

            String s = option.getText();
            actualList.add(s);
        }

        return actualList;
    }

    public List<String> getTablesfromShowTrans(){

        List<WebElement> elements = Driver.get().findElements(By.xpath("//thead//th"));

        List<String> actualList = new ArrayList<String>();

        for (WebElement element : elements) {

            String s =  element.getText();
            actualList.add(s);
        }

        return actualList;

    }

    public void clickFindButton(){


        findButton.click();

    }

    public void clearAllBox(){
        descriptionBox.clear();
        datesBox_From.clear();
        datesBox_To.clear();
    }

    public boolean rangeOfTheDateInTheResult(String from, String to) {
        String[] from_ = from.split("-");
        String[] to_ = to.split("-");

        String fromDate = "";
        String toDate = "";

        for (String s : from_) {
            fromDate+=s;
        }
        for (String s : to_) {
            toDate+=s;
        }

        int fromDateInt = Integer.parseInt(fromDate);
        int toDateInt = Integer.parseInt(toDate);

        List<Integer> resultDatesInt = new ArrayList<>();
        while (true){
            try {

                for (WebElement webElement : datesInTheResult) {
                    String str = "";
                    for (int i = 0; i < webElement.getText().length(); i++) {
                        if (Character.isDigit(webElement.getText().charAt(i))) {
                            str += webElement.getText().charAt(i);
                        }
                    }
                    resultDatesInt.add(Integer.parseInt(str));
                }
                break;
            }catch (StaleElementReferenceException e){

            }
        }

        for (Integer integer : resultDatesInt) {
            if (integer>toDateInt || integer<fromDateInt){
                return false;
            }else {
                return true;
            }
        }






        return false;
    }

    public List<Integer> getDatesInTheResultAsInteger(){
        ArrayList<String> dates = new ArrayList<>();
        for (WebElement webElement : datesInTheResult) {
            dates.add(webElement.getText().replace("-",""));
        }
        ArrayList<Integer> datesInt = new ArrayList<>();
        for (String date : dates) {
            datesInt.add(Integer.parseInt(date));
        }
        return datesInt;
    }


    public List<String> getAllDescriptionsFromTheResultsAsString(){

        List<String> strList = new ArrayList<>();
        for (WebElement webElement : descriptionsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }

    public List<String> getAllDepositsFromTheResultAsString(){
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : depositsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }

    public List<String> getAllWithdrawalsFromTheResultAsString(){
        List<String> strList = new ArrayList<>();
        for (WebElement webElement : withdrawalsInTheResult) {
            strList.add(webElement.getText());
        }
        return strList;
    }


}
