package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".icon-signin")
    public WebElement signinIcon;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(name ="submit")
    public WebElement submit;

    @FindBy(xpath = "//button[@id='primary-button']")
    public WebElement security;


    public void login(String usernameStr, String passwordStr) {

        signinIcon.click();

        if (!usernameStr.equals("username") && password.equals("password")) {
            System.out.println("Login and/or password are wrong.");
        } else if (usernameStr.isEmpty() || passwordStr.isEmpty()) {
            System.out.println("Login and/or password are wrong.");
        } else {
            username.sendKeys(usernameStr);
            password.sendKeys(passwordStr);
            submit.click();

            BrowserUtils.waitFor(3);

            security.click();
        }

    }

}
