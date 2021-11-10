package framework.utils.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ibm.icu.text.SimpleDateFormat;
import framework.Utility;
import framework.utils.ImageResizer;
import framework.utils.extentReports.ExtentTestManager;
import framework.utils.logs.Log;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import static framework.utils.extentReports.ExtentTestManager.getTest;

public class TestListener  implements ITestListener {
    private static final ExtentReports extentReports = new ExtentReports();

    public AppiumDriver driver;



    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());




    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        Utility.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
        AppiumDriver driver = (AppiumDriver) iTestResult.getTestContext().getAttribute("driver");



    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

       // driver = (AppiumDriver) context.getAttribute("mobiledriver");
        AppiumDriver driver = (AppiumDriver) iTestResult.getTestContext().getAttribute("driver");

        Log.info(getTestMethodName(iTestResult) + " test is failed.");

        Log.info("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed...");
        Log.info((iTestResult.getMethod().getMethodName() + " failed!"));


        String targetLocation = null;

        String testClassName = iTestResult.getInstanceName().trim();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        // get timestamp
        String testMethodName = iTestResult.getName().trim();
        String screenShotName = testMethodName +"_"+ timeStamp + ".png";
        String fileSeperator = System.getProperty("file.separator");
        String reportsPath =  "./screenshots";
        Log.info("Screen shots reports path - " + reportsPath);
        try {
            File file = new File(reportsPath + fileSeperator + testClassName); // Set
            // screenshots
            // folder
            if (!file.exists()) {
                if (file.mkdirs()) {
                    Log.info("Directory: " + file.getAbsolutePath() + " is created!");
                } else {
                    Log.info("Failed to create directory: " + file.getAbsolutePath());
                }

            }

            File screenshotFile = ( driver).getScreenshotAs(OutputType.FILE);
            targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
            // location
            File targetFile = new File(targetLocation);
            Log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
            Log.info("Target File location - " + targetFile.getAbsolutePath());
            FileHandler.copy(screenshotFile, targetFile);
            int scaledWidth = 450;
            int scaledHeight = 800;
            ImageResizer.resize( targetLocation, targetLocation, scaledWidth, scaledHeight);


        } catch (FileNotFoundException e) {
            Log.info("File not found exception occurred while taking screenshot " + e.getMessage());
        } catch (Exception e) {
            Log.info("An exception occurred while taking screenshot " + e.getCause());
        }

        // attach screenshots to report
        if (targetLocation== null){
            onTestSkipped(iTestResult);
        }else {
            //  assert targetLocation != null;
            ExtentTestManager.getTest().fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
        }
            ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName()+"Test case FAILED due to below issues:",  ExtentColor.RED));


            ExtentTestManager.getTest().fail(iTestResult.getThrowable());




       /* try {
            screenshotPath = Utility.getscreenshot(driver,iTestResult.getName(),mPlatform);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExtentTestManager.getTest().log(Status.FAIL, (Markup)  ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath,"screenshot"));*/
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
