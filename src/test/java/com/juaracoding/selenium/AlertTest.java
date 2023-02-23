package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @Test
    public void testSecond(){//Locator linkText
        driver.findElement(By.linkText("Gmail")).click();
    }

    @Test
    public void testFirst() throws InterruptedException { //Locator Name
        //alert default
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        System.out.println("Alert Ok Clicked");

        //Timer Alert
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        System.out.println("Timer Alert Ok Clicked");
        driver.close();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
