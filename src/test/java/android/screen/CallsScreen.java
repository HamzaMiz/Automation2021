package android.screen;

import IOS.screen.ContactScreen;
import IOS.screen.DialerScreen;
import IOS.screen.PermissionsScreen;
import IOS.screen.Settings.SettingsScreen;
import IOS.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.screen.STWScreen;
import framework.tester.STWAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.io.IOException;
import java.net.MalformedURLException;

public class CallsScreen extends STWScreen {

    public CallsScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements of PTT Call screen
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]",priority = 2)
    @iOSXCUITFindBy(accessibility = "Accept")
    @AndroidFindBy(id = "walkie_talkie_accept_btn",priority = 1)
    @AndroidFindBy(id = "accept_call_waiting_image_btn")
    private MobileElement AcceptPTTCall ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_pushToTalkButton")
    @AndroidFindBy(id = "walkie_talkie_push_button")
    private MobileElement PTT_TakeTheFloor ;

    @iOSXCUITFindBy(accessibility = "PushToTalkView_addButton")
    @AndroidFindBy(id = "walkie_talkie_add_contact_btn")
    private MobileElement PTT_addContactBtn ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_detailsButton")
    @AndroidFindBy(id = "walkie_talkie_contact_details_btn")
    private MobileElement PTT_ContactDetailsBtn ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther\n")
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_list")
    private MobileElement PTT_ListofContactDetails ;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_ok_btn")
    private MobileElement PTT_OK_ListContact ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_videoStreaming")
    @AndroidFindBy(id = "walkie_talkie_video_streaming_button")
    private MobileElement PTT_VideoStreamingBtn ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_geoLocButton")
    @AndroidFindBy(id = "walkie_talkie_geoloc_btn")
    private MobileElement PTT_geolocBtn ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_goToConversationButton")
    @AndroidFindBy(id = "walkie_talkie_go_to_conversation_btn")
    private MobileElement PTT_GoToConversation ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_participentsCollectionView")
    @AndroidFindBy(id = "view_voip_contact_image")
    private MobileElement PTT_Account_image ;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private MobileElement touchToComeBackToCall ;

    @iOSXCUITFindBy(accessibility = "PushToTalkView_speackerBtn")
    @AndroidFindBy(id = "walkie_talkie_speaker_btn")
    private MobileElement PTT_SpeakerBTN ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_hideButton")
    @AndroidFindBy(id = "walkie_talkie_back_btn")
    private MobileElement PTT_BackButton ;
    @iOSXCUITFindBy(accessibility = "STOP")
    @AndroidFindBy(id = "stop_video_streaming_button")
    private MobileElement stopVideoStreaming ;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_self.cancelButton")
    @AndroidFindBy(id = "walkie_talkie_reject_btn")
    private MobileElement  End_PTT_Call;
    @iOSXCUITFindBy(accessibility = "On Duty contacts")
    @AndroidFindBy(id = "title_template")
    private MobileElement  Pop_up_Of_OnDuty;
    @iOSXCUITFindBy(accessibility = "On Duty contacts")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty contacts']")
    private MobileElement Call_On_Duty_contacts ;
    @iOSXCUITFindBy(accessibility = "All group contacts")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All group contacts']")
    private MobileElement Call_All_group_contacts ;
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_availibilityStatusView")
    @AndroidFindBy(id = "activity_message_user_availability_explanation")
    private MobileElement Sent_To_On_Duty_Users_Toast ;
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    @AndroidFindBy(id = "alertTitle")
    private MobileElement alertTitle ;

    //Elements of Conference Call screen
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]",priority = 2)
    @iOSXCUITFindBy(accessibility = "Accept")
    @AndroidFindBy(id = "accept_call_waiting_image_btn", priority = 1)
    @AndroidFindBy(id = "conference_call_accept_btn")
    private MobileElement AcceptConferenceCall ;
    @iOSXCUITFindBy(accessibility = "9 Voip poc earpiece")
    @AndroidFindBy(id = "conference_call_speaker_btn")
    private MobileElement conference_call_speaker_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "conference_call_mute_btn")
    private MobileElement conference_call_mute_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip goToGeoLocationButton")
    @AndroidFindBy(id = "conference_call_geoloc_btn")
    private MobileElement conference_call_geoloc_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip videoStreamingButton")
    @AndroidFindBy(id = "conference_call_video_streaming_button")
    private MobileElement conference_call_video_streaming_button ;
    @iOSXCUITFindBy(accessibility = "9 Voip goToConversationButton")
    @AndroidFindBy(id = "conference_call_go_to_conversation_btn")
    private MobileElement conference_call_go_to_conversation_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip endLiveVoipCallIcon")
    @AndroidFindBy(id = "conference_call_reject_btn")
    private MobileElement conference_call_reject_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip AddButton")
    @AndroidFindBy(id = "conference_call_add_contact_btn")
    private MobileElement conference_call_add_contact_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip moreDetailsButton")
    @AndroidFindBy(id = "conference_call_contact_details_btn")
    private MobileElement conference_call_contact_details_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "conference_call_back_btn")
    private MobileElement conference_call_back_btn ;

    public MobileElement getConference_call_back_btn() {
        return conference_call_back_btn;
    }

    public MobileElement getConference_call_add_contact_btn() {
        return conference_call_add_contact_btn;
    }

    public MobileElement getConference_call_contact_details_btn() {
        return conference_call_contact_details_btn;
    }

    public MobileElement getConference_call_speaker_btn() {
        return conference_call_speaker_btn;
    }

    public MobileElement getConference_call_mute_btn() {
        return conference_call_mute_btn;
    }

    public MobileElement getConference_call_geoloc_btn() {
        return conference_call_geoloc_btn;
    }

    public MobileElement getConference_call_video_streaming_button() {
        return conference_call_video_streaming_button;
    }

    public MobileElement getConference_call_go_to_conversation_btn() {
        return conference_call_go_to_conversation_btn;
    }

    public MobileElement getConference_call_reject_btn() {
        return conference_call_reject_btn;
    }

    public MobileElement getAcceptConferenceCall() {
        return AcceptConferenceCall;
    }


    public MobileElement getSent_To_On_Duty_Users_Toast() {
        return Sent_To_On_Duty_Users_Toast;
    }

    public MobileElement getAlertTitle() {
        return alertTitle;
    }

    public MobileElement getPop_up_Of_OnDuty() {
        return Pop_up_Of_OnDuty;
    }

    public MobileElement getCall_On_Duty_contacts() {
        return Call_On_Duty_contacts;
    }

    public MobileElement getCall_All_group_contacts() {
        return Call_All_group_contacts;
    }

    public MobileElement getEnd_PTT_Call() {
        return End_PTT_Call;
    }

    //Elements of Video Call screen
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "mute_btn")
    private MobileElement VideoCall_Mute ;
    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOptionSelect")
    @AndroidFindBy(id = "speaker_btn")
    private MobileElement VideoCall_speaker_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "back_btn")
    private MobileElement VideoCall_back_btn ;
    @AndroidFindBy(id = "voip_geolocation_image_button")
    @iOSXCUITFindBy(accessibility = "9 Voip goToGeoLocationButton")
    private MobileElement VideoCall_geolocation_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip goToConversationButton")
    @AndroidFindBy(id = "go_to_conversation_btn")
    private MobileElement VideoCall_go_to_conversation_btn ;
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    private MobileElement VideoCall_reject_call_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]",priority = 2)
    @iOSXCUITFindBy(accessibility = "Accept")
    @AndroidFindBy(id = "accept_call_btn",priority = 1)
    @AndroidFindBy(id = "accept_call_waiting_image_btn")
    private MobileElement AcceptVideoCall ;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Teamontherun']")
    @AndroidFindBy(id = "wide_camera_preview_surface_view")
    private MobileElement VideoCall_Screen ;
    @iOSXCUITFindBy(accessibility = "9 Voip transferIconBackground")
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement Transfert_videoCall_Btn ;


    //Elements of Video Broadcast screen
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_bannerInfoView.eyeStreamingButton")
    @AndroidFindBy(id = "video_streaming_header_label")
    private MobileElement Video_Broadcast_Bar ;
    @iOSXCUITFindBy(accessibility = "STOP")
    @AndroidFindBy(id = "stop_video_streaming_button")
    private MobileElement Video_Broadcast_Stop_Btn ;
    @AndroidFindBy(id = "video_streaming_icon")
    private MobileElement Video_Broadcast_header_icon ;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip respondStreamVideoCallI")
    @iOSXCUITFindBy(accessibility = "AcceptLiveCall",priority = 1)
    @AndroidFindBy(id = "accept_call_waiting_btn",priority = 1)
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement AcceptVideoBroadcast ;



    //Elements of External Call via PBX screen
    @AndroidFindBy(id = "speaker_btn")
    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOption")
    private MobileElement externalSpeakersBtn ;
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "mute_btn")
    private MobileElement externalMuteBtn ;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "back_btn")
    private MobileElement externalDismissBtn ;
    @AndroidFindBy(id = "dialer_btn")
    @iOSXCUITFindBy(accessibility = "9 Voip swout keyboardIcon")
    private MobileElement externalDialerBtn ;
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    private MobileElement externalRejectBtn ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Outgoing Push-To-Talk']")
    @iOSXCUITFindBy(accessibility = "Outgoing Push-To-Talk")
    private MobileElement incomingPttSentence ;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeImage[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"ContactCell_secondLabel\"])[2]")
    private MobileElement firstInstance;

    public MobileElement getFirstInstance() {
        return firstInstance;
    }

    public MobileElement getTouchToComeBackToCall() {
        return touchToComeBackToCall;
    }

    public MobileElement getIncomingPttSentence() {
        return incomingPttSentence;
    }

    public MobileElement getExternalSpeakersBtn() {
        return externalSpeakersBtn;
    }

    public MobileElement getExternalMuteBtn() {
        return externalMuteBtn;
    }

    public MobileElement getExternalDismissBtn() {
        return externalDismissBtn;
    }

    public MobileElement getExternalDialerBtn() {
        return externalDialerBtn;
    }

    public MobileElement getExternalRejectBtn() {
        return externalRejectBtn;
    }

    public MobileElement getAcceptVideoBroadcast() {
        return AcceptVideoBroadcast;
    }


    public MobileElement getVideo_Broadcast_Bar() {
        return Video_Broadcast_Bar;
    }



    public MobileElement getVideo_Broadcast_Stop_Btn() {
        return Video_Broadcast_Stop_Btn;
    }

    public MobileElement getVideo_Broadcast_header_icon() {
        return Video_Broadcast_header_icon;
    }

    public MobileElement getTransfert_videoCall_Btn() {
        return Transfert_videoCall_Btn;
    }

    public MobileElement getAcceptVideoCall() {
        return AcceptVideoCall;
    }


    public MobileElement getVideoCall_Screen() {
        return VideoCall_Screen;
    }

    public MobileElement getVideoCall_Mute() {
        return VideoCall_Mute;
    }

    public MobileElement getVideoCall_speaker_btn() {
        return VideoCall_speaker_btn;
    }

    public MobileElement getVideoCall_back_btn() {
        return VideoCall_back_btn;
    }

    public MobileElement getVideoCall_geolocation_btn() {
        return VideoCall_geolocation_btn;
    }

    public MobileElement getVideoCall_go_to_conversation_btn() {
        return VideoCall_go_to_conversation_btn;
    }

    public MobileElement getVideoCall_reject_call_btn() {
        return VideoCall_reject_call_btn;
    }

    public MobileElement getStopVideoStreaming() {
        return stopVideoStreaming;
    }

    public MobileElement getPTT_Account_image() {
        return PTT_Account_image;
    }

    public MobileElement getPTT_SpeakerBTN() {
        return PTT_SpeakerBTN;
    }

    public MobileElement getPTT_BackButton() {
        return PTT_BackButton;
    }

    public MobileElement getAcceptPTTCall() {
        return AcceptPTTCall;
    }



    public MobileElement getPTT_TakeTheFloor() {
        return PTT_TakeTheFloor;
    }

    public MobileElement getPTT_addContactBtn() {
        return PTT_addContactBtn;
    }

    public MobileElement getPTT_ContactDetailsBtn() {
        return PTT_ContactDetailsBtn;
    }

    public MobileElement getPTT_ListofContactDetails() {
        return PTT_ListofContactDetails;
    }

    public MobileElement getPTT_OK_ListContact() {
        return PTT_OK_ListContact;
    }

    public MobileElement getPTT_VideoStreamingBtn() {
        return PTT_VideoStreamingBtn;
    }

    public MobileElement getPTT_geolocBtn() {
        return PTT_geolocBtn;
    }

    public MobileElement getPTT_GoToConversation() {
        return PTT_GoToConversation;
    }



    public void startConferenceCall(String GroupAccount) throws InterruptedException, MalformedURLException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            IOS.screen.ContactScreen contactScreen = new IOS.screen.ContactScreen(mDriver);
            goToContactsTab();
            contactScreen.getCallBtn().click();
            contactScreen.getConfCall().click();
            ConversationScreen.getSearchContact().click();
            ConversationScreen.getSearchContact().sendKeys(GroupAccount);
            Thread.sleep(3000);
            CallsScreen callsScreen = new CallsScreen(mDriver);
            //callsScreen.getFirstInstance().click();
            ConversationScreen.clickOnFirstCell(GroupAccount);

            //PressOnElement();

            //ConversationScreen.selectorToClick(GroupAccount);
            ConversationScreen.getConfirmBtn().click();
        }else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            CallsScreen callsScreen = new CallsScreen(mDriver);
            android.screen.TabBarScreen tabBarScreen = new android.screen.TabBarScreen(mDriver);
            tabBarScreen.getMessageItem();
            ConversationScreen.getConversationNewCall().click();
            ConversationScreen.getConference_Call().click();


            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(GroupAccount, 0, 1).click();
            ConversationScreen.getCheckButton().click();
        }
    }

    public void checkPopupOfOnDuty() throws InterruptedException {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
                mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");
                CallsScreen.getCall_All_group_contacts().click();
                Thread.sleep(2000);
            }
            Thread.sleep(5000);

    }

    public void clickToAcceptConferenceCall() {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            CallsScreen2.getAcceptConferenceCall().click();

    }

    public void checkItemsOfConferenceCallScreen() throws IOException, InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            CallsScreen.getConference_call_speaker_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_mute_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_geoloc_btn().click();
            Thread.sleep(5000);
            CallsScreen.getTouchToComeBackToCall();
            Thread.sleep(3000);
            CallsScreen.getConference_call_video_streaming_button().click();
            // CallsScreen.back();
            mLogger.log(Status.PASS, "2 - B accept the  call ");
            CallsScreen.getConference_call_reject_btn().click();
        }
        else {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            Thread.sleep(3000);
            CallsScreen.getConference_call_speaker_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_speaker_btn().click();
            CallsScreen.getConference_call_mute_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_geoloc_btn().click();
            Thread.sleep(5000);
            CallsScreen.back();
            CallsScreen.getConference_call_video_streaming_button().click();
            // CallsScreen.back();

            CallsScreen.getConference_call_reject_btn().click();

        }
    }

    public void acceptPermission() {
        if(Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            permissionsScreen.acceptPermissions();
        }else
        {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.dismissAlert();
        }
    }

    public void goToContactsTab() throws InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            IOS.screen.TabBarScreen tabBarScreen = new IOS.screen.TabBarScreen(mDriver);
            tabBarScreen.goToContacts();
        }else {

        }


    }

    public void openConversationWithSecondAccount(String First_Account) throws InterruptedException, MalformedURLException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            IOS.screen.TabBarScreen tabBarScreen = new IOS.screen.TabBarScreen(mDriver);
            tabBarScreen.goTochats();

            ConversationScreen.getConversationNewMessage().click();
            //ConversationScreen.getSearchContact().sendKeys(Account1);
            Thread.sleep(3000);
            ConversationScreen.getSearchContact().sendKeys(First_Account);

            Thread.sleep(3000);
            CallsScreen callsScreen = new CallsScreen(mDriver);
            //callsScreen.getFirstInstance().click();
            ConversationScreen.clickOnFirstCell(First_Account);

            // PressOnElement(First_Account);

            //ConversationScreen.selectorToClick();
            ConversationScreen.getCheckButton().click();
        }
        else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            android.screen.TabBarScreen tabBarScreen = new android.screen.TabBarScreen(mDriver);

            tabBarScreen.getMessageItem();

            ConversationScreen.getConversationNewMessage().click();
            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(First_Account);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(First_Account, 0, 1).click();
            ConversationScreen.getCheckButton().click();
        }
    }

    public void startVideoCall() throws InterruptedException {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.getConversationNewCall().click();
            ConversationScreen.getVideo_Call().click();
            mLogger.log(Status.PASS, "1 - A call B video call ");

            Thread.sleep(5000);

    }

    public void acceptVideoCall() {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);
            CallsScreen2.getAcceptVideoCall().click();

    }

    public void checkItemsOfVideoCallScreen() throws IOException, InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            mLogger.log(Status.PASS, "2 - B accept the  call ");


            //Sanity check For Video call screen
            CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_speaker_btn().click();

            Thread.sleep(3000);
            CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_Mute().click();

            Thread.sleep(3000);
            CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_Mute().click();
            CallsScreen.getVideoCall_geolocation_btn().click();
            Thread.sleep(5000);
            CallsScreen.getTouchToComeBackToCall().click();
            Thread.sleep(2000);
            //CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_go_to_conversation_btn().click();
            mLogger.log(Status.PASS, "3 - Users A & B excute a sanity check on call view ");
        }else
        {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            //Sanity check For Video call screen

            CallsScreen.getVideoCall_speaker_btn().click();
            //Thread.sleep(3000);
            CallsScreen.getVideoCall_speaker_btn().click();
            CallsScreen.getVideoCall_Mute().click();
            Thread.sleep(3000);
            CallsScreen.getVideoCall_Screen().click();
            Thread.sleep(3000);

            CallsScreen.getVideoCall_Mute().click();
            CallsScreen.getVideoCall_geolocation_btn().click();
            Thread.sleep(5000);
            CallsScreen.back();
            CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_go_to_conversation_btn().click();
            mLogger.log(Status.PASS, "3 - Users A & B excute a sanity check on call view ");

        }
    }
    public void transferVideoCall(String Second_Account) throws IOException, InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver);

            CallsScreen2.getVideoCall_Screen().click();
            CallsScreen2.getTransfert_videoCall_Btn().click();
            Thread.sleep(5000);
            ConversationScreen2.getSearchContact().sendKeys(Second_Account);
            Thread.sleep(3000);
            ConversationScreen2.PressOnElement(Second_Account);

            //ConversationScreen2.selectorToClick(Second_Account);
            ConversationScreen2.getCheckButton().click();
            mLogger.log(Status.PASS, "4 - B transfer the   video call to user C ");
        } else {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver);

            CallsScreen2.getVideoCall_Screen().click();
            CallsScreen2.getTransfert_videoCall_Btn().click();
            ConversationScreen2.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen2.getSearchContactTextField().sendKeys(Second_Account);
            ConversationScreen2.ElementToClick(Second_Account, 0, 1).click();
            ConversationScreen2.getCheckButton().click();
            mLogger.log(Status.PASS, "4 - B transfer the   video call to user C ");
        }
    }
    public void acceptTransferVideoCall(String Second_Account) throws IOException, InterruptedException {
            CallsScreen CallsScreen3 = new CallsScreen(mDriver);


            CallsScreen3.getAcceptVideoCall().click();


            Thread.sleep(3000);
            mLogger.log(Status.PASS, "5 - C accept the  call from B ");
            CallsScreen3.getVideoCall_reject_call_btn().click();
            mLogger.log(Status.PASS, "6 - B end the  call  ");

    }


    public void checkDisplayOfItemsOfVideoCallScreen() throws IOException, InterruptedException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            mLogger.log(Status.PASS, "2 - B accept the  call ");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_geolocation_btn(), "Geolocation");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_Mute(), "Mute");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_speaker_btn(), "Speaker");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_back_btn(), "Go back");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_go_to_conversation_btn(), "Go to conversation");

    }

    public void checkDisplayOfItemsOfConferenceCallScreen() throws IOException, InterruptedException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_add_contact_btn(), "Add contact");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_video_streaming_button(), "Video streaming");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_go_to_conversation_btn(), "Go to conversation");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_contact_details_btn(), "Contact details");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_mute_btn(), "Mute");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_geoloc_btn(), "Geolocation");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_speaker_btn(), "Speaker");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_back_btn(), "Dismiss");
            Thread.sleep(3000);

    }

    public void startPTTCall() throws InterruptedException {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            mLogger.log(Status.PASS, "1 - A call B through PTT call ");
            ConversationScreen.getPTTOneToOne().click();
            Thread.sleep(5000);


    }

    public void acceptPTTCall() throws InterruptedException {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            CallsScreen2.getAcceptPTTCall().click();



    }

    public void launchVideoStreamingFromPTTScreen() throws InterruptedException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            CallsScreen.getPTT_VideoStreamingBtn().click();



    }

    public void acceptAndEndsVideoStreamingFromPTTScreen() throws InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            Thread.sleep(2000);
            acceptVideoStreaming();
            EndPTTCall();
            EndVideoStreaming();
        }
        else {

        }
    }

    public void acceptVideoStreaming() {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            CallsScreen2.getAcceptVideoBroadcast().click();
            mLogger.log(Status.PASS, " User B accept's Video streaming ");

    }

    public void EndPTTCall() {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            CallsScreen.getEnd_PTT_Call().click();

    }

    public void EndVideoStreaming() throws InterruptedException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            CallsScreen.getStopVideoStreaming().click();

            Thread.sleep(2000);


    }

    public void launchVoipCallFromOpenedConversation() throws InterruptedException {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);


           // CallsScreen.getStopVideoStreaming().click();

            Thread.sleep(2000);
            conversationScreen.getCallButton().click();
            conversationScreen.getCall().click();



    }

    public void acceptVoipCall() throws InterruptedException {



            VoipScreen VoipScreenSecond = new VoipScreen(mDriver);
            Thread.sleep(5000);
            VoipScreenSecond.getAccept().click();
            mLogger.log(Status.PASS, "A call B through Voip call ");
            Thread.sleep(3000);



    }

    public void launchVideoStreamingFromVoipScreen() throws InterruptedException {



            VoipScreen VoipScreenSecond = new VoipScreen(mDriver);

            VoipScreenSecond.getVideoStreaming().click();


    }

    public void AcceptAndEndsVideoStreamingFromVoipScreen() throws InterruptedException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);




            VoipScreen VoipScreenSecond = new VoipScreen(mDriver);
            Thread.sleep(3000);

            CallsScreen.getAcceptVideoBroadcast().click();
            Thread.sleep(3000);
            VoipScreenSecond.getEnd_Button().click();
            Thread.sleep(3000);
            CallsScreen.getStopVideoStreaming().click();
            mLogger.log(Status.PASS, "Test Video braodcast through Voip call passed ");


    }
    public void launchVideoStreaming() {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            mLogger.log(Status.PASS, "1 - A call B through Video Streaming ");

            conversationScreen.getConversationNewCall().click();
            conversationScreen.getBroadcast_Video().click();


    }

    public void checkDisplayOfItemsOfVideoStreaming() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        if(Platforms.IOS.equals(mPlatform)) {

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Bar(), "Video_Broadcast_Bar");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Stop_Btn(), "Video_Broadcast Stop");

        }else {
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Bar(), "Video_Broadcast_Bar");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Stop_Btn(), "Video_Broadcast Stop");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_header_icon(), "Video_Broadcast_Bar icon");

        }
    }

    public void launchGroupPTTCallFromContact(String GroupAccount) throws InterruptedException, MalformedURLException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            IOS.screen.TabBarScreen tabBarScreen = new IOS.screen.TabBarScreen(mDriver);
            IOS.screen.ContactScreen contactScreen = new IOS.screen.ContactScreen(mDriver);


            ConversationScreen.GetUseCaseDescription("Calls_STC9", Constants.PushToTalk_OneToManySheetNumber, mLogger);
            tabBarScreen.goToContacts();
            contactScreen.getCallBtn().click();
            contactScreen.getPTTCall().click();
            ConversationScreen.getSearchContact().click();
            ConversationScreen.getSearchContact().sendKeys(GroupAccount);
            Thread.sleep(3000);
            CallsScreen callsScreen = new CallsScreen(mDriver);
            ConversationScreen.clickOnFirstCell(GroupAccount);

            //PressOnElement();
            //ConversationScreen.selectorToClick(GroupAccount);
            ConversationScreen.getConfirmBtn().click();
        }else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            android.screen.TabBarScreen tabBarScreen = new android.screen.TabBarScreen(mDriver);
            tabBarScreen.getMessageItem();
            ConversationScreen.getConversationNewCall().click();
            ConversationScreen.getPush_To_Talk().click();

            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(GroupAccount, 0, 1).click();
            ConversationScreen.getCheckButton().click();
            mLogger.log(Status.PASS, "1 - A call B through PTT call ");
            Thread.sleep(3000);
        }
    }


    public void CheckOnDutyConversation() throws InterruptedException, IOException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            CallsScreen.getCall_On_Duty_contacts().click();
            Thread.sleep(2000);
            CallsScreen.getPTT_GoToConversation().click();
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getSent_To_On_Duty_Users_Toast(), "an information bar on top of the  conversation thread : 'Sent to only on duty users'");
            CallsScreen.getSent_To_On_Duty_Users_Toast().click();
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getAlertTitle(), "Alert title");
        }else{

        }

    }

    public String getStatusOfUser() throws InterruptedException, IOException {
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);

        if(Platforms.IOS.equals(mPlatform)) {
            IOS.screen.TabBarScreen tabBarScreen = new IOS.screen.TabBarScreen(mDriver);
            IOS.screen.TabBarScreen tabBarScreen2 = new IOS.screen.TabBarScreen(mDriver);
            SettingsScreen settingsScreen2 = new SettingsScreen(mDriver);


            CallsScreen CallsScreen2 = new CallsScreen(mDriver);
            tabBarScreen2.getMoreItem().click();
            settingsScreen2.getStatus().click();
            // CallsScreen2.PressOnElement("Status");
            //CallsScreen2.selectorToClick("Status");
            tabBarScreen.getContactsItem().click();
        }else {
            android.screen.TabBarScreen tabBarScreen2 = new android.screen.TabBarScreen(mDriver);

            tabBarScreen2.getMoreItem();
            tabBarScreen2.ElementToClick("Status", 0, 0).click();

        }
        String statusOfUser;

            if (settingsScreen.isElementDisplayed(settingsScreen.getStatus_OFF_Duty())) {
                mLogger.log(Status.INFO, " Status of second device is OFF duty ");
                statusOfUser = "OffDuty";

            } else {
                mLogger.log(Status.INFO, " Status of second device is On duty ");
                statusOfUser = "OnDuty";
            }


        return statusOfUser;
    }



    public void endPTTCall(AppiumDriver driver) throws InterruptedException, IOException {
            CallsScreen CallsScreen = new CallsScreen(driver);


            CallsScreen.getEnd_PTT_Call().click();

            Thread.sleep(3000);


    }

    public void checkDisplayOfItemsOfPTTCall() throws InterruptedException, IOException {

            CallsScreen CallsScreen = new CallsScreen(mDriver);
            Thread.sleep(5000);

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_addContactBtn(), "Add contact");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_VideoStreamingBtn(), "Video streaming");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_GoToConversation(), "Go to conversation");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_ContactDetailsBtn(), "Contact details");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_geolocBtn(), "Geolocation");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_TakeTheFloor(), "Take the floor");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_SpeakerBTN(), "Speaker");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_Account_image(), "Account image");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_BackButton(), "Dismiss");


    }


    public void selectGroupNewConversation(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            IOS.screen.TabBarScreen tabBarScreen = new IOS.screen.TabBarScreen(mDriver);
            tabBarScreen.goTochats();
            ConversationScreen.getConversationNewMessage().click();
            ConversationScreen.getSearchContact().sendKeys(GroupAccount);
            Thread.sleep(3000);
            //getFirstInstance().click();
            ConversationScreen.clickOnFirstCell(GroupAccount);

            //PressOnElement(Account);
            // ConversationScreen.selectorToClick(Account);
            ConversationScreen.getCheckButton().click();
            mLogger.log(Status.PASS, "1 - A open group conversation");

            ConversationScreen.getGroupNameInput().sendKeys(GroupAccount);
            ConversationScreen.getCreateThread().click();

            mLogger.log(Status.PASS, "3 - A adds a group title ");
        }else {
            ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
            android.screen.TabBarScreen tabBarScreen= new android.screen.TabBarScreen(mDriver);
            tabBarScreen.getMessageItem();
            ConversationScreen.getConversationNewMessage().click();

            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(GroupAccount,0,1).click();
            ConversationScreen.getCheckButton().click();
        }
    }

    public void takeTheFloor() throws InterruptedException, IOException {
            CallsScreen callsScreen = new CallsScreen(mDriver);
            Thread.sleep(3000);
            callsScreen.LonPressOnElement(callsScreen.getPTT_TakeTheFloor());
            Thread.sleep(3000);

    }

    public void selectConversationOneToOne(String Account) throws InterruptedException, IOException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.getConversationNewMessage().click();
            Thread.sleep(3000);
            ConversationScreen.getSearchContact().sendKeys(Account);

            Thread.sleep(3000);
            CallsScreen callsScreen = new CallsScreen(mDriver);
            //callsScreen.getFirstInstance().click();
            ConversationScreen.clickOnFirstCell(Account);

            //PressOnElement(Account);

            //ConversationScreen.selectorToClick(Account);
            ConversationScreen.getCheckButton().click();
        }else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            android.screen.TabBarScreen tabBarScreen = new android.screen.TabBarScreen(mDriver);
            tabBarScreen.getMessageItem();

            ConversationScreen.getConversationNewMessage().click();
            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(Account);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(Account, 0, 1).click();
            ConversationScreen.getCheckButton().click();
        }
    }

    public void checkItemsOfPTTCall() throws InterruptedException, IOException {
        if(Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);
            Thread.sleep(3000);

            mLogger.log(Status.PASS, "3 - A & B check the  notification center ");
            CallsScreen.getPTT_addContactBtn().click();
            Thread.sleep(2000);
            CallsScreen.back();
            Thread.sleep(2000);


            CallsScreen.getPTT_ContactDetailsBtn().click();
            Thread.sleep(2000);
            if (CallsScreen.isElementDisplayed(CallsScreen.getPTT_ListofContactDetails()))
                CallsScreen.getPTT_OK_ListContact().click();
            Thread.sleep(2000);

            CallsScreen.getPTT_geolocBtn().click();
            Thread.sleep(5000);
            CallsScreen.getTouchToComeBackToCall().click();
            Thread.sleep(2000);

            CallsScreen.getPTT_SpeakerBTN().click();
            Thread.sleep(2000);
            mLogger.log(Status.PASS, "3 - A take the  floor");

            takeTheFloor();
            mLogger.log(Status.PASS, "4 - A release the  floor");

            CallsScreen.getPTT_VideoStreamingBtn().click();
            Thread.sleep(2000);

            CallsScreen.getPTT_GoToConversation().click();
            CallsScreen.getStopVideoStreaming().click();
        }else {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            mLogger.log(Status.PASS, "A & B have  an  ongoing PTT call");
            CallsScreen.getPTT_addContactBtn().click();
            Thread.sleep(2000);
            CallsScreen.back();
            Thread.sleep(2000);


            CallsScreen.getPTT_ContactDetailsBtn().click();
            Thread.sleep(2000);
            if (CallsScreen.isElementDisplayed(CallsScreen.getPTT_ListofContactDetails()))
                CallsScreen.getPTT_OK_ListContact().click();
            Thread.sleep(2000);

            CallsScreen.getPTT_geolocBtn().click();
            Thread.sleep(5000);
            CallsScreen.back();
            Thread.sleep(2000);

            CallsScreen.getPTT_SpeakerBTN().click();
            Thread.sleep(2000);
            mLogger.log(Status.PASS, "3 - A take the  floor");

            CallsScreen.LonPressOnElement(CallsScreen.getPTT_TakeTheFloor());
            mLogger.log(Status.PASS, "4 - A release the  floor");

            CallsScreen.getPTT_VideoStreamingBtn().click();
            Thread.sleep(2000);

            CallsScreen.getPTT_GoToConversation().click();
            CallsScreen.getStopVideoStreaming().click();


            CallsScreen.CheckDisplayedOfString("Outgoing Push-To-Talk", 0, 0, mLogger);

        }

    }

    public void goToConversationPTTBtn() throws InterruptedException, IOException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);
            Thread.sleep(3000);
            CallsScreen.getPTT_GoToConversation().click();


    }

    public void checkDisplayOfPttSentence() throws InterruptedException, IOException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);
            Thread.sleep(3000);
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getIncomingPttSentence(), "Outgoing PTT calls ");
            mLogger.log(Status.PASS, "3 - A & B check the  notification center ");


    }

    public void checkDisplayOfItemsOfExternalCall() throws InterruptedException, IOException {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            Thread.sleep(2000);

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalSpeakersBtn(), "Speaker");

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalMuteBtn(), "Mute");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDialerBtn(), "Dialer");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDismissBtn(), "Go back");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalRejectBtn(), "End call");


    }

    public void selectCallBtnFromContact() throws InterruptedException, IOException {
        if(Platforms.IOS.equals(mPlatform)) {
            IOS.screen.ContactScreen contactScreen = new IOS.screen.ContactScreen(mDriver);
            IOS.screen.TabBarScreen tabBarScreen = new TabBarScreen(mDriver);


            tabBarScreen.getContactsItem().click();
            contactScreen.getCallBtn().click();

        }else {
android.screen.ContactScreen contactScreen = new android.screen.ContactScreen(mDriver);


            contactScreen.getCallButton().click();

        }
    }

    public void launchDialerCall() {
        if(Platforms.IOS.equals(mPlatform)) {
            IOS.screen.ContactScreen contactScreen = new ContactScreen(mDriver);


            contactScreen.getDialerCall().click();
        }else {
android.screen.ContactScreen contactScreen = new android.screen.ContactScreen(mDriver);


            contactScreen.getDialer().click();
        }
    }

    public void pushPhoneNumberForDialerCall() throws InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            IOS.screen.DialerScreen dialerScreen = new DialerScreen(mDriver);


            dialerScreen.getNine().click();
            dialerScreen.getSeven().click();
            dialerScreen.getEight().click();
            dialerScreen.getFour().click();
            dialerScreen.getFour().click();

            dialerScreen.getTwo().click();
            dialerScreen.getSex().click();
            dialerScreen.getZero().click();
            dialerScreen.getCall_Dialer().click();
        }else {
            android.screen.DialerScreen DialerScreen = new android.screen.DialerScreen(mDriver);


            DialerScreen.getNine().click();
            DialerScreen.getTwo().click();
            DialerScreen.getSeven().click();
            DialerScreen.getEight().click();
            DialerScreen.getSex().click();
            DialerScreen.getEight().click();
            DialerScreen.getEight().click();
            DialerScreen.getEight().click();
            DialerScreen.getCall_Dialer().click();


            Thread.sleep(3000);
        }
    }

    public void launchCallsFromConversation() {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);


            conversationScreen.getCallButton().click();


    }

    public void launchExternalCallFromConversation() throws InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);


            conversationScreen.getDialer().click();
            Thread.sleep(3000);
        }else {
            android.screen.ContactScreen contactScreen = new android.screen.ContactScreen(mDriver);

            mLogger.log(Status.PASS, "1 - User A  call user B via PBX");

            contactScreen.getCallOutPBX().click();
            Thread.sleep(3000);
        }
    }

    public void callOnDutyContacts() throws InterruptedException {
            CallsScreen callsScreen = new CallsScreen(mDriver);


            callsScreen.getPop_up_Of_OnDuty().click();
            mLogger.log(Status.PASS, "2 - A call B through PTT call ");
            Thread.sleep(5000);

    }




    public  AppiumDriver createSessionForSecondDevice(STWAppiumTest mStwAppiumTest) {

        if(Platforms.IOS.equals(mPlatform))
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        else
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        return mDriver;

    }
    public AppiumDriver createSessionForThirdDevice(STWAppiumTest mStwAppiumTest) {
        if(Platforms.IOS.equals(mPlatform))
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.IOS);
        else
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        return mDriver;
    }
}

