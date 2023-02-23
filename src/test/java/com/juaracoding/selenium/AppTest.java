package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //driver.get("http://google.com");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void inputTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.id("userName")).sendKeys("juaracoding");
        driver.findElement(By.id("userEmail")).sendKeys("juaracoding@gmail.co.id");
        driver.findElement(By.id("currentAddress")).sendKeys("Jl.juaracoding");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jalan. juaracoding");

        //scroll by pixel (vertical)
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void testTwo(){
        driver.findElement(By.id("item-1")).click();
        driver.findElement(By.xpath("//button[@title='Toggle']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']//*[name()='svg']")).click();
        String result = driver.findElement(By.xpath("//div[@id='result']")).getText();
        System.out.println(result);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
