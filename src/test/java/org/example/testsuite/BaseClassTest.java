package org.example.testsuite;

import PageObjectFactory.android.FormPage;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class BaseClassTest extends AppiumUtils {
    public AndroidDriver driver;
    public FormPage formPage;
    public AppiumDriverLocalService service;

    public BaseClassTest(AppiumDriver driver) {
        super(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void basetest() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
        prop.load(file);
        String ipAddress = System.getProperty("ipAddress")!=null? System.getProperty("ipAddress"):prop.getProperty("ipAddress");// if I m getting IP from maven terminal then use that else use from properties file, checks during runtime
        String port = prop.getProperty("port");

        startAppiumServer(ipAddress, Integer.parseInt(port));
        //service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setChromedriverExecutable("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//chromedriver");
        options.setApp("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//ApiDemos-debug.apk");
        options.setApp("//Users//nandnisrivastava//IdeaProjects//AppiumAutomation//src//main//java//resources//General-Store.apk");

        driver = new AndroidDriver(service.getUrl(), (Capabilities) options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        formPage=new FormPage(driver);

    }
    @AfterMethod(alwaysRun = true)
    public void TearDown(){
        driver.quit();
        service.stop();
    }
}
