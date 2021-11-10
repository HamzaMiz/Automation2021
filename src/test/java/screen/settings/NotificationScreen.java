package screen.settings;

import framework.Platforms;
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
    @AndroidFindBy(id = "setting_messages_enable_notifications")
    private MobileElement enableMessage;

    @AndroidFindBy(id = "setting_call_enable_notifications")
    private MobileElement enableCall;

    @AndroidFindBy(id = "setting_push_to_talk_enable_notifications")
    private MobileElement enablePTT;

    @iOSXCUITFindBy(accessibility = "NotificationsAlertViewController_enableMBSwitch")
    @AndroidFindBy(id = "setting_my_business_enable_notifications")
    private MobileElement enableMyBusiness;

    @iOSXCUITFindBy(accessibility = "NotificationsAlertViewController_privacy")
    @AndroidFindBy(id = "setting_messages_enable_text_notifications")
    private MobileElement enablePrivacy;


    public void manageNotifications() {
if (mPlatform.equals(Platforms.ANDROID)) {

    enableCall.click();
    enableMessage.click();
    scrollUp(4, 1000);
    enableMyBusiness.click();
                } else {

    enableMessage.click();
    enableMyBusiness.click();
//    enablePrivacy.click();
                }


    }

}
