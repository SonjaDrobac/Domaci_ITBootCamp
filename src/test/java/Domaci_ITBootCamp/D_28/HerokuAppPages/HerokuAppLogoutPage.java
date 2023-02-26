package Domaci_ITBootCamp.D_28.HerokuAppPages;

import Domaci_ITBootCamp.D_28.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLogoutPage extends HerokuAppBaseTest {
    public HerokuAppLogoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flash")
    public WebElement Notification;

    @FindBy (css = ".icon-2x.icon-signout")
    public  WebElement logOutButton;

    @FindBy (className = "subheader")
    public WebElement headerText;

    //-----------------------

    public String getNotificationText() {
        return Notification.getText();
    }

    public void clickOnLogOutButton () { logOutButton.click(); }

    public String getHeaderText () {return headerText.getText();}

}
