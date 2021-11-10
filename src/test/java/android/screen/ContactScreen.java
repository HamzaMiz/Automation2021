package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class ContactScreen extends STWScreen {
    public MobileElement getExternalUserInvitationButton() {
        return ExternalUserInvitationButton;
    }
    //ExternalUserInvitationButton
    @AndroidFindBy(id = "contact_bottom_bar_invite_external_user")
    private MobileElement ExternalUserInvitationButton ;

    //Company contact list
    @AndroidFindBy(id = "view_switch_left_container")
    private MobileElement companyContact ;
    @AndroidFindBy(id = "contact_item_icon")
    private MobileElement ContactIcon;
    @AndroidFindBy(id = "contact_item_availability_icon")
    private MobileElement ContactIconAvailability;

    @AndroidFindBy(id = "contact_list_mgm")
    private MobileElement ContactResultSearchList;
    //My local contact list
    @AndroidFindBy(id = "view_switch_right_container")
    private MobileElement MyContact ;

    //Contact options
    private MobileElement LongPressContact;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Details']")
    private MobileElement ContactDetails ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call Out via PBX']")
    private MobileElement CallOutPBX ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadcast Video']")
    private MobileElement BroadcastVideoCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Message']")
    private MobileElement SendMessage ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    private MobileElement SendEmail ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Geolocation']")
    private MobileElement ContactGeolocation ;

    //Group options
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New conversation']")
    private MobileElement NewGroupConversation ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open conversation']")
    private MobileElement OpenGroupConversation ;


    //Multiselect to start or open conversation , start Group call , Broadcast Video
    @AndroidFindBy(id = "bottom_multiselect")
    private MobileElement Multiselect ;


    //Start or open Conversation
    @AndroidFindBy(id = "bottom_open_new_conversation")
    private MobileElement OpenConversation ;

   //Call list (VOIP,PTT,Conf,VideoCall,Cellular,Dialer)
    @AndroidFindBy(id = "contact_bottom_voip_call")
    private MobileElement CallButton ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
    private MobileElement VOIPCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Push-To-Talk']")
    private MobileElement PTTCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conference Call']")
    private MobileElement ConfCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Call']")
    private MobileElement VideoCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cellular Call']")
    private MobileElement CellularCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dialer']")
    private MobileElement Dialer ;

   //Start Broadcast video
    @AndroidFindBy(id = "contact_bottom_video_stream")
    private MobileElement VideoStreamButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dispatch Managers']")
    private MobileElement VideoStreamDispatchManagers ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    private MobileElement VideoStreamContact ;

    //contact details UI (user info)
    @AndroidFindBy(id = "contact_details_image")
    private MobileElement ContactAvatar;
    @AndroidFindBy(id = "contact_details_call")
    private MobileElement UserDetailsCall;
    @AndroidFindBy(id = "contact_details_new_message")
    private MobileElement UserDetailsConversation;
    @AndroidFindBy(id = "contact_details_geolocation")
    private MobileElement UserDetailsGeolocation;
    @AndroidFindBy(id = "contact_details_send_email")
    private MobileElement UserDetailsSendMail;
    @AndroidFindBy(id = "phone_number_contact_details")
    private MobileElement UserPhoneNumber;
    @AndroidFindBy(id = "email_adress_contact_details")
    private MobileElement UserMail;
    @AndroidFindBy(id = "contact_business_detail_group_view")
    private MobileElement UserGroupDetails;
    @AndroidFindBy(id = "contact_business_detail_all_media_view")
    private MobileElement UserAllMedia;

    //filter contact list
    @AndroidFindBy(id = "contact_bottom_contact_filter_options")
    private MobileElement ContactFilterButton ;
    @AndroidFindBy(id = "contact_filter_reset_default_menu")
    private MobileElement ResetContactFilter ;
    @AndroidFindBy(id = "filter_contact_user_check_box")
    private MobileElement FilterUsers ;
    @AndroidFindBy(id = "filter_contact_group_check_box")
    private MobileElement FilterGroups ;
    @AndroidFindBy(id = "filter_contact_connected_check_box")
    private MobileElement ConnectedUsers ;
    @AndroidFindBy(id = "filter_contact_not_connected_check_box")
    private MobileElement NotConnectedUsers ;
    @AndroidFindBy(id = "filter_contact_on_duty_check_box")
    private MobileElement OnDutyUsers ;
    @AndroidFindBy(id = "filter_contact_off_duty_check_box")
    private MobileElement OffDutyUsers ;
    @AndroidFindBy(id = "view_contact_filter_reset_default_button")
    private MobileElement Default ;

    //search contact
    @AndroidFindBy(id = "bottom_search")
    private MobileElement SearchButton ;
    @AndroidFindBy(id = "contact_search_content")
    private MobileElement SearchContent ;

    public void enterContactToSearch(String contact) { SearchContent.sendKeys(contact); }

    @AndroidFindBy(id ="contact_single_item_data_container")
    private MobileElement SearchResult;
    public  MobileElement getSearchResult(){return  SearchResult;}




    public MobileElement getCompanyContact() {
        return companyContact;
    }

    public MobileElement getMyContact() {
        return MyContact;
    }

    public MobileElement getMultiselect() {
        return Multiselect;
    }

    public MobileElement getCallButton() {
        return CallButton;
    }

    public MobileElement getVideoStreamButton() {
        return VideoStreamButton;
    }

    public MobileElement getContactFilterButton() {
        return ContactFilterButton;
    }

    public MobileElement getSearchButton() {
        return SearchButton;
    }

    public MobileElement getOpenConversation() {
        return OpenConversation;
    }

    public MobileElement getSearchContent() {
        return SearchContent;
    }


    public MobileElement getVOIPCall() {
        return VOIPCall;
    }

    public MobileElement getPTTCall() {
        return PTTCall;
    }

    public MobileElement getConfCall() {
        return ConfCall;
    }

    public MobileElement getVideoCall() {
        return VideoCall;
    }

    public MobileElement getCellularCall() {
        return CellularCall;
    }

    public MobileElement getDialer() {
        return Dialer;
    }

    public MobileElement getVideoStreamDispatchManagers() {
        return VideoStreamDispatchManagers;
    }

    public MobileElement getVideoStreamContact() {
        return VideoStreamContact;
    }

    public MobileElement getResetContactFilter() {
        return ResetContactFilter;
    }

    public MobileElement getFilterUsers() {
        return FilterUsers;
    }

    public MobileElement getFilterGroups() {
        return FilterGroups;
    }

    public MobileElement getConnectedUsers() {
        return ConnectedUsers;
    }

    public MobileElement getNotConnectedUsers() {
        return NotConnectedUsers;
    }

    public MobileElement getOnDutyUsers() {
        return OnDutyUsers;
    }

    public MobileElement getOffDutyUsers() {
        return OffDutyUsers;
    }

    public MobileElement getDefault() {
        return Default;
    }

    public MobileElement getContactGeolocation() {
        return ContactGeolocation;
    }

    public MobileElement getSendEmail() {
        return SendEmail;
    }

    public MobileElement getSendMessage() {
        return SendMessage;
    }

    public MobileElement getCallOutPBX() {
        return CallOutPBX;
    }

    public MobileElement getContactDetails() {
        return ContactDetails;
    }

    public MobileElement getOpenGroupConversation() {
        return OpenGroupConversation;
    }

    public MobileElement getNewGroupConversation() {
        return NewGroupConversation;
    }

    public ContactScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getBroadcastVideoCall(){
        return BroadcastVideoCall;
    }

    public MobileElement getContactAvatar(){
        return ContactAvatar;
    }

    public MobileElement getUserDetailsCall(){
        return UserDetailsCall;
    }

    public MobileElement getUserDetailsConversation(){
        return UserDetailsConversation;
    }

    public MobileElement getUserDetailsGeolocation(){
        return UserDetailsGeolocation;
    }

    public MobileElement getUserDetailsSendMail(){
        return UserDetailsSendMail;
    }

    public MobileElement getUserPhoneNumber(){
        return UserPhoneNumber;
    }

    public MobileElement getUserMail(){
        return UserMail;
    }

    public MobileElement getUserGroupDetails(){
        return UserGroupDetails;
    }

    public MobileElement getUserAllMedia(){
        return UserAllMedia;
    }

    public MobileElement getContactIconAvailability(){
        return ContactIconAvailability;
    }

    public MobileElement getContactIcon(){
        return ContactIcon;
    }

    public MobileElement getContactResultSearchList(){
        return ContactResultSearchList;
    }

    public void checkOptionsOfContactThread() throws IOException, InterruptedException {
        ContactScreen contactScreen= new ContactScreen ( mDriver);
        contactScreen.CheckDisplayedOfElement(contactScreen.getCompanyContact(), "My company contact ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getMyContact(), "Local contact  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(), "Multiselect ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoStreamButton(), "Streaming Button  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCallButton(), "Call Button  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactFilterButton(), "filter list contact  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSearchButton(), "search  ");
    }
    public void dismissAlerts(){
        ContactScreen contactScreen= new ContactScreen ( mDriver);

        contactScreen.dismissAlert();
    }

    public void checkContactOptions() throws IOException, InterruptedException {
        ContactScreen contactScreen= new ContactScreen ( mDriver);
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactDetails(), "Details");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVOIPCall(), "Call");
        contactScreen.CheckDisplayedOfElement(contactScreen.getPTTCall(), "Push-To-Talk");
        contactScreen.CheckDisplayedOfElement(contactScreen.getConfCall(), "Conference Call");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoCall(), "Video Call");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCellularCall(), "Cellular Call");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCallOutPBX(), "Call Out via PBX");
        contactScreen.CheckDisplayedOfElement(contactScreen.getBroadcastVideoCall(), "Broadcast Video");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSendMessage(), "Send Message");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSendEmail(), "Email");
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactGeolocation(), "Geolocation");

    }
    public void checkContactDetails() throws IOException, InterruptedException {
        ContactScreen contactScreen= new ContactScreen ( mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen ( mDriver);
        tabBarScreen.getContactItem();
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactAvatar(), "User Avatar");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserDetailsCall(), "User Call");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserDetailsConversation(), "Send Message");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserDetailsGeolocation(), "Geolocation");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserDetailsSendMail(), "Send Mail");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserPhoneNumber(), "Phone Number");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserMail(), "User Mail");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserGroupDetails(), "User Group details");
        contactScreen.CheckDisplayedOfElement(contactScreen.getUserAllMedia(), "User All media");

    }
    public void SearchContact(String Account) throws IOException, InterruptedException {
        TabBarScreen tabBarScreen= new TabBarScreen ( mDriver);
        tabBarScreen.getContactItem();
        getSearchButton().click();
       getSearchContent().sendKeys(Account);
    }

    public void clickOnSearchResult(){

        WebDriverWait wait = new WebDriverWait(mDriver, 180);
        try {
            wait.until(ExpectedConditions.visibilityOf(getSearchResult()));
        } catch (TimeoutException e) {
            Assert.fail("Search result not found");
        }
        getSearchResult().click();
    }

}