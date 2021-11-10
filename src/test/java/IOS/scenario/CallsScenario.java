package IOS.scenario;

import IOS.screen.ContactScreen;
import IOS.screen.DialerScreen;
import IOS.screen.PermissionsScreen;
import IOS.screen.Settings.SettingsScreen;
import IOS.screen.TabBarScreen;
import android.screen.CallsScreen;
import android.screen.ChannelScreen;
import android.screen.ConversationScreen;
import android.screen.VoipScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.net.MalformedURLException;

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

    public void Calls_STC17(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC17", Constants.External_Call_OutSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();


        callsScreen.selectCallBtnFromContact();
        callsScreen.launchDialerCall();
        callsScreen.pushPhoneNumberForDialerCall();


        callsScreen.checkDisplayOfItemsOfExternalCall();


    }

    public void Calls_STC4(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);


        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);

        callsScreen2.acceptPermission();
        callsScreen.selectConversationOneToOne(Account);
        mLogger.log(Status.PASS, "1 - A call B through PTT call ");
        callsScreen.startPTTCall();
        callsScreen2.acceptPTTCall();
        callsScreen.checkDisplayOfItemsOfPTTCall();

        callsScreen2.checkDisplayOfItemsOfPTTCall();


        callsScreen.goToConversationPTTBtn();
        callsScreen.checkDisplayOfPttSentence();


    }

    public void Calls_STC5(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();
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
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();


        callsScreen.selectGroupNewConversation(GroupAccount);

        callsScreen.startPTTCall();

        callsScreen.checkPopupOfOnDuty();

        callsScreen.checkDisplayOfItemsOfPTTCall();


        callsScreen2.acceptPTTCall();


        callsScreen.takeTheFloor();

        callsScreen.endPTTCall(mDriver);


    }

    public void Calls_STC8(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC8", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();

        callsScreen.launchGroupPTTCallFromContact(GroupAccount);

        mLogger.log(Status.PASS, "1 - A open user B conversation");


        callsScreen.checkPopupOfOnDuty();

        mLogger.log(Status.PASS, "2 - A call B through PTT call ");
        callsScreen2.acceptPTTCall();


        mLogger.log(Status.PASS, "2 - B accept the  call ");
        callsScreen.checkDisplayOfItemsOfPTTCall();

        callsScreen.endPTTCall(mDriver);


    }

    public void Calls_STC7(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC7", Constants.PushToTalk_OneToManySheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);

        callsScreen2.acceptPermission();

        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver2);


        ConversationScreen.GetUseCaseDescription("Calls_STC7", Constants.PushToTalk_OneToManySheetNumber, mLogger);
        int s = 0;
        while (s < 2) {
            String statusOfUser = callsScreen.getStatusOfUser();

            callsScreen.launchGroupPTTCallFromContact(GroupAccount);

            mLogger.log(Status.PASS, "1 - A open user B conversation");


            if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
                s = s + 1;

                callsScreen.callOnDutyContacts();

                if (statusOfUser.equals("OnDuty")) {
                    mLogger.log(Status.INFO, "ON duty ");

                    callsScreen2.acceptPTTCall();


                    mLogger.log(Status.PASS, "2 - B accept the  call ");
                    callsScreen2.endPTTCall(mDriver2);

                    callsScreen.endPTTCall(mDriver);


                } else {

                    mLogger.log(Status.INFO, "OFF duty ");

                    if (ConversationScreen2.isElementDisplayed(callsScreen2.getAcceptPTTCall()))
                        mLogger.log(Status.FAIL, "The call is received when status is OFF duty ");
                    else
                        mLogger.log(Status.PASS, "The call is not received when status is OFF duty ");

                    callsScreen.endPTTCall(mDriver);
                    Thread.sleep(3000);


                }


                mLogger.log(Status.PASS, "2 - B accept the  call ");
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


        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();
        callsScreen.openConversationWithSecondAccount(Account);
        callsScreen.launchVideoStreaming();
        callsScreen2.acceptVideoStreaming();
        callsScreen.checkDisplayOfItemsOfVideoStreaming();

    }

    public void callsSTC26(String Account) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC26", Constants.Video_StreamingSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();


        callsScreen.openConversationWithSecondAccount(Account);
        callsScreen.startPTTCall();
        callsScreen2.acceptPTTCall();
        callsScreen.launchVideoStreamingFromPTTScreen();
        callsScreen2.acceptAndEndsVideoStreamingFromPTTScreen();
        callsScreen.launchVoipCallFromOpenedConversation();
        callsScreen2.acceptVoipCall();
        callsScreen.launchVideoStreamingFromVoipScreen();
        callsScreen2.AcceptAndEndsVideoStreamingFromVoipScreen();


    }


    public void callsSTC27(String Account) throws InterruptedException, IOException {
        CallsScreen callsScreen = new CallsScreen(mDriver);

        ConversationScreen.GetUseCaseDescription("Calls_STC27", Constants.OneToOne_Video_CallSheetNumber, mLogger);
        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen.acceptPermission();
        callsScreen.openConversationWithSecondAccount(Account);
        callsScreen.startVideoCall();
        callsScreen2.acceptVideoCall();
        callsScreen.checkDisplayOfItemsOfVideoCallScreen();


    }

    public void callsSTC28(String First_Account, String Second_Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC28", Constants.OneToOne_Video_CallSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();
        callsScreen.openConversationWithSecondAccount(First_Account);
        callsScreen.startVideoCall();
        callsScreen2.acceptVideoCall();
        callsScreen.checkDisplayOfItemsOfVideoCallScreen();

        callsScreen.checkItemsOfVideoCallScreen();
        callsScreen2.transferVideoCall(Second_Account);
        mDriver3= callsScreen.createSessionForThirdDevice(mStwAppiumTest);


        CallsScreen callsScreen3 = new CallsScreen(mDriver3);
        callsScreen3.acceptPermission();
        callsScreen3.acceptTransferVideoCall(Second_Account);

    }

    public void callSTC3(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC3", Constants.ConferencecallSheetNumber, mLogger);
        CallsScreen callsScreen = new CallsScreen(mDriver);

        callsScreen.acceptPermission();
        mDriver2= callsScreen.createSessionForSecondDevice(mStwAppiumTest);
        CallsScreen callsScreen2 = new CallsScreen(mDriver2);
        callsScreen2.acceptPermission();

        callsScreen.startConferenceCall(GroupAccount);

        callsScreen.checkPopupOfOnDuty();

        callsScreen2.clickToAcceptConferenceCall();
        callsScreen.checkDisplayOfItemsOfConferenceCallScreen();
        callsScreen.checkItemsOfConferenceCallScreen();


    }





}
