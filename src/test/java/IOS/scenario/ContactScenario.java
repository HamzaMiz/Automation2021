package IOS.scenario;

import IOS.screen.ContactScreen;
import IOS.screen.PermissionsScreen;
import IOS.screen.Settings.OptionScreen;
import IOS.screen.Settings.SettingsMoreScreen;
import IOS.screen.Settings.SettingsScreen;
import IOS.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;
import java.net.MalformedURLException;

public class ContactScenario extends STWScenario {
    PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

    public ContactScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    public void Contact_STC2() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        permissionsScreen.acceptPermissions();
    contactScreen.GetUseCaseDescription("Contact_STC2", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1 - Launch the app");
        TabBarScreen.getContactsItem().click();
        mLogger.log(Status.PASS, "2 - Switch to Contacts tab");
        contactScreen.CheckDisplayedOfElement(contactScreen.getMultiselect(),"Multiselect");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSelectCompany(),"Select company");
        contactScreen.CheckDisplayedOfElement(contactScreen.getCallBtn(),"Call botton");
        contactScreen.CheckDisplayedOfElement(contactScreen.getResultsearchContact(),"Search contact");
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactListFilter(),"Contact filter");
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoStreamBtn(),"Video stream botton");
        contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Contact details");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"More contact option");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send Message");
        contactScreen.getSwipeDetailsOption().click();
        Thread.sleep(1000);
        contactScreen.back();
        Thread.sleep(3000);

    }
    public void Contact_STC3() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC3", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1 - Launch the app");
        TabBarScreen.getContactsItem().click();
        mLogger.log(Status.PASS, "2 - Switch to Contacts tab");
        contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
        mLogger.log(Status.PASS, "3 - Click on a user entry");
        contactScreen.getSwipeMoreOption().click();
        Thread.sleep(1000);
        mLogger.log(Status.PASS, "4 - Check the  displayed Contact options");
        Thread.sleep(1000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getVoipCallList(),"Voip Call");
        Thread.sleep(2000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getVideoCallList(),"Video call");
        Thread.sleep(2000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getCellularCallList(),"Cellular call");
        Thread.sleep(2000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getPTTCallList(),"PTT call");
        Thread.sleep(2000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getConfCallList(),"Conf call");
        Thread.sleep(2000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getGeolocationList(),"Geolocation");
        Thread.sleep(1000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getEmailList(),"Email");
        Thread.sleep(1000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getBtnCancel(),"Cancel");
        Thread.sleep(1000);

        contactScreen.getBtnCancel().click();
        Thread.sleep(3000);
        TabBarScreen.getContactsItem().click();
        mLogger.log(Status.PASS, "5 - Click on contact details and check UI");
        Thread.sleep(1000);
        contactScreen.swipe(contactScreen.getResultsearchContact(),"left");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeDetailsOption(),"Details option is displayed");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeMoreOption(),"more option is displayed");
        contactScreen.CheckDisplayedOfElement(contactScreen.getSwipeSendMessage(),"Send message option is displayed");
        contactScreen.getSwipeDetailsOption().click();

        Thread.sleep(3000);
    }

    public void Contact_STC4() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC4", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1- Launch app");
        TabBarScreen.getContactsItem().click();
        mLogger.log(Status.PASS, " 2- Switch to contacts tab");
        contactScreen.getMultiselect().click();
        mLogger.log(Status.PASS, "3- Click select button");
        Thread.sleep(3000);
        contactScreen.getCancelSelect().click();
        Thread.sleep(7000);

    }
    public void Contact_STC5() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC5", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1- Launch app");
        Thread.sleep(1000);
        TabBarScreen.getContactsItem().click();
        Thread.sleep(1000);
        mLogger.log(Status.PASS, " 2- Switch to contacts tab");
        contactScreen.scrollDown(1,1);
        mLogger.log(Status.PASS, " 3 - Swipe down on Contacts tab then click on Search bar (iOS) or click on Search button (Android");
        contactScreen.getSearchContact().click();
        Thread.sleep(3000);

    }

    public void Contact_STC7() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC7", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        TabBarScreen.getContactsItem().click();
        mLogger.log(Status.PASS, "1-go to settings");
        TabBarScreen.getMoreItem().click();
        settingsMoreScreen.getmSettings().click();
        mLogger.log(Status.PASS, "2-click on option");
        settingsScreen.getmOptions().click();
        optionScreen.getSortContact().click();
        mLogger.log(Status.PASS, "3-click on contact sort option");
        optionScreen.getSortContactByLastName().click();
        optionScreen.getSave().click();
        mLogger.log(Status.PASS, "4-user can change option from : sort by first name to sort by last name");
        optionScreen.back();
        settingsScreen.back();
        mLogger.log(Status.PASS, "5-go to contact tab");
        TabBarScreen.getContactsItem().click();
        Thread.sleep(3000);

    }
}
