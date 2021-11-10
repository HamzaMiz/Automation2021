package android.scenario;

import android.screen.GmailScreen;
import android.screen.LoginScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;

import java.io.IOException;

public class LoginScenario extends STWScenario {

    public LoginScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void login(String company, String country, String phone) throws InterruptedException, IOException {
        LoginScreen loginScreen = new LoginScreen(mDriver);
        GmailScreen GmailScreen = new GmailScreen(mDriver);
        loginScreen.GetUseCaseDescription("Login_STC3", Constants.InstallLoginSheetNumber, mLogger);
        loginScreen.getCompanyId().setValue(company);
        mLogger.log(Status.PASS, "1: set company Id to : $company");
        //  loginScreen.CountryCode?.setValue(country)
        loginScreen.getCountryCode().click();
        loginScreen.getScrollCountry().click();
        loginScreen.getPhoneNumber().setValue(phone);
        mLogger.log(Status.PASS, "2 : set phone number to : $phone");
        loginScreen.getLogin().click();
        mLogger.log(Status.PASS, "3 : Click Login button");
        loginScreen.CheckDisplayedOfElement(loginScreen.getSenDEmail(), "Screen to confirm that application sent link by email");
        if (loginScreen.isElementDisplayed(loginScreen.getConfirmation())) {
            loginScreen.acceptAlert();
        }
        Thread.sleep(5000);
        loginScreen.startActivity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail");
        mLogger.log(Status.PASS, "4 : User should be redirected to gmail");
        GmailScreen.getNewMessageGmail().click();
        GmailScreen.getScrollGmail().click();
        Thread.sleep(2000);
        if (loginScreen.isElementDisplayed(loginScreen.getPopupAndroid())) {
            loginScreen.getOpenWith().click();
        }
        Thread.sleep(2000);
        if (loginScreen.isElementDisplayed(loginScreen.getConfirmation())) {
            loginScreen.acceptAlert();
            loginScreen.startActivity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail");
            GmailScreen.getNewMessageGmail().click();
            GmailScreen.getScrollGmail().click();
            Thread.sleep(2000);
            if (loginScreen.isElementDisplayed(loginScreen.getPopupAndroid())) {
                loginScreen.getOpenWith().click();
            }
            if (loginScreen.isElementDisplayed(loginScreen.getConfirmation())) {
                loginScreen.acceptAlert();
            }
            Thread.sleep(2000);
        }
        loginScreen.CheckDisplayedOfElement(loginScreen.getCongratulations(), "Screen to confirm that we are connected");
        loginScreen.getNext().click();
        if (loginScreen.isElementDisplayed(loginScreen.getAlertGeolocation())) {
            loginScreen.getOk().click();
        }
        mLogger.log(Status.PASS, "5 : with the link, User can navigate into the app");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
