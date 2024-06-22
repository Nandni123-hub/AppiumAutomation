package PageObjectFactory.android;
import Utils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class FormPage extends AndroidActions {
    AndroidDriver driver;//LOCAL VARIABLE

    public FormPage(AndroidDriver driver) {
        super(driver);// call the constructor of the parent class
        this.driver = driver;
        PageFactory.initElements(new
                AppiumFieldDecorator(driver), this);
    }

    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement getFemaleOption;
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropdown;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Argentina']")
    private WebElement submitButton;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.contains("female")) {
            femaleOption.click();
        } else {
            getFemaleOption.click();
        }
    }

    public void setCountry(String country) {
        countryDropdown.click();
        scrollToText(country);
        driver.findElement(By.id("//android.widget.TextView[@text='" + country + "']")).click();

    }
    public void setActivity() throws MalformedURLException {
        Activity activity= new Activity("com.google.android.apps.nexuslauncher","com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        driver.startActivity(activity);
        // run command to get pckg name
    }

    public ProductCatalouge submitbuttonClick() {
        submitButton.click();
        new ProductCatalouge(driver);
        return null;
    }
}

