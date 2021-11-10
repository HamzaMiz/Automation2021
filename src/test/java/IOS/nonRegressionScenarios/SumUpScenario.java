package IOS.nonRegressionScenarios;

import IOS.screen.Mybusiness.MyBusinessScreen;
import IOS.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

public class SumUpScenario extends STWScenario {
    public SumUpScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }
    public void doSumUp_STC1 (String processName, String firstInput, String secondInput, String thirdInput, String fourthInput) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescriptionFromNonRegression("MyBusiness_STC1", Constants.MB_SumOfTableColumnSheetNumber, mLogger);
        mLogger.log(Status.PASS, "1 - Launch the application");
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "2 - Go to MyBusiness tab");
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "3 - Click on Start");
        myBusinessScreen.searchProcessStart(processName);
        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "4 – Select the process P1: Sum-up ");
        myBusinessScreen.fillFirstRowTable(firstInput,fourthInput);
        myBusinessScreen.fillSecondRowTable(secondInput,thirdInput);
        myBusinessScreen.fillThirdRowTable(thirdInput,firstInput);
        mLogger.log(Status.PASS, "5 – Fill in the columns with different values");
        myBusinessScreen.getNextStepProcess();
        double valNum = Double.parseDouble(myBusinessScreen.getWidgetNumberOutsideTable().getText());
        double valCurr = Double.parseDouble(myBusinessScreen.getWidgetCurrency().get(0).getText());
        double sumNum =Double.parseDouble(firstInput)+Double.parseDouble(secondInput)+Double.parseDouble(thirdInput);
        double sumCurr =Double.parseDouble(fourthInput)+Double.parseDouble(thirdInput)+Double.parseDouble(firstInput);
        Assert.assertEquals(valNum, sumNum,"Expected and Actual Result are not match!");
        Assert.assertEquals(valCurr, sumCurr,"Expected and Actual Result are not match!");
        if ((Double.compare(valNum, sumNum) == 0) && (Double.compare(valCurr, sumCurr) == 0)) {
            mLogger.log(Status.PASS, "Expected and Actual Result are equals");
        }
    }
}
