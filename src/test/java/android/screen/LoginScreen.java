package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends STWScreen {


    @AndroidFindBy(id = "login_company_id")
    private MobileElement companyId;

    @AndroidFindBy(id = "flags_spinner")
    private MobileElement CountryCode;

    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumber;

    @AndroidFindBy(id = "login_btn_ok")
    private MobileElement login;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Tunisia\"));")
    private MobileElement scrollCountry;

    @AndroidFindBy(id = "login_redirect_tip")
    private MobileElement senDEmail;

    public MobileElement getAlertGeolocation() {
        return alertGeolocation;
    }

    @AndroidFindBy(id = "activity_geolocation_prompt_dont_show_again")
    private MobileElement alertGeolocation;


    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement openWith;

    public MobileElement getPopupAndroid() {
        return popupAndroid;
    }

    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement popupAndroid;

    public MobileElement getCongratulations() {
        return congratulations;
    }

    @AndroidFindBy(id = "congrats_wizard_id")
    private MobileElement congratulations;

    public MobileElement getConfirmation() {
        return confirmation;
    }

    @AndroidFindBy(id = "parentPanel")
    private MobileElement confirmation;


    public MobileElement getNext() {
        return next;
    }

    @AndroidFindBy(id = "wizard_next_btn")
    private MobileElement next;


    public MobileElement getOk() {
        return ok;
    }

    @AndroidFindBy(id = "activity_geolocation_prompt_ok_btn")
    private MobileElement ok;


    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getCompanyId() {
        return companyId;
    }

    public MobileElement getCountryCode() {
        return CountryCode;
    }

    public MobileElement getPhoneNumber() {
        return phoneNumber;
    }

    public MobileElement getLogin() {
        return login;
    }

    public MobileElement getScrollCountry() {
        return scrollCountry;
    }

    public MobileElement getSenDEmail() {
        return senDEmail;
    }

    public MobileElement getOpenWith() {
        return openWith;
    }

}
