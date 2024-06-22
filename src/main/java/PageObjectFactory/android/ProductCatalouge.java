package PageObjectFactory.android;
import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class ProductCatalouge extends AndroidActions{
    AndroidDriver driver;//LOCAL VARIABLE
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCartButton;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    public ProductCatalouge(AndroidDriver driver) {
        super(driver);// call the constructor of the parent class
        this.driver = driver;
        PageFactory.initElements(new
                AppiumFieldDecorator(driver), this);
    }
    public void addToCartByIndex(int index){
      addToCartButton.get(index).click();
    }
    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }
}
