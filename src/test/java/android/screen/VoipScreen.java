package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class VoipScreen extends STWScreen {

    public VoipScreen(AppiumDriver driver) {
        super(driver);
    }


    //Accept Button
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hold & Accept\"]\n", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accept\"]", priority = 2)
    @iOSXCUITFindBy(accessibility = "Accept")
    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement accept;

    public MobileElement getAccept() {
        return accept;
    }


    //full blue screen when start call before answer
    @AndroidFindBy(id = "message_call")
    private MobileElement message_Call;

    @AndroidFindBy(id = "original_image_contact_call")
    private MobileElement Avatar;

    @AndroidFindBy(id = "name_contact")
    private MobileElement name;

    @AndroidFindBy(id = "mute_btn")
    private MobileElement enable_disable_Mic;

    @AndroidFindBy(id = "speaker_btn")
    private MobileElement output;

    @AndroidFindBy(id = "voip_more_options_btn")
    private MobileElement threeDots;

    @AndroidFindBy(id = "go_to_conversation_btn")
    private MobileElement conversation;

    @AndroidFindBy(id = "voip_geolocation_image_button")
    private MobileElement location;

    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> threeDotsOptions;

    @iOSXCUITFindBy(accessibility = "9 Voip videoStreamingButton")
    @AndroidFindBy(id = "view_voip_call_video_streaming")
    private MobileElement videoStreaming;
    @iOSXCUITFindBy(accessibility = "9 Voip hangOutButton")
    @AndroidFindBy(id = "reject_call_btn")
    private MobileElement end_Button;

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


    //full blue screen when start call after answer

    @AndroidFindBy(id = "message_call")
    private MobileElement time_Spent;

    @AndroidFindBy(id = "accept_call_btn")
    private MobileElement transfer_Button;

   // @AndroidFindBy(id = "message_voip_text_content")
    @AndroidFindBy(id = "message_voip_container")
    private MobileElement bubble;

    public MobileElement getTime_Spent() {
        return time_Spent;
    }

    public MobileElement getTransfer_Button() {
        return transfer_Button;
    }

    public MobileElement getBubble() {
        return bubble;
    }

    //transfer
    @AndroidFindBy(id = "bottom_search")
    private MobileElement search_Transfer;

    @AndroidFindBy(id = "contact_search_content")
    private MobileElement find_Search;

    @AndroidFindBy(id = "contact_item_name")
    private MobileElement result_Search;

    @AndroidFindBy(id = "bottom_check")
    private MobileElement call_Search;

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


    public void searchContactAndCallVoip(String phoneToCall) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 10);

        ContactScreen ContactScreen = new ContactScreen(mDriver);

        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        ContactScreen.getSearchButton().click();
        ContactScreen.getSearchContent().sendKeys(phoneToCall);
        Thread.sleep(2000);
        ContactScreen.getSearchResult().click();
        wait.until(ExpectedConditions.visibilityOf(ConversationScreen.getCallButton()));
        ConversationScreen.getCallButton().click();
        ConversationScreen.getCall().click();

    }

    public void acceptVoipCallFromSecondDevice() {

      getAccept().click();
    }

    public void acceptVoipCallFromThirdDevice() {
        getAccept().click();
    }

    public MobileElement getThreeDots() {
        return threeDots;
    }

    public List<MobileElement> getThreeDotsOptions() {
        return threeDotsOptions;
    }

    public void clickOnthreeDots() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf( threeDots));

        getThreeDots().click();
    }

    public void checkBroadcastCallOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(0),"Video streaming is displayed");
    }

    public void checkGeolocationOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(1),"Geolocation is displayed");
    }
    public void checkGoToConversationOptionIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(threeDotsOptions.get(1),"Go to conversation is displayed");
    }


    public void endVoipCallFromSeconDevice() {
        getEnd_Button().click();
    }

    public void transferVoipCall( String phoneToTransfer) {
        getTransfer_Button().click();
        getSearch_Transfer().click();
        getFind_Search().sendKeys(phoneToTransfer);
            getResult_Search().click();
            getCall_Search().click();

    }

}
