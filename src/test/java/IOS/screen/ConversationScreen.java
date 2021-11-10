package IOS.screen;

import android.screen.GeolocationScreen;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConversationScreen extends STWScreen {
    public ConversationScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(id = "GeofenceLocationTrackingOn")
    private MobileElement geolocation;
    @iOSXCUITFindBy(accessibility = "STWComposerInputView_textView")
    private MobileElement inputOfSendMessage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ConversationListViewController_conversationCell_0\"]/XCUIElementTypeButton[2]")
    private MobileElement conversationPreview;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonDeletes\"])[2]")
    private MobileElement deleteConversation;
    @iOSXCUITFindBy(id = "CustomAlertView_ok")
    private MobileElement confirmDelete;
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label")
    private MobileElement titleOfConversation;

    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_wayButton")
    @AndroidFindBy(id = "action_geolocation_button")
    private MobileElement gelocationButton;

    public MobileElement getConversationPreview() {
        return conversationPreview;
    }

    public MobileElement getTitleOfConversation() {
        return titleOfConversation;
    }

    public void clickOnGeolocation(AppiumDriver mDriver, int x, int y) {
        (new TouchAction(mDriver)).tap(PointOption.point(x, y)).perform();


    }

    @iOSXCUITFindBy(accessibility = "STWComposerView_sendButton")
    private MobileElement sendButton;
    @iOSXCUITFindBy(accessibility = "GroupContactListViewController_leaveGroupButton")
    private MobileElement leaveConversationButton;

    public MobileElement getGeolocation() {
        return geolocation;
    }


    public void writeMessage(String message) {
        inputOfSendMessage.sendKeys(message);
    }

    public void sendMessage() {
        sendButton.click();

    }

    public void deleteConversation() {
        deleteConversation.click();

    }

    public void confirmDelete() {
        confirmDelete.click();
    }

    public void openConversation() {

        conversationPreview.click();
    }

    public MobileElement getLeaveConversationButton() {
        return leaveConversationButton;
    }

    public void clickOnTileOfConversation() {

        titleOfConversation.click();
    }

    public void clickOnLeaveConversationButton() {

        leaveConversationButton.click();
    }

    public void clickOnGeolocationIcon() {
        android.screen.GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver);

        WebDriverWait wait = new WebDriverWait(mDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(gelocationButton));

        gelocationButton.click();

    }

}
