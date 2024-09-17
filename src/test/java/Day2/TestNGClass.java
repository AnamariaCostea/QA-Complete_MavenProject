package Day2;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestNGClass {
    @Test
    public void loginTest(){
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

        //1. Open browser
        //2. Navigate to https://juice-shop.herokuapp.com
        driver.get("https://juice-shop.herokuapp.com");

        //Dismiss Welcome popup
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();

        // 3. Access registration page
        // a. click Account button
        driver.findElement(By.xpath("//*[@id=\"navbarAccount\"]/span[1]/span")).click();

        //Click login button
        driver.findElement(By.xpath("//*[@id=\"navbarLoginButton\"]/span")).click();

        //Click register button
        driver.findElement(By.xpath("//*[@id=\"newCustomerLink\"]/a")).click();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-register/div/mat-card/h1")).getText(),"User Registration");
    }
}
