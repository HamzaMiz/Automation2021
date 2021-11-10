package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

public class ChannelScreen extends STWScreen {
    public ChannelScreen(AppiumDriver driver) {
        super(driver);
    }

    //List view main screen channel
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]")
    private MobileElement SearchChannel;
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
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_videoStreaming")
    private MobileElement ChannelVideoStream;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_moreButton")
    private MobileElement ChannelMoreBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_geoLocButton")
    private MobileElement ChannelGeolocBtn;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_hideButton")
    private MobileElement ChannelHideView;
    @iOSXCUITFindBy(accessibility = "ChannelPushToTalkView_channelSwitch")
    private MobileElement ChannelSwitchOnOff;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_0")
    private MobileElement AllChannel;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_1")
    private MobileElement RecentChannel;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_0")
    private MobileElement AllChannelListView;
    @iOSXCUITFindBy(accessibility = "ExtendableListView_0_1")
    private MobileElement RecentChannelListView;
    @iOSXCUITFindBy(accessibility = "MCPTTListViewController_ChannelCell_0_0")
    private MobileElement ChannelDetails;
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

  //  public void clickOnSearchResult() { searchContactResult.click(); }

   // public MobileElement getResultsearchContact(){
   //     return ResultsearchContact;
  //  }


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
}
