package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void Setup(){
        driver = new ChromeDriver();

    }

    @After
    public void Teardown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Given("i am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }
    @Given("i have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() throws InterruptedException {
        loginPage.enterEmail("zaza@mail.com");
        loginPage.enterPassword("tester@123");
        Thread.sleep(3000);

    }

    @Given("i have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {

        loginPage.enterEmail(username);
        loginPage.enterPassword(password);

    }
    @When("i click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickOnLoginButton();

    }
    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkForLogOutLink(),true);

    }

    @Then("i should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String error_message) {
       String message = loginPage.getErrorMessage();
       System.out.println(message);
      // Assert.assertTrue(message.contains(error_message));
       Assert.assertEquals(message,error_message);

//      boolean actual= loginPage.errorMessagePopUp();
//        Assert.assertEquals(actual,true);

    }

    @When("i click on the {string} link")
    public void iClickOnTheLink(String forgotten) {
        loginPage.clickOnForgottenPassword();
    }


    @Then("i should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {

        Assert.assertTrue(loginPage.getForgottenPasswordUrl().contains("account/forgotten"));

    }



}
