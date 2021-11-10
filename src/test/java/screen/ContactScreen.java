package screen;

import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import screen.settings.OptionScreen;
import screen.settings.SettingsMoreScreen;
import screen.settings.SettingsScreen;

import java.io.IOException;
import java.net.MalformedURLException;

public class ContactScreen extends STWScreen {
    public MobileElement getExternalUserInvitationButton() {
        return ExternalUserInvitationButton;
    }
    //ExternalUserInvitationButton
    @AndroidFindBy(id = "contact_bottom_bar_invite_external_user")
    @iOSXCUITFindBy(accessibility = "ContactsViewController_inviteExternalButton")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Contact details\"]")
    private MobileElement ContactDetails ;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Call Out via PBX']",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call Out via PBX']")
    private MobileElement CallOutPBX ;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Video Streaming", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadcast Video']")
    private MobileElement BroadcastVideoCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Message']")
    private MobileElement SendMessage ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    private MobileElement SendEmail ;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Location", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Geolocation']")
    private MobileElement ContactGeolocation ;

    //Group options
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "New conversation", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New conversation']")
    private MobileElement NewGroupConversation ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open conversation']")
    private MobileElement OpenGroupConversation ;


    //Multiselect to start or open conversation , start Group call , Broadcast Video
    @AndroidFindBy(id = "bottom_multiselect")
    @iOSXCUITFindBy(accessibility = "ContactsViewController_selectedButton")
    private MobileElement Multiselect ;


    //Start or open Conversation
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Open a conversation", priority = 1)
    @AndroidFindBy(id = "bottom_open_new_conversation")
    private MobileElement OpenConversation ;

    //Call list (VOIP,PTT,Conf,VideoCall,Cellular,Dialer)
    @AndroidFindBy(id = "contact_bottom_voip_call")
    private MobileElement CallButton ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
    private MobileElement VOIPCall ;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PTT Call']",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Push-To-Talk']")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_pttCall")
    private MobileElement PTTCall ;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Conference Call", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conference Call']")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_conferenceCall")
    private MobileElement ConfCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Call']")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_videoCall")
    private MobileElement VideoCall ;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cellular Call']")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_cellularCall")
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
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_ContactImage")
    private MobileElement ContactAvatar;
    @AndroidFindBy(id = "contact_details_call")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_CallButton")
    private MobileElement UserDetailsCall;
    @AndroidFindBy(id = "contact_details_new_message")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_ConversationButton")
    private MobileElement UserDetailsConversation;
    @AndroidFindBy(id = "contact_details_geolocation")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_WayButton")
    private MobileElement UserDetailsGeolocation;
    @AndroidFindBy(id = "contact_details_send_email")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_EmailButton")
    private MobileElement UserDetailsSendMail;
    @AndroidFindBy(id = "phone_number_contact_details")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_0_2")
    private MobileElement UserPhoneNumber;
    @AndroidFindBy(id = "email_adress_contact_details")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_0_1")
    private MobileElement UserMail;
    @AndroidFindBy(id = "contact_business_detail_group_view")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_1_0")
    private MobileElement UserGroupDetails;
    @AndroidFindBy(id = "contact_business_detail_all_media_view")
    @iOSXCUITFindBy(accessibility = "ContactDetailsViewController_1_1")
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
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)

    @AndroidFindBy(id = "bottom_search")
    @AndroidFindBy(id = "search_contact",priority = 1)

    @iOSXCUITFindBy(accessibility = "Search")
    private MobileElement SearchButton ;
    @AndroidFindBy(id = "contact_search_content")
    @iOSXCUITFindBy(accessibility = "Search")
    private MobileElement SearchContent ;

    public void enterContactToSearch(String contact) { SearchContent.sendKeys(contact); }

    @AndroidFindBy(id ="contact_single_item_data_container")
    @FindBy(xpath = "(//XCUIElementTypeCell[@name=\"ContactsViewController_0_0\"])[2]")
    private MobileElement SearchResult;
    public  MobileElement getSearchResult(){return  SearchResult;}




    public MobileElement getCompanyContact() {
        return companyContact;
    }

    public MobileElement getMyContact() {
        return MyContact;
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


    //Contact list view
    @AndroidFindBy(id = "Back")
    @iOSXCUITFindBy(accessibility = "ContactsViewController_selectedButton")
    private MobileElement CancelSelect;
    @iOSXCUITFindBy(accessibility = "Conversation sectionTitleArrow")
    private MobileElement selectCompany;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_callBarButton")
    private MobileElement CallBtn;

    // call option One to one
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_voiceCall")
    private MobileElement VoipCall;

    @iOSXCUITFindBy(accessibility = "VoipActionSheet_dialer")
    private MobileElement DialerCall;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_cancel")
    private MobileElement CancelBtn;


    @iOSXCUITFindBy(accessibility = "ContactsViewController_videoStreamingButton")
    private MobileElement VideoStreamBtn;

    // video streaming option
    @iOSXCUITFindBy(accessibility = "ContactsViewController_action0")
    private MobileElement DispatchManager;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_action1")
    private MobileElement ContactStream;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_action2")
    private MobileElement CancelBttn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ContactsViewController_cancelAction\"]")
    private MobileElement BtnCancel;


    @iOSXCUITFindBy(accessibility = "ContactsViewController_searchBar")
    private MobileElement SearchContact;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_ContactFilter")
    private MobileElement ContactListFilter;

    //filter screen
    @iOSXCUITFindBy(accessibility = "FilterStatusViewController_cancelButtonItem")
    private MobileElement CancelBtnFilter;
    @iOSXCUITFindBy(accessibility = "FilterStatusViewController_showFilterButtonItem")
    private MobileElement ApplyBtnFilter;
    @iOSXCUITFindBy(accessibility = "FilterStatusViewController_clearFilters")
    private MobileElement ClearBtnFilter;
    @iOSXCUITFindBy(accessibility = "FilterStatusViewController_defaultFilters")
    private MobileElement DefaultBtnFilter;

    //Operation Status screen
    @iOSXCUITFindBy(accessibility = "OperationalStatusViewController_saveButtonItem")
    private MobileElement OperationStatusSave;
    @iOSXCUITFindBy(accessibility = "OperationalStatusViewController_cancelButtonItem")
    private MobileElement OperationStatusCancel;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Rechercher\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search\"])[1]")
    private MobileElement searchContact;

    @iOSXCUITFindBy(accessibility = "ContactsViewController_0_0")
    private MobileElement ResultsearchContact;

    @FindBy(xpath = "(//XCUIElementTypeCell[@name=\"ContactsViewController_0_0\"])[2]")
    private MobileElement searchContactResult;

    //Swipe options
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PTT Call", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonPTT\"])[2]")
    private MobileElement swipeGroupPTTCallOption;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonMore\"])[2]")
    private MobileElement swipeGroupMoreOption;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonDetails\"])[2]")
    private MobileElement swipeGroupDetailsOption;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonConversation\"])[2]")
    private MobileElement swipeSendMessage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonMoreOne\"])[2]")
    private MobileElement swipeMoreOption;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Group details", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ContactsViewController_buttonDetails\"])[2]")
    private MobileElement swipeDetailsOption;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"ContactsViewController_LiveCall\"]")
    private MobileElement VoipCallList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_videoCall")
    private MobileElement VideoCallList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_callOutPbxCall")
    private MobileElement CallOutPBXList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_actionPTT")
    private MobileElement PTTCallList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_videoStreamAction")
    private MobileElement BroadcastList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_cellularAction")
    private MobileElement CellularCallList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_conference")
    private MobileElement ConfCallList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_geolocation")
    private MobileElement GeolocationList;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_emailAction")
    private MobileElement EmailList;

    public MobileElement getCancelBtnFilter() {
        return CancelBtnFilter;
    }

    public MobileElement getApplyBtnFilter() {
        return ApplyBtnFilter;
    }

    public MobileElement getSwipeGroupPTTCallOption() {
        return swipeGroupPTTCallOption;
    }

    public MobileElement getSwipeGroupMoreOption() {
        return swipeGroupMoreOption;
    }

    public MobileElement getSwipeGroupDetailsOption() {
        return swipeGroupDetailsOption;
    }

    public MobileElement getSwipeSendMessage() {
        return swipeSendMessage;
    }

    public MobileElement getSwipeMoreOption() {
        return swipeMoreOption;
    }

    public MobileElement getSwipeDetailsOption() {
        return swipeDetailsOption;
    }

    public MobileElement getMultiselect() {
        return Multiselect;
    }

    public MobileElement getSelectCompany() {
        return selectCompany;
    }

    public MobileElement getCallBtn() {
        return CallBtn;
    }

    public MobileElement getVideoStreamBtn() {
        return VideoStreamBtn;
    }

    public MobileElement getContactListFilter() {
        return ContactListFilter;
    }

    public MobileElement getDefaultBtnFilter() {
        return DefaultBtnFilter;
    }

    public MobileElement getClearBtnFilter() {
        return ClearBtnFilter;
    }

    public MobileElement getOperationStatusSave() {
        return OperationStatusSave;
    }

    public MobileElement getOperationStatusCancel() {
        return OperationStatusCancel;
    }


    public MobileElement getCancelBtn() {
        return CancelBtn;
    }

    public MobileElement getVoipCall() {
        return VoipCall;
    }

    public MobileElement getVideoCall() {
        return VideoCall;
    }

    public MobileElement getPTTCall() {
        return PTTCall;
    }

    public MobileElement getCellularCall() {
        return CellularCall;
    }

    public MobileElement getConfCall() {
        return ConfCall;
    }

    public MobileElement getDialerCall() {
        return DialerCall;
    }

    public MobileElement getCancelBttn() {
        return CancelBttn;
    }

    public MobileElement getContactStream() {
        return ContactStream;
    }

    public MobileElement getDispatchManager() {
        return DispatchManager;
    }

    public MobileElement getCancelSelect() {
        return CancelSelect;
    }

    public MobileElement getSearchContactResult() { return searchContactResult; }

    public MobileElement getSearchContact() { return searchContact; }
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='First name']")
    private MobileElement mFirstName;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Last name']")
    private MobileElement mLastname;
    @AndroidFindBy(id = "com.teamontherun.preprod:id/main_fab")
    @iOSXCUITFindBy(accessibility = "FloatingView_floatingButton")
    public MobileElement PlusButtonMain;

    @AndroidFindBy(id="com.teamontherun.preprod:id/main_fab")
    @iOSXCUITFindBy(accessibility="FloatingView_floatingButton")
    private MobileElement PlusButtonContact;
    public MobileElement getPlusButtonContact(){
        return PlusButtonContact;
    }

    public void enterTheContactToSearch(String contact) { searchContact.sendKeys(contact); }

    public void clickOnSearchResult() { searchContactResult.click(); }

    public MobileElement getResultsearchContact(){
        return ResultsearchContact;
    }

    public MobileElement getBtnCancel(){
        return BtnCancel;
    }

    public MobileElement getVoipCallList(){
        return VoipCallList;
    }

    public MobileElement getVideoCallList(){
        return VideoCallList;
    }

    public MobileElement getEmailList(){
        return EmailList;
    }

    public MobileElement getGeolocationList(){
        return GeolocationList;
    }

    public MobileElement getConfCallList(){
        return ConfCallList;
    }

    public MobileElement getCellularCallList(){
        return CellularCallList;
    }

    public MobileElement getBroadcastList(){
        return BroadcastList;
    }

    public MobileElement getPTTCallList(){
        return PTTCallList;
    }

    public MobileElement getCallOutPBXList(){
        return CallOutPBXList;
    }

    public void checkOptionsOfContactThread() throws IOException, InterruptedException {
        if(Platforms.ANDROID.equals(mPlatform)) {
            if (Branding.TOTR.equals(branding)){
        ContactScreen contactScreen= new ContactScreen( mDriver);
        //contactScreen.CheckDisplayedOfElement(contactScreen.getCompanyContact(), "My company contact ");
        //contactScreen.CheckDisplayedOfElement(contactScreen.getMyContact(), "Local contact  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(), "Multiselect ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoStreamButton(), "Streaming Button  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCallButton(), "Call Button  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactFilterButton(), "filter list contact  ");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSearchButton(), "search  ");
        }
      else{
                ContactScreen contactScreen= new ContactScreen( mDriver);
                contactScreen.CheckDisplayedOfElement(contactScreen.getContactFilterButton(), "filter list contact  ");
                contactScreen.CheckDisplayedOfElement(contactScreen.getSearchButton(), "search  ");
                contactScreen.CheckDisplayedOfElement(contactScreen.getPlusButtonContact(),"PlusButton");
            }
        }
        else {
            if (Branding.TOTR.equals(branding)){
            ContactScreen contactScreen= new ContactScreen( mDriver);
            contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(),"Multiselect");
                contactScreen.CheckDisplayedOfElement(contactScreen.getCallBtn(),"Call botton");
                contactScreen.CheckDisplayedOfElement(contactScreen.getResultsearchContact(),"Search contact");
                contactScreen.CheckDisplayedOfElement(contactScreen.getContactListFilter(),"Contact filter");
                contactScreen.CheckDisplayedOfElement(contactScreen.getVideoStreamBtn(),"Video stream botton");
                //contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
            //contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Contact details");
            //contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"More contact option");
            //contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send Message");
        }
            else{
                ContactScreen contactScreen= new ContactScreen( mDriver);
                contactScreen.CheckDisplayedOfElement(contactScreen.getContactFilterButton(), "filter list contact  ");
                contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(), "Multiselect ");
                contactScreen.CheckDisplayedOfElement(contactScreen.getSearchButton(), "search  ");
                contactScreen.CheckDisplayedOfElement(contactScreen.getPlusButtonContact(),"PlusButton");

            }
        }
    }
    public void ChangeContactSortToLastName() throws IOException, InterruptedException {
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){
                TabBarScreen.goToMore();
            mLogger.log(Status.PASS, "1-go to settings");
            settingsMoreScreen.clickOnSettings();
            mLogger.log(Status.PASS, "2-click on option");
            settingsScreen.clickOnOptions();
            mLogger.log(Status.PASS, "3-click on contact sort option");
            optionScreen.clickOnSortContactBy();
            mLogger.log(Status.PASS, "4-user can change option from : sort by first name to sort by last name");
            optionScreen.getmLastname();

        }
            else{
            TabBarScreen.goToMore();
            mLogger.log(Status.PASS, "1-go to settings");
            settingsMoreScreen.clickOnSettings();
            mLogger.log(Status.PASS, "2-click on option");
            settingsScreen.clickOnOptions();
            mLogger.log(Status.PASS, "3-click on contact sort option");
            optionScreen.clickOnSortContactBy();
            mLogger.log(Status.PASS, "4-user can change option from : sort by first name to sort by last name");
            optionScreen.getmLastname().click();
            optionScreen.getSave().click();

        }
    }

    public void ChangeContactSortToFirstName() throws IOException, InterruptedException {
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){
            TabBarScreen.goToMore();
            mLogger.log(Status.PASS, "1-go to settings");
            settingsMoreScreen.clickOnSettings();
            mLogger.log(Status.PASS, "2-click on option");
            settingsScreen.clickOnOptions();
            mLogger.log(Status.PASS, "3-click on contact sort option");
            optionScreen.clickOnSortContactBy();
            mLogger.log(Status.PASS, "4-user can change option from : sort by first name to sort by last name");
            optionScreen.getmFirstName();

        }
        else{
            TabBarScreen.goToMore();
            mLogger.log(Status.PASS, "1-go to settings");
            settingsMoreScreen.clickOnSettings();
            mLogger.log(Status.PASS, "2-click on option");
            settingsScreen.clickOnOptions();
            mLogger.log(Status.PASS, "3-click on contact sort option");
            optionScreen.clickOnSortContactBy();
            mLogger.log(Status.PASS, "4-user can change option from : sort by first name to sort by last name");
            optionScreen.getmFirstName().click();
            optionScreen.getSave().click();

        }
    }
    public void dismissAlerts(){
        ContactScreen contactScreen= new ContactScreen( mDriver);

        contactScreen.dismissAlert();
    }

    public void checkContactOptions() throws IOException, InterruptedException {
        if(Platforms.ANDROID.equals(mPlatform)) {
            ContactScreen contactScreen= new ContactScreen( mDriver);
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
        contactScreen.getContactDetails().click();
        }
        else {
            ContactScreen contactScreen= new ContactScreen( mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            //contactScreen.CheckDisplayedOfElement(contactScreen.getContactDetails(),"Contact details");
            //Thread.sleep(1000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getVoipCallList(),"Voip Call");
            Thread.sleep(2000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getVideoCallList(),"Video call");
            Thread.sleep(2000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getCellularCallList(),"Cellular call");
            Thread.sleep(2000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getPTTCallList(),"PTT call");
            Thread.sleep(2000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getConfCallList(),"Conf call");
            Thread.sleep(2000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getGeolocationList(),"Geolocation");
            Thread.sleep(1000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getEmailList(),"Email");
            Thread.sleep(1000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getBtnCancel(),"Cancel");
            Thread.sleep(1000);
            contactScreen.getBtnCancel().click();
            Thread.sleep(3000);
            tabBarScreen.goToContacts();
            mLogger.log(Status.PASS, "5 - Click on contact details and check UI");
            Thread.sleep(1000);
            contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
            contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Details option is displayed");
            contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"more option is displayed");
            contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send message option is displayed");
            contactScreen.getSwipeDetailsOption().click();
            Thread.sleep(3000);

        }

    }
    public void checkContactDetails() throws IOException, InterruptedException {
        ContactScreen contactScreen= new ContactScreen( mDriver);
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
        TabBarScreen tabBarScreen= new TabBarScreen( mDriver);
        tabBarScreen.goToContacts();
        getSearchButton().click();
        getSearchContent().sendKeys(Account);
    }

    public void ClickOnSearchResult(){

        WebDriverWait wait = new WebDriverWait(mDriver, 180);
        try {
            wait.until(ExpectedConditions.visibilityOf(getSearchResult()));
            getSearchResult().click();


        } catch (TimeoutException e) {
            Assert.fail("Search result not found");
        }

    }

    public void ClickOnContactSearchResult(String Account) throws MalformedURLException, InterruptedException{
        ContactScreen contactScreen= new ContactScreen( mDriver);

        if(Branding.TOTR.equals(branding)) {
            if (Platforms.ANDROID.equals(mPlatform)){
            //Android TOTR Long press

                contactScreen.LonPressOnString(Account,1,0);
                if(isElementDisplayed(contactScreen.getUserDetailsConversation())==false)
                    contactScreen.LonPressOnString(Account,0,1);

            }
            else{
            //iOS TOTR Swipe
                contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
                contactScreen.getSwipeMoreOption().click();
            }
        }
        //Agnet iOS and Android Simple click
        else
        {
        getSearchResult().click();
        }
    }

    public void SearchContactandClickOnHim(String contact) throws IOException, InterruptedException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.goToContacts();

        enterTheContactToSearch(contact);
        hideKeyboardIos();
        Thread.sleep(5000);
        clickOnSearchResult();
    }


    public MobileElement getmFirstName(){
        return mFirstName;
    }

    public MobileElement getmLastname(){
        return mLastname;
    }
}
