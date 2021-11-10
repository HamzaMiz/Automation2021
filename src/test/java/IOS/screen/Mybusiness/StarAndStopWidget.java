package IOS.screen.Mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

public class StarAndStopWidget extends STWScreen {
    public StarAndStopWidget(AppiumDriver driver) {
        super(driver);
    }




    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name, 'StartStopOptionCell_button')]")
    public List<MobileElement> startStopButton;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Started on\"`]")
    public MobileElement startDetail;

    public MobileElement getStartDetail() {
        return startDetail;
    }

    public MobileElement getStopDetail() {
        return stopDetail;
    }

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Stopped on\"`]")
    public MobileElement stopDetail;

    public List<MobileElement> getStartStopButton() {
        return startStopButton;
    }

public void VerifyDetails(){
     boolean verify=  isElementDisplayed(startDetail) && isElementDisplayed(stopDetail) ;
    Assert.assertTrue(verify, "star detail and stop detail are not displayed");

}
    public void clickStartButton(){

        getStartStopButton().get(0).click();
    }

    public void clickStopButton(){

        getStartStopButton().get(1).click();
    }



}
