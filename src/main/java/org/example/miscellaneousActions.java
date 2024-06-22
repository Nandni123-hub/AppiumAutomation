package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class miscellaneousActions extends BaseClassTest
{
    public miscellaneousActions(AppiumDriver driver) {
        super(driver);
    }

    @Test
    public void wifiSettings() throws MalformedURLException{
        //code to start server
        //AndroidDriver, IOSDriver
        //Appium code -> Appium Server -> Mobile
        //ActualAutomation
        //locators->Xpath, id, AccessibilityId, classname, Android UIAutomation
        //tagname[@attribute='value]
        //tagname[@attribute='value]->//tagname
        //basetest();
        //
        Activity activity= new Activity("com.google.android.apps.nexuslauncher","com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        driver.startActivity(activity);
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landscape =new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alert=driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alert,"WiFi settings");
        //copy to clipboard- paste
        driver.setClipboardText("Nandni wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        //TearDown();
    }
}

