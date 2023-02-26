package Domaci_ITBootCamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class D_26 {
    WebDriver driver;

    @BeforeClass
    public void pageSetUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();

    }

    String usuername = "Mara";
    String password = "Mara@123";

    @BeforeMethod
    public void logIn() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys(username);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement booksMesage = driver.findElement(By.className("rt-noData"));
        String actualeMesage= booksMesage.getText();
        String expectedMesage = "No rows found";
        Assert.assertEquals(actualeMesage, expectedMesage);
    }

    @Test
    public void addOneBook () throws InterruptedException {
        driver.get("https://demoqa.com/books");
        WebElement bookButton1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        bookButton1.click();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addButton1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton1.click();
        driver.navigate().back();

        driver.get("https://demoqa.com/profile");
        WebElement name = driver.findElement(By.id("userName-value"));
        String actualName = name.getText();
        Assert.assertEquals(actualName, usuername);
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1.isDisplayed());
    }

    @Test
    public void addTwoBooks () throws InterruptedException {
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
        Assert.assertEquals(actualName, usuername);
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1.isDisplayed());
        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2.isDisplayed());
    }

    @Test
    public void addThreeBooks () throws InterruptedException {
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

        WebElement bookButton3 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        bookButton3.click();
        Thread.sleep(2000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addButton3 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton3.click();
        driver.navigate().back();

        driver.get("https://demoqa.com/profile");

        WebElement name = driver.findElement(By.id("userName-value"));
        String actualName = name.getText();
        Assert.assertEquals(actualName, usuername);
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1.isDisplayed());
        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2.isDisplayed());
        WebElement book3 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2.isDisplayed());
    }

    @AfterMethod
    public void logOut() throws InterruptedException {
        driver.get("https://demoqa.com/profile");

        List<WebElement> deleteAllButton = driver.findElements(By.id("submit"));
        for (int i = 0; i<deleteAllButton.size(); i++) {
            if (deleteAllButton.get(i).getText().equals("Delete All Books")) {
                JavascriptExecutor js3 = (JavascriptExecutor) driver;
                js3.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                deleteAllButton.get(i).click();
                break;
            }
        }

        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();
        driver.navigate().back();

        driver.manage().deleteCookieNamed("userID");
        driver.navigate().back();

        driver.get("https://demoqa.com/login");
        Thread.sleep(3000);
        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
        Thread.sleep(2000);
    }

        @AfterClass
        public void close () {
        driver.close();
    }






}
