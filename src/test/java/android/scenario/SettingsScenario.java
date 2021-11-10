package android.scenario;

import android.screen.TabBarScreen;
import android.screen.settings.*;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.io.IOException;

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
        TabBarScreen.getMoreItem();
        mLogger.log(Status.PASS, "2 - Go to settings");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsMoreScreen.getmAccount(), "My  account is displayed");
        SettingsMoreScreen.goToSettings();
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmDuty(), "Status is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmLoneWorker(), "Lone worker is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getOptions(), "Options is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmVoice(), "Voice settings is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmMessage(), "Message settings is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmAccessories(), "Accessories is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmNetwork(), "Network is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmStorage(), "Storage is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmNotification(), "Notifications & alerts are displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmInformation(), "Legal information is displayed");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmHelp(), "Information & Help are displayed");
        SettingsMoreScreen.clickOnBack();
        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmResetSettings(), "Reset to default is displayed");

    }


    public void settings_stc2() throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Settings_STC2", Constants.SettingsSheetNumber, mLogger);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        OptionScreen OptionScreen = new OptionScreen(mDriver);
        VoiceSettingsScreen VoiceSettingsScreen = new VoiceSettingsScreen(mDriver);
        NotificationScreen NotificationScreen = new NotificationScreen(mDriver);
        HelpScreen HelpScreen = new HelpScreen(mDriver);
        TabBarScreen.getMoreItem();
        SettingsMoreScreen.goToSettings();
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

        SettingsMoreScreen.CheckDisplayedOfElement(OptionScreen.getmPopUp(), "Pop-up preferences");

        OptionScreen.getScrollOption();
        SettingsMoreScreen.CheckDisplayedOfElement(OptionScreen.getmBusinessOption(), "My Business options");

        SettingsMoreScreen.clickOnBack();

        SettingsScreen.goToVoiceSettings();

        SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getPTT_mode(), "Check PTT modes");

        SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getAudio_Output(), "Check PTT default audio output");
        VoiceSettingsScreen.enableDisableAutoResponse();
        mLogger.log(Status.PASS, "Check PTT and VoIP Autoresponse");

        SettingsMoreScreen.clickOnBack();

        SettingsScreen.goToNotification();

        NotificationScreen.manageNotifications();
        mLogger.log(Status.PASS, "Trying to disable  and enable  notification for  some features");


        for (int i = 0; i <= 1; i++) {
            SettingsMoreScreen.clickOnBack();
        }
        SettingsMoreScreen.goToCustomizeMyApp();
        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmDefaultPageTeamOnTheRun(), "check default page");
        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmDefaultPageMyBusiness(), "Check My Business default page");
        SettingsMoreScreen.clickOnBack();

        SettingsMoreScreen.goToSettings();

        SettingsScreen.contactSupport();
        SettingsMoreScreen.CheckDisplayedOfElement(HelpScreen.getFile(), "Try to contact  the  support team through  the Contact us button");


    }


}
