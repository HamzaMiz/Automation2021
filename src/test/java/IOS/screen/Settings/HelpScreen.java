package IOS.screen.Settings;

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
    private MobileElement contactUs;

    public MobileElement getContactUs() {
        return contactUs;
    }

    public MobileElement getFile() {
        return file;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement file;
}
