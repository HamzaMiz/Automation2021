package framework.tester;


import framework.Branding;
import framework.Constants;
import framework.Platforms;
import framework.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class STWAppiumTest extends Utility {

    public AppiumDriver mDriver;
    private   AppiumDriverLocalService server;
    private static ITestContext context;



    private HashMap<String,AppiumDriver> mDriverMap= new HashMap<>();

    public STWAppiumTest(String platform ,String branding) {
        super(platform,branding);
    }

    private void prepareDevice()
    {
        System.out.println(" mPlatform : "+mPlatform);
        System.out.println(" branding : "+mBranding);


        try {
            String deviceId=null;
            if(Platforms.ANDROID.equals(mPlatform))
            {
                deviceId=mConfigProperties.getProperty(Constants.ANDROID_DEVICE_ID1) ;
            }
            else if (Platforms.IOS.equals(mPlatform))
            {
                deviceId=mConfigProperties.getProperty(Constants.IOS_DEVICE_ID1) ;
            }
            String wdaPort= mConfigProperties.getProperty(Constants.WDA_PORT);

            mDriver=  createDriver(mPlatform,deviceId, server,mBranding,wdaPort);

            mDriverMap.put(deviceId,mDriver);
            System.out.println(" device id is : "+deviceId);

            System.out.println(" driver  is : "+mDriver.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println(" prepareDevice : exception while preparing the driver"+e.getMessage());
        }
    }

    private String getDriverKey(String platform, int driverIndex)
    {
        String deviceId=null;
        String wdaPort=null;
        if(Platforms.ANDROID.equals(platform))
        {
            deviceId=mConfigProperties.getProperty(
                    driverIndex==2?Constants.ANDROID_DEVICE_ID2:Constants.ANDROID_DEVICE_ID3) ;



        }
        else
        {
            deviceId=mConfigProperties.getProperty
                    (driverIndex==2?Constants.IOS_DEVICE_ID2:Constants.IOS_DEVICE_ID3) ;
        }
        return deviceId;
    }

    private AppiumDriver getDriver(String platform, int driverIndex)
    {
        String deviceId=getDriverKey(platform,driverIndex);

        AppiumDriver driver= mDriverMap.get(deviceId);


            try {
                String wdaPort= mConfigProperties.getProperty(Constants.WDA_PORT);
                if(driverIndex==2)
                    wdaPort= mConfigProperties.getProperty(Constants.WDA_PORT2);
                else if(driverIndex==3)
                    wdaPort= mConfigProperties.getProperty(Constants.WDA_PORT3);

                driver =createDriver(platform,deviceId,server,mBranding,wdaPort);
                mDriverMap.put(deviceId,driver);

                return driver;

            } catch (MalformedURLException e) {
                e.printStackTrace();

                return null;
            }

    }

    public AppiumDriver getSecondDriver(String platform)  {
      return  getDriver(platform,2);
    }

    public AppiumDriver getThirdDriver(String platform)  {
      return  getDriver(platform,3);
    }

    @BeforeMethod
    @Parameters({"nodePath","appiumPath"})
    public void setup(@Optional("")ITestContext context, String nodePath , String appiumPath) throws Exception {
       // prepareAppiumServer();
       //String commandString= "pkill -f node";
       // Runtime.getRuntime().exec(commandString);
       loadPropertiesFile();


       this.server= prepareAppiumServer(nodePath,appiumPath);
        prepareDevice();


        super.driver = mDriver;
        this.context = setContext(context, driver);  // setting the driver into context


    }


    private AppiumDriverLocalService  prepareAppiumServer(String nodePAth,String appiumPath)
    {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

       // int port = Integer.parseInt(mAppiumConfig.getProperty(Constants.APPIUM_PORT));
        //serviceBuilder.usingPort(Integer.valueOf(port));
        serviceBuilder.usingAnyFreePort();
        serviceBuilder.usingDriverExecutable(new File(nodePAth));
        // Tell serviceBuilder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
        serviceBuilder.withAppiumJS(new File(appiumPath));
        // The XCUITest driver requires that a path to the Carthage binary is in the PATH variable. I have this set for my shell, but       the Java process does not see it. It can be inserted here.
        HashMap environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", mAppiumConfig.getProperty(Constants.ANDROID_HOME));
        environment.put("JAVA_HOME", mAppiumConfig.getProperty(Constants.JAVA_HOME));
        serviceBuilder.withEnvironment(environment);
        AppiumDriverLocalService server   = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        if(server == null || !server.isRunning())
        {
            System.out.println(" prepareAppiumServer : Appium server is null or not running");
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started");

        }
        return server ;
    }


    private AppiumDriver createDriver(String platform,String deviceId ,AppiumDriverLocalService server,String branding,String WdaPort) throws MalformedURLException {

        AppiumDriver driver =null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.20.2");
       // capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2147483);
        //int port=Integer.parseInt(mAppiumConfig.getProperty(Constants.APPIUM_PORT));
       // URL serverAddress = new URL("http://127.0.0.1:"+port+"/wd/hub");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceId);

        if (  Platforms.ANDROID.equals(platform)) {

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
            capabilities.setCapability("noReset", true);


            if(Branding.TOTR.equals(branding)) {
                capabilities.setCapability(MobileCapabilityType.APP,
                        mConfigProperties.getProperty(Constants.ANDROID_APK_PATH_TOTR));
            }
            else{
                capabilities.setCapability(MobileCapabilityType.APP,
                        mConfigProperties.getProperty(Constants.ANDROID_APK_PATH_AGNET));

            }
            capabilities.setCapability("androidInstallTimeout", 500000);
            capabilities.setCapability("autoGrantPermissions", true);

            String bundleId= mConfigProperties.getProperty(Constants.BUNDLE_ID);


            capabilities.setCapability("appPackage", bundleId);
            capabilities.setCapability("appActivity", "com.streamwide.smartms.ui.activity.MainActivity");
             driver = new AndroidDriver(server.getUrl(), capabilities);
            System.out.println(" driver "+driver.toString());
        } else  {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");

            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
           // capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");


            if(Branding.TOTR.equals(branding)) {
                        capabilities.setCapability(MobileCapabilityType.APP,
                                mConfigProperties.getProperty(Constants.IOS_APP_PATH_TOTR));            }
            else{
                capabilities.setCapability(MobileCapabilityType.APP,
                        mConfigProperties.getProperty(Constants.IOS_APP_PATH_AGNET));

            }
            capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT,WdaPort);
            capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);

            capabilities.setCapability("useJSONSource", true);
            capabilities.setCapability("waitForQuiescence", false);

            capabilities.setCapability("useNewWDA", false);
           capabilities.setCapability("usePrebuiltWDA", true);

            capabilities.setCapability("noReset", true );
            capabilities.setCapability("fullReset", false);
            capabilities.setCapability("xcodeOrgId", "36WZCVM7SX");
            capabilities.setCapability("xcodeSigningId", "Apple Development");

            driver = new  IOSDriver(server.getUrl(), capabilities);
            System.out.println(" driver "+driver.toString());

        }

        return driver;
    }

    public static ITestContext setContext(ITestContext iTestContext, AppiumDriver driver) {
        iTestContext.setAttribute("driver", driver);

        return iTestContext;
    }
    @AfterMethod
    public void afterMethods() {
        if(mDriver!=null)
        {
            mDriver.quit();

        }

        for( Map.Entry<String, AppiumDriver> map:mDriverMap.entrySet())
        {
            if( map.getValue()!=null)
            {
                map.getValue().quit();
            }
        }
    }

    @AfterTest
    public void afterTest() {
        if(mDriver!=null)
        {
            mDriver.quit();

        }

        for( Map.Entry<String, AppiumDriver> map:mDriverMap.entrySet())
        {
            if( map.getValue()!=null)
            {
                map.getValue().quit();
            }
        }
    }
    @AfterSuite
    public void afterClass()
    {
        if(mDriver!=null)
        {
            mDriver.quit();


        }

     for( Map.Entry<String, AppiumDriver> map:mDriverMap.entrySet())
     {
         if( map.getValue()!=null)
         {
             map.getValue().quit();
         }
     }
    }

}
