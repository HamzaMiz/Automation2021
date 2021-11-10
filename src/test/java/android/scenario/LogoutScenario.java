package android.scenario;

import android.screen.LoginScreen;
import android.screen.TabBarScreen;
import android.screen.settings.AccountScreen;
import android.screen.settings.SettingsMoreScreen;
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
        TabBarScreen.getMoreItem();
        SettingsMoreScreen.getmAccount().click();
        mLogger.log(Status.PASS, "1 - clicks on LOG OUT button");
        AccountScreen.getmLogOut().click();
        LoginScreen.acceptAlert();
        mLogger.log(Status.PASS, "2 - Yes to confirm");
        Thread.sleep(5000);
        LoginScreen.CheckDisplayedOfElement(LoginScreen.getCompanyId(), "company id");


    }
}
