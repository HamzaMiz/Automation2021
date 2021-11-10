package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VoiceSettingsScreen extends STWScreen {

    public VoiceSettingsScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"PTT Take the floor mode, Push-to-talk mode\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement PTT_mode ;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"PTT audio output, Speaker\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement audio_Output;

    public MobileElement getPTT_mode() {
        return PTT_mode;
    }

    public MobileElement getAudio_Output() {
        return audio_Output;
    }

    public MobileElement getPTT_Auto_Response() {
        return PTT_Auto_Response;
    }

    @iOSXCUITFindBy(accessibility = "VoiceSettingsViewController_pttAutoAnswerSwitch")
    private MobileElement PTT_Auto_Response;

}
