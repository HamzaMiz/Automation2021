package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ExternalUserInvitationScreen extends STWScreen {
    public ExternalUserInvitationScreen(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "textinput_error")
    private List<MobileElement> textInputErrorsMessagesList;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Germany\"));")
    private MobileElement scrollCountry;

    @AndroidFindBy(id = "flags_spinner")
    private MobileElement CountryCode;

    @AndroidFindBy(id = "textinput_error")
    private MobileElement textInputErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private MobileElement backButton ;

    @AndroidFindBy(id = "external_user_phone_address_book_btn")
    private MobileElement phoneAdressBookButton ;

    @AndroidFindBy(id = "external_user_first_name_input")
    private MobileElement firstName ;

    @AndroidFindBy(id = "external_user_last_name_input")
    private MobileElement lastName ;

    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumber ;

    @AndroidFindBy(id = "external_user_email_input")
    private MobileElement email ;

    @AndroidFindBy(id = "external_user_invitation_mode_sms")
    private MobileElement smsInvitationMode ;

    @AndroidFindBy(id = "external_user_invitation_mode_email")
    private MobileElement emailInvitationMode ;

    @AndroidFindBy(id = "details_external_user_text_view")
    private MobileElement details ;

    @AndroidFindBy(id = "details_external_user_btn_send")
    private MobileElement sendInvitationButton ;


    public MobileElement getBackButton() {
        return backButton;
    }

    public MobileElement getPhoneAdressBookButton() {
        return phoneAdressBookButton;
    }

    public MobileElement getFirstName() {
        return firstName;
    }

    public MobileElement getLastName() {
        return lastName;
    }

    public MobileElement getPhoneNumber() {
        return phoneNumber;
    }

    public MobileElement getEmail() {
        return email;
    }

    public MobileElement getSmsInvitationMode() {
        return smsInvitationMode;
    }

    public MobileElement getEmailInvitationMode() {
        return emailInvitationMode;
    }

    public MobileElement getDetails() {
        return details;
    }

    public MobileElement getSendInvitationButton() {
        return sendInvitationButton;
    }

    public MobileElement getCountryCode() {return CountryCode; }

    public MobileElement getTextInputErrorMessage() { return textInputErrorMessage; }

    public MobileElement getScrollCountry() { return scrollCountry; }
    public List<MobileElement> getTextInputErrorsMessagesList() { return textInputErrorsMessagesList; }
}
