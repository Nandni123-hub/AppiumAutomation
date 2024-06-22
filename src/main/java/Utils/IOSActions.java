package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtils{
    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void longPressAction(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) ele).getId());
        params.put("duration", 5.0);
        driver.executeScript("mobile: touchAndHold", params);
    }

    public void swipeAction(WebElement ele, String direction) {
        HashMap<String,String> args2=new HashMap<String,String>();
        args2.put("direction", "left");
        driver.executeScript("mobile:swipe", args2);
    }

    public void scrollWebElement(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement) ele).getId());
        driver.executeScript("mobile: scroll", params);
    }

}
