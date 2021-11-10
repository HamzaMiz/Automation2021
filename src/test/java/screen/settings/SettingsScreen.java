package screen.settings;

import com.aventstack.extentreports.Status;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import screen.CallsScreen;
import screen.TabBarScreen;

import java.io.IOException;
import java.net.MalformedURLException;

public class SettingsScreen extends STWScreen {

    @iOSXCUITFindBy(accessibility = "15 minutes")
    private MobileElement fifteen_min;
    @iOSXCUITFindBy(accessibility = "30 minutes")
    private MobileElement thirty_min;
    @iOSXCUITFindBy(accessibility = "1 hour")
    private MobileElement one_hour;
    @iOSXCUITFindBy(accessibility = "Until I turn it back on")
    private MobileElement until;
    @AndroidFindBy(id = "fragment_setting_list_availability_spinner")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"IASKAppSettingsViewController_0_0\"]")
    private MobileElement mDuty;
    @AndroidFindBy(id = "fragment_setting_list_lone_worker_switch")
    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_loneWorker")
    private MobileElement mLoneWorker;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Options\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    private MobileElement mOptions;
    @iOSXCUITFindBy(id = "Options")
    @AndroidFindBy(id = "setting_list_options")
    private MobileElement options;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "setting_list_voice_settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Voice settings\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @iOSXCUITFindBy(accessibility="IASKAppSettingsViewController_1_1",priority=1)
    private MobileElement mVoice;
    @AndroidFindBy(id = "setting_list_message_settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Message settings\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mMessage;
    @AndroidFindBy(id = "setting_list_accessories")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Accessories\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mAccessories;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "setting_list_network_sms")
    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_1_6")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Network\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther",priority = 1)
    private MobileElement mNetwork;
    @AndroidFindBy(id = "setting_list_storage")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Storage\"`]")
    private MobileElement mStorage;
    @AndroidFindBy(id = "setting_list_notification_alert")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Notifications & Alerts\"`]")
    private MobileElement mNotification;
    @AndroidFindBy(id = "setting_list_information")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Legal information\"`]")
    private MobileElement mInformation;
    @AndroidFindBy(id = "setting_list_about_help")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Information & Help\"`]")
    private MobileElement mHelp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Settings\"`]")
    private MobileElement mBackSettings;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Status\"])[1]", priority = 1)
    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_status")
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement status;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "IASKAppSettingsViewController_1_0")
    @AndroidFindBy(id = "fragment_setting_list_availability_status")
    private MobileElement Options;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"On Duty\"`][2]",priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"On Duty\"])[2]",priority = 1)
    @iOSXCUITFindBy(accessibility = "On Duty")
    private MobileElement Status_On_Duty;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Off Duty']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Off Duty\"])[1]")
    private MobileElement Status_OFF_Duty;

    public SettingsScreen(AppiumDriver driver) {
        super(driver);
    }

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

    public MobileElement getStatus() {
        return status;
    }

    public MobileElement getmBackSettings() {
        return mBackSettings;
    }

    public MobileElement getOptions() {
        return options;
    }

    public void clickOnOptions() throws InterruptedException {
        Thread.sleep(10000);
        options.click();

    }

    public MobileElement getmVoice() {
        return mVoice;
    }

    public void goToVoiceSettings() {
        mVoice.click();
    }

    public void enableAndDisableDuty() throws MalformedURLException, InterruptedException {
        mDuty.click();

        if (mPlatform.equals(Platforms.ANDROID)) {


            String currentDuty = getStatus().getAttribute("checked");
            String newDuty = "On Duty";
            if (currentDuty.equals("true")) {
                newDuty = "Off Duty";
            }
            ElementToClick(newDuty, 0, 0).click();
            acceptAlert();
            String currentDutyText = mDuty.getText();
            Assert.assertEquals(currentDutyText, newDuty);

        } else {


            String OnDuty = status.getAttribute("label");
            if (OnDuty.equals("On Duty")) {
                Thread.sleep(2000);
                selectorToClick("Off Duty");
                getmBackSettings().click();
                Thread.sleep(2000);
                String off = status.getText();
                Assert.assertEquals(off, "Off Duty");
            } else {
                Thread.sleep(2000);

                selectorToClick("On Duty");
                getmBackSettings().click();
                Thread.sleep(2000);
                String off = status.getText();
                Assert.assertEquals(off, "On Duty");
            }

        }
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

    public MobileElement getStatus_On_Duty() {
        return Status_On_Duty;
    }

    public MobileElement getStatus_OFF_Duty() {
        return Status_OFF_Duty;
    }

    public String returnStatusOfUser() throws InterruptedException {
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        String statusOfUser ;

         if (settingsScreen.isElementDisplayed(Status_On_Duty)){
            mLogger.log(Status.INFO, " Status of second device is On duty ");
            statusOfUser = "OnDuty";
        }else {
             statusOfUser = "OffDuty";

             mLogger.log(Status.INFO, " Status of second device is OFF duty ");
         }


        return statusOfUser;
    }

    public void enableAndDisableLoneWorker() throws MalformedURLException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            String loneWorker = mLoneWorker.getAttribute("text");
            if (loneWorker.equals("ON")) {
                mLoneWorker.click();
                ElementToClick("15 minutes", 0, 0).click();
                ElementToClick("30 minutes", 0, 0).click();
                ElementToClick("1 hour", 0, 0).click();
                ElementToClick("Until I turn it back ON", 0, 0).click();
                acceptAlert();
            } else {
                mLoneWorker.click();
            }

        } else {
            String loneWorker = mLoneWorker.getAttribute("label");
            if (loneWorker.equals("On")) {
               mLoneWorker.click();
                selectorToClick("Off");
                Thread.sleep(2000);
                until.click();
                mBackSettings.click();
            } else {
                mLoneWorker.click();
                selectorToClick("On");
                CallsScreen callsScreen = new CallsScreen(mDriver);
                callsScreen.acceptPermission();
                selectorToClick("Off");
                Thread.sleep(5000);
                until.click();
                mBackSettings.click();
            }
        }

    }


    public void contactSupport() throws InterruptedException, IOException {
        HelpScreen HelpScreen = new HelpScreen(mDriver);

        if (mPlatform.equals(Platforms.ANDROID)) {
            scrollFromElementToAnother(mStorage,Options);
            mHelp.click();
            CheckDisplayedOfElement(HelpScreen.getContactUs(), "Contact us");

            HelpScreen.getContactUs().click();
            Thread.sleep(5000);

        } else {

            scrollUp(1, 3000);
            mHelp.click();
            HelpScreen.getContactUs().click();
            Thread.sleep(5000);
        }


    }



    public void checkSettingsOptions() throws InterruptedException, IOException {
        CheckDisplayedOfElement(mDuty, "Status ");
        CheckDisplayedOfElement(mLoneWorker, "Lone worker ");
        CheckDisplayedOfElement(Options, "Options");
        CheckDisplayedOfElement(mVoice, "Voice settings");
        CheckDisplayedOfElement(mMessage, "Message settings");
        CheckDisplayedOfElement(mAccessories, "Accessories ");
        CheckDisplayedOfElement(mNetwork, "Network");
        CheckDisplayedOfElement(mStorage, "Storage");
        scrollFromElementToAnother(mNetwork, Options);

        CheckDisplayedOfElement(mNotification, "Notifications & alerts ");
        CheckDisplayedOfElement(mInformation, "Legal information");
        CheckDisplayedOfElement(mHelp, "Information & Help ");


    }


    public void goToNotification() throws IOException, InterruptedException {
        scrollFromElementToAnother(mNetwork, Options);

        waitForElementToBeClickable(mNotification);
        mNotification.click();


    }


}
