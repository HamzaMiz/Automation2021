package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CustomizeAppScreen extends STWScreen {

    @AndroidFindBy(id = "fragment_customize_app_navigation_bar_config_spinner")
    private MobileElement mNavigationBar;

    @AndroidFindBy(id = "fragment_customize_app_action_default_page_spinner")
    private MobileElement mDefaultPageTeamOnTheRun;

    @AndroidFindBy(id = "fragment_customize_app_default_for_my_business_spinner")
    private MobileElement mDefaultPageMyBusiness;

    @AndroidFindBy(id = "fragment_customize_app_on_contact_spinner")
    private MobileElement mDefaultAction;

    @AndroidFindBy(id = "fragment_customize_app_export_settings")
    private MobileElement mSendSettings;

    @AndroidFindBy(id = "fragment_customize_app_reset_settings")
    private MobileElement mResetSettings;

    public CustomizeAppScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getmNavigationBar() {
        return mNavigationBar;
    }

    public MobileElement getmDefaultPageTeamOnTheRun() {
        return mDefaultPageTeamOnTheRun;
    }

    public MobileElement getmDefaultPageMyBusiness() {
        return mDefaultPageMyBusiness;
    }

    public MobileElement getmDefaultAction() {
        return mDefaultAction;
    }

    public MobileElement getmSendSettings() {
        return mSendSettings;
    }

    public MobileElement getmResetSettings() {
        return mResetSettings;
    }

}
