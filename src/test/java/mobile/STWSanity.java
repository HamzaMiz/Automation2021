package mobile;

import framework.tester.STWAppiumTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import scenario.*;

import java.io.IOException;


@Listeners({framework.utils.listeners.TestListener.class,framework.utils.listeners.AnnotationTransformer.class })

public class STWSanity extends STWAppiumTest {


    public STWSanity(String platform, String branding) {
        super(platform, branding);
    }

    @Test(priority = 1)
    @Parameters({"companyID", "country", "phone", "bundleId"})
    public void login_STC3_STC4(String companyID, String country, String phone, @Optional("") String bundleId) throws InterruptedException, IOException {
        LoginScenario loginScenario = new scenario.LoginScenario(this, "Login_STC3",
                "Login with link");
        loginScenario.login_STC3_STC4(companyID, country, phone, bundleId);
    }

    @Test(priority = 74)
    public void login_STC5() throws InterruptedException, IOException {

        scenario.LogoutScenario logoutScenario = new scenario.LogoutScenario(this, "Login_STC5",
                "Logout");

        logoutScenario.login_STC5();
    }

    @Test(priority = 3)
    public void myBusiness_STC1() throws InterruptedException, IOException {


        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC1",
                "My Business tab : global display");

        mybusinessScenario.myBusiness_STC1();
    }

    @Test(priority = 4)
    @Parameters({"processName", "contact"})
    public void myBusiness_STC2(String processName, String contact) throws InterruptedException, IOException {


        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC2",
                "Send Process");

        mybusinessScenario.myBusiness_STC2(processName, contact);
    }

    @Test(priority = 5)
    public void myBusiness_STC4() throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC4", "My Business : Activity Tab");
        mybusinessScenario.myBusiness_STC4();

    }

    @Test(priority = 6)
    @Parameters({"processName"})
    public void myBusiness_STC5(String processName) throws InterruptedException, IOException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC5", "Search Process");

        mybusinessScenario.myBusiness_STC5(processName);

    }

    @Test(priority = 7)
    @Parameters({"widgetName"})
    public void myBusiness_STC7(String widgetName) throws InterruptedException, IOException {
        // this need contact widget
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC7",
                "Send Process");


        mybusinessScenario.myBusiness_STC7(widgetName);
    }

    @Test(priority = 8)
    @Parameters({"widgetName", "contact", "bundleId", "title"})
    public void myBusiness_STC15(String widgetName, String contact, String bundleId, String title) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC15",
                "upload file widget");
        mybusinessScenario.myBusiness_STC15(widgetName, contact, bundleId, title);
    }

    @Test(priority = 9)
    @Parameters({"widgetName"})
    public void myBusiness_STC16(String widgetName) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC16",
                "Start-Stop widget  (General Display)");
        mybusinessScenario.myBusiness_STC16(widgetName);
    }

    @Test(priority = 10)
    @Parameters({"widgetName", "location"})
    public void myBusiness_STC17(String widgetName, String location) throws InterruptedException, IOException {
        //this need process with Adress widget
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC17",
                "Address ");
        mybusinessScenario.myBusiness_STC17(widgetName, location);
    }

    @Test(priority = 11)
    public void mybusiness_STC37() throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC37", "Auto-Saving option is Activated");
        mybusinessScenario.mybusiness_STC37();

    }

    @Test(priority = 12)
    @Parameters({"processName",})
    public void mybusiness_STC60(String processName) throws IOException, InterruptedException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC60", "History icon display - In Progress Process");

        mybusinessScenario.mybusiness_STC60(processName);
    }

    @Test(priority = 13)
    @Parameters({"processName", "contact2"})
    public void mybusiness_STC61(String processName, String contact2) throws IOException, InterruptedException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC61", "History icon display - Submitted Process");

        mybusinessScenario.mybusiness_STC61(processName, contact2);
    }


    @Test(priority = 14)
    @Parameters({"groupToCall"})
    public void conversationSTC5(String groupToCall) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC5",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC5(groupToCall);
    }

    @Test(priority = 15)
    @Parameters({"processName", "contact", "contact2"})
    public void mybusiness_STC20(String processName, String contact, String contact2) throws InterruptedException, IOException {


        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC20",
                "Duplicate Button Displayed (Read Only Mode)");

        mybusinessScenario.mybusiness_STC20(processName, contact, contact2);
    }


    @Test(priority = 16)
    @Parameters({"processName", "contact"})
    public void myBusiness_STC21(String processName, String contact) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC21", "My Business : Actitvity > NEW");
        mybusinessScenario.mybusiness_STC21(processName, contact);

    }

    @Test(priority = 17)
    @Parameters({"processName"})
    public void myBusiness_STC29(String processName) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC29",
                "PProcess completed at the initiation step");

        mybusinessScenario.myBusiness_STC29(processName);
    }

    @Test(priority = 18)
    @Parameters({"processName", "contact"})
    public void myBusiness_STC30(String processName, String contact) throws InterruptedException, IOException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC30",
                "Process completed at the initiation step (at least on contact selected from the recipient list)");


        mybusinessScenario.mybusiness_STC30(processName, contact);
    }

    @Test(priority = 19)
    @Parameters({"processName", "contact", "group"})
    public void myBusiness_STC33(String processName, String contact, String group) throws InterruptedException, IOException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC33",
                "Process submitted by the initiator");

        mybusinessScenario.mybusiness_STC33(processName, contact, group);
    }

    @Test(priority = 73)
    @Parameters({"processName", "contact2", "bundleId"})
    public void myBusiness_STC36(String processName, String contact2, @Optional("") String bundleId) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC36",
                "Submit a process when No internet connexion");

        mybusinessScenario.mybusiness_STC36(processName, contact2, bundleId);
    }


    @Test(priority = 20)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC43(String processName, String contact2) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC43",
                "Conversation already created for the Process");
        mybusinessScenario.myBusiness_STC43(processName, contact2);
    }

    @Test(priority = 21)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC45(String processName, String contact2) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC45",
                "Delete My Business Conversations ");
        mybusinessScenario.myBusiness_STC45(processName, contact2);
    }

    @Test(priority = 22)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC46(String processName, String contact2) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC46",
                "The Process Is Completed");
        mybusinessScenario.myBusiness_STC46(processName, contact2);
    }

    @Test(priority = 23)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC47(String processName, String contact2) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC47",
                "Edit Process Name (Process submitted by User B)");
        mybusinessScenario.myBusiness_STC47(processName, contact2);
    }

    @Test(priority = 24)
    @Parameters({"processName", "contact"})
    public void myBusiness_STC27_28(String processName, String contact) throws IOException, InterruptedException {
        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC27", "verify if canceled process is in the Canceled tab");

        mybusinessScenario.mybusiness_STC27_28(processName, contact);
        // the user should send the process to himself
    }

    @Test(priority = 25)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC19(String processName, String contact2) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC19", "verify if process is in submit category");

        mybusinessScenario.myBusiness_STC19(processName, contact2);
    }


    @Test(priority = 26)
    @Parameters({"processName"})
    public void myBusiness_STC24(String processName) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC24", "verify the display of Schedule option and details");

        mybusinessScenario.myBusiness_STC24(processName);

    }

    @Test(priority = 27)
    @Parameters({"widgetName", "contact"})
    public void myBusiness_STC25(String widgetName, String contact) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC25",
                "Use info from previous process");

        mybusinessScenario.myBusiness_STC25(widgetName, contact);
    }

    @Test(priority = 28)
    @Parameters({"widgetName"})
    public void myBusiness_STC26(String widgetName) throws InterruptedException, IOException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "MyBusiness_STC26",
                "Logic of Process instance name Display - Display Mode");
        mybusinessScenario.myBusiness_STC26(widgetName);
    }

    @Test(priority = 29)
    @Parameters({"processName"})
    public void myBusiness_STC38(String processName) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC38", "verify the manual save of a process");

        mybusinessScenario.myBusiness_STC38(processName);

        // in order for this methode to work, the process needs to have a text area first widget
    }


    @Test(priority = 30)
    @Parameters({"processName"})
    public void myBusiness_STC39(String processName) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC39", "verify the auto-save of a process");

        mybusinessScenario.myBusiness_STC39(processName);

        // in order for this methode to work, the process needs to have a text area first widget
        // there s a two minute wait to test the auto save

    }

    @Test(priority = 31)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC63(String processName, String contact2) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC63", "verify the display of details in process history for a scheduled process");

        mybusinessScenario.myBusiness_STC63(processName, contact2);


    }


    @Test(priority = 32)
    @Parameters({"processName", "contact2"})
    public void myBusiness_STC64(String processName, String contact2) throws IOException, InterruptedException {

        scenario.MybusinessScenario mybusinessScenario = new scenario.MybusinessScenario(this, "myBusiness_STC64", "verify the display of stop repeating option in a submitted repeated option");
        mybusinessScenario.myBusiness_STC64(processName, contact2);
    }


    @Test(priority = 33)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC1(String accountOfSecondDevice) throws InterruptedException, IOException {
        VoipScenario voipScenario = new VoipScenario(this, "Calls_STC1",
                "Introduction to VoIP calls");
        voipScenario.Calls_STC1(accountOfSecondDevice);
    }

    @Test(priority = 34)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC4(String accountOfSecondDevice) throws InterruptedException, IOException {
      /*CallsScenario callsScenario = new  CallsScenario(this, "Calls_STC4",
                "PTT One to One");*/

        CallsScenario callsScenario = new CallsScenario(this, "Calls_STC4",
                "PTT One to One");
        callsScenario.Calls_STC4(accountOfSecondDevice);
    }

    @Test(priority = 35)
    @Parameters({"accountOfSecondDevice", "bundleId", "titleOfEvent"})
    public void conversationSTC3(String accountOfSecondDevice, @Optional("") String bundleId, String titleOfEvent) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC3",
                "Conversation One to One ");
        ConversationScenario.conversationSTC3(accountOfSecondDevice, bundleId, titleOfEvent);
    }

    @Test(priority = 36)
    @Parameters({"accountOfSecondDevice"})
    public void conversationSTC2(String accountOfSecondDevice) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC2",
                "Conversation One to One ");
        ConversationScenario.conversationSTC2(accountOfSecondDevice);
    }

    @Test(priority = 37)
    public void conversationSTC1() throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC1",
                "Conversation One to One ");
        ConversationScenario.conversationSTC1();
    }

    @Test(priority = 38)
    @Parameters({"groupToCall", "accountOfSecondDevice", "bundleId", "titleOfEvent"})
    public void conversationSTC8(String groupToCall, String accountOfSecondDevice, @Optional("") String bundleId, String titleOfEvent) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC8",
                "Conversation One to Many ");
        ConversationScenario.conversationSTC8(groupToCall, accountOfSecondDevice, bundleId, titleOfEvent);
    }

    @Test(priority = 39)
    @Parameters({"groupToCall"})
    public void conversationSTC7(String groupToCall) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC7",
                "Conversation One to Many ");
        ConversationScenario.conversationSTC7(groupToCall);
    }

    @Test(priority = 40)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void conversationSTC9(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC9",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC9(accountOfSecondDevice, accountOfThirdDevice);
    }


    @Test(priority = 41)
    @Parameters({"groupToCall"})
    public void conversationSTC6(String groupToCall) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario = new scenario.ConversationScenario(this, "Conversation_STC6",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC6(groupToCall);
    }

    @Test(priority = 42)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC5(String accountOfSecondDevice) throws InterruptedException, IOException {
      /*CallsScenario callsScenario = new  CallsScenario(this, "Calls_STC4",
                "PTT One to One");*/

        CallsScenario callsScenario = new CallsScenario(this, "Calls_STC5",
                "PTT One to One");
        callsScenario.Calls_STC5(accountOfSecondDevice);
    }

    @Test(priority = 43)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC27(String accountOfSecondDevice) throws InterruptedException, IOException {
        scenario.CallsScenario CallsScenario = new scenario.CallsScenario(this, "Calls_STC27",
                "Video Call");
        CallsScenario.callsSTC27(accountOfSecondDevice);
    }


    @Test(priority = 44)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void callsSTC28(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        scenario.CallsScenario CallsScenario = new scenario.CallsScenario(this, "Calls_STC28",
                "Video call");
        CallsScenario.callsSTC28(accountOfSecondDevice, accountOfThirdDevice);
    }

    @Test(priority = 45)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC25(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC25",
                "Video Broadcast ");
        CallsScenario.callsSTC25(accountOfSecondDevice);
    }

    @Test(priority = 47)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC26(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC26",
                "Video Broadcast ");
        CallsScenario.callsSTC26(accountOfSecondDevice);
    }

    @Test(priority = 48)
    @Parameters({"groupToCall"})
    public void callsSTC8(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC8",
                "PTT group ");
        CallsScenario.Calls_STC8(groupToCall);
    }

    @Test(priority = 49)
    @Parameters({"groupToCall"})
    public void callsSTC7(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC7",
                "PTT group ");
        CallsScenario.Calls_STC7(groupToCall);
    }

    @Test(priority = 50)
    @Parameters({"groupToCall"})
    public void callsSTC9(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC9",
                "PTT group ");
        CallsScenario.Calls_STC9(groupToCall);
    }

    @Test(priority = 51)
    @Parameters({"groupToCall"})
    public void callsSTC6(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC6",
                "PTT group ");
        CallsScenario.Calls_STC6(groupToCall);
    }


    @Test(priority = 52)
    @Parameters({"groupToCall"})
    public void callsSTC3(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC3",
                "Conference Call ");
        CallsScenario.callSTC3(groupToCall);
    }

    @Test(priority = 53)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC16(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC16",
                "External call via PBX ");
        CallsScenario.Calls_STC16(accountOfSecondDevice);
    }

    @Test(priority = 54)
    public void callsSTC17() throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC17",
                "Dialer call ");
        CallsScenario.Calls_STC17();
    }


    @Test(priority = 55)
    public void Contact_STC1() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC1",
                "check contact screen details");


        contactScenario.Contact_STC1();
    }

    @Test(priority = 56)
    public void Contact_STC2() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC2",
                "check contact screen details");


        contactScenario.Contact_STC2();
    }

    @Test(priority = 57)
    @Parameters({"accountOfSecondDevice"})
    public void Contact_STC3(String accountOfSecondDevice) throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC3",
                "check contact option");

        contactScenario.Contact_STC3(accountOfSecondDevice);
    }

    @Test(priority = 58)
    public void Contact_STC4() throws IOException, InterruptedException {
        ContactScenario ContactScenario = new ContactScenario(this, "Contact_STC4", "verify contact option and Details UI screen");
        ContactScenario.Contact_STC4();

    }

    @Test(priority = 59)
    @Parameters({"accountOfSecondDevice"})
    public void Contact_STC5(String accountOfSecondDevice) throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC5",
                "Search user from contact list ");

        contactScenario.Contact_STC5(accountOfSecondDevice);
    }
    @Parameters({"accountOfSecondDevice"})
    @Test(priority = 60)
    public void Contact_STC7() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC7",
                "Contact availability icon");

        contactScenario.Contact_STC7();
    }

    @Test(priority = 61)
    public void Calls_STC10() throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC10",
                "check Channel main screen ");
        ChannelScenario.Calls_STC10();
        //ChannelScenario.doSearchTalkgroup();
    }
    @Parameters({"groupToCall"})
    @Test(priority = 62)
    public void Calls_STC11(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC11",
                "check Channel talk screen ");
        ChannelScenario.Calls_STC11(groupToCall);

    }
    @Parameters({"groupToCall"})
    @Test(priority = 63)
    public void Calls_STC15(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC15",
                "transmit permission ");
        ChannelScenario.Calls_STC15(groupToCall);

    }
    @Parameters({"groupToCall"})
    @Test(priority = 64)
    public void Calls_STC12(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC12",
                "check Channel take the floor modes ");
        ChannelScenario.Calls_STC12(groupToCall);

    }


    @Test(priority = 65)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void Calls_STC2(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        VoipScenario voipScenario = new VoipScenario(this, "Calls_STC2",
                "Transfer Voip call");

        voipScenario.Calls_STC2(accountOfSecondDevice, accountOfThirdDevice);
    }


    @Test(priority = 66)
    public void Settings_STC1() throws InterruptedException, IOException {
        SettingsScenario settingsScenario = new SettingsScenario(this, "Settings_STC1",
                "Settings");
        settingsScenario.settings_stc1();
    }


    @Test(priority = 67)
    public void Settings_STC2() throws InterruptedException, IOException {
        SettingsScenario settingsScenario = new SettingsScenario(this, "Settings_STC2",
                "Settings");
        settingsScenario.settings_stc2();
    }

    @Test(priority = 68)
    public void Calls_STC18() throws InterruptedException, IOException {
        EmergencyMessageScenario emergencyMessageScenario = new EmergencyMessageScenario(this, "Calls_STC18",
                "Emergency message STC18");
        emergencyMessageScenario.doEmergencyMessage_STC18();
    }

    @Test(priority = 70)
    public void Calls_STC19() throws InterruptedException, IOException {
        EmergencyMessageScenario emergencyMessageScenario = new EmergencyMessageScenario(this, "Calls_STC19",
                "Emergency message STC19");
        emergencyMessageScenario.doEmergencyMessage_STC19();
    }

    @Test(priority = 71)
    public void Calls_STC20() throws InterruptedException, IOException {
        EmergencyCallScenario emergencyCallScenario = new EmergencyCallScenario(this, "Calls_STC20",
                "Emergency call STC20");
        emergencyCallScenario.doEmergencyCall_STC20();
    }


    @Test(priority = 72)
    public void Calls_STC21() throws InterruptedException, IOException {
        EmergencyCallScenario emergencyCallScenario = new EmergencyCallScenario(this, "Calls_STC21",
                "Emergency call STC21");
        emergencyCallScenario.doEmergencyCall_STC21();
    }

}
