package screen;

import screen.myBusiness.MyBusinessScreen;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TabBarScreen extends STWScreen {


    String Parent = "android.widget.HorizontalScrollView";
    String child = "android.widget.LinearLayout";


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Messaging']")
    @iOSXCUITFindBy(accessibility = "AppDelegate.conversationItem")
    private MobileElement chatsItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'AppDelegate')]")
    private List<MobileElement> TabBarChild;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Contacts']")
    @iOSXCUITFindBy(accessibility = "AppDelegate.contactsItem")
    private MobileElement contactsItem;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Talk groups']")
    @iOSXCUITFindBy(accessibility = "AppDelegate.channelItem")
    private MobileElement channelsItem;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='My Mission']")
    @iOSXCUITFindBy(accessibility = "AppDelegate_myBusinessItem")
    private MobileElement mybusinessItem;
    @iOSXCUITFindBy(accessibility = "AppDelegate.myRulesItem")
    private MobileElement myRulesItem;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='More']")
    @iOSXCUITFindBy(accessibility = "AppDelegate.moreItem")
    private MobileElement moreItem;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Planning\"]")
    private MobileElement schedulingItem;

    public TabBarScreen(AppiumDriver driver) {
        super(driver);
    }

    public void goToContacts() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (Branding.TOTR.equals(branding)){
                Thread.sleep(1000);

                ToClickFromChildClassbyXpath(Parent, child, 0);}
            else
                contactsItem.click();

        } else {
            waitForElementToBeClickable(contactsItem);
            contactsItem.click();
        }
    }


    public void goToChats() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            if (Branding.TOTR.equals(branding)){
                Thread.sleep(1000);

            ToClickFromChildClassbyXpath(Parent, child, 1);}
            else
                chatsItem.click();

        } else {
            Thread.sleep(1000);
            waitForElementToBeClickable(chatsItem);
            chatsItem.click();
        }
    }


    public void goToChannels() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            if (Branding.TOTR.equals(branding))
            {
                Thread.sleep(1000);

                ToClickFromChildClassbyXpath(Parent, child, 2);}
            else channelsItem.click();

        } else {
            Thread.sleep(1000);
            waitForElementToBeClickable(channelsItem);
            channelsItem.click();
        }

    }


    public void goToMore() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            WebDriverWait wait = new WebDriverWait(mDriver, 20);
            if (Branding.TOTR.equals(branding)) {
                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tab_icon")));

                ToClickFromChildClassbyXpath(Parent, child, 4);
            } else moreItem.click();

        } else {
            Thread.sleep(1000);
            waitForElementToBeClickable(moreItem);
            moreItem.click();
        }

    }

    public void checkItemPositionInTabbar(int index, String Selector) {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

                if (mPlatform.equals(Platforms.ANDROID)) {
                    Boolean iselementpresent = myBusinessScreen.getActivityItem().isDisplayed();
                    Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen." );

                        } else {
                    if (isElementDisplayed(mybusinessItem)) {
                        Boolean iselementpresent = TabBarChild.get(index).getAttribute("label").equalsIgnoreCase(Selector);
                        Assert.assertTrue(iselementpresent, "Targeted element App is not present on screen.");
                    }
                        }

    }


    public void goToMyRules() throws InterruptedException {
        Thread.sleep(1000);
        myRulesItem.click();
    }

    public void goToScheduling() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            ToClickFromChildClassbyXpath(Parent, child, 0);
        } else {
            Thread.sleep(1000);
            schedulingItem.click();
        }
    }

    public void goToMyBusiness() {
        if (mPlatform.equals(Platforms.ANDROID)) {
            WebDriverWait wait = new WebDriverWait(mDriver, 20);
            if (Branding.TOTR.equals(branding)) {

                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tab_icon")));

                ToClickFromChildClassbyXpath(Parent, child, 3);
            } else mybusinessItem.click();

        } else {
            mybusinessItem.click();
        }

    }

    public String getParent() {
        return Parent;
    }

    public String getChild() {
        return child;
    }

    public MobileElement getChatsItem() {
        return chatsItem;
    }

    public List<MobileElement> getTabBarChild() {
        return TabBarChild;
    }

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

    public MobileElement getSchedulingItem() {
        return schedulingItem;
    }
}