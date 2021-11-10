package android.scenario;

import android.screen.EmergencyCallScreen;
import android.screen.VoipScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDateTime;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class EmergencyCallScenario extends STWScenario {

    public EmergencyCallScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void doEmergencyCall_STC20() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);

        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);

        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);


        EmergencyCallScreen.GetUseCaseDescription("Calls_STC20", Constants.EmergencyCallSheetNumber, mLogger);


        EmergencyCallScreen.clickOnEmergencyCall();
        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");


        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreen.getBack_Button(), "Back button is displayed");

        EmergencyCallScreen.clickOnBackFromEmergency();

        EmergencyCallScreen.verifyDate();

        mLogger.log(Status.PASS, " A new Emergency call conversation is created with every Emergency Call");

        acceptEmergencyCallFromSecondDevice();
        mLogger.log(Status.PASS, "D accept the Call");

        EmergencyCallScreen.getDate().click();


        endEmergencyCallFromSecondDevice();
        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreen.getBubble_Activity_Message(), "Check the bubble activity message");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreen.getDuration(), "Check the duration of the call");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreen.getMap(), " Check the map preview");

        mLogger.log(Status.PASS, "Check the conversation of the emergency call screen");


        EmergencyCallScreen.verifyRecipient();
        mLogger.log(Status.PASS, "Check the members");


        EmergencyCallScreen.verifyAdminGroupe();
        mLogger.log(Status.PASS, "The conversation is similar to group conversation but no admin");


    }


    public void doEmergencyCall_STC21() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);

        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);

        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreen.GetUseCaseDescription("Calls_STC21", Constants.EmergencyCallSheetNumber, mLogger);

        EmergencyCallScreen.clickOnEmergencyCall();

        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");

        Thread.sleep(2000);
        acceptEmergencyCallFromSecondDevice();
        mLogger.log(Status.PASS, "accept the call");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getPtt_Button(), "Ptt button is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getAdd_User(), "Add user button is displayed");


        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getDétails(), "Details emergency call is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getVideo(), "Video button is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getConversation(), "Conversation is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getGeolocation(), "Get geolocation is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getBack_Button(), "Back button is displayed");

        EmergencyCallScreenSecond.CheckDisplayedOfElement(EmergencyCallScreenSecond.getReject_Button(), "Reject button is displayed");


        mLogger.log(Status.PASS, "Check the emergency call screen options  (one by one)");


        endEmergencyCallFromSecondDevice();

        verifyEmergencyCallButton();

        mLogger.log(Status.PASS, "If user is  the  only recipient on the  profile , and  he is  on the users list, The  Emergency Call  button will not be available");


    }

    public void acceptEmergencyCallFromSecondDevice() {
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreenSecond.getAccept_Emergency().click();
    }


    public void endEmergencyCallFromSecondDevice() {
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreenSecond.getReject_Button().click();
    }

    public void verifyEmergencyCallButton() {
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        Boolean emergencyButton = EmergencyCallScreenSecond.isElementDisplayed(EmergencyCallScreenSecond.getEmergency_Call_Button());
        Assert.assertFalse(emergencyButton);
    }
}
