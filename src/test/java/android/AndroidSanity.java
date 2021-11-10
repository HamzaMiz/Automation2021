package android;

import android.scenario.*;
import framework.Constants;
import framework.tester.STWAppiumTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(framework.utils.listeners.TestListener.class)
public class AndroidSanity extends STWAppiumTest {


    public AndroidSanity(String platform, String branding) {
        super(platform, branding);
    }

       @Test(priority = 1)
        @Parameters({"companyID", "country", "phone","bundleId"})
        public void Login_STC3_STC4(String companyID,String country, String phone,@Optional("")String bundleId) throws InterruptedException, IOException {
          //  LoginScenario loginScenario = new LoginScenario(this, "Login_STC3",
               //     "Login with link");
            scenario.LoginScenario loginScenario1 = new scenario.LoginScenario(this, "Login_STC3",
                    "Login with link");
            loginScenario1.login_STC3_STC4(companyID, country, phone, bundleId);

        }
    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice","bundleId","titleOfEvent"})
    public void conversationSTC3(String accountOfSecondDevice,String bundleId,String titleOfEvent ) throws InterruptedException, IOException {
      ConversationScenario  ConversationScenario = new ConversationScenario(this, "Conversation_STC3",
                "Conversation One to One");


        ConversationScenario.Conversation_STC3(accountOfSecondDevice,bundleId);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void conversationSTC2(String accountOfSecondDevice) throws InterruptedException, IOException {
      ConversationScenario ConversationScenario = new ConversationScenario(this, "Conversation_STC2",
                "Conversation One to One");


        ConversationScenario.Conversation_STC2(accountOfSecondDevice);
    }

    @Test(priority = 1)
    public void Contact_STC1() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC1",
                "check contact screen details");


        contactScenario.Contact_STC1();
    }

    @Test(priority = 1)
    public void Contact_STC3() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC3",
                "check contact option");

        contactScenario.Contact_STC3(Constants.AccountOfSecondDevice);
    }

    @Test(priority = 1)
    public void Contact_STC5() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC5",
                "Search user from contact list ");

        contactScenario.Contact_STC5(Constants.AccountOfSecondDevice);
    }

    @Test(priority = 1)
    public void Contact_STC7() throws InterruptedException, IOException {
        ContactScenario contactScenario = new ContactScenario(this, "Contact_STC7",
                "Contact availability icon");

        contactScenario.Contact_STC7(Constants.AccountOfSecondDevice);
    }


    @Test(priority = 1)
    public void Calls_STC10() throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC10",
                "check Channel main screen ");
        ChannelScenario.Calls_STC10();
        //ChannelScenario.doSearchTalkgroup();
    }

    @Test(priority = 1)
    public void Calls_STC11(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC11",
                "check Channel talk screen ");
        ChannelScenario.Calls_STC11(groupToCall);

    }
    @Test(priority = 1)
    public void Calls_STC15(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC15",
                "transmit permission ");
        ChannelScenario.Calls_STC15(groupToCall);

    }
    @Test(priority = 1)
    public void Calls_STC12() throws InterruptedException, IOException {
        ChannelScenario ChannelScenario = new ChannelScenario(this, "Call_STC12",
                "check Channel take the floor modes ");
        ChannelScenario.Calls_STC12(Constants.AccountOfSecondDevice);

    }

    @Test(priority = 1)
    public void conversationSTC1() throws InterruptedException, IOException {
       ConversationScenario ConversationScenario = new ConversationScenario(this, "Conversation_STC1",
                "Conversation One to One");


        ConversationScenario.Conversation_STC1();
    }

    @Test(priority = 3)
    public void Login_STC5() throws InterruptedException, IOException {

        scenario.LogoutScenario logoutScenario = new scenario.LogoutScenario(this, "Login_STC5",
                "Logout");
        logoutScenario.login_STC5();
    }


    @Test(priority = 4)
    public void Settings_STC1() throws InterruptedException, IOException {
        SettingsScenario SettingsScenario = new SettingsScenario(this, "Settings_STC1",
                "Settings");
        SettingsScenario.settings_stc1();
    }


    @Test(priority = 5)
    public void Settings_STC2() throws InterruptedException, IOException {
        SettingsScenario SettingsScenario = new SettingsScenario(this, "Settings_STC2",
                "Settings");
        SettingsScenario.settings_stc2();
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC4(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC4",
                "PTT One to One");
        CallsScenario.Calls_STC4(accountOfSecondDevice);
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC5(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC5",
                "PTT One to One");
        CallsScenario.Calls_STC5(accountOfSecondDevice);
    }

    @Test
    public void Calls_STC18() throws InterruptedException, IOException {
        EmergencyMessageScenario EmergencyMessageScenario = new EmergencyMessageScenario(this, "Calls_STC18",
                "Emergency message STC18");
        EmergencyMessageScenario.doEmergencyMessage_STC18();
    }

    @Test
    public void Calls_STC19() throws InterruptedException, IOException {
        EmergencyMessageScenario EmergencyMessageScenario = new EmergencyMessageScenario(this, "Calls_STC19",
                "Emergency message STC19");
        EmergencyMessageScenario.doEmergencyMessage_STC19();
    }


    @Test
    public void Calls_STC20() throws InterruptedException, IOException {
        EmergencyCallScenario EmergencyCallScenario = new EmergencyCallScenario(this, "Calls_STC20",
                "Emergency call STC20");
        EmergencyCallScenario.doEmergencyCall_STC20();
    }


    @Test
    public void Calls_STC21() throws InterruptedException, IOException {
        EmergencyCallScenario EmergencyCallScenario = new EmergencyCallScenario(this, "Calls_STC21",
                "Emergency call STC21");
        EmergencyCallScenario.doEmergencyCall_STC21();
    }

    @Test
    @Parameters({"contact"})
    public void Conversation_STC14(String contact) throws InterruptedException, IOException {
        GeolocationScenario geolocationScenario = new GeolocationScenario(this, "geolocation",
                "Authorize user to deactivate the geolocation option ");
        geolocationScenario.doGeolocation_STC14(contact);
    }
    @Test
    @Parameters({"contact2"})
    public void Conversation_STC15(String contact2) throws InterruptedException, IOException {
        GeolocationScenario geolocationScenario = new GeolocationScenario(this, "geolocation",
                "Authorize your organization to locate  you");
        geolocationScenario.doGeolocation_STC15(contact2);
    }

    @Test
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC1(String accountOfSecondDevice) throws InterruptedException, IOException {
        VoipScenario VoipScenario = new VoipScenario(this, "Calls_STC1",
                "Introduction to VoIP calls");
        VoipScenario.Calls_STC1(accountOfSecondDevice);
    }


    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC27(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC27",
                "Video Call");
        CallsScenario.Calls_STC27(accountOfSecondDevice);
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void Calls_STC28(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC28",
                "Video call");
        CallsScenario.Calls_STC28(accountOfSecondDevice,accountOfThirdDevice);
    }

    @Test
    public void doMyBusiness_STC1() throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC1",
                "My Business tab : global display");


        mybusinessScenario.MyBusiness_STC1();
    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC2(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC2", "My Business : Actitvity > NEW");
        mybusinessScenario.doMyBusiness_STC2(processName, contact);

    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC21(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC21", "My Business : Actitvity > NEW");
        mybusinessScenario.Mybusiness_STC21(processName, contact);

    }

    @Test
    @Parameters({"processName", "contact", "contact2"})
    public void doMyBusiness_STC20(String processName, String contact, String contact2) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC2", "My Business : Actitvity > NEW");
        mybusinessScenario.Mybusiness_STC20(processName, contact, contact2);

    }

    @Test
    public void doMyBusiness_STC4() throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC4", "My Business : Activity Tab");
        mybusinessScenario.MyBusiness_STC4();

    }

    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC5(String processName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC5", "Search Process");
        mybusinessScenario.MyBusiness_STC5(processName);

    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC7(String widgetName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC7",
                "Send Process");

        mybusinessScenario.MyBusiness_STC7(widgetName);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC16(String widgetName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC16",
                "Start-Stop widget  (General Display)");

        mybusinessScenario.MyBusiness_STC16(widgetName);
    }

    @Test
    @Parameters({"widgetName"})
    public void myBusiness_STC17(String widgetName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC17",
                "Address");

        mybusinessScenario.myBusiness_STC17(widgetName);
    }


    @Test
    @Parameters({"processName","contact"})
    public void doMyBusiness_STC19(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "myBusiness_STC19()", "verify if process is in submit category");
        myBusinessScenario.MyBusiness_STC19(processName, contact);

    }

    @Test
    @Parameters({"widgetName", "contact"})
    public void doMyBusiness_STC25(String widgetName, String contact) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC25",
                "Use info from previous process");

        mybusinessScenario.MyBusiness_STC25(widgetName, contact);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC26(String widgetName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC26",
                "Logic of Process instance name Display - Display Mode");

        mybusinessScenario.MyBusiness_STC26(widgetName);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC29(String widgetName) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC29",
                "PProcess completed at the initiation step");

        mybusinessScenario.MyBusiness_STC29(widgetName);
    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC30(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC30",
                "Process completed at the initiation step (at least on contact selected from the recipient list)");


        mybusinessScenario.Mybusiness_STC30(processName, contact);
    }


    @Test
    @Parameters({"processName", "contact", "group"})
    public void doMyBusiness_STC33(String processName, String contact, String group) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC33",
                "Process submitted by the initiator");

        mybusinessScenario.Mybusiness_STC33(processName, contact, group);
    }

    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC43(String processName, String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC43", "Conversation already created for the Process");
        myBusinessScenario.Mybusiness_STC43(processName, contact2);
    }


    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC45(String processName, String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC45", "Conversation already created for the Process");
        myBusinessScenario.doMybusiness_STC45(processName, contact2);
    }

    @Test
    @Parameters({"processName","contact" ,"contact2"})

    public void doMyBusiness_STC46(String processName, String contact , String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC45", "The Process Is Completed");
        myBusinessScenario.doMybusiness_STC46(processName,contact , contact2);
    }

    @Test
    @Parameters({"processName","contact" ,"contact2"})

    public void doMyBusiness_STC47(String processName, String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC47","Edit Process Name (Process submitted by User B)");
        myBusinessScenario.doMybusiness_stc47(processName, contact2);
    }

    @Test
    @Parameters({"processName","i","j"})
    public void doMyBusiness_STC24(String processName, int i, int j) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "myBusiness_STC24", "verify the display of Schedule option and details");
        myBusinessScenario.MyBusiness_STC24(processName, i, j);
    }

    @Test
    @Parameters({"processName","contact"})
    public void doMyBusiness_STC27_28(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC27()", "verify if canceled process is in the Canceled tab");
        myBusinessScenario.mybusiness_STC27_28(processName, contact);
        // the user should send the process to himself

    }

    @Test
    @Parameters({"processName", "contact2"})
    public void doMyBusiness_STC36(String processName, String contact2) throws InterruptedException, IOException {
        MyBusinessScenario mybusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC36",
                "Submit a process when No internet connexion");


        mybusinessScenario.Mybusiness_STC36(processName, contact2);
    }

    @Test
    public void doMyBusiness_STC37() throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC37", "Auto-Saving option is Activated");
        myBusinessScenario.Mybusiness_STC37();

    }

    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC38(String processName) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC38", "verify the manual save of a process");
        myBusinessScenario.Mybusiness_STC38(processName);
        // in order for this methode to work, the process needs to have a text area first widget
    }

    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC39(String processName) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC39", "verify the auto-save of a process");
        myBusinessScenario.Mybusiness_STC39(processName);
        // in order for this methode to work, the process needs to have a text area first widget
        // there s a two minute wait to test the auto save
    }

    @Test(priority = 1)
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC60(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC60", "verify the manual save of a process");
        myBusinessScenario.Mybusiness_STC60(processName, contact);
    }

    @Test(priority = 2)
    @Parameters({"processName", "contact2"})
    public void doMyBusiness_STC61(String processName, String contact2) throws IOException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC60", "verify the manual save of a process");
        myBusinessScenario.Mybusiness_STC61(processName, contact2);
    }

    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC63(String processName, String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "myBusiness_STC63", "verify the display of details in process history for a scheduled process");
        myBusinessScenario.Mybusiness_STC63(processName, contact2);
    }

    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC64(String processName, String contact2) throws MalformedURLException, InterruptedException {
        MyBusinessScenario myBusinessScenario = new MyBusinessScenario(this, "MyBusiness_STC64", "verify the display of stop repeating option in a submitted repeated option");
        myBusinessScenario.Mybusiness_STC64(processName, contact2);
    }

    @Test
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void Calls_STC2(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        VoipScenario VoipScenario = new VoipScenario(this, "Calls_STC2",
                "Transfer Voip call");
        VoipScenario.Calls_STC2(accountOfSecondDevice, accountOfThirdDevice);
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC25(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC25",
                "Video Broadcast ");
        CallsScenario.Calls_STC25(accountOfSecondDevice);
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC26(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC26",
                "Video Broadcast ");
        CallsScenario.Calls_STC26(accountOfSecondDevice);
    }


    @Test(priority = 4)
    @Parameters({"groupToCall"})
    public void Calls_STC8(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC8",
                "PTT group ");
        CallsScenario.Calls_STC8(groupToCall);
    }

    @Test(priority = 4)
    @Parameters({"groupToCall"})
    public void Calls_STC7(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC7",
                "PTT group ");
        CallsScenario.Calls_STC7(groupToCall);
    }

    @Test(priority = 4)
    @Parameters({"groupToCall"})
    public void Calls_STC9(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC9",
                "PTT group ");
        CallsScenario.Calls_STC9(groupToCall);
    }

    @Test(priority = 2)
    @Parameters({"groupToCall"})
    public void Calls_STC6(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC6",
                "PTT group ");
        CallsScenario.Calls_STC6(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void Calls_STC3(String groupToCall) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC3",
                "Conference Call ");
        CallsScenario.Calls_STC3(groupToCall);
    }


    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC5(String groupToCall) throws InterruptedException, IOException {
       ConversationScenario conversationScenario = new ConversationScenario(this, "conversationSTC5",
                "Conversation one to many ");
        conversationScenario.conversationSTC5(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall","accountOfSecondDevice","bundleId","TitleOfEvent"})
    public void conversationSTC8(String groupToCall,String accountOfSecondDevice,String bundleId,String TitleOfEvent) throws InterruptedException, IOException {
       ConversationScenario conversationScenario = new ConversationScenario(this, "conversationSTC8",
                "Conversation one to many ");
        conversationScenario.conversationSTC8(groupToCall,TitleOfEvent);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC7(String groupToCall) throws InterruptedException, IOException {
        ConversationScenario conversationScenario = new ConversationScenario(this, "conversationSTC8",
                "Conversation one to many ");
        conversationScenario.conversationSTC7(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void conversationSTC9(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        ConversationScenario conversationScenario = new ConversationScenario(this, "conversationSTC0",
                "Conversation one to many ");
        conversationScenario.conversationSTC9(accountOfSecondDevice,accountOfThirdDevice);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC6(String groupToCall) throws InterruptedException, IOException {
        ConversationScenario conversationScenario = new ConversationScenario(this, "conversationSTC6",
                "Conversation one to many ");
        conversationScenario.conversationSTC6(groupToCall);
    }

    @Test(priority = 4)
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC16(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC16",
                "External call via PBX ");
        CallsScenario.Calls_STC16(accountOfSecondDevice);
    }


    @Test(priority = 4)
    public void Calls_STC17() throws InterruptedException, IOException {
        CallsScenario CallsScenario = new CallsScenario(this, "Calls_STC17",
                "Dialer call ");
        CallsScenario.Calls_STC17();
    }
}
