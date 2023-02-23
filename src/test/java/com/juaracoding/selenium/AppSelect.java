package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppSelect {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
    }

    @Test
    public void testSecond(){
        WebElement selectColor = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select color = new Select(selectColor);
        color.selectByValue("5");
        color.selectByIndex(5);
        color.selectByVisibleText("Black");
    }

    @Test
    public void testFirst() throws InterruptedException { //Locator Name

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
