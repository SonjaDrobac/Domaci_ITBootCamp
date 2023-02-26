package Domaci_ITBootCamp.D_28.HerokuAppTests;

import Domaci_ITBootCamp.D_28.HerokuAppBase.HerokuAppBaseTest;
import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLoginPage;
import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority =10 )
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertTrue(herokuAppLogoutPage.logOutButton.isDisplayed());
        Assert.assertEquals(herokuAppLogoutPage.getHeaderText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {

        for (int i= 1; i< excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);

            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.inserPassword(validPassword);
            herokuAppLoginPage.clickOnLogInButton();

            Assert.assertEquals(herokuAppLoginPage.getNotLogedInNotification(), "Your username is invalid!\n" + "×");
            Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
            Assert.assertTrue(herokuAppLoginPage.Username.isDisplayed());
        }

    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {

        for (int i= 1; i< excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i, 3);

            herokuAppLoginPage.insertUsername(validUsername);
            herokuAppLoginPage.inserPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();

            Assert.assertEquals(herokuAppLoginPage.getNotLogedInNotification(), "Your password is invalid!\n" + "×");
            Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
            Assert.assertTrue(herokuAppLoginPage.Username.isDisplayed());
        }

    }

    @Test(priority =40 )
    public void userCannotLoginWithBlankUsername() {
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLoginPage.getNotLogedInNotification(), "Your username is invalid!\n" + "×");
        Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
        Assert.assertTrue(herokuAppLoginPage.Username.isDisplayed());
    }

    @Test (priority =50 )
    public void userCannotLoginWithBlankPassword() {
        String validUsername = excelReader.getStringData("Login", 1, 0);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.clickOnLogInButton();

        Assert.assertEquals(herokuAppLoginPage.getNotLogedInNotification(), "Your password is invalid!\n" + "×");
        Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
        Assert.assertTrue(herokuAppLoginPage.Username.isDisplayed());
    }

    @AfterClass
    public void refresh () {
        driver.navigate().refresh();
    }




}
