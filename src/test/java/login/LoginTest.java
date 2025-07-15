package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.openLoginForm();
        login.login("username", "password");
        Assert.assertFalse(login.isLoginSuccessful(), "Login should be successful.");
    }


    @Test
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.openLoginForm();
        login.login("wronguser", "wrongpass");
        Assert.assertTrue(login.getErrorMessage().contains("Login and/or password are wrong"),
                "Should show error for invalid credentials.");
    }

    @Test
    public void emptyFieldsLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.openLoginForm();
        login.login("", "");
        Assert.assertTrue(login.getErrorMessage().contains("Login and/or password are wrong"),
                "Should show error for empty fields.");
    }

    @Test
    public void loginWithUsernameOnlyTest() {
        LoginPage login = new LoginPage(driver);
        login.openLoginForm();
        login.login("username", "");
        Assert.assertTrue(login.getErrorMessage().contains("Login and/or password are wrong"),
                "Should show error when password is missing.");
    }

    @Test
    public void loginWithPasswordOnlyTest() {
        LoginPage login = new LoginPage(driver);
        login.openLoginForm();
        login.login("", "password");
        Assert.assertTrue(login.getErrorMessage().contains("Login and/or password are wrong"),
                "Should show error when username is missing.");
    }
}
