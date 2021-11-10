package screen;

import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends STWScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id="android:id/button1")
    private MobileElement okBtn;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy( iOSClassChain ="**/XCUIElementTypeTextField[`name == \"CreateAccountViewController_companyIdTextField\"`]" )
    @iOSXCUITFindBy( iOSClassChain ="**/XCUIElementTypeTextField[`name == \"ColibriLoginViewController_companyIdTextField\"`]" )
    @AndroidFindBy(id = "login_company_id")
    private MobileElement companyId ;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @WithTimeout(time = 10L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"CreateAccountViewController_phoneNumTextField\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"ColibriLoginViewController_phoneNumTextField\"`]")
    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumTextField ;


    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ContactsList checkboxEmpty")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ContactsList checkboxEmpty\"`]")
    private MobileElement checkBoxOfTermsAndConditions ;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CreateAccountViewController_phoneCodeLabel")
    @iOSXCUITFindBy(accessibility = "ColibriLoginViewController_phoneCodeLabel")
    @AndroidFindBy(id = "flags_spinner")
    private MobileElement phoneCodeLabel ;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Tunisia\"));")
    private MobileElement scrollCountry;
    //@AndroidFindBy(id = "com.google.android.gm:id/senders")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Team on the run\"));")
    private MobileElement newMessageGmail ;

    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement popupAndroid;
    @AndroidFindBy(id = "android:id/sem_title_default")
    private MobileElement openWith;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"http://teamontherun.com\"));")
    private MobileElement scrollGmail;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Team on the Run\"));")
    private MobileElement openWithapp;
    @AndroidFindBy(id = "android:id/button_always")
    private MobileElement always;

    @AndroidFindBy(id = "login_redirect_tip")
    private MobileElement senDEmail;
    @AndroidFindBy(id = "parentPanel")
    private MobileElement confirmation;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`]")
    private MobileElement searchBar ;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Mailboxes\"`]")
    private MobileElement mailBoxes;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"ConversationView\"`]/XCUIElementTypeButton[1]")
    private MobileElement backtoInbox;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Use current device\"`]")
    @AndroidFindBy(id="alertTitle")
    private MobileElement useCurrentDevice ;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Inbox\"`]")
    private MobileElement InboxBtn ;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
   @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Team on the run\"`][1]")
    //@iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name=\"Mail.messageList.cell.view.addressLabel\"])[1]",priority = 1)
    private MobileElement MailRecieved ;

    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
        @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    //@iOSXCUITFindBy(xpath = "//*[contains(@label,'com.streamwide.totrInHouseDev')]" ,priority =1)
      //  @iOSXCUITFindBy(xpath = "//*[contains(@label,'com.streamwide.SmartMSBusinessInHouse')]",priority = 2)
    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,'com.streamwide.SmartMSBusinessInHouse')]")
    private MobileElement Link ;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"216, Tunisia (\u202Bتونس\u202C\u200E)\"`]")
    private MobileElement CountryCell ;


    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CreateAccountViewController_registerButton")
    @iOSXCUITFindBy(accessibility = "ColibriLoginViewController_registerButton")
    @AndroidFindBy(id="login_btn_ok")
    private MobileElement logInButton ;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Open\"`]")
    private MobileElement openPopupLink ;
    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`]")
    private MobileElement validButton;

    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"START USING AGNET\"`]")
    private MobileElement startUsingAgnetBtn;
    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Welcome!\"`]")
    private MobileElement welcomeLabel;
    @AndroidFindBy(id = "congrats_wizard_id")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Congratulations')]")
    private MobileElement congratulations;
    @AndroidFindBy(id = "wizard_next_btn")
    private MobileElement next;
    @AndroidFindBy(id = "activity_geolocation_prompt_dont_show_again")
    private MobileElement dontShowAgainalertGeolocation;
    @AndroidFindBy(id = "activity_geolocation_prompt_ok_btn")
    private MobileElement activityGeolocationPromptOkBtn;

    public LoginScreen(AppiumDriver driver) {
        super((AppiumDriver) driver);
    }
    // @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    // private MobileElement CountryCell = new MobileBy.ByIosClassChain("**/XCUIElementTypeCell[`label == \"216, Tunisia (\u202Bتونس\u202C\u200E)\"`]");

    public MobileElement getBacktoInbox() {
        return backtoInbox;
    }

    public MobileElement getMailBoxes() {
        return mailBoxes;
    }

    public MobileElement getUseCurrentDevice() {
        return useCurrentDevice;
    }

    public MobileElement getInboxBtn() {
        return InboxBtn;
    }

    public MobileElement getOpenPopupLink() {
        return openPopupLink;
    }



    public MobileElement getCompanyId() {
        return companyId;
    }



    public MobileElement getPhoneNumTextField() {
        return phoneNumTextField;
    }

    public MobileElement getPhoneCodeLabel() {
        return phoneCodeLabel;
    }

    public MobileElement getMailRecieved() {
        return MailRecieved;
    }

    public MobileElement getLink() {
        return Link;
    }

    public MobileElement getSearchBar() {
        return searchBar;
    }

    public MobileElement getCountryCell() {
        return CountryCell;
    }



    public MobileElement getValidButton() {
        return validButton;
    }

    public void setCompanyId(String company){

                if (mPlatform.equals(Platforms.ANDROID)) {
                    companyId.clear();
                    companyId.setValue(company);

                } else {
                    clearTextFully(companyId);

                    companyId.setValue(company);
                        }

    }

    public void clickOnContinue(){

        logInButton.click();
    }


    public void setPhoneNumber(String phone){

        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(phoneNumTextField));

                if (mPlatform.equals(Platforms.IOS)) {
                    clearTextFully(phoneNumTextField);
                }

        phoneNumTextField.setValue(phone);
    }

    public void clickCountryCodeflag(){

        phoneCodeLabel.click();
    }

    public void searchCountryAndClick(String countryName) throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            phoneCodeLabel.click();
            scrollCountry.click();
                } else {
            clickCountryCodeflag();
            searchBar.sendKeys(countryName);
            Thread.sleep(500);

            hideKeyboardIos();
            // Thread.sleep(500);

            selectorToClick(countryName);
                }

    }

    public void ClickOnGO() throws InterruptedException {

                if (branding.equals(Branding.TOTR)) {
                    Thread.sleep(500);
                    logInButton.click();

                } else {
                    Thread.sleep(500);
                    checkBoxOfTermsAndConditions.click();
                    logInButton.click();


                }
    }

    public void openActivationLinkFromMail(String bundleId) throws InterruptedException, IOException {
                if (mPlatform.equals(Platforms.ANDROID)) {
                    WebDriverWait wait = new WebDriverWait(mDriver, 60);

                   CheckDisplayedOfElement(senDEmail, "Screen to confirm that application sent link by email");
                    if (isElementDisplayed(confirmation)) {
                       acceptAlert();
                    }
                    TimeUnit.SECONDS.sleep(2);

                    startActivity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail");
                    mLogger.log(Status.PASS, "4 : User should be redirected to gmail");
                    scrollDown(5,10);
                    TimeUnit.SECONDS.sleep(5);

                    wait.until(ExpectedConditions.visibilityOf(newMessageGmail));

                    newMessageGmail.click();
                    scrollGmail.click();
                    Thread.sleep(2000);
                    if (isElementDisplayed(openWith)) {
                        openWithapp.click();
                        if (isElementDisplayed(always))
                        always.click();

                    }
                    if (isElementDisplayed(confirmation)) {
                        acceptAlert();
                    }
                    if (isElementDisplayed(dontShowAgainalertGeolocation)) {
                        activityGeolocationPromptOkBtn.click();
                    }

                    Thread.sleep(2000);
                        }
                    else
                    {

                    openApp(bundleId);



                    if (isElementDisplayed(backtoInbox))
                        backtoInbox.click();

                    if (isElementDisplayed(InboxBtn))
                        InboxBtn.click();

                    holdAndScrollDown(20 , 3000, 0.3, 0.7, 0.5);

                        tapOnElementPosition(MailRecieved,0.5,0.5);

                       // MailRecieved.click();
                    mLogger.log(Status.PASS, "5 : open activation mail");
                        waitForElementToBeClickable(Link);

                    Link.click();
                    //tapOnElementPosition(Link,0.5,0.48);
                    mLogger.log(Status.PASS, "6 : open activation link");

                    if (isElementDisplayed(openPopupLink))
                        openPopupLink.click();
                        }



    }
public void verifyUserCurrentDevice(){
        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(useCurrentDevice))
                okBtn.click();

                } else {
            if (isElementDisplayed(useCurrentDevice))
                useCurrentDevice.click();
                }


}

    public void verifyWelcomePage(String bundleId) throws IOException, InterruptedException {
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        if (mPlatform.equals(Platforms.ANDROID)) {

            if (isElementDisplayed(dontShowAgainalertGeolocation)) {
                activityGeolocationPromptOkBtn.click();
            }
            CheckDisplayedOfElement(congratulations, "Screen to confirm that we are connected");
            next.click();
            mLogger.log(Status.PASS, "5 : with the link, User can navigate into the app");
             permissionsScreen.allow();
                } else {

            if (branding.equals(Branding.TOTR)){
                waitForElementToBeVisible(welcomeLabel);
            checkIfElementIsPresent(welcomeLabel,"welcome");
            mLogger.log(Status.PASS, "check welcome page and login success");
            waitForElementToBeClickable(validButton);
           validButton.click();

            mDriver.terminateApp(bundleId);
            mLogger.log(Status.PASS, " close Mail app");}
            else{

                checkIfElementIsPresent(congratulations,"congratulation");
                mLogger.log(Status.PASS, "check welcome page and login success");

                startUsingAgnetBtn.click();

                mDriver.terminateApp(bundleId);
                mLogger.log(Status.PASS, " close Mail app");}

            }

        }


        public void verifyLogoutWasSuccesful() throws IOException, InterruptedException {

            CheckDisplayedOfElement(companyId, "company id");

            mLogger.log(Status.PASS, "logout was successful");

        }

    }

