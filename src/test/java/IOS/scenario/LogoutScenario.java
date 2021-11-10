package IOS.scenario;


import IOS.screen.LoginScreen;
import IOS.screen.Settings.AccountScreen;
import IOS.screen.Settings.SettingsMoreScreen;
import IOS.screen.TabBarScreen;


import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class LogoutScenario extends STWScenario {

    public LogoutScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void logout() throws InterruptedException, IOException {
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        AccountScreen AccountScreen = new AccountScreen(mDriver);
        LoginScreen LoginScreen = new LoginScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Login_STC5", Constants.InstallLoginSheetNumber,mLogger);
        TabBarScreen.getMoreItem().click();
        SettingsMoreScreen.getmAccount().click();
        mLogger.log(Status.PASS, "1 - clicks on LOG OUT button");
        AccountScreen.scrollUp(1,1000);
        AccountScreen.getmLogOut().click();
        AccountScreen.getConfirm_Logout().click();
        mLogger.log(Status.PASS, "2 - Yes to confirm");
        Thread.sleep(5000);
        LoginScreen.CheckDisplayedOfElement(LoginScreen.getCompanyId(), "company id");


    }

}
