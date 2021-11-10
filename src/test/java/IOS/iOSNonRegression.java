package IOS;

import IOS.nonRegressionScenarios.DialerScenario;
import IOS.nonRegressionScenarios.SumUpScenario;
import IOS.nonRegressionScenarios.calendarScenario;
import framework.tester.STWAppiumTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scenario.PerformanceScenarios;

import java.io.IOException;

@Listeners(framework.utils.listeners.TestListener.class)
public class iOSNonRegression extends STWAppiumTest {


    public iOSNonRegression(String platform, String branding) {
        super(platform, branding);
    }

    @Test
    public void doDialer() throws InterruptedException, IOException {
        DialerScenario DialerScenario=new DialerScenario(this,"Dialer",
                "Dialer");
        DialerScenario.Dailer();
    }
    @Test
    public void batchMessages(String account,int numberoFMessages ) throws InterruptedException, IOException {
        PerformanceScenarios performanceScenarios=new PerformanceScenarios(this,"Dialer",
                "batch messages");
        performanceScenarios.batchMessages(account,numberoFMessages);
    }

    @Test
    public void doSumUp() throws InterruptedException, IOException {
        SumUpScenario SumUpScenario=new SumUpScenario(this,"MyBusiness",
                "SumUpColumnTable");
        SumUpScenario.doSumUp_STC1("Sum-up","5.00","10.00","4.00","2.00");
    }

    @Test
    public void businessProcessTC13() throws InterruptedException, IOException {
    calendarScenario calendarScenario=new calendarScenario(this,"MyBusiness",
            "calendar");
        calendarScenario.businessProcessTC13();
    }

    @Test
    public void businessProcessTC22() throws InterruptedException, IOException {
        calendarScenario calendarScenario=new calendarScenario(this,"MyBusiness",
                "calendar");
        calendarScenario.businessProcessTC22();
    }
    @Test
    public void businessProcessTC23() throws InterruptedException, IOException {
        calendarScenario calendarScenario=new calendarScenario(this,"MyBusiness",
                "calendar");
        calendarScenario.businessProcessTC23("Unavailable");
    }
}
