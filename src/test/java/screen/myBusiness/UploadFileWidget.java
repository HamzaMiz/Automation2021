package screen.myBusiness;

import IOS.screen.Mybusiness.MyBusinessScreen;
import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UploadFileWidget  extends STWScreen {

    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "UploadButtonCell_fileUploadButton")
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
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "SWCameraViewController_switchButton",priority = 1)
    @iOSXCUITFindBy(accessibility = "FrontBackFacingCameraChooser")
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
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement firstContactCell;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstContactOnThelist;
    //Elements of upload Calendar
    @iOSXCUITFindBy(accessibility = "ComposerShareView_EventButton")
    @AndroidFindBy(id = "attachment_selector_calendar_item")
    private MobileElement attachmentCalendarButton;
    @iOSXCUITFindBy(accessibility = "CustomEKVIewController_sendButtonItem")
    private MobileElement sendEventButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Yes\"`]")
    private MobileElement confirSendButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "More Info",priority = 1)
    @iOSXCUITFindBy(accessibility = "EventKitItemCell_EventName",priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"EventKitItemCell_EventName\"])[1]",priority = 3)
    private MobileElement eventDetailsButton;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private List<MobileElement> contactCell;
    //Elements of upload Document
    @iOSXCUITFindBy(accessibility = "ComposerShareView_folderShare")
    @AndroidFindBy(id = "attachment_selector_document_item")
    private MobileElement attachmentDocumentButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWComposerView_FileSystem")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"STWComposerView_FileSystem\"`]")
    private MobileElement fileDocsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'pdf')]")
    private MobileElement pdfFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_photoViewCell")
    private MobileElement attachmentPhotoFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_videoViewCell")
    private MobileElement attachmentVideoFile;
//Elements of uploaded attachments
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_documentViewCell")
    private MobileElement attachmentDocumentFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_locationViewCell")
    private MobileElement attachmentLocationFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_eventViewCell")
    private MobileElement attachmentEventFile;
    @iOSXCUITFindBy(accessibility = "ProcessFileCell_contactViewCell")
    private MobileElement attachmentcontactFile;

    public UploadFileWidget(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getFileDocsButton() {
        return fileDocsButton;
    }

    public MobileElement getPdfFile() {
        return pdfFile;
    }

    public MobileElement getAttachmentPhotoFile() {
        return attachmentPhotoFile;
    }

    public MobileElement getAttachmentVideoFile() {
        return attachmentVideoFile;
    }

    public MobileElement getAttachmentDocumentFile() {
        return attachmentDocumentFile;
    }

    public MobileElement getAttachmentLocationFile() {
        return attachmentLocationFile;
    }

    public MobileElement getAttachmentEventFile() {
        return attachmentEventFile;
    }

    public MobileElement getAttachmentcontactFile() {
        return attachmentcontactFile;
    }

    public MobileElement getFirstResultofTheSearch() {
        return firstResultofTheSearch;
    }

    public MobileElement getSendEventButton() {
        return sendEventButton;
    }

    public MobileElement getConfirSendButton() {
        return confirSendButton;
    }

    public MobileElement getAttachementLocationButton() {
        return attachementLocationButton;
    }

    public MobileElement getEventDetailsButton() {
        return eventDetailsButton;
    }

    public MobileElement getOkBtn() {
        return OkBtn;
    }

    public MobileElement getRecordPhoto() {
        return recordPhoto;
    }

    public MobileElement getConfirmMediaResult() {
        return confirmMediaResult;
    }

    public MobileElement getUploadFileButton() {
        return uploadFileButton;
    }

    public MobileElement getSearchBar() {
        return searchBar;
    }

    public MobileElement getAttachementPhotoButton() {
        return attachementPhotoButton;
    }

    public MobileElement getTakePhoto() {
        return takePhoto;
    }

    public MobileElement getSwitchCamera() {
        return switchCamera;
    }

    public MobileElement getSettingsOfCamera() {
        return settingsOfCamera;
    }


    public MobileElement getChoosePhoto() {
        return choosePhoto;
    }

    public MobileElement getAttachementVideoButton() {
        return attachementVideoButton;
    }

    public MobileElement getCaptureVideo() {
        return captureVideo;
    }

    public MobileElement getOpenGallery() {
        return openGallery;
    }

    public MobileElement getUploadLocationButton() {
        return attachementLocationButton;
    }

    public MobileElement getShareLocationButton() {
        return shareLocationButton;
    }

    public MobileElement getAttachementContactButton() {
        return attachementContactButton;
    }

    public MobileElement getVcardContactSendBtn() {
        return vcardContactSendBtn;
    }

    public MobileElement getAttachmentCalendarButton() {
        return attachmentCalendarButton;
    }

    public MobileElement getAttachmentDocumentButton() {
        return attachmentDocumentButton;
    }


    public void uploadContact(String contact) throws MalformedURLException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(mDriver, 30);
        IOS.screen.Mybusiness.MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        // Upload Contact
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileButton)).click();
        attachementContactButton.click();

        while(isElementDisplayed(vcardContactSendBtn)== false){

          //  tapOnElementCell(firstContactCell, 0.5, 0.42);
            waitForElementToBeClickable(firstContactOnThelist);
            firstContactOnThelist.click();
        break;
        }
       // myBusinessScreen.scrollToMobileElement(contact,"down") ;
        waitForElementToBeClickable(vcardContactSendBtn);
        vcardContactSendBtn.click();
        TimeUnit.SECONDS.sleep(1);

    }

    public void uploadPicture() throws MalformedURLException, InterruptedException {


        waitForElementToBeClickable(uploadFileButton);
        // Upload picture
        uploadFileButton.click();
        waitForElementToBeClickable(attachementPhotoButton);

        attachementPhotoButton.click();
        waitForElementToBeClickable(takePhoto);

        takePhoto.click();
        switchCamera.click();

        recordPhoto.click();

    }

    public void uploadVideo() throws MalformedURLException, InterruptedException {

        // Upload video
        waitForElementToBeClickable(uploadFileButton);
        uploadFileButton.click();

        attachementVideoButton.click();
        waitForElementToBeClickable(captureVideo);
        captureVideo.click();
        TimeUnit.SECONDS.sleep(2);
        switchCamera.click();
        waitForElementToBeClickable(recordPhoto);

        recordPhoto.click();
        Thread.sleep(5000);
        recordPhoto.click();


    }

    public void uploadLocation() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 30);

        TimeUnit.SECONDS.sleep(1);
        waitForElementToBeClickable(uploadFileButton);

        // Upload location
        uploadFileButton.click();
        attachementLocationButton.click();
        TimeUnit.SECONDS.sleep(2);

        wait.until(ExpectedConditions.elementToBeClickable(shareLocationButton)).click();

        TimeUnit.SECONDS.sleep(4);

    }

    public void uploadCalendar(String bundleId,String title) throws MalformedURLException, InterruptedException {

        // Upload calendar
        waitForElementToBeClickable(uploadFileButton);
        uploadFileButton.click();
        waitForElementToBeClickable(attachmentCalendarButton);


        attachmentCalendarButton.click();
        mLogger.log(Status.INFO, " user click the calendar attachement button ");

        if (isElementDisplayed(eventDetailsButton) == false) {
            mLogger.log(Status.INFO, " user have no event in calendar ");

            createEventInCalendarForIos(title);
            mLogger.log(Status.INFO, " user create event in calendar ");

            openApp(bundleId);
            mLogger.log(Status.INFO, " user go back to the app ");

            eventDetailsButton.click();
            sendEventButton.click();
            mLogger.log(Status.INFO, " user send the event of the calendar ");

            waitForElementToBeClickable(confirSendButton);
            confirSendButton.click();
        TimeUnit.SECONDS.sleep(2);
        } else {
            mLogger.log(Status.INFO, " user have  event that already exist in calendar ");

            eventDetailsButton.click();
            mLogger.log(Status.INFO, " user select the event of the calendar ");

            sendEventButton.click();
            mLogger.log(Status.INFO, " user send the event of the calendar ");

            waitForElementToBeClickable(confirSendButton);

            confirSendButton.click();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void uploadDocument() throws InterruptedException {
        waitForElementToBeClickable(uploadFileButton);

        uploadFileButton.click();
        attachmentDocumentButton.click();
        waitForElementToBeClickable(fileDocsButton);
        fileDocsButton.click();
        waitForElementToBeClickable(pdfFile);
        pdfFile.click();
        TimeUnit.SECONDS.sleep(2);


    }

    public void checkAttachementsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(attachmentcontactFile,"attachement contact");
        CheckDisplayedOfElement(attachmentDocumentFile,"attachement document");
        CheckDisplayedOfElement(attachmentEventFile,"attachement event calendar");
        CheckDisplayedOfElement(attachmentPhotoFile,"attachement photo");
        CheckDisplayedOfElement(attachmentLocationFile,"attachement location");
        CheckDisplayedOfElement(attachmentVideoFile,"attachement video");




    }

}