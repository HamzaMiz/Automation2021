package IOS.nonRegressionScenarios;

import IOS.screen.calendarScreen;
import IOS.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class calendarScenario extends STWScenario {
    public calendarScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
    calendarScreen calendarScreen = new calendarScreen(mDriver);

    public void businessProcessTC13() throws InterruptedException, IOException {
        calendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_TC6735", Constants.SchedulingSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.goToScheduling();
        mLogger.log(Status.PASS, "2 - User A opens the daily view in the scheduling from the navigation bar with a new SO");
        calendarScreen.checkAcceptedService();
        calendarScreen.checkStartedService();
        calendarScreen.checkFinishedService();
        calendarScreen.checkCompletedService();
    }

    public void businessProcessTC22() throws InterruptedException, IOException {

        calendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_STC22", Constants.SchedulingSheetNumber, mLogger);
        tabBarScreen.goToScheduling();
        mLogger.log(Status.PASS, "2 - User A opens the daily view in the scheduling from the navigation bar with a new SO");
        calendarScreen.checkAcceptedService();
        calendarScreen.checkAcceptedServiceFromContent();

    }

    public void businessProcessTC23(String rejectionReason) throws InterruptedException, IOException {

        calendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_STC22", Constants.SchedulingSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.goToScheduling();
        mLogger.log(Status.PASS, "2 - User A opens the daily view in the scheduling from the navigation bar with a new SO");
        calendarScreen.rejectService(rejectionReason);

    }

@AfterMethod
public void stopAppiumServer(){
    mDriver.close();
}
}
