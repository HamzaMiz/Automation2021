package screen.settings;

import screen.TabBarScreen;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.io.IOException;

public class CustomizeAppScreen extends STWScreen {

    public CustomizeAppScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "fragment_customize_app_action_default_page_spinner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mDefaultPageTeamOnTheRun;

    public MobileElement getmDefaultPageTeamOnTheRun() {
        return mDefaultPageTeamOnTheRun;
    }

    public MobileElement getmDefaultPageMyBusiness() {
        return mDefaultPageMyBusiness;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "fragment_customize_app_default_for_my_business_spinner")
    private MobileElement mDefaultPageMyBusiness;

    public MobileElement getmResetSettings() {
        return mResetSettings;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Reset settings\"`][1]")
    @AndroidFindBy(id = "fragment_customize_app_reset_settings")
    private MobileElement mResetSettings;


    public void goToCustomizeAndCheckSettings() throws IOException, InterruptedException {
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);



        if (mPlatform.equals(Platforms.ANDROID)) {

            for (int i = 0; i <= 1; i++) {
                Thread.sleep(3000);
                SettingsMoreScreen.clickOnBack();
            }
            SettingsMoreScreen.goToCustomizeMyApp();
            SettingsMoreScreen.CheckDisplayedOfElement(mDefaultPageTeamOnTheRun, "check default page");
            SettingsMoreScreen.CheckDisplayedOfElement(mDefaultPageMyBusiness, "Check My Business default page");
            SettingsMoreScreen.clickOnBack();

        } else {

            SettingsScreen.getmBackSettings().click();
            TabBarScreen.goToMore();
            Thread.sleep(1000);
            SettingsMoreScreen.getmCustomize().click();
            Thread.sleep(1000);
            SettingsMoreScreen.CheckDisplayedOfElement(mDefaultPageTeamOnTheRun, "check default page");

            SettingsMoreScreen.CheckDisplayedOfElement(mDefaultPageMyBusiness, "Check My Business default page");

            TabBarScreen.goToMore();
            Thread.sleep(1000);



        }

    }



}
