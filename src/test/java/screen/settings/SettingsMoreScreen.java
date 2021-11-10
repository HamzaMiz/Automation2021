package screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import screen.TabBarScreen;

import java.io.IOException;


public class SettingsMoreScreen extends STWScreen {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \" Manage my Favorites\"`][1]")
    private MobileElement mManageFavorite;

    public MobileElement getAccount() {
        return account;
    }
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "fragment_more_features_settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_0\"`]")
    @iOSXCUITFindBy(accessibility = "ColibriMoreViewController_0_0")
    @iOSXCUITFindBy(accessibility = "Settings")
    private MobileElement mSettings;
    @AndroidFindBy(id = "fragment_more_features_contacts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_1\"`]")
    private MobileElement mContacts;

    public MobileElement getmContacts() {
        return mContacts;
    }

    public MobileElement getmMyBusiness() {
        return mMyBusiness;
    }

    public MobileElement getmDisconnect() {
        return mDisconnect;
    }

    public MobileElement getmBack() {
        return mBack;
    }

    @AndroidFindBy(id = "fragment_more_features_my_business")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_2\"`]")
    private MobileElement mMyBusiness;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "fragment_more_features_customize")
    @iOSXCUITFindBy(accessibility = "Customize my App",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Customize my App\"`]",priority = 2)
    @iOSXCUITFindBy(accessibility = "MoreViewController_0_3")
    private MobileElement mCustomize;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_4\"`]")
    @iOSXCUITFindBy(accessibility = "ColibriMoreViewController_0_3")
    @AndroidFindBy(id = "fragment_more_features_account_name")
    private MobileElement account;

    public MobileElement getmManageFavorite() {
        return mManageFavorite;
    }

    public MobileElement getmSettings() {
        return mSettings;
    }


    public MobileElement getmCustomize() {
        return mCustomize;
    }


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Disconnect\"`][1]")
    private MobileElement mDisconnect;

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement mBack;

    public SettingsMoreScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnSettings() {
        mSettings.click();
    }

    public void clickOnBack() throws InterruptedException {
            mBack.click();
    }


    public void clickOnAccount() {

        account.click();


    }

    public void goToCustomizeMyApp() throws IOException, InterruptedException {
        screen.TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.goToMore();
        waitForElementToBeClickable(mCustomize);
        mCustomize.click();

    }

}
