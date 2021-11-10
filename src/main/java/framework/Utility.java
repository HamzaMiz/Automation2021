package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    private final String CONFIG_FILE_PATH = "//src//main//java//config//config.properties";
    private final String APPIUM_CONFIG_FILE_PATH = "//src//main//java//config//appium_config.properties";
    protected Properties mConfigProperties;
    protected Properties mAppiumConfig;
    public static String mPlatform;
    public static String mBranding;

    public AppiumDriver driver;
    private static final ExtentReports extentReports = new ExtentReports();


    public Utility(String platform, String branding) {
        mConfigProperties = new Properties();
        mAppiumConfig = new Properties();
        this.mPlatform = platform;
        this.mBranding = branding ;


    }


    public void loadPropertiesFile() throws IOException {

        File file = new File("");
        FileInputStream configFis = new FileInputStream(file.getAbsoluteFile()
                + CONFIG_FILE_PATH);
        mConfigProperties.load(configFis);

        configFis = new FileInputStream(file.getAbsoluteFile()
                + APPIUM_CONFIG_FILE_PATH);
        mAppiumConfig.load(configFis);

        //getExtentReports();
    }
    public static synchronized  ExtentReports getExtentReports() {


        String reportPath=mPlatform== Platforms.ANDROID?"./Android_report.html"
                :"./ios_report.html";
        String parentPath= System.getProperty("user.dir");
        System.out.println("report path : "+parentPath+reportPath);

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        //extentReports.setSystemInfo("Blog Name", "StreamWide Test");
        return extentReports;
    }

}
