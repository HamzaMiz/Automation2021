package IOS.scenario;


import IOS.screen.EmergencyMessageScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.io.IOException;

public class EmergencyMessageScenario extends STWScenario {

    public EmergencyMessageScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void doEmergencyMessage_STC18() throws InterruptedException, IOException {
        EmergencyMessageScreen EmergencyMessageScreen = new EmergencyMessageScreen(mDriver);
        EmergencyMessageScreen.GetUseCaseDescription("Calls_STC18", Constants.EmergencyMessageSheetNumber, mLogger);
        EmergencyMessageScreen.getEmergency_Message_Button().click();
        mLogger.log(Status.PASS, "2: From any screen, select the Alert Button ");

//Please modify tests as this one:
        EmergencyMessageScreen.CheckDisplayedOfElement(EmergencyMessageScreen.getCritical(), "CRITICAL ! Life in danger");

        EmergencyMessageScreen.CheckDisplayedOfElement(EmergencyMessageScreen.getSevere(), "SEVERE ! Property in danger is displayed");

        EmergencyMessageScreen.CheckDisplayedOfElement(EmergencyMessageScreen.getUrgent(), "URGENT ! I need help is displayed");

        EmergencyMessageScreen.CheckDisplayedOfElement(EmergencyMessageScreen.getCancel(), "Cancel is displayed");

    }


    public void doEmergencyMessage_STC19() throws InterruptedException, IOException {
        EmergencyMessageScreen EmergencyMessageScreen = new EmergencyMessageScreen(mDriver);
        EmergencyMessageScreen.GetUseCaseDescription("Calls_STC19", Constants.EmergencyMessageSheetNumber, mLogger);
        EmergencyMessageScreen.getEmergency_Message_Button().click();
        mLogger.log(Status.PASS, "2: From any screen, select the Alert Button ");
        Thread.sleep(30000);
        mLogger.log(Status.PASS, "3: User Wait 20 secondes");
        String AlertON = EmergencyMessageScreen.getEmergency_Message_Button().getText();
        Assert.assertEquals(AlertON, "EMERGENCY MESSAGE");
        EmergencyMessageScreen.getEmergency_Message_Button().click();
        mLogger.log(Status.PASS, "The standard emergency alert pop-up is closed after sending the alert");
    }
}
