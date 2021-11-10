package screen;

import com.aventstack.extentreports.Status;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screen.settings.SettingsMoreScreen;
import screen.settings.SettingsScreen;
import screen.settings.VoiceSettingsScreen;

import java.io.IOException;

public class ChannelScreen extends STWScreen {


    //Channel Main screen
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All channels']")
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_0")
    private MobileElement AllChannel;


    @AndroidFindBy(id = "view_switch_right_container")
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_1")
    private MobileElement RecentChannel;
    @AndroidFindBy(id = "channel_bottom_bar_search")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]")
    private MobileElement SearchChannel;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "mcptt_walkie_talkie_push_image_button")
    @iOSXCUITFindBy(accessibility="ActivatedChannelViewCell_pushToTalkButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ActivatedChannelViewCell_pushToTalkButton\"`]",priority = 1)
    private MobileElement PTTBtnMainScreen;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "channel_item_name")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"MCPTTListViewController_ChannelCell_0_0\"])[1]",priority = 0)
    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_channelActive",priority = 1)
    private MobileElement channel_item_name;
    @AndroidFindBy(id = "channel_item_priority")
    private MobileElement channel_item_priority;
    @AndroidFindBy(id = "contact_search_back")
    private MobileElement channel_search_back;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_okButton")
    private MobileElement YesBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_cancelButton")
    private MobileElement NoBtn;

    //Channel PTT screen
    @AndroidFindBy(id = "channel_speaker_btn")
    @iOSXCUITFindBy(accessibility="ChannelPushToTalkView_speackerBtn")
    private MobileElement SpeakerBtn;
    @AndroidFindBy(id = "walkie_talkie_push_image_button")
    @iOSXCUITFindBy(accessibility="ChannelPushToTalkView_pushToTalkButton")
    private MobileElement PTTChannelBtn;
    @AndroidFindBy(id = "channel_video_streaming_image_button")
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_videoStreaming")
    private MobileElement ChannelVideoStream;
    @AndroidFindBy(id = "channel_contact_details_btn")
    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_ChannelCell_0_0")
    private MobileElement ChannelDetails;
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_ok_btn")
    private MobileElement OkDetailsChannel;

    //connected channel PTT screen
    @AndroidFindBy(id = "channel_geolocation_image_button")
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_geoLocButton")
    private MobileElement ChannelGeolocation;
    @AndroidFindBy(id = "channel_back_btn")
    private MobileElement ChannelBackBtn;
    @AndroidFindBy(id = "channel_toggle_btn")
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_channelSwitch")
    private MobileElement DisconnetChannelBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE, androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "channel_item_toggle_btn")
    @iOSXCUITFindBy(accessibility = "ActivatedChannelViewCell_channelSwitch")
    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_channelSwitch")
    @iOSXCUITFindBy(xpath="XCUIElementTypeOther[@name=\"MCPTTListViewController_channelSwitch\"]",priority=1)
    private MobileElement Toggle_BTN_Main_Screen;
    @AndroidFindBy(id = "searchButtonChannel")
    private MobileElement searchButtonChannel;
    @AndroidFindBy(id = "channel_item_number_contact_connected")

    private MobileElement number_contact_connected;
    //channel screen details
    @AndroidFindBy(id = "voip_contact_name")
    private MobileElement ChannelNameDetails;
    @AndroidFindBy(id = "channel_contact_detail_action_bar_priority")
    private MobileElement ChannelPriorityDetails;
    @AndroidFindBy(id = "view_voip_contact_image")
    @iOSXCUITFindBy(accessibility="ChannelPushToTalkView_detailsButton")
    private MobileElement ChannelIconDetails;
    @AndroidFindBy(id = "channel_contact_detail_action_bar_switch")
    @iOSXCUITFindBy(accessibility="MCPTTDetailsViewController_voipSwitch")
    private MobileElement ChannelDetailsSwitchBtn;
    @HowToUseLocators( androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "Navigate up")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",priority = 1)
    private MobileElement BackBTN;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox")
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_dontAskMeAgainButton")
    private MobileElement DontAskAgain;
    //channel Call screen
    @AndroidFindBy(id = "channel_back_btn")
    private MobileElement ChannelBackBTN;


    public MobileElement getOkDetailsChannel() {
        return OkDetailsChannel;
    }

    public MobileElement getToggle_BTN_Main_Screen() {
        return Toggle_BTN_Main_Screen;
    }

    //disconnected channel screen Details
    @AndroidFindBy(id = "channel_contact_detail_action_bar_switch")
    private MobileElement SwitchBtnChannel;


    @AndroidFindBy(id = "contact_search_content")
    private MobileElement ChannelSearchContent;
    @AndroidFindBy(id = "channel_item_icon")
    private MobileElement serachResultChannel;

    public ChannelScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getChannelSearchContent() {
        return ChannelSearchContent;
    }
    public MobileElement getSerachResultChannel(){
        return searchButtonChannel;
    }

    public MobileElement getSearchChannel() {
        return SearchChannel;
    }

    public MobileElement getPTTBtnMainScreen() {
        return PTTBtnMainScreen;
    }

    public MobileElement getSpeakerBtn() {
        return SpeakerBtn;
    }

    public MobileElement getPTTChannelBtn() {
        return PTTChannelBtn;
    }


    public MobileElement getChannelGeolocation() {
        return ChannelGeolocation;
    }

    public MobileElement getChannelBackBtn() {
        return ChannelBackBtn;
    }

    public MobileElement getDisconnetChannelBtn() {
        return DisconnetChannelBtn;
    }

    public MobileElement getSwitchBtnChannel() {
        return SwitchBtnChannel;
    }

    public MobileElement getSearchButtonChannel() {
        return getSearchChannel();
    }

    public MobileElement getChannel_item_name(){
        return channel_item_name;
    }

    public MobileElement getChannel_item_priority(){
        return channel_item_priority;
    }

    public MobileElement getChannel_search_back(){
        return channel_search_back;
    }


    public MobileElement getBackBTN(){
        return BackBTN;
    }

    public MobileElement getChannelDetailsSwitchBtn(){
        return ChannelDetailsSwitchBtn;
    }

    public MobileElement getChannelIconDetails(){
        return ChannelIconDetails;
    }

    public MobileElement getChannelPriorityDetails(){
        return ChannelPriorityDetails;
    }

    public MobileElement getChannelNameDetails(){
        return ChannelNameDetails;
    }

    public MobileElement getChannelBackBTN(){
        return ChannelBackBTN;
    }

    public MobileElement getNumber_contact_connected(){
        return number_contact_connected;
    }


    //List view main screen channel

    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_titleButton")
    private MobileElement ListChannelView;
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label")
    private MobileElement ChannelTitleDetails;
    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_channelActive")
    private MobileElement ChannelTitleMain;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_pushToTalkButton")
    private MobileElement ChannelPTTBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_speackerBtn")
    private MobileElement ChannelSpeakerBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_detailsButton")
    private MobileElement ChannelDetailsBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_moreButton")
    private MobileElement ChannelMoreBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_geoLocButton")
    private MobileElement ChannelGeolocBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_hideButton")
    private MobileElement ChannelHideView;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_channelSwitch")
    private MobileElement ChannelSwitchOnOff;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_0")
    private MobileElement AllChannelListView;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_1")
    private MobileElement RecentChannelListView;
    @iOSXCUITFindBy(accessibility = "MCPTTDetailsViewController_voipSwitch")
    private MobileElement ChannelDetailsBtnOn;
    @FindBy(name = "MCPTTListViewController_channelSwitch")
    private MobileElement ChannelActivateButton;
    @FindBy(name = "MCPTTListViewController_channelInactive")
    private MobileElement ChannelNameLabel;
    @FindBy(name = "ActivatedChannelViewCell_channelSwitch")
    private MobileElement OnOffChannelMainButton;
    @FindBy(name = "ActivatedChannelViewCell_pushToTalkButton")
    private MobileElement PushToTalkButtonMain;
    @FindBy(name = "Back")
    private MobileElement BackBtn;


    public void enterTheChannelToSearch(String groupToCall) { SearchChannel.sendKeys(groupToCall); }

     // public void clickOnSearchResult() { searchContactResult.click(); }

     //public MobileElement getResultsearchContact(){
         //return ResultsearchContact;
     // }


    public MobileElement getSearchChannel(String groupToCall) {
        return SearchChannel;
    }

    public MobileElement getListChannelView(){
        return ListChannelView;
    }

    public MobileElement getAllChannelListView(){
        return AllChannelListView;
    }

    public MobileElement getRecentChannelListView(){
        return RecentChannelListView;
    }

    public MobileElement getChannelActivateButton(){
        return ChannelActivateButton;
    }

    public MobileElement getChannelNameLabel(){
        return ChannelNameLabel;
    }

    public MobileElement getOnOffChannelMainButton(){
        return OnOffChannelMainButton;
    }

    public MobileElement getPushToTalkButtonMain(){
        return PushToTalkButtonMain;
    }

    public MobileElement getAllChannel(){
        return AllChannel;
    }

    public MobileElement getRecentChannel(){
        return RecentChannel;
    }

    public MobileElement getChannelDetails(){
        return ChannelDetails;
    }

    public MobileElement getChannelDetailsBtnOn(){
        return ChannelDetailsBtnOn;
    }

    public MobileElement getChannelTitleDetails(){
        return ChannelTitleDetails;
    }

    public MobileElement getBackBtn(){
        return BackBtn;
    }

    public MobileElement getChannelTitleMain(){
        return ChannelTitleMain;
    }

    public MobileElement getChannelSwitchOnOff(){
        return ChannelSwitchOnOff;
    }

    public MobileElement getChannelHideView(){
        return ChannelHideView;
    }

    public MobileElement getChannelGeolocBtn(){
        return ChannelGeolocBtn;
    }

    public MobileElement getChannelMoreBtn(){
        return ChannelMoreBtn;
    }

    public MobileElement getChannelVideoStream(){
        return ChannelVideoStream;
    }

    public MobileElement getChannelDetailsBtn(){
        return ChannelDetailsBtn;
    }

    public MobileElement getChannelSpeakerBtn(){
        return ChannelSpeakerBtn;
    }

    public MobileElement getChannelPTTBtn(){
        return ChannelPTTBtn;
    }

    public void CheckChannelMainScreen() throws IOException, InterruptedException {
        ChannelScreen ChannelScreen= new ChannelScreen( mDriver);

        if (Platforms.ANDROID.equals(mPlatform)){
            mLogger.log(Status.PASS, "3 - A  checks the tab components");
            ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getAllChannel(),"All channel ");
        ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getRecentChannel(),"Recent channel  ");
        ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getSearchChannel(),"Search channel ");
        ChannelScreen.getAllChannel().click();
        ChannelScreen.getRecentChannel().click();
        }
        else {
            ChannelScreen.scrollDown(1,1);
            mLogger.log(Status.PASS, "3 - A  checks the tab components");
            ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getSearchChannel(),"Search channel ");
            ChannelScreen.getListChannelView().click();
            ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getAllChannel(),"All channel is displayed");
            ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getRecentChannel(),"Recent channel is displayed");
            ChannelScreen.getRecentChannel().click();
            Thread.sleep(1000);
            ChannelScreen.getListChannelView().click();
            Thread.sleep(1000);
            ChannelScreen.getAllChannel().click();
            Thread.sleep(3000);
        } }

    public void CheckChannelElement() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){

            channelScreen.CheckDisplayedOfElement(channelScreen.getChannel_item_name() ,"channel name");
            //channelScreen.CheckDisplayedOfElement(channelScreen.getChannel_item_priority() ,"channel priority");
        channelScreen.CheckDisplayedOfElement(channelScreen.getToggle_BTN_Main_Screen(),"Toggle_BTN_Main_Screen");
        }
    else {
            //channelScreen.CheckDisplayedOfElement(channelScreen.getChannelActivateButton(),"Activate button");
            //Thread.sleep(3000);
            //channelScreen.CheckDisplayedOfElement(channelScreen.getChannelNameLabel() ,"channel name");
            Thread.sleep(3000);

        }
    }

    public void returnToMainScreenFromvoiceSettings() throws InterruptedException {
        if(mPlatform.equals(Platforms.ANDROID)){
            getBackBTN().click();
            Thread.sleep(500);
            getBackBTN().click();
            Thread.sleep(500);


        }
        if(mPlatform.equals(Platforms.IOS)){
            back();
            back();
        }
    }


    public void GoToAllChannel() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){
            channelScreen.getAllChannel().click();
        }
        else {
            channelScreen.scrollDown(1,1);
            channelScreen.getListChannelView().click();
            channelScreen.getAllChannel().click();
            Thread.sleep(3000);
        }
    }

    public void OpenChannelFromDetails() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){
            channelScreen.getChannelDetailsSwitchBtn().click();
            Thread.sleep(3000);
            channelScreen.getChannelBackBtn().click();
            Thread.sleep(3000);
            channelScreen.back();
            Thread.sleep(3000);
            channelScreen.getChannel_item_name().click();
            Thread.sleep(3000);
        }
        else {
            Thread.sleep(5000);
            channelScreen.getChannelDetailsSwitchBtn().click();
            Thread.sleep(3000);
            channelScreen.back();
            Thread.sleep(3000);
            channelScreen.getChannel_item_name().click();
        }
    }

    public void OpenChannelFromMain() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        if (Platforms.ANDROID.equals(mPlatform)){
            channelScreen.getToggle_BTN_Main_Screen().click();
        }
        else {
            channelScreen.getChannelActivateButton().click();
        }
    }
    public void CheckChannelPTTScreen() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen( mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelIconDetails(),"channel icon");
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelNameDetails(),"channel name");
        Thread.sleep(3000);
        //channelScreen.CheckDisplayedOfElement(channelScreen.getChannelPriorityDetails(),"channel priority");
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelGeolocation(),"Geolocation");
        Thread.sleep(3000);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelVideoStream(),"VideoStream");
        Thread.sleep(3000);
        Thread.sleep(3000);
        }
        else{
            channelScreen.CheckDisplayedOfElement(channelScreen.getChannelIconDetails(),"channel icon");
            Thread.sleep(3000);
            channelScreen.CheckDisplayedOfElement(channelScreen.getChannelGeolocation(),"Geolocation");
            Thread.sleep(3000);
            channelScreen.CheckDisplayedOfElement(channelScreen.getChannelVideoStream(),"VideoStream");
            Thread.sleep(3000);
        }
    }
    public void ClickOnAllChannel() throws InterruptedException, IOException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
            channelScreen.getAllChannel().click();
        }
else{
            channelScreen.getListChannelView().click();
            channelScreen.getAllChannel().click();
        }

    }

    public void CloseMainChannel() throws InterruptedException, IOException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        channelScreen.getToggle_BTN_Main_Screen().click();
        Thread.sleep(5000);

        if (isElementDisplayed(channelScreen.getYesBtn())) {

            channelScreen.getYesBtn().click();

            }
    }
    public void denyCloseMainChannel() throws InterruptedException, IOException {
        if(Platforms.ANDROID.equals(mPlatform)) {
            ChannelScreen channelScreen = new ChannelScreen(mDriver);
            Thread.sleep(5000);

            if (isElementDisplayed(channelScreen.getYesBtn())) {
                channelScreen.getNoBtn().click();

            }
        }
    }
    public void GoToPTTFloorMode() throws InterruptedException, IOException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        SettingsScreen settingsScreen = new SettingsScreen (mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        VoiceSettingsScreen VoiceSettingsScreen = new VoiceSettingsScreen (mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
            channelScreen.getAllChannel().click();
        }
        else{
            channelScreen.getListChannelView().click();
            channelScreen.getAllChannel().click();
        }

    }

    public void CloseDetailsChannel() throws InterruptedException, IOException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        Thread.sleep(3000);
        channelScreen.getChannelDetailsSwitchBtn().click();
        Thread.sleep(5000);

        if (isElementDisplayed(channelScreen.getYesBtn())) {
            channelScreen.getDontAskAgain();
            channelScreen.getYesBtn().click();

        }
    }
    public void ClosePTTScreenChannel() throws InterruptedException, IOException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        channelScreen.getDisconnetChannelBtn().click();
        Thread.sleep(5000);

        if (isElementDisplayed(channelScreen.getYesBtn())) {
            channelScreen.getDontAskAgain();
            channelScreen.getYesBtn().click();

        }
    }
    public void doSearchTalkgroup(String groupToCall) throws InterruptedException, IOException {
        ChannelScreen channelScreen = new ChannelScreen(mDriver);
        if(Platforms.ANDROID.equals(mPlatform)) {
        mLogger.log(Status.PASS, "1 - Go to  channel tab");
        WebDriverWait wait = new WebDriverWait(mDriver, 180);
        wait.until(ExpectedConditions.visibilityOf(channelScreen.getAllChannel()));
        channelScreen.getAllChannel().click();
        mLogger.log(Status.PASS, "2 - Go to  all channel");
        channelScreen.getSearchButtonChannel().click();
        mLogger.log(Status.PASS, "3 - Click on search button channel");
        channelScreen.getChannelSearchContent().sendKeys(groupToCall);
        mLogger.log(Status.PASS, "3 - Enter the name of the channel to be searched");
        //channelScreen.getChannelSearchContent().click();
        mLogger.log(Status.PASS, "4 -Click on the search result ");
        hideKeyboard();
        }
        else
            {
                channelScreen.scrollDown(1,1);
                Thread.sleep(3000);
                channelScreen.enterTheChannelToSearch(groupToCall);
                Thread.sleep(3000);
            }}

    public MobileElement getNoBtn(){
        return NoBtn;
    }

    public MobileElement getYesBtn(){
        return YesBtn;
    }

    public MobileElement getDontAskAgain(){
        return DontAskAgain;
    }
}
