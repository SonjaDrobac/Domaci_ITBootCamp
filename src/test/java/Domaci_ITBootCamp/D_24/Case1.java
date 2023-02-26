package Domaci_ITBootCamp.D_24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class Case1 {

    //Test case name: Incorrect username, correct password

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement logIn= driver.findElement(By.partialLinkText("Test Login Page"));
        logIn.click();

        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("studen");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement error = driver.findElement(By.id("error"));
        String acctualTitle= error.getText();
        String expectedTitle= "Your username is invalid!";

        WebElement username1 = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));
        WebElement submitButton1 = driver.findElement(By.id("submit"));

        Assert.assertTrue(error.isDisplayed());
        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(password1.isDisplayed());
        Assert.assertTrue(submitButton1.isDisplayed());
    }
}
