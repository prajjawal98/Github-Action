package testcase;

import com.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test extends BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws URISyntaxException, IOException {
        BaseClass bs= new BaseClass();
        driver = bs.initialize_driver();

        // now we enter our URL that we want to open in our
        // default browser
       // String cURL = driver.executeScript("return document.URL");
       // System.out.println("Current URL is : "+cURL);

       driver.get("https://demo.nopcommerce.com/");

    }

    @org.testng.annotations.Test
    public void loginTest1() throws InterruptedException
    {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("prajjawalkansal@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("testcase.Test@123");
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).submit();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");

    }

    @org.testng.annotations.Test
    public void loginTest2() throws InterruptedException {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("avadhsharma566@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("prajjawal1234");
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).submit();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
