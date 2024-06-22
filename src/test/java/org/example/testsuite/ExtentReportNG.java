package org.example.testsuite;

import ExtentReportsFile.reportDemo;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportNG {
    private static ExtentSparkReporter spark;
    private static ExtentReports extent;

    public static ExtentReports getReporterObject() {
    //ExtentReports, ExtentSparkReporter
    String path=System.getProperty("user.dir")+ "/reports/index.html";
    spark = new ExtentSparkReporter(path);
    extent = new ExtentReports();
    spark.config().setReportName("Web Automation Results");
    spark.config().setDocumentTitle("Report Results");
    extent.attachReporter(spark);
    extent.setSystemInfo("tester", "Nandni");
    return extent;
}
}
