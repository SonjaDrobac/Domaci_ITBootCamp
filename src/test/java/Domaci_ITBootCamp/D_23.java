package Domaci_ITBootCamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class D_23 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.edgedriver().setup();
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        WebElement search = driver.findElement(By.className("gLFyf"));
        search.sendKeys("Youtube");
        search.sendKeys(Keys.ENTER);

        WebElement ytLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        ytLink.click();

        Thread.sleep(3000);

        WebElement ytSearch = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        ytSearch.sendKeys("Nirvana-man who sold the world");
        //ytSearch.sendKeys(Keys.ENTER);

        WebElement SearchButton = driver.findElement(By.id("search-icon-legacy"));
        SearchButton.click();

        Thread.sleep(3000);

        WebElement song = driver.findElement(By.cssSelector(".style-scope.ytd-video-renderer"));
        song.click();

    }
}
