package screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DialerScreen extends STWScreen {

    public DialerScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "contact_bottom_voip_call")
    @iOSXCUITFindBy(accessibility = "ContactsViewController_callBarButton")
    private MobileElement call_Option_Button;
    @AndroidFindBy(id = "activity_dialer_button")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_dialer")
    private MobileElement dialer;

    @AndroidFindBy(id = "activity_dialer_button")
    @iOSXCUITFindBy(accessibility = "Common CallEmergency")
    private MobileElement call_Dialer;


    @iOSXCUITFindBy(accessibility = "redial icon")
    private MobileElement call_Dialer_before;
    @AndroidFindBy(id = "button1")
    @iOSXCUITFindBy(accessibility = "1")
    private MobileElement one;
    @AndroidFindBy(id = "button2")
    @iOSXCUITFindBy(accessibility = "2")
    private MobileElement two;
    @AndroidFindBy(id = "button3")
    @iOSXCUITFindBy(accessibility = "3")
    private MobileElement three;
    @AndroidFindBy(id = "button4")
    @iOSXCUITFindBy(accessibility = "4")
    private MobileElement four;
    @AndroidFindBy(id = "button5")
    @iOSXCUITFindBy(accessibility = "5")
    private MobileElement five;
    @AndroidFindBy(id = "button6")
    @iOSXCUITFindBy(accessibility = "6")
    private MobileElement sex;
    @AndroidFindBy(id = "button7")
    @iOSXCUITFindBy(accessibility = "7")
    private MobileElement seven;
    @AndroidFindBy(id = "button8")
    @iOSXCUITFindBy(accessibility = "8")
    private MobileElement eight;
    @AndroidFindBy(id = "button9")
    @iOSXCUITFindBy(accessibility = "9")
    private MobileElement nine;
    @AndroidFindBy(id = "button11")
    @iOSXCUITFindBy(accessibility = "0")
    private MobileElement zero;
    @AndroidFindBy(id = "button10")
    @iOSXCUITFindBy(accessibility = "*")
    private MobileElement star;
    @AndroidFindBy(id = "button12")
    @iOSXCUITFindBy(accessibility = "#")
    private MobileElement diez;
    @AndroidFindBy(id = "activity_dialer_delete")
    @iOSXCUITFindBy(accessibility = "9 Voip swout deleteGrayButton")
    private MobileElement clear;

    @AndroidFindBy(id = "activity_dialer_phone_number_edit_text")
    @iOSXCUITFindBy(accessibility = "KeyboardCallViewController_phoneNumber")
    private MobileElement Text;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
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
