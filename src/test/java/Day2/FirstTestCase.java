package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    public static void main(String[] args) {
        System.out.println("Test");

        //TestName - Create Account
        // 1. Open browser
        // 2. Navigate to https://juice-shop.herokuapp.com
        // 3. Access registration page
        // 4. Complete all mandatory fields
        // 5. Click Register button

        //Create the driver instance
        //Add arguments to disable search engine choice
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        //Maximize browser screen
        driver.manage().window().maximize();
        //Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1. Open browser
        // 2. Navigate to https://juice-shop.herokuapp.com
        driver.get("https://juice-shop.herokuapp.com");

        //Dismiss Welcome popup
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();

        // 3. Access registration page
        // a. click Account button
        driver.findElement(By.xpath("//*[@id=\"navbarAccount\"]/span[1]/span")).click();

        // Click login button
        driver.findElement(By.xpath("//*[@id=\"navbarLoginButton\"]/span")).click();

        //Thread.sleep(5000); //do not use!

        //Wait for element to be visible
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //WebElement element = wait.until(
        //ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"newCustomerLink\"]/a")));

        //Wait for element to be invisible
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Boolean element = wait.until(

        //Wait for element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean element = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"newCustomerLink\"]/a")));

        //Click register button
        driver.findElement(By.xpath("//*[@id=\"newCustomerLink\"]/a")).click();

    }
}
