package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
    @Test //selenium
    public void mobileBrowserTest() {
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());
//        driver.findElement(By.name("q")).sendKeys("hello");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
         driver.get("https://www.google.com");
         driver.findElement((By.xpath("//span[@class='navbar-toggler-icon']"))).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
        String text= driver.findElement(By.cssSelector("a[href*='products/3']")).getText();// * is regular expression for partial search
        Assert.assertEquals(text,"devops");



    }
}
