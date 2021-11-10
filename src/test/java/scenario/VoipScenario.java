package scenario;

import screen.TabBarScreen;
import screen.VoipScreen;
import android.screen.settings.AccountScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class VoipScenario extends STWScenario {

    public VoipScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void Calls_STC1(String phoneToCall) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        VoipScreen voipScreenSecond = new VoipScreen(mDriver2);
        VoipScreen voipScreen = new VoipScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Calls_STC1", Constants.VOIP_CallSheetNumber, mLogger);
        TabBarScreen.goToContacts();
        voipScreen.searchContactAndCallVoip(phoneToCall);
        mLogger.log(Status.PASS, " User A should  be  able  to  trigger  a  VoIP call  from  Contact  tab");
        voipScreen.checkCallVoipScreenDeviceOne();
        voipScreenSecond.acceptVoipCall();
        mLogger.log(Status.PASS, "B accept the Call");
        voipScreenSecond.checkCallVoipScreenDeviceTwo();
        mLogger.log(Status.PASS, "a full blue screen will be displayed with following information and tools for user A and B");
        voipScreen.checkThreeDotsOptionAfterCall();
        voipScreenSecond.checkScreenAfterLaunchCall();
        mLogger.log(Status.PASS, "The Call status area  will switch to a counter to display the time  spent  on the  call session + a  small  icon to show  the  quality off network");
        mLogger.log(Status.PASS, "The pick up button will switch to transfer call button");
        voipScreenSecond.endVoipCall();
        Thread.sleep(5000);
        //voipScreen.checkBubbleIsDisplayed();
       //mLogger.log(Status.PASS, "A & B will find a call bubbles to show  the  call events on the  middle  of thread call");

    }


    public void Calls_STC2(String phoneToCall, String phoneToTransfer) throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        mDriver3 = mStwAppiumTest.getThirdDriver(mDriver.getPlatformName());

        VoipScreen VoipScreen = new VoipScreen(mDriver);
        VoipScreen voipScreenSecond = new VoipScreen(mDriver2);
        AccountScreen.GetUseCaseDescription("Calls_STC2", Constants.VOIP_CallSheetNumber, mLogger);
        TabBarScreen.goToContacts();
        VoipScreen.searchContactAndCallVoip(phoneToCall);
        mLogger.log(Status.PASS, " User A call B through VoIP from  Contact  tab");
        Thread.sleep(5000);
        voipScreenSecond.acceptVoipCall();
        mLogger.log(Status.PASS, "B accept the Call");
        voipScreenSecond.transferVoipCall(phoneToTransfer);
        mLogger.log(Status.PASS, "B transfer the Call to C");
        VoipScreen voipScreenThird = new VoipScreen(mDriver3);

        voipScreenThird.acceptVoipCall();
        mLogger.log(Status.PASS, " C accept the  call from B");
        voipScreenSecond.endVoipCall();
        mLogger.log(Status.PASS, "B end the  call");
        mLogger.log(Status.PASS, "A will communicate with C");

    }


}


