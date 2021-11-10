package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

public class SettingsScreen extends STWScreen {

    public SettingsScreen(AppiumDriver driver) {
        super(driver);
    }


    @iOSXCUITFindBy(accessibility = "15 minutes")
    private MobileElement fifteen_min;
    @iOSXCUITFindBy(accessibility = "30 minutes")
    private MobileElement thirty_min;
    @iOSXCUITFindBy(accessibility = "1 hour")
    private MobileElement one_hour;

    public MobileElement getFifteen_min() {
        return fifteen_min;
    }

    public MobileElement getThirty_min() {
        return thirty_min;
    }

    public MobileElement getOne_hour() {
        return one_hour;
    }

    public MobileElement getUntil() {
        return until;
    }

    @iOSXCUITFindBy(accessibility = "Until I turn it back on")
    private MobileElement until;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"IASKAppSettingsViewController_0_0\"]")
    private MobileElement mDuty;

    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_loneWorker")
    private MobileElement mLoneWorker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Options\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    private MobileElement mOptions;
    @iOSXCUITFindBy(id = "Options")
    private MobileElement options;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Voice settings\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mVoice;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Message settings\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mMessage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Accessories\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mAccessories;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Network\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mNetwork;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Storage\"`]")
    private MobileElement mStorage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Notifications & Alerts\"`]")
    private MobileElement mNotification;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Legal information\"`]")
    private MobileElement mInformation;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Information & Help\"`]")
    private MobileElement mHelp;

    public MobileElement getStatus() {
        return status;
    }


    public MobileElement getmBackSettings() {
        return mBackSettings;
    }
    public MobileElement getOptions(){return  options;}
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Settings\"`]")
    private MobileElement mBackSettings;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Status\"])[1]",priority = 1)
    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_status")
    private MobileElement status;


    @FindBy(name="Options")
    private  MobileElement Options;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Off Duty\"])[1]")
    private MobileElement Status_On_Duty;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Off Duty']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Off Duty\"])[1]")
    private MobileElement Status_OFF_Duty;

    public MobileElement getStatus_On_Duty() {
        return Status_On_Duty;
    }

    public MobileElement getStatus_OFF_Duty() {
        return Status_OFF_Duty;
    }

    public MobileElement getmDuty() {
        return mDuty;
    }

    public MobileElement getmLoneWorker() {
        return mLoneWorker;
    }

    public MobileElement getmOptions() {
        return mOptions;
    }

    public MobileElement getmVoice() {
        return mVoice;
    }

    public MobileElement getmMessage() {
        return mMessage;
    }

    public MobileElement getmAccessories() {
        return mAccessories;
    }

    public MobileElement getmNetwork() {
        return mNetwork;
    }

    public MobileElement getmStorage() {
        return mStorage;
    }

    public MobileElement getmNotification() {
        return mNotification;
    }

    public MobileElement getmInformation() {
        return mInformation;
    }

    public MobileElement getmHelp() {
        return mHelp;
    }

    public  void clickOnOptions() throws InterruptedException {
        Thread.sleep(5000);
        options.click();

    }
}
