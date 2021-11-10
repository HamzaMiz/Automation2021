package IOS.screen;

import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
public class LoginScreen extends STWScreen {



    public LoginScreen(AppiumDriver driver) {
        super((AppiumDriver) driver);
    }



    @iOSXCUITFindBy( iOSClassChain ="**/XCUIElementTypeTextField[`name == \"CreateAccountViewController_companyIdTextField\"`]" )
    private MobileElement companyId ;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"CreateAccountViewController_phoneNumTextField\"`]")
    private MobileElement phoneNumTextField ;

    @iOSXCUITFindBy(accessibility = "CreateAccountViewController_phoneCodeLabel")
    private MobileElement phoneCodeLabel ;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`]")
    private MobileElement searchBar ;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Mailboxes\"`]")
    private MobileElement mailBoxes;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"ConversationView\"`]/XCUIElementTypeButton[1]")
    private MobileElement backtoInbox;

    public MobileElement getBacktoInbox() {
        return backtoInbox;
    }

    public MobileElement getMailBoxes() {
        return mailBoxes;
    }

    public MobileElement getUseCurrentDevice() {
        return useCurrentDevice;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Use current device\"`]")
    private MobileElement useCurrentDevice ;
    public MobileElement getInboxBtn() {
        return InboxBtn;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Inbox\"`]")
    private MobileElement InboxBtn ;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Team on the run\"`][1]")
    private MobileElement MailRecieved ;


    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'com.streamwide.totrInHouseDev')]")
    private MobileElement Link ;

    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"216, Tunisia (\u202Bتونس\u202C\u200E)\"`]")
    private MobileElement CountryCell ;
   // @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
   // private MobileElement CountryCell = new MobileBy.ByIosClassChain("**/XCUIElementTypeCell[`label == \"216, Tunisia (\u202Bتونس\u202C\u200E)\"`]");


    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "CreateAccountViewController_registerButton")
    private MobileElement registerButton ;

    public MobileElement getOpenPopupLink() {
        return openPopupLink;
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Open\"`]")
    private MobileElement openPopupLink ;

    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`]")
    private MobileElement validButton;


    public MobileElement getWelcomeLabel() {
        return WelcomeLabel;
    }

    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Welcome!\"`]")
    private MobileElement WelcomeLabel;
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

    public MobileElement getRegisterButton() {
        return registerButton;
    }
    public MobileElement getValidButton() {
        return validButton;
    }


    public void setCompanyId(String company){
       clearTextFully(companyId);

        companyId.setValue(company);
    }

    public void clickOnContinue(){
        registerButton.click();
    }


    public void setPhoneNumber(String phone){

        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(phoneNumTextField));

        clearTextFully(phoneNumTextField);

        phoneNumTextField.setValue(phone);
    }

    public void clickCountryCodeflag(){
        phoneCodeLabel.click();
    }

    public void searchCountryAndClick(String countryName) throws InterruptedException {

        searchBar.sendKeys(countryName);
        Thread.sleep(500);

        hideKeyboardIos();
        // Thread.sleep(500);

        selectorToClick("Tunisia");
    }

    public void ClickOnGO(){
        registerButton.click();
    }

    public void openActivationLinkFromMail(String bundleId){
        openApp(bundleId);
        if (isElementDisplayed(mailBoxes))
            mailBoxes.click();

        if (isElementDisplayed(backtoInbox))
            backtoInbox.click();

        if (isElementDisplayed(InboxBtn))
            InboxBtn.click();

       holdAndScrollDown(6, 2700, 0.3, 0.5, 0.5);


        MailRecieved.click();
        mLogger.log(Status.PASS, "5 : open activation mail");


       tapOnElementPosition(Link,0.5,0.5);
        mLogger.log(Status.PASS, "6 : open activation link");

        if (isElementDisplayed(openPopupLink))
           openPopupLink.click();
    }


    public void verifyWelcomePage() throws IOException, InterruptedException {

        checkIfElementIsPresent(getWelcomeLabel(),"welcome");
        mLogger.log(Status.PASS, "check welcome page and login success");
    }
}
