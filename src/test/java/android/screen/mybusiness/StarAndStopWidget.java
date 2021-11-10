package android.screen.mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


    public class StarAndStopWidget extends STWScreen {
        @AndroidFindBy(id="my_business_widget_start_linear_layout")
        public MobileElement startButton;
        @AndroidFindBy(id="my_business_widget_stop_linear_layout")
        public MobileElement stopButton;
        @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Started on')]")
        public MobileElement startDetail;
        @AndroidFindBy(id="my_business_widget_start_date_text_view")
        public MobileElement startDatedetail;

        @AndroidFindBy(id="my_business_widget_stop_date_text_view")
        public MobileElement stopDatedetail;

        public MobileElement getStartButton() {
            return startButton;
        }

        public MobileElement getStopButton() {
            return stopButton;
        }

        public MobileElement getStartDatedetail() {
            return startDatedetail;
        }

        public MobileElement getStopDatedetail() {
            return stopDatedetail;
        }

        @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Stopped on')]")
        public MobileElement stopDetail;

        public StarAndStopWidget(AppiumDriver driver) {
            super(driver);
        }

        public MobileElement getStartDetail() {
            return startDetail;
        }

        public MobileElement getStopDetail() {
            return stopDetail;
        }



        public void verifyDetails(){
            boolean verify=  isElementDisplayed(startDetail) && isElementDisplayed(stopDetail) && isElementDisplayed(startDatedetail)&& isElementDisplayed(stopDatedetail);
            Assert.assertTrue(verify, "start detail and stop detail are not displayed");

        }
        public void clickStartButton(){

      startButton.click();
        }

        public void clickStopButton(){

           stopButton.click();
        }



    }


