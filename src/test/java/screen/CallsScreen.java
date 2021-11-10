package screen;

import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import framework.tester.STWAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import screen.settings.SettingsMoreScreen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;

public class CallsScreen extends STWScreen {

    public CallsScreen(AppiumDriver driver) {
        super(driver);
    }

    //Elements of PTT Call screen
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]", priority = 2)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_startButton")
    @iOSXCUITFindBy(accessibility = "Accept", priority = 3)
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton", priority = 4)
    @AndroidFindBy(id = "walkie_talkie_accept_btn", priority = 1)
    @AndroidFindBy(id = "accept_call_waiting_image_btn")
    private MobileElement AcceptPTTCall;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_pushToTalkButton")
    @iOSXCUITFindBy(accessibility = "Colibri_PTTCallView_pushToTalkButton",priority = 1)
    @AndroidFindBy(id = "walkie_talkie_push_button")
    private MobileElement PTT_TakeTheFloor;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add person to call']", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_addButton")
    @iOSXCUITFindBy(accessibility = "Add person to call",priority = 1)
    @AndroidFindBy(id = "walkie_talkie_add_contact_btn")
    private MobileElement PTT_addContactBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Details")
    @iOSXCUITFindBy(accessibility = "PushToTalkView_detailsButton",priority = 1)
    @AndroidFindBy(id = "walkie_talkie_contact_details_btn")
    private MobileElement PTT_ContactDetailsBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Details",priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther\n")
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_list")
    private MobileElement PTT_ListofContactDetails;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]",priority = 1)
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_ok_btn")
    private MobileElement PTT_OK_ListContact;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Video Streaming",priority = 1)
    @iOSXCUITFindBy(accessibility = "LiveCallView_broadcast_video",priority = 2)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Streaming']", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadcast Video']", priority = 2)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_videoStreaming")
    @AndroidFindBy(id = "walkie_talkie_video_streaming_button")
    private MobileElement PTT_VideoStreamingBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Location",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_geoLocButton")
    @AndroidFindBy(id = "walkie_talkie_geoloc_btn")
    private MobileElement PTT_geolocBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Conversation",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversation']", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_goToConversationButton")
    @AndroidFindBy(id = "walkie_talkie_go_to_conversation_btn")
    private MobileElement PTT_GoToConversation;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_contact_icon", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_participentsCollectionView")
    @AndroidFindBy(id = "view_voip_contact_image")
    private MobileElement PTT_Account_image;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Agnet Work\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton",priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton",priority = 2)
    private MobileElement touchToComeBackToCall;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "ptt_audio_options_btn", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_speackerBtn")
    @iOSXCUITFindBy(accessibility = "PttOptionsExclusionIcon", priority = 1)
    @iOSXCUITFindBy(accessibility = "PttLoudspeakerIcon",priority = 2)
    @AndroidFindBy(id = "walkie_talkie_speaker_btn")
    private MobileElement PTT_SpeakerBTN;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_hideButton")
    @AndroidFindBy(id = "walkie_talkie_back_btn")
    private MobileElement PTT_BackButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_bannerInfoView.button",priority = 1)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_bannerInfoView.button",priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"STOP\"`]",priority = 3)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ConversationListViewController_bannerInfoView.button\"]",priority = 4)
    @AndroidFindBy(id = "stop_video_streaming_button")
    private MobileElement stopVideoStreaming;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PttDeclineButtonIcon",priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_self.cancelButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PushToTalkView_self.cancelButton\"]",priority = 2)
    @AndroidFindBy(id = "walkie_talkie_reject_btn")
    private MobileElement End_PTT_Call;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty contacts']", priority = 1)
    @iOSXCUITFindBy(accessibility = "On Duty contacts")
    @AndroidFindBy(id = "title_template")
    private MobileElement Pop_up_Of_OnDuty;
    @iOSXCUITFindBy(accessibility = "On Duty contacts")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On Duty contacts']")
    private MobileElement Call_On_Duty_contacts;
    @iOSXCUITFindBy(accessibility = "All group contacts")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All group contacts']")
    private MobileElement Call_All_group_contacts;
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_availibilityStatusView")
    @AndroidFindBy(id = "activity_message_user_availability_explanation")
    private MobileElement Sent_To_On_Duty_Users_Toast;
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    @AndroidFindBy(id = "alertTitle")
    private MobileElement alertTitle;

    //Elements of Conference Call screen
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]", priority = 2)
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton", priority = 3)
    @iOSXCUITFindBy(accessibility = "Accept")
    @iOSXCUITFindBy(accessibility = "9 Voip PhoneIcon",priority = 4)
    @AndroidFindBy(id = "accept_call_waiting_image_btn", priority = 1)
    @AndroidFindBy(id = "conference_call_accept_btn")
    private MobileElement AcceptConferenceCall;
    @iOSXCUITFindBy(accessibility = "9 Voip poc earpiece")
    @AndroidFindBy(id = "conference_call_speaker_btn")
    private MobileElement conference_call_speaker_btn;
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "conference_call_mute_btn")
    private MobileElement conference_call_mute_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip goToGeoLocationButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']", priority = 1)
    @AndroidFindBy(id = "conference_call_geoloc_btn")
    private MobileElement conference_call_geoloc_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip videoStreamingButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Streaming']", priority = 1)
    @AndroidFindBy(id = "conference_call_video_streaming_button")
    private MobileElement conference_call_video_streaming_button;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip goToConversationButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversation']", priority = 1)
    @AndroidFindBy(id = "conference_call_go_to_conversation_btn")
    private MobileElement conference_call_go_to_conversation_btn;
    @iOSXCUITFindBy(accessibility = "9 Voip endLiveVoipCallIcon")
    @AndroidFindBy(id = "conference_call_reject_btn")
    private MobileElement conference_call_reject_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip AddButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add person to call']", priority = 1)
    @AndroidFindBy(id = "conference_call_add_contact_btn")
    private MobileElement conference_call_add_contact_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip moreDetailsButton")
    @AndroidFindBy(id = "conference_call_contact_details_btn")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Details']", priority = 1)
    private MobileElement conference_call_contact_details_btn;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "conference_call_back_btn")
    private MobileElement conference_call_back_btn;
    @iOSXCUITFindBy(accessibility = "MessagesTV menu", priority = 1)
    @AndroidFindBy(id = "thread_recipient_options")
    private MobileElement recipient_options;
    @AndroidFindBy(id = "alertTitle")
    private MobileElement dismissVideoScreen;

    public MobileElement getRecipient_options() {
        return recipient_options;
    }

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
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_call_mute_btn", priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "mute_btn")
    @iOSXCUITFindBy(accessibility = "VideoCall OffMute",priority = 1)
    private MobileElement VideoCall_Mute;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_call_speaker_btn", priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOptionSelect")
    @iOSXCUITFindBy(accessibility = "VideoCall OffSpeaker",priority = 1)
    @iOSXCUITFindBy(accessibility = "VideoCall OnSpeaker",priority = 2)
    @AndroidFindBy(id = "speaker_btn")
    private MobileElement VideoCall_speaker_btn;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "back_btn")
    private MobileElement VideoCall_back_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']", priority = 1)
    @AndroidFindBy(id = "voip_geolocation_image_button")
    @iOSXCUITFindBy(accessibility = "9 Voip goToGeoLocationButton")
    @iOSXCUITFindBy(accessibility = "Location",priority = 1)
    private MobileElement VideoCall_geolocation_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversation']", priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip goToConversationButton")
    @iOSXCUITFindBy(accessibility = "Conversation",priority = 1)
    @AndroidFindBy(id = "go_to_conversation_btn")
    private MobileElement VideoCall_go_to_conversation_btn;
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    private MobileElement VideoCall_reject_call_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]", priority = 6)
    @iOSXCUITFindBy(accessibility = "Accept",priority = 4)
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"9 Voip hangUpButton\"`]",priority = 5)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"9 Voip hangUpButton\"]" )
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == \"Accept\"`]" ,priority = 3)
    @AndroidFindBy(id = "accept_call_btn", priority = 1)
    @AndroidFindBy(id = "accept_call_waiting_image_btn")
    private MobileElement AcceptVideoCall;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Teamontherun']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Teamontherun\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther",priority = 1)
    @AndroidFindBy(id = "wide_camera_preview_surface_view")
    //@AndroidFindBy(id = "video_blurred_image_background",priority = 1)
    private MobileElement VideoCall_Screen;
    @iOSXCUITFindBy(accessibility = "9 Voip transferIconBackground")
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement Transfert_videoCall_Btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "ptt_options_btn", priority = 1)
    @AndroidFindBy(id = "voip_call_menu_btn")
    @AndroidFindBy(id = "voip_more_options_btn",priority = 2)
    @iOSXCUITFindBy(accessibility = "PttMoreIcon", priority = 1)
    @iOSXCUITFindBy(accessibility = "VideoCall More")
    @iOSXCUITFindBy(accessibility = "more call options", priority = 2)

    private MobileElement call_menu_Btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "select_dialog_listview")
    private MobileElement dialogListView;
    //Elements of Video Broadcast screen
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_bannerInfoView.eyeStreamingButton")
    @AndroidFindBy(id = "video_streaming_header_label")
    private MobileElement Video_Broadcast_Bar;
    @iOSXCUITFindBy(accessibility = "STOP")
    @AndroidFindBy(id = "stop_video_streaming_button")
    private MobileElement Video_Broadcast_Stop_Btn;
    @AndroidFindBy(id = "video_streaming_icon")
    private MobileElement Video_Broadcast_header_icon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pause call']", priority = 1)
    private MobileElement pause_call_btn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip respondStreamVideoCallI")
    @iOSXCUITFindBy(accessibility = "AcceptLiveCall", priority = 1)
    @iOSXCUITFindBy(accessibility = "LiveStreamCall accept", priority = 2)
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton", priority = 3)
    @AndroidFindBy(id = "accept_call_waiting_image_btn", priority = 2)
    @AndroidFindBy(id = "accept_call_waiting_btn", priority = 1)
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement AcceptVideoBroadcast;


    //Elements of External Call via PBX screen
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "speaker_btn")
    @AndroidFindBy(id = "voip_call_speaker_btn", priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOption")
    private MobileElement externalSpeakersBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_call_mute_btn", priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "mute_btn")
    private MobileElement externalMuteBtn;
    @iOSXCUITFindBy(accessibility = "9 Voip hideButton")
    @AndroidFindBy(id = "back_btn")
    private MobileElement externalDismissBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "dialer_btn")
    @AndroidFindBy(id = "voip_call_dialer_btn",priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip swout keyboardIcon")
    private MobileElement externalDialerBtn;
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    private MobileElement externalRejectBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Outgoing PTT']", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Outgoing Push-To-Talk']")
    @iOSXCUITFindBy(accessibility = "Outgoing Push-To-Talk")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Outgoing Push-To-Talk\"])[10]", priority = 1)
    private MobileElement incomingPttSentence;

    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement contactCell;

    public MobileElement getContactCell() {
        return contactCell;
    }

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeImage[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"ContactCell_secondLabel\"])[2]")
    private MobileElement firstInstance;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "conference_call_menu_btn", priority = 1)
    @AndroidFindBy(id = "ptt_options_btn")
    @iOSXCUITFindBy(accessibility = "PttMoreIcon")
    private MobileElement Calls_options_btn;

    public MobileElement getCalls_options_btn() {
        return Calls_options_btn;
    }

    public MobileElement getFirstInstance() {
        return firstInstance;
    }

    public MobileElement getDismissVideoScreen() {
        return dismissVideoScreen;
    }

    public MobileElement getCall_menu_Btn() {
        return call_menu_Btn;
    }

    public MobileElement getDialogListView() {
        return dialogListView;
    }

    public MobileElement getTouchToComeBackToCall() {
        return touchToComeBackToCall;
    }

    public MobileElement getPause_call_btn() {
        return pause_call_btn;
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
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            ContactScreen contactScreen = new ContactScreen(mDriver);
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
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding))
                ConversationScreen.getConversationNewCall().click();
            else
                ConversationScreen.getPlusBtn().click();
            Thread.sleep(3000);

            ConversationScreen.getConference_Call().click();


            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.clickOnFirstCell(GroupAccount);
            ConversationScreen.getCheckButton().click();
        }
    }

    public void checkPopupOfOnDuty() throws InterruptedException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        if (ConversationScreen.isElementDisplayed(CallsScreen.getCall_All_group_contacts())) {
            mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");
            CallsScreen.getCall_All_group_contacts().click();
            Thread.sleep(2000);
        }
        Thread.sleep(5000);

    }

    public void clickToAcceptConferenceCall() {

        waitForElementToBeClickable(getAcceptConferenceCall());
            getAcceptConferenceCall().click();

    }

    public void checkItemsOfConferenceCallScreen() throws IOException, InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            CallsScreen.getConference_call_speaker_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_mute_btn().click();
            Thread.sleep(3000);
            CallsScreen.getConference_call_geoloc_btn().click();
            Thread.sleep(5000);
            acceptPermission();
            CallsScreen.getTouchToComeBackToCall().click();

            Thread.sleep(3000);
            CallsScreen.getConference_call_video_streaming_button().click();
            // CallsScreen.back();
            CallsScreen.getConference_call_reject_btn().click();
        } else {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            Thread.sleep(3000);
            CallsScreen.getConference_call_speaker_btn().click();
            Thread.sleep(3000);
            if (Branding.AGNET.equals(branding))
                CallsScreen.back();
            else
                CallsScreen.getConference_call_speaker_btn().click();

            CallsScreen.getConference_call_mute_btn().click();
            Thread.sleep(3000);
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            CallsScreen.getConference_call_geoloc_btn().click();
            Thread.sleep(10000);
            if (Platforms.IOS.equals(mPlatform))
            acceptPermission();
            CallsScreen.back();
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            waitForElementToBeClickable(getConference_call_video_streaming_button());
            CallsScreen.getConference_call_video_streaming_button().click();
            // CallsScreen.back();

            CallsScreen.getConference_call_reject_btn().click();

        }
    }

    public void acceptPermission() {
        if (Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            permissionsScreen.acceptPermissions();
        }
    }

    public void goToContactsTab() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToContacts();
        } else {

        }


    }

    public void openConversationWithSecondAccount(String First_Account) throws InterruptedException, MalformedURLException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();

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
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

            tabBarScreen.goToChats();

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
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        if (Branding.TOTR.equals(branding)) {
            wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getConversationNewCall())).click();

           // ConversationScreen.getConversationNewCall().click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(recipient_options)).click();

           // recipient_options.click();
        }
        ConversationScreen.getVideo_Call().click();
        mLogger.log(Status.PASS, "1 - A call B video call ");

        Thread.sleep(3000);

    }

    public void acceptVideoCall() {
        if (Platforms.IOS.equals(mPlatform)){
        getAcceptVideoCall().click();}
        else
        {
            waitForElementToBeClickable(AcceptVideoCall);
            getAcceptVideoCall().click();
        }

    }

    public void checkItemsOfVideoCallScreen() throws IOException, InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            mLogger.log(Status.PASS, "2 - B accept the  call ");


            //Sanity check For Video call screen
            if(Branding.TOTR.equals(branding)) {
                Thread.sleep(5000);
                CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_speaker_btn().click();

                Thread.sleep(5000);
                CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_Mute().click();

                Thread.sleep(5000);
                CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_Mute().click();
                Thread.sleep(5000);
                CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_geolocation_btn().click();
                Thread.sleep(5000);
                //mDriver.navigate().back();
                    CallsScreen.getTouchToComeBackToCall().click();
                Thread.sleep(2000);
                //CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_go_to_conversation_btn().click();
            }else
            {
                CallsScreen.getVideoCall_speaker_btn().click();

                Thread.sleep(3000);
                CallsScreen.getVideoCall_Mute().click();

                Thread.sleep(3000);
                CallsScreen.getVideoCall_Mute().click();
                CallsScreen.call_menu_Btn.click();
                CallsScreen.getVideoCall_geolocation_btn().click();
                Thread.sleep(5000);
                CallsScreen.getTouchToComeBackToCall().click();
                Thread.sleep(2000);
                CallsScreen.call_menu_Btn.click();
                CallsScreen.getVideoCall_go_to_conversation_btn().click();

            }
            mLogger.log(Status.PASS, "3 - Users A & B excute a sanity check on call view ");
        } else {
            CallsScreen CallsScreen = new CallsScreen(mDriver);


            //Sanity check For Video call screen
            if (Branding.TOTR.equals(branding)) {
                CallsScreen.getVideoCall_Screen().click();

                CallsScreen.getVideoCall_speaker_btn().click();
                //Thread.sleep(5000);
                //CallsScreen.getVideoCall_Screen().click();

                CallsScreen.getVideoCall_speaker_btn().click();
                Thread.sleep(5000);
            } else {
                Thread.sleep(3000);
                CallsScreen.getVideoCall_Screen().click();
                CallsScreen.getVideoCall_speaker_btn().click();
                CallsScreen.CheckDisplayedOfElement(CallsScreen.dialogListView, "dialog list view");
                CallsScreen.back();


            }
            if (Branding.TOTR.equals(branding))
                CallsScreen.getVideoCall_Screen().click();
            CallsScreen.getVideoCall_Mute().click();
            Thread.sleep(5000);
            CallsScreen.getVideoCall_Screen().click();
            Thread.sleep(2000);
            CallsScreen.getVideoCall_Mute().click();
            Thread.sleep(5000);

            if (Branding.TOTR.equals(branding))
                CallsScreen.getVideoCall_Screen().click();
            if (Branding.AGNET.equals(branding))
                call_menu_Btn.click();
            CallsScreen.getVideoCall_geolocation_btn().click();
            Thread.sleep(10000);

            CallsScreen.back();
            CallsScreen.getVideoCall_Screen().click();
            if (Branding.AGNET.equals(branding))
                call_menu_Btn.click();
            CallsScreen.getVideoCall_go_to_conversation_btn().click();
            mLogger.log(Status.PASS, "3 - Users A & B excute a sanity check on call view ");

        }
    }

    public void transferVideoCall(String Second_Account) throws IOException, InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {

            ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver);
          //  if(Branding.TOTR.equals(branding))
               // waitForElementToBeClickable(getVideoCall_Screen());
        //    WebDriverWait wait = new WebDriverWait(mDriver, 5);
    //        getVideoCall_Screen().click();
/*
            int delay = 100000;
            int period = 5000;
            Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                                                  @Override
                                                  public void run() {
                                                  }
                                              },delay,period

                    );*/

            //wait.until(ExpectedConditions.elementToBeClickable(getTransfert_videoCall_Btn())).click();
            Thread.sleep(7000);
            getVideoCall_Screen().click();
            getTransfert_videoCall_Btn().click();

            Thread.sleep(5000);
            ConversationScreen2.getSearchContact().sendKeys(Second_Account);
            Thread.sleep(3000);
           // ConversationScreen2.PressOnElement(Second_Account);
            tapOnElementCell(contactCell, 0.5, 0.42);

            //ConversationScreen2.selectorToClick(Second_Account);
            if(Branding.AGNET.equals(branding)) {
                ConversationScreen2.getCheckButton().click();}

            mLogger.log(Status.PASS, "4 - B transfer the   video call to user C ");
        } else {
            CallsScreen CallsScreen2 = new CallsScreen(mDriver);

            ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver);
            waitForElementToBeClickable(getVideoCall_Screen());

            CallsScreen2.getVideoCall_Screen().click();

            if(!isElementDisplayed(Transfert_videoCall_Btn))
                waitForElementToBeClickable(getVideoCall_Screen());

            CallsScreen2.getVideoCall_Screen().click();

            CallsScreen2.getTransfert_videoCall_Btn().click();
            waitForElementToBeClickable( ConversationScreen2.getSearchContact());


            ConversationScreen2.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen2.getSearchContactTextField().sendKeys(Second_Account);
            ConversationScreen2.clickOnFirstCell(Second_Account);
            ConversationScreen2.getCheckButton().click();
            mLogger.log(Status.PASS, "4 - B transfer the   video call to user C ");
        }
    }

    public void acceptTransferVideoCall() throws IOException, InterruptedException {


        waitForElementToBeClickable( getAcceptVideoCall());
       getAcceptVideoCall().click();


        Thread.sleep(3000);
        mLogger.log(Status.PASS, "5 - C accept the  call from B ");
        getVideoCall_reject_call_btn().click();
        mLogger.log(Status.PASS, "6 - B end the  call  ");

    }


    public void checkDisplayOfItemsOfVideoCallScreen() throws IOException, InterruptedException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        mLogger.log(Status.PASS, "2 - B accept the  call ");
        if (Branding.TOTR.equals(branding)) {
           CheckDisplayedOfElement(getVideoCall_geolocation_btn(), "Geolocation");
           CheckDisplayedOfElement(getVideoCall_Mute(), "Mute");
            CheckDisplayedOfElement(getVideoCall_speaker_btn(), "Speaker");
           CheckDisplayedOfElement(getVideoCall_back_btn(), "Go back");
          CheckDisplayedOfElement(getVideoCall_go_to_conversation_btn(), "Go to conversation");
        } else {
           CheckDisplayedOfElement(getVideoCall_Mute(), "Mute");
            CheckDisplayedOfElement(getVideoCall_speaker_btn(), "Speaker");
            CheckDisplayedOfElement(call_menu_Btn, "Call menu");
            call_menu_Btn.click();
            CheckDisplayedOfElement(getVideoCall_go_to_conversation_btn(), "Go to conversation");
           CheckDisplayedOfElement(getVideoCall_geolocation_btn(), "Geolocation");
            back();
            if(Platforms.IOS.equals(mPlatform))
                conversationScreen.getCancelBtn().click();


        }

    }

    public void checkDisplayOfItemsOfConferenceCallScreen() throws IOException, InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_mute_btn(), "Mute");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_speaker_btn(), "Speaker");
        if (Branding.AGNET.equals(branding))
            Calls_options_btn.click();
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_add_contact_btn(), "Add contact");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_video_streaming_button(), "Video streaming");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_go_to_conversation_btn(), "Go to conversation");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_contact_details_btn(), "Contact details");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_geoloc_btn(), "Geolocation");
        if (Branding.TOTR.equals(branding))
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_back_btn(), "Dismiss");
        Thread.sleep(3000);
        if (Branding.AGNET.equals(branding))
            CallsScreen.back();

    }

    public void startPTTCall() throws InterruptedException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        if (Branding.TOTR.equals(branding)) {

            waitForElementToBeClickable(ConversationScreen.getPTTOneToOne());
        } else {
            wait.until(ExpectedConditions.visibilityOf(recipient_options));

            recipient_options.click();
        }

        ConversationScreen.getPTTOneToOne().click();
        mLogger.log(Status.PASS, "1 - A call B through PTT call ");

        Thread.sleep(5000);


    }

    public void acceptPTTCall() throws InterruptedException {
        waitForElementToBeClickable(getAcceptPTTCall());

        getAcceptPTTCall().click();


    }

    public void launchVideoStreamingFromPTTScreen() throws InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        if (Branding.AGNET.equals(branding))
            call_menu_Btn.click();
        waitForElementToBeClickable(CallsScreen.getPTT_VideoStreamingBtn());

        CallsScreen.getPTT_VideoStreamingBtn().click();


    }

    public void acceptAndEndsVideoStreamingFromPTTScreen() throws InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        Thread.sleep(5000);
        acceptVideoStreaming();
        //EndPTTCall();
        //EndVideoStreaming();

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

        Thread.sleep(2000);

        CallsScreen.getStopVideoStreaming().click();

        Thread.sleep(2000);


    }

    public void launchVoipCallFromOpenedConversation() throws InterruptedException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        // CallsScreen.getStopVideoStreaming().click();

        Thread.sleep(2000);
        EndPTTCall();
        EndVideoStreaming();
        Thread.sleep(2000);
        if (Branding.TOTR.equals(branding)) {
           // waitForElementToBeClickable(conversationScreen.getCallButton());
            //WebDriverWait wait = new WebDriverWait(mDriver, 5);
           // wait.until(ExpectedConditions.visibilityOf( conversationScreen.getCallButton()));
            //mDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            conversationScreen.getCallButton().click();
        }
        else {

            waitForElementToBeClickable(recipient_options);
            recipient_options.click();
        }
        waitForElementToBeClickable(conversationScreen.getCall());
        conversationScreen.getCall().click();


    }

    public void acceptVoipCall() throws InterruptedException {

        VoipScreen VoipScreenSecond = new VoipScreen(mDriver);


        VoipScreenSecond.acceptVoipCall();
        mLogger.log(Status.PASS, "A call B through Voip call ");
        Thread.sleep(3000);


    }

    public void launchVideoStreamingFromVoipScreen() throws InterruptedException {


       // if (Branding.AGNET.equals(branding))
        waitForElementToBeClickable(call_menu_Btn);
            call_menu_Btn.click();
            waitForElementToBeClickable(getPTT_VideoStreamingBtn());
        getPTT_VideoStreamingBtn().click();


    }

    public void AcceptAndEndsVideoStreamingFromVoipScreen() throws InterruptedException {


        VoipScreen VoipScreenSecond = new VoipScreen(mDriver);
    waitForElementToBeClickable( getAcceptVideoBroadcast());
    getAcceptVideoBroadcast().click();
        waitForElementToBeClickable( VoipScreenSecond.getEnd_Button());

        VoipScreenSecond.getEnd_Button().click();
        waitForElementToBeClickable(  getStopVideoStreaming());

        getStopVideoStreaming().click();
        mLogger.log(Status.PASS, "Test Video braodcast through Voip call passed ");


    }

    public void launchVideoStreaming() throws InterruptedException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        mLogger.log(Status.PASS, "1 - A call B through Video Streaming ");


        if (Branding.TOTR.equals(branding)) {
            Thread.sleep(3000);
            conversationScreen.getConversationNewCall().click();
        }
        else {
            Thread.sleep(3000);
            recipient_options.click();
        }

        conversationScreen.getBroadcast_Video().click();
        Thread.sleep(5000);


    }

    public void checkDisplayOfItemsOfVideoStreaming() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        if (Platforms.IOS.equals(mPlatform)) {

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Bar(), "Video_Broadcast_Bar");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Stop_Btn(), "Video_Broadcast Stop");

        } else {
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Bar(), "Video_Broadcast_Bar");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Stop_Btn(), "Video_Broadcast Stop");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_header_icon(), "Video_Broadcast_Bar icon");

        }
    }

    public void launchGroupPTTCallFromContact(String GroupAccount) throws InterruptedException, MalformedURLException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            ContactScreen contactScreen = new ContactScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);


           // ConversationScreen.GetUseCaseDescription("Calls_STC9", Constants.PushToTalk_OneToManySheetNumber, mLogger);
           //waitForElementToBeClickable(tabBarScreen.getContactsItem());
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
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding))
                ConversationScreen.getConversationNewCall().click();
            else
                ConversationScreen.getPlusBtn().click();
            Thread.sleep(3000);

            ConversationScreen.getPush_To_Talk().click();

            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.clickOnFirstCell(GroupAccount);
            ConversationScreen.getCheckButton().click();
            mLogger.log(Status.PASS, "1 - A call B through PTT call ");
            Thread.sleep(3000);
        }
    }


    public void CheckOnDutyConversation() throws InterruptedException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            CallsScreen.getCall_On_Duty_contacts().click();
            Thread.sleep(2000);
            CallsScreen.getPTT_GoToConversation().click();
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getSent_To_On_Duty_Users_Toast(), "an information bar on top of the  conversation thread : 'Sent to only on duty users'");
            CallsScreen.getSent_To_On_Duty_Users_Toast().click();
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getAlertTitle(), "Alert title");
        } else {

        }

    }

    public String getStatusOfUser() throws InterruptedException, IOException {
        screen.settings.SettingsScreen settingsScreen = new screen.settings.SettingsScreen(mDriver);
        String userStatus ;
        if (Platforms.IOS.equals(mPlatform)) {
            TabBarScreen tabBarScreen2 = new TabBarScreen(mDriver);
            screen.settings.SettingsScreen settingsScreen2 = new screen.settings.SettingsScreen(mDriver);
            SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);


            tabBarScreen2.goToMore();
            waitForElementToBeClickable(settingsScreen2.getStatus());
            settingsScreen2.getStatus().click();


            Thread.sleep(3000);
            SettingsMoreScreen.clickOnSettings();
            String CurrentStatus= settingsScreen2.getmDuty().getText();
            if(CurrentStatus.equals("Status, On Duty"))
            userStatus  = "OnDuty";
            else
                userStatus  = "OffDuty";

            SettingsMoreScreen.back();
            ;
            // CallsScreen2.PressOnElement("Status");
            //CallsScreen2.selectorToClick("Status");
            tabBarScreen2.goToContacts();

        } else {
            TabBarScreen tabBarScreen2 = new TabBarScreen(mDriver);

            tabBarScreen2.goToMore();
            tabBarScreen2.ElementToClick("Status", 0, 0).click();
            userStatus = settingsScreen.returnStatusOfUser();

        }

        return userStatus;
    }




    public void endPTTCall() throws InterruptedException, IOException {


        End_PTT_Call.click();

        Thread.sleep(3000);


    }

    public void checkDisplayOfItemsOfPTTCall() throws InterruptedException, IOException {

        CallsScreen CallsScreen = new CallsScreen(mDriver);
        ConversationScreen conversationScreen= new ConversationScreen(mDriver);
        Thread.sleep(3000);
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_SpeakerBTN(), "Speaker");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_TakeTheFloor(), "Take the floor");

        if (Branding.AGNET.equals(branding)) {
            Calls_options_btn.click();

        } else {
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_ContactDetailsBtn(), "Contact details");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_BackButton(), "Dismiss");
            Thread.sleep(500);

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_Account_image(), "Account image");

        }

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_addContactBtn(), "Add contact");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_VideoStreamingBtn(), "Video streaming");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_GoToConversation(), "Go to conversation");


        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_geolocBtn(), "Geolocation");

        if (Branding.AGNET.equals(branding)) {
            if (Platforms.ANDROID.equals(mPlatform))
                CallsScreen.back();
            else
                conversationScreen.getCancelBtn().click();
        }
    }


    public void selectGroupNewConversation(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
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
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            android.screen.TabBarScreen tabBarScreen = new android.screen.TabBarScreen(mDriver);
            tabBarScreen.getMessageItem();
            ConversationScreen.getConversationNewMessage().click();

            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            ConversationScreen.ElementToClick(GroupAccount, 0, 1).click();
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
        if (Platforms.IOS.equals(mPlatform)) {

            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.SelectContactConversation(Account);
            ConversationScreen.sendsMessages();
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);


            ConversationScreen.SelectContactConversation(Account);

        }
    }

    public void checkItemsOfPTTCall() throws InterruptedException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            CallsScreen CallsScreen = new CallsScreen(mDriver);
            Thread.sleep(3000);

            mLogger.log(Status.PASS, "3 - A & B check the  notification center ");
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            CallsScreen.getPTT_addContactBtn().click();
            Thread.sleep(2000);
            CallsScreen.back();
            Thread.sleep(2000);

            if (Branding.AGNET.equals(branding)) {
                Calls_options_btn.click();

            }
            CallsScreen.getPTT_ContactDetailsBtn().click();
            Thread.sleep(3000);
            if (CallsScreen.isElementDisplayed(CallsScreen.getPTT_OK_ListContact())) {
                CallsScreen.getPTT_OK_ListContact().click();
                Thread.sleep(2000);
            }
            if (Branding.AGNET.equals(branding)) {
                Calls_options_btn.click();

            }
            CallsScreen.getPTT_geolocBtn().click();
            Thread.sleep(5000);
            acceptPermission();

            CallsScreen.getTouchToComeBackToCall().click();

            Thread.sleep(2000);

            CallsScreen.getPTT_SpeakerBTN().click();
            Thread.sleep(2000);
            mLogger.log(Status.PASS, "3 - A take the  floor");

            takeTheFloor();
            mLogger.log(Status.PASS, "4 - A release the  floor");
            if (Branding.AGNET.equals(branding)) {
                Calls_options_btn.click();

            }
            CallsScreen.getPTT_VideoStreamingBtn().click();
            Thread.sleep(2000);
            if (Branding.AGNET.equals(branding)) {
                Calls_options_btn.click();

            }
            CallsScreen.getPTT_GoToConversation().click();
            CallsScreen.getStopVideoStreaming().click();
        } else {
            CallsScreen CallsScreen = new CallsScreen(mDriver);

            mLogger.log(Status.PASS, "A & B have  an  ongoing PTT call");
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            CallsScreen.getPTT_addContactBtn().click();
            Thread.sleep(2000);
            CallsScreen.back();
            Thread.sleep(2000);

            if (Branding.TOTR.equals(branding)) {
                CallsScreen.getPTT_ContactDetailsBtn().click();
                Thread.sleep(2000);
                if (CallsScreen.isElementDisplayed(CallsScreen.getPTT_ListofContactDetails()))
                    CallsScreen.getPTT_OK_ListContact().click();
                Thread.sleep(2000);
            }
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            CallsScreen.getPTT_geolocBtn().click();
            Thread.sleep(9000);
            CallsScreen.back();
            Thread.sleep(2000);

            CallsScreen.getPTT_SpeakerBTN().click();
            Thread.sleep(2000);
            if (Branding.AGNET.equals(branding))
                CallsScreen.back();

            mLogger.log(Status.PASS, "3 - A take the  floor");
            CallsScreen.LonPressOnElement(CallsScreen.getPTT_TakeTheFloor());
            mLogger.log(Status.PASS, "4 - A release the  floor");
            if (Branding.AGNET.equals(branding))
                Calls_options_btn.click();
            CallsScreen.getPTT_VideoStreamingBtn().click();
            Thread.sleep(2000);

        }

    }

    public void goToConversationPTTBtn() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        Thread.sleep(3000);
        if (Branding.AGNET.equals(branding))
            Calls_options_btn.click();
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


        //Thread.sleep(2000);

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalSpeakersBtn(), "Speaker");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalMuteBtn(), "Mute");
        if (Branding.AGNET.equals(branding)) {
            call_menu_Btn.click();
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_go_to_conversation_btn(), "conversation");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.pause_call_btn, "pause call");
            CallsScreen.back();


        } else {

            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDialerBtn(), "Dialer");
            CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDismissBtn(), "Go back");
        }
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalRejectBtn(), "End call");


    }

    public void selectCallBtnFromContact() throws InterruptedException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ContactScreen contactScreen = new ContactScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);


            tabBarScreen.goToContacts();
            contactScreen.getCallBtn().click();

        } else {
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            ContactScreen contactScreen = new ContactScreen(mDriver);
            tabBarScreen.goToContacts();

            if (Branding.TOTR.equals(branding))
                contactScreen.getCallButton().click();
            else
                conversationScreen.getPlusBtn().click();

        }
    }

    public void launchDialerCall() {
        if (Platforms.IOS.equals(mPlatform)) {
            ContactScreen contactScreen = new ContactScreen(mDriver);


            contactScreen.getDialerCall().click();
        } else {
            android.screen.ContactScreen contactScreen = new android.screen.ContactScreen(mDriver);


            contactScreen.getDialer().click();
        }
    }

    public void pushPhoneNumberForDialerCall() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            DialerScreen DialerScreen = new DialerScreen(mDriver);

            DialerScreen.getNine().click();
            DialerScreen.getSeven().click();
            DialerScreen.getEight().click();
            DialerScreen.getSex().click();
            DialerScreen.getEight().click();
            DialerScreen.getEight().click();
            DialerScreen.getEight().click();
            DialerScreen.getSeven().click();


            DialerScreen.getCall_Dialer().click();
        } else {
           DialerScreen DialerScreen = new DialerScreen(mDriver);
           acceptPermission();


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

        if (Branding.TOTR.equals(branding))
            conversationScreen.getCallButton().click();
        else
            recipient_options.click();


    }

    public void launchExternalCallFromConversation() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);


            conversationScreen.getDialer().click();
            Thread.sleep(3000);
        } else {
            ContactScreen contactScreen = new ContactScreen(mDriver);

            mLogger.log(Status.PASS, "1 - User A  call user B via PBX");

            contactScreen.getCallOutPBX().click();
            Thread.sleep(3000);
        }
    }

    public void callOnDutyContacts() throws InterruptedException {
        CallsScreen callsScreen = new CallsScreen(mDriver);


        callsScreen.getCall_On_Duty_contacts().click();
        mLogger.log(Status.PASS, "2 - A call B through PTT call ");
        Thread.sleep(5000);

    }


    public AppiumDriver createSessionForSecondDevice(STWAppiumTest mStwAppiumTest) {

        if (Platforms.IOS.equals(mPlatform))
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        else
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        return mDriver;

    }

    public AppiumDriver createSessionForThirdDevice(STWAppiumTest mStwAppiumTest) {
        if (Platforms.IOS.equals(mPlatform))
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.IOS);
        else
            mDriver = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        return mDriver;
    }

    @AfterMethod
    public void stopAppiumServer() {

        mDriver.close();

    }
}

