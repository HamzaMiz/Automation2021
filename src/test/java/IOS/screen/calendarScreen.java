package IOS.screen;

import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class calendarScreen extends STWScreen {
    public calendarScreen(AppiumDriver driver) {
        super(driver);
    }

    String pendingStatus="PENDING";
    String unconfirmedStatus="UNCONFIRMED";
    String inProgressStatus="IN PROGRESS";
    String acceptedStatus="ACCEPTED";
    String doneStatus="DONE";
    String completedStatus="COMPLETED";
    String delayedStatus="DELAYED";

    @iOSXCUITFindBy(id = "dailyView calander")
    private MobileElement calendarIcon;
    @iOSXCUITFindBy(id = "Today")
    private MobileElement todayIcon;
    @iOSXCUITFindBy(id = "dailyView leftArrow")
    private MobileElement previousDate;
    @iOSXCUITFindBy(id = "dailyView RightArrow")
    private MobileElement nextDate;
    @iOSXCUITFindBy(id = "dailyView notif")
    private MobileElement dailyNotif;
    @iOSXCUITFindBy(id = "dailyView option")
    private MobileElement dailyOption;
    @iOSXCUITFindBy(id = "Set Default Navigation App")
    private MobileElement setNavigationApp;
    @iOSXCUITFindBy(id = "Apple Maps")
    private MobileElement setNavigationAppleMaps;
    @iOSXCUITFindBy(id = "Google Maps")
    private MobileElement setNavigationGoogleMaps;
    @iOSXCUITFindBy(id = "Waze")
    private MobileElement setNavigationWaze;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"3\"`]")
    private MobileElement randomDate;
    @iOSXCUITFindBy(id = "SO_acceptButton_0")
    private MobileElement acceptButton;
    @iOSXCUITFindBy(id = "SO_rejectButton_0")
    private MobileElement rejectButton;
    @iOSXCUITFindBy(id = "Start the service")
    private MobileElement startButton;
    @iOSXCUITFindBy(id = "Finish the service")
    private MobileElement finishButton;
    @iOSXCUITFindBy(id = "Complete the service")
    private MobileElement completeButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Planning\"])[1]")
    private MobileElement backButton;

    @iOSXCUITFindBy(id = "SO_statusLabel_0")
    private MobileElement serviceStatus;
    @iOSXCUITFindBy(id = "**/XCUIElementTypeStaticText[`label == \"COMPLETED\"`]")
    private MobileElement serviceStatusCompleted;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"ACCEPTED\"`]")
    private MobileElement serviceStatusAccepted;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"UNCONFIRMED\"`]")
    private MobileElement serviceStatusUnconfirmed;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"IN PROGRESS\"`]")
    private MobileElement serviceStatusInProgress;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"DONE\"`]")
    private MobileElement serviceStatusDone;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PENDING\"`]")
    private MobileElement serviceStatusPending;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"DELAYED\"`]")
    private MobileElement serviceStatusDelayed;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"REJECTED\"`]")
    private MobileElement serviceStatusRejected;

    @iOSXCUITFindBy(id = "ty")
    private MobileElement servicePriority;
    @iOSXCUITFindBy(id = "SO_fromDateLabel_0")
    private MobileElement serviceFromDate;
    @iOSXCUITFindBy(id = "SO_untilDateLabel_0")
    private MobileElement serviceUntilDate;
    @iOSXCUITFindBy(id = "SO_customorLabel_0")
    private MobileElement serviceCustomer;
    @iOSXCUITFindBy(id = "SO_locationLabel_0")
    private MobileElement serviceCustomerAddress;


    @iOSXCUITFindBy(id = "SO Phone")
    private MobileElement phoneButton;
    @iOSXCUITFindBy(id = "Call Dispatcher")
    private MobileElement callDispatcher;
    @iOSXCUITFindBy(id = "Chat With Dispatcher")
    private MobileElement chatWithDispatcher;
    @iOSXCUITFindBy(id = "Call Customer")
    private MobileElement callCustomer;
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelPhoneButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"“Teamontherun” Would Like to Access the Microphone\"]")
    private MobileElement microphonePermission;
    @iOSXCUITFindBy(id = "OK")
    private MobileElement okPermission;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private MobileElement DoNotAllowPermission;
    @iOSXCUITFindBy(id = "Send")
    private MobileElement sendButton;
    @iOSXCUITFindBy(id = "STWComposerInputView_textView")
    private MobileElement chatInput;
    @iOSXCUITFindBy(id = "ty")
    private MobileElement customerNumber;



    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SO Location\"`][1]")
    private MobileElement serviceItinerary;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView")
    private MobileElement rejectDescription;
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelRejection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
    private MobileElement submitRejection;
    @iOSXCUITFindBy(id = "Done")
    private MobileElement doneRejectReason;
    @iOSXCUITFindBy(id = "SO_priorityLabel_0")
    private MobileElement frameNumber;
    @iOSXCUITFindBy(id = "Service accepted")
    private MobileElement acceptToast;
    @iOSXCUITFindBy(id = "Service rejected")
    private MobileElement rejectToast;

    @iOSXCUITFindBy(xpath = "No Service Order")
    private MobileElement noSOLabel;
    @iOSXCUITFindBy(id = "wrapperView1_0")
    private MobileElement floatButton;



    public MobileElement getCalendarIcon() {
        return calendarIcon;
    }
    public MobileElement getTodayIcon() {
        return todayIcon;
    }
    public MobileElement getPreviousDate() {
        return previousDate;
    }
    public MobileElement getNextDate() {
        return nextDate;
    }
    public MobileElement getDailyNotif() { return dailyNotif; }
    public MobileElement getDailyOption() { return dailyOption; }

    public MobileElement getSetNavigationApp() {
        return setNavigationApp;
    }
    public MobileElement getSetNavigationAppleMaps() {
        return setNavigationAppleMaps;
    }

    public MobileElement getSetNavigationGoogleMaps() {
        return setNavigationGoogleMaps;
    }

    public MobileElement getSetNavigationWaze() {
        return setNavigationWaze;
    }
    public MobileElement getBackButton() {
        return backButton;
    }
    public MobileElement getRandomDate() {
        return randomDate;
    }
    public MobileElement getAcceptButton() {
        return acceptButton;
    }

    public MobileElement getRejectButton() { return rejectButton; }

    public MobileElement getStartButton() {
        return startButton;
    }

    public MobileElement getFinishButton() {
        return finishButton;
    }

    public MobileElement getCompleteButton() {
        return completeButton;
    }
    public MobileElement getServiceStatus() { return serviceStatus; }
    public MobileElement getServiceStatusCompleted() { return serviceStatusCompleted; }

    public MobileElement getServiceStatusAccepted() { return serviceStatusAccepted; }

    public MobileElement getServiceStatusUnconfirmed() { return serviceStatusUnconfirmed; }

    public MobileElement getServiceStatusInProgress() { return serviceStatusInProgress; }

    public MobileElement getServiceStatusDone() { return serviceStatusDone; }

    public MobileElement getServiceStatusPending() { return serviceStatusPending; }

    public MobileElement getServiceStatusDelayed() { return serviceStatusDelayed; }

    public MobileElement getServiceStatusRejected() { return serviceStatusRejected; }

    public MobileElement getServicePriority() {
        return servicePriority;
    }

    public MobileElement getServiceFromDate() {
        return serviceFromDate;
    }

    public MobileElement getServiceUntilDate() {
        return serviceUntilDate;
    }

    public MobileElement getServiceCustomer() {
        return serviceCustomer;
    }

    public MobileElement getServiceCustomerAddress() {
        return serviceCustomerAddress;
    }


    public MobileElement getServiceItinerary() {
        return serviceItinerary;
    }

    public MobileElement getRejectDescription() {
        return rejectDescription;
    }

    public MobileElement getCancelRejection() {
        return cancelRejection;
    }

    public MobileElement getSubmitRejection() { return submitRejection; }
    public MobileElement getDoneRejectReason() { return doneRejectReason; }
    public MobileElement getFrameNumber() {
        return frameNumber;
    }
    public MobileElement getAcceptToast() { return acceptToast; }
    public MobileElement getRejectToast() { return rejectToast; }
    public MobileElement getFloatButton() { return floatButton; }
    public MobileElement getNoSOLabel() { return noSOLabel; }
    public MobileElement getPhoneButton() { return phoneButton; }
    public MobileElement getCallDispatcher() {
        return callDispatcher;
    }

    public MobileElement getChatWithDispatcher() {
        return chatWithDispatcher;
    }

    public MobileElement getCallCustomer() {
        return callCustomer;
    }

    public MobileElement getCancelPhoneButton() {
        return cancelPhoneButton;
    }

    public MobileElement getMicrophonePermission() {
        return microphonePermission;
    }
    public MobileElement getChatInput() {
        return chatInput;
    }
    public MobileElement getSendButton() {
        return sendButton;
    }
    public MobileElement getCustomerNumber() {
        return customerNumber;
    }

    public MobileElement getOkPermission() {
        return okPermission;
    }

    public MobileElement getDoNotAllowPermission() {
        return DoNotAllowPermission;
    }

    public void clickOnAccept(){

        getAcceptButton().click();
    }
    public void soContent() {

        getFrameNumber().click();
    }
    public void clickOnStartTheService() {
        getStartButton().click();
    }
    public void clickOnFinishTheService() {
        getFinishButton().click();
    }
    public void clickOnCompleteTheService() {
        getCompleteButton().click();
    }
    public void rejectService(String rejectReason) throws IOException, InterruptedException {
        getRejectButton().click();
        getRejectDescription().sendKeys(rejectReason);
        getDoneRejectReason().click();
        getSubmitRejection().click();
        //WebDriverWait wait = new WebDriverWait(mDriver, 100);
        //wait.until(ExpectedConditions.visibilityOf(getRejectToast()));
        CheckDisplayedOfElement(getRejectToast(),"Result : Service rejected");
        CheckDisplayedOfElement(getNoSOLabel(),"Result : Service rejected");

    }

    public void checkAcceptedService() throws IOException, InterruptedException {
        if (getServiceStatus().getAttribute("label").equalsIgnoreCase(pendingStatus)|| getServiceStatus().getAttribute("label").equalsIgnoreCase(unconfirmedStatus))
        {
            clickOnAccept();
            mLogger.log(Status.PASS, "User A clicks on « Accept » button in a service with « Pending » or « Unconfirmed » status ");

            WebDriverWait wait = new WebDriverWait(mDriver, 100);
            wait.until(ExpectedConditions.visibilityOf(getAcceptToast()));
            mLogger.log(Status.PASS, "Service Accepted is displayed");
            if (getServiceStatus().getAttribute("label").equalsIgnoreCase(acceptedStatus))
            {
                mLogger.log(Status.PASS, "Result PASS – The Status of the service order is changed to " + getServiceStatus().getText());
            } else {
                mLogger.log(Status.FAIL, "Result Fail – The Status of the service order is changed to " + getServiceStatus().getText());
                mLogger.addScreenCaptureFromPath(getscreenshot());
            }
        }
    }
    public void checkAcceptedServiceFromContent() throws IOException, InterruptedException {
        soContent();
        CheckDisplayedOfElement(getFloatButton(),"Result :  The floating button is displayed / The edit mode is activated ");

    }
    public void checkStartedService() throws IOException, InterruptedException {
        if (getServiceStatus().getAttribute("label").equalsIgnoreCase(acceptedStatus) || getServiceStatus().getAttribute("label").equalsIgnoreCase(delayedStatus) ) {
            clickOnStartTheService();
            mLogger.log(Status.PASS, "User A clicks on « Start the service » button in a service with « Accepted » status ");
            //String inProgressStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (getServiceStatus().getAttribute("label").equalsIgnoreCase(inProgressStatus)) {
                mLogger.log(Status.PASS, "Result Pass – The Status of the service order is changed to " + getServiceStatus().getText());

            } else {
                mLogger.log(Status.FAIL, "Result fail – The Status of the service order is changed to " + getServiceStatus().getText());
                mLogger.addScreenCaptureFromPath(getscreenshot());
            }
        }
    }
    public void checkFinishedService() throws IOException, InterruptedException {
        if (getServiceStatus().getAttribute("label").equalsIgnoreCase(inProgressStatus)) {
            clickOnFinishTheService();
            //Thread.sleep(1000);
            mLogger.log(Status.PASS, "User A clicks on « Finish the service » button in a service with « In progress » status ");
            //String doneStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (getServiceStatus().getAttribute("label").equalsIgnoreCase(doneStatus)) {
                mLogger.log(Status.PASS, "Result Pass – The Status of the service order is changed to " + getServiceStatus().getText());

            } else {
                mLogger.log(Status.FAIL, "Result Fail – The Status of the service order is changed to " + getServiceStatus().getText());
                mLogger.addScreenCaptureFromPath(getscreenshot());
            }
        }
    }
    public void checkCompletedService() throws IOException, InterruptedException {
        if (getServiceStatus().getAttribute("label").equalsIgnoreCase(doneStatus)) {
            clickOnCompleteTheService();
            //Thread.sleep(2000);
            mLogger.log(Status.PASS, "User A clicks on « Complete the service » button in a service with « Done » status ");
            //String completedStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (getServiceStatus().getAttribute("label").equalsIgnoreCase(completedStatus)) {
                mLogger.log(Status.PASS, "Result Pass – The Status of the service order is changed to " + getServiceStatus().getText());

            } else {
                mLogger.log(Status.FAIL, "Result Fail – The Status of the service order is changed to " + getServiceStatus().getText());
                mLogger.addScreenCaptureFromPath(getscreenshot());
            }
        }
    }
    public void setDefaultNavigationAppleMaps()  {
        getDailyOption().click();
        getSetNavigationApp().click();
        getSetNavigationAppleMaps().click();
        getBackButton().click();
    }
    public void setDefaultNavigationGoogleMaps()  {
        getDailyOption().click();
        getSetNavigationApp().click();
        getSetNavigationGoogleMaps().click();
        getBackButton().click();
    }
    public void setDefaultNavigationWaze()  {
        getDailyOption().click();
        getSetNavigationApp().click();
        getSetNavigationWaze().click();
        getBackButton().click();
    }
    public void clickOnServiceItinerary()  {
        getServiceItinerary().click();
    }
    public void callDispatcher()  {
        getPhoneButton().click();
        getCallDispatcher().click();
        if (isElementDisplayed(getMicrophonePermission()))
        {
            getOkPermission().click();
        }
    }
    public void chatWithDispatcher()  {
        getPhoneButton().click();
        getChatWithDispatcher().click();
        getChatInput().getAttribute("Hello");
        getSendButton().click();
    }
    public void callCustomer()  {
        getPhoneButton().click();
        getCallCustomer().click();
        getCustomerNumber().click();
    }
}
