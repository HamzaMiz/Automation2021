package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsMoreScreen extends STWScreen {


    @AndroidFindBy(id = "view_favorite_grid_manage_favorite")
    private MobileElement mManageFavorite;

    @AndroidFindBy(id = "fragment_more_features_settings")
    private MobileElement mSettings;

    @AndroidFindBy(id = "fragment_more_features_contacts")
    private MobileElement mContacts;

    @AndroidFindBy(id = "fragment_more_features_my_business")
    private MobileElement mMyBusiness;

    @AndroidFindBy(id = "fragment_more_features_customize")
    private MobileElement mCustomize;

    @AndroidFindBy(id = "fragment_more_features_account_name")
    private MobileElement mAccount;

    @AndroidFindBy(id = "fragment_more_features_local_logout_btn")
    private MobileElement mDisconnect;

    public MobileElement getmBack() {
        return mBack;
    }

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement mBack;

    public void clickOnSettings(){
    getmSettings().click();    }


    public SettingsMoreScreen(AppiumDriver driver) {
        super(driver);
    }

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


    public void clickOnBack() {

        getmBack().click();
    }

    public void goToSettings()   {
        getmSettings().click();

    }

    public void goToCustomizeMyApp()   {
        getmCustomize().click();

    }



}
