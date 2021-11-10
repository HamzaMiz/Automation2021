package screen.settings;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountScreen extends STWScreen {

    public AccountScreen(AppiumDriver driver) {
        super(driver);
    }




    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CustomAlertView_ok\"]",priority = 1)
    @iOSXCUITFindBy(accessibility = "Yes",priority = 3)
    private MobileElement confirmLogout;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "MyAccountViewController_logOutButton")
    @iOSXCUITFindBy(accessibility = "Colibri_MyAccountViewController_logOutButton")
    @AndroidFindBy(id = "fragment_setting_account_logout")
    private MobileElement logOutButton;

    @FindBy(css = "div[class='group-authorization-title'] button[class='trash-button enabled']")
    public WebElement trashBtn;

    public void clickOnTrash(){
        trashBtn.click();
    }
    public void clickOnLogout() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            scrollToAnElementByText(mDriver,"LOG OUT");
            waitForElementToBeClickable(logOutButton);
            logOutButton.click();
            acceptAlert();


        } else {
            Thread.sleep(3000);
            scrollUp(0,1000);
            waitForElementToBeClickable(logOutButton);
            logOutButton.click();
          confirmLogout.click();

        }


    }
}
