package IOS.scenario;

import IOS.screen.EmergencyCallScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.Platforms;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDateTime;

public class EmergencyCallScenario extends STWScenario {

    public EmergencyCallScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }


    public void doEmergencyCall_STC20() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);

        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);


        EmergencyCallScreen.GetUseCaseDescription("Calls_STC20", Constants.EmergencyCallSheetNumber, mLogger);


        Thread.sleep(2000);
        EmergencyCallScreen.LonPressOnElement(EmergencyCallScreen.getEmergency_Call_Button());
        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreen.getBack_Button(), "Back Button is displayed");

        EmergencyCallScreen.getBack_Button().click();
        String date = EmergencyCallScreen.getDate().getAttribute("label");

       /* if(date.contains("AM")) {
           String h =date.substring(0,date.length() - 6);
           System.out.println(h);
            date = String.format("%02d", Integer.parseInt(h))+ ":" + date.substring(date.length() - 5,date.length() - 3);
        }else {
            int h = Integer.parseInt(date.substring(0,date.length() - 6)) + 12;
            date = String.format("%02d", h)+ ":" + date.substring(date.length() - 5,date.length() - 3);
        }
*/

        int hour = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();
        int minPrime = LocalDateTime.now().getMinute() - 1;

        String Local_time = String.format("%02d", hour) + ":" + String.format("%02d", min);
        String Local_timePrime = String.format("%02d", hour) + ":" + String.format("%02d", minPrime);

        System.out.println(date);
        System.out.println(Local_time);
        System.out.println(Local_timePrime);

        if (date == Local_time) {
            Assert.assertEquals(date, Local_time);
        } else if (date == Local_timePrime) {
            Assert.assertEquals(date, Local_timePrime);
        }


        mLogger.log(Status.PASS, " A new Emergency call conversation is created with every Emergency Call");

        Thread.sleep(1000);
        EmergencyCallScreenSecond.getAccept_Emergency().click();


        mLogger.log(Status.PASS, "D accept the Call");

        EmergencyCallScreen.getDate().click();


        EmergencyCallScreenSecond.getReject_Button().click();
        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreen.getBubble_Activity_Message(), "Check the bubble activity message");


        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreen.getMap(), "Check the map preview");


        mLogger.log(Status.PASS, "Check the conversation of the emergency call screen");


        EmergencyCallScreen.getRecipient_Emergency().click();
        mLogger.log(Status.PASS, "Check the members");


        Boolean admin = EmergencyCallScreen.isElementDisplayed(EmergencyCallScreen.getAdmin_Groupe());
        Assert.assertFalse(admin);
        mLogger.log(Status.PASS, "The conversation is similar to group conversation but no admin");


    }



    public void doEmergencyCall_STC21() throws InterruptedException, IOException {
        EmergencyCallScreen EmergencyCallScreen = new EmergencyCallScreen(mDriver);

        mDriver2 = mStwAppiumTest.getSecondDriver(Platforms.IOS);

        EmergencyCallScreen EmergencyCallScreenSecond = new EmergencyCallScreen(mDriver2);
        EmergencyCallScreen.GetUseCaseDescription("Calls_STC21", Constants.EmergencyCallSheetNumber, mLogger);

        EmergencyCallScreen.LonPressOnElement(EmergencyCallScreen.getEmergency_Call_Button());
        mLogger.log(Status.PASS, "From any view  of  TOTR app user A trigger an Emergency Call  call");

        Thread.sleep(1000);
        EmergencyCallScreenSecond.getAccept_Emergency().click();
        mLogger.log(Status.PASS, "accept the call");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getPtt_Button(), "Ptt button is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getAdd_User(), "Add user button is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getDétails(), "Details call is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getVideo(), "Video button is displayed  ");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getConversation(), "go to conversation is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getGeolocation(), "Location is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getBack_Button(), "Back button is displayed");

        EmergencyCallScreen.CheckDisplayedOfElement(EmergencyCallScreenSecond.getReject_Button(), "Reject button is displayed");


        mLogger.log(Status.PASS, "Check the emergency call screen options  (one by one)");


        EmergencyCallScreenSecond.getReject_Button().click();

        Boolean emergencyButton = EmergencyCallScreenSecond.isElementDisplayed(EmergencyCallScreenSecond.getEmergency_Call_Button());
        Assert.assertFalse(emergencyButton);

        mLogger.log(Status.PASS, "If user is  the  only recipient on the  profile , and  he is  on the users list, The  Emergency Call  button will not be available");



    }


}
