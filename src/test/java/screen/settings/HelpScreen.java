package screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HelpScreen extends STWScreen {

    public HelpScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Contact us\"`]")
    @AndroidFindBy(id = "setting_help_contact_us_button")
    private MobileElement contactUs;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(id = "android:id/sem_chooser_preview_icon")
    private MobileElement file;


    public MobileElement getContactUs() {
        return contactUs;
    }

    public MobileElement getFile() {
        return file;
    }
}
