package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSBaseTest{
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    @BeforeMethod
    public void basetest() throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE(3rd generation)");
        options.setApp("/Users/nandnisrivastava/Library/Developer/Xcode/DerivedData/UIKitCatalog-awuvgcsqbwfmqxgcmrvkbglfkahu/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        options.setPlatformVersion("17.4");
        // Appium-> webdriver Agent-> ios apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(200));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), (Capabilities) options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
    }
    public void swipeAction(WebElement ele,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
    public Double getFormattedAmount(String amount){
        Double amt=Double.parseDouble(amount.substring(1));
        return amt;
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
        service.stop();
    }
}
