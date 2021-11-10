package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountScreen extends STWScreen {

    public AccountScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getmLogOut() {
        return mLogOut;
    }

    public MobileElement getConfirm_Logout() {
        return confirm_Logout;
    }

    @iOSXCUITFindBy(accessibility = "Yes")
    private MobileElement confirm_Logout;

    @iOSXCUITFindBy(accessibility = "MyAccountViewController_logOutButton")
    private MobileElement mLogOut;
}
