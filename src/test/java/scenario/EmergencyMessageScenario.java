package scenario;

import framework.Branding;
import framework.Platforms;
import screen.CallsScreen;
import screen.ConversationScreen;
import screen.EmergencyMessageScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

import static framework.Utility.mBranding;
import static framework.Utility.mPlatform;

public class EmergencyMessageScenario extends STWScenario {

    public EmergencyMessageScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void doEmergencyMessage_STC18() throws InterruptedException, IOException {
        EmergencyMessageScreen EmergencyMessageScreen = new EmergencyMessageScreen(mDriver);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        EmergencyMessageScreen.GetUseCaseDescription("Calls_STC18", Constants.EmergencyMessageSheetNumber, mLogger);
        callsScreen.acceptPermission();
        EmergencyMessageScreen.clickOnEmergencyMessage();
        mLogger.log(Status.PASS, "2: From any screen, select the Alert Button ");
        EmergencyMessageScreen.checkEmeregencyMessageScreen();
    }


    public void doEmergencyMessage_STC19() throws InterruptedException, IOException {
        EmergencyMessageScreen EmergencyMessageScreen = new EmergencyMessageScreen(mDriver);
        EmergencyMessageScreen.GetUseCaseDescription("Calls_STC19", Constants.EmergencyMessageSheetNumber, mLogger);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        EmergencyMessageScreen EmergencyMessageScreenSecond = new EmergencyMessageScreen(mDriver2);

        EmergencyMessageScreen.clickOnEmergencyMessage();
        mLogger.log(Status.PASS, "2: From any screen, select the Alert Button ");
        Thread.sleep(122000);
        mLogger.log(Status.PASS, "3: User Wait 20 secondes");
        if (Platforms.ANDROID.equals(mPlatform)) {


            if (mBranding.equals(Branding.AGNET))
         {
             EmergencyMessageScreenSecond.verifyEmergencyMessageIsLaunched();
             EmergencyMessageScreen.stopEmergencyMessageAlerte();


         }else{
                EmergencyMessageScreen.verifyEmergencyMessageIsLaunched();
                EmergencyMessageScreen.stopEmergencyMessageAlerte();
            }

            } else {
            if (mBranding.equals(Branding.TOTR)) {
                EmergencyMessageScreenSecond.verifyEmergencyMessageIsLaunched();
                EmergencyMessageScreenSecond.stopEmergencyMessageAlerte();

            }else{
                EmergencyMessageScreenSecond.verifyEmergencyMessageIsLaunched();
                EmergencyMessageScreenSecond.stopEmergencyMessageAlerte();


            }
        }
        mLogger.log(Status.PASS, "The standard emergency alert pop-up is closed after sending the alert");


    }


}