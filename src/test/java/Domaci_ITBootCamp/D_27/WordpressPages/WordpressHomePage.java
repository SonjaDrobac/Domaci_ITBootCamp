package Domaci_ITBootCamp.D_27.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressHomePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement loginRedirect;

    public WordpressHomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLoginRedirect() {
        return driver.findElement(By.linkText("Log In"));
    }

    //---------------------------------------------
    public void clickOnloginRedirect () {
       getLoginRedirect().click();
    }
}
