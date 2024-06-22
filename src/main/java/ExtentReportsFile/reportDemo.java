package ExtentReportsFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;

public class reportDemo {
    ExtentSparkReporter spark;
    ExtentReports extent;
    @BeforeTest
    public void config(){
        //ExtentReports, ExtentSparkReporter
        String path=System.getProperty("user.dir")+ "/reports/index.html";
        spark = new ExtentSparkReporter(path);
        extent = new ExtentReports();
        spark.config().setReportName("Web Automation Results");
        spark.config().setDocumentTitle("Report Results");
        extent.attachReporter(spark);
        extent.setSystemInfo("tester", "Nandni");
    }

    @Test
    public void initialDemo(){
        ExtentTest test= extent.createTest("initialDemo");
        System.setProperty("webdriver.chrome.driver", "/Users/nandnisrivastava/IdeaProjects/AppiumAutomation/src/main/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        //test.addScreenCaptureFromBase64String("screenshot");
        test.fail("Result do not match");
        extent.flush();
    }

    private class ExtentReports {
    }
}
