package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.net.MalformedURLException;

public class SettingsScreen extends STWScreen {

    @AndroidFindBy(id = "fragment_setting_list_availability_spinner")
    private MobileElement mDuty;


    public MobileElement getStatus() {
        return status;
    }

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement status;


    @AndroidFindBy(id = "fragment_setting_list_lone_worker_switch")
    private MobileElement mLoneWorker;

    @AndroidFindBy(id = "setting_list_options")
    private MobileElement mOptions;

    @AndroidFindBy(id = "setting_list_voice_settings")
    private MobileElement mVoice;

    @AndroidFindBy(id = "setting_list_message_settings")
    private MobileElement mMessage;

    @AndroidFindBy(id = "setting_list_accessories")
    private MobileElement mAccessories;

    @AndroidFindBy(id = "setting_list_network_sms")
    private MobileElement mNetwork;

    @AndroidFindBy(id = "setting_list_storage")
    private MobileElement mStorage;

    @AndroidFindBy(id = "setting_list_notification_alert")
    private MobileElement mNotification;

    @AndroidFindBy(id = "setting_list_information")
    private MobileElement mInformation;

    @AndroidFindBy(id = "setting_list_about_help")
    private MobileElement mHelp;

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement mBack;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty']")
    private MobileElement Status_On_Duty;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Off Duty']")
    private MobileElement Status_OFF_Duty;




    public MobileElement getStatus_On_Duty() {
        return Status_On_Duty;
    }

    public MobileElement getStatus_OFF_Duty() {
        return Status_OFF_Duty;
    }

    public SettingsScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getmDuty() {
        return mDuty;
    }

    public MobileElement getmLoneWorker() {
        return mLoneWorker;
    }

    public MobileElement getOptions() {
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


    public MobileElement getmBack(){
        return mBack;
    }


    public void clickOnOptions(){
        getOptions().click();
    }


    public void enableAndDisableDuty() throws MalformedURLException, InterruptedException {

        getmDuty().click();
        String OnDuty = getStatus().getAttribute("checked");
        if (OnDuty.equals("true")) {
            ElementToClick("Off Duty", 0, 0).click();
            acceptAlert();
            String off = getmDuty().getText();
            Assert.assertEquals(off, "Off Duty");
        } else {
            ElementToClick("On Duty", 0, 0).click();
            acceptAlert();
            String off = getmDuty().getText();
            Assert.assertEquals(off, "On Duty");
        }
    }
    public void enableAndDisableLoneWorker() throws MalformedURLException, InterruptedException {

        String loneWorker = getmLoneWorker().getAttribute("text");
        if (loneWorker.equals("ON")) {
            getmLoneWorker().click();
            ElementToClick("15 minutes", 0, 0).click();
            ElementToClick("30 minutes", 0, 0).click();
            ElementToClick("1 hour", 0, 0).click();
            ElementToClick("Until I turn it back ON", 0, 0).click();
            acceptAlert();
        } else {
            getmLoneWorker().click();
        }
    }


    public void goToVoiceSettings()   {
        getmVoice().click();
    }

    public void goToNotification()   {
        getmNotification().click();
    }


    public void contactSupport() throws InterruptedException {
        HelpScreen HelpScreen = new HelpScreen(mDriver);
        getmHelp().click();
        HelpScreen.getContactUs().click();
        Thread.sleep(5000);

    }



    }
