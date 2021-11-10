package android.screen.mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactWidget extends STWScreen {


    @AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@text, 'Use my info')]")
    private MobileElement myInfoCheckBox;

    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> AnyTextField;
    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumTextField;

    public ContactWidget(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getMyInfoCheckBox() {
        return myInfoCheckBox;
    }

    public List<MobileElement> getAnyTextField() {
        return AnyTextField;
    }

    public MobileElement getPhoneNumTextField() {
        return phoneNumTextField;
    }

    public void checkIfContactFieldAreFilled() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        boolean isFilled = (AnyTextField.get(0).getText() != null && AnyTextField.get(0).getText().isEmpty() == false);
        Assert.assertTrue(isFilled, "error :contact field is not filled");

    }

    public void clickOnUseMyInfo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        myInfoCheckBox.click();
    }
}
