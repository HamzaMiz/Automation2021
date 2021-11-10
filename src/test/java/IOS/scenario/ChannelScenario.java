package IOS.scenario;

import IOS.screen.*;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class ChannelScenario extends STWScenario {
    PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

    public ChannelScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    public void Call_STC10() throws InterruptedException, IOException{
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ChannelScreen.GetUseCaseDescription("Calls_STC10", Constants.Talk_GroupsSheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1 - A launch the application");
        TabBarScreen.getChannelsItem().click();
        mLogger.log(Status.PASS, "2 - A clicks  on the  Talk groups tab");
        Thread.sleep(3000);
        channelScreen.scrollDown(1,1);
        Thread.sleep(1000);
        //channelScreen.CheckDisplayedOfElement(channelScreen.getSearchChannel(channelOn),"Search channel is displayed");
        channelScreen.getListChannelView().click();
        mLogger.log(Status.PASS, "3 - A  checks the tab components");
        channelScreen.CheckDisplayedOfElement(channelScreen.getAllChannel(),"All channel is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getRecentChannel(),"Recent channel is displayed");
        channelScreen.getRecentChannel().click();
        Thread.sleep(1000);
        channelScreen.getListChannelView().click();
        Thread.sleep(1000);
        channelScreen.getAllChannel().click();
        Thread.sleep(3000);
    }
    public void Calls_STC11 () throws InterruptedException, IOException{
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ChannelScreen.GetUseCaseDescription("Calls_STC11", Constants.Talk_GroupsSheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        TabBarScreen.getChannelsItem().click();
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelActivateButton(),"OnOff button is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelNameLabel(),"Channel Name is displayed");
        channelScreen.scrollDown(1,1);
        //channelScreen.CheckDisplayedOfElement(channelScreen.getSearchChannel(channelOn),"Search Channel is displayed");
        channelScreen.getChannelDetails().click();
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelDetailsBtnOn(),"On/Off btn Channel is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelTitleDetails(),"Title Channel is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getBackBtn(),"Title Channel is displayed");
        channelScreen.getChannelDetailsBtnOn().click();
        channelScreen.getChannelDetailsBtnOn().click();
        channelScreen.getBackBtn().click();
        Thread.sleep(3000);
        channelScreen.getChannelActivateButton().click();
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getPushToTalkButtonMain(),"PTT btn Channel is displayed");
        channelScreen.LonPressOnElement(channelScreen.getPushToTalkButtonMain());
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelTitleMain(),"Main channel Title is displayed");
        channelScreen.getChannelDetails().click();

        Thread.sleep(3000);
    }
    public void Calls_STC12 (String groupToCall) throws InterruptedException, IOException{
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ChannelScreen.GetUseCaseDescription("Calls_STC12", Constants.Talk_GroupsSheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        TabBarScreen.getChannelsItem().click();
        channelScreen.scrollDown(1,1);
        channelScreen.CheckDisplayedOfElement(channelScreen.getSearchChannel(groupToCall),"Search Bar is displayed");
        Thread.sleep(3000);
        channelScreen.getChannelActivateButton().click();
        Thread.sleep(5000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getPushToTalkButtonMain(),"PTT btn Channel is displayed");
        channelScreen.LonPressOnElement(channelScreen.getPushToTalkButtonMain());
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelTitleMain(),"Main channel Title is displayed");
        channelScreen.getChannelDetails().click();
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelSpeakerBtn(),"Speaker btn is displayed");
        //channelScreen.CheckDisplayedOfElement(channelScreen.getChannelMoreBtn(),"More btn is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelGeolocBtn(),"Geolocation btn is displayed");
       //channelScreen.CheckDisplayedOfElement(channelScreen.getChannelDetails(),"Details btn is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelHideView(),"Hide view is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelSwitchOnOff(),"Switch on off is displayed");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelPTTBtn(),"PTT Btn is displayed");
        channelScreen.LonPressOnElement(channelScreen.getChannelPTTBtn());
        Thread.sleep(3000);
        channelScreen.getChannelSwitchOnOff().click();
        Thread.sleep(3000);

    }
    public void Calls_STC15 (String groupToCall) throws InterruptedException, IOException{
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ChannelScreen.GetUseCaseDescription("Calls_STC15", Constants.Talk_GroupsSheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        TabBarScreen.getChannelsItem().click();
        channelScreen.scrollDown(1,1);
        Thread.sleep(3000);
        channelScreen.enterTheChannelToSearch(groupToCall);
        Thread.sleep(3000);
        channelScreen.getChannelActivateButton().click();
        Thread.sleep(3000);
        channelScreen.LonPressOnElement(channelScreen.getPushToTalkButtonMain());
        Thread.sleep(3000);

    }}
