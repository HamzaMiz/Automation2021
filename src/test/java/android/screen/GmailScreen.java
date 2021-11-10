package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailScreen extends STWScreen {




    @AndroidFindBy(id = "com.google.android.gm:id/senders")
    private MobileElement newMessageGmail ;

    public MobileElement getScrollGmail() {
        return scrollGmail;
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"http://teamontherun.com\"));")
    private MobileElement scrollGmail;


    public GmailScreen(AppiumDriver driver) {
        super(driver);
    }



    public MobileElement getNewMessageGmail() {
        return newMessageGmail;
    }
}
