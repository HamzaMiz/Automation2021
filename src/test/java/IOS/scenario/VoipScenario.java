package IOS.scenario;


import IOS.screen.ContactScreen;
import IOS.screen.TabBarScreen;
import IOS.screen.VoipScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class VoipScenario extends STWScenario {

    public VoipScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void Calls_STC1(String phoneToCall) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        ContactScreen ContactScreen = new ContactScreen(mDriver);
        // ContactScreen ContactScreenSecond = new ContactScreen(mDriver2);


        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        VoipScreen VoipScreenSecond = new VoipScreen(mDriver2);
        VoipScreen VoipScreen = new VoipScreen(mDriver);


        TabBarScreen.GetUseCaseDescription("Calls_STC1", Constants.VOIP_CallSheetNumber, mLogger);
        TabBarScreen.getContactsItem().click();
        ContactScreen.enterTheContactToSearch(phoneToCall);
        ContactScreen.clickOnSearchResult();
        VoipScreen.getCallButton().click();
        VoipScreen.getVoip().click();

        mLogger.log(Status.PASS, " User A should  be  able  to  trigger  a  VoIP call  from  Contact  tab");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getMessage_Call(), "Go to message is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getAvatar(), "Avatar is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getName(), "Name is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getEnable_disable_Mic(), "enabled and disable speaker is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getOutput(), "output button is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getEnd_Button(), "End button is displayed");

        VoipScreen.getMore_Option().click();
        VoipScreen.CheckDisplayedOfElement(VoipScreen.getConversation(), "Go to conversation is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getLocation(), "Go to location is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getVideoStreaming(), "video streaming is displayed");


        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getMessage_Call(), "Go to message is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getAvatar(), "Avatar is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getName(), "Name is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getEnable_disable_Mic(), "Enabled and disable speaker button is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getOutput(), "Output is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getEnd_Button(), "End call button is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getAccept(), "Accept call is displayed");

        VoipScreenSecond.getMore_Option().click();
        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getConversation(), "Go to conversation is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getLocation(), "Location is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getVideoStreaming(), "Video streaming is displayed");


        VoipScreenSecond.getCancel().click();

        mLogger.log(Status.PASS, "a full blue screen will be displayed with following information and tools for user A and B");

        VoipScreenSecond.getAccept().click();

        mLogger.log(Status.PASS, "B accept the Call");

        Thread.sleep(2000);

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getTime_Spent(), "Time to spent is displayed");

        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getTransfer_Button(), "Transfer button is displayed");



        mLogger.log(Status.PASS, "The Call status area  will switch to a counter to display the time  spent  on the  call session + a  small  icon to show  the  quality off network");
        mLogger.log(Status.PASS, "The pick up button will switch to transfer call button");

        VoipScreenSecond.getEnd_Button().click();

        VoipScreen.CheckDisplayedOfElement(VoipScreen.getBubble(), "Bubble is displayed");

        //ContactScreenSecond.getSearchResult().click();
        VoipScreen.CheckDisplayedOfElement(VoipScreenSecond.getBubble(), "Bubble in second device is displayed");



        mLogger.log(Status.PASS, "A & B will find a call bubbles to show  the  call events on the  middle  of thread call");

    }



    public void Calls_STC2(String phoneToCall, String phoneToTransfer) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        ContactScreen ContactScreen = new ContactScreen(mDriver);
        // ContactScreen ContactScreenSecond = new ContactScreen(mDriver2);


        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        mDriver3 = mStwAppiumTest.getThirdDriver(Platforms.IOS);


        VoipScreen VoipScreenSecond = new VoipScreen(mDriver2);

        VoipScreen VoipScreenThird = new VoipScreen(mDriver3);

        VoipScreen VoipScreen = new VoipScreen(mDriver);


        VoipScreen.GetUseCaseDescription("Calls_STC2", Constants.VOIP_CallSheetNumber, mLogger);

        TabBarScreen.getContactsItem().click();
        ContactScreen.enterTheContactToSearch(phoneToCall);
        ContactScreen.clickOnSearchResult();
        VoipScreen.getCallButton().click();
        VoipScreen.getVoip().click();

        mLogger.log(Status.PASS, " User A call B through VoIP from  Contact  tab");

        VoipScreenSecond.getAccept().click();

        mLogger.log(Status.PASS, "B accept the Call");

        VoipScreenSecond.getTransfer_Button().click();
        VoipScreenSecond.getFind_Search().sendKeys(phoneToTransfer);
        VoipScreenSecond.getCall_Search().click();

        mLogger.log(Status.PASS, "B transfer the Call to C");
        Thread.sleep(2000);
        VoipScreenThird.getAccept().click();

        mLogger.log(Status.PASS, " C accept the  call from B");

        VoipScreenSecond.getEnd_Button().click();

        mLogger.log(Status.PASS, "B end the  call");

        VoipScreen.CheckDisplayedOfElement(VoipScreenThird.getTime_Spent(), "Time spent is displayed");
        VoipScreen.CheckDisplayedOfElement(VoipScreenThird.getTransfer_Button(), "Transfer button is displayed");

        mLogger.log(Status.PASS, "A will communicate with C");

    }


}
