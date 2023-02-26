package Domaci_ITBootCamp.D_28.HerokuAppTests;

import Domaci_ITBootCamp.D_28.HerokuAppBase.HerokuAppBaseTest;
import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLoginPage;
import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLogoutTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp () {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test
    public void userCanLogOut() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        herokuAppLogoutPage.clickOnLogOutButton();

        Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
        Assert.assertTrue(herokuAppLoginPage.Username.isDisplayed());
        Assert.assertEquals(herokuAppLoginPage.logInPageNotification(), "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.");
    }

}
