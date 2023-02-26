package Domaci_ITBootCamp.D_27.WordpressLoginTest;

import Domaci_ITBootCamp.D_27.WordpressBase.WordpressBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WordpressLoginTest extends WordpressBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");
    }

    String validEmail= "sonjadrobac13@gmail.com";
    String validPassword= "SonjaBojanaIvana@123";

    @Test
    public void userCanLogIn() throws InterruptedException {
        wordpressHomePage.clickOnloginRedirect();
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));
        wordpressLoginPage.enterEmail(validEmail);
        wordpressLoginPage.clickOnContinueButton();
        wdwait.until(ExpectedConditions.elementToBeClickable(wordpressLoginPage.getPasswordField()));
        wordpressLoginPage.enterPassword(validPassword);
        wordpressLoginPage.clickOnContinueButton();


    }


}
