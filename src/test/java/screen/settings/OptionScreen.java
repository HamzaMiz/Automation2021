package screen.settings;

import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;


public class OptionScreen extends STWScreen {

    @AndroidFindBy(id = "setting_my_business_options_spinner")
    private MobileElement mBusinessOption;
    @AndroidFindBy(id = "setting_geolocation_battery_optimization_toggle_btn")
    private MobileElement mBatteryOpt;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='First name']")
    @iOSXCUITFindBy(accessibility = "First Name")
    private MobileElement mFirstName;
    @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='Last name']")
    @iOSXCUITFindBy(accessibility = "Last Name")
    private MobileElement mLastname;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"My Business\"));")
    private MobileElement scrollOption;
    @AndroidFindBy(id = "setting_high_speed_geoloc")
    private MobileElement traking;

    @iOSXCUITFindBy(accessibility = "Allow Once")
    private MobileElement allow_Location;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_fastTrackingSwitch")
    private MobileElement highSpeedSwitcher;

    @iOSXCUITFindBy(accessibility = "Geolocation")
    private MobileElement mGeolocation;

    @AndroidFindBy(id = "setting_geolocation_toggle_btn")
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_geolocTrackingSwitch")
    private MobileElement mLocation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "fragment_setting_options_mybusiness_autoav_se_toggle")
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_visibilitySwitch")
    @AndroidFindBy(id = "setting_public_visibility_toggle_btn", priority = 1)
    private MobileElement publicVisibilitySwitcher;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Process Auto-Saving\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Process Auto-Saving')]")
    private MobileElement processAutoSaving;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_autosaveProcessSwitch")
    @AndroidFindBy(id = "fragment_setting_options_mybusiness_auto_save_toggle")
    private MobileElement processAutoSavingSwitcher;
    @AndroidFindBy(id = "user_pop_up_preferences_container")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Pop-up preferences\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mPopUp;
    private MobileElement ChannelTitleMain;


    @FindBy(name = "Cancel")
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Cancel process']")
    private MobileElement Cancel;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @FindBy(name = "Save")
    @iOSXCUITFindBy(accessibility = "SortedContactsSettingViewController_saveButtonItemSorted")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Save\"`]",priority = 1)
    private MobileElement Save;
    @AndroidFindBy(id = "setting_high_speed_geoloc")
    private MobileElement mHighsp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Your edited processes are auto-saved as In Progress each 2 minutes\"`]")
    @AndroidFindBy(id = "fragment_setting_options_mybusiness_auto_save_explanation_text")
    private MobileElement processAutoSavingDescription;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '')]")
    private MobileElement processAutoSavingLabel;

    @iOSXCUITFindBy(accessibility = "Public visibility")
    private MobileElement mPublic;

    public MobileElement getmGeolocation() {
        return mGeolocation;
    }

    public MobileElement getmPublic() {
        return mPublic;
    }

    public MobileElement getProcessQrCode() {
        return ProcessQrCode;
    }

    @iOSXCUITFindBy(accessibility = "Process QR Code")
    private MobileElement ProcessQrCode;




    public OptionScreen(AppiumDriver driver) {
        super(driver);
    }


    public void deactivateGeolocationViaButton() {

        String loc = mLocation.getAttribute("value");
        if (loc.contentEquals("1")) {
            mLocation.click();
        }


    }

    public void deactivateHighspeed() {
        if (mPlatform.equals(Platforms.ANDROID)) {
            scrollUp(1, 300);

            if (traking.getAttribute("text").equals("OUI") || (traking.getAttribute("Text").contentEquals("ON"))) {
                traking.click();
                mLogger.log(Status.PASS, "3-b  -  'deactivate high speed geolocation tracking '");
            }

        } else {
            String highSpeed = highSpeedSwitcher.getAttribute("value");
            if (highSpeed.contentEquals("0")) {
                highSpeedSwitcher.click();
            }
        }


    }


    public void verifyProcessAutosavingIsActivatedByDefault() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            String processAutoSavingStatus = processAutoSavingSwitcher.getAttribute("checked");

            if (isElementDisplayed(processAutoSaving) && isElementDisplayed(processAutoSavingSwitcher)) {
                Assert.assertTrue(processAutoSavingStatus.contentEquals("true"), "process auto saving is not Activatedby default");
            }
        } else {
            String processAutoSavingStatus = processAutoSavingSwitcher.getAttribute("value");

            if (isElementDisplayed(processAutoSaving) && isElementDisplayed(processAutoSavingSwitcher)) {
                Assert.assertTrue(processAutoSavingStatus.contentEquals("1"), "process auto saving is not Activated by default");
            }
        }

    }
    @AndroidFindBy(id = "setting_action_sort_contact_by_spinner")
    @iOSXCUITFindBy(accessibility = "Sort contacts by")
    private MobileElement SortContactBy;

    public MobileElement getmBusinessOption() {
        return mBusinessOption;
    }

    public MobileElement getmBatteryOpt() {
        return mBatteryOpt;
    }

    public MobileElement getScrollOption() {
        return scrollOption;
    }

    public MobileElement getTraking() {
        return traking;
    }

    public MobileElement getAllow_Location() {
        return allow_Location;
    }

    public MobileElement getHighSpeedSwitcher() {
        return highSpeedSwitcher;
    }

    public MobileElement getmLocation() {
        return mLocation;
    }

    public MobileElement getPublicVisibilitySwitcher() {
        return publicVisibilitySwitcher;
    }

    public MobileElement getProcessAutoSaving() {
        return processAutoSaving;
    }

    public MobileElement getProcessAutoSavingSwitcher() {
        return processAutoSavingSwitcher;
    }

    public MobileElement getmPopUp() {
        return mPopUp;
    }

    public MobileElement getChannelTitleMain() {
        return ChannelTitleMain;
    }

    public MobileElement getCancel() {
        return Cancel;
    }

    public MobileElement getSave() {
        return Save;
    }

    public MobileElement getmHighsp() {
        return mHighsp;
    }

    public MobileElement getProcessAutoSavingDescription() {
        return processAutoSavingDescription;
    }

    public MobileElement getProcessAutoSavingLabel() {
        return processAutoSavingLabel;
    }

    public void verifyProcessAutosavingIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(processAutoSaving, "process auto saving label");
        CheckDisplayedOfElement(processAutoSavingDescription, "process auto saving description");
        CheckDisplayedOfElement(processAutoSavingSwitcher, "process auto switcher");
    }


    public void disableEnablePublicOption() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            String pub = publicVisibilitySwitcher.getAttribute("text");
            if (pub.equals("ON")) {
                publicVisibilitySwitcher.click();
                pub.equals("OFF");
            } else {
                publicVisibilitySwitcher.click();
                pub.equals("ON");
            }

        } else {
            publicVisibilitySwitcher.click();
            Thread.sleep(1000);
            publicVisibilitySwitcher.click();

        }


    }

    public void disableEnableLocation() throws InterruptedException, IOException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            String location = mLocation.getAttribute("text");
            if (location.equals("ON")) {
                mLocation.click();
                location.equals("OFF");
            } else {
                mLocation.click();
                location.equals("ON");
            }
        } else {
            Thread.sleep(1000);


            String location = mLocation.getAttribute("value");
            if (location.equals("0")) {
                mLocation.click();
              //  CheckDisplayedOfElement(allow_Location, "Allow location is displayed");
Thread.sleep(2000);
                //OptionScreen.getAllow_Location().click();
                location.equals("1");
            } else {
                mLocation.click();
                location.equals("0");
            }
        }

    }

    public void deactivateGeolocation() {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (mLocation.getAttribute("Text").contentEquals("OUI") || (mLocation.getAttribute("Text").contentEquals("ON"))) {

                mLocation.click();
                mLogger.log(Status.PASS, "3-a  - Check geolocation : 'Authorize user to deactivate the geolocation'");

            }


        }


    }


    public void checkSettingsOptions() throws IOException, InterruptedException {
        VoiceSettingsScreen VoiceSettingsScreen = new VoiceSettingsScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        OptionScreen OptionScreen = new OptionScreen(mDriver);

        if (mPlatform.equals(Platforms.ANDROID)) {

            scrollFromElementToAnother(mLocation,publicVisibilitySwitcher);
           // ElementToClick("Pop-up", 0, 0);
            CheckDisplayedOfElement(mPopUp, "Pop-up preferences");
            if (Branding.TOTR.equals(branding)) {
                scrollFromElementToAnother(mPopUp,mLocation);

                CheckDisplayedOfElement(OptionScreen.mBusinessOption, "My Business options");
            }
            SettingsMoreScreen.clickOnBack();

            SettingsScreen.goToVoiceSettings();

            SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getPTT_mode(), "Check PTT modes");

            SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getAudio_Output(), "Check PTT default audio output");
            VoiceSettingsScreen.scrollToAnElementByText(mDriver,"VOICE BOOST");
            VoiceSettingsScreen.enableDisableAutoResponse();
            mLogger.log(Status.PASS, "Check PTT and VoIP Autoresponse");


        } else {
            waitForElementToBeClickable(highSpeedSwitcher);
            scrollFromElementToAnother(highSpeedSwitcher,SortContactBy);
            CheckDisplayedOfElement(mPopUp, "Pop-up preferences");

            CheckDisplayedOfElement(processAutoSaving, "Process auto saving");

            SettingsScreen.getmBackSettings().click();
            SettingsScreen.getmVoice().click();

            CheckDisplayedOfElement(VoiceSettingsScreen.getPTT_mode(), "Check PTT modes");

            SettingsMoreScreen.CheckDisplayedOfElement(VoiceSettingsScreen.getAudio_Output(), "Check PTT default audio output");

            String autoResponse = VoiceSettingsScreen.getPTT_Auto_Response().getAttribute("value");
            if (autoResponse.equals("1")) {
                VoiceSettingsScreen.getPTT_Auto_Response().click();
                autoResponse.equals("0");
            } else {
                VoiceSettingsScreen.getPTT_Auto_Response().click();
                autoResponse.equals("1");
            }
            mLogger.log(Status.PASS, "Check PTT and VoIP Autoresponse");


        }


    }


    public MobileElement getSortContactBy(){
        return SortContactBy;
    }

    public MobileElement getmFirstName(){
        return mFirstName;
    }

    public MobileElement getmLastname(){
        return mLastname;
    }
    public void clickOnSortContactBy() {
    SortContactBy.click();
    }
}






