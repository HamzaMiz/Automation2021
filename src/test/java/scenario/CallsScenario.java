package scenario;


import IOS.screen.Settings.SettingsScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.*;

import java.io.IOException;

public class CallsScenario extends STWScenario {


    public CallsScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void Calls_STC16(String Account) throws InterruptedException, IOException {


        ConversationScreen.GetUseCaseDescription("Calls_STC16", Constants.External_Call_OutSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();

        callsScreen.selectConversationOneToOne(Account);

        callsScreen.launchCallsFromConversation();
        callsScreen.launchExternalCallFromConversation();


        callsScreen.checkDisplayOfItemsOfExternalCall();


    }

    public void Calls_STC17() throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC17", Constants.External_Call_OutSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        PermissionsScreen permissionsScreen= new PermissionsScreen(mDriver);

        callsScreen.acceptPermission();


        callsScreen.selectCallBtnFromContact();
        callsScreen.launchDialerCall();
        permissionsScreen.acceptPermission();
        callsScreen.pushPhoneNumberForDialerCall();


        callsScreen.checkDisplayOfItemsOfExternalCall();


    }

    public void Calls_STC4(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);


        callsScreen.acceptPermission();
        //mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);

      //  callsScreen2.acceptPermission();
        ConversationScreen conversationScreen= new ConversationScreen(mDriver);
        conversationScreen.deleteConversationOfUser(Account);
        mLogger.log(Status.PASS, "1 - delete conversation of user B if exist");

        callsScreen.selectConversationOneToOne(Account);
        mLogger.log(Status.PASS, "1 - A create conversation with user B  ");
        callsScreen.startPTTCall();
        callsScreen2.acceptPTTCall();
        mLogger.log(Status.PASS, "1 - B accept ptt call   ");

        callsScreen.checkDisplayOfItemsOfPTTCall();

        //callsScreen2.checkDisplayOfItemsOfPTTCall();


        callsScreen.goToConversationPTTBtn();
        mLogger.log(Status.PASS, "1 - User A open the conversation with user b   ");

        callsScreen.checkDisplayOfPttSentence();
        mLogger.log(Status.PASS, "1 - User A check the display of ptt event in the conversation    ");


    }

    public void Calls_STC5(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        //mDriver2 = callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
       // mDriver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);

        //callsScreen2.acceptPermission();
        callsScreen.selectConversationOneToOne(Account);
        mLogger.log(Status.PASS, "1 - A call B through PTT call ");

        callsScreen.startPTTCall();


        callsScreen2.acceptPTTCall();
        callsScreen.checkDisplayOfItemsOfPTTCall();

        callsScreen.checkItemsOfPTTCall();


    }

    public void Calls_STC6(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC6", Constants.PushToTalk_OneToManySheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        //callsScreen2.acceptPermission();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);



        callsScreen.launchGroupPTTCallFromContact(GroupAccount);

        mLogger.log(Status.PASS, "1 - A open user B conversation");


        callsScreen.checkPopupOfOnDuty();

        mLogger.log(Status.PASS, "2 - A call B through PTT call ");
        callsScreen2.acceptPTTCall();
        callsScreen.checkDisplayOfItemsOfPTTCall();


        callsScreen.takeTheFloor();

        callsScreen.endPTTCall();


    }

    public void Calls_STC8(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC8", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        //callsScreen2.acceptPermission();

        callsScreen.launchGroupPTTCallFromContact(GroupAccount);

        mLogger.log(Status.PASS, "1 - A open user B conversation");


        callsScreen.checkPopupOfOnDuty();

        mLogger.log(Status.PASS, "2 - A call B through PTT call ");
        callsScreen2.acceptPTTCall();


        mLogger.log(Status.PASS, "2 - B accept the  call ");
        callsScreen.checkDisplayOfItemsOfPTTCall();

        callsScreen.endPTTCall();


    }

    public void Calls_STC7(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC7", Constants.PushToTalk_OneToManySheetNumber, mLogger);

      //  callsScreen.acceptPermission();

        CallsScreen callsScreen = new CallsScreen(mDriver);

        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());

        ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver2);


        int s = 0;
        while (s < 2) {
            CallsScreen callsScreen2 = new CallsScreen(mDriver2);

            String statusOfUser = callsScreen2.getStatusOfUser();

            callsScreen.launchGroupPTTCallFromContact(GroupAccount);

            mLogger.log(Status.PASS, "1 - A open user B conversation");


            if (ConversationScreen.isElementDisplayed(callsScreen.getPop_up_Of_OnDuty())) {
                s = s + 1;

                callsScreen.callOnDutyContacts();

                if (statusOfUser.equals("OnDuty")) {
                    mLogger.log(Status.INFO, "ON duty ");

                        callsScreen2.acceptPTTCall();


                        mLogger.log(Status.PASS, "2 - B accept the  call ");
                        callsScreen2.endPTTCall();





                } else {

                    mLogger.log(Status.INFO, "OFF duty ");

                    if (ConversationScreen2.isElementDisplayed(callsScreen2.getAcceptPTTCall())){

                    mLogger.log(Status.FAIL, "The call is received when status is OFF duty ");
                        callsScreen.endPTTCall();
                    }
                    else {
                        mLogger.log(Status.PASS, "The call is not received when status is OFF duty ");
                        callsScreen.endPTTCall();


                    }

                }


            } else {
                mLogger.log(Status.FAIL, " Pop_up_Of_OnDuty() option is NOT displayed, please enable Reach only On Duty users from web admin for group " + GroupAccount);

            }
        }


    }

    public void Calls_STC9(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC9", Constants.PushToTalk_OneToManySheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        callsScreen.launchGroupPTTCallFromContact(GroupAccount);
        if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
            mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");

            callsScreen.CheckOnDutyConversation();
        } else
            mLogger.log(Status.PASS, "Pop_up_Of_OnDuty() option is displayed  is not displayed, please check the administrator ");


    }

    public void callsSTC25(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC25", Constants.Video_StreamingSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        //callsScreen2.acceptPermission();
        conversationScreen.SelectContactConversation(Account);
        callsScreen.launchVideoStreaming();
        callsScreen2.acceptVideoStreaming();
        callsScreen.checkDisplayOfItemsOfVideoStreaming();

    }

    public void callsSTC26(String Account) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC26", Constants.Video_StreamingSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        VoipScreen voipScreenSecond = new VoipScreen(mDriver2);

        //callsScreen2.acceptPermission();


        conversationScreen.SelectContactConversation(Account);
        callsScreen.startPTTCall();
        callsScreen2.acceptPTTCall();
        callsScreen.launchVideoStreamingFromPTTScreen();
        callsScreen2.acceptAndEndsVideoStreamingFromPTTScreen();
        callsScreen.launchVoipCallFromOpenedConversation();
        voipScreenSecond.acceptVoipCall();
        callsScreen.launchVideoStreamingFromVoipScreen();
        callsScreen2.AcceptAndEndsVideoStreamingFromVoipScreen();


    }


    public void callsSTC27(String Account) throws InterruptedException, IOException {
        CallsScreen callsScreen = new CallsScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        ConversationScreen.GetUseCaseDescription("Calls_STC27", Constants.OneToOne_Video_CallSheetNumber, mLogger);
        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
       // callsScreen2.acceptPermission();
        conversationScreen.SelectContactConversation(Account);
        callsScreen.startVideoCall();
        callsScreen.checkDisplayOfItemsOfVideoCallScreen();

        callsScreen2.acceptVideoCall();
        callsScreen.checkItemsOfVideoCallScreen();


    }

    public void callsSTC28(String First_Account, String Second_Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC28", Constants.OneToOne_Video_CallSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);


        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        callsScreen.acceptPermission();
        //callsScreen2.acceptPermission();
        conversationScreen.SelectContactConversation(First_Account);
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        mDriver3 = mStwAppiumTest.getThirdDriver(mDriver.getPlatformName());

        callsScreen.startVideoCall();
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);

        callsScreen2.acceptVideoCall();

        callsScreen2.transferVideoCall(Second_Account);


        CallsScreen callsScreen3 = new CallsScreen(mDriver3);
        //callsScreen3.acceptPermission();
        callsScreen3.acceptTransferVideoCall();
        //callsScreen3.checkDisplayOfItemsOfVideoCallScreen();


    }

    public void callSTC3(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC3", Constants.ConferencecallSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2 = mStwAppiumTest.getSecondDriver(mDriver.getPlatformName());
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        //callsScreen2.acceptPermission();

        callsScreen.startConferenceCall(GroupAccount);
        mLogger.log(Status.INFO, " user A start conference with  a group  ");


        callsScreen.checkPopupOfOnDuty();

        callsScreen2.clickToAcceptConferenceCall();
        mLogger.log(Status.INFO, " user B accept the  conference   ");

        callsScreen.checkDisplayOfItemsOfConferenceCallScreen();
        callsScreen.checkItemsOfConferenceCallScreen();


    }


    public String getStatusOfUser() throws InterruptedException, IOException {
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);

        if (Platforms.IOS.equals(mDriver.getPlatformName())) {
            TabBarScreen tabBarScreen2 = new TabBarScreen(mDriver);
            SettingsScreen settingsScreen2 = new SettingsScreen(mDriver);


            CallsScreen CallsScreen2 = new CallsScreen(mDriver);
            tabBarScreen2.goToMore();
            settingsScreen2.getStatus().click();
            // CallsScreen2.PressOnElement("Status");
            //CallsScreen2.selectorToClick("Status");
            tabBarScreen2.goToContacts();
        } else {
            TabBarScreen tabBarScreen2 = new TabBarScreen(mDriver);

            tabBarScreen2.goToMore();
            tabBarScreen2.ElementToClick("Status", 0, 0).click();

        }
        String statusOfUser;

        if (settingsScreen.isElementDisplayed(settingsScreen.getStatus_OFF_Duty())) {
            mLogger.log(Status.INFO, " Status of second device is OFF duty ");
            statusOfUser = "OffDuty";

        } else {
            mLogger.log(Status.INFO, " Status of second device is On duty ");
            statusOfUser = "OnDuty";
        }


        return statusOfUser;
    }

}
