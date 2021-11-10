package scenario;

import screen.CallsScreen;
import screen.EmergencyCallScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class EmergencyCallScenario extends STWScenario {

    public EmergencyCallScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void doEmergencyCall_STC20() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreen.GetUseCaseDescription("Calls_STC20", Constants.EmergencyCallSheetNumber, mLogger);

        EmergencyCallScreen.clickOnEmergencyCall();
        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");
        Thread.sleep(1500);

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreen.getBack_Button(), "Back button");
        EmergencyCallScreen.clickOnBackFromEmergency();

        EmergencyCallScreen.verifyDate();
        mLogger.log(Status.PASS, " A new Emergency call conversation is created with every Emergency Call");
        EmergencyCallScreenSecond.acceptEmergencyCallFromSecondDevice();
        mLogger.log(Status.PASS, "D accept the Call");
        EmergencyCallScreen.checkDate();
        EmergencyCallScreenSecond.endEmergencyCallFromSecondDevice();
        EmergencyCallScreen.checkConversationEmergencyCall();
    }


    public void doEmergencyCall_STC21() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreen.GetUseCaseDescription("Calls_STC21", Constants.EmergencyCallSheetNumber, mLogger);
        EmergencyCallScreen.clickOnEmergencyCall();
        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");
        Thread.sleep(2000);
        EmergencyCallScreenSecond.acceptEmergencyCallFromSecondDevice();
        mLogger.log(Status.PASS, "accept the call");
        EmergencyCallScreenSecond.checkEmergencyCallScreen();
        mLogger.log(Status.PASS, "Check the emergency call screen options  (one by one)");
        EmergencyCallScreenSecond.endEmergencyCallFromSecondDevice();
        EmergencyCallScreenSecond.verifyEmergencyCallButton();
        mLogger.log(Status.PASS, "If user is  the  only recipient on the  profile , and  he is  on the users list, The  Emergency Call  button will not be available");
    }


}
