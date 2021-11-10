package scenario;

import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.ContactScreen;
import screen.PermissionsScreen;
import screen.TabBarScreen;
import screen.settings.AccountScreen;
import screen.settings.OptionScreen;
import screen.settings.SettingsMoreScreen;
import screen.settings.SettingsScreen;

import java.io.IOException;
import java.net.MalformedURLException;

public class ContactScenario extends STWScenario {

    public ContactScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    //test screen
    public void Contact_STC1() throws InterruptedException, IOException{
        AccountScreen.GetUseCaseDescription("Contact_STC1", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        contactScreen.dismissAlerts();
        TabBarScreen.goToContacts();
        contactScreen.checkOptionsOfContactThread();

    }
    public void Contact_STC2() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        //permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC2", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);

        mLogger.log(Status.PASS, "1 - Launch the app");
        permissionsScreen.acceptPermission();
        TabBarScreen.goToContacts();
        mLogger.log(Status.PASS, "2 - Switch to Contacts tab");
        contactScreen.checkOptionsOfContactThread();
        //contactScreen.getSwipeDetailsOption().click();
        Thread.sleep(1000);
        contactScreen.back();
        Thread.sleep(3000);

    }

    //test Contact options and user UI
    public void Contact_STC3(String Account) throws InterruptedException, MalformedURLException, IOException{
        TabBarScreen TabBarScreen=new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Contact_STC3", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        TabBarScreen.goToContacts();
        //mLogger.log(Status.PASS, " 2 - Switch to Contacts tab");
        Thread.sleep(3000);
        contactScreen.SearchContact(Account);
        contactScreen.ClickOnContactSearchResult(Account);
        //mLogger.log(Status.PASS, " 3 - Click on a user entry");
        Thread.sleep(3000);
        contactScreen.checkContactOptions();
        //mLogger.log(Status.PASS, "4 - Check the  displayed Contact options");
        Thread.sleep(1000);
        contactScreen.checkContactDetails();
        //mLogger.log(Status.PASS, "5 - Click on contact details and check UI");

        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void Contact_STC4() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        //permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC4", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        mLogger.log(Status.PASS, "1- Launch app");
        TabBarScreen.goToContacts();
        mLogger.log(Status.PASS, " 2- Switch to contacts tab");
        contactScreen.getMultiselect().click();
        mLogger.log(Status.PASS, "3- Click select button");
        Thread.sleep(3000);
        //contactScreen.getCancelSelect().click();
        Thread.sleep(7000);

    }

    //Search contact
    public void Contact_STC5(String Account) throws InterruptedException, IOException{
        TabBarScreen TabBarScreen=new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Contact_STC5", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        TabBarScreen.goToContacts();
        mLogger.log(Status.PASS, " 2 - Switch to Contacts tab");
        Thread.sleep(3000);
        mLogger.log(Status.PASS, "  3 - Search contact");
        contactScreen.SearchContact(Account);
        contactScreen.ClickOnContactSearchResult(Account);
        mLogger.log(Status.PASS, "  4 - Tape some characters");
        Thread.sleep(3000);
        //contactScreen.getContactDetails().click();

        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    //availability icon contact
    public void Contact_STC7() throws InterruptedException, IOException{
        ContactScreen contactScreen = new ContactScreen(mDriver);
        SettingsScreen SettingsScreen = new SettingsScreen(mDriver);
        SettingsMoreScreen SettingsMoreScreen = new SettingsMoreScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        //permissionsScreen.acceptPermissions();
        contactScreen.GetUseCaseDescription("Contact_STC7", Constants.Company_ContactsheetNumber,mLogger);
        TabBarScreen TabBarScreen = new TabBarScreen(mDriver);
        contactScreen.ChangeContactSortToLastName();
        Thread.sleep(3000);
        optionScreen.back();
        Thread.sleep(3000);
        SettingsScreen.back();
        SettingsMoreScreen.back();
        mLogger.log(Status.PASS, "5-go to contact tab");
        TabBarScreen.goToContacts();
        contactScreen.ChangeContactSortToFirstName();
        Thread.sleep(1000);

    }



}
