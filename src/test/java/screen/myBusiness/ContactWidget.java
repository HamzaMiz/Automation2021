package screen.myBusiness;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactWidget extends STWScreen {
    public ContactWidget(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ProcessContactCell_myInfoCheckBox\"`]")
    @iOSXCUITFindBy(accessibility = "ProcessContactCell_myInfoCheckBox")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@text, 'Use my info')]")
    private MobileElement myInfoCheckBox;

    @iOSXCUITFindBy(accessibility = "contact_0")
    private MobileElement firstNameTextField;
    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> AnyTextField;

    @iOSXCUITFindBy(accessibility = "contact_1")
    private MobileElement lastNameTextField;

    @iOSXCUITFindBy(accessibility = "contact_6")
    private MobileElement emailTextField;

    @iOSXCUITFindBy(accessibility = "PhoneTextFieldCell_phoneNumTextField")
    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumTextField;


    public MobileElement getMyInfoCheckBox() {
        return myInfoCheckBox;
    }

    public MobileElement getFirstNameTextField() {
        return firstNameTextField;
    }

    public MobileElement getLastNameTextField() {
        return lastNameTextField;
    }

    public MobileElement getEmailTextField() {
        return emailTextField;
    }

    public MobileElement getPhoneNumTextField() {
        return phoneNumTextField;
    }

    public void clickOnUseMyInfo(){

        myInfoCheckBox.click();
    }

    public void checkIfContactFieldAreFilled() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    TimeUnit.SECONDS.sleep(1);

                    boolean isFilled = (AnyTextField.get(0).getText() != null && AnyTextField.get(0).getText().isEmpty() == false);
                    Assert.assertTrue(isFilled, "error :contact field is not filled");

                } else {
                    boolean isFilled = (firstNameTextField.getAttribute("label") != null && firstNameTextField.getAttribute("label").isEmpty() == false);
                    Assert.assertTrue(isFilled, "error :contact field is not filled");
                        }



    }
}
