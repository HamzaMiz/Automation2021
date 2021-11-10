package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CalendarScreen extends STWScreen {

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]/android.widget.ImageButton")
    private MobileElement calendarIcon;
    @AndroidFindBy(id = "view_action_menu_item_text")
    private MobileElement todayIcon;
    @AndroidFindBy(id = "view_switch_date_previous")
    private MobileElement previousDate;
    @AndroidFindBy(id = "view_switch_date_next")
    private MobileElement nextDate;
    @AndroidFindBy(id = "mdtp_previous_month_arrow")
    private MobileElement previousMonth;
    @AndroidFindBy(id = "mdtp_next_month_arrow")
    private MobileElement nextMonth;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"20 April 2021\"]")
    private MobileElement randomDate;
    @AndroidFindBy(id = "mdtp_ok")
    private MobileElement okButton;
    @AndroidFindBy(id = "mdtp_cancel")
    private MobileElement cancelButton;
    @AndroidFindBy(id = "item_service_order_right_button")
    private MobileElement acceptButton;
    @AndroidFindBy(id = "item_service_order_left_button")
    private MobileElement rejectButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Start the service']")
    private MobileElement startButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Finish the service']")
    private MobileElement finishButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Complete the service']")
    private MobileElement completeButton;
    @AndroidFindBy(id = "item_service_order_status")
    private List<MobileElement> serviceStatus;
    @AndroidFindBy(id = "item_service_order_priority")
    private MobileElement servicePriority;
    @AndroidFindBy(id = "item_service_order_from")
    private MobileElement serviceFrom;
    @AndroidFindBy(id = "item_service_order_until")
    private MobileElement serviceUntil;
    @AndroidFindBy(id = "item_service_order_from_date")
    private MobileElement serviceFromDate;
    @AndroidFindBy(id = "item_service_order_to_date")
    private MobileElement serviceUntilDate;
    @AndroidFindBy(id = "item_service_order_customer")
    private MobileElement serviceCustomer;
    @AndroidFindBy(id = "item_service_order_customer_address")
    private MobileElement serviceCustomerAddress;
    @AndroidFindBy(id = "item_service_order_action_contact")
    private MobileElement serviceActionContact;
    @AndroidFindBy(id = "item_service_order_itinerary")
    private MobileElement serviceItinerary;
    @AndroidFindBy(id = "view_bottom_sheet_reject_reason_input")
    private MobileElement rejectDescription;
    @AndroidFindBy(id = "dialog_bottom_sheet_negative_button")
    private MobileElement cancelRejection;
    @AndroidFindBy(id = "dialog_bottom_sheet_positive_button")
    private MobileElement submitRejection;
    @AndroidFindBy(id = "")
    private MobileElement rejectionReason;
    @AndroidFindBy(id = "")
    private MobileElement doneRejectReason;
    @AndroidFindBy(xpath = "")
    private MobileElement rejectToast;
    @AndroidFindBy(xpath = "")
    private MobileElement noSOLabel;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.RelativeLayout")
    private MobileElement frameNumber;
    @AndroidFindBy(xpath = "")
    private MobileElement myBusinessStatus;
    @AndroidFindBy(xpath = "")
    private MobileElement acceptToast;
    @AndroidFindBy(xpath = "")
    private MobileElement floatButton;
    public CalendarScreen(AppiumDriver driver) {
        super(driver);
    }

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

    public MobileElement getPreviousMonth() {
        return previousMonth;
    }
    public MobileElement getNextMonth() {
        return nextMonth;
    }
    public MobileElement getRandomDate() {
        return randomDate;
    }
    public MobileElement getOkButton() {
        return okButton;
    }
    public MobileElement getCancelButton() {
        return cancelButton;
    }
    public MobileElement getAcceptButton() {
        return acceptButton;
    }

    public MobileElement getRejectButton() {
        return rejectButton;
    }

    public MobileElement getStartButton() {
        return startButton;
    }

    public MobileElement getFinishButton() {
        return finishButton;
    }

    public MobileElement getCompleteButton() {
        return completeButton;
    }

    public List<MobileElement> getServiceStatus() {
        return serviceStatus;
    }

    public MobileElement getServicePriority() {
        return servicePriority;
    }

    public MobileElement getServiceFrom() {
        return serviceFrom;
    }

    public MobileElement getServiceUntil() {
        return serviceUntil;
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

    public MobileElement getServiceActionContact() {
        return serviceActionContact;
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

    public MobileElement getSubmitRejection() {
        return submitRejection;
    }
    public MobileElement getRejectionReason() { return rejectionReason; }
    public MobileElement getDoneRejectReason() { return doneRejectReason; }
    public MobileElement getRejectToast() { return rejectToast; }
    public MobileElement getFrameNumber() { return frameNumber; }
    public MobileElement getNoSOLabel() { return noSOLabel; }
    public MobileElement getMyBusinessStatus() { return myBusinessStatus; }
    public MobileElement getAcceptToast() { return acceptToast; }
    public MobileElement getFloatButton() { return floatButton; }
}
