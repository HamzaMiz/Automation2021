package IOS.screen;

import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class ContactScreen extends STWScreen {

    public ContactScreen(AppiumDriver driver) {
        super(driver);
    }

    //ExternalUserInvitationButton
    @iOSXCUITFindBy(accessibility = "ContactsViewController_inviteExternalButton")
    private MobileElement ExternalUserInvitationButton ;

    //Contact list view
    @iOSXCUITFindBy(accessibility = "ContactsViewController_selectedButton")
    private MobileElement Multiselect;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_selectedButton")
    private MobileElement CancelSelect;
    @iOSXCUITFindBy(accessibility = "Conversation sectionTitleArrow")
    private MobileElement selectCompany;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_callBarButton")
    private MobileElement CallBtn;

    // call option One to one
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_voiceCall")
    private MobileElement VoipCall;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_videoCall")
    private MobileElement VideoCall;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_pttCall")
    private MobileElement PTTCall;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_cellularCall")
    private MobileElement CellularCall;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_conferenceCall")
    private MobileElement ConfCall;
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

    public MobileElement getExternalUserInvitationButton() {
        return ExternalUserInvitationButton;
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
       ContactScreen contactScreen= new ContactScreen( mDriver);
        contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(),"Multiselect");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSelectCompany(),"Select company");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCallBtn(),"Call botton");
        contactScreen.CheckDisplayedOfElement(contactScreen.getResultsearchContact(),"Search contact");
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactListFilter(),"Contact filter");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoStreamBtn(),"Video stream botton");
        contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Contact details");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"More contact option");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send Message");
    }

    public void checkContactOptions() throws IOException, InterruptedException {
        ContactScreen contactScreen= new ContactScreen( mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        Thread.sleep(1000);
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
        tabBarScreen.getContactsItem();
        mLogger.log(Status.PASS, "5 - Click on contact details and check UI");
        Thread.sleep(1000);
        contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Details option is displayed");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"more option is displayed");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send message option is displayed");
        contactScreen.getSwipeDetailsOption().click();

        Thread.sleep(3000);

    }

    public void SearchContactandClickOnHim(String contact) throws IOException, InterruptedException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.clickOnContactsButton();

        enterTheContactToSearch(contact);
       hideKeyboardIos();
       Thread.sleep(5000);
       clickOnSearchResult();
    }
}
