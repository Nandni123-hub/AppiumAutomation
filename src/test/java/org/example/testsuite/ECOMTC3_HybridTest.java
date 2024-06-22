package org.example.testsuite;
import PageObjectFactory.android.CartPage;
import PageObjectFactory.android.FormPage;
import PageObjectFactory.android.ProductCatalouge;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.example.BaseClassTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Stack;

public class ECOMTC3_HybridTest extends BaseClassTest {
    AndroidDriver driver;
    private FormPage formPage;

    public ECOMTC3_HybridTest(AppiumDriver driver) {
        super(driver);
    }

    @Test(dataProvider = "getData", groups = {"smoke"})
    public void FillForm(HashMap<String,String> input) throws MalformedURLException {
        //ExtentTest test=extent.createTest("FillForm");
        //FormPage formPage = new FormPage(driver); // as this is 1st page so created in base test
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountry(input.get("country"));
        formPage.submitbuttonClick();
        //ProductCatalouge productCatalouge = new ProductCatalouge(driver);
        ProductCatalouge productCatalouge = formPage.submitbuttonClick();
        productCatalouge.addToCartByIndex(0);
        productCatalouge.addToCartByIndex(0);
        CartPage cartPage = productCatalouge.clickCartButton();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //explicit wait
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        double totalsum = cartPage.getProductSum();
        double sum = cartPage.getTotalAmount();
        Assert.assertEquals(totalsum, sum);
        cartPage.clickTermsButton();
        cartPage.clickCheckBox();
        cartPage.clickProceedButton();

    }
    @BeforeMethod
    public void preSetup() throws MalformedURLException {
        formPage.setActivity();
    }

    @DataProvider
    public Object[][] getData() throws IOException {// can take inout as hashmap
        List<HashMap<String,String>> data=getJsonData((System.getProperty("src/test/resources/data/data.json")));
        return new Object[][]{
                {data.get(0)},
                {data.get(1)},
        };
        }
    }

