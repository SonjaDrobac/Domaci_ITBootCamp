package Domaci_ITBootCamp.D_28.HerokuAppBase;

import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLoginPage;
import Domaci_ITBootCamp.D_28.HerokuAppPages.HerokuAppLogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class HerokuAppBaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String LoginURL;
    public HerokuAppLoginPage herokuAppLoginPage;
    public HerokuAppLogoutPage herokuAppLogoutPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/Domaci/D_28_Sonja_Drobac/HerokuApp/TestData.xlsx");
        LoginURL = excelReader.getStringData("URL", 1, 0);
    }
}
