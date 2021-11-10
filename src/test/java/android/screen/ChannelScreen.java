package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.io.IOException;

public class ChannelScreen extends STWScreen {

    //Channel Main screen
    @AndroidFindBy(id = "view_switch_left_container")
    private MobileElement AllChannel;
    @AndroidFindBy(id = "view_switch_right_container")
    private MobileElement RecentChannel;
    @AndroidFindBy(id = "channel_bottom_bar_search")
    private MobileElement SearchChannel;
    @AndroidFindBy(id = "mcptt_walkie_talkie_push_image_button")
    private MobileElement PTTBtnMainScreen;
    @AndroidFindBy(id = "channel_item_name")
    private MobileElement channel_item_name;
    @AndroidFindBy(id = "channel_item_priority")
    private MobileElement channel_item_priority;
    @AndroidFindBy(id = "contact_search_back")
    private MobileElement channel_search_back;


    //Channel PTT screen
    @AndroidFindBy(id = "channel_speaker_btn")
    private MobileElement SpeakerBtn;
    @AndroidFindBy(id = "walkie_talkie_push_image_button")
    private MobileElement PTTChannelBtn;
    @AndroidFindBy(id = "channel_video_streaming_image_button")
    private MobileElement ChannelVideoStream;
    @AndroidFindBy(id = "channel_contact_details_btn")
    private MobileElement ChannelDetails;
    @AndroidFindBy(id = "fragment_walkie_talkie_contact_detail_ok_btn")
    private MobileElement OkDetailsChannel;

    //connected channel PTT screen
    @AndroidFindBy(id = "channel_geolocation_image_button")
    private MobileElement ChannelGeolocation;
    @AndroidFindBy(id = "channel_back_btn")
    private MobileElement ChannelBackBtn;
    @AndroidFindBy(id = "channel_toggle_btn")
    private MobileElement DisconnetChannelBtn;
    @AndroidFindBy(id = "channel_item_toggle_btn")
    private MobileElement Toggle_BTN_Main_Screen;
    @AndroidFindBy(id = "searchButtonChannel")
    private MobileElement searchButtonChannel;
    @AndroidFindBy(id = "channel_item_number_contact_connected")
    private MobileElement number_contact_connected;
    //channel screen details
    @AndroidFindBy(id = "channel_contact_detail_action_bar_title")
    private MobileElement ChannelNameDetails;
    @AndroidFindBy(id = "channel_contact_detail_action_bar_priority")
    private MobileElement ChannelPriorityDetails;
    @AndroidFindBy(id = "channel_contact_detail_action_bar_icon")
    private MobileElement ChannelIconDetails;
    @AndroidFindBy(id = "channel_contact_detail_action_bar_switch")
    private MobileElement ChannelDetailsSwitchBtn;
    @AndroidFindBy(id = "Navigate up")
    private MobileElement BackBTN;

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
    public MobileElement getAllChannel() {
        return AllChannel;
    }

    public MobileElement getRecentChannel() {
        return RecentChannel;
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

    public MobileElement getChannelVideoStream() {
        return ChannelVideoStream;
    }

    public MobileElement getChannelDetails() {
        return ChannelDetails;
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

    public void CheckChannelMainScreen() throws IOException, InterruptedException {
        ChannelScreen ChannelScreen= new ChannelScreen ( mDriver);
        ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getAllChannel(),"All channel ");
        ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getRecentChannel(),"Recent channel  ");
        ChannelScreen.CheckDisplayedOfElement(ChannelScreen.getSearchChannel(),"Search channel ");
    }

    public void CheckChannelElement() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannel_item_name() ,"channel name");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannel_item_priority() ,"channel priority");
        channelScreen.CheckDisplayedOfElement(channelScreen.getToggle_BTN_Main_Screen(),"Toggle_BTN_Main_Screen");
    }

    public void CheckChannelPTTScreen() throws IOException, InterruptedException {
        ChannelScreen channelScreen= new ChannelScreen ( mDriver);
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelIconDetails(),"channel icon");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelNameDetails(),"channel name");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelPriorityDetails(),"channel priority");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelGeolocation(),"Geolocation");
        channelScreen.CheckDisplayedOfElement(channelScreen.getChannelVideoStream(),"VideoStream");
    }

}
