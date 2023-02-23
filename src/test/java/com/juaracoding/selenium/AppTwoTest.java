package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppTwoTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("http://google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testSecond(){//Locator linkText
        driver.findElement(By.linkText("Gmail")).click();
    }

    @Test
    public void testFirst() throws InterruptedException { //Locator Name
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Berhasil klik submit");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
