package android.scenario;

import android.screen.*;
import android.screen.settings.AccountScreen;
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
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        VoipScreen voipScreenSecond = new VoipScreen(mDriver2);
        VoipScreen voipScreen = new VoipScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Calls_STC1", Constants.VOIP_CallSheetNumber, mLogger);
        TabBarScreen.getContactItem();
        voipScreen.searchContactAndCallVoip(phoneToCall);
        mLogger.log(Status.PASS, " User A should  be  able  to  trigger  a  VoIP call  from  Contact  tab");
        voipScreen.CheckDisplayedOfElement(voipScreen.getMessage_Call(), "Go to message is displayed");
        voipScreen.CheckDisplayedOfElement(voipScreen.getAvatar(), " Avatar is displayed");
        voipScreen.CheckDisplayedOfElement(voipScreen.getName(), " Name is displayed");
        voipScreen.CheckDisplayedOfElement(voipScreen.getEnable_disable_Mic(), "Disable speaker is displayed");
        voipScreen.CheckDisplayedOfElement(voipScreen.getOutput(), " output is displayed");

        voipScreen.CheckDisplayedOfElement(voipScreen.getEnd_Button(), " End Button is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getAvatar(), "Avatar is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getName(), "Name  is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getEnable_disable_Mic(), "Enabled and disabled speaker of second device is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getOutput(), "output of second device is displayed");

        voipScreenSecond.clickOnthreeDots();
        voipScreenSecond.checkBroadcastCallOptionIsDisplayed();
        voipScreenSecond.checkGeolocationOptionIsDisplayed();
        voipScreenSecond.checkBroadcastCallOptionIsDisplayed();

        mDriver2.navigate().back();


        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getEnd_Button(), "End Button of second device is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getAccept(), "Accept button of second device is displayed");
        mLogger.log(Status.PASS, "a full blue screen will be displayed with following information and tools for user A and B");

        voipScreenSecond.acceptVoipCallFromSecondDevice();
        mLogger.log(Status.PASS, "B accept the Call");

        Thread.sleep(2000);
        voipScreen.clickOnthreeDots();
        voipScreen.checkBroadcastCallOptionIsDisplayed();
        voipScreen.checkGeolocationOptionIsDisplayed();
        voipScreen.checkBroadcastCallOptionIsDisplayed();

        mDriver.navigate().back();


        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getTime_Spent(), "Time spent of second device is displayed");
        voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getTransfer_Button(), "Transfer button of second device is displayed");
        mLogger.log(Status.PASS, "The Call status area  will switch to a counter to display the time  spent  on the  call session + a  small  icon to show  the  quality off network");
        mLogger.log(Status.PASS, "The pick up button will switch to transfer call button");

        voipScreenSecond.endVoipCallFromSeconDevice();
        Thread.sleep(5000);
        voipScreen.CheckDisplayedOfElement(voipScreen.getBubble(), "Bubble of first device is displayed");
       // voipScreenSecond.CheckDisplayedOfElement(voipScreenSecond.getBubble(), "Bubble of second device is displayed");
        mLogger.log(Status.PASS, "A & B will find a call bubbles to show  the  call events on the  middle  of thread call");

    }


    public void Calls_STC2(String phoneToCall, String phoneToTransfer) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        mDriver3 = mStwAppiumTest.getThirdDriver(Platforms.ANDROID);
        VoipScreen voipScreenThird = new VoipScreen(mDriver3);
        VoipScreen VoipScreen = new VoipScreen(mDriver);
        VoipScreen voipScreenSecond = new VoipScreen(mDriver2);

        AccountScreen.GetUseCaseDescription("Calls_STC2", Constants.VOIP_CallSheetNumber, mLogger);
        TabBarScreen.getContactItem();
        VoipScreen.searchContactAndCallVoip(phoneToCall);
        mLogger.log(Status.PASS, " User A call B through VoIP from  Contact  tab");
        Thread.sleep(5000);
        voipScreenSecond.acceptVoipCallFromSecondDevice();
        mLogger.log(Status.PASS, "B accept the Call");
        voipScreenSecond.transferVoipCall(phoneToTransfer);
        mLogger.log(Status.PASS, "B transfer the Call to C");
        Thread.sleep(2000);
        voipScreenThird.acceptVoipCallFromThirdDevice();
        mLogger.log(Status.PASS, " C accept the  call from B");
        voipScreenSecond.endVoipCallFromSeconDevice();
        mLogger.log(Status.PASS, "B end the  call");
        voipScreenThird.CheckDisplayedOfElement(voipScreenThird.getTransfer_Button(), "Transfer button is displayed");
        mLogger.log(Status.PASS, "A will communicate with C");

    }


}
