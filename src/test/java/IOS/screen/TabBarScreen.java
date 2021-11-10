package IOS.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

public class TabBarScreen extends STWScreen {
    public TabBarScreen(AppiumDriver driver) {
        super(driver);

    }

    @iOSXCUITFindBy(accessibility = "AppDelegate.conversationItem")
    private MobileElement chatsItem;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'AppDelegate')]")
    private List<MobileElement> TabBarChild;
    @iOSXCUITFindBy(accessibility = "AppDelegate.contactsItem")
    private MobileElement contactsItem;
    @iOSXCUITFindBy(accessibility = "AppDelegate.channelItem")
    private MobileElement channelsItem;
    @iOSXCUITFindBy(accessibility = "AppDelegate_myBusinessItem")
    private MobileElement mybusinessItem;
    @iOSXCUITFindBy(accessibility = "AppDelegate.myRulesItem")
    private MobileElement myRulesItem;
    @iOSXCUITFindBy(accessibility = "AppDelegate.moreItem")
    private MobileElement moreItem;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Planning\"]")
    private MobileElement schedulingItem;






    public MobileElement getContactsItem() {
        return contactsItem;
    }

    public MobileElement getChannelsItem() {
        return channelsItem;
    }

    public MobileElement getMybusinessItem() {
        return mybusinessItem;
    }

    public MobileElement getMyRulesItem() {
        return myRulesItem;
    }

    public MobileElement getMoreItem() {
        return moreItem;
    }

    public List<MobileElement> getTabBarChild() {
        return TabBarChild;
    }

    public MobileElement getChatsItem() {
        return chatsItem;
    }

    public MobileElement getSchedulingItem() { return schedulingItem; }
    public void clickOnContactsButton() {
        contactsItem.click();

    }

    public void checkItemPositionInTabbar(int index, String Selector) {

        if (isElementDisplayed(getMybusinessItem())) {
            Boolean iselementpresent = getTabBarChild().get(index).getAttribute("label").equalsIgnoreCase(  Selector );
            Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen." );
        }
    }

    public  void goToMyBusiness()  {
        getMybusinessItem().click();


    }

    public  void goToMore() throws InterruptedException {
        Thread.sleep(1000);
        getMoreItem().click();

    }

    public  void goToContacts() throws InterruptedException {
        Thread.sleep(1000);
        getContactsItem().click();

    }

    public  void goTochats() throws InterruptedException {
        Thread.sleep(1000);
        getChatsItem().click();

    }

    public  void goToChannels() throws InterruptedException {
        Thread.sleep(1000);
        getChannelsItem().click();

    }

    public  void goToMyRules() throws InterruptedException {
        Thread.sleep(1000);
        getMyRulesItem().click();

    }

    public  void goToScheduling() throws InterruptedException {
        Thread.sleep(1000);
        getSchedulingItem().click();

    }


}
