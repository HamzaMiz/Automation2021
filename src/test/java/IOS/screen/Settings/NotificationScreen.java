package IOS.screen.Settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NotificationScreen extends STWScreen {
    public NotificationScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "NotificationsAlertViewController_enableMessageSwitch")
    private MobileElement enableMessage;

    @iOSXCUITFindBy(accessibility = "NotificationsAlertViewController_enableMBSwitch")
    private MobileElement enableMyBusiness;

    public MobileElement getEnableMessage() {
        return enableMessage;
    }

    public MobileElement getEnableMyBusiness() {
        return enableMyBusiness;
    }

    public MobileElement getEnablePrivacy() {
        return enablePrivacy;
    }

    @iOSXCUITFindBy(accessibility = "NotificationsAlertViewController_privacy")
    private MobileElement enablePrivacy;


}
