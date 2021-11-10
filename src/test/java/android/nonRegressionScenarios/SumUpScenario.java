package android.nonRegressionScenarios;

import android.screen.mybusiness.MyBusinessScreen;
import android.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

import java.net.MalformedURLException;

public class SumUpScenario extends STWScenario {
    public SumUpScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void doSumUp_STC1 (String processName) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescriptionFromNonRegression("MyBusiness_STC1", Constants.MB_SumOfTableColumnSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");

        //if (myBusinessScreen.isElementDisplayed(myBusinessScreen.getDenyBattery()))
        // myBusinessScreen.getDenyBattery().click();
        String a = "5.00";
        String b = "10.00";
        String c = "4.00";
        String d = "2.00";
        Thread.sleep(3000);
        tabBarScreen.getMyBusinessItem();
        mLogger.log(Status.PASS, "2 - Go to MyBusiness tab");
        Thread.sleep(3000);
        myBusinessScreen.getStartItem().click();
        mLogger.log(Status.PASS, "3 - Click on Start");
        myBusinessScreen.getSearchBarBtn().click();
        myBusinessScreen.getSearchBarContent().sendKeys(processName);
        myBusinessScreen.getFirstSearchedProcess().get(0).click();
        mLogger.log(Status.PASS, "4 – Select the process P1:Sum-up ");
        myBusinessScreen.getRowTable().get(0).click();
        Thread.sleep(1000);
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(a);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(d);
        myBusinessScreen.getRowTable().get(0).click();
        myBusinessScreen.getRowTable().get(1).click();
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(b);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(c);
        myBusinessScreen.getRowTable().get(1).click();
        myBusinessScreen.getRowTable().get(2).click();
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(c);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(a);
        myBusinessScreen.getRowTable().get(2).click();
        mLogger.log(Status.PASS, "5 – Fill in the columns with different values");
        //myBusinessScreen.scrollToElement(mDriver ,myBusinessScreen.getWidgetNumber(), false);
        myBusinessScreen.holdAndScrollDown(1,2000,0.7,0.3,0.5);

       // String val = myBusinessScreen.getWidgetNumber().getText();
        double val = Double.parseDouble(myBusinessScreen.getWidgetNumber().getText());
        String val1 = myBusinessScreen.getWidgetCurrency().getText();
        double sumNum =Double.parseDouble(a)+Double.parseDouble(b)+Double.parseDouble(c);
        double sumCurr =Double.parseDouble(d)+Double.parseDouble(c)+Double.parseDouble(a);
        //double valNum = Double.parseDouble(val);
        double valCurr = Double.parseDouble(val1);
        //valNum
        Assert.assertEquals(val, sumNum,"Expected and Actual Result are not match!");
        Assert.assertEquals(valCurr, sumCurr,"Expected and Actual Result are not match!");
        if ((Double.compare(val, sumNum) == 0) && (Double.compare(valCurr, sumCurr) == 0))
        {
            System.out.println("Sum of QTY columns is correct");
            //mLogger.log(Status.PASS,"Actual Result : Sum of QTY columns is correct");
        //}
        //if (Double.compare(valCurr, sumCurr) == 0)
        //{
            System.out.println("Sum of Total Price columns is correct");
            mLogger.log(Status.PASS,"Expected and Actual Result are equals");
        }
    }
    public void doSumUp_STC3 (String processName) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescriptionFromNonRegression("MyBusiness_STC3", Constants.MB_SumOfTableColumnSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        String a = "5.00";
        String b = "10.00";
        String c = "4.00";
        String d = "2.00";
        Thread.sleep(3000);
        tabBarScreen.getMyBusinessItem();
        mLogger.log(Status.PASS, "2 - Go to MyBusiness tab");
        myBusinessScreen.getStartItem().click();
        mLogger.log(Status.PASS, "3 - Click on Start");
        myBusinessScreen.getSearchBarBtn().click();
        myBusinessScreen.getSearchBarContent().sendKeys(processName);
        myBusinessScreen.getFirstSearchedProcess().get(0).click();
        mLogger.log(Status.PASS, "4 – Select the process P1:Sum-up ");
        myBusinessScreen.getRowTable().get(0).click();
        Thread.sleep(1000);
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(a);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(d);
        myBusinessScreen.getRowTable().get(0).click();
        myBusinessScreen.getRowTable().get(1).click();
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(b);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(c);
        myBusinessScreen.getRowTable().get(1).click();
        myBusinessScreen.getRowTable().get(2).click();
        myBusinessScreen.getWidgetNumber().clear();
        myBusinessScreen.getWidgetNumber().sendKeys(c);
        myBusinessScreen.getWidgetCurrency().clear();
        myBusinessScreen.getWidgetCurrency().sendKeys(a);
        myBusinessScreen.getRowTable().get(2).click();
        mLogger.log(Status.PASS, "5 – Fill in the columns with different values");
        //myBusinessScreen.scrollToElement(mDriver ,myBusinessScreen.getWidgetNumber(), false);
        myBusinessScreen.getPreviewElement().click();
        mLogger.log(Status.PASS, "6 – Click on “Preview table” button");
        myBusinessScreen.LonPressOnElement(myBusinessScreen.getPreviewRows().get(0));
        mLogger.log(Status.PASS,"7 – Perform a long press on a row");
        Thread.sleep(1000);
        myBusinessScreen.getDeleteButton().click();
        Thread.sleep(1000);
        myBusinessScreen.getBackBtn().click();
        mLogger.log(Status.PASS,"8 – Click on Delete then press the back button");
        Thread.sleep(1000);
        myBusinessScreen.holdAndScrollDown(1,2000,0.7,0.3,0.5);
        double val = Double.parseDouble(myBusinessScreen.getWidgetNumber().getText());
        String val1 = myBusinessScreen.getWidgetCurrency().getText();
        double sumNum =Double.parseDouble(b)+Double.parseDouble(c);
        double sumCurr =Double.parseDouble(c)+Double.parseDouble(a);
        //double valNum = Double.parseDouble(val);
        double valCurr = Double.parseDouble(val1);
        Assert.assertEquals(val, sumNum,"Expected and Actual Result are not match!");
        Assert.assertEquals(valCurr, sumCurr,"Expected and Actual Result are not match!");
        if ((Double.compare(val, sumNum) == 0) && (Double.compare(valCurr, sumCurr) == 0))
        {
            System.out.println("Sum of QTY columns is correct");
            System.out.println("Sum of Total Price columns is correct");
            mLogger.log(Status.PASS,"Expected and Actual Result are equals");
        }

    }

    }
