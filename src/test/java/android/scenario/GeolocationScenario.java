package android.scenario;

import android.screen.ContactScreen;
import android.screen.ConversationScreen;
import android.screen.GeolocationScreen;
import android.screen.TabBarScreen;
import android.screen.settings.OptionScreen;
import android.screen.settings.SettingsMoreScreen;
import android.screen.settings.SettingsScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;


public class GeolocationScenario extends STWScenario {


    public GeolocationScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);

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

    public void doGeolocation_STC14(String contact) throws InterruptedException, IOException {
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);

        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        ConversationScreen conversationScreenSecondDevice = new ConversationScreen(mDriver2);
        ContactScreen contactScreenSecondDevice = new ContactScreen(mDriver2);
        GeolocationScreen geolocationScreenSecondDevice = new GeolocationScreen(mDriver2);


        GeolocationScreen.GetUseCaseDescription("Conversation_STC14", Constants.GeolocationSheetNumber, mLogger);

        Thread.sleep(5000);

        tabBarScreen.clickOnMoreButton();
        settingsMoreScreen.clickOnSettings();
        mLogger.log(Status.PASS, "2 - Go to settings");

        settingsScreen.clickOnOptions();
        mLogger.log(Status.PASS, "3 - Go to options");

        optionScreen.deactivateGeolocation();
        mLogger.log(Status.PASS, "3-a   Deactivate  geolocation");

        optionScreen.deactivateHighSpeed();
        mLogger.log(Status.PASS, "3-b  -  'deactivate high speed geolocation tracking '");


        Thread.sleep(1000);

        contactScreenSecondDevice.SearchContact(contact);
        mLogger.log(Status.PASS, "4 - search contact from contact tab ");



        contactScreenSecondDevice.clickOnSearchResult();
        mLogger.log(Status.PASS, "6 - click on the search result ");
        Thread.sleep(1000);

        conversationScreenSecondDevice.clickOnGeolocationIcon();
        mLogger.log(Status.PASS, "7 - click on the geolocation button ");



        geolocationScreenSecondDevice.clickOnDetails();
         mLogger.log(Status.PASS, "8 - click on the détails of geolocation  ");

        geolocationScreenSecondDevice.verifyThatLocationIsNotAvailable();


    }

    public void doGeolocation_STC15(String contact2) throws InterruptedException, IOException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        ContactScreen contactScreen = new ContactScreen(mDriver);
        GeolocationScreen geolocationScreen = new GeolocationScreen(mDriver);

        GeolocationScreen.GetUseCaseDescription("Conversation_STC15", Constants.GeolocationSheetNumber, mLogger);




        contactScreen.SearchContact(contact2);
        mLogger.log(Status.PASS, "4 - search contact from contact tab ");



        contactScreen.clickOnSearchResult();
        mLogger.log(Status.PASS, "6 - click on the search result ");
        Thread.sleep(1000);

        conversationScreen.clickOnGeolocationIcon();
        mLogger.log(Status.PASS, "7 - click on the geolocation button ");



        geolocationScreen.verifyMapDetails();



        geolocationScreen.clickOnDetails();
        mLogger.log(Status.PASS, "9 - click on the détails of geolocation  ");

        geolocationScreen.verifyUserInfo();








    }}



