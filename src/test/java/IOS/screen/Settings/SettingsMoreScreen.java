package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class SettingsMoreScreen extends STWScreen {

    public SettingsMoreScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \" Manage my Favorites\"`][1]")
    private MobileElement mManageFavorite;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_0\"`]")
    private MobileElement mSettings;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_1\"`]")
    private MobileElement mContacts;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_2\"`]")
    private MobileElement mMyBusiness;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_3\"`]")
    private MobileElement mCustomize;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"MoreViewController_0_4\"`]")
    @AndroidFindBy(id = "fragment_more_features_account_name")
    private MobileElement mAccount;

    public MobileElement getmManageFavorite() {
        return mManageFavorite;
    }

    public MobileElement getmSettings() {
        return mSettings;
    }

    public MobileElement getmContacts() {
        return mContacts;
    }

    public MobileElement getmMyBusiness() {
        return mMyBusiness;
    }

    public MobileElement getmCustomize() {
        return mCustomize;
    }

    public MobileElement getmAccount() {
        return mAccount;
    }

    public MobileElement getmDisconnect() {
        return mDisconnect;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Disconnect\"`][1]")
    private MobileElement mDisconnect;

    public void clickOnSettings() { mSettings.click(); }


    public void clickOnAccount(){



    }

}
