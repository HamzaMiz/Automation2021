package scenario;


import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.CallsScreen;
import screen.TabBarScreen;
import screen.settings.*;

import java.io.IOException;

import static framework.Utility.mPlatform;

public class SettingsScenario extends STWScenario {

    public SettingsScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void settings_stc1() throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Settings_STC1", Constants.SettingsSheetNumber, mLogger);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        callsScreen.acceptPermission();
        TabBarScreen.goToMore();
        mLogger.log(Status.PASS, "2 - Go to settings");
        SettingsMoreScreen.scrollFromElementToAnother(SettingsMoreScreen.getmMyBusiness(),SettingsMoreScreen.getmSettings());

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsMoreScreen.getAccount(), "My  account ");
        SettingsMoreScreen.clickOnSettings();

        SettingsScreen.checkSettingsOptions();

        SettingsMoreScreen.back();
        SettingsMoreScreen.goToCustomizeMyApp();

        if (mPlatform.equals(Platforms.IOS))
            CustomizeAppScreen.scrollFromElementToAnother(CustomizeAppScreen.getmDefaultPageMyBusiness(), CustomizeAppScreen.getmDefaultPageTeamOnTheRun());

        if (mPlatform.equals(Platforms.ANDROID))
            CustomizeAppScreen.scrollToAnElementByText(mDriver,"RESET SETTINGS");

            CustomizeAppScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmResetSettings(), "Reset to default is displayed");

    }


    public void settings_stc2() throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Settings_STC2", Constants.SettingsSheetNumber, mLogger);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        OptionScreen OptionScreen = new OptionScreen(mDriver);
        NotificationScreen NotificationScreen = new NotificationScreen(mDriver);
        CallsScreen callsScreen = new CallsScreen(mDriver);


        callsScreen.acceptPermission();
        TabBarScreen.goToMore();
        SettingsMoreScreen.clickOnSettings();


        SettingsScreen.enableAndDisableDuty();
        mLogger.log(Status.PASS, "Modify the status");
        Thread.sleep(1000);
        SettingsScreen.enableAndDisableLoneWorker();
        mLogger.log(Status.PASS, "Lifeguard : Try all the  possible  options 15, 30 ...");

        SettingsScreen.clickOnOptions();

        OptionScreen.disableEnablePublicOption();
        mLogger.log(Status.PASS, "the public visibility");
        OptionScreen.disableEnableLocation();
        mLogger.log(Status.PASS, "user check Location options");
        OptionScreen.checkSettingsOptions();
        SettingsMoreScreen.back();

        SettingsScreen.goToNotification();

        NotificationScreen.manageNotifications();
        mLogger.log(Status.PASS, "Trying to disable  and enable  notification for  some features");

        CustomizeAppScreen.goToCustomizeAndCheckSettings();

        SettingsMoreScreen.clickOnSettings();

        SettingsScreen.contactSupport();


    }


}
