package scenario;


import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.CallsScreen;
import screen.ChannelScreen;
import screen.TabBarScreen;
import screen.settings.AccountScreen;
import screen.settings.SettingsMoreScreen;
import screen.settings.SettingsScreen;
import screen.settings.VoiceSettingsScreen;

import java.io.IOException;

import static framework.Utility.mPlatform;

public class ChannelScenario extends STWScenario {
    public ChannelScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    //channel main Screen check
    public void Calls_STC10() throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC10", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen ChannelScreen= new ChannelScreen ( mDriver);
        mLogger.log(Status.PASS, "2- A clicks  on the  Talk groups tab");
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        TabBarScreen.goToChannels();
        mLogger.log(Status.PASS, "3 - A  checks the tab components");
        ChannelScreen.CheckChannelMainScreen();
    }


    //check channel talk screen
    public void Calls_STC11(String groupToCall) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC11", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        //CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        channelScreen.dismissAlert();
        mLogger.log(Status.PASS, "1 - A opens Channels tab");
        TabBarScreen.goToChannels();
        channelScreen.GoToAllChannel();
        mLogger.log(Status.PASS, "2 - A checks channel entry");
        mDriver3 = mStwAppiumTest.getThirdDriver(mDriver.getPlatformName());
        channelScreen.doSearchTalkgroup(groupToCall);
        if (mPlatform.equals(Platforms.IOS))
        channelScreen.hideKeyboardIos();
        mLogger.log(Status.PASS, "3 - A cliks on the mid section of channel G1 entry ");
        channelScreen.CheckChannelElement();
        channelScreen.OpenChannelFromMain();
        mLogger.log(Status.PASS, "4 - A goes back to talk group tab ");
        mLogger.log(Status.PASS, "5 - A clicks on switch button of G1");
        Thread.sleep(500);

        //channelScreen.CheckDisplayedOfElement(channelScreen.getPTTBtnMainScreen(),"PTTBtnMainScreen");
        //channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(3000);
        mLogger.log(Status.PASS, "6 - B connects to channel G1");
        //channelScreen.CheckDisplayedOfElement(channelScreen.getNumber_contact_connected(),"number of connected user");
        channelScreen.longPressOnElementButton(channelScreen.getPTTBtnMainScreen(),0.5,0.45);

        Thread.sleep(3000);
        //channelScreen.getToggle_BTN_Main_Screen().click();
        channelScreen.CloseMainChannel();
        Thread.sleep(500);

        channelScreen.getChannel_item_name().click();
        mLogger.log(Status.PASS, "7 - A cliks on the mid section of channel G1 entry");
        channelScreen.OpenChannelFromDetails();
        Thread.sleep(3000);
        channelScreen.CheckChannelPTTScreen();
        channelScreen.getSpeakerBtn().click();
        channelScreen.getSpeakerBtn().click();
        channelScreen.longPressOnElementButton(channelScreen.getPTTChannelBtn(),0.5,0.45);

        Thread.sleep(3000);
        channelScreen.ClosePTTScreenChannel();
        Thread.sleep(3000);


    }

    public void Calls_STC12(String groupToCall) throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC12", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        VoiceSettingsScreen voiceSettingsScreen = new VoiceSettingsScreen(mDriver);
        channelScreen.dismissAlert();
        mDriver3 = mStwAppiumTest.getThirdDriver(mDriver.getPlatformName());
        mLogger.log(Status.PASS, "1 - A opens Channels tab");
        TabBarScreen.goToChannels();
        mLogger.log(Status.PASS, "Select All channel section");
        channelScreen.GoToAllChannel();
        mLogger.log(Status.PASS, "Search channel");
        channelScreen.doSearchTalkgroup(groupToCall);
        //channelScreen.back();
        channelScreen.hideKeyboardIos();
        Thread.sleep(500);
        mLogger.log(Status.PASS, "Open the selected channel");
        channelScreen.OpenChannelFromMain();
            if(mPlatform.equals(Platforms.ANDROID)){
                channelScreen.back();
        }
        //Thread.sleep(2000);
        mLogger.log(Status.PASS, "2- change PTT mode from Voice settings");
        TabBarScreen.goToMore();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        mLogger.log(Status.PASS, "PTT mode selected");
        voiceSettingsScreen.ChangePPTFloorModePTT();
        channelScreen.returnToMainScreenFromvoiceSettings();
        mLogger.log(Status.PASS, "Back to channel and take the floor on PTT mode ");
        TabBarScreen.goToChannels();
        Thread.sleep(500);
        channelScreen.longPressOnElementButton(channelScreen.getPTTBtnMainScreen(),0.5,0.4);
        Thread.sleep(2000);
        if(mPlatform.equals(Platforms.IOS))
            channelScreen.back();
        mLogger.log(Status.PASS, "3- change Toggle mode from Voice settings");
        TabBarScreen.goToMore();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        mLogger.log(Status.PASS, "Toggle mode selected");
        voiceSettingsScreen.ChangePPTFloorModeToggle();
        channelScreen.returnToMainScreenFromvoiceSettings();
        mLogger.log(Status.PASS, "Back to channel and take the floor on Toggle mode ");
        TabBarScreen.goToChannels();
        channelScreen.GoToAllChannel();
        channelScreen.doSearchTalkgroup(groupToCall);
        channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(4000);
        channelScreen.getPTTBtnMainScreen().click();
        channelScreen.back();
        channelScreen.hideKeyboardIos();
        Thread.sleep(2000);
        if(mPlatform.equals(Platforms.IOS))
            channelScreen.back();
        Thread.sleep(2000);
        mLogger.log(Status.PASS, "4- change Both mode from Voice settings");
        TabBarScreen.goToMore();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        mLogger.log(Status.PASS, "Both mode selected");
        voiceSettingsScreen.ChangePPTFloorModeBoth();
        channelScreen.returnToMainScreenFromvoiceSettings();
        mLogger.log(Status.PASS, "Back to channel and take the floor on both mode ");
        TabBarScreen.goToChannels();
        channelScreen.GoToAllChannel();
        channelScreen.doSearchTalkgroup(groupToCall);
        channelScreen.longPressOnElementPosition(channelScreen.getPTTBtnMainScreen());
        channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(4000);
        channelScreen.getPTTBtnMainScreen().click();
        channelScreen.back();
        channelScreen.hideKeyboardIos();
        Thread.sleep(2000);
        if(mPlatform.equals(Platforms.IOS))
            channelScreen.back();
        channelScreen.CloseMainChannel();
        Thread.sleep(100);
    }


    //transmit permission
    public void Calls_STC15(String groupToCall) throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC15", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        mLogger.log(Status.PASS, "2- A clicks  on the  Talk groups tab");
        TabBarScreen.goToChannels();
        mLogger.log(Status.PASS, "3 - A  checks the tab components");
        channelScreen.doSearchTalkgroup(groupToCall);
        channelScreen.OpenChannelFromMain();
        channelScreen.denyCloseMainChannel();
        Thread.sleep(8000);

        channelScreen.CloseMainChannel();
        Thread.sleep(4000);
    }
}
