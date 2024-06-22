package PageObjectFactory.IOS;

import Utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViews extends IOSActions {
    IOSDriver driver;//LOCAL VARIABLE

    public AlertViews(IOSDriver driver) {
        super(driver);// call the constructor of the parent class
        this.driver = driver;
        PageFactory.initElements(new
                AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntryMenu;
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
    private WebElement textBox;
    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okButton;
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[C] 'A message'")
    private WebElement message;
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Confirm'")
    private WebElement confirmButton;
    public void clickTextEntry() {
        textEntryMenu.click();
    }
    public void enterText(String text) {
        textBox.sendKeys(text);
    }
    public void clickOk() {
        okButton.click();
    }
    public String getMessage() {
        return message.getText();
    }


}
