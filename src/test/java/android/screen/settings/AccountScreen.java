package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountScreen extends STWScreen {

    @AndroidFindBy(id = "fragment_setting_account_user_status")
    private MobileElement mAbout;

    @AndroidFindBy(id = "fragment_setting_account_logout")
    private MobileElement mLogOut;

    public AccountScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getmAbout() {
        return mAbout;
    }

    public MobileElement getmLogOut() {
        return mLogOut;
    }

}


