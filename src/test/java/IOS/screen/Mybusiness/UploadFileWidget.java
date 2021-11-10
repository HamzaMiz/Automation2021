package IOS.screen.Mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class UploadFileWidget  extends STWScreen {

    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "UploadButtonCell_fileUploadButton")
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
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement contactCell;
    //Elements of upload Document
    @iOSXCUITFindBy(accessibility = "ComposerShareView_folderShare")
    @AndroidFindBy(id = "attachment_selector_document_item")
    private MobileElement attachmentDocumentButton;

    @iOSXCUITFindBy(accessibility = "STWComposerView_FileSystem")
    private MobileElement fileDocsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'pdf')]")
    private MobileElement pdfFile;

    public MobileElement getFileDocsButton() {
        return fileDocsButton;
    }

    public MobileElement getPdfFile() {
        return pdfFile;
    }
//Elements of uploaded attachments

    @iOSXCUITFindBy(accessibility = "ProcessFileCell_photoViewCell")
    private MobileElement attachmentPhotoFile;

    @iOSXCUITFindBy(accessibility = "ProcessFileCell_videoViewCell")
    private MobileElement attachmentVideoFile;

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
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        // Upload Contact
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileButton)).click();
        attachementContactButton.click();
        searchBar.sendKeys(contact);
        hideKeyboardIos();
        TimeUnit.SECONDS.sleep(1);

        // wait.until(ExpectedConditions.elementToBeClickable(myBusinessScreen.getContactCellName()));
        //myBusinessScreen.PressOnElement(contact);
        try {
            // PressOnElement(Account);
            // callsScreen.getFirstInstance().click();
            tapOnElementPosition(contactCell,0.5,0.5);


        }catch(Exception ex) {
            clickOnElementPositionForContactCell(contactCell,5,5);

        }
       // myBusinessScreen.scrollToMobileElement(contact,"down") ;
        myBusinessScreen.ClickOnString(contact);
        vcardContactSendBtn.click();
        TimeUnit.SECONDS.sleep(1);

    }

    public void uploadPicture() throws MalformedURLException, InterruptedException {

        mDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        // Upload picture
        uploadFileButton.click();
        attachementPhotoButton.click();
        takePhoto.click();
        switchCamera.click();

        recordPhoto.click();

    }

    public void uploadVideo() throws MalformedURLException, InterruptedException {
        mDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Upload video
        uploadFileButton.click();
        attachementVideoButton.click();
        captureVideo.click();
        TimeUnit.SECONDS.sleep(2);
        switchCamera.click();
        recordPhoto.click();
        Thread.sleep(5000);
        recordPhoto.click();


    }

    public void uploadLocation() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 30);

        TimeUnit.SECONDS.sleep(1);

        // Upload location
        uploadFileButton.click();
        attachementLocationButton.click();
        TimeUnit.SECONDS.sleep(2);

        wait.until(ExpectedConditions.elementToBeClickable(shareLocationButton)).click();

        TimeUnit.SECONDS.sleep(4);

    }

    public void uploadCalendar(String bundleId,String title) throws MalformedURLException, InterruptedException {
        mDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // Upload calendar
        uploadFileButton.click();

        attachmentCalendarButton.click();
        if (isElementDisplayed(eventDetailsButton) == false) {
            createEventInCalendarForIos(title);
            openApp(bundleId);
            eventDetailsButton.click();
            sendEventButton.click();
            confirSendButton.click();
        TimeUnit.SECONDS.sleep(2);
        } else {
            eventDetailsButton.click();
            sendEventButton.click();
            confirSendButton.click();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void uploadDocument() throws InterruptedException {
        uploadFileButton.click();
        attachmentDocumentButton.click();
        fileDocsButton.click();
        pdfFile.click();
        TimeUnit.SECONDS.sleep(2);


    }

    public void checkAttachementsDisplayed(){

        SoftAssert softAssert = new SoftAssert();

        if (isElementDisplayed(attachmentcontactFile))
            softAssert.assertTrue(isElementDisplayed(attachmentcontactFile));


        if (isElementDisplayed(attachmentDocumentFile))
            softAssert.assertTrue(isElementDisplayed(attachmentDocumentFile));

        if (isElementDisplayed(attachmentEventFile))
            softAssert.assertTrue(isElementDisplayed(attachmentEventFile));

        if (isElementDisplayed(attachmentPhotoFile))
            softAssert.assertTrue(isElementDisplayed(attachmentPhotoFile));

        if (isElementDisplayed(attachmentLocationFile))
            softAssert.assertTrue(isElementDisplayed(attachmentcontactFile));

        if (isElementDisplayed(attachmentVideoFile))
            softAssert.assertTrue(isElementDisplayed(attachmentVideoFile));
        softAssert.assertAll();

    }

}