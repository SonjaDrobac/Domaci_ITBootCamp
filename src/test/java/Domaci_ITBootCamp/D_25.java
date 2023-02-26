package Domaci_ITBootCamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class D_25 {
    public static void main(String[] args) throws InterruptedException {

//        Ulogujte se na demoqa preko cookies-a,
//        dodati dve knjige na svoj nalog,
//        zatim se izlogovati brisanjem cookies-a.
//        Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();

        Cookie userID = new Cookie("userID", "eb890da0-36c8-4049-b24c-5211ada0db67");
        Cookie expires = new Cookie("expires", "2023-01-21T11%3A59%3A48.047Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkJvamFuYSIsInBhc3N3b3JkIjoiU29uamFCb2phbmFJdmFuYUAxMjMiLCJpYXQiOjE2NzM2OTc1ODh9.PB2mbgVIgAFvM13u0VefRQA9WucIn45zf8KZ-iBHsjA");

        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);
        driver.navigate().refresh();

        driver.get("https://demoqa.com/books");

        WebElement bookButton1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        bookButton1.click();
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addButton1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton1.click();
        driver.navigate().back();

        WebElement bookButton2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        bookButton2.click();
        Thread.sleep(2000);

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addButton2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton2.click();
        driver.navigate().back();

        driver.get("https://demoqa.com/profile");

        WebElement name = driver.findElement(By.id("userName-value"));
        String actualName = name.getText();
        String expectedName = "Bojana";
        Assert.assertEquals(actualName, expectedName);

        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1.isDisplayed());

        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2.isDisplayed());

        driver.manage().deleteCookieNamed("userID");
        driver.navigate().back();

        driver.get("https://demoqa.com/login");
        Thread.sleep(3000);

        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Bojana");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SonjaBojanaIvana@123");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement firstBook2 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(firstBook2.isDisplayed());

        WebElement secondBook2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(secondBook2.isDisplayed());
    }
}
