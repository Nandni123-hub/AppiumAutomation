package org.example;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest{
    @Test
    public void iosBasicsTest(){
      //accessibility id ,id,xpath, classname, ios, iosClassChain ,IOSPredicateString
      driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
      driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
      driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
      driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello");
      driver.findElement(AppiumBy.accessibilityId("OK")).click();
      //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value=='Confirm / Cancel'")).click();
      driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND value BEGINSWITH[C] 'Confirm'")).click();
      String text=driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[C] 'A message'")).getText();
      System.out.println(text);
      driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
    }

}
