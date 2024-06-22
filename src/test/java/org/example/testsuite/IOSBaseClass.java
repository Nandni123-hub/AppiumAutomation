package org.example.testsuite;
import Utils.AppiumUtils;

import PageObjectFactory.IOS.HomePage;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseClass extends AppiumUtils{
    public IOSDriver driver;
    public HomePage homePage;
    public AppiumDriverLocalService service;

    public IOSBaseClass(AppiumDriver driver) {
        super(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void basetest() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
        prop.load(file);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");

        startAppiumServer(ipAddress, Integer.parseInt(port));
        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setApp("/Users/nandnisrivastava/Library/Developer/Xcode/DerivedData/UIKitCatalog-awuvgcsqbwfmqxgcmrvkbglfkahu/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        options.setPlatformVersion("17.4");
        // Appium-> webdriver Agent-> ios apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(200));

        driver = new IOSDriver(service.getUrl(), (Capabilities) options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage=new HomePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void TearDown(){
        driver.quit();
        service.stop();
    }
}
