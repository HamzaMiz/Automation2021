package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EmergencyMessageScreen extends STWScreen {

    public EmergencyMessageScreen(AppiumDriver driver) {
        super(driver);
    }


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"EMERGENCY MESSAGE\"`]")
    private MobileElement emergency_Message_Button ;

    @iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeStaticText[`label == \"CRITICAL!\"`]")
    private MobileElement critical ;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SEVERE!\"`]")
    private MobileElement  severe;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"URGENT!\"`]")
    private MobileElement urgent  ;

    public MobileElement getEmergency_Message_Button() {
        return emergency_Message_Button;
    }

    public MobileElement getCritical() {
        return critical;
    }

    public MobileElement getSevere() {
        return severe;
    }

    public MobileElement getUrgent() {
        return urgent;
    }

    public MobileElement getCancel() {
        return cancel;
    }

    @iOSXCUITFindBy(accessibility = "**/XCUIElementTypeButton[`label == \"Cancel\"`]")
    private MobileElement cancel ;

}
