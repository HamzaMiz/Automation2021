package IOS.screen.Mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AdressWidget  extends STWScreen {
    public AdressWidget(AppiumDriver driver) {
        super(driver);
    }
    @iOSXCUITFindBy(accessibility = "OneRowTextFieldCell_locationButton")
    private MobileElement locationButton;


    @iOSXCUITFindBy(accessibility = "LocationViewController_searchButton")
    private MobileElement locationSearchButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search for an address\"`]")
    private MobileElement searchTextField;

    @iOSXCUITFindBy(accessibility = "LocationViewController_0_0")
    private MobileElement firstLocationFromSearchResult;


    @iOSXCUITFindBy(accessibility = "LocationViewController_sendLocationButton")
    private MobileElement shareLocationBtn;

    @iOSXCUITFindBy(accessibility = "location_3")
    private MobileElement adressTextField;


    @iOSXCUITFindBy(accessibility = "address_1")
    private MobileElement zipCodeTextField;

    @iOSXCUITFindBy(accessibility = "address_2")
    private MobileElement cityTextField;

    @iOSXCUITFindBy(accessibility = "address_3")
    private MobileElement countryTextField;

    public MobileElement getLocationButton() {
        return locationButton;
    }

    public MobileElement getLocationSearchButton() {
        return locationSearchButton;
    }

    public MobileElement getSearchTextField() {
        return searchTextField;
    }

    public MobileElement getFirstLocationFromSearchResult() {
        return firstLocationFromSearchResult;
    }

    public MobileElement getShareLocationBtn() {
        return shareLocationBtn;
    }

    public MobileElement getAdressTextField() {
        return adressTextField;
    }

    public MobileElement getZipCodeTextField() {
        return zipCodeTextField;
    }

    public MobileElement getCityTextField() {
        return cityTextField;
    }

    public MobileElement getCountryTextField() {
        return countryTextField;
    }


    public void searchLocation(String location) throws InterruptedException {

        locationButton.click();
        TimeUnit.SECONDS.sleep(2);

        locationSearchButton.click();
        searchTextField.sendKeys(location);
        hideKeyboardIos();
    }
    public void clickOnLocationFromSearchResult(){
        firstLocationFromSearchResult.click();
    }

    public void clickOnShareLocation(){
        shareLocationBtn.click();
    }

    public void verifyTheFieldPopulated() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(adressTextField));
        boolean isFilled = (adressTextField.getText() != null && adressTextField.getText().isEmpty() == false) && (zipCodeTextField.getText() != null && zipCodeTextField.getText().isEmpty() == false) && (cityTextField.getText() != null && cityTextField.getText().isEmpty() == false)  && (countryTextField.getText() != null && countryTextField.getText().isEmpty() == false);
        Assert.assertTrue(isFilled, "error :contact field is not filled");    }

}
