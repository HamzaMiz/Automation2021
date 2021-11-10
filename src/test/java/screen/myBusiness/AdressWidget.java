package screen.myBusiness;

import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdressWidget  extends STWScreen {
    @iOSXCUITFindBy(accessibility = "OneRowTextFieldCell_locationButton")
    @AndroidFindBy(id = "share_location_button")
    private MobileElement locationButton;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "LocationViewController_searchButton")
    @AndroidFindBy(id = "map_toolbar_search_button",priority = 1)
    @AndroidFindBy(id="search_contact",priority = 2)
    private MobileElement locationSearchButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search for an address\"`]")
    @AndroidFindBy(id = "map_toolbar_content")
    private MobileElement searchTextField;
    @iOSXCUITFindBy(accessibility = "LocationViewController_0_0")
    private MobileElement firstLocationFromSearchResult;
    @AndroidFindBy(id = "location_item_title_text")
    private List<MobileElement> firstLocationFromSearchResultAndroid;
    @iOSXCUITFindBy(accessibility = "LocationViewController_sendLocationButton")
    @AndroidFindBy(id = "map_share_button")
    private MobileElement shareLocationBtn;
    @iOSXCUITFindBy(accessibility = "location_3")
    @AndroidFindBy(id = "address_edit_text")
    private MobileElement adressTextField;
    @iOSXCUITFindBy(accessibility = "address_1")

    private MobileElement zipCodeTextField;
    @iOSXCUITFindBy(accessibility = "address_2")
    private MobileElement cityTextField;
    @iOSXCUITFindBy(accessibility = "address_3")
    private MobileElement countryTextField;
    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> ZipCodeAndCityAndCountryTextFields;

    public AdressWidget(AppiumDriver driver) {
        super(driver);
    }

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

                if (mPlatform.equals(Platforms.ANDROID)) {

                    locationButton.click();
                    TimeUnit.SECONDS.sleep(2);

                    locationSearchButton.click();
                    searchTextField.clear();
                    searchTextField.sendKeys(location);
                        } else {
                    locationButton.click();
                    TimeUnit.SECONDS.sleep(2);

                    locationSearchButton.click();
                    searchTextField.sendKeys(location);
                    hideKeyboardIos();
                        }

    }
    public void clickOnLocationFromSearchResult(){
                if (mPlatform.equals(Platforms.ANDROID)) {
                firstLocationFromSearchResultAndroid.get(0).click();

                        } else {
                    firstLocationFromSearchResult.click();

                }
    }

    public void clickOnShareLocation()

    {
        WebDriverWait wait = new WebDriverWait(mDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(shareLocationBtn));
                        shareLocationBtn.click();

    }

    public void verifyTheFieldPopulated() throws InterruptedException {


                if (mPlatform.equals(Platforms.ANDROID)) {

                    boolean isFilled = (adressTextField.getText() != null && adressTextField.getText().isEmpty() == false) && (ZipCodeAndCityAndCountryTextFields.get(0).getText() != null && ZipCodeAndCityAndCountryTextFields.get(0).getText().isEmpty() == false) && (ZipCodeAndCityAndCountryTextFields.get(1).getText() != null && ZipCodeAndCityAndCountryTextFields.get(1).getText().isEmpty() == false)  && (ZipCodeAndCityAndCountryTextFields.get(2).getText() != null && ZipCodeAndCityAndCountryTextFields.get(2).getText().isEmpty() == false);
                    Assert.assertTrue(isFilled, "error :adress field is not filled");
                        } else {
                    WebDriverWait wait = new WebDriverWait(mDriver, 5);
                    wait.until(ExpectedConditions.visibilityOf(adressTextField));
                    boolean isFilled = (adressTextField.getText() != null && adressTextField.getText().isEmpty() == false) && (zipCodeTextField.getText() != null && zipCodeTextField.getText().isEmpty() == false) && (cityTextField.getText() != null && cityTextField.getText().isEmpty() == false)  && (countryTextField.getText() != null && countryTextField.getText().isEmpty() == false);
                    Assert.assertTrue(isFilled, "error :adress field is not filled");    }

    }
                }



