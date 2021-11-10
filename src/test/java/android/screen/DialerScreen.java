package android.screen;


import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DialerScreen extends STWScreen {

    public DialerScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getCall_Option_Button() {
        return call_Option_Button;
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


    @AndroidFindBy(id = "contact_bottom_voip_call")
    private MobileElement call_Option_Button ;

    @AndroidFindBy(id = "activity_dialer_button")
    private MobileElement call_Dialer;

    @AndroidFindBy(id = "button1")
    private MobileElement one;

    @AndroidFindBy(id = "button2")
    private MobileElement two;

    @AndroidFindBy(id = "button3")
    private MobileElement three;

    @AndroidFindBy(id = "button4")
    private MobileElement four;

    @AndroidFindBy(id = "button5")
    private MobileElement five;

    @AndroidFindBy(id = "button6")
    private MobileElement sex;

    @AndroidFindBy(id = "button7")
    private MobileElement seven;

    @AndroidFindBy(id = "button8")
    private MobileElement eight;

    @AndroidFindBy(id = "button9")
    private MobileElement nine;

    @AndroidFindBy(id = "button11")
    private MobileElement zero;

    @AndroidFindBy(id = "button10")
    private MobileElement star;

    @AndroidFindBy(id = "button12")
    private MobileElement diez;

    @AndroidFindBy(id = "activity_dialer_delete")
    private MobileElement clear;


    @AndroidFindBy(id = "activity_dialer_phone_number_edit_text")
    private MobileElement Text;


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private MobileElement back;


}
