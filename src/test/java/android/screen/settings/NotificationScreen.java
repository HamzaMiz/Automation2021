package android.screen.settings;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NotificationScreen extends STWScreen {


    @AndroidFindBy(id = "setting_messages_enable_notifications")
    private MobileElement enableMessage;

    @AndroidFindBy(id = "setting_call_enable_notifications")
    private MobileElement enableCall;

    @AndroidFindBy(id = "setting_push_to_talk_enable_notifications")
    private MobileElement enablePTT;

    @AndroidFindBy(id = "setting_my_business_enable_notifications")
    private MobileElement enableMyBusiness;

    public MobileElement getEnableMessage() {
        return enableMessage;
    }

    public MobileElement getEnableCall() {
        return enableCall;
    }

    public MobileElement getEnablePTT() {
        return enablePTT;
    }

    public MobileElement getEnableMyBusiness() {
        return enableMyBusiness;
    }

    public MobileElement getEnablePrivacy() {
        return enablePrivacy;
    }

    @AndroidFindBy(id = "setting_messages_enable_text_notifications")
    private MobileElement enablePrivacy;

    public NotificationScreen(AppiumDriver driver) {
        super(driver);
    }

    public void manageNotifications() {

        getEnableCall().click();
        getEnableMessage().click();
        scrollUp(4, 1000);
        getEnableMyBusiness().click();

    }
}
