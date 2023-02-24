package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppFrame {
    private static WebDriver driver;
    private static WebElement frameSamplePage;
    private static JavascriptExecutor js;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        //frame
        frameSamplePage = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSamplePage);

        String txtFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtFrame);

        //keluar dari frame
        driver.switchTo().defaultContent();
        String textContent = driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 Iframes in this pag')]")).getText();
        System.out.println(textContent);

        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).click();
        //Small modal
        driver.findElement(By.xpath("//button[@id='showSmallModal']")).click();
        String textSmallModal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']")).getText();
        System.out.println(textSmallModal);
        driver.findElement(By.xpath("//button[@id='closeSmallModal']")).click();

        //Large modal
        driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();
        String textLargeModal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).getText();
        System.out.println(textLargeModal);
        driver.findElement(By.xpath("//button[@id='showSmallModal']"));




        Thread.sleep(3000);

        driver.quit();
    }
}
