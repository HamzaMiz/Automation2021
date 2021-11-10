package android;

import android.nonRegressionScenarios.CalendarScenario;
import android.nonRegressionScenarios.DialerScenario;
import android.nonRegressionScenarios.SumUpScenario;
import framework.tester.STWAppiumTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(framework.utils.listeners.TestListener.class)
public class AndroidNonRegression extends STWAppiumTest {


    public AndroidNonRegression(String platform, String branding) {
        super(platform, branding);
    }

    @Test(priority = 1)
    public void doDialer() throws InterruptedException, IOException {
        DialerScenario DialerScenario=new DialerScenario(this,"Dialer",
                "Dialer");
        DialerScenario.Dailer();
    }

    @Test(priority = 1)
    public void doSumUp_STC1() throws InterruptedException {
        SumUpScenario SumUpScenario=new SumUpScenario(this,"MyBusiness",
                "SumUpColumnTable");
        SumUpScenario.doSumUp_STC1("Sum-up ");
    }

    @Test(priority = 1)
    public void doSumUp_STC3() throws InterruptedException, MalformedURLException {
        SumUpScenario SumUpScenario=new SumUpScenario(this,"MyBusiness",
                "SumUpColumnTable");
        SumUpScenario.doSumUp_STC3("Sum-up ");
    }

    @Test(priority = 1)
    public void doCalendar_STC13() throws InterruptedException, MalformedURLException {
        CalendarScenario calendarScenario = new CalendarScenario(this, "Scheduling",
                "Service Order Status");
        calendarScenario.doCalendar_STC13();
    }
}
