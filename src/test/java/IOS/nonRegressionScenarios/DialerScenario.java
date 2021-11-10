package IOS.nonRegressionScenarios;

import IOS.screen.DialerScreen;
import IOS.screen.TabBarScreen;
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
        TabBarScreen.getContactsItem().click();
        DialerScreen.getCall_Option_Button().click();
        DialerScreen.getDialer().click();
        DialerScreen.getOne().click();
        DialerScreen.getThree().click();
        DialerScreen.getFour().click();
        DialerScreen.getFive().click();
        DialerScreen.getCall_Dialer().click();
        Thread.sleep(5000);
        DialerScreen.getBack().click();
        DialerScreen.getCall_Option_Button().click();
        DialerScreen.getDialer().click();
        String dialer = DialerScreen.getText().getAttribute("value");
        Assert.assertEquals("Dial your number", dialer);
        DialerScreen.getCall_Dialer_before().click();
        Thread.sleep(2000);
        String numberToCompose = DialerScreen.getText().getAttribute("value");
        Assert.assertEquals("1345", numberToCompose);
    }


}
