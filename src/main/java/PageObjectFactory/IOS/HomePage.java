package PageObjectFactory.IOS;

import Utils.IOSActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSActions {
    IOSDriver driver;//LOCAL VARIABLE

    public HomePage(IOSDriver driver) {
        super(driver);// call the constructor of the parent class
        this.driver = driver;
        PageFactory.initElements(new
                AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility= "Alert Views")
    private WebElement alertViews;
    public AlertViews clickAlertViews() {
        alertViews.click();
        return new AlertViews(driver);
    }
}
