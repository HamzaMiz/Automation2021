package framework.scenario;

import com.aventstack.extentreports.ExtentTest;
import framework.Platforms;
import framework.screen.STWScreen;
import framework.tester.STWAppiumTest;
import framework.utils.extentReports.ExtentTestManager;
import io.appium.java_client.AppiumDriver;

public abstract class STWScenario {
    protected STWAppiumTest mStwAppiumTest;

    protected AppiumDriver mDriver;
    protected AppiumDriver mDriver2;
    protected AppiumDriver mDriver3;

   protected ExtentTest mLogger;


    public STWScenario(STWAppiumTest stwAppiumTest, String title, String description) {
      //  stwAppiumTest.initLogger(title, description);
        ExtentTestManager.startTest(title,description);
        this.mStwAppiumTest = stwAppiumTest;
        this.mDriver = stwAppiumTest.mDriver;
       this.mLogger = ExtentTestManager.getTest();


    }

    public STWScenario() {

    }



   /* @BeforeTest
    public void setupLogger()
    {
        mStwAppiumTest.initLogger("test","tests:xklc");
        mLogger= this.mStwAppiumTest.getLogger();
    }*/
}
