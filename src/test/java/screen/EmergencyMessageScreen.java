package screen;

import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class EmergencyMessageScreen extends STWScreen {


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"EMERGENCY MESSAGE\"`]")
    @AndroidFindBy(id = "alert_message_title")
    private MobileElement emergency_Message_Button;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CRITICAL!\"`]")
    @AndroidFindBy(id = "critical_button")
    private MobileElement critical;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SEVERE!\"`]")
    @AndroidFindBy(id = "severe_button")
    private MobileElement severe;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"URGENT!\"`]")
    @AndroidFindBy(id = "urgent_button")
    private MobileElement urgent;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cancel\"`]")
    @AndroidFindBy(id = "cancel_button")
    private MobileElement cancel;

    @AndroidFindBy(id = "alert_message")
    @iOSXCUITFindBy(accessibility = "Life in danger!")
    private MobileElement alerte;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "view_slide_button_container")
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_lwSlider")
    @iOSXCUITFindBy(accessibility = "Slide to STOP Alert", priority = 1)

    private MobileElement slideToStop;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ConversationListViewController_threadName_0")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Alert Mode On')]")
    @iOSXCUITFindBy(xpath = "ConversationListViewController_threadName_0", priority = 2)

    private MobileElement cellEmergency;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Colibri_ConversationListViewController_date')]")
    private List<MobileElement> cellEmergencyAgnet;


    @AndroidFindBy(id = "close_btn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Close\"`]")
    private MobileElement close;

    @AndroidFindBy(id = "record_button_view_image_view")
    @iOSXCUITFindBy(accessibility = "STWComposerView_recordingButton")
    private MobileElement recordingButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Message')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Message\"`]")

    private MobileElement agnetEmergencyMessageButton;


    public EmergencyMessageScreen(AppiumDriver driver) {
        super(driver);
    }


    public void clickOnEmergencyMessage() throws MalformedURLException, InterruptedException {
        EmergencyCallScreen emergencyCallScreen = new EmergencyCallScreen(mDriver);

        if (Branding.AGNET.equals(branding)) {
            emergencyCallScreen.getSos().click();
            if (mPlatform.equals(Platforms.ANDROID)) {
                clickOnElementByString("Message");
            } else {
                agnetEmergencyMessageButton.click();
            }


        } else {

            emergency_Message_Button.click();
        }
    }

    public void verifyEmergencyMessageIsLaunched() throws IOException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            if (Branding.TOTR.equals(branding)) {


                String AlertON = emergency_Message_Button.getText();
                //Assert.assertEquals(AlertON, "ALERT MODE ON");
                if (AlertON.equals("ALERT MODE ON"))
                    mLogger.log(Status.PASS, "ALERT MODE ON is displayed");
                else
                    mLogger.log(Status.FAIL, "ALERT MODE ON is not displayed");

            } else {
                Thread.sleep(2000);
                CheckDisplayedOfElement(alerte, "Life is danger for the recipient");
                close.click();

            }
        } else {
            CheckDisplayedOfElement(alerte, "Life in danger for the recipient");
            close.click();

        }

    }


    public void checkEmeregencyMessageScreen() throws IOException, InterruptedException {
        CheckDisplayedOfElement(critical, "CRITICAL ! Life in danger is displayed");
        CheckDisplayedOfElement(severe, "SEVERE ! Property in danger is displayed");
        CheckDisplayedOfElement(urgent, "URGENT ! I need help is displayed");
        CheckDisplayedOfElement(cancel, "Cancel is displayed");

    }

    public void stopEmergencyMessageAlerte() throws IOException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            if (Branding.TOTR.equals(branding)) {
                clickOnEmergencyMessage();
            } else {

                Thread.sleep(5000);
                cellEmergency.click();
                swipeRightElementToClickIOSByAcces(mDriver, slideToStop, recordingButton);
            }
        } else {
            if (Branding.TOTR.equals(branding)) {

                Thread.sleep(5000);
                cellEmergency.click();
                swipeRightElementToClickIOSByAcces(mDriver, slideToStop, recordingButton);


            } else {
                cellEmergencyAgnet.get(0).click();
                //swipe(slideToStop,"right");
                swipeWithDuration(slideToStop,"right",10.0);

                //swipeRightElementToClickIOSByAcces(mDriver, slideToStop, recordingButton);


            }

        }
    }
}


