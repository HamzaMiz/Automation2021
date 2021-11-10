package android.screen;

import com.aventstack.extentreports.Status;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.LocalDateTime;

public class EmergencyCallScreen extends STWScreen {

    public EmergencyCallScreen(AppiumDriver driver) {
        super(driver);
    }

    //Button emergency call
    @AndroidFindBy(id = "alert_call_title")
    private MobileElement emergency_Call_Button;

    public MobileElement getEmergency_Call_Button() {
        return emergency_Call_Button;
    }


    //Conversation screen (emergency call)
    @AndroidFindBy(id = "message_voip_duration")
    private MobileElement duration;
    @AndroidFindBy(id = "message_voip_container")
    private MobileElement bubble_Activity_Message;
    @AndroidFindBy(id = "attachment_location_image")
    private MobileElement map;
    @AndroidFindBy(id = "recipient_names")
    private MobileElement recipient_Emergency;
    @AndroidFindBy(id = "view_switch_right")
    private MobileElement admin_Groupe;
    @AndroidFindBy(id = "thread_item_date")
    private MobileElement date;


    public MobileElement getDate() {
        return date;
    }

    public MobileElement getRecipient_Emergency() {
        return recipient_Emergency;
    }

    public MobileElement getAdmin_Groupe() {
        return admin_Groupe;
    }

    public MobileElement getBubble_Activity_Message() {
        return bubble_Activity_Message;
    }

    public MobileElement getDuration() {
        return duration;
    }

    public MobileElement getMap() {
        return map;
    }


    //emergency call sceen options
    @AndroidFindBy(id = "walkie_talkie_add_contact_btn")
    private MobileElement add_User;
    @AndroidFindBy(id = "walkie_talkie_contact_details_btn")
    private MobileElement détails;
    @AndroidFindBy(id = "walkie_talkie_video_streaming_button")
    private MobileElement video;
    @AndroidFindBy(id = "walkie_talkie_go_to_conversation_btn")
    private MobileElement conversation;
    @AndroidFindBy(id = "walkie_talkie_geoloc_btn")
    private MobileElement geolocation;
    @AndroidFindBy(id = "mic_push_button")
    private MobileElement ptt_Button;
    @AndroidFindBy(id = "walkie_talkie_back_btn")
    private MobileElement back_Button;
    @AndroidFindBy(id = "walkie_talkie_accept_btn")
    private MobileElement accept_Emergency;
    @AndroidFindBy(id = "walkie_talkie_reject_btn")
    private MobileElement reject_Button;


    public MobileElement getAdd_User() {
        return add_User;
    }

    public MobileElement getDétails() {
        return détails;
    }

    public MobileElement getVideo() {
        return video;
    }

    public MobileElement getConversation() {
        return conversation;
    }

    public MobileElement getGeolocation() {
        return geolocation;
    }

    public MobileElement getPtt_Button() {
        return ptt_Button;
    }

    public MobileElement getBack_Button() {
        return back_Button;
    }

    public MobileElement getAccept_Emergency() {
        return accept_Emergency;
    }

    public MobileElement getReject_Button() {
        return reject_Button;
    }

    public void clickOnEmergencyCall() throws MalformedURLException, InterruptedException {
        LonPressOnElement(getEmergency_Call_Button());
    }

    public void clickOnBackFromEmergency() {
        getBack_Button().click();
    }

    public void verifyDate() {

        String date = getDate().getAttribute("text");

        int hour = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();
        String Local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
        Assert.assertEquals(date, Local_time);

    }

    public void verifyRecipient() {
        getRecipient_Emergency().click();
    }

    public void verifyAdminGroupe() {
        Boolean admin = isElementDisplayed(getAdmin_Groupe());
        Assert.assertFalse(admin);
    }


}
