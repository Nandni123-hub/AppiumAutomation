package org.example.testsuite;
import PageObjectFactory.IOS.AlertViews;
import PageObjectFactory.IOS.HomePage;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOSBASICS extends IOSBaseClass{
    IOSDriver driver;
    public HomePage homePage;
    @Test
    public void iosBasicsTest(){
        AlertViews alertViews=homePage.clickAlertViews();
        alertViews.clickTextEntry();
        alertViews.enterText("Hello");
        alertViews.clickOk();
        alertViews.getMessage();
    }

}

