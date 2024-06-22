package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import Object mapper
import java.io.IOException;

import java.io.File;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {
    public AppiumDriverLocalService service;
    AppiumDriver driver;
    public AppiumUtils(AppiumDriver driver) {
        this.driver = driver;

    }
    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;
    }

    public Double getFormattedAmount(String amount) {
        Double amt = Double.parseDouble(amount.substring(1));
        return amt;
}
    public List<HashMap<String ,String>> getJsonData(String jsonFilePath) throws IOException {
        //convert json to json string
        String jsonContent= FileUtils.readFileToString(new File(jsonFilePath,"UTF-8"));
        ObjectMapper mapper=new ObjectMapper();
        //convert json string to hashmap
        List<HashMap<String,String>> data= mapper.readValue(jsonContent, new
                TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }
   public void waitforElementToAppear(WebElement ele,AppiumDriver driver){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
    }
    public String getScreenshotpath(String testCseName ,AppiumDriver  driver) throws IOException {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        String destination = System.setProperty("user.dir"+testCaseName + ".png");
        FileUtils.copyFile(srcFile, new File(destination));
        return destination;
        // 1. capure and place in folder ,2. extent report pick file and attach to report
        // mvn test profile -Pregression
        // run time parameter- mvn test profile -Pregression -Dipadress=127.0.0.1

    }
}