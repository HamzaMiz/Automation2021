package android.nonRegressionScenarios;

import android.screen.DialerScreen;
import android.screen.TabBarScreen;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.io.IOException;

public class DialerScenario extends STWScenario {

    public DialerScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void Dailer() throws InterruptedException, IOException {
        DialerScreen DialerScreen = new DialerScreen(mDriver);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        // EmergencyCallScreen.GetUseCaseDescription("Dialer", Constants.EmergencyCallSheetNumber, mLogger);
        TabBarScreen.getContactItem();
        DialerScreen.getCall_Option_Button().click();
        DialerScreen.ElementToClick("Dialer",0,0).click();
        DialerScreen.getOne().click();
        DialerScreen.getTwo().click();
        DialerScreen.getThree().click();
        DialerScreen.getFour().click();
        DialerScreen.getFive().click();
        DialerScreen.getCall_Dialer().click();

        Thread.sleep(5000);

        DialerScreen.getBack().click();

        DialerScreen.getCall_Option_Button().click();
        DialerScreen.ElementToClick("Dialer",0,0).click();
        String dialer = DialerScreen.getText().getAttribute("text");
        Assert.assertEquals("Dial your number", dialer);
        DialerScreen.getCall_Dialer().click();
        Thread.sleep(2000);
        String numberToCompose = DialerScreen.getText().getAttribute("text");
        Assert.assertEquals("12345", numberToCompose);



    }

}
