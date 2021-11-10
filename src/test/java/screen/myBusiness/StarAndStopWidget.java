package screen.myBusiness;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

public class StarAndStopWidget extends STWScreen {
    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name, 'StartStopOptionCell_button')]")
    public List<MobileElement> startStopButton;
    @AndroidFindBy(id="my_business_widget_start_linear_layout")
    public MobileElement startButton;
    @AndroidFindBy(id="my_business_widget_stop_linear_layout")
    public MobileElement stopButton;
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Started on\"`]")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Started on')]")
    public MobileElement startDetail;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Stopped on\"`]")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Stopped on')]")
    public MobileElement stopDetail;

    @AndroidFindBy(id="my_business_widget_start_date_text_view")
    public MobileElement startDatedetail;

    @AndroidFindBy(id="my_business_widget_stop_date_text_view")
    public MobileElement stopDatedetail;

    public StarAndStopWidget(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getStartDetail() {
        return startDetail;
    }

    public MobileElement getStopDetail() {
        return stopDetail;
    }

    public List<MobileElement> getStartStopButton() {
        return startStopButton;
    }




public void VerifyDetails(){

                if (mPlatform.equals(Platforms.ANDROID)) {
                    boolean verify=  isElementDisplayed(startDetail) && isElementDisplayed(stopDetail) && isElementDisplayed(startDatedetail)&& isElementDisplayed(stopDatedetail);
                    Assert.assertTrue(verify, "start detail and stop detail are not displayed");


                } else {
                    boolean verify=  isElementDisplayed(startDetail) && isElementDisplayed(stopDetail) ;
                    Assert.assertTrue(verify, "star detail and stop detail are not displayed");

                }

}
    public void clickStartButton(){
        if (mPlatform.equals(Platforms.ANDROID)) {

            startButton.click();

        } else {
            waitForElementToBeClickable( startStopButton.get(0));
            startStopButton.get(0).click();

        }
    }

    public void clickStopButton(){
                if (mPlatform.equals(Platforms.ANDROID)) {

                    stopButton.click();

                } else {
                    startStopButton.get(1).click();

                }

    }



}
