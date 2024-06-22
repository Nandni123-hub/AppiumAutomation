package org.example;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class BaseClassTest extends AppiumUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    public BaseClassTest(AppiumDriver driver) {
        super(driver);
    }

    @BeforeMethod
    public void basetest() throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("NandniPhone");
        options.setChromedriverExecutable("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//chromedriver");
        options.setApp("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//ApiDemos-debug.apk");
        options.setApp("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//General-Store.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), (Capabilities) options);
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
