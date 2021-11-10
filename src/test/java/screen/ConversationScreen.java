package screen;

import IOS.screen.PermissionsScreen;
import android.screen.CallsScreen;
import android.screen.GeolocationScreen;
import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ConversationScreen extends STWScreen {

    //Thread

    @AndroidFindBy(id = "thread_process_icon")
    private List<MobileElement> processConversationThreadIcon;
    @AndroidFindBy(id = "thread_item_recepients")
    private MobileElement thread_item_recepients;
    @AndroidFindBy(id = "thread_item_contact_icon",priority = 1)
    private MobileElement conversationThreadIcon;
    @AndroidFindBy(id = "thread_item_recepients")
    private List<MobileElement> conversationCell;
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label")
    private MobileElement titleOfConversation;
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_leaveGroupButton")
    private MobileElement leaveConversationButton;
    @iOSXCUITFindBy(id = "CustomAlertView_ok")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmDelete;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement firstContactCell;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonDelete\"])[2]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Delete\"`][2]")
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_buttonDelete",priority = 3)
    private MobileElement deleteConversationBtn;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Today\"`]")
    private MobileElement todayBubble;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ConversationList deselect\"`]", priority = 1)
    // @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"ContactCell_checkbox\"])" ,priority = 2)
    // @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[contains(@name, 'ContactCell_checkbox')]" ,priority = 3)
    private List<IOSElement> contactCell;
    //Elements of New conversation  button, Search contact to upload it
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "bottom_new_message")
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_createCon",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ConversationList beginConversa\"`]")
    private MobileElement ConversationNewMessage;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]", priority = 1)
    @iOSXCUITFindBy(accessibility = "Search")
    @AndroidFindBy(id = "bottom_search")
    @AndroidFindBy(id = "search_contact", priority = 1)
    private MobileElement SearchContact;
    @AndroidFindBy(id = "filter_right")
    private MobileElement SingleContact;
    @AndroidFindBy(id = "filter_left")
    private MobileElement GroupContact;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWContactPickerViewController_doneButton")
    @iOSXCUITFindBy(accessibility = "FloatingButtonMessage", priority = 1)
    @iOSXCUITFindBy(accessibility = "FloatingButtonChoose", priority = 2)
    @AndroidFindBy(id = "bottom_check")
    @AndroidFindBy(id = "multi_contact_fab", priority = 1)
    private MobileElement CheckButton;
    @AndroidFindBy(id = "contact_search_content")
    private MobileElement SearchContactTextField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Subject\"`]")
    @AndroidFindBy(id = "group_name_input")
    private MobileElement groupNameInput;
    @iOSXCUITFindBy(accessibility = "Create")
    @AndroidFindBy(id = "activity_create_thread_confirm_fab")
    private MobileElement createThread;
    @AndroidFindBy(id = "contact_item_name")
    private MobileElement firstResult;
    //Elements of voip button
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_callButton")
    @AndroidFindBy(id = "recipient_names_call")
    @AndroidFindBy(id = "thread_bottom_voip_call", priority = 1)
    private MobileElement ConversationNewCall;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Call']", priority = 1)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_voiceCall")
    @iOSXCUITFindBy(accessibility = "Call", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
    private MobileElement Call;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PTT Call']", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Push-To-Talk']")
    private MobileElement Push_To_Talk;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Conference Call']", priority = 1)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_conferenceCall")
    @iOSXCUITFindBy(accessibility = "Conference Call", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conference Call']")
    private MobileElement Conference_Call;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Video Call']", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Call']")
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_videoCall")
    @iOSXCUITFindBy(accessibility = "Video Call", priority = 1)
    private MobileElement Video_Call;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_cellularCall")
    @iOSXCUITFindBy(accessibility = "Cellular Call", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cellular Call']")
    private MobileElement Cellular_Call;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Call Out via PBX']", priority = 2)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Call Out via PBX']", priority = 1)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_callOutPbxCall")
    @iOSXCUITFindBy(accessibility = "Call Out via PBX", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dialer']")
    private MobileElement Dialer;
    //Elements of video stream button
    @AndroidFindBy(id = "thread_bottom_video_stream")
    private MobileElement ConversationNewVideoBroadcast;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dispatch Managers']")
    private MobileElement video_streamDispatch_Managers;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    private MobileElement video_streamContacts;
    //Elements of Serach button
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Search']", priority = 1)
    @AndroidFindBy(id = "thread_bottom_search")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][1]")
    private MobileElement ConversationSearch;
    @AndroidFindBy(id = "base_search_content")
    private MobileElement ConversationSearchTextField;
    //Elements of 3 dots button
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "menu_action", priority = 1)
    @AndroidFindBy(id = "thread_bottom_menu")
    @iOSXCUITFindBy(accessibility = "MessagesTV menu", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationList optionMore\"])[2]")
    private MobileElement Conversation3dots;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Delete']", priority = 1)
    @AndroidFindBy(id = "menu_item_icon")
    private MobileElement DeleteConversations;
    @AndroidFindBy(id = "thread_delete_select_button")
    private MobileElement SelectAllConversationsToDelete;
    @AndroidFindBy(id = "thread_delete_trash_button")
    private MobileElement DeleteTheSelectedConversation;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Conversation unreadMessagesDow")
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_titleButton")
    @AndroidFindBy(id = "view_switch_right")
    private MobileElement MyCompanyConversation;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "External")
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_extendableListView")
    @AndroidFindBy(id = "view_switch_left")
    private MobileElement ExternalConversation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_editBarButton")
    @iOSXCUITFindBy(accessibility = "Edit")
    private MobileElement EditForSelect;
    //Elements of Conversation One To One
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_wtButton")
    @iOSXCUITFindBy(accessibility = "PTT Call", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  PTT Call']", priority = 2)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PTT Call']", priority = 1)
    @AndroidFindBy(id = "action_one_click_ptt_button")
    @AndroidFindBy(id = "recipient_names_group_name_edit_or_start_walkie_talkie_button", priority = 3)
    private MobileElement PTTOneToOne;
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_wayButton")
    @AndroidFindBy(id = "action_geolocation_button")
    private MobileElement Geolocation_button;
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_callButton")
    @AndroidFindBy(id = "recipient_names_call")
    private MobileElement CallButton;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='*  Video Streaming']", priority = 1)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_streamVideoCall")
    @iOSXCUITFindBy(accessibility = "Video Streaming", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadcast Video']")
    private MobileElement Broadcast_Video;
    //Elements of voice record
    @iOSXCUITFindBy(accessibility = "STWComposerView_recordingButton")
    @AndroidFindBy(id = "message_content_send")
    private MobileElement VoiceRecordButton;
    @AndroidFindBy(id = "view_record_delete_icon")
    private MobileElement DeleteVoiceRecordButton;
    @AndroidFindBy(id = "view_record_counter")
    private MobileElement CounterVoiceRecord;
    @iOSXCUITFindBy(accessibility = "VoiceRecordingView_startRecordingButton")
    @AndroidFindBy(id = "record_button_view_image_view")
    private MobileElement SendVoiceRecord;
    //Elements of send message
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[starts-with(@name, 'STWMessagesViewController_')]")
    private List<MobileElement> messageBubble;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Hello\"])[2]")
    private MobileElement messageBubbleAgnet;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWComposerInputView_textView")
    @AndroidFindBy(id = "message_content_edit_text", priority = 1)
    @AndroidFindBy(id = "group_switch_title",priority = 2)
    @AndroidFindBy(id = "group_name_input")
    private MobileElement ConversationTypeText;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE,androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PhotoVideoCaptionViewController_sendButton", priority = 1)
    @iOSXCUITFindBy(accessibility = "STWComposerView_sendButton")
    @AndroidFindBy(id = "message_content_send")
    @AndroidFindBy(id = "activity_create_thread_confirm_fab",priority = 1)
    private MobileElement SendTextOrAttachment;
    //Elements of attachment
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ComposerShareView_shareButton", priority = 2)
    @iOSXCUITFindBy(accessibility = "STWComposerView_shareButton", priority = 1)
    @AndroidFindBy(id = "message_attachment_button")
    private MobileElement message_attachment_button;
    //Elements of attach Location
    @iOSXCUITFindBy(accessibility = "ComposerShareView_LocationButton")
    @AndroidFindBy(id = "attachment_selector_location_item")
    private MobileElement attachment_location_item;
    @iOSXCUITFindBy(accessibility = "LocationViewController_sendLocationButton")
    @AndroidFindBy(id = "map_share_button")
    private MobileElement map_share_button;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "search_contact", priority = 1)
    @AndroidFindBy(id = "map_toolbar_search_button")
    private MobileElement mapSearchButton;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "map_toolbar_place", priority = 1)
    @AndroidFindBy(id = "map_toolbar_content")
    private MobileElement mapSearchField;
    @AndroidFindBy(id = "location_item_title_text")
    private List<MobileElement> locationsSearchResult;
    @iOSXCUITFindBy(accessibility = "ComposerShareView_PhotoButton")
    @AndroidFindBy(id = "attachment_selector_photo_item")
    private MobileElement attachment_Photo_item;
    @iOSXCUITFindBy(accessibility = "STWComposerView_picture_camera")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take a picture']")
    private MobileElement TakePhoto;
    @iOSXCUITFindBy(accessibility = "FrontBackFacingCameraChooser")
    @AndroidFindBy(id = "front_back_camera_switcher")
    private MobileElement SwitchCamera;
    @AndroidFindBy(id = "settings_view")
    private MobileElement SettingsOfCamera;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement Ok_Item;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "VideoCapture", priority = 2)
    @iOSXCUITFindBy(accessibility = "PhotoCapture")
    @AndroidFindBy(id = "record_button")
    private MobileElement record_Photo;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Use Photo\"`]", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Use Video\"`]", priority = 3)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use Video\"]", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use Photo\"]")
    @AndroidFindBy(id = "confirm_media_result")
    private MobileElement confirm_media_result;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose a photo']")
    private MobileElement ChoosePhoto;
    //Elements of attach Video
    @iOSXCUITFindBy(accessibility = "ComposerShareView_VideoButton")
    @AndroidFindBy(id = "attachment_selector_video_item")
    private MobileElement attachment_Video_item;
    @iOSXCUITFindBy(accessibility = "STWComposerView_video_camera")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Capture a video']")
    private MobileElement CaptureVideo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open the gallery']")
    private MobileElement OpenGallery;
    //Elements of upload contact
    @iOSXCUITFindBy(accessibility = "ComposerShareView_ContactButton")
    @AndroidFindBy(id = "attachment_selector_contact_item")
    private MobileElement attachment_contact_item;
    @iOSXCUITFindBy(accessibility = "ServerContactDetailsForShareViewController_sendButton")
    @AndroidFindBy(id = "vcard_contact_action_btn")
    private MobileElement vcard_contact_Send_btn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Share contact\"`]")
    private MobileElement shareContactTitle;
    //Elements of upload Calendar
    @iOSXCUITFindBy(accessibility = "ComposerShareView_EventButton")
    @AndroidFindBy(id = "attachment_selector_calendar_item")
    private MobileElement attachment_calendar;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CustomEKVIewController_sendButtonItem\"]", priority = 1)
    @iOSXCUITFindBy(accessibility = "CustomEKVIewController_sendButtonItem", priority = 0)
    @AndroidFindBy(id = "calendar_detail_btn")
    private MobileElement sendEventButton;
//Elements of attach Picture
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirSendButton;
    @AndroidFindBy(id = "menu_action_today_calendar_action_bar")
    private MobileElement TodayButton;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWComposerInputView_textView")
    @AndroidFindBy(id = "message_content_edit_text")
    @AndroidFindBy(id = "group_switch_title")
    private MobileElement inputOfSendMessage;
    @iOSXCUITFindBy(accessibility = "STWComposerView_sendButton")
    @AndroidFindBy(id = "message_content_send")
    private MobileElement sendMessageButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonDeletes\"])[2]")
    private MobileElement deleteConversation;
    //Agnet buttons
    @AndroidFindBy(id = "main_fab")
    @iOSXCUITFindBy(accessibility = "FloatingButtonMenu")
    private MobileElement plusBtn;
    @iOSXCUITFindBy(accessibility = "Send message")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Message']")
    private MobileElement sendMessageForUser;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "EventKitItemCell_EventName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, EventKitItemCell_EventName)]", priority = 2)
    @AndroidFindBy(id = "txt_title_event")
    private MobileElement eventDetailsButton;
    //Elements of upload Document
    @iOSXCUITFindBy(accessibility = "ComposerShareView_folderShare")
    @AndroidFindBy(id = "attachment_selector_document_item")
    private MobileElement attachment_Document;
    @iOSXCUITFindBy(accessibility = "STWComposerView_FileSystem")
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement fileDocsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'pdf')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'pdf')]")
    private MobileElement pdfFile;
    //Messages options
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Details", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Details\"])[2]",priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Details\"`][2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Message details']")
    private MobileElement Message_details;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationList optionDelete\"])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Delete\"])[2]", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Delete\"`][2]",priority =3)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ConversationList optionDelete\"`][2]", priority = 2)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete message']")
    private MobileElement Delete_message;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Copy", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Copy\"])[2]",priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Copy\"`][2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Copy text']")
    private MobileElement Copy_text;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Forward", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Forward\"])[2]",priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Forward\"`][2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward by Team on the Run']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward']", priority = 1)
    private MobileElement FWD_BY_TOTR;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward by email']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    private MobileElement Share;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationList optionDelete\"])[2]", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonDelete\"])[2]", priority = 1)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_deleteSelected")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete conversation']")
    private MobileElement DeleteConversation;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open conversation']")
    private MobileElement OpenConversation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationList optionMore\"])[2]", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonMoreOne\"])[4]")
    private MobileElement MoreConversation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_conversationCell_0")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Conversation voipMissedBadge\"])[1]", priority = 1)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"ContactsViewController_0_0\"])[2]",priority = 2)
    private MobileElement FirstConversation;
    @AndroidFindBy(id = "recipient_detail_add")
    private MobileElement detail_add;
    //Conversation process
    @AndroidFindBy(id = "recipient_names")
    private MobileElement recipient_name;
    @AndroidFindBy(id = "exit_conversation")
    private MobileElement exit;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cancel\"`][1]", priority = 1)
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_cancel")
    @iOSXCUITFindBy(accessibility = "Cancel", priority = 2)
    private MobileElement CancelBtn;
    //Element of edit group of conversation
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "recipient_names")
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_titleView")
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label", priority = 1)
    private MobileElement groupNameConversation;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ConversationListViewController_conversationCell_0\"]/XCUIElementTypeButton[2]")
    private MobileElement conversationPreview;
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_searchConversationCell_0")
    private MobileElement firstconversationAfterSearch;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "dialog_edit_text_view", priority = 2)
    @AndroidFindBy(id = "recipient_names_group_name_edit_or_start_walkie_talkie_button", priority = 1)
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_editGroupButton")
    @iOSXCUITFindBy(accessibility = "MessagesTV menu", priority = 1)
    private MobileElement editGroupNameConversation;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Done")
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_validateGroupeNameItem")
    private MobileElement confirmEditGroupNameConversation;
    @iOSXCUITFindBy(accessibility = "Change group name")
    private MobileElement changeGroupName;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Admins\"]")
    private MobileElement adminConversationBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Members\"]")
    private MobileElement membersConversationBtn;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "leave_conversation_btn", priority = 1)
    @AndroidFindBy(id = "exit_conversation")
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_leaveGroupButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GroupContactListViewController_leaveGroupButton\"]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Leave conversation\"]", priority = 1)
    private MobileElement exitFromConversation;
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_addGroupButton")
    @AndroidFindBy(id = "recipient_detail_add")
    private MobileElement addContactFromConversation;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    private MobileElement continueItem;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[1]")
     private MobileElement cancelItem;
    @HowToUseLocators( iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Cancel\"])[1]",priority = 1)
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancelSearch;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "multi_contact_fab", priority = 1)
    @AndroidFindBy(id = "confirm_button")
    @iOSXCUITFindBy(accessibility = "STWContactPickerViewController_doneButton")
    @iOSXCUITFindBy(accessibility = "FloatingButtonChoose", priority = 2)
    private MobileElement confirmBtn;
    @iOSXCUITFindBy(accessibility = "You have left the conversation")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have left the conversation']")
    private MobileElement leaveConversationMsg;
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_closeConversationGroupButton")
    private MobileElement closeConversationBtn;
    @AndroidFindBy(id = "config_recipient_view_only_available_contacts_switch")
    @iOSXCUITFindBy(accessibility = "ReachOnlyAvailableContactsView_switchButton")
    private MobileElement reachOnlyAvailableContacts;
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_okButton")
    private MobileElement validatePopupOnlyAvailableContacts;
    @AndroidFindBy(id = "recipient_names")
    private MobileElement recipientName;
    @HowToUseLocators( androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "Navigate up")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",priority = 1)
    private MobileElement BackBTN;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"OK\"`]",priority = 2)
    private MobileElement okBtn;
    public ConversationScreen(AppiumDriver driver) {
        super(driver);

    }

    public MobileElement getConversationThreadIcon() {
        return conversationThreadIcon;
    }

    public MobileElement getDeleteConversationBtn() {
        return deleteConversationBtn;
    }

    public MobileElement getFirstconversationAfterSearch() {
        return firstconversationAfterSearch;
    }

    public MobileElement getChangeGroupName() {
        return changeGroupName;
    }

    public MobileElement getValidatePopupOnlyAvailableContacts() {
        return validatePopupOnlyAvailableContacts;
    }

    public MobileElement getOkBtn() {
        return okBtn;
    }

    public List<MobileElement> getConversationCell() {
        return conversationCell;
    }

    public MobileElement getThread_item_recepients() {
        return thread_item_recepients;
    }

    public MobileElement getLeaveConversationButton() {
        return leaveConversationButton;
    }

    public MobileElement getTitleOfConversation() {
        return titleOfConversation;
    }

    public MobileElement getGroupNameInput() {
        return groupNameInput;
    }

    public MobileElement getCreateThread() {
        return createThread;
    }

    public List<MobileElement> getMessageBubble() {
        return messageBubble;
    }

    public MobileElement getMapSearchField() {
        return mapSearchField;
    }

    public MobileElement getMapSearchButton() {
        return mapSearchButton;
    }

    public List<MobileElement> getLocationsSearchResult() {
        return locationsSearchResult;
    }

    public MobileElement getTodayButton() {
        return TodayButton;
    }

    public MobileElement getPlusBtn() {
        return plusBtn;
    }

    public MobileElement getSendMessageForUser() {
        return sendMessageForUser;
    }

    public MobileElement getFirstContactCell() {
        return firstContactCell;
    }

    public MobileElement getTodayBubble() {
        return todayBubble;
    }

    public MobileElement getConfirmDelete() {
        return confirmDelete;
    }

    public MobileElement getFirstResult() {
        return firstResult;
    }

    public MobileElement getInputOfSendMessage() {
        return inputOfSendMessage;
    }

    public MobileElement getSendMessageButton() {
        return sendMessageButton;
    }

    public List<IOSElement> getContactCell() {
        return contactCell;
    }

    public MobileElement getShareContactTitle() {
        return shareContactTitle;
    }

    public MobileElement getSendEventButton() {
        return sendEventButton;
    }

    public MobileElement getConfirSendButton() {
        return confirSendButton;
    }

    public MobileElement getEventDetailsButton() {
        return eventDetailsButton;
    }

    public MobileElement getFileDocsButton() {
        return fileDocsButton;
    }

    public MobileElement getPdfFile() {
        return pdfFile;
    }

    public MobileElement getReachOnlyAvailableContacts() {
        return reachOnlyAvailableContacts;
    }

    public MobileElement getRecipientName() {
        return recipientName;
    }

    public MobileElement getLeaveConversationMsg() {
        return leaveConversationMsg;
    }

    public MobileElement getCloseConversationBtn() {
        return closeConversationBtn;
    }

    public MobileElement getConfirmBtn() {
        return confirmBtn;
    }

    public MobileElement getContinueItem() {
        return continueItem;
    }

    public MobileElement getCancelItem() {
        return cancelItem;
    }

    public MobileElement getExitFromConversation() {
        return exitFromConversation;
    }

    public MobileElement getAddContactFromConversation() {
        return addContactFromConversation;
    }

    public MobileElement getAdminConversationBtn() {
        return adminConversationBtn;
    }

    public MobileElement getMembersConversationBtn() {
        return membersConversationBtn;
    }

    public MobileElement getGroupNameConversation() {
        return groupNameConversation;
    }

    public MobileElement getEditGroupNameConversation() {
        return editGroupNameConversation;
    }

    public MobileElement getConfirmEditGroupNameConversation() {
        return confirmEditGroupNameConversation;
    }

    public MobileElement getDetail_add() {
        return detail_add;
    }

    public MobileElement getRecipient_name() {
        return recipient_name;
    }

    public MobileElement getExit() {
        return exit;
    }

    public MobileElement getFirstConversation() {
        return FirstConversation;
    }

    public MobileElement getDeleteConversation() {
        return DeleteConversation;
    }

    public MobileElement getMoreConversation() {
        return MoreConversation;
    }

    public MobileElement getOpenConversation() {
        return OpenConversation;
    }

    public MobileElement getMessage_details() {
        return Message_details;
    }

    public MobileElement getDelete_message() {
        return Delete_message;
    }

    public MobileElement getCopy_text() {
        return Copy_text;
    }

    public MobileElement getFWD_BY_TOTR() {
        return FWD_BY_TOTR;
    }

    public MobileElement getShare() {
        return Share;
    }

    public MobileElement getSearchContact() {
        return SearchContact;
    }

    public MobileElement getSingleContact() {
        return SingleContact;
    }

    public MobileElement getGroupContact() {
        return GroupContact;
    }

    public MobileElement getCheckButton() {
        return CheckButton;
    }

    public MobileElement getSearchContactTextField() {
        return SearchContactTextField;
    }

    public MobileElement getPush_To_Talk() {
        return Push_To_Talk;
    }

    public MobileElement getConference_Call() {
        return Conference_Call;
    }

    public MobileElement getVideo_Call() {
        return Video_Call;
    }

    public MobileElement getCellular_Call() {
        return Cellular_Call;
    }

    public MobileElement getDialer() {
        return Dialer;
    }

    public MobileElement getVideo_streamDispatch_Managers() {
        return video_streamDispatch_Managers;
    }

    public MobileElement getVideo_streamContacts() {
        return video_streamContacts;
    }

    public MobileElement getConversationSearchTextField() {
        return ConversationSearchTextField;
    }

    public MobileElement getDeleteConversations() {
        return DeleteConversations;
    }

    public MobileElement getSelectAllConversationsToDelete() {
        return SelectAllConversationsToDelete;
    }

    public MobileElement getDeleteTheSelectedConversation() {
        return DeleteTheSelectedConversation;
    }

    public MobileElement getPTTOneToOne() {
        return PTTOneToOne;
    }

    public MobileElement getGeolocation_button() {
        return Geolocation_button;
    }

    public MobileElement getCallButton() {
        return CallButton;
    }

    public MobileElement getBroadcast_Video() {
        return Broadcast_Video;
    }

    public MobileElement getVoiceRecordButton() {
        return VoiceRecordButton;
    }

    public MobileElement getDeleteVoiceRecordButton() {
        return DeleteVoiceRecordButton;
    }

    public MobileElement getCounterVoiceRecord() {
        return CounterVoiceRecord;
    }

    public MobileElement getSendVoiceRecord() {
        return SendVoiceRecord;
    }

    public MobileElement getConversationTypeText() {
        return ConversationTypeText;
    }

    public MobileElement getSendTextOrAttachment() {
        return SendTextOrAttachment;
    }

    public MobileElement getMessage_attachment_button() {
        return message_attachment_button;
    }

    public MobileElement getAttachment_location_item() {
        return attachment_location_item;
    }

    public MobileElement getMap_share_button() {
        return map_share_button;
    }

    public List<MobileElement> getProcessConversationThreadIcon() {
        return processConversationThreadIcon;
    }

    public MobileElement getAttachment_Photo_item() {
        return attachment_Photo_item;
    }

    public MobileElement getTakePhoto() {
        return TakePhoto;
    }

    public MobileElement getSwitchCamera() {
        return SwitchCamera;
    }

    public MobileElement getSettingsOfCamera() {
        return SettingsOfCamera;
    }

    public MobileElement getOk_Item() {
        return Ok_Item;
    }

    public MobileElement getRecord_Photo() {
        return record_Photo;
    }

    public MobileElement getConfirm_media_result() {
        return confirm_media_result;
    }

    public MobileElement getChoosePhoto() {
        return ChoosePhoto;
    }

    public MobileElement getAttachment_Video_item() {
        return attachment_Video_item;
    }

    public MobileElement getCaptureVideo() {
        return CaptureVideo;
    }

    public MobileElement getOpenGallery() {
        return OpenGallery;
    }

    public MobileElement getAttachment_contact_item() {
        return attachment_contact_item;
    }

    public MobileElement getVcard_contact_Send_btn() {
        return vcard_contact_Send_btn;
    }

    public MobileElement getAttachment_calendar() {
        return attachment_calendar;
    }

    public MobileElement getAttachment_Document() {
        return attachment_Document;
    }

    public MobileElement getCall() {
        return Call;
    }

    public MobileElement getConversationNewVideoBroadcast() {
        return ConversationNewVideoBroadcast;
    }

    public MobileElement getConversationSearch() {
        return ConversationSearch;
    }

    public MobileElement getConversation3dots() {
        return Conversation3dots;
    }

    public MobileElement getMyCompanyConversation() {
        return MyCompanyConversation;
    }

    public MobileElement getExternalConversation() {
        return ExternalConversation;
    }

    public MobileElement getEditForSelect() {
        return EditForSelect;
    }

    public MobileElement getConversationNewMessage() {
        return ConversationNewMessage;
    }

    public MobileElement getConversationNewCall() {
        return ConversationNewCall;
    }

    public MobileElement getCancelBtn() {
        return CancelBtn;
    }

    public void checkOptionsOfConversationsTab() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            //Send msg and Verify Long press options

            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getEditForSelect(), "Edit to select");
            ConversationScreen.getEditForSelect().click();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDeleteConversation(), "Delete conversation");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMyCompanyConversation(), "My company tab");
            ConversationScreen.getMyCompanyConversation().click();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getExternalConversation(), "External conversation tab");
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getExternalConversation(), "External conversation tab");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMyCompanyConversation(), "My company tab");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversationSearch(), "Search ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversation3dots(), "3 dots ");
            } else {
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversation3dots(), "3 dots ");
                getConversation3dots().click();
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversationSearch(), "Search ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDeleteConversations(), "Delete ");

            }

        }
    }

    public void selectGroupConversation(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {

                ConversationScreen.getConversationNewMessage().click();
            } else {
                plusBtn.click();
                Thread.sleep(2000);
                sendMessageForUser.click();


            }
            waitForElementToBeClickable(ConversationScreen.getSearchContact());
            ConversationScreen.getSearchContact().sendKeys(GroupAccount);
            Thread.sleep(3000);
            //callsScreen.getFirstInstance().click();
            ConversationScreen.clickOnFirstCell(GroupAccount);

            //PressOnElement(Account);
            //ConversationScreen.selectorToClick(Account);
            ConversationScreen.getCheckButton().click();
            Thread.sleep(3000);
            mLogger.log(Status.PASS, "1 - A open user B conversation");


        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {

                ConversationScreen.getConversationNewMessage().click();
            } else {
                plusBtn.click();
                Thread.sleep(2000);
                sendMessageForUser.click();


            }
            waitForElementToBeClickable(ConversationScreen.getSearchContact());
            ConversationScreen.getSearchContact().click();
            Thread.sleep(5000);
            ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
            Thread.sleep(3000);
            //ConversationScreen.ElementToClick(GroupAccount,1,0).click();
            ConversationScreen.clickOnFirstCell(GroupAccount);
            ConversationScreen.getCheckButton().click();
        }
    }

    public void SelectContactConversation(String Account) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {

            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);


            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {

                waitForElementToBeClickable(ConversationScreen.getConversationNewMessage());
                ConversationScreen.getConversationNewMessage().click();
            } else {
                waitForElementToBeClickable(plusBtn);
                plusBtn.click();
                waitForElementToBeClickable(sendMessageForUser);
                sendMessageForUser.click();


            }

            ConversationScreen.getSearchContact().sendKeys(Account);


            ConversationScreen.clickOnFirstCell(Account);

            //PressOnElement(Account);
            //ConversationScreen.selectorToClick(Account);
            ConversationScreen.getCheckButton().click();
            Thread.sleep(3000);
            if(Branding.AGNET.equals(branding))
            ConversationScreen.sendsMessages();
            mLogger.log(Status.PASS, "1 - A open user B conversation");

        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);


            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {

                ConversationScreen.getConversationNewMessage().click();
            } else {
                plusBtn.click();
                Thread.sleep(2000);
                sendMessageForUser.click();


            }
             wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getSearchContact())).click();

            ConversationScreen.getSearchContactTextField().sendKeys(Account);
            Thread.sleep(3000);
            clickOnFirstCell(Account);
            ConversationScreen.getCheckButton().click();
            mLogger.log(Status.PASS, "1 - A open user B conversation");
        }
    }

        public void sendMultiplesMessages(int number){
        int i ;
        int j = 0;
        waitForElementToBeClickable(ConversationTypeText);
    for (i=1 ; j < number; i++){

         ConversationTypeText.sendKeys("Hello");
            SendTextOrAttachment.click();
    }
        }

    public void clickOnFirstCell(String Account) throws InterruptedException, MalformedURLException {
        if (Platforms.IOS.equals(mPlatform)) {
            CallsScreen callsScreen = new CallsScreen(mDriver);
            tapOnElementCell(firstContactCell, 0.5, 0.5);

            Thread.sleep(3000);
            if (Branding.AGNET.equals(branding))
                callsScreen.hideKeyboardIos();
            if (CheckButton.isEnabled() == false) {
                tapOnElementCell(firstContactCell, 0.5, 0.5);
            }

            if (CheckButton.isEnabled() == false) {
                clickOnElementPositionForContactCell(firstContactCell, 5, 5);
            }
            if (CheckButton.isEnabled() == false) {
                tapOnElementCell(firstContactCell, 0.5, 0.5);
                callsScreen.getFirstInstance().click();
            }
            if (CheckButton.isEnabled() == false) {
                ContactNameToClick(Account);
            }


        } else {

            while (CheckButton.isEnabled() == false) {

                ElementToClick(Account, 1, 0).click();
                ElementToClick(Account, 0, 1).click();
                break;

            }
        }

    }

    public void uploadLocation() throws MalformedURLException, InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {

            WebDriverWait wait = new WebDriverWait(mDriver, 10);
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

            TimeUnit.SECONDS.sleep(1);

            // Upload location
            message_attachment_button.click();
            attachment_location_item.click();
            permissionsScreen.acceptPermissions();

            TimeUnit.SECONDS.sleep(2);

            wait.until(ExpectedConditions.elementToBeClickable(map_share_button)).click();

            TimeUnit.SECONDS.sleep(4);
            getSendTextOrAttachment().click();
        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);

            TimeUnit.SECONDS.sleep(1);

            // Upload location
            conversationScreen.getMessage_attachment_button().click();
            conversationScreen.getAttachment_location_item().click();

            TimeUnit.SECONDS.sleep(2);

            //conversationScreen.getMapSearchButton().click();
            //wait.until(ExpectedConditions.elementToBeClickable(conversationScreen.getMapSearchField()));
            Thread.sleep(3000);

            //conversationScreen.getMapSearchField().sendKeys("Tunis");
            //conversationScreen.getLocationsSearchResult().get(0).click();
            wait.until(ExpectedConditions.elementToBeClickable(conversationScreen.getMap_share_button()));
            conversationScreen.getMap_share_button().click();

            waitForElementToBeClickable(getSendTextOrAttachment());
            conversationScreen.getSendTextOrAttachment().click();


        }
    }

    public void uploadCalendar(String bundleId, String title) throws MalformedURLException, InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {

            mDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

            // Upload calendar
            message_attachment_button.click();

            attachment_calendar.click();
            permissionsScreen.acceptPermission();

            if (isElementDisplayed(eventDetailsButton) == false) {
                createEventInCalendarForIos(title);
                openApp(bundleId);
                eventDetailsButton.click();
                sendEventButton.click();
                confirSendButton.click();
                TimeUnit.SECONDS.sleep(2);
                getSendTextOrAttachment().click();

            } else {
                eventDetailsButton.click();
                sendEventButton.click();
                confirSendButton.click();
                TimeUnit.SECONDS.sleep(2);
                getSendTextOrAttachment().click();

            }
        } else {
           /* mDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            ConversationScreen conversationScreen= new ConversationScreen ( mDriver);

            // Upload calendar
            conversationScreen.getMessage_attachment_button().click();

            conversationScreen.getAttachment_calendar().click();
            conversationScreen.getTodayButton().click();
            if (conversationScreen.isElementDisplayed(conversationScreen.getEventDetailsButton()) == false) {
                conversationScreen.createEventInCalendarForAndroid(titleOfEvent);
                conversationScreen.startActivity("com.streamwide.smartms","com.streamwide.smartms.ui.activity.MainActivity");
                openConversationFromChats(Account);
                conversationScreen.getMessage_attachment_button().click();
                conversationScreen.getAttachment_calendar().click();
                conversationScreen.getTodayButton().click();
                conversationScreen.getEventDetailsButton().click();
                conversationScreen.getSendEventButton().click();
                conversationScreen.getConfirSendButton().click();
                TimeUnit.SECONDS.sleep(2);
                conversationScreen.getSendTextOrAttachment().click();

            } else {
                conversationScreen.getEventDetailsButton().click();
                conversationScreen.getSendEventButton().click();
                conversationScreen.getConfirSendButton().click();
                TimeUnit.SECONDS.sleep(2);
                conversationScreen.getSendTextOrAttachment().click();

            }*/

        }
    }

    public void uploadDocument() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            waitForElementToBeClickable(message_attachment_button);
            message_attachment_button.click();
            waitForElementToBeClickable(attachment_Document);

            attachment_Document.click();
            wait.until(ExpectedConditions.elementToBeClickable(fileDocsButton)).click();

            TimeUnit.SECONDS.sleep(1);
            if (isElementDisplayed(pdfFile)) {
                pdfFile.click(); // put a pdf file in documents
                TimeUnit.SECONDS.sleep(2);
                getSendTextOrAttachment().click();
                TimeUnit.SECONDS.sleep(1);
            } else {
                mLogger.log(Status.FAIL, " PDF file is not exist");
                back();

            }

        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);

            conversationScreen.getMessage_attachment_button().click();

            conversationScreen.getAttachment_Document().click();
            wait.until(ExpectedConditions.elementToBeClickable(conversationScreen.getFileDocsButton())).click();
            if (isElementDisplayed(pdfFile)) {
                TimeUnit.SECONDS.sleep(1);
                conversationScreen.getPdfFile().click(); // put a pdf file in documents
                TimeUnit.SECONDS.sleep(2);
                conversationScreen.getSendTextOrAttachment().click();
                TimeUnit.SECONDS.sleep(1);
            } else {
                mLogger.log(Status.PASS, " PDF file is not exist");
                back();

            }
        }


    }

    public void uploadContact(String Account) throws InterruptedException, MalformedURLException {
        if (Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            android.screen.CallsScreen callsScreen = new android.screen.CallsScreen(mDriver);

            getMessage_attachment_button().click();
            getAttachment_contact_item().click();
            permissionsScreen.acceptPermission();
            getSearchContact().sendKeys(Account);
            Thread.sleep(3000);
            //callsScreen.getFirstInstance().click();

            if (isElementDisplayed(getVcard_contact_Send_btn()) == false) {

                tapOnElementPosition(firstContactCell, 0.5, 0.44);
            }
            if (isElementDisplayed(getVcard_contact_Send_btn()) == false) {
                clickOnElementPositionForContactCell(firstContactCell, 5, 5);
            }
            if (isElementDisplayed(getVcard_contact_Send_btn()) == false) {
                ClickOnString(Account);
            }
            //wait.until(ExpectedConditions.visibilityOf(getVcard_contact_Send_btn()));

            getVcard_contact_Send_btn().click();
            Thread.sleep(3000);
            getSendTextOrAttachment().click();
            Thread.sleep(3000);
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            Thread.sleep(3000);
            ConversationScreen.getMessage_attachment_button().click();
            Thread.sleep(3000);
            ConversationScreen.getAttachment_contact_item().click();
            ConversationScreen.getSearchContactTextField().sendKeys(Account);
            ConversationScreen.ElementToClick(Account, 0, 1).click();
            ConversationScreen.getVcard_contact_Send_btn().click();
            Thread.sleep(3000);
            ConversationScreen.getSendTextOrAttachment().click();
        }
    }

    public void uploadPhoto() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
            WebDriverWait wait = new WebDriverWait(mDriver, 10);


            getMessage_attachment_button().click();
            getAttachment_Photo_item().click();
            getTakePhoto().click();
            permissionsScreen.acceptPermission();
            getSwitchCamera().click();
            Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOf(getRecord_Photo()));

            getRecord_Photo().click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(getConfirm_media_result()));

            getConfirm_media_result().click();
            Thread.sleep(5000);
            getSendTextOrAttachment().click();
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            WebDriverWait wait = new WebDriverWait(mDriver, 5);


            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.getAttachment_Photo_item().click();
            ConversationScreen.getTakePhoto().click();
            wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getSwitchCamera())).click();

            ConversationScreen.getSwitchCamera().click();
            Thread.sleep(3000);
            ConversationScreen.getSettingsOfCamera().click();
            Thread.sleep(5000);
            ConversationScreen.getOk_Item().click();
            ConversationScreen.getRecord_Photo().click();
            Thread.sleep(5000);
            ConversationScreen.getConfirm_media_result().click();
            Thread.sleep(5000);
            ConversationScreen.getSendTextOrAttachment().click();


        }
    }

    public void uploadVideo() throws InterruptedException {
        if (Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

            getMessage_attachment_button().click();
            getAttachment_Video_item().click();
            waitForElementToBeClickable(getCaptureVideo());
            getCaptureVideo().click();
            permissionsScreen.acceptPermission();

            getSwitchCamera().click();
            Thread.sleep(3000);
            getRecord_Photo().click();
            Thread.sleep(5000);
            getRecord_Photo().click();

            getConfirm_media_result().click();
            Thread.sleep(5000);
            getSendTextOrAttachment().click();
        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.getAttachment_Video_item().click();
            ConversationScreen.getCaptureVideo().click();
            ConversationScreen.getSwitchCamera().click();
            ConversationScreen.getRecord_Photo().click();
            Thread.sleep(5000);
            ConversationScreen.getRecord_Photo().click();
            if(!isElementDisplayed(ConversationScreen.getConfirm_media_result()))
                ConversationScreen.getRecord_Photo().click();
            wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getConfirm_media_result()));
            ConversationScreen.getConfirm_media_result().click();
            Thread.sleep(5000);
            ConversationScreen.getSendTextOrAttachment().click();
            mLogger.log(Status.PASS, " 3 - A send multiple attachements to B");
            Thread.sleep(3000);
        }
    }

    public void sendAttachments(String Account, String bundleId, String title) throws InterruptedException, MalformedURLException {
        if (Platforms.IOS.equals(mPlatform)) {
            PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

            //upload voice memo
            waitForElementToBeClickable(getVoiceRecordButton());
            getVoiceRecordButton().click();
            permissionsScreen.acceptPermission();
            Thread.sleep(5000);
            getSendVoiceRecord().click();
            mLogger.log(Status.PASS, " 4 - A send multiple voice records to B");
            // upload location
            uploadLocation();
            //ulpoad Document
            uploadDocument();
            // upload calendar
           // uploadCalendar(bundleId, title);
            // Upload Contact
            uploadContact(Account);
            // PressOnElement(Account);
            //ConversationScreen.selectorToClick(Account);
            // Upload picture
            uploadPhoto();
            // Upload video
            uploadVideo();
            mLogger.log(Status.PASS, " 3 - A send multiple attachements to B");
            Thread.sleep(3000);
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            mLogger.log(Status.PASS, " A tries to send  every possible attachements + messages + voice records ");
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            //upload document
            //uploadDocument();
            //upload location
            uploadLocation();
            //upload calendar
            // uploadCalendar(Account,titleOfEvent);
            // Upload Contact

            uploadContact(Account);
            // Upload picture

            uploadPhoto();

            // Upload video
            uploadVideo();

//upload voice memo
            ConversationScreen.getVoiceRecordButton().click();
            Thread.sleep(5000);
            ConversationScreen.getSendVoiceRecord().click();
            mLogger.log(Status.PASS, " 4 - A send multiple voice records to B");
        }
    }

    public void acceptPermissions() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {


            acceptPermissions();

        }
    }

    public void sendsMessages() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            //Send Messages

            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            wait.until(ExpectedConditions.visibilityOf(conversationScreen.getConversationTypeText()));
            conversationScreen.getConversationTypeText().sendKeys("Hello");
            conversationScreen.getSendTextOrAttachment().click();
            Thread.sleep(3000);
            if (isElementDisplayed(validatePopupOnlyAvailableContacts)) {
                validatePopupOnlyAvailableContacts.click();
            }
            mLogger.log(Status.PASS, " 3- A send multiple messages to B");
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getConversationTypeText()));

            //Send Messages
            ConversationScreen.getConversationTypeText().sendKeys("Hello");
            ConversationScreen.getSendTextOrAttachment().click();
            ConversationScreen.getConversationTypeText().sendKeys("Hello");
            ConversationScreen.getSendTextOrAttachment().click();

            mLogger.log(Status.PASS, " 3- A send multiple messages to B");

        }
    }

    public void  swipeLeftOnTextMessage(){
        if (Branding.TOTR.equals(branding)) {

            int size = messageBubble.size() - 1;
            swipe(messageBubble.get(size), "left");
        }else {
            swipe(messageBubbleAgnet, "left");
        }


    }

    public void sendsMessageAndSwipeLeftOrLongPress() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            for (int i = 0; i < 2; i++) {
                Thread.sleep(2000);
                conversationScreen.getConversationTypeText().sendKeys("Hello");
                conversationScreen.getSendTextOrAttachment().click();
            }
            conversationScreen.horizontalSwipeByPercentage(0.1,0.5,0.4);
            //todayBubble.click();

            swipeLeftOnTextMessage();

            int x= 0;
            while((!isElementDisplayed(conversationScreen.getCopy_text())) && (x!=4)){
                swipeLeftOnTextMessage();
                x++;
            }

            //conversationScreen.swipe(conversationScreen.SelectedString("Hello"), "left");

            mLogger.log(Status.PASS, " 5 - A scroll up in the thread");
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            Thread.sleep(3000);
            ConversationScreen.getConversationTypeText().sendKeys("Hello");
            ConversationScreen.getSendTextOrAttachment().click();
            Thread.sleep(5000);

            ConversationScreen.LonPressOnString("Hello", 0, 0);
            mLogger.log(Status.PASS, " 5 - A scroll up in the thread");

        }
    }

    public void checkOptionsOfMessage() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            Thread.sleep(5000);
            mLogger.log(Status.INFO, "  - A long click or swipe left on a messages");

            conversationScreen.CheckDisplayedOfElement(conversationScreen.getDelete_message(), "Delete message");


            if (Branding.AGNET.equals(branding)) {
                if (isElementDisplayed(conversationScreen.getConversation3dots()))
                    conversationScreen.getConversation3dots().click();
            }

            conversationScreen.CheckDisplayedOfElement(conversationScreen.getMessage_details(), "Message Details");
            conversationScreen.CheckDisplayedOfElement(conversationScreen.getCopy_text(), "Copy Text");
            conversationScreen.CheckDisplayedOfElement(conversationScreen.getFWD_BY_TOTR(), "Forward by TOTR");
            if (Branding.AGNET.equals(branding)) {
                if (isElementDisplayed(conversationScreen.getCancelBtn()))
                    conversationScreen.getCancelBtn().click();
            }


        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            mLogger.log(Status.PASS, " 6 - A long click on a messages");

            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMessage_details(), "Message Details");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDelete_message(), "Delete message");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCopy_text(), "Copy Text");
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getFWD_BY_TOTR(), "Forward by TOTR");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getShare(), "Share");
            } else {
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getFWD_BY_TOTR(), "Forward ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getShare(), "Forward by e-mail");
            }


            ConversationScreen.back();
        }
    }

    public void conversationSwipeLeft(String Account) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            Thread.sleep(3000);

            conversationScreen.swipe(conversationScreen.getFirstConversation(), "left");

            //ConversationScreen.getConversationSearch().click();
            // ConversationScreen.getConversationSearchTextField().sendKeys(Account);


        } else {

        }
        mLogger.log(Status.PASS, "3 - Long click (or swipe left for iOS)on user B convrersation entry");

    }

    public void deleteConversationOfUser(String account) throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            searchConversation(account);
            if(isElementDisplayed(conversationThreadIcon)){
            longPressOnElementPosition(conversationThreadIcon);
            waitForElementToBeClickable(getDeleteConversation());
            getDeleteConversation().click();
                waitForElementToBeClickable( getOk_Item());

                getOk_Item().click();
                waitForElementToBeClickable( BackBTN);

                BackBTN.click();
                ;}
            else
            {
             back();
                TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

                if(!isElementDisplayed(tabBarScreen.getChatsItem()))
                back();
            }

        } else {


            searchConversation(account);

            if(isElementDisplayed(firstconversationAfterSearch)) {
                swipe(firstconversationAfterSearch, "left");
                Thread.sleep(500);
                waitForElementToBeClickable(deleteConversationBtn);
                tapOnElementCell(deleteConversationBtn, 0.5, 0.5);
                //deleteConversationBtn.click();
                waitForElementToBeClickable(okBtn);
                okBtn.click();
            }
            else
            {
                if(isElementDisplayed(cancelSearch)) {
                    cancelSearch.click();
                }

            }
        }

    }
    public void searchConversation(String account) throws InterruptedException {
        if(Platforms.IOS.equals(mPlatform)) {
            scrollDown(2, 1000);
            if(isElementDisplayed(ConversationSearch)){
            clearTextFully(ConversationSearch);
            ConversationSearch.sendKeys(account);
                hideKeyboardIos();}
        }else
        {
            if(isElementDisplayed(ConversationSearch)){

                ConversationSearch.click();
            ConversationSearchTextField.sendKeys(account);}
        }
    }
    public void checkOptionsOfConversationThread() throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            mLogger.log(Status.PASS, " 6 - A long click on a messages");
            conversationScreen.CheckDisplayedOfElement(conversationScreen.getDeleteConversation(), "Delete conversation");
            conversationScreen.CheckDisplayedOfElement(conversationScreen.getMoreConversation(), "More of Conversation");
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

            tabBarScreen.goToChats();
            if (Branding.TOTR.equals(branding)) {

                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getExternalConversation(), "External conversation tab");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMyCompanyConversation(), "My company tab");
            }
        }
    }

    public void selectFirstConversation(String Account) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            waitForElementToBeClickable(getFirstConversation());
            conversationScreen.getFirstConversation().click();
            Thread.sleep(3000);
            mLogger.log(Status.PASS, "4 - Open a conversation");
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.ElementToClick(Account, 0, 0).click();
            mLogger.log(Status.PASS, "4 - Open a conversation");

        }
    }

    public void checkOptionsOfConversation() throws InterruptedException, MalformedURLException, IOException {
        Thread.sleep(3000);

        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            //Send msg and Verify Long press options
            //check conversation one to one options

            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getPTTOneToOne(), "PTT icon");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCallButton(), "New call icon");
                ConversationScreen.getCallButton().click();
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCall(), " call ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getVideo_Call(), "Video call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConference_Call(), "Conference call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDialer(), "Call Out via PBX");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getBroadcast_Video(), "Broadcast_Video");
                if(isElementDisplayed( ConversationScreen.getCancelBtn()))
                ConversationScreen.getCancelBtn().click();

            } else {
                waitForElementToBeClickable(Conversation3dots);
                ConversationScreen.getConversation3dots().click();
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getPTTOneToOne(), "PTT icon");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCall(), " call ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getVideo_Call(), "Video call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConference_Call(), "Conference call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDialer(), "Call Out via PBX");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getBroadcast_Video(), "Broadcast_Video");
            }

            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMessage_attachment_button(), "Attachments icon");

            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_calendar(), " Attachment Calendar ");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_contact_item(), "Attachment contact");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_location_item(), "Attachment location");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Document(), "Attachment Document ");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Photo_item(), "Attachment photo");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Video_item(), "Attachment video");

        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            if (Branding.TOTR.equals(branding)) {
                //check conversation one to one options
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getPTTOneToOne(), "PTT icon");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCallButton(), "New call icon");
                ConversationScreen.getCallButton().click();
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCall(), " call ");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getVideo_Call(), "Video call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConference_Call(), "Conference call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCellular_Call(), "Cellular call");
                ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getBroadcast_Video(), "Broadcast_Video");
            } else {

            }
            ConversationScreen.back();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMessage_attachment_button(), "Attachments icon");

            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_calendar(), " Attachment Calendar ");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_contact_item(), "Attachment contact");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_location_item(), "Attachment location");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Document(), "Attachment Document ");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Photo_item(), "Attachment photo");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Video_item(), "Attachment video");


        }
    }


    public void createGroupOfConversation(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);


            ConversationScreen.getGroupNameInput().sendKeys(GroupAccount);
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.getCreateThread().click();
            } else {
                if (isElementDisplayed(reachOnlyAvailableContacts)) {
                    reachOnlyAvailableContacts.click();
                }
                ConversationScreen.getConversationTypeText().sendKeys("Hello");
                ConversationScreen.getSendTextOrAttachment().click();

            }
            if (isElementDisplayed(validatePopupOnlyAvailableContacts)) {
                validatePopupOnlyAvailableContacts.click();
            }
            mLogger.log(Status.PASS, "2 - A adds a group title ");
            Thread.sleep(3000);
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            if (Branding.TOTR.equals(branding)) {
                Thread.sleep(3000);
                ConversationScreen.getConversationTypeText().sendKeys(GroupAccount);
                mLogger.log(Status.PASS, "4 - A types a message ");
                if (isElementDisplayed(reachOnlyAvailableContacts)) {
                    reachOnlyAvailableContacts.click();
                }
                ConversationScreen.getSendTextOrAttachment().click();

                mLogger.log(Status.PASS, "5 - A clicks on send button ");
                mLogger.log(Status.PASS, " - A opens the group conversation ");
                Thread.sleep(2000);
                sendsMessages();
            } else {
                ConversationScreen.getConversationTypeText().sendKeys(GroupAccount);
                Thread.sleep(3000);

                ((AndroidDriver) mDriver).pressKey(new KeyEvent(AndroidKey.BACK));


                Thread.sleep(3000);
                sendsMessages();
            }

        }
    }

    public void editGroupOfConversation(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.getGroupNameConversation().click();
            Thread.sleep(3000);
            waitForElementToBeClickable(ConversationScreen.getEditGroupNameConversation());
            ConversationScreen.getEditGroupNameConversation().click();
            if (Branding.AGNET.equals(branding)) {
                changeGroupName.click();
            }

            ConversationScreen.elementIOSbyxpath(GroupAccount).sendKeys("updated");
            ConversationScreen.getConfirmEditGroupNameConversation().click();
            ConversationScreen.back();
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            mLogger.log(Status.WARNING, " Unable to edit group name on Android, waiting for the fix (Issue : https://jira.streamwide.com/browse/SMARTMS-8936) ");
            //waiting for the fix :
          /*  ConversationScreen.getGroupNameConversation().click();
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.getEditGroupNameConversation().click();
                ConversationScreen.getEditGroupNameConversation().sendKeys("updated");
                ConversationScreen.getOk_Item().click();
            } else {
                mLogger.log(Status.WARNING, " Unable to edit group name on Android, waiting for the fix ");

            }
            ConversationScreen.back();
        }*/
    }
    }

    public void createConversationOfSelectedAccounts(String Account1, String Account2) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            screen.CallsScreen callsScreen= new screen.CallsScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();

            if (Branding.TOTR.equals(branding)) {

                ConversationScreen.getConversationNewMessage().click();
            } else {
                plusBtn.click();
                Thread.sleep(2000);
                sendMessageForUser.click();


            }
            //ConversationScreen.getSearchContact().sendKeys(Account1);
            Thread.sleep(3000);
            //callsScreen.getFirstInstance().click();

            //ConversationScreen.clickOnFirstCell(Account1);

            //ConversationScreen.PressOnElement(Account1);
            ConversationScreen.getSearchContact().sendKeys(Account1);
            ConversationScreen.clickOnFirstCell(Account1);
            ConversationScreen.getSearchContact().click();
            //ConversationScreen.clearTextFully(SearchContact);
            ConversationScreen.getSearchContact().clear();
            ConversationScreen.getSearchContact().sendKeys(Account2);

            Thread.sleep(3000);
           // ConversationScreen.clickOnFirstCell(Account2);
            if (!isElementDisplayed(firstContactCell)){
                tapOnElementCell(firstContactCell, 0.5, 0.5);

            }
            if (!isElementDisplayed(firstContactCell)){
                clickOnElementPositionForContactCell(firstContactCell, 5, 5);

        }
            if (Branding.AGNET.equals(branding))
                callsScreen.hideKeyboardIos();
            ConversationScreen.getCheckButton().click();

            // ConversationScreen.PressOnElement(Account1);
            //  ConversationScreen.selectorToClick(Account2);
            mLogger.log(Status.PASS, "1 - A open user B conversation");
            wait.until(ExpectedConditions.visibilityOf(ConversationScreen.getGroupNameInput()));

            ConversationScreen.getGroupNameInput().sendKeys(Account1 + Account2);
            if (Branding.TOTR.equals(branding))
                ConversationScreen.getCreateThread().click();
            else {
                ConversationScreen.getConversationTypeText().sendKeys("Hello");
                ConversationScreen.getSendTextOrAttachment().click();

            }
        } else {


            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            tabBarScreen.goToChats();
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.getConversationNewMessage().click();
            } else {
                plusBtn.click();
                Thread.sleep(2000);
                sendMessageForUser.click();
            }
            waitForElementToBeClickable(ConversationScreen.getSearchContact());
            ConversationScreen.getSearchContact().click();
            ConversationScreen.getSearchContactTextField().sendKeys(Account1);
            Thread.sleep(3000);
            clickOnFirstCell(Account1);
            ConversationScreen.getSearchContactTextField().clear();
            ConversationScreen.getSearchContactTextField().sendKeys(Account2);
            Thread.sleep(3000);
            ElementToClick(Account2, 1, 0).click();
            ElementToClick(Account2, 0, 1).click();
            ConversationScreen.getCheckButton().click();
            mLogger.log(Status.PASS, "1 - A open user B conversation");
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.getGroupNameInput().sendKeys(Account1 + Account2);
                ConversationScreen.getCreateThread().click();
            } else {
                ConversationScreen.getConversationTypeText().sendKeys(Account1 + Account2);
                Thread.sleep(3000);

                ((AndroidDriver) mDriver).pressKey(new KeyEvent(AndroidKey.BACK));


                Thread.sleep(3000);
                ConversationTypeText.sendKeys("hello");
                ConversationScreen.getSendTextOrAttachment().click();
            }
        }

    }

    public void leaveConversation(String newAdmin) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            Thread.sleep(3000);
            waitForElementToBeClickable( ConversationScreen.getGroupNameConversation());
            ConversationScreen.getGroupNameConversation().click();
            waitForElementToBeClickable(ConversationScreen.getExitFromConversation());
            ConversationScreen.getExitFromConversation().click();
            if (ConversationScreen.isElementDisplayed(ConversationScreen.getOk_Item())) {
                mLogger.log(Status.FAIL, "  no network popup is displayed ");
                mLogger.addScreenCaptureFromPath(ConversationScreen.getscreenshot());

            }
            ConversationScreen.selectorToClick("OK");
            ConversationScreen.getSearchContact().sendKeys(newAdmin);
            ConversationScreen.clickOnFirstCell(newAdmin);


            ConversationScreen.getConfirmBtn().click();
            Thread.sleep(3000);
            ConversationScreen.back();
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getLeaveConversationMsg(), "You have left the conversation");

        } else {
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            //tabBarScreen.goToChats();
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.getGroupNameConversation().click();
            ConversationScreen.getExitFromConversation().click();
            if (ConversationScreen.isElementDisplayed(ConversationScreen.getOk_Item())) {
                mLogger.log(Status.FAIL, "  no network popup is displayed ");
                mLogger.addScreenCaptureFromPath(ConversationScreen.getscreenshot());

            }
            ConversationScreen.getContinueItem().click();
            ConversationScreen.getOk_Item().click();
            ConversationScreen.ElementToClick(newAdmin, 0, 0).click();
            ConversationScreen.getConfirmBtn().click();

            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getLeaveConversationMsg(), "You have left the conversation");
            ConversationScreen.back();
        }
    }


    public void checkGroupOptionsFromContacts(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        if (Platforms.IOS.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
            screen.ContactScreen contactScreen = new screen.ContactScreen(mDriver);


            tabBarScreen.goToContacts();
            ConversationScreen.getSearchContact().sendKeys(GroupAccount);
            if (isElementDisplayed(reachOnlyAvailableContacts)) {
                reachOnlyAvailableContacts.click();
            }
            Thread.sleep(3000);
            waitForElementToBeClickable(FirstConversation);
            ConversationScreen.swipe(ConversationScreen.getFirstConversation(), "left");
            Thread.sleep(3000);
            contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeGroupPTTCallOption(), "PTT call");
            contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(), "Details");
            if(Branding.TOTR.equals(branding)) {
                contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeGroupMoreOption(), "More");

            }else
            {
                contactScreen.CheckDisplayedOfElement(contactScreen.getConfCall(), "Conference Call");
                contactScreen.CheckDisplayedOfElement(contactScreen.getNewGroupConversation(), "New conversation");
                contactScreen.CheckDisplayedOfElement(contactScreen.getBroadcastVideoCall(), "Video Streaming");
                contactScreen.CheckDisplayedOfElement(contactScreen.getContactGeolocation(), "Location");
                contactScreen.CheckDisplayedOfElement(contactScreen.getOpenConversation(), "Open a conversation");




            }
        } else {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            TabBarScreen tabScreen = new TabBarScreen(mDriver);
            screen.ContactScreen contactScreen = new screen.ContactScreen(mDriver);


            tabScreen.goToContacts();
            ConversationScreen.getSearchContact().click();
            contactScreen.getSearchContent().sendKeys(GroupAccount);
            if (Branding.TOTR.equals(branding)) {
                ConversationScreen.LonPressOnString(GroupAccount, 0, 1);
            } else {

                firstResult.click();
            }
            Thread.sleep(3000);
            ConversationScreen.CheckDisplayedOfElement(contactScreen.getNewGroupConversation(), "New conversation ");
            ConversationScreen.CheckDisplayedOfElement(contactScreen.getPTTCall(), "Push to talk ");
            ConversationScreen.CheckDisplayedOfElement(contactScreen.getConfCall(), "Conference call");
        }

    }

    public void dismissAlerts() {
        if (Platforms.ANDROID.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ConversationScreen.dismissAlert();
        }
    }

    public void checkOptionsOfLongPressConversation(String Account) throws InterruptedException, IOException {
        if (Platforms.ANDROID.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            Thread.sleep(3000);
            ConversationScreen.getConversationSearch().click();
            ConversationScreen.getConversationSearchTextField().sendKeys(Account);
            ConversationScreen.LonPressOnString(Account, 0, 1);

            mLogger.log(Status.PASS, "3 - Long click (or swipe left for iOS)on user B convrersation entry");

            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDeleteConversation(), "Delete conversation");
            ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getOpenConversation(), "Open Conversation");
            ConversationScreen.back();
        }

    }

    public void checkDisplayOfPopupOnDuty() throws InterruptedException {
        if (Platforms.ANDROID.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            android.screen.CallsScreen CallsScreen = new CallsScreen(mDriver);


            if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
                mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");

            } else mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is NOT displayed ");
            Thread.sleep(2000);
        }
    }

    public void confirmContinuePopup() throws InterruptedException, MalformedURLException {
        if (Platforms.ANDROID.equals(mPlatform)) {
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
            ConversationScreen.back();
            ConversationScreen.ElementToClick("Continue", 0, 0).click();
        }
    }


    public void clickOnGeolocationIcon() {
        GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver);

        WebDriverWait wait = new WebDriverWait(mDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(Geolocation_button));

        Geolocation_button.click();

    }

    public void writeMessage(String message) {
        inputOfSendMessage.sendKeys(message);
    }

    public void sendMessage() {
        sendMessageButton.click();

    }

    public void deleteConversation() {
        deleteConversation.click();

    }

    public MobileElement getConversationPreview() {
        return conversationPreview;
    }

    public void clickOnTileOfConversation() {
        if (mPlatform.equals(Platforms.ANDROID)) {


            recipientName.click();


        } else {
            titleOfConversation.click();

        }

    }

    public void confirmDelete() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();


    }

    public void openConversation() {

        conversationPreview.click();
    }

}
