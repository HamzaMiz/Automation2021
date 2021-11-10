package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EmergencyCallScreen extends STWScreen {

    public EmergencyCallScreen(AppiumDriver driver) {
        super(driver);
    }

    //Button emergency call
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"EMERGENCY CALL\"`]")
    private MobileElement emergency_Call_Button;

    public MobileElement getEmergency_Call_Button() {
        return emergency_Call_Button;
    }


    //Conversation screen (emergency call)
    @iOSXCUITFindBy(accessibility = "Outgoing Emergency Call")
    private MobileElement bubble_Activity_Message;
    @iOSXCUITFindBy(accessibility = "STWMessageCellOUTGOINGLOCATION_locationView")
    private MobileElement map;
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_titleView")
    private MobileElement recipient_Emergency;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Admins\"`]")
    private MobileElement admin_Groupe;
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_date_0")
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

   /* public MobileElement getDuration() {
        return duration;
    }*/

    public MobileElement getMap() {
        return map;
    }


    //emergency call sceen options
    @iOSXCUITFindBy(accessibility = "PushToTalkView_addButton")
    private MobileElement add_User;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_detailsButton")
    private MobileElement détails;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_videoStreaming")
    private MobileElement video;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_goToConversationButton")
    private MobileElement conversation;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_geoLocButton")
    private MobileElement geolocation;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_pushToTalkButton")
    private MobileElement ptt_Button;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_hideButton")
    private MobileElement back_Button;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Accept\"]")
    private MobileElement accept_Emergency;
    @iOSXCUITFindBy(accessibility = "PushToTalkView_self.cancelButton")
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

}
