package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VoiceSettingsScreen extends STWScreen {


    @AndroidFindBy(id = "setting_walkie_talkie_action_mode_spinner")
    private MobileElement  PTT_mode ;
    @AndroidFindBy(id = "setting_walkie_talkie_audio_output_options_spinner")
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

    @AndroidFindBy(id = "setting_walkie_talkie_autoresponse_toggle_btn")
    private MobileElement PTT_Auto_Response;


    public VoiceSettingsScreen(AppiumDriver driver) {
        super(driver);
    }


    public void enableDisableAutoResponse() {

        String autoResponse = getPTT_Auto_Response().getAttribute("text");
        if (autoResponse.equals("ON")) {
            getPTT_Auto_Response().click();
            autoResponse.equals("OFF");
        } else {
            getPTT_Auto_Response().click();
            autoResponse.equals("ON");
        }
    }

}
