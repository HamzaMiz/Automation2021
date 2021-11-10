package android.screen;

import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDateTime;

public class GeolocationScreen extends STWScreen {
    public GeolocationScreen(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "activity_geolocation_collapse_contact_details_linear_layout")
    private MobileElement details_geolocation;

    @AndroidFindBy(id = "contact_geoloc_item_battery_network_date_time_text_view")
    private MobileElement today;
    @AndroidFindBy(id = "contact_geoloc_item_battery_text_view")
    private MobileElement geolocation_option_disabled;

    @AndroidFindBy(id = "activity_geolocation_role_icon_btn")
    private MobileElement roleIcon;

    @AndroidFindBy(id = "map_toolbar_search_button")
    private MobileElement searchButtonInMap;

    @AndroidFindBy(id = "activity_geolocation_center_map_btn")
    private MobileElement centerMapButton;

    @AndroidFindBy(id = "contact_geoloc_item_battery_icon_imageview")
    private MobileElement batteryDetails;


    @AndroidFindBy(id = "contact_geoloc_item_network_icon_imageview")
    private MobileElement networkDetails;


    @AndroidFindBy(id = "contact_geoloc_item_battery_network_date_time_text_view")
    private MobileElement dateOfLastPosition;

    public MobileElement getBatteryDetails() {
        return batteryDetails;
    }

    public MobileElement getNetworkDetails() {
        return networkDetails;
    }

    public MobileElement getDateOfLastPosition() {
        return dateOfLastPosition;
    }

    public MobileElement getRoleIcon() {
        return roleIcon;
    }

    public MobileElement getSearchButtonInMap() {
        return searchButtonInMap;
    }

    public MobileElement getCenterMapButton() {
        return centerMapButton;
    }

    public MobileElement getDirectionsbutton() {
        return directionsButton;
    }

    public MobileElement getGelocationStatusFromUserDetails() {
        return gelocationStatusFromUserDetails;
    }

    @AndroidFindBy(id = " activity_geolocation_compass_map_btn")
    private MobileElement directionsButton;

    @AndroidFindBy(id = "contact_geoloc_item_reason_no_location_text_view")
    private MobileElement gelocationStatusFromUserDetails;
    public MobileElement getDetails_geolocation() {
        return details_geolocation;
    }

    public MobileElement getToday() {
        return today;
    }

    public MobileElement getGeolocation_option_disabled() {
        return geolocation_option_disabled;
    }


    public void clickOnDetails() {

        WebDriverWait wait = new WebDriverWait(mDriver,5 );

        try {
            wait.until(ExpectedConditions.visibilityOf(details_geolocation));
        } catch (TimeoutException e) {
            Assert.fail("Details of geolocation not found");
        }
        details_geolocation.click();



    }

public void verifyThatLocationIsNotAvailable() throws IOException, InterruptedException {

    //get not availbe message
  /*  String message = geolocation_option_disabled.getText();
    if (!message.equals("Location service not available")) {
        Assert.fail("Not available message does not appear");*/
    WebDriverWait wait = new WebDriverWait(mDriver,5 );

    wait.until(ExpectedConditions.visibilityOf(gelocationStatusFromUserDetails));


    String message = gelocationStatusFromUserDetails.getText();

    CheckDisplayedOfText(message,"Application Geolocation Option Disabled"," message does  appear");

    }


    public void verifyMapDetails() throws IOException, InterruptedException {


        WebDriverWait wait = new WebDriverWait(mDriver,10 );

        wait.until(ExpectedConditions.visibilityOf(roleIcon));

        CheckDisplayedOfElement(roleIcon,"role icon");
        CheckDisplayedOfElement(centerMapButton,"center Map button ");
        CheckDisplayedOfElement(directionsButton,"Direction compass Button");
        CheckDisplayedOfElement(searchButtonInMap,"SearchMap Button");



    }

    public void verifyUserInfo() throws IOException, InterruptedException {


        WebDriverWait wait = new WebDriverWait(mDriver,65 );
        wait.until(ExpectedConditions.visibilityOf(batteryDetails));


        CheckDisplayedOfElement(batteryDetails,"Battery icon");
        CheckDisplayedOfElement(networkDetails,"Network Map button ");
        CheckDisplayedOfElement(dateOfLastPosition,"last position time and date Button");



    }



    public void verifyLocationIsRecieved(){


        String time_today ;

        //get local Date time
        int hour = LocalDateTime.now().getHour();
        //AM Time
        if (hour > 12) hour = hour - 12;
        //minutes
        int min = LocalDateTime.now().getMinute();


        //change format
        String local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
        String local_time_2 = String.format("%02d", hour) + ":" + String.format("%02d", min + 1);
        String today = getToday().getText();
        mLogger.log(Status.PASS, "10 - get geolocation time ");


        int pos = today.indexOf(":");
        if ((hour == 10) || (hour == 11) || (hour == 12)) {
            time_today = (String) today.subSequence(pos - 2, pos + 3);
        } else {
            time_today = "0" + today.subSequence(pos - 1, pos + 3);
        }


        if (!local_time.equals(time_today) && (!local_time_2.equals(time_today))) {

            Assert.fail("The position is not sent in real time " + "local time : " + local_time_2 + " geolocation time " + time_today);

        }
    }
    }



