package android.scenario;

import android.screen.*;
import android.screen.settings.SettingsScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CallsScenario extends STWScenario {

    public CallsScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void Calls_STC4(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);

        dismissAlerts(mDriver);
        createSessionForSecondDevice();
        dismissAlerts(mDriver2);

        selectConversationOneToOne(Account);
        startPTTCall();
        acceptPTTCall();
        checkDisplayOfItemsOfPTTCall();

        checkDisplayOfItemsOfPTTCall();

        goToConversationPTTBtn();
        checkDisplayOfPttSentence();


    }

    public void Calls_STC5(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC4", Constants.PushToTalk_OneToOneSheetNumber, mLogger);
        createSessionForSecondDevice();
        dismissAlerts(mDriver2);

        dismissAlerts(mDriver);
        selectConversationOneToOne(Account);
        startPTTCall();
        acceptPTTCall();
        checkDisplayOfItemsOfPTTCall();
        checkItemsOfPTTCall();


    }


    public void Calls_STC27(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC27", Constants.OneToOne_Video_CallSheetNumber, mLogger);

        createSessionForSecondDevice();


        dismissAlerts(mDriver2);


        dismissAlerts(mDriver);
        openConversationWithSecondAccount(Account);
        startVideoCall();
        acceptVideoCall();
        checkDisplayOfItemsOfVideoCallScreen();

    }


    public void Calls_STC28(String First_Account, String Second_Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC28", Constants.OneToOne_Video_CallSheetNumber, mLogger);

        createSessionForSecondDevice();
        dismissAlerts(mDriver2);
        dismissAlerts(mDriver);
        openConversationWithSecondAccount(First_Account);
        startVideoCall();
        acceptVideoCall();
        checkDisplayOfItemsOfVideoCallScreen();
        checkItemsOfVideoCallScreen(Second_Account);


    }


    public void Calls_STC25(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC25", Constants.Video_StreamingSheetNumber, mLogger);

        createSessionForSecondDevice();
        dismissAlerts(mDriver2);
        dismissAlerts(mDriver);
        openConversationWithSecondAccount(Account);
        launchVideoStreaming();
        acceptVideoStreaming();
        checkDisplayOfItemsOfVideoStreaming();

    }

    public void Calls_STC26(String Account) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC26", Constants.Video_StreamingSheetNumber, mLogger);

        createSessionForSecondDevice();
        dismissAlerts(mDriver2);


        dismissAlerts(mDriver);
        openConversationWithSecondAccount(Account);
        startPTTCall();
        acceptPTTCall();
        launchVideoStreamingFromPTTScreen();
        launchVideoStreamingFromVoipScreen();

    }

    public void Calls_STC8(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC8", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        createSessionForSecondDevice();

        dismissAlerts(mDriver2);


        dismissAlerts(mDriver);
        startPTTGroupCall(GroupAccount);
        checkPopupOfOnDuty();

        checkDisplayOfItemsOfPTTCall();

        acceptPTTCall();


        endPTTCall(mDriver);

    }

    public void Calls_STC7(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC7", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        createSessionForSecondDevice();
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);

        ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver2);

        dismissAlerts(mDriver2);

        int s = 0;
        while (s < 2) {
            String statusOfUser = getStatusOfUser();


            dismissAlerts(mDriver);
            startPTTGroupCall(GroupAccount);
            if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
                s = s + 1;

                callOnDutyContacts();

                if (statusOfUser.equals("OnDuty")) {
                    mLogger.log(Status.INFO, "ON duty ");

                    acceptPTTCall();


                    endPTTCall(mDriver2);
                    endPTTCall(mDriver);

                } else {
                    mLogger.log(Status.INFO, "OFF duty ");

                    if (ConversationScreen2.isElementDisplayed(CallsScreen2.getAcceptPTTCall()))
                        mLogger.log(Status.FAIL, "The call is received when status is OFF duty ");
                    else
                        mLogger.log(Status.PASS, "The call is not received when status is OFF duty ");

                    endPTTCall(mDriver);


                }

            } else {
                s = 2;
                mLogger.log(Status.FAIL, " Pop_up_Of_OnDuty() option is NOT displayed, please enable Reach only On Duty users from web admin for group " + GroupAccount);
            }


        }

    }


    public void Calls_STC9(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC9", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        dismissAlerts(mDriver);
        startPTTGroupCall(GroupAccount);

        if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
            CheckOnDutyConversation();
        } else
            mLogger.log(Status.PASS, "Pop_up_Of_OnDuty() option is displayed  is not displayed, please check the administrator ");


    }


    public void Calls_STC6(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC6", Constants.PushToTalk_OneToManySheetNumber, mLogger);

        dismissAlerts(mDriver);

        createSessionForSecondDevice();
        dismissAlerts(mDriver2);
        startPTTGroupCall(GroupAccount);
        checkPopupOfOnDuty();


        checkDisplayOfItemsOfPTTCall();

        acceptPTTCall();


        takeTheFloor();
        endPTTCall(mDriver);


    }


    public void Calls_STC3(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Calls_STC3", Constants.ConferencecallSheetNumber, mLogger);

        createSessionForSecondDevice();

        dismissAlerts(mDriver2);

        dismissAlerts(mDriver);
        startConferenceCall(GroupAccount);
        checkPopupOfOnDuty();
        clickToAcceptConferenceCall();
        checkDisplayOfItemsOfConferenceCallScreen();
        checkItemsOfConferenceCallScreen();


    }

    public void Calls_STC16(String Account) throws InterruptedException, IOException {


        ConversationScreen.GetUseCaseDescription("Calls_STC16", Constants.External_Call_OutSheetNumber, mLogger);
        dismissAlerts(mDriver);
        selectConversationOneToOne(Account);
        launchCallsFromConversation();
        launchExternalCallFromConversation();
        checkDisplayOfItemsOfExternalCall();

    }

    public void Calls_STC17() throws InterruptedException, IOException {
        ConversationScreen.GetUseCaseDescription("Calls_STC17", Constants.External_Call_OutSheetNumber, mLogger);
        dismissAlerts(mDriver);
        goToContactsTab();
        selectCallBtnFromContact();
        pushPhoneNumberForDialerCall();
        checkDisplayOfItemsOfExternalCall();

    }

    public void dismissAlerts(AppiumDriver driver) {
        ConversationScreen ConversationScreen = new ConversationScreen(driver);

        ConversationScreen.dismissAlert();
    }

    public void goToContactsTab() throws InterruptedException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.getContactItem();


    }

    public void selectCallBtnFromContact() throws InterruptedException, IOException {
        ContactScreen contactScreen = new ContactScreen(mDriver);


        contactScreen.getCallButton().click();
        contactScreen.getDialer().click();

    }

    public void pushPhoneNumberForDialerCall() throws InterruptedException {
        DialerScreen DialerScreen = new DialerScreen(mDriver);


        DialerScreen.getNine().click();
        DialerScreen.getTwo().click();
        DialerScreen.getSeven().click();
        DialerScreen.getEight().click();
        DialerScreen.getSex().click();
        DialerScreen.getEight().click();
        DialerScreen.getEight().click();
        DialerScreen.getEight().click();
        DialerScreen.getCall_Dialer().click();


        Thread.sleep(3000);
    }

    public void checkDisplayOfItemsOfExternalCall() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalSpeakersBtn(), "Speaker");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalMuteBtn(), "Mute");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDialerBtn(), "Dialer");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalDismissBtn(), "Go back");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getExternalRejectBtn(), "End call");

    }


    public void selectConversationOneToOne(String Account) throws InterruptedException, IOException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();

        ConversationScreen.getConversationNewMessage().click();
        ConversationScreen.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen.getSearchContactTextField().sendKeys(Account);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(Account, 0, 1).click();
        ConversationScreen.getCheckButton().click();
    }

    public void launchCallsFromConversation() {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        conversationScreen.getCallButton().click();

    }

    public void launchExternalCallFromConversation() throws InterruptedException {
        ContactScreen contactScreen = new ContactScreen(mDriver);

        mLogger.log(Status.PASS, "1 - User A  call user B via PBX");

        contactScreen.getCallOutPBX().click();
        Thread.sleep(3000);
    }

    public void createSessionForSecondDevice() {
        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);
        mDriver2.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public void startConferenceCall(String GroupAccount) throws InterruptedException, MalformedURLException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen callsScreen = new CallsScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen.getConversationNewCall().click();
        ConversationScreen.getConference_Call().click();


        ConversationScreen.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(GroupAccount, 0, 1).click();
        ConversationScreen.getCheckButton().click();

    }

    public void checkPopupOfOnDuty() throws InterruptedException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        if (ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty())) {
            mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");
            CallsScreen.getCall_All_group_contacts().click();
            Thread.sleep(2000);
        }
        Thread.sleep(5000);
    }

    public void clickToAcceptConferenceCall() {
        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);

        CallsScreen2.getAcceptConferenceCall().click();
    }

    public void checkItemsOfConferenceCallScreen() throws IOException, InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        Thread.sleep(3000);
        CallsScreen.getConference_call_speaker_btn().click();
        Thread.sleep(3000);
        CallsScreen.getConference_call_speaker_btn().click();
        CallsScreen.getConference_call_mute_btn().click();
        Thread.sleep(3000);
        CallsScreen.getConference_call_geoloc_btn().click();
        Thread.sleep(5000);
        CallsScreen.back();
        CallsScreen.getConference_call_video_streaming_button().click();
        // CallsScreen.back();

        CallsScreen.getConference_call_reject_btn().click();

    }

    public void checkDisplayOfItemsOfConferenceCallScreen() throws IOException, InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_add_contact_btn(), "Add contact");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_video_streaming_button(), "Video streaming");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_go_to_conversation_btn(), "Go to conversation");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_contact_details_btn(), "Contact details");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_mute_btn(), "Mute");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_geoloc_btn(), "Geolocation");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_speaker_btn(), "Speaker");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getConference_call_back_btn(), "Dismiss");
        Thread.sleep(3000);
    }

    public void startPTTGroupCall(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen.getConversationNewCall().click();
        ConversationScreen.getPush_To_Talk().click();

        ConversationScreen.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(GroupAccount, 0, 1).click();
        ConversationScreen.getCheckButton().click();
        mLogger.log(Status.PASS, "1 - A call B through PTT call ");
        Thread.sleep(3000);
    }

    public void checkDisplayOfItemsOfPTTCall() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        Thread.sleep(5000);

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_addContactBtn(), "Add contact");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_VideoStreamingBtn(), "Video streaming");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_GoToConversation(), "Go to conversation");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_ContactDetailsBtn(), "Contact details");

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_geolocBtn(), "Geolocation");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_TakeTheFloor(), "Take the floor");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_SpeakerBTN(), "Speaker");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_Account_image(), "Account image");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getPTT_BackButton(), "Dismiss");


    }

    public void acceptPTTCall() throws InterruptedException {

        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);
        Thread.sleep(5000);

        CallsScreen2.getAcceptPTTCall().click();
        Thread.sleep(3000);


    }

    public void takeTheFloor() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        Thread.sleep(3000);
        CallsScreen.LonPressOnElement(CallsScreen.getPTT_TakeTheFloor());
        Thread.sleep(3000);
    }


    public void endPTTCall(AppiumDriver driver) throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(driver);


        CallsScreen.getEnd_PTT_Call().click();

        Thread.sleep(3000);


    }


    public void CheckOnDutyConversation() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        mLogger.log(Status.INFO, " Pop_up_Of_OnDuty() option is displayed ");
        CallsScreen.getCall_On_Duty_contacts().click();
        Thread.sleep(2000);
        CallsScreen.getPTT_GoToConversation().click();
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getSent_To_On_Duty_Users_Toast(), "an information bar on top of the  conversation thread : 'Sent to only on duty users'");
        CallsScreen.getSent_To_On_Duty_Users_Toast().click();
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getAlertTitle(), "Alert title");


    }


    public String getStatusOfUser() throws InterruptedException, IOException {
        TabBarScreen tabBarScreen2 = new TabBarScreen(mDriver2);

        tabBarScreen2.getMoreItem();
        SettingsScreen settingsScreen2 = new SettingsScreen(mDriver2);
        tabBarScreen2.ElementToClick("Status", 0, 0).click();
        String statusOfUser;

        if (settingsScreen2.isElementDisplayed(settingsScreen2.getStatus_OFF_Duty())) {
            mLogger.log(Status.INFO, " Status of second device is OFF duty ");
            statusOfUser = "OffDuty";

        } else {
            mLogger.log(Status.INFO, " Status of second device is On duty ");
            statusOfUser = "OnDuty";
        }
        return statusOfUser;

    }


    public void callOnDutyContacts() throws InterruptedException {
        CallsScreen callsScreen = new CallsScreen(mDriver);


        callsScreen.getPop_up_Of_OnDuty().click();
        mLogger.log(Status.PASS, "2 - A call B through PTT call ");
        Thread.sleep(5000);
    }


    public void openConversationWithSecondAccount(String Account) throws InterruptedException, MalformedURLException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        tabBarScreen.getMessageItem();

        ConversationScreen.getConversationNewMessage().click();
        ConversationScreen.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen.getSearchContactTextField().sendKeys(Account);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(Account, 0, 1).click();
        ConversationScreen.getCheckButton().click();
    }


    public void launchVideoStreamingFromVoipScreen() throws InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        CallsScreen.getStopVideoStreaming().click();

        conversationScreen.getCallButton().click();
        conversationScreen.getCall().click();
        VoipScreen VoipScreenSecond = new VoipScreen(mDriver2);
        Thread.sleep(3000);
        VoipScreenSecond.getAccept().click();
        mLogger.log(Status.PASS, "A call B through Voip call ");
        VoipScreenSecond.getVideoStreaming().click();
        CallsScreen.getAcceptVideoBroadcast().click();
        Thread.sleep(3000);
        VoipScreenSecond.getEnd_Button().click();
        Thread.sleep(3000);
        CallsScreen.getStopVideoStreaming().click();
        mLogger.log(Status.PASS, "Test Video braodcast through Voip call passed ");
    }

    public void startPTTCall() throws InterruptedException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

        mLogger.log(Status.PASS, "1 - A call B through PTT call ");
        ConversationScreen.getPTTOneToOne().click();
        Thread.sleep(5000);


    }


    public void launchVideoStreamingFromPTTScreen() throws InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        CallsScreen.getPTT_VideoStreamingBtn().click();

        Thread.sleep(2000);
        acceptVideoStreaming();
        EndPTTCall();
        EndVideoStreaming();

    }

    public void acceptVideoStreaming() {
        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);

        CallsScreen2.getAcceptVideoBroadcast().click();
        mLogger.log(Status.PASS, " User B accept's Video streaming ");


    }

    public void EndPTTCall() {
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        CallsScreen.getEnd_PTT_Call().click();
    }

    public void EndVideoStreaming() throws InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);


        CallsScreen.getStopVideoStreaming().click();

        Thread.sleep(2000);


    }

    public void launchVideoStreaming() {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        mLogger.log(Status.PASS, "1 - A call B through Video Streaming ");

        conversationScreen.getConversationNewCall().click();
        conversationScreen.getBroadcast_Video().click();


    }

    public void checkDisplayOfItemsOfVideoStreaming() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Bar(), "Video_Broadcast_Bar");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_Stop_Btn(), "Video_Broadcast Stop");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideo_Broadcast_header_icon(), "Video_Broadcast_Bar icon");


    }

    public void startVideoCall() throws InterruptedException {
        ConversationScreen ConversationScreen = new ConversationScreen(mDriver);

        ConversationScreen.getConversationNewCall().click();
        ConversationScreen.getVideo_Call().click();
        mLogger.log(Status.PASS, "1 - A call B video call ");

        Thread.sleep(5000);
    }

    public void acceptVideoCall() {
        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);
        CallsScreen2.getAcceptVideoCall().click();

    }


    public void checkDisplayOfItemsOfVideoCallScreen() throws IOException, InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        mLogger.log(Status.PASS, "2 - B accept the  call ");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_geolocation_btn(), "Geolocation");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_Mute(), "Mute");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_speaker_btn(), "Speaker");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_back_btn(), "Go back");
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getVideoCall_go_to_conversation_btn(), "Go to conversation");

    }


    public void checkItemsOfVideoCallScreen(String Second_Account) throws IOException, InterruptedException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        CallsScreen CallsScreen2 = new CallsScreen(mDriver2);

        ConversationScreen ConversationScreen2 = new ConversationScreen(mDriver2);

        //Sanity check For Video call screen

        CallsScreen.getVideoCall_speaker_btn().click();
        //Thread.sleep(3000);
        CallsScreen.getVideoCall_speaker_btn().click();
        CallsScreen.getVideoCall_Mute().click();
        Thread.sleep(3000);
        CallsScreen.getVideoCall_Screen().click();
        Thread.sleep(3000);

        CallsScreen.getVideoCall_Mute().click();
        CallsScreen.getVideoCall_geolocation_btn().click();
        dismissAlerts(mDriver);
        Thread.sleep(5000);
        CallsScreen.back();
        CallsScreen.getVideoCall_Screen().click();
        CallsScreen.getVideoCall_go_to_conversation_btn().click();
        mLogger.log(Status.PASS, "3 - Users A & B excute a sanity check on call view ");
        CallsScreen2.getVideoCall_Screen().click();
        CallsScreen2.getTransfert_videoCall_Btn().click();
        ConversationScreen2.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen2.getSearchContactTextField().sendKeys(Second_Account);
        createSessionForThirdDevice();
        CallsScreen CallsScreen3 = new CallsScreen(mDriver3);
        dismissAlerts(mDriver3);

        Thread.sleep(3000);
        ConversationScreen2.ElementToClick(Second_Account, 0, 1).click();
        ConversationScreen2.getCheckButton().click();
        mLogger.log(Status.PASS, "4 - B transfer the   video call to user C ");


        Thread.sleep(3000);

        CallsScreen3.getAcceptVideoCall().click();


        Thread.sleep(3000);
        mLogger.log(Status.PASS, "5 - C accept the  call from B ");
        CallsScreen3.getVideoCall_reject_call_btn().click();
        mLogger.log(Status.PASS, "6 - B end the  call  ");
    }

    public void createSessionForThirdDevice() {
        mDriver3 = mStwAppiumTest.getSecondDriver(Platforms.ANDROID);

    }


    public void checkItemsOfPTTCall() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);

        mLogger.log(Status.PASS, "A & B have  an  ongoing PTT call");
        CallsScreen.getPTT_addContactBtn().click();
        Thread.sleep(2000);
        CallsScreen.back();
        Thread.sleep(2000);


        CallsScreen.getPTT_ContactDetailsBtn().click();
        Thread.sleep(2000);
        if (CallsScreen.isElementDisplayed(CallsScreen.getPTT_ListofContactDetails()))
            CallsScreen.getPTT_OK_ListContact().click();
        Thread.sleep(2000);

        CallsScreen.getPTT_geolocBtn().click();
        Thread.sleep(5000);
        CallsScreen.back();
        Thread.sleep(2000);

        CallsScreen.getPTT_SpeakerBTN().click();
        Thread.sleep(2000);
        mLogger.log(Status.PASS, "3 - A take the  floor");

        CallsScreen.LonPressOnElement(CallsScreen.getPTT_TakeTheFloor());
        mLogger.log(Status.PASS, "4 - A release the  floor");

        CallsScreen.getPTT_VideoStreamingBtn().click();
        Thread.sleep(2000);

        CallsScreen.getPTT_GoToConversation().click();
        CallsScreen.getStopVideoStreaming().click();


        CallsScreen.CheckDisplayedOfString("Outgoing Push-To-Talk", 0, 0, mLogger);


    }


    public void goToConversationPTTBtn() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        Thread.sleep(3000);
        CallsScreen.getPTT_GoToConversation().click();


    }

    public void checkDisplayOfPttSentence() throws InterruptedException, IOException {
        CallsScreen CallsScreen = new CallsScreen(mDriver);
        Thread.sleep(3000);
        CallsScreen.CheckDisplayedOfElement(CallsScreen.getIncomingPttSentence(), "Outgoing PTT calls ");
        mLogger.log(Status.PASS, "3 - A & B check the  notification center ");


    }
}
