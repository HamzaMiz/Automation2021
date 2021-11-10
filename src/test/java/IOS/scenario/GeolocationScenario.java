package IOS.scenario;

import IOS.screen.*;
import IOS.screen.Settings.OptionScreen;
import IOS.screen.Settings.SettingsMoreScreen;
import IOS.screen.Settings.SettingsScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;


public class GeolocationScenario extends STWScenario {
    //Device 1
    OptionScreen optionScreen = new OptionScreen(mDriver);
    TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
    SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
    SettingsScreen settingsScreen = new SettingsScreen(mDriver);
    //Device 2
    ContactScreen contactScreen = new ContactScreen(mDriver);
    ConversationScreen conversationScreen = new ConversationScreen(mDriver);
    GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver);

    // TabBarScreen tabBarScreen_2 = new TabBarScreen(mDriver2);
    //  ContactScreen contactScreen = new ContactScreen(mDriver2);
    //  ConversationScreen conversationScreen = new ConversationScreen(mDriver2);
    // GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver2);

    public GeolocationScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);

    }

    public void clickOnMoreButton() {

        tabBarScreen.getMoreItem().click();
    }

    public void clickOnSettingsButton() {

        settingsMoreScreen.clickOnSettings();

    }

    public void clickOnOptionsButton() throws InterruptedException {
        settingsScreen.clickOnOptions();

    }

    public void deactivateGeolocation() {
        optionScreen.deactivateGeolocationViaButton();
    }

    public void deactivateHighSpeed() {
        optionScreen.scrollUp(1, 300);
        optionScreen.deactivateHighspeed();
    }

    public void clickOnContacts() {
        tabBarScreen.clickOnContactsButton();
    }

    public void enterTheContactToSearch(String contact) {
        contactScreen.enterTheContactToSearch(contact);

    }

    public void getSearchResult() throws InterruptedException {
        contactScreen.hideKeyboardIos();
        Thread.sleep(5000);
        contactScreen.clickOnSearchResult();

    }

    public void clickOnGeolocationIcon() {
        WebDriverWait wait = new WebDriverWait(mDriver2, 180);

        conversationScreen.clickOnGeolocation(mDriver2, 340, 40);
        try {
            wait.until(ExpectedConditions.visibilityOf(geolocationScreen.getDetailsGeolocation()));
        } catch (TimeoutException e) {
            Assert.fail("Details of geolocation not found");
        }
    }

    public void clickOnDetails() {
        GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver2);

        geolocationScreen.clickOnDetailsGeolocation();


        //get not availbe message
        String message = geolocationScreen.getGeolocation_option_disabled().getText();
        if (!message.equals("Location service not available")) {
            Assert.fail("Not available message does not appear");

        }
    }




    public void getLocalTime() {

/*
        //get local Date time
        int hour = LocalDateTime.now().getHour();
        //AM Time
        if (hour > 12) hour = hour - 12;
        //minutes
        int min = LocalDateTime.now().getMinute();


        //change format
        String local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
        String local_time_2 = String.format("%02d", hour) + ":" + String.format("%02d", min + 1);


        //change format
       String local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
        String local_time_2 = String.format("%02d", hour) + ":" + String.format("%02d", min + 1);
        String today = geolocationScreen.getToday().getText();
        mLogger.log(Status.PASS, "10 - get geolocation time ");


        int pos = today.indexOf(":");
        if ((hour == 10) || (hour == 11) || (hour == 12)) {
            time_today = (String) today.subSequence(pos - 2, pos + 3);
        } else {
            time_today = "0" + today.subSequence(pos - 1, pos + 3);
        }


        if (!local_time.equals(time_today) && (!local_time_2.equals(time_today))) {

            Assert.fail("The position is not sent in real time " + "local time : " + local_time_2 + " geolocation time " + time_today);

        */
    }

    public void doGeolocation_STC14(String contact2) throws InterruptedException {
        GeolocationScreen.GetUseCaseDescription("Conversation_STC14", Constants.GeolocationSheetNumber, mLogger);
        clickOnMoreButton();
        mLogger.log(Status.PASS, "2 - Go to MORE");

        clickOnSettingsButton();
        mLogger.log(Status.PASS, "3 - Go to SETTINGS");

        clickOnOptionsButton();
        mLogger.log(Status.PASS, "3 - Go to options");

        deactivateGeolocation();
        mLogger.log(Status.PASS, "3-a   Deactivate  geolocation");

        deactivateHighSpeed();
        mLogger.log(Status.PASS, "3-b  -  'deactivate high speed geolocation tracking '");


        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.IOS);
        clickOnContacts();
        mLogger.log(Status.PASS, "4 -Click  on contacts button");


        enterTheContactToSearch(contact2);
        mLogger.log(Status.PASS, "5 -enter the name of the contact to be searched  ");


        getSearchResult();
        mLogger.log(Status.PASS, "6 - click on the search result ");


        clickOnGeolocationIcon();
        mLogger.log(Status.PASS, "7 - click on the geolocation button ");

        clickOnDetails();
        mLogger.log(Status.PASS, "8 - click on the détails of geolocation  ");


    }

    public void doGeolocation_STC15(String contact2) throws InterruptedException, IOException {
        GeolocationScreen.GetUseCaseDescription("Conversation_STC15", Constants.GeolocationSheetNumber, mLogger);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
            ConversationScreen conversationScreen = new ConversationScreen(mDriver);
            ContactScreen contactScreen = new ContactScreen(mDriver);
           GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver);

            android.screen.GeolocationScreen.GetUseCaseDescription("Conversation_STC15", Constants.GeolocationSheetNumber, mLogger);




            contactScreen.SearchContactandClickOnHim(contact2);
            mLogger.log(Status.PASS, "4 - search contact from contact tab ");



            Thread.sleep(1000);

            conversationScreen.clickOnGeolocationIcon();
            mLogger.log(Status.PASS, "7 - click on the geolocation button ");



            geolocationScreen.verifyMapDetails();



            geolocationScreen.clickOnDetailsGeolocation();
            mLogger.log(Status.PASS, "9 - click on the détails of geolocation  ");

            geolocationScreen.verifyUserInfo();








        }
    }

