package android.screen.mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class UploadFileWidget  extends STWScreen {
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "file_upload_widget_image")
    private MobileElement uploadFileButton;
    @iOSXCUITFindBy(accessibility = "ComposerShareView_PhotoButton")
    @AndroidFindBy(id = "attachment_selector_photo_item")
    private MobileElement attachementPhotoButton;
    @iOSXCUITFindBy(accessibility = "STWComposerView_picture_camera")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take a picture']")
    private MobileElement takePhoto;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'contactAvatar')]")
    private MobileElement firstResultofTheSearch;
    //Elements of attach Picture
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "SWCameraViewController_switchButton")
    @AndroidFindBy(id = "front_back_camera_switcher")
    private MobileElement switchCamera;
    @AndroidFindBy(id = "settings_view")
    private MobileElement settingsOfCamera;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement OkBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "VideoCapture", priority = 2)
    @iOSXCUITFindBy(accessibility = "SWCameraViewController_snapButton")
    @AndroidFindBy(id = "record_button")
    private MobileElement recordPhoto;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use Video\"]", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use Photo\"]")
    @AndroidFindBy(id = "confirm_media_result")
    private MobileElement confirmMediaResult;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose a photo']")
    private MobileElement choosePhoto;
    //Elements of attach Video
    @iOSXCUITFindBy(accessibility = "ComposerShareView_VideoButton")
    @AndroidFindBy(id = "attachment_selector_video_item")
    private MobileElement attachementVideoButton;
    @iOSXCUITFindBy(accessibility = "STWComposerView_video_camera")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Capture a video']")
    private MobileElement captureVideo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open the gallery']")
    private MobileElement openGallery;
    //Elements of upload location
    @iOSXCUITFindBy(accessibility = "ComposerShareView_LocationButton")
    private MobileElement attachementLocationButton;
    @iOSXCUITFindBy(accessibility = "LocationViewController_sendLocationButton")
    private MobileElement shareLocationButton;
    //Elements of upload contact
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "ComposerShareView_ContactButton")
    @AndroidFindBy(id = "attachment_selector_contact_item")
    private MobileElement attachementContactButton;
    @iOSXCUITFindBy(accessibility = "ServerContactDetailsForShareViewController_sendButton")
    @AndroidFindBy(id = "vcard_contact_action_btn")
    private MobileElement vcardContactSendBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`]")
    private MobileElement searchBar;
    //Elements of upload Calendar
    @iOSXCUITFindBy(accessibility = "ComposerShareView_EventButton")
    @AndroidFindBy(id = "attachment_selector_calendar_item")
    private MobileElement attachmentCalendarButton;
    @iOSXCUITFindBy(accessibility = "CustomEKVIewController_sendButtonItem")
    private MobileElement sendEventButton;
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    private MobileElement confirSendButton;
    @iOSXCUITFindBy(accessibility = "More Info")
    private MobileElement eventDetailsButton;
    //Elements of upload Document
    @iOSXCUITFindBy(accessibility = "ComposerShareView_folderShare")
    @AndroidFindBy(id = "attachment_selector_document_item")
    private MobileElement attachmentDocumentButton;
    @iOSXCUITFindBy(accessibility = "STWComposerView_FileSystem")
    private MobileElement fileDocsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'pdf')]")
    private MobileElement pdfFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_photoViewCell")
    private MobileElement attachmentPhotoFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_videoViewCell")
    private MobileElement attachmentVideoFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_documentViewCell")
    private MobileElement attachmentDocumentFile;
//Elements of uploaded attachments
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_locationViewCell")
    private MobileElement attachmentLocationFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_eventViewCell")
    private MobileElement attachmentEventFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_contactViewCell")
    private MobileElement attachmentcontactFile;

    public UploadFileWidget(AppiumDriver driver) {
        super(driver);
    }

    public void uploadPicture() throws MalformedURLException, InterruptedException {

        mDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        // Upload picture
        uploadFileButton.click();
        String pageSource = mDriver.getPageSource();
            System.out.println(pageSource);
        clickOnElementByString("Photos");

    }

}
