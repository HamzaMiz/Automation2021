package IOS.screen.Mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class ContactWidget extends STWScreen {
    public ContactWidget(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ProcessContactCell_myInfoCheckBox\"`]")
    @iOSXCUITFindBy(accessibility = "ProcessContactCell_myInfoCheckBox")
    private MobileElement myInfoCheckBox;

    @iOSXCUITFindBy(accessibility = "contact_0")
    private MobileElement firstNameTextField;


    @iOSXCUITFindBy(accessibility = "contact_1")
    private MobileElement lastNameTextField;

    @iOSXCUITFindBy(accessibility = "contact_6")
    private MobileElement emailTextField;

    @iOSXCUITFindBy(accessibility = "PhoneTextFieldCell_phoneNumTextField")
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

    public void checkIfContactFieldAreFilled(){

        boolean isFilled = (firstNameTextField.getText() != null && firstNameTextField.getText().isEmpty() == false);
        Assert.assertTrue(isFilled, "error :contact field is not filled");

    }
}
