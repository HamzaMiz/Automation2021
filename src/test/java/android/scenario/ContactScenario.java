package android.scenario;

import android.screen.ContactScreen;
import android.screen.TabBarScreen;
import android.screen.settings.AccountScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

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

        contactScreen.dismissAlerts();
        contactScreen.checkOptionsOfContactThread();

        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //test Contact options and user UI
    public void Contact_STC3(String Account) throws InterruptedException, MalformedURLException, IOException{
        TabBarScreen TabBarScreen=new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Contact_STC3", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        TabBarScreen.getContactItem();
        mLogger.log(Status.PASS, " 2 - Switch to Contacts tab");
        Thread.sleep(3000);
        contactScreen.SearchContact(Account);
        contactScreen.LonPressOnString(Account,1,0);
        mLogger.log(Status.PASS, " 3 - Click on a user entry");
        Thread.sleep(3000);
        contactScreen.checkContactOptions();
        mLogger.log(Status.PASS, "4 - Check the  displayed Contact options");
        Thread.sleep(1000);
        contactScreen.getContactDetails().click();
        contactScreen.checkContactDetails();
        mLogger.log(Status.PASS, "5 - Click on contact details and check UI");

        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

//Search contact
    public void Contact_STC5(String Account) throws InterruptedException, IOException{
        TabBarScreen TabBarScreen=new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Contact_STC5", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        TabBarScreen.getContactItem();
        mLogger.log(Status.PASS, " 2 - Switch to Contacts tab");
        Thread.sleep(1000);
        contactScreen.getSearchButton().click();
        mLogger.log(Status.PASS, "  3 - Swipe down on Contacts tab then click on Search bar (iOS) or click on Search button (Android)");
        contactScreen.getSearchContent().sendKeys(Account);
        mLogger.log(Status.PASS, "  4 - Tape some characters");
        Thread.sleep(3000);
        contactScreen.LonPressOnString(Account,0,1);
        contactScreen.getContactDetails().click();




        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    //availability icon contact
    public void Contact_STC7(String Account) throws InterruptedException, IOException{
        TabBarScreen TabBarScreen=new TabBarScreen(mDriver);
        AccountScreen.GetUseCaseDescription("Contact_STC7", Constants.Company_ContactsheetNumber, mLogger);
        ContactScreen contactScreen=new ContactScreen(mDriver);
        contactScreen.dismissAlert();
        TabBarScreen.getContactItem();
        Thread.sleep(3000);
        contactScreen.getSearchButton().click();
        contactScreen.getSearchContent().sendKeys(Account);
        Thread.sleep(3000);
        contactScreen.CheckDisplayedOfElement(contactScreen.getContactIconAvailability(), "contact icon availability");
        Thread.sleep(3000);
        String color = contactScreen.getContactIconAvailability().getCssValue("background-color");
        System.out.println(color);


        Thread.sleep(10000L);
        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    }
