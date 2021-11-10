package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DialerScreen extends STWScreen {

    public DialerScreen(AppiumDriver driver) {
        super(driver);
    }


    @iOSXCUITFindBy(accessibility = "ContactsViewController_callBarButton")
    private MobileElement call_Option_Button;

    @iOSXCUITFindBy(accessibility = "VoipActionSheet_dialer")
    private MobileElement dialer;


    @iOSXCUITFindBy(accessibility = "Common CallEmergency")
    private MobileElement call_Dialer;


    @iOSXCUITFindBy(accessibility = "redial icon")
    private MobileElement call_Dialer_before;

    @iOSXCUITFindBy(accessibility = "1")
    private MobileElement one;

    @iOSXCUITFindBy(accessibility = "2")
    private MobileElement two;

    @iOSXCUITFindBy(accessibility = "3")
    private MobileElement three;

    @iOSXCUITFindBy(accessibility = "4")
    private MobileElement four;

    @iOSXCUITFindBy(accessibility = "5")
    private MobileElement five;

    @iOSXCUITFindBy(accessibility = "6")
    private MobileElement sex;

    @iOSXCUITFindBy(accessibility = "7")
    private MobileElement seven;

    @iOSXCUITFindBy(accessibility = "8")
    private MobileElement eight;

    @iOSXCUITFindBy(accessibility = "9")
    private MobileElement nine;

    @iOSXCUITFindBy(accessibility = "0")
    private MobileElement zero;

    @iOSXCUITFindBy(accessibility = "*")
    private MobileElement star;

    @iOSXCUITFindBy(accessibility = "#")
    private MobileElement diez;

    @iOSXCUITFindBy(accessibility = "9 Voip swout deleteGrayButton")
    private MobileElement clear;


    @iOSXCUITFindBy(accessibility = "KeyboardCallViewController_phoneNumber")
    private MobileElement Text;

    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement back;

    public MobileElement getCall_Option_Button() {
        return call_Option_Button;
    }

    public MobileElement getDialer() {
        return dialer;
    }

    public MobileElement getCall_Dialer() {
        return call_Dialer;
    }

    public MobileElement getOne() {
        return one;
    }

    public MobileElement getTwo() {
        return two;
    }

    public MobileElement getThree() {
        return three;
    }

    public MobileElement getFour() {
        return four;
    }

    public MobileElement getFive() {
        return five;
    }

    public MobileElement getSex() {
        return sex;
    }

    public MobileElement getSeven() {
        return seven;
    }

    public MobileElement getEight() {
        return eight;
    }

    public MobileElement getNine() {
        return nine;
    }

    public MobileElement getZero() {
        return zero;
    }

    public MobileElement getStar() {
        return star;
    }

    public MobileElement getDiez() {
        return diez;
    }

    public MobileElement getClear() {
        return clear;
    }

    public MobileElement getText() {
        return Text;
    }

    public MobileElement getBack() {
        return back;
    }

    public MobileElement getCall_Dialer_before() {
        return call_Dialer_before;
    }

}
