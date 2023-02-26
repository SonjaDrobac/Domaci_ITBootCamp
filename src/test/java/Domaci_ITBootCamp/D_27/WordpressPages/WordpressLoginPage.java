package Domaci_ITBootCamp.D_27.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLoginPage {

    public WebDriver driver;
    public WebDriverWait wdwait;




    WebElement emailField;

    WebElement continueButton;

    WebElement passwordField;

    WebElement profileName;

    public WordpressLoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getProfileName() {
        return driver.findElement(By.className("site__title"));
    }

    //--------------------------------------------------

    public void enterEmail (String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void clickOnContinueButton () {
        getContinueButton().click();
    }

   public void enterPassword (String password) {
        getPasswordField().sendKeys(password);
   }




}
