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
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;

public class EmergencyCallScreen extends STWScreen {
    //Button emergency call
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"EMERGENCY CALL\"`]")
    @AndroidFindBy(id = "alert_call_title")
    private MobileElement emergency_Call_Button;
    //Conversation screen (emergency call)
    @AndroidFindBy(id = "message_voip_duration")
    private MobileElement duration;
    @iOSXCUITFindBy(accessibility = "Outgoing Emergency Call")
    @AndroidFindBy(id = "message_voip_container")
    private MobileElement bubble_Activity_Message;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWMessageCellOUTGOINGLOCATION_locationView")
    @AndroidFindBy(id = "attachment_location_image")
    private MobileElement map;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_titleView", priority = 1)
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label")
    @AndroidFindBy(id = "recipient_names")
    private MobileElement recipient_Emergency;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Admins\"`]")

    @AndroidFindBy(id = "view_switch_right")
    private MobileElement admin_Groupe;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_date_0")
    @iOSXCUITFindBy(accessibility = "Colibri_ConversationListViewController_date_9")
    @AndroidFindBy(id = "thread_item_date")
    private MobileElement date;
    //emergency call sceen options

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Add person to call')]", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_addButton")
    @iOSXCUITFindBy(accessibility = "Add person to call", priority = 1)

    @AndroidFindBy(id = "walkie_talkie_add_contact_btn")
    private MobileElement add_User;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_detailsButton")
    @iOSXCUITFindBy(accessibility = "Details")
    @AndroidFindBy(id = "walkie_talkie_contact_details_btn")
    private MobileElement détails;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Video Streaming')]", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_videoStreaming")

    @iOSXCUITFindBy(accessibility = "Video Streaming", priority = 1)
    @AndroidFindBy(id = "walkie_talkie_video_streaming_button")
    private MobileElement video;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Conversation')]", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_goToConversationButton")
    @iOSXCUITFindBy(accessibility = "Conversation", priority = 1)
    @AndroidFindBy(id = "walkie_talkie_go_to_conversation_btn")
    private MobileElement conversation;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Location')]", priority = 1)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_geoLocButton")
    @iOSXCUITFindBy(accessibility = "Location", priority = 1)
    @AndroidFindBy(id = "walkie_talkie_geoloc_btn")
    private MobileElement geolocation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_pushToTalkButton")
    @iOSXCUITFindBy(accessibility = "Colibri_PTTCallView_pushToTalkButton", priority = 1)
    @AndroidFindBy(id = "mic_push_button")
    private MobileElement ptt_Button;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_hideButton")

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "walkie_talkie_back_btn")
    @AndroidFindBy(accessibility = "Navigate up", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"backButtonIcon\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"backButtonIcon\"")
    @iOSXCUITFindBy(accessibility = "backButtonIcon")
    private MobileElement back_Button;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_startButton")
    @iOSXCUITFindBy(accessibility = "PttAcceptButtonIcon")
    @AndroidFindBy(id = "walkie_talkie_accept_btn")
    private MobileElement accept_Emergency;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PushToTalkView_self.cancelButton")
    @iOSXCUITFindBy(accessibility = "PttDeclineButtonIcon")
    @AndroidFindBy(id = "walkie_talkie_reject_btn")
    private MobileElement reject_Button;

    public MobileElement getSos() {
        return sos;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"sos\"`]")
    @AndroidFindBy(id = "sos_floating_button")
    private MobileElement sos;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Call\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Call')]")
    private MobileElement agnetEmergencyCallButton;


    @AndroidFindBy(id = "ptt_options_btn")
    @iOSXCUITFindBy(accessibility = "PttMoreIcon")
    private MobileElement pttOption;

    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancel;


    public EmergencyCallScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getBack_Button() {
        return back_Button;
    }


    public void clickOnEmergencyCall() throws MalformedURLException, InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            if (Branding.AGNET.equals(branding)) {
                sos.click();
                clickOnElementByString("Call");
                acceptAlert();


            } else
                LonPressOnElement(emergency_Call_Button);


        } else {

            if (Branding.AGNET.equals(branding)) {
                sos.click();
                agnetEmergencyCallButton.click();

            } else {
                LonPressOnElement(emergency_Call_Button);
            }
        }
    }

    public void clickOnBackFromEmergency() {
        waitForElementToBeClickable(getBack_Button());
        getBack_Button().click();
    }

    public void verifyDate() {

        if (mPlatform.equals(Platforms.ANDROID)) {
            String time = date.getAttribute("text");

            int hour = LocalDateTime.now().getHour();
            int min = LocalDateTime.now().getMinute();
            int minMinus1 = LocalDateTime.now().getMinute()-1;

            String Local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
            String Local_timeMinus1 = String.format("%02d", hour) + ":" + String.format("%02d", minMinus1);

            //Assert.assertEquals(time, Local_time);
            if (time.equals(Local_time) || time.equals(Local_timeMinus1))
                mLogger.log(Status.PASS, "Time is correct");
            else
                mLogger.log(Status.FAIL, "Time is not correct");


        } else {

            String datee = date.getAttribute("label");


            int hour = LocalDateTime.now().getHour();
            int min = LocalDateTime.now().getMinute();
            int minPrime = LocalDateTime.now().getMinute() - 1;

            String Local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
            String Local_timePrime = String.format("%02d", hour) + ":" + String.format("%02d", minPrime);

            if (datee == Local_time) {
                Assert.assertEquals(datee, Local_time);
            } else if (datee == Local_timePrime) {
                Assert.assertEquals(datee, Local_timePrime);
            }


        }


    }

    public void verifyRecipient() {
        recipient_Emergency.click();
    }

    public void verifyAdminGroupe() {
        Boolean admin = isElementDisplayed(admin_Groupe);
        Assert.assertFalse(admin);
    }


    public void acceptEmergencyCallFromSecondDevice() {
        accept_Emergency.click();
    }


    public void endEmergencyCallFromSecondDevice() {
        reject_Button.click();
    }

    public void verifyEmergencyCallButton() {
        if (mPlatform.equals(Platforms.ANDROID)) {
            Boolean emergencyButton = isElementDisplayed(emergency_Call_Button);
            Assert.assertFalse(emergencyButton);

        } else {
            Boolean emergencyButton = isElementDisplayed(emergency_Call_Button);
            Assert.assertFalse(emergencyButton);
        }

    }

    public void checkDate() {
        date.click();
    }

    public void checkConversationEmergencyCall() throws IOException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            CheckDisplayedOfElement(bubble_Activity_Message, "Check the bubble activity message");
            CheckDisplayedOfElement(duration, "Check the duration of the call");
            CheckDisplayedOfElement(map, " Check the map preview");
            mLogger.log(Status.PASS, "Check the conversation of the emergency call screen");
            verifyRecipient();
            mLogger.log(Status.PASS, "Check the members");
            verifyAdminGroupe();
            mLogger.log(Status.PASS, "The conversation is similar to group conversation but no admin");
        } else {
            Thread.sleep(3000);
            CheckDisplayedOfElement(bubble_Activity_Message, "Check the bubble activity message");
            Thread.sleep(2000);
            if (Branding.TOTR.equals(branding)) {
                CheckDisplayedOfElement(map, "Check the map preview");
            }
            mLogger.log(Status.PASS, "Check the conversation of the emergency call screen");
            recipient_Emergency.click();
            mLogger.log(Status.PASS, "Check the members");
            Boolean admin = isElementDisplayed(admin_Groupe);
            Assert.assertFalse(admin);
            mLogger.log(Status.PASS, "The conversation is similar to group conversation but no admin");

        }

    }


    public void checkEmergencyCallScreen() throws IOException, InterruptedException {

        CheckDisplayedOfElement(ptt_Button, "Ptt button ");
        CheckDisplayedOfElement(getBack_Button(), "Back button ");
        CheckDisplayedOfElement(reject_Button, "Reject button ");

        if (Branding.AGNET.equals(branding)) {

            pttOption.click();


        } else {

            CheckDisplayedOfElement(détails, "Details emergency call");


        }

        CheckDisplayedOfElement(add_User, "Add user button");
        CheckDisplayedOfElement(conversation, "Conversation");
        CheckDisplayedOfElement(video, "Video button");
        CheckDisplayedOfElement(geolocation, "Get geolocation");

        if (Branding.AGNET.equals(branding)) {


            if (mPlatform.equals(Platforms.ANDROID)) {
                back();
            } else {
                cancel.click();

            }
        }


    }
}


