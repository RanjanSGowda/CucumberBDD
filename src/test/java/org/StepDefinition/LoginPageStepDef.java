package org.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openCart.pages.LoginPage;

import static connectors.Hooks.driver;

public class LoginPageStepDef {

    public LoginPage loginPage;

    public LoginPageStepDef() {
        loginPage = new LoginPage(driver);
    }

    @Given("User is on the Login page")
    public void loginPage() {
        loginPage.loginpage();
    }

    @When("User enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
        loginPage.enterEmail("ranjangowda360@gmail.com");
        loginPage.enterPassword("Ranjan@123");
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        loginPage.logoutLink();
    }


    @When("User enters a invalid {string} and {string}")
    public void user_enters_a_invalid_and(String email, String password) {
        loginPage.login(email, password);

    }

    @Then("User should be see {string}")
    public void user_should_be_see(String warningMsg) {
        loginPage.verfiyWarningMsg(warningMsg);

    }

    @When("User verifies the Forgot password")
    public void user_verifies_the_forgot_password() {
        loginPage.verifyForgotPwdLink();
    }

    @When("User clicks on Forgot Password link")
    public void user_clicks_on_forgot_password_link() {
        loginPage.clickForgotPassword();
    }

    @Then("User should navigate to Forgot password page")
    public void user_should_navigate_to_forgot_password_page() {
        loginPage.forgotPwdPage();

    }

}
