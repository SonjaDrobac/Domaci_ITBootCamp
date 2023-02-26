package Domaci_ITBootCamp.D_28.HerokuAppPages;

import Domaci_ITBootCamp.D_28.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLoginPage extends HerokuAppBaseTest {
    public HerokuAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LogInButton;

    @FindBy (className = "subheader")
    public WebElement headerText;

    @FindBy (id = "flash-messages")
    public WebElement notLogedInNotification;

    //----------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void inserPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickOnLogInButton() {
        LogInButton.click();
    }

    public String logInPageNotification () {
        return headerText.getText();
    }

    public String getNotLogedInNotification () { return notLogedInNotification.getText(); }

}
