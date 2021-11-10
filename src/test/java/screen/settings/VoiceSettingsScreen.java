package screen.settings;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.io.IOException;

public class VoiceSettingsScreen extends STWScreen {
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"PTT Take the floor mode, Push-to-talk mode\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @iOSXCUITFindBy(accessibility="VoiceSettingsViewController_0_0",priority=1)
    @AndroidFindBy(id = "setting_walkie_talkie_action_mode_spinner")
    private MobileElement PTT_mode;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"PTT audio output, Speaker\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "setting_walkie_talkie_audio_output_options_spinner")
    private MobileElement audio_Output;
    @iOSXCUITFindBy(accessibility = "VoiceSettingsViewController_pttAutoAnswerSwitch")
    @AndroidFindBy(id = "setting_walkie_talkie_autoresponse_toggle_btn")
    private MobileElement PTT_Auto_Response;
    @iOSXCUITFindBy(accessibility="PttTakeTheFloorSettingsViewController_saveButtonItemFloor")
    private MobileElement SaveBtn;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Push-to-talk mode']")
    @iOSXCUITFindBy(accessibility="PttTakeTheFloorSettingsViewController_0_0")
    private MobileElement PTTMode;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Toggle mode']")
    @iOSXCUITFindBy(accessibility="PttTakeTheFloorSettingsViewController_1_0")
    private MobileElement ToggleMode;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Both']")
    @iOSXCUITFindBy(accessibility="PttTakeTheFloorSettingsViewController_2_0")
    private MobileElement BothMode;
    public VoiceSettingsScreen(AppiumDriver driver) {
        super(driver);
    }

    public void enableDisableAutoResponse() {
        if (mPlatform.equals(Platforms.ANDROID)) {
            String autoResponse = PTT_Auto_Response.getAttribute("text");
            if (autoResponse.equals("ON")) {
                PTT_Auto_Response.click();
                autoResponse.equals("OFF");
            } else {
                PTT_Auto_Response.click();
                autoResponse.equals("ON");
            }

        } else {
        }

    }

    public MobileElement getPTT_mode() {
        return PTT_mode;
    }

    public void ChangePPTFloorModePTT() throws InterruptedException, IOException{
        VoiceSettingsScreen voiceSettingsScreen = new VoiceSettingsScreen (mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
            voiceSettingsScreen.getPTT_mode().click();
            //voiceSettingsScreen.clickOnElementByString("Push-to-talk mode");
            voiceSettingsScreen.PTTMode.click();
            voiceSettingsScreen.clickOnElementByString("OK");        }
        else{
            voiceSettingsScreen.getPTT_mode().click();
            voiceSettingsScreen.getPTTMode().click();
            voiceSettingsScreen.getSaveBtn().click();
        }

    }
    public void ChangePPTFloorModeToggle() throws InterruptedException, IOException{
        VoiceSettingsScreen voiceSettingsScreen = new VoiceSettingsScreen (mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
            voiceSettingsScreen.getPTT_mode().click();
            //voiceSettingsScreen.clickOnElementByString("Toggle mode");
            voiceSettingsScreen.ToggleMode.click();
            voiceSettingsScreen.clickOnElementByString("OK");        }
        else{
            voiceSettingsScreen.getPTT_mode().click();
            voiceSettingsScreen.getToggleMode().click();
            voiceSettingsScreen.getSaveBtn().click();
        }

    }
    public void ChangePPTFloorModeBoth() throws InterruptedException, IOException{
        VoiceSettingsScreen voiceSettingsScreen = new VoiceSettingsScreen (mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
            voiceSettingsScreen.getPTT_mode().click();
            //voiceSettingsScreen.clickOnElementByString("Both");
            voiceSettingsScreen.BothMode.click();
            voiceSettingsScreen.clickOnElementByString("OK");        }
        else{
            voiceSettingsScreen.getPTT_mode().click();
            voiceSettingsScreen.getBothMode().click();
            voiceSettingsScreen.getSaveBtn().click();
        }

    }
    public MobileElement getAudio_Output() {
        return audio_Output;
    }

    public MobileElement getPTT_Auto_Response() {
        return PTT_Auto_Response;
    }

    public MobileElement getSaveBtn(){
        return SaveBtn;
    }

    public MobileElement getBothMode(){
        return BothMode;
    }

    public MobileElement getToggleMode(){
        return ToggleMode;
    }

    public MobileElement getPTTMode(){
        return PTTMode;
    }
}
