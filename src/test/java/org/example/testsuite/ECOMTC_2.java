package org.example.testsuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class ECOMTC_2 extends BaseClassTest {
    AndroidDriver driver;

    public ECOMTC_2(AppiumDriver driver) {
        super(driver);
    }

    @BeforeMethod
    public void preSetup() throws MalformedURLException {
       formPage.setActivity();
        // run command to get pckg name
    }

    @Test
    public void FillForm_PositiveFlow() throws MalformedURLException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argenntina\"))")).click();
        driver.findElement(By.id("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Add TO CART'][1]"));
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Add TO CART'][1]"));
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    @Test
    public void FillForm_ErrorValidation() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argenntina\"))")).click();
        driver.findElement(By.id("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Add TO CART'][1]"));
       // driver.findElement(By.xpath("//android.widget.RadioButton[@text='Add TO CART'][1]"));
        //driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

         Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size()<1);
         //Assert.assertEquals(toast,"Please enter your name");
    }
}