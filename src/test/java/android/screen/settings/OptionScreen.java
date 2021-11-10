package android.screen.settings;

import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class OptionScreen extends STWScreen {

    @AndroidFindBy(id = "setting_action_sort_contact_by_spinner")
    private MobileElement SortContactBy;
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement mBack;
    @AndroidFindBy(id = "setting_high_speed_geoloc")
    private MobileElement traking;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"My Business\"));")
    private MobileElement scrollOption;
    @AndroidFindBy(id = "setting_my_business_options_spinner")
    private MobileElement mBusinessOption;
    @AndroidFindBy(id = "setting_geolocation_battery_optimization_toggle_btn")
    private MobileElement mBatteryOpt;
    @AndroidFindBy(id = "user_pop_up_preferences_container")
    private MobileElement mPopUp;
    @AndroidFindBy(id = "setting_high_speed_geoloc")
    private MobileElement mHighsp;
    @AndroidFindBy(id = "setting_action_sort_contact_by_spinner")
    private MobileElement mSortContact;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='First name']")
    private MobileElement mFirstName;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Last name']")
    private MobileElement mLastname;
    @AndroidFindBy(id = "setting_beacon_toggle_btn")
    private MobileElement mBeacon;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Take the lead']")
    private MobileElement mTakelead;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Untake the lead']")
    private MobileElement mUntakelead;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Complete process']")
    private MobileElement mCompProc;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Cancel process']")
    private MobileElement mCancelProc;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Cancel process']")
    private MobileElement mProcAutoClean;
    @AndroidFindBy(id="android:id/button1")
    private MobileElement mOk;
    @AndroidFindBy(id = "setting_geolocation_toggle_btn")
    private MobileElement mLocation;
    @AndroidFindBy(id = "setting_public_visibility_toggle_btn")
    private MobileElement mPublic;
    @AndroidFindBy(id = "fragment_setting_options_mybusiness_auto_save_toggle")
    private MobileElement ProcessAutoSavingSwitcher;


    public MobileElement getProcessAutoSavingLabel() {
        return processAutoSavingLabel;
    }

    public MobileElement getProcessAutoSavingDescription() {
        return processAutoSavingDescription;
    }

    @AndroidFindBy(id = "fragment_setting_options_mybusiness_auto_save_explanation_text")
    private MobileElement processAutoSavingDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '')]")
    private MobileElement processAutoSavingLabel;

    public OptionScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getmPublic() {
        return mPublic;
    }

    public MobileElement getmLocation() {
        return mLocation;
    }

    public MobileElement getmPopUp() {
        return mPopUp;
    }

    public MobileElement getmBusinessOption() { return mBusinessOption; }

    public MobileElement getTraking() {
        return traking;
    }

    public MobileElement getScrollOption() {
        return scrollOption;
    }

    public MobileElement getmBatteryOpt() { return mBatteryOpt ;}

    public MobileElement getmHighsp() {
        return mHighsp;
    }

    public MobileElement getmSortContact(){return mSortContact;}

    public MobileElement getmFirstName(){return mFirstName; }

    public MobileElement getmLastname() {return mLastname;}

    public MobileElement getmBeacon() {return mBeacon;}

    public MobileElement getmTakelead() {return mTakelead;}

    public MobileElement getmCompProc() {return mCompProc;}

    public MobileElement getmUntakelead() {return mUntakelead;}

    public MobileElement getmCancelProc() {return mCancelProc;}

    public MobileElement getmProcAutoClean() {return mProcAutoClean;}

    public MobileElement getmOk(){return mOk;}

    public MobileElement getProcessAutoSavingSwitcher() {
        return ProcessAutoSavingSwitcher;
    }

    public MobileElement getSortContactBy(){
        return SortContactBy;
    }

    public MobileElement getmBack(){
        return mBack;
    }


    public void verifyProcessAutosavingIsActivatedByDefault() {
        String processAutoSavingStatus = getProcessAutoSavingSwitcher().getAttribute("checked");

        if( isElementDisplayed(getProcessAutoSavingLabel() )&& isElementDisplayed(getProcessAutoSavingSwitcher())){
            Assert.assertTrue(processAutoSavingStatus.contentEquals("true"),"process auto saving is not Activatedby default");
        }
    }

    public void verifyProcessAutosavingIsDisplayed() {

        boolean processAutoSavingOptionisDisplayed = isElementDisplayed(getProcessAutoSavingLabel() ) && isElementDisplayed(getProcessAutoSavingDescription()) && isElementDisplayed(getProcessAutoSavingSwitcher()) ;
        Assert.assertTrue(processAutoSavingOptionisDisplayed,"element is  present");


    }

    public void disableEnablePublicOption() {

        String pub = getmPublic().getAttribute("text");
        if (pub.equals("ON")) {
            getmPublic().click();
            pub.equals("OFF");
        } else {
            getmPublic().click();
            pub.equals("ON");
        }

    }

    public void disableEnableLocation() {
        String location = getmLocation().getAttribute("text");
        if (location.equals("ON")) {
            getmLocation().click();
            location.equals("OFF");
        } else {
            getmLocation().click();
            location.equals("ON");
        }
    }

    public void deactivateGeolocation() {


        if (getmLocation().getAttribute("Text").contentEquals("OUI") || (getmLocation().getAttribute("Text").contentEquals("ON"))) {

            getmLocation().click();
            mLogger.log(Status.PASS, "3-a  - Check geolocation : 'Authorize user to deactivate the geolocation'");

        }    }


    public void deactivateHighSpeed() {

        scrollUp(1, 300);

        if (getTraking().getAttribute("text").equals("OUI") || (getTraking().getAttribute("Text").contentEquals("ON"))) {
            getTraking().click();
            mLogger.log(Status.PASS, "3-b  -  'deactivate high speed geolocation tracking '");
        }
    }

    public void activateGeolocation() {


        if (getmLocation().getAttribute("Text").contentEquals("NON") || (getmLocation().getAttribute("Text").contentEquals("OFF"))) {

            getmLocation().click();
            mLogger.log(Status.PASS, "3-a  - Check geolocation : 'Authorize your company to locate you'");

        }   }


    public void activateHighSpeed() {

        scrollUp(1, 300);

        if (getTraking().getAttribute("text").equals("NON") || (getTraking().getAttribute("Text").contentEquals("OFF"))) {
            getTraking().click();
            mLogger.log(Status.PASS, "3-b  - Check high speed geolocation tracking  'position of user  will be sent in real time'");
        }
    }


}


