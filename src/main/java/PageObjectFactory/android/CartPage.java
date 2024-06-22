package PageObjectFactory.android;
import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class CartPage extends AndroidActions {
    AndroidDriver driver;//LOCAL VARIABLE

    public CartPage(AndroidDriver driver) {
        super(driver);// call the constructor of the parent class
        this.driver = driver;
        PageFactory.initElements(new
                AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrice;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsButton;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;
    @AndroidFindBy(id = "android.widget.CheckBox")
    private WebElement checkBox;

    public List<WebElement> getProductPrice() {

        return productPrice;

    }
    public Double getProductSum() {
        int count = productPrice.size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 =productPrice.get(i).getText();
            double amount = getFormattedAmount(amount1);
            sum = sum + amount;// 280.97+116.97
        }
        return sum;
    }
    public Double getTotalAmount() {
        String total = totalAmount.getText();
        return getFormattedAmount(total);
    }
    public void clickTermsButton() {
        longPressAction(termsButton);
        acceptButton.click();
    }
    public void clickCheckBox() {
        checkBox.click();
    }
    public void clickProceedButton() {
        proceedButton.click();
    }
}
