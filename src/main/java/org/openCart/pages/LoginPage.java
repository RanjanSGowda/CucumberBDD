package org.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    // Applications locators
    private final By emailField = By.id("input-email");
    private final By passworField = By.id("input-password");
    private final By LoginBtn = By.cssSelector("input[type='submit']");
    private final By forgotPassword = By.linkText("Forgotten Password");
    private final By logoutLink = By.linkText("Logout");

    private final By warningMsg = By.xpath("//*[@id='account-login']/child::div[@class='alert alert-danger alert-dismissible']");

    private final By loginpage = By.xpath("//h2[contains(text(),'Returning Customer')]");

    private final By getForgotPassword = By.xpath("//input[@id='input-password']/following-sibling::a");

    // Page Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailField);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void loginpage() {
        driver.findElement(loginpage).isDisplayed();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passworField);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(LoginBtn);
        loginBtn.click();
    }

    public boolean forgotPasslink() {
        WebElement forgotlink = driver.findElement(forgotPassword);
        return forgotlink.isDisplayed();
    }

    public void clickForgotpasslink() {
        WebElement link = driver.findElement(forgotPassword);
        link.click();
    }

    public String forgotpassUrl() {
        String url = driver.getCurrentUrl();
        return url;

    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public void verfiyWarningMsg(String msg) {
        WebElement warningText = driver.findElement(warningMsg);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(warningText));
        String actual = warningText.getText();
        Assert.assertEquals(msg, actual, "Text mismatch");

    }

    public void logoutLink() {
        WebElement ele = driver.findElement(logoutLink);
        ele.isDisplayed();
    }

    public void verifyForgotPwdLink() {
        driver.findElement(getForgotPassword).isDisplayed();
    }

    public void clickForgotPassword() {
        WebElement ele = driver.findElement(getForgotPassword);
        ele.click();
    }

    public void forgotPwdPage()
    {
        driver.getCurrentUrl().contains("forgotten");
    }


}
