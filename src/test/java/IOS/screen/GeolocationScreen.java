package IOS.screen;

import io.appium.java_client.AppiumDriver;
import framework.screen.STWScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class GeolocationScreen extends STWScreen {
    public GeolocationScreen(AppiumDriver driver) {
        super(driver);
    }
    @iOSXCUITFindBy(accessibility= "Contact Details")
    private MobileElement detailsGeolocation;

    @iOSXCUITFindBy(accessibility= "WAYMapViewController_searchButton")
    private MobileElement searchButtonInMap;


    @iOSXCUITFindBy(accessibility= "WAYMapViewController_roleIconButton")
    private MobileElement roleIcon;

    @iOSXCUITFindBy(accessibility= "batteryIcon")
    private MobileElement batteryDetails;

    @iOSXCUITFindBy(accessibility= "wifiIcon")
    private MobileElement networkDetails;


    @iOSXCUITFindBy(accessibility= "BAtteryTimeDate")
    private MobileElement dateOfLastPosition;

    @iOSXCUITFindBy(accessibility = "Location service not available")
    private MobileElement geolocation_option_disabled;


    public MobileElement getDetailsGeolocation() {
        return detailsGeolocation;
    }

    public MobileElement getGeolocation_option_disabled()
    {
        return  geolocation_option_disabled;
    }
    public void clickOnDetailsGeolocation() {
        detailsGeolocation.click();

    }


    public void verifyMapDetails() throws IOException, InterruptedException {


        WebDriverWait wait = new WebDriverWait(mDriver,10 );

        wait.until(ExpectedConditions.visibilityOf(roleIcon));

        CheckDisplayedOfElement(roleIcon,"role icon");
        CheckDisplayedOfElement(searchButtonInMap,"SearchMap Button");



    }

    public void verifyUserInfo() throws IOException, InterruptedException {


        WebDriverWait wait = new WebDriverWait(mDriver,65 );
        wait.until(ExpectedConditions.visibilityOf(batteryDetails));


        CheckDisplayedOfElement(batteryDetails,"Battery icon");
        CheckDisplayedOfElement(networkDetails,"Network Map button ");
        CheckDisplayedOfElement(dateOfLastPosition,"last position time and date Button");



    }
}
