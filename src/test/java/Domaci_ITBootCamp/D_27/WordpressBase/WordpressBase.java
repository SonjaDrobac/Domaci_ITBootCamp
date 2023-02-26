package Domaci_ITBootCamp.D_27.WordpressBase;

import Domaci_ITBootCamp.D_27.WordpressPages.WordpressHomePage;
import Domaci_ITBootCamp.D_27.WordpressPages.WordpressLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordpressBase {

    public WebDriver driver;
    public WebDriverWait wdwait;


    public WordpressLoginPage wordpressLoginPage;
    public WordpressHomePage wordpressHomePage;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wordpressLoginPage = new WordpressLoginPage(driver, wdwait);
        wordpressHomePage = new WordpressHomePage(driver,wdwait);
    }


}
