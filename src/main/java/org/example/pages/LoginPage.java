package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Locators

    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
    private By forgottenLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");

    private By errorMessagePopUpLocator = By.cssSelector(".alert.alert-danger.alert-dismissible");

    // Construct

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

   // Public Methods

    public void enterEmail  (String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword (String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickOnLoginButton (){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public void clickOnForgottenPassword (){
        WebElement forgottenPassword = driver.findElement(forgottenLinkLocator);
        forgottenPassword.click();
    }

    public void clickLogOut (){
        WebElement logOut = driver.findElement(logoutLinkLocator);
        logOut.click();
    }

    public boolean checkForForgottenPasswordLink (){
        return driver.findElement(forgottenLinkLocator).isDisplayed();
    }

    public boolean checkForLogOutLink (){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login (String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getForgottenPasswordUrl (){
        String forgottenUrl = driver.getCurrentUrl();
        return forgottenUrl;
    }

    public boolean errorMessagePopUp (){
        return driver.findElement(errorMessagePopUpLocator).isDisplayed();
    }

    public String getErrorMessage () {
       String errorMessage = driver.findElement(errorMessagePopUpLocator).getText();

       return errorMessage;

    }



}
