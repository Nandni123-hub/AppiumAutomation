package org.example;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class IOSSwipeTest extends IOSBaseTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub



        IOSDriver driver = DesiredCapabilities();
        //bundle id of App- ( installed in iphone)
        //com.apple.mobileslideshow

        HashMap<String,String> args1 =new HashMap<String,String>();
        args1.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", args1);
        driver.findElement(By.id("All Photos")).click();
        int photosCount = driver.findElements(By.xpath("//XCUIElementTypeCell")).size();
        System.out.println(photosCount);
        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
        System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));//to get timestamps
        for (int i =0;i<photosCount;i++)
        {

            HashMap<String,String> args2=new HashMap<String,String>();
            args2.put("direction", "left");
            driver.executeScript("mobile:swipe", args2);
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
        }
        driver.navigate().back();
        driver.findElement(By.id("Albums")).click();



        //	driver.resetInputState();
        //tear down - initial state





    }

    private static IOSDriver DesiredCapabilities() {
        return null;
    }


}

