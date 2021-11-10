package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class OptionScreen extends STWScreen {

    @iOSXCUITFindBy(accessibility = "Allow Once")
    private MobileElement allow_Location;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_fastTrackingSwitch")
    private MobileElement highSpeedSwitcher;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_geolocTrackingSwitch")
    private MobileElement mLocation;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_visibilitySwitch")
    private MobileElement publicVisibilitySwitcher;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Process Auto-Saving\"`]")
    private MobileElement processAutoSaving;
    @iOSXCUITFindBy(accessibility = "OptionsSettingsViewController_autosaveProcessSwitch")
    private MobileElement processAutoSavingSwitcher;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Pop-up preferences\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement mPopUp;
    private MobileElement ChannelTitleMain;
    @FindBy(name = "Sort contacts by")
    private MobileElement SortContact;
    @FindBy(name = "First Name")
    private MobileElement SortContactByFirstName;
    @FindBy(name = "Last Name")
    private MobileElement SortContactByLastName;
    @FindBy(name = "Cancel")
    private MobileElement Cancel;
    @FindBy(name = "Save")
    private MobileElement Save;
    public MobileElement getProcessAutoSavingDescription() {
        return processAutoSavingDescription;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Your edited processes are auto-saved as In Progress each 2 minutes\"`]")
    private MobileElement processAutoSavingDescription;

    public OptionScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getProcessAutoSaving() {
        return processAutoSaving;
    }

    public MobileElement getProcessAutoSavingSwitcher() {
        return processAutoSavingSwitcher;
    }

    public MobileElement getAllow_Location() {
        return allow_Location;
    }


    public MobileElement getmLocation() {
        return mLocation;
    }

    public MobileElement getHighSpeedSwitcher() {
        return highSpeedSwitcher;
    }

    public MobileElement getPublicVisibilitySwitcher() {
        return publicVisibilitySwitcher;
    }

    public MobileElement getmPopUp() {
        return mPopUp;
    }

    public void deactivateGeolocationViaButton() {

        String loc = getmLocation().getAttribute("value");
        if (loc.contentEquals("1")) {
            getmLocation().click();
        }


    }

    public void deactivateHighspeed() {
        String highSpeed = getHighSpeedSwitcher().getAttribute("value");
        if (highSpeed.contentEquals("0")) {
            getHighSpeedSwitcher().click();
        }

    }


    public void verifyProcessAutosavingIsActivatedByDefault() {
        String processAutoSavingStatus = getPublicVisibilitySwitcher().getAttribute("value");

        if( isElementDisplayed(getProcessAutoSaving() )&& isElementDisplayed(getProcessAutoSavingSwitcher())){
            Assert.assertTrue(processAutoSavingStatus.contentEquals("1"),"process auto saving is not Activatedby default");
        }
        }

    public void verifyProcessAutosavingIsDisplayed() {

        boolean processAutoSavingOptionisDisplayed = isElementDisplayed(getProcessAutoSaving() ) && isElementDisplayed(getProcessAutoSavingDescription()) && isElementDisplayed(getProcessAutoSavingSwitcher()) ;
        Assert.assertTrue(processAutoSavingOptionisDisplayed,"element is  present");


        }

    public MobileElement getSortContact(){
        return SortContact;
    }

    public MobileElement getSave(){
        return Save;
    }

    public MobileElement getCancel(){
        return Cancel;
    }

    public MobileElement getSortContactByLastName(){
        return SortContactByLastName;
    }

    public MobileElement getSortContactByFirstName(){
        return SortContactByFirstName;
    }
}



