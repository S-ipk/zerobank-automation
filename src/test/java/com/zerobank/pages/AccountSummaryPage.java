package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage{



    public void AccountSummary(String text){

        Driver.get().findElement(By.xpath("//a[.='"+text+"']")).click();

    }

    public String accountOptions(String text){

        Select dropdownElement = new Select(Driver.get().findElement(By.id("id = aa_accountId")));

        WebElement option = dropdownElement.getFirstSelectedOption();


        return option.getText();

    }

    public List<String> getAccountTypes(){

        List<WebElement> elements = Driver.get().findElements(By.cssSelector(".board-header"));

        List<String> actualList = new ArrayList<String>();

        for (WebElement element : elements) {

            String s =element.getText();
            actualList.add(s);
        }

        return actualList;
    }

    public  List<String> getCreditAccounts(){

        List<WebElement> elements = Driver.get().findElements(By.xpath("(//thead//tr)[3]//th"));

        List<String> actualList = new ArrayList<String>();

        for (WebElement element : elements) {

            String s =element.getText();
            actualList.add(s);
        }

        return actualList;


    }
}
