package android.nonRegressionScenarios;

import android.screen.CalendarScreen;
import android.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class CalendarScenario extends STWScenario {
    public CalendarScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    public void doCalendar_STC13() throws InterruptedException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        CalendarScreen calendarScreen = new CalendarScreen(mDriver);
        CalendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_STC13", Constants.SchedulingSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.getSchedulingItem();
        Thread.sleep(3000);
        mLogger.log(Status.PASS, "2 - User A opens the daily view in the scheduling feature in mobile application menu");
        calendarScreen.getCalendarIcon().click();
        mLogger.log(Status.PASS, "3 - User A receives a new service order in the calendar");
        calendarScreen.getPreviousMonth().click();
        calendarScreen.getRandomDate().click();
        calendarScreen.getOkButton().click();
        String status = calendarScreen.getServiceStatus().get(0).getText();
        //Accept the service
        if (status.equals("PENDING") || status.equals("UNCONFIRMED"))
        {
            calendarScreen.getAcceptButton().click();
            Thread.sleep(1000);
            mLogger.log(Status.PASS, "4 – User A clicks on « Accept » button in a service with « Pending » or « Unconfirmed » status ");

            String acceptedStatus = calendarScreen.getServiceStatus().get(0).getText();
            if (acceptedStatus.equals("ACCEPTED")) {
            mLogger.log(Status.PASS, "Result : 4 – The Status of the service order is changed to " + acceptedStatus);
             } else {
            mLogger.log(Status.FAIL, "Result : 4 – The Status of the service order is changed to " + acceptedStatus);
             }
        }

            //Start the service
            calendarScreen.getStartButton().click();
            Thread.sleep(1000);
            mLogger.log(Status.PASS, "5 – User A clicks on « Start the service » button in a service with « Accepted » status ");
            String inProgressStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (inProgressStatus.equals("IN PROGRESS")) {
                mLogger.log(Status.PASS, "Result : 5 – The Status of the service order is changed to " + inProgressStatus);

            } else {
                mLogger.log(Status.FAIL, "Result : 5 – The Status of the service order is changed to " + inProgressStatus);
            }


            //Finish the service
            calendarScreen.getFinishButton().click();
            Thread.sleep(1000);
            mLogger.log(Status.PASS, "6 – User A clicks on « Finish the service » button in a service with « In progress » status ");
            String doneStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (doneStatus.equals("DONE")) {
                mLogger.log(Status.PASS, "Result : 6 – The Status of the service order is changed to " + doneStatus);

            } else {
                mLogger.log(Status.FAIL, "Result : 6 – The Status of the service order is changed to " + doneStatus);
            }

//            //Complete the service
            calendarScreen.getCompleteButton().click();
            Thread.sleep(1000);
            mLogger.log(Status.PASS, "7 – User A clicks on « Complete the service » button in a service with « Done » status ");
            String completedStatus = calendarScreen.getServiceStatus().get(0).getText();

            if (completedStatus.equals("COMPLETED")) {
                mLogger.log(Status.PASS, "Result : 7 – The Status of the service order is changed to " + completedStatus);

            } else {
                mLogger.log(Status.FAIL, "Result : 7 – The Status of the service order is changed to " + completedStatus);
            }

    }
    public void doCalendar_STC22() throws InterruptedException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        CalendarScreen calendarScreen = new CalendarScreen(mDriver);
        CalendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_STC22", Constants.SchedulingSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.getSchedulingItem();
        String status = calendarScreen.getServiceStatus().get(0).getText();
        calendarScreen.getAcceptButton().click();
        if (status.equals("ACCEPTED"))
        {
            mLogger.log(Status.PASS, "Result :  The Status of the service order is changed to " + status);
        }
        String acceptedToast = calendarScreen.getAcceptToast().getText();
        if (acceptedToast.equals("Service accepted"))
        {
            mLogger.log(Status.PASS, "Result :  The label displayed when accepting the service: " + acceptedToast);
        }
        calendarScreen.getFrameNumber().click();
        boolean displayed = calendarScreen.isElementDisplayed(calendarScreen.getFloatButton());
        String mbStatus = calendarScreen.getMyBusinessStatus().getText();
        if (mbStatus.equals("ACCEPTED"))
        {
            mLogger.log(Status.PASS, "Result :  The status of MB process is changed to " +mbStatus );
        }
        if (displayed)
        {
            mLogger.log(Status.PASS, "Result :  The floating button is displayed " );
        }
    }

    public void doCalendar_STC23() throws InterruptedException, IOException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        CalendarScreen calendarScreen = new CalendarScreen(mDriver);
        CalendarScreen.GetUseCaseDescriptionFromNonRegression("Calendar_STC22", Constants.SchedulingSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.getSchedulingItem();
        Thread.sleep(3000);
        calendarScreen.getRejectButton().click();
        Thread.sleep(1000);
        //mLogger.addScreenCaptureFromPath(calendarScreen.getscreenshot());
        calendarScreen.getRejectionReason().sendKeys("Unavailable");
        calendarScreen.getDoneRejectReason().click();
        calendarScreen.getSubmitRejection().click();
        boolean rejectLabel = calendarScreen.isElementDisplayed(calendarScreen.getRejectToast());
        if (rejectLabel)
        {
            mLogger.log(Status.PASS, "Result : Service rejected is displayed " );
        }
        calendarScreen.isElementDisplayed(calendarScreen.getNoSOLabel());
    }
}
