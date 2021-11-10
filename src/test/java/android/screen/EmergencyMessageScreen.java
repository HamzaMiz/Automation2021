package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class EmergencyMessageScreen extends STWScreen {

    public EmergencyMessageScreen(AppiumDriver driver) {
        super(driver);
    }



    @AndroidFindBy(id = "alert_message_title")
    private MobileElement emergency_Message_Button ;

    @AndroidFindBy(id = "critical_button")
    private MobileElement critical ;

    @AndroidFindBy(id = "severe_button")
    private MobileElement  severe;

    @AndroidFindBy(id = "urgent_button")
    private MobileElement urgent  ;

    @AndroidFindBy(id = "cancel_button")
    private MobileElement cancel ;


    public MobileElement getEmergency_Message_Button() {
        return emergency_Message_Button;
    }

    public MobileElement getCritical() {
        return critical;
    }

    public MobileElement getSevere() {
        return severe;
    }

    public MobileElement getUrgent() {
        return urgent;
    }

    public MobileElement getCancel() {
        return cancel;
    }


    public void clickOnEmergencyMessage()   {
        getEmergency_Message_Button().click();
    }

    public void verifyEmergencyMessageIsLaunched() {
        String AlertON = getEmergency_Message_Button().getText();
        Assert.assertEquals(AlertON, "ALERT MODE ON");
    }



    }
