package Listner;

import Utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Listner implements ITestListener {
    private ExtentReports extent;
    WebDriver driver;
    Helper helper=new Helper(driver);
    private final Map<String, ExtentTest> testMap = new HashMap<>();
    private boolean halt = false;

    @Override
    public void onStart(ITestContext result) {
        if (halt) {
            System.exit(1);
        }
        System.out.println(" Test Started " + result.getName());
        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(new ExtentSparkReporter("extent-reports/extent-report.html"));
        }
        testMap.put(result.getName(), extent.createTest(result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED -> " + result.getName());
        ExtentTest methodTest = testMap.get(result.getName());
        methodTest.log(Status.FAIL, "Test failed");
        methodTest.fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testMap.get(result.getMethod().getMethodName()).log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = testMap.get(result.getTestContext().getName());
        ExtentTest methodTest = test.createNode(result.getMethod().getMethodName());
        testMap.put(result.getMethod().getMethodName(), methodTest);
    }



    @Override
    public void onFinish(ITestContext result) {
        extent.flush();
    }

}
