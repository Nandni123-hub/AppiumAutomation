package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class EcomTC_1 extends BaseClassTest {
    AndroidDriver driver;

    @Test
    public void FillForm() throws MalformedURLException{
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

        // String toast=driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
   // Assert.assertEquals(toast,"Please enter your name");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        int product=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for(int i=0;i<product;i++) {
//            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//                break;
//            }
//        }
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        //explicit wait
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        List<WebElement> price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count= price.size();
        Double sum=0.0;
        for (int i=0;i<count;i++){
            String amount1=price.get(i).getText();
            Double amt=Double.parseDouble(amount1.substring(1));
            sum=sum+amt;
        }
        String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double totalValue=getFormattedAmount(total);
        Assert.assertEquals(sum,totalValue);
        WebElement ele= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        String lastPageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//        Assert.assertEquals(lastPageProduct,"Jordan 6 Rings");
    }

}