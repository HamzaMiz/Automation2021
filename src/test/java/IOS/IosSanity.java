package IOS;

import IOS.scenario.*;
import framework.tester.STWAppiumTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
@Listeners(framework.utils.listeners.TestListener.class)
public class IosSanity extends STWAppiumTest {


    public IosSanity(String platform, String branding) {
        super(platform, branding);
    }

    /*    @Test
        @Parameters({"company", "countryName","phone", "bundleId"})
        public void login_STC3_STC4(String company, String countryName , String phone , String bundleId) throws InterruptedException, IOException {
            LoginScenario loginScenario = new LoginScenario(this, "Login_STC3_STC4",
                    "Login with Activation Code");


            loginScenario.login_STC3_STC4(company, countryName, phone, bundleId);
        }*/
    @Test
    public void doMyBusiness_STC1() throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC1",
                "My Business tab : global display");


        mybusinessScenario.MyBusiness_STC1();
    }

    @Test(priority = 1)
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC2(String processName, String contact) throws InterruptedException, IOException {

        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC2",
                "Send Process");



        mybusinessScenario.MyBusiness_STC2(processName, contact);
    }
    @Test
    public void doMyBusiness_STC4() throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC4",
                "Verify all categories is displayed");

        mybusinessScenario.MyBusiness_STC4();
    }

    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC5(String processName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC5",
                "Search Process");


        mybusinessScenario.MyBusiness_STC5(processName);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC7(String widgetName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC7",
                "Send Process");

        mybusinessScenario.MyBusiness_STC7(widgetName);
    }



    @Test
    @Parameters({"widgetName","contact","bundleId","title"})
    public void doMyBusiness_STC15(String widgetName,String contact,String bundleId,String title) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC15",
                "upload file widget");

        mybusinessScenario.MyBusiness_STC15(widgetName,contact,bundleId,title);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC16(String widgetName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC16",
                "star and stop widget");

        mybusinessScenario.MyBusiness_STC16(widgetName);
    }

    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC17(String widgetName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC17",
                "Adresswidget");

        mybusinessScenario.MyBusiness_STC17(widgetName);
    }
    @Test
    @Parameters({"processName","contact"})
    public void doMyBusiness_STC19(String processName, String contact) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC19",
                "Check if process is properly received");
        mybusinessScenario.MyBusiness_STC19(processName, contact);
    }
    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC24(String processName) throws MalformedURLException, InterruptedException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC24", "verify the display of Schedule option and details");
        mybusinessScenario.MyBusiness_STC24(processName);
    }

    @Test
    @Parameters({"widgetName","contact"})
    public void doMyBusiness_STC25(String widgetName,String contact) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC25",
                "use previous data");

        mybusinessScenario.MyBusiness_STC25(widgetName,contact);
    }


    @Test
    @Parameters({"widgetName"})
    public void doMyBusiness_STC26(String widgetName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC26",
                "Logic of Process instance name Display - Display Mode");


        mybusinessScenario.MyBusiness_STC26(widgetName);
    }
    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC29(String processName) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC29",
                "Process completed at the initiation step");

        mybusinessScenario.MyBusiness_STC29(processName);
    }




    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC43(String processName, String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC43",
                "Conversation already created for the Process");
        mybusinessScenario.myBusiness_STC43( processName,  contact2);
    }
    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC45(String processName, String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC45",
                "Delete My Business Conversations ");
        mybusinessScenario.myBusiness_STC45( processName, contact2);
    }
    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC46(String processName, String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC46",
                "The Process Is Completed");
        mybusinessScenario.myBusiness_STC46(processName,  contact2);
    }
    @Test
    @Parameters({"processName","contact2"})
    public void doMyBusiness_STC47(String processName, String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC47",
                "Edit Process Name (Process submitted by User B)");
        mybusinessScenario.myBusiness_STC47(processName,  contact2);
    }


    @Test
    @Parameters({"processName","contact"})
    public void doMyBusiness_STC27_28(String processName, String contact) throws IOException, InterruptedException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC27", "verify if canceled process is in the Canceled tab with details");

        mybusinessScenario.Mybusiness_STC27_28(processName, contact);
        // the user should send the process to himself
    }


    @Test
    @Parameters({"processName"})
    public void doMyBusiness_STC38(String processName) throws IOException, InterruptedException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC38", "verify the manual save of a process");

        mybusinessScenario.Mybusiness_STC38(processName);
    }

    @Test
    @Parameters({"processName"})
    // there's a two minute wait to verify the auto save
    public void doMyBusiness_STC39(String processName) throws IOException, InterruptedException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC39", "verify the auto-save of a process");

        mybusinessScenario.Mybusiness_STC39(processName);
    }




    @Test
    @Parameters({"processName", "contact","contact2"})
    public void doMyBusiness_STC20(String processName, String contact,String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC4",
                "Duplicate Button Displayed (Read Only Mode)");


        mybusinessScenario.Mybusiness_STC20(processName, contact,contact2);
    }
    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC21(String processName, String contact) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC21",
                "Duplicate Button NOT Displayed    (Edit Mode)");


        mybusinessScenario.Mybusiness_STC21(processName, contact);
    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC30(String processName, String contact) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC30",
                "Process completed at the initiation step");


        mybusinessScenario.Mybusiness_STC30(processName, contact);
    }

    @Test
    @Parameters({"processName", "contact", "group"})
    public void doMyBusiness_STC33(String processName, String contact, String group) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC33",
                "Process submitted by the initiator");


        mybusinessScenario.Mybusiness_STC33(processName, contact, group);
    }

    @Test
    @Parameters({"processName", "contact", "bundleId"})
    public void doMyBusiness_STC36(String processName, String contact, String bundleId) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC36",
                "Submit a process when No internet connexion");


        mybusinessScenario.Mybusiness_STC36(processName, contact, bundleId);
    }

    @Test
    public void doMyBusiness_STC37() throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC37",
                "Auto-Saving option is Activated ");


        mybusinessScenario.Mybusiness_STC37();
    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC60(String processName, String contact) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC60",
                "History icon display - In Progress Process");


        mybusinessScenario.Mybusiness_STC60(processName, contact);
    }

    @Test
    @Parameters({"processName", "contact2"})
    public void doMyBusiness_STC61(String processName, String contact2) throws InterruptedException, IOException {
        MybusinessScenario mybusinessScenario = new MybusinessScenario(this, "MyBusiness_STC36",
                "History icon display - In Progress Process");


        mybusinessScenario.Mybusiness_STC61(processName, contact2);
    }

    @Test
    @Parameters({"processName", "contact"})
    public void doMyBusiness_STC63(String processName, String contact) throws MalformedURLException, InterruptedException {
        MybusinessScenario myBusinessScenario = new MybusinessScenario( this, "MyBusiness_STC63", "verify the display of details in process history for a scheduled process");
        myBusinessScenario.MyBusiness_STC63(processName,contact);
    }
    @Test
    @Parameters({"processName","contact"})
    public void doMyBusiness_STC64(String processName, String contact) throws IOException, InterruptedException {
        MybusinessScenario myBusinessScenario = new MybusinessScenario( this, "MyBusiness_STC64", "verify the display of stop repeating option in a submitted repeated option");
        myBusinessScenario.Mybusiness_STC64(processName, contact);
    }


    @Test
    public void Settings_STC1() throws InterruptedException, IOException {
        SettingsScenario SettingsScenario = new SettingsScenario(this, "Settings_STC1",
                "Settings");

        SettingsScenario.settings_stc1();
    }

    @Test
    public void Settings_STC2() throws InterruptedException, IOException {
        SettingsScenario SettingsScenario = new SettingsScenario(this, "Settings_STC2",
                "Settings");

        SettingsScenario.settings_stc2();
    }

    @Test
    public void Login_STC5() throws InterruptedException, IOException {
        LogoutScenario LogoutScenario = new LogoutScenario(this, "Login_STC5",
                "Logout");
        LogoutScenario.logout();
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
    @Parameters({"contact2"})

    public void Geolocation_STC14(String contact2 ) throws InterruptedException {
        GeolocationScenario geolocationScenario = new GeolocationScenario(this, "doGeolocation_STC14", "");
        geolocationScenario.doGeolocation_STC14(contact2);

    }

    @Test
    @Parameters({"contact2"})

    public void Geolocation_STC15(String contact2) throws InterruptedException, IOException {
        GeolocationScenario geolocationScenario = new GeolocationScenario(this, "doGeolocation_STC15", "");
        geolocationScenario.doGeolocation_STC15(contact2);

    }


    @Test
    @Parameters({"accountOfSecondDevice"})
    public void Calls_STC1(String accountOfSecondDevice) throws InterruptedException, IOException {
        VoipScenario VoipScenario = new VoipScenario(this, "Calls_STC1",
                "Introduction to VoIP calls");
        VoipScenario.Calls_STC1(accountOfSecondDevice);
    }


    @Test
    @Parameters({"accountOfSecondDevice","accountOfThirdDevice"})
    public void Calls_STC2(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        VoipScenario VoipScenario = new VoipScenario(this, "Calls_STC2",
                "Transfer Voip call");
        VoipScenario.Calls_STC2(accountOfSecondDevice, accountOfThirdDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice","bundleId","titleOfEvent"})
    public void conversationSTC3(String accountOfSecondDevice,String bundleId,String titleOfEvent ) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario = new ConversationScenario(this, "Conversation_STC3",
                "Conversation One to One IOS");
        ConversationScenario.conversationSTC3(accountOfSecondDevice,bundleId,titleOfEvent);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void conversationSTC2(String accountOfSecondDevice) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario = new ConversationScenario(this, "Conversation_STC2",
                "Conversation One to One IOS");
        ConversationScenario.conversationSTC2(accountOfSecondDevice);
    }

    @Test(priority = 1)
    public void conversationSTC1() throws InterruptedException, IOException {
        ConversationScenario ConversationScenario = new ConversationScenario(this, "Conversation_STC1",
                "Conversation One to One IOS");
        ConversationScenario.conversationSTC1();
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC5(String groupToCall) throws InterruptedException, IOException {
        scenario.ConversationScenario ConversationScenario =  new scenario.ConversationScenario (this,"Conversation_STC5",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC5(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall","accountOfSecondDevice","bundleId","titleOfEvent"})
    public void conversationSTC8(String groupToCall,String accountOfSecondDevice,String bundleId,String titleOfEvent) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario =  new ConversationScenario(this,"Conversation_STC8",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC8(groupToCall,accountOfSecondDevice,bundleId,titleOfEvent);
    }
    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC7(String groupToCall) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario =  new ConversationScenario(this,"Conversation_STC7",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC7(groupToCall);
    }
    @Test(priority = 1)
    public void Contact_STC2() throws IOException, InterruptedException {
        ContactScenario ContactScenario= new ContactScenario(this,"Contact_STC2","verify contact screen items");

        ContactScenario.Contact_STC2();

    }
    @Test(priority = 1)
    public void Contact_STC3() throws IOException, InterruptedException {
        ContactScenario ContactScenario= new ContactScenario(this,"Contact_STC3","verify contact option and Details UI screen");

        ContactScenario.Contact_STC3();

    }
    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void conversationSTC9(String accountOfSecondDevice, String accountOfThirdDevice) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario =  new ConversationScenario(this,"Conversation_STC9",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC9(accountOfSecondDevice,accountOfThirdDevice );
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void conversationSTC6(String groupToCall) throws InterruptedException, IOException {
        ConversationScenario ConversationScenario =  new ConversationScenario(this,"Conversation_STC6",
                "Conversation One to Many IOS");
        ConversationScenario.conversationSTC6(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC16(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC16",
                "Call via PBX");
        callsScenario.Calls_STC16(accountOfSecondDevice);
    }
    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC17(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC17",
                "Dialer Call ");
        callsScenario.Calls_STC17(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC4(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC4",
                "PTT Call ");
        callsScenario.Calls_STC4(accountOfSecondDevice);
    }
    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC5(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC5",
                "PTT Call ");
        callsScenario.Calls_STC5(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void callsSTC6(String groupToCall) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC6",
                "PTT Call ");
        callsScenario.Calls_STC6(groupToCall);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC8(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC8",
                "PTT Call ");
        callsScenario.Calls_STC8(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC7(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC7",
                "PTT Call ");
        callsScenario.Calls_STC7( accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC9(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC9",
                "PTT Call ");
        callsScenario.Calls_STC9(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC25(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC25",
                "Video broadcast  ");
        callsScenario.callsSTC25(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC26(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC26",
                "Video broadcast");
        callsScenario.callsSTC26(accountOfSecondDevice);
    }

    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice"})
    public void callsSTC27(String accountOfSecondDevice) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC27",
                "Video call");
        callsScenario.callsSTC27(accountOfSecondDevice);
    }
    @Test(priority = 1)
    @Parameters({"accountOfSecondDevice", "accountOfThirdDevice"})
    public void callsSTC28(String accountOfSecondDevice,String accountOfThirdDevice ) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC28",
                "Video call");
        callsScenario.callsSTC28(accountOfSecondDevice,accountOfThirdDevice);
    }

    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void callsSTC3(String groupToCall) throws InterruptedException, IOException {
        CallsScenario callsScenario =  new CallsScenario(this,"callsSTC3",
                "Conference  call");
        callsScenario.callSTC3(groupToCall);
    }
    @Test(priority = 1)
    public void Contact_STC4() throws IOException, InterruptedException {
        ContactScenario ContactScenario= new ContactScenario(this,"Contact_STC4","verify contact option and Details UI screen");
        ContactScenario.Contact_STC4();

    }
    @Test(priority = 1)
    public void Contact_STC5() throws IOException, InterruptedException {
        ContactScenario ContactScenario= new ContactScenario(this,"Contact_STC5","Search contact");
        ContactScenario.Contact_STC5();

    }
    @Test(priority = 1)
    public void Contact_STC7() throws IOException, InterruptedException {
        ContactScenario ContactScenario= new ContactScenario(this,"Contact_STC7","Sort contact");
        ContactScenario.Contact_STC7();

    }
    @Test(priority = 1)
    public void callsSTC10() throws InterruptedException, IOException {
        ChannelScenario channelScenario =  new ChannelScenario(this,"calls_STC10","Channel Main screen");
        channelScenario.Call_STC10();
    }
    @Test(priority = 1)
    public void callsSTC11() throws InterruptedException, IOException {
        ChannelScenario channelScenario =  new ChannelScenario(this,"calls_STC11","Channel Option details");
        channelScenario.Calls_STC11();

    }
    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void callsSTC12(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario channelScenario =  new ChannelScenario(this,"calls_STC12","Channel Take the floor ");
        channelScenario.Calls_STC12(groupToCall);

    }
    @Test(priority = 1)
    @Parameters({"groupToCall"})
    public void callsSTC15(String groupToCall) throws InterruptedException, IOException {
        ChannelScenario channelScenario =  new ChannelScenario(this,"calls_STC15","Channel Take the floor");
        channelScenario.Calls_STC15(groupToCall);

    }
}