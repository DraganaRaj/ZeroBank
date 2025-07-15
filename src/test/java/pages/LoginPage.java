package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By signInButtonHome = By.id("signin_button");
    private By usernameField = By.id("user_login");
    private By passwordField = By.id("user_password");
    private By signInButton = By.name("submit");
    private By errorMessage = By.cssSelector(".alert-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginForm() {
        driver.findElement(signInButtonHome).click();
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginSuccessful() {
        return driver.getPageSource().contains("Account Summary")
                || driver.getCurrentUrl().contains("account-summary");
    }
}
