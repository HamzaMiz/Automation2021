package IOS.scenario;

import IOS.screen.Settings.*;
import IOS.screen.TabBarScreen;
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
        SettingsMoreScreen.GetUseCaseDescription("Settings_STC1", Constants.SettingsSheetNumber, mLogger);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        Thread.sleep(10000);
        TabBarScreen.getMoreItem().click();
        mLogger.log(Status.PASS, "2 - Go to settings");
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsMoreScreen.getmAccount(), "My account is displayed");

        SettingsMoreScreen.getmSettings().click();
        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmDuty(), "Status is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmLoneWorker(), "Lone worker is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmOptions(), "Options is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmVoice(), "Voice settings is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmMessage(), "Message settings is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmAccessories(), "Accessories is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmNetwork(), "Network is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmStorage(), "Storage is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmNotification(), "Notifications & alerts are displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmInformation(), "Legal information is displayed");

        SettingsMoreScreen.CheckDisplayedOfElement(SettingsScreen.getmHelp(), "Information & Help are displayed");

        TabBarScreen.getMoreItem().click();
        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmResetSettings(), "Reset to default is displayed");

    }


    public void settings_stc2() throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        SettingsMoreScreen.GetUseCaseDescription("Settings_STC2", Constants.SettingsSheetNumber, mLogger);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        OptionScreen OptionScreen = new OptionScreen(mDriver);
        VoiceSettingsScreen VoiceSettingsScreen = new VoiceSettingsScreen(mDriver);
        NotificationScreen NotificationScreen = new NotificationScreen(mDriver);
        HelpScreen HelpScreen = new HelpScreen(mDriver);


        TabBarScreen.getMoreItem().click();
        SettingsMoreScreen.getmSettings().click();
        SettingsScreen.getmDuty().click();


        String OnDuty = SettingsScreen.getStatus().getAttribute("label");
        if (OnDuty.equals("On Duty")) {
            Thread.sleep(2000);
            SettingsScreen.selectorToClick("Off Duty");
            SettingsScreen.getmBackSettings().click();

            String off = SettingsScreen.getStatus().getText();
            Assert.assertEquals(off, "Off Duty");
        } else {
            Thread.sleep(2000);

            SettingsScreen.selectorToClick("On Duty");
            SettingsScreen.getmBackSettings().click();
            String off = SettingsScreen.getStatus().getText();
            Assert.assertEquals(off, "On Duty");
        }

        mLogger.log(Status.PASS, "Modify the status");
        Thread.sleep(1000);
        String loneWorker = SettingsScreen.getmLoneWorker().getAttribute("label");
        if (loneWorker.equals("On")) {
            SettingsScreen.getmLoneWorker().click();
            SettingsScreen.selectorToClick("Off");
            Thread.sleep(2000);
            SettingsScreen.getFifteen_min().click();
            SettingsScreen.selectorToClick("Off");
            SettingsScreen.getThirty_min().click();
            Thread.sleep(2000);
            SettingsScreen.selectorToClick("Off");
            SettingsScreen.getOne_hour().click();
            SettingsScreen.selectorToClick("Off");
            SettingsScreen.getUntil().click();
            SettingsScreen.getmBackSettings().click();
        } else {
            SettingsScreen.getmLoneWorker().click();
            SettingsScreen.selectorToClick("On");
            SettingsScreen.selectorToClick("Off");
            SettingsScreen.getUntil().click();
            SettingsScreen.getmBackSettings().click();
        }
        mLogger.log(Status.PASS, "Lifeguard : Try all the  possible  options 15, 30 ...");
        SettingsScreen.getmOptions().click();

        OptionScreen.getPublicVisibilitySwitcher().click();
        Thread.sleep(1000);
        OptionScreen.getPublicVisibilitySwitcher().click();

        mLogger.log(Status.PASS, "the public visibility");

        Thread.sleep(1000);
        String location = OptionScreen.getmLocation().getAttribute("value");
        if (location.equals("0")) {
            OptionScreen.getmLocation().click();
            SettingsMoreScreen.CheckDisplayedOfElement(OptionScreen.getAllow_Location(), "Allow location is displayed");

            //OptionScreen.getAllow_Location().click();
            location.equals("1");
        } else {
            OptionScreen.getmLocation().click();
            location.equals("0");
        }
        mLogger.log(Status.PASS, "Location options");

        SettingsMoreScreen.CheckDisplayedOfElement(OptionScreen.getmPopUp(), "Pop-up preferences");


        SettingsMoreScreen.CheckDisplayedOfElement(OptionScreen.getProcessAutoSaving(), "My Business options");

        SettingsScreen.getmBackSettings().click();
        SettingsScreen.getmVoice().click();

        SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getPTT_mode(), "Check PTT modes");

        SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getAudio_Output(), "Check PTT default audio output");

        String autoResponse = VoiceSettingsScreen.getPTT_Auto_Response().getAttribute("value");
        if (autoResponse.equals("1")) {
            VoiceSettingsScreen.getPTT_Auto_Response().click();
            autoResponse.equals("0");
        } else {
            VoiceSettingsScreen.getPTT_Auto_Response().click();
            autoResponse.equals("1");
        }
        mLogger.log(Status.PASS, "Check PTT and VoIP Autoresponse");

        SettingsScreen.getmBackSettings().click();
        SettingsScreen.getmNotification().click();
        NotificationScreen.getEnableMessage().click();
        NotificationScreen.getEnableMyBusiness().click();
        // NotificationScreen.holdAndScrollDown(1, 1000, 1, 3, 4);
        NotificationScreen.getEnablePrivacy().click();
        mLogger.log(Status.PASS, "Trying to disable  and enable  notification for  some features");

        SettingsScreen.getmBackSettings().click();
        TabBarScreen.getMoreItem().click();
        Thread.sleep(1000);
        SettingsMoreScreen.getmCustomize().click();
        Thread.sleep(1000);
        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmDefaultPageTeamOnTheRun(), "check default page");

        SettingsMoreScreen.CheckDisplayedOfElement(CustomizeAppScreen.getmDefaultPageMyBusiness(), "Check My Business default page");

        TabBarScreen.getMoreItem().click();
        Thread.sleep(1000);
        SettingsMoreScreen.getmSettings().click();
        SettingsScreen.scrollUp(1, 3000);
        SettingsScreen.getmHelp().click();
        HelpScreen.getContactUs().click();
        Thread.sleep(5000);
        SettingsMoreScreen.CheckDisplayedOfElement(HelpScreen.getFile(), "Try to contact  the  support team through  the Contact us button");

    }


}
