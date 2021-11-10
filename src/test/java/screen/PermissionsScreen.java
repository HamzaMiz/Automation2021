package screen;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import java.time.temporal.ChronoUnit;

public class PermissionsScreen extends STWScreen {
    public PermissionsScreen(AppiumDriver driver) {
        super(driver);
    }


    @iOSXCUITFindBy(iOSNsPredicate="label == \"Allow\"")
    @AndroidFindBy(id="android:id/button1")
    private MobileElement allowPermission;

    public MobileElement getAlwaysAllowPermission() {
        return alwaysAllowPermission;
    }

    @iOSXCUITFindBy(iOSNsPredicate="label == \"Always Allow\"")
    private MobileElement alwaysAllowPermission;
    @iOSXCUITFindBy(iOSNsPredicate="label == \"Allow Once\"")
    private MobileElement allowOncePermission;

    @iOSXCUITFindBy(iOSNsPredicate="label == \"Allow While Using App\"")
    private MobileElement allowWhileUsingAppPermission;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Activate Bluetooth\"`]")
    private MobileElement activateBluetoothPopupTitle;



    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"No available network\"`]")
    private MobileElement noNetworkPopupTitle;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"OK\"`]")
    private MobileElement oKactivateBlueetoothPopup;

    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    private MobileElement activateGeolocationPopup;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"OK\"`]",priority = 2)
    private MobileElement okBtn;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmBtn;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"Don't ask me again\"`]")
    private MobileElement dontAskmeAgainCheckBox;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextView[`value == \"Cloud Storage Quota\"`]")
    private MobileElement  cloudStorageQuota;

    public MobileElement getCloudStorageQuota() {
        return cloudStorageQuota;
    }

    public MobileElement getoKactivateBlueetoothPopup() {
        return oKactivateBlueetoothPopup;
    }

    public MobileElement getAllowWhileUsingAppPermission() {
        return allowWhileUsingAppPermission;
    }

    public MobileElement getDontAskmeAgainCheckBox() {
        return dontAskmeAgainCheckBox;
    }

    public MobileElement getActivateBluetoothPopupTitle() {
        return activateBluetoothPopupTitle;
    }

    public MobileElement getAllowOncePermission() {
        return allowOncePermission;
    }

    public MobileElement getAllowPermission() {
        return allowPermission;
    }




    public void dontAskmeAgainCheckBoxBluetoothPopup() {

        if (isElementDisplayed(activateBluetoothPopupTitle)) {
            dontAskmeAgainCheckBox.click();

        }
    }


    public void activateBluetoothPopup() {

        if (isElementDisplayed(activateBluetoothPopupTitle)) {
           oKactivateBlueetoothPopup.click();

        }
    }

    public void activateGeolocationPopup() {

        if (isElementDisplayed(activateGeolocationPopup)) {
            activateGeolocationPopup.click();

        }
    }

    public void QuotaPopup() {

        if (isElementDisplayed(cloudStorageQuota)) {
            okBtn.click();

        }
    }
    public void allowWhileUsingApp() {
        if (isElementDisplayed(allowWhileUsingAppPermission)) {
            allowWhileUsingAppPermission.click();
        }
    }

    public void alwaysAllowPermision() {
        if (isElementDisplayed(alwaysAllowPermission)) {

            alwaysAllowPermission.click();
        }
    }
    public void allow() {

        if (isElementDisplayed(allowPermission)){
            allowPermission.click();}
    }




    public void allowOnce() {

        if (isElementDisplayed(allowOncePermission)){

        allowOncePermission.click();}
    }

    public void  acceptPermissions(){
                if (mPlatform.equals(Platforms.IOS)) {
                    alwaysAllowPermision();
                    allowWhileUsingApp();
                    allow();
                    allowOnce();
                    QuotaPopup();
                    dontAskmeAgainCheckBoxBluetoothPopup();
                    activateBluetoothPopup();
                    activateGeolocationPopup();
                    acceptPermission();

                        }
    }

    public void acceptPermission() {
        if (mPlatform.equals(Platforms.IOS)){
        if (isElementDisplayed(okBtn)) {
            okBtn.click();



        }}
    }
}
