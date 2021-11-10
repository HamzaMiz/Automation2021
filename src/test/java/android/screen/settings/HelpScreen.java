package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HelpScreen extends STWScreen {


    public MobileElement getContactUs() {
        return contactUs;
    }

    @AndroidFindBy(id = "setting_help_contact_us_button")
    private MobileElement contactUs;

    public MobileElement getFile() {
        return file;
    }

    @AndroidFindBy(id = "android:id/sem_chooser_preview_icon")
    private MobileElement file;


    public HelpScreen(AppiumDriver driver) {
        super(driver);
    }
}
