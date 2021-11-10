package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VoipScreen extends STWScreen {
    public VoipScreen(AppiumDriver driver) {
        super( driver);
    }




    //Accept Button
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton")
    private MobileElement accept;




    //full blue screen when start call before answer
    @iOSXCUITFindBy(accessibility = "Calling")
    private MobileElement message_Call;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    private MobileElement Avatar;

    @iOSXCUITFindBy(accessibility = "LiveCallView_userName")
    private MobileElement name;

    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    private MobileElement enable_disable_Mic;

    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOption")
    private MobileElement output;

    @iOSXCUITFindBy(accessibility = "more call options")
    private MobileElement more_Option;

    @iOSXCUITFindBy(accessibility = "pause call")
    private MobileElement pause;


    @iOSXCUITFindBy(accessibility = "LiveCallView_goToConversation")
    private MobileElement conversation;

    @iOSXCUITFindBy(accessibility = "LiveCallView_geolocation")
    private MobileElement location;

    @iOSXCUITFindBy(accessibility = "LiveCallView_broadcast_video")
    private MobileElement videoStreaming;


    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    private MobileElement end_Button;


    @iOSXCUITFindBy(accessibility = "LiveCallView_cancel")
    private MobileElement cancel;


    //full blue screen when start call after answer

    @iOSXCUITFindBy(accessibility = "LiveCallView_timer")
    private MobileElement time_Spent ;

    @iOSXCUITFindBy(accessibility = "9 Voip transferIconBackground")
    private MobileElement transfer_Button;

    @iOSXCUITFindBy(accessibility = "Incoming call")
    private MobileElement bubble;

    //transfer
    @iOSXCUITFindBy(accessibility = "ContactsViewController_searchBar")
    private MobileElement find_Search ;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement call_Search ;



    //call
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_callButton")
    private MobileElement callButton ;




    @iOSXCUITFindBy(accessibility = "VoipActionSheet_voiceCall")
    private MobileElement voip ;


    public MobileElement getAccept() {
        return accept;
    }

    public MobileElement getMessage_Call() {
        return message_Call;
    }

    public MobileElement getAvatar() {
        return Avatar;
    }

    public MobileElement getName() {
        return name;
    }

    public MobileElement getEnable_disable_Mic() {
        return enable_disable_Mic;
    }

    public MobileElement getOutput() {
        return output;
    }

    public MobileElement getMore_Option() {
        return more_Option;
    }

    public MobileElement getPause() {
        return pause;
    }

    public MobileElement getConversation() {
        return conversation;
    }

    public MobileElement getLocation() {
        return location;
    }

    public MobileElement getEnd_Button() {
        return end_Button;
    }

    public MobileElement getTime_Spent() {
        return time_Spent;
    }

    public MobileElement getTransfer_Button() {
        return transfer_Button;
    }

    public MobileElement getBubble() {
        return bubble;
    }

    public MobileElement getFind_Search() {
        return find_Search;
    }

    public MobileElement getCall_Search() {
        return call_Search;
    }


    public MobileElement getVideoStreaming() {
        return videoStreaming;
    }

    public MobileElement getCallButton() {
        return callButton;
    }

    public MobileElement getVoip() {
        return voip;
    }


    public MobileElement getCancel() {
        return cancel;
    }


}
