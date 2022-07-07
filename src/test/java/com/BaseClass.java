package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver initialize_driver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }
}
