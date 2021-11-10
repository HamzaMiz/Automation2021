package android.screen.mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdressWidget extends STWScreen {
    public AdressWidget(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(id = "share_location_button")
    private MobileElement locationButton;


    @AndroidFindBy(id = "map_toolbar_search_button")
    private MobileElement locationSearchButton;

    @AndroidFindBy(id = "map_toolbar_content")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "location_item_title_text")
    private List<MobileElement> firstLocationFromSearchResult;


    @AndroidFindBy(id = "map_share_button")
    private MobileElement shareLocationBtn;

    @AndroidFindBy(id = "address_edit_text")
    private MobileElement adressTextField;


    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> ZipCodeAndCityAndCountryTextFields;



    public MobileElement getLocationButton() {
        return locationButton;
    }

    public MobileElement getLocationSearchButton() {
        return locationSearchButton;
    }

    public MobileElement getSearchTextField() {
        return searchTextField;
    }

    public List<MobileElement> getFirstLocationFromSearchResult() {
        return firstLocationFromSearchResult;
    }

    public MobileElement getShareLocationBtn() {
        return shareLocationBtn;
    }

    public MobileElement getAdressTextField() {
        return adressTextField;
    }

    public List<MobileElement> getZipCodeAndCityAndCountryTextFields() {
        return ZipCodeAndCityAndCountryTextFields;
    }

    public void searchLocation(String location) throws InterruptedException {

        locationButton.click();
        TimeUnit.SECONDS.sleep(2);

        locationSearchButton.click();
        searchTextField.sendKeys(location);
    }
    public void clickOnLocationFromSearchResult(){
        firstLocationFromSearchResult.get(0).click();
    }

    public void clickOnShareLocation(){
        shareLocationBtn.click();
    }

    public void verifyTheFieldPopulated(){
        boolean isFilled = (adressTextField.getText() != null && adressTextField.getText().isEmpty() == false) && (ZipCodeAndCityAndCountryTextFields.get(0).getText() != null && ZipCodeAndCityAndCountryTextFields.get(0).getText().isEmpty() == false) && (ZipCodeAndCityAndCountryTextFields.get(1).getText() != null && ZipCodeAndCityAndCountryTextFields.get(1).getText().isEmpty() == false)  && (ZipCodeAndCityAndCountryTextFields.get(2).getText() != null && ZipCodeAndCityAndCountryTextFields.get(2).getText().isEmpty() == false);
        Assert.assertTrue(isFilled, "error :adress field is not filled");    }

}
