package screen;

import android.screen.CallsScreen;
import framework.Branding;
import framework.Platforms;
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

public class VoipScreen extends STWScreen {


    //Accept Button
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 4)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]", priority = 5)
    @iOSXCUITFindBy(accessibility = "9 Voip hangUpButton", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"9 Voip hangUpButton\"]",priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"9 Voip hangUpButton\"`]",priority = 7)
    @iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == \"Accept\"`]" ,priority = 3)
    @iOSXCUITFindBy(accessibility = "Accept",priority = 6)
    @iOSXCUITFindBy(accessibility = "AcceptLiveCall",priority = 7)
    @AndroidFindBy(id = "accept_call_btn")
    @AndroidFindBy(id = "accept_call_waiting_image_btn",priority = 1)
    private MobileElement acceptCallButton;
    //full blue screen when start call before answer
    @AndroidFindBy(id = "message_call")
    @iOSXCUITFindBy(accessibility = "Calling")
    private MobileElement message_Call;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    @AndroidFindBy(id = "original_image_contact_call")
    private MobileElement avatar;
    @iOSXCUITFindBy(accessibility = "LiveCallView_userName")
    @AndroidFindBy(id = "name_contact")
    private MobileElement name;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_call_mute_btn",priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip MuteUnmuteLiveOption")
    @AndroidFindBy(id = "mute_btn")
    @iOSXCUITFindBy(accessibility = "OffMuteLiveCall",priority = 1)
    private MobileElement enablEdisableMic;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement contactCell;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "voip_call_speaker_btn",priority = 1)
    @iOSXCUITFindBy(accessibility = "9 Voip SpeakerLiveOption")
    @AndroidFindBy(id = "speaker_btn")
    @iOSXCUITFindBy(accessibility = "OffSpeakerLiveCall",priority = 1)
    private MobileElement output;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "more call options")
    @AndroidFindBy(id = "voip_more_options_btn")
    @AndroidFindBy(id = "voip_call_menu_btn",priority = 1)
    @iOSXCUITFindBy(accessibility = "MoreLiveCall", priority = 1)
    private MobileElement threeDots;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "LiveCallView_goToConversation")
    @AndroidFindBy(id = "go_to_conversation_btn")
    @iOSXCUITFindBy(accessibility = "Conversation",priority = 1)
    private MobileElement conversation;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "LiveCallView_geolocation")
    @AndroidFindBy(id = "voip_geolocation_image_button")
    @iOSXCUITFindBy(accessibility = "Location",priority = 1)
    private MobileElement location;
    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> threeDotsOptions;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "LiveCallView_broadcast_video")
    @AndroidFindBy(id = "view_voip_call_video_streaming")
    @iOSXCUITFindBy(accessibility = "Video Streaming",priority = 1)

    private MobileElement videoStreaming;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    @iOSXCUITFindBy(accessibility = "RefuseLiveCall",priority = 1)
    private MobileElement end_Button;
    @iOSXCUITFindBy(accessibility = "LiveCallView_timer")
    @AndroidFindBy(id = "message_call")
    private MobileElement time_Spent;
    @iOSXCUITFindBy(accessibility = "9 Voip transferIconBackground")
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement transfer_Button;

    public MobileElement getTransfer_Button() {
        return transfer_Button;
    }
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Outgoing call")
    @iOSXCUITFindBy(accessibility = "Outgoing calls",priority = 1)
    @AndroidFindBy(id = "message_voip_container")
    private MobileElement bubble;
    //transfer
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "search_contact",priority = 1)
    @AndroidFindBy(id = "bottom_search")
    @iOSXCUITFindBy(accessibility = "Search")
    private MobileElement search_Transfer;
    @iOSXCUITFindBy(accessibility = "ContactsViewController_searchBar")
    @AndroidFindBy(id = "contact_search_content")
    private MobileElement find_Search;
    @AndroidFindBy(id = "contact_item_name")
    private MobileElement result_Search;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "bottom_check")
    @AndroidFindBy(id = "multi_contact_fab",priority = 1)
    private MobileElement call_Search;
    //call
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_callButton")
    private MobileElement callButton;
    @iOSXCUITFindBy(accessibility = "VoipActionSheet_voiceCall")
    private MobileElement voip;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "LiveCallView_cancel")
    @iOSXCUITFindBy(accessibility = "Cancel", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cancel\"`]", priority = 2)
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Cancel\"", priority = 3)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]", priority = 4)

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSheet[`label == \"Please select an action\"`]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]", priority = 5)

    private MobileElement cancel;
    @iOSXCUITFindBy(accessibility = "pause call")
    private MobileElement pause;

    @iOSXCUITFindBy(accessibility = "Call")
    private MobileElement call;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][1]")
    private MobileElement search;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private List<MobileElement> firstContactCellToCall;

    public MobileElement getAcceptCallButton() {
        return acceptCallButton;
    }

    public MobileElement getMessage_Call() {
        return message_Call;
    }

    public MobileElement getAvatar() {
        return avatar;
    }

    public MobileElement getName() {
        return name;
    }

    public MobileElement getEnablEdisableMic() {
        return enablEdisableMic;
    }

    public MobileElement getOutput() {
        return output;
    }

    public MobileElement getConversation() {
        return conversation;
    }

    public MobileElement getLocation() {
        return location;
    }

    public MobileElement getVideoStreaming() {
        return videoStreaming;
    }

    public MobileElement getEnd_Button() {
        return end_Button;
    }

    public MobileElement getTime_Spent() {
        return time_Spent;
    }

    public MobileElement getBubble() {
        return bubble;
    }

    public MobileElement getSearch_Transfer() {
        return search_Transfer;
    }

    public MobileElement getFind_Search() {
        return find_Search;
    }

    public MobileElement getResult_Search() {
        return result_Search;
    }

    public MobileElement getCall_Search() {
        return call_Search;
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

    public MobileElement getPause() {
        return pause;
    }

    public VoipScreen(AppiumDriver driver) {

        super(driver);
    }


    public void searchContactAndCallVoip(String phoneToCall) throws InterruptedException, IOException {


        if (mPlatform.equals(Platforms.ANDROID)) {

            WebDriverWait wait = new WebDriverWait(mDriver, 10);
            ContactScreen ContactScreen = new ContactScreen(mDriver);
            ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

            ContactScreen.getSearchButton().click();


            ContactScreen.getSearchContent().sendKeys(phoneToCall);
            Thread.sleep(2000);
            ContactScreen.getSearchResult().click();
            if (Branding.TOTR.equals(branding)) {
                wait.until(ExpectedConditions.elementToBeClickable(ConversationScreen.getCallButton()));
                ConversationScreen.getCallButton().click();}

            waitForElementToBeClickable( ConversationScreen.getCall());
            ConversationScreen.getCall().click();
        } else {
            if (Branding.TOTR.equals(branding)) {

                ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            conversationScreen.SelectContactConversation(phoneToCall);
            callButton.click();
            voip.click();
        }else
            {
                ConversationScreen conversationScreen = new ConversationScreen(mDriver);

                conversationScreen.getPlusBtn().click();
                Thread.sleep(2000);
                call.click();
                Thread.sleep(2000);
                search.sendKeys(phoneToCall);
                Thread.sleep(3000);
                CallsScreen callsScreen = new CallsScreen(mDriver);
                callsScreen.hideKeyboardIos();
                firstContactCellToCall.size();
                firstContactCellToCall.get(0).click();
            }
        }
    }


    public void checkCallVoipScreenDeviceOne() throws InterruptedException, IOException {


        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(1000);
            CheckDisplayedOfElement(message_Call, "Go to message ");
            CheckDisplayedOfElement(avatar, " Avatar ");
            CheckDisplayedOfElement(name, " Name ");
            CheckDisplayedOfElement(enablEdisableMic, "Disable speaker ");
            CheckDisplayedOfElement(output, " output");
            CheckDisplayedOfElement(end_Button, " End Button ");
        } else {
            if (Branding.TOTR.equals(branding)) {
                CheckDisplayedOfElement(message_Call, "Go to message ");
                CheckDisplayedOfElement(avatar, "Avatar ");
                CheckDisplayedOfElement(name, "Name");
                CheckDisplayedOfElement(enablEdisableMic, "enabled and disable speaker");
                CheckDisplayedOfElement(output, "output button ");
                CheckDisplayedOfElement(end_Button, "End button ");
                threeDots.click();
                CheckDisplayedOfElement(conversation, "Go to conversation ");
                CheckDisplayedOfElement(location, "Go to location ");
                CheckDisplayedOfElement(videoStreaming, "video streaming ");
                cancel.click();
            } else {

               // CheckDisplayedOfElement(avatar, "Avatar");
                //CheckDisplayedOfElement(name, "Name");
                CheckDisplayedOfElement(enablEdisableMic, "enabled and disable speaker");
                CheckDisplayedOfElement(output, "output button ");
                CheckDisplayedOfElement(end_Button, "End button ");
                threeDots.click();
                CheckDisplayedOfElement(conversation, "Go to conversation ");
                CheckDisplayedOfElement(location, "Go to location ");
                //CheckDisplayedOfElement(videoStreaming, "video streaming ");
                waitForElementToBeClickable(cancel);
                cancel.click();


            }

        }
    }

    public void checkCallVoipScreenDeviceTwo() throws InterruptedException, IOException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            CheckDisplayedOfElement(avatar, "Avatar ");
            CheckDisplayedOfElement(name, "Name  ");
            if (Branding.TOTR.equals(branding)) {

            CheckDisplayedOfElement(enablEdisableMic, "Enabled and disabled speaker of second device ");
            CheckDisplayedOfElement(output, "output of second device");
            clickOnthreeDots();
            checkGoToConversationOptionIsDisplayed();
            checkGeolocationOptionIsDisplayed();
            checkBroadcastCallOptionIsDisplayed();
            mDriver.navigate().back();}
            CheckDisplayedOfElement(end_Button, "End Button of second device ");
            CheckDisplayedOfElement(acceptCallButton, "Accept button of second device");

        } else {
            //CheckDisplayedOfElement(avatar, "Avatar");
           // CheckDisplayedOfElement(name, "Name");
            CheckDisplayedOfElement(enablEdisableMic, "Enabled and disable speaker button");
             CheckDisplayedOfElement(output, "Output ");
            CheckDisplayedOfElement(end_Button, "End call button ");
            threeDots.click();
            CheckDisplayedOfElement(conversation, "Go to conversation ");
            CheckDisplayedOfElement(location, "Location");
            cancel.click();

        }

    }

    public void acceptVoipCall() {
        waitForElementToBeClickable(acceptCallButton);

        acceptCallButton.click();
    }


    public MobileElement getThreeDots() {
        return threeDots;
    }

    public List<MobileElement> getThreeDotsOptions() {
        return threeDotsOptions;
    }

    public void clickOnthreeDots() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(threeDots));

        getThreeDots().click();
    }

    public void checkBroadcastCallOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(0), "Video streaming is displayed");
    }

    public void checkGeolocationOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(1), "Geolocation ");
    }

    public void checkGoToConversationOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(1), "Go to conversation");
    }

    public void endVoipCall() {
        end_Button.click();
    }

    public void transferVoipCall(String phoneToTransfer) throws MalformedURLException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            transfer_Button.click();
            waitForElementToBeClickable(search_Transfer);
            search_Transfer.click();
            find_Search.sendKeys(phoneToTransfer);
            result_Search.click();
            call_Search.click();

        } else {
            transfer_Button.click();
            search_Transfer.click();
            search_Transfer.sendKeys(phoneToTransfer);
            tapOnElementCell(contactCell, 0.5, 0.42);


        }

    }
    public void checkThreeDotsOptionAfterCall() throws InterruptedException, IOException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(2000);
            clickOnthreeDots();
            checkGoToConversationOptionIsDisplayed();
            checkGeolocationOptionIsDisplayed();
            checkBroadcastCallOptionIsDisplayed();
            mDriver.navigate().back();
        }
    }


    public void checkScreenAfterLaunchCall() throws InterruptedException, IOException {
        //Thread.sleep(3000);
        CheckDisplayedOfElement(time_Spent, "Time spent of second device ");
        CheckDisplayedOfElement(transfer_Button, "Transfer button of second device ");
    }

    public void checkBubbleIsDisplayed() throws InterruptedException, IOException {
        if (Branding.TOTR.equals(branding)) {

            Thread.sleep(5000);
            CheckDisplayedOfElement(bubble, "Bubble of first device ");
        }
    }


}






