package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PermissionsScreen extends STWScreen {
    public PermissionsScreen(AppiumDriver driver) {
        super(driver);
    }


    @iOSXCUITFindBy(iOSNsPredicate="label == \"Allow\"")
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

    public MobileElement getNoNetworkPopupTitle() {
        return NoNetworkPopupTitle;
    }

    public MobileElement getOkBtn() {
        return OkBtn;
    }

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"No available network\"`]")
    private MobileElement NoNetworkPopupTitle;


    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"OK\"`]")
    private MobileElement oKactivateBlueetoothPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement OkBtn;

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

        if (isElementDisplayed(getActivateBluetoothPopupTitle())) {
            getDontAskmeAgainCheckBox().click();

        }
    }

    public void conifrmNoAvailableNetworkPopup() {

        if (isElementDisplayed(getNoNetworkPopupTitle())) {
           getOkBtn().click();

        }
    }

    public void activateBluetoothPopup() {

        if (isElementDisplayed(getActivateBluetoothPopupTitle())) {
           getoKactivateBlueetoothPopup().click();

        }
    }


    public void QuotaPopup() {

        if (isElementDisplayed(getCloudStorageQuota())) {
            oKactivateBlueetoothPopup.click();

        }
    }
    public void allowWhileUsingApp() {
        if (isElementDisplayed(getAllowWhileUsingAppPermission()))
        allowWhileUsingAppPermission.click();

    }

    public void alwaysAllowPermision() {
        if (isElementDisplayed(alwaysAllowPermission))
            alwaysAllowPermission.click();

    }
    public void allow() {

        if (isElementDisplayed(getAllowPermission()))
           allowPermission.click();
    }




    public void allowOnce() {

        if (isElementDisplayed(getAllowOncePermission()))
           getAllowOncePermission().click();
    }

    public void  acceptPermissions(){
        allowWhileUsingApp();
        allowOnce();
        allow();
        QuotaPopup();
        dontAskmeAgainCheckBoxBluetoothPopup();
        activateBluetoothPopup();
        allow();

    }

    public void acceptPermission() {

        if (isElementDisplayed(OkBtn)) {
            OkBtn.click();



        }
    }
}
