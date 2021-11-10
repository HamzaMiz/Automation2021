package scenario;


import screen.settings.AccountScreen;
import screen.settings.SettingsMoreScreen;
import screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class LogoutScenario extends STWScenario {

    public LogoutScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void login_STC5() throws InterruptedException, IOException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
    SettingsMoreScreen   settingsMoreScreen = new SettingsMoreScreen(mDriver);

       AccountScreen accountScreen = new screen.settings.AccountScreen(mDriver);
        screen.LoginScreen loginScreen = new screen.LoginScreen(mDriver);
    AccountScreen.GetUseCaseDescription("Login_STC5", Constants.InstallLoginSheetNumber,mLogger);
        tabBarScreen.goToMore();
        settingsMoreScreen.clickOnAccount();
        accountScreen.clickOnLogout();;
        mLogger.log(Status.PASS, "1 - clicks on LOG OUT button");
        mLogger.log(Status.PASS, "2 - Yes to confirm");
        Thread.sleep(5000);

        loginScreen.verifyLogoutWasSuccesful();
    }

}
