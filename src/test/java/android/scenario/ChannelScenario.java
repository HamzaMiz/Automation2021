package android.scenario;

import android.screen.ChannelScreen;
import android.screen.ConversationScreen;
import android.screen.TabBarScreen;
import android.screen.settings.*;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

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
        TabBarScreen.getChannelsItem();
        mLogger.log(Status.PASS, "3 - A  checks the tab components");
        ChannelScreen.CheckChannelMainScreen();
    }

    public void doSearchTalkgroup(String groupToCall) throws InterruptedException, IOException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        Thread.sleep(3000);
        conversationScreen.horizontalSwipeByPercentage(0.7, 0.2, 0.5);
        mLogger.log(Status.PASS, "1 - Go to  channel tab");
        WebDriverWait wait = new WebDriverWait(mDriver, 180);
        wait.until(ExpectedConditions.visibilityOf(channelScreen.getAllChannel()));

        channelScreen.getAllChannel().click();
        mLogger.log(Status.PASS, "2 - Go to  all channel");

        channelScreen.getSearchButtonChannel().click();
        mLogger.log(Status.PASS, "3 - Click on search button channel");

        channelScreen.getChannelSearchContent().sendKeys(groupToCall);
        mLogger.log(Status.PASS, "3 - Enter the name of the channel to be searched");


        channelScreen.getChannelSearchContent().click();
        mLogger.log(Status.PASS, "4 -Click on the search result ");



    }
//check channel talk screen
    public void Calls_STC11(String groupToCall) throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC11", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        CustomizeAppScreen CustomizeAppScreen = new CustomizeAppScreen(mDriver);
        channelScreen.dismissAlert();
        mLogger.log(Status.PASS, "1 - A opens Channels tab");
        TabBarScreen.getChannelsItem();
        channelScreen.getAllChannel().click();
        mLogger.log(Status.PASS, "2 - A checks channel entry");
        doSearchTalkgroup(groupToCall);
        mLogger.log(Status.PASS, "3 - A cliks on the mid section of channel G1 entry ");
        channelScreen.CheckChannelElement();
        channelScreen.getToggle_BTN_Main_Screen().click();
        mLogger.log(Status.PASS, "4 - A goes back to talk group tab ");
        mLogger.log(Status.PASS, "5 - A clicks on switch button of G1");
        channelScreen.CheckDisplayedOfElement(channelScreen.getPTTBtnMainScreen(),"PTTBtnMainScreen");
        channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(3000);
        mLogger.log(Status.PASS, "6 - B connects to channel G1");
        channelScreen.CheckDisplayedOfElement(channelScreen.getNumber_contact_connected(),"number of connected user");
        channelScreen.longPressOnElementPosition(channelScreen.getPTTBtnMainScreen());
        Thread.sleep(3000);
        channelScreen.getToggle_BTN_Main_Screen().click();
        Thread.sleep(500);
        channelScreen.getChannel_item_name().click();
        mLogger.log(Status.PASS, "7 - A cliks on the mid section of channel G1 entry");
        channelScreen.CheckChannelPTTScreen();
        channelScreen.getChannelDetailsSwitchBtn().click();
        channelScreen.getSpeakerBtn().click();
        channelScreen.getSpeakerBtn().click();
        channelScreen.longPressOnElementPosition(channelScreen.getPTTChannelBtn());
        channelScreen.getChannelDetails().click();
        Thread.sleep(3000);
        channelScreen.back();
        Thread.sleep(3000);
        channelScreen.getChannelBackBTN().click();
        channelScreen.getChannelDetailsSwitchBtn().click();
        channelScreen.dismissAlert();
        channelScreen.back();
        channelScreen.back();
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
        TabBarScreen.getChannelsItem();
        channelScreen.getAllChannel().click();
        doSearchTalkgroup(groupToCall);
        channelScreen.getToggle_BTN_Main_Screen().click();
        channelScreen.back();
        Thread.sleep(2000);
        channelScreen.back();
        TabBarScreen.getMoreItem();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        voiceSettingsScreen.getPTT_mode().click();
        Thread.sleep(2000);
        voiceSettingsScreen.clickOnElementByString("Push-to-talk mode");
        voiceSettingsScreen.clickOnElementByString("OK");
        voiceSettingsScreen.back();
        settingsScreen.back();
        TabBarScreen.getChannelsItem();
        channelScreen.getAllChannel().click();
        doSearchTalkgroup(groupToCall);
        channelScreen.longPressOnElementPosition(channelScreen.getPTTBtnMainScreen());
        channelScreen.back();
        Thread.sleep(2000);
        channelScreen.back();
        TabBarScreen.getMoreItem();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        voiceSettingsScreen.getPTT_mode().click();
        Thread.sleep(2000);
        voiceSettingsScreen.clickOnElementByString("Toggle mode");
        voiceSettingsScreen.clickOnElementByString("OK");
        voiceSettingsScreen.back();
        settingsScreen.back();
        TabBarScreen.getChannelsItem();
        channelScreen.getAllChannel().click();
        doSearchTalkgroup(groupToCall);
        channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(4000);
        channelScreen.getPTTBtnMainScreen().click();
        channelScreen.back();
        Thread.sleep(2000);
        channelScreen.back();
        Thread.sleep(2000);
        TabBarScreen.getMoreItem();
        Thread.sleep(2000);
        settingsMoreScreen.getmSettings().click();
        settingsScreen.getmVoice().click();
        Thread.sleep(2000);
        voiceSettingsScreen.getPTT_mode().click();
        Thread.sleep(2000);
        voiceSettingsScreen.clickOnElementByString("Both");
        voiceSettingsScreen.clickOnElementByString("OK");
        voiceSettingsScreen.back();
        settingsScreen.back();
        TabBarScreen.getChannelsItem();
        channelScreen.getAllChannel().click();
        doSearchTalkgroup(groupToCall);
        channelScreen.longPressOnElementPosition(channelScreen.getPTTBtnMainScreen());
        channelScreen.getPTTBtnMainScreen().click();
        Thread.sleep(4000);
        channelScreen.getPTTBtnMainScreen().click();
        channelScreen.back();
        Thread.sleep(2000);
        channelScreen.back();
        Thread.sleep(2000);
    }


    //transmit permission
    public void Calls_STC15(String groupToCall) throws InterruptedException, IOException {

        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        AccountScreen.GetUseCaseDescription("Calls_STC15", Constants.Talk_GroupsSheetNumber, mLogger);
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        mLogger.log(Status.PASS, "2- A clicks  on the  Talk groups tab");
        TabBarScreen.getChannelsItem();
        mLogger.log(Status.PASS, "3 - A  checks the tab components");
        doSearchTalkgroup(groupToCall);
        channelScreen.getToggle_BTN_Main_Screen().click();
    }
}
