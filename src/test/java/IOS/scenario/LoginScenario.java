package IOS.scenario;

import IOS.screen.LoginScreen;
import IOS.screen.PermissionsScreen;
import com.aventstack.extentreports.Status;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.annotations.AfterTest;

import java.io.IOException;

public class LoginScenario extends STWScenario {

    public LoginScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void login_STC3_STC4(String company, String countryName, String phone, String bundleId) throws InterruptedException, IOException {
     //   mLogger.log(Status.FAIL, "1: User cannot the app");

        LoginScreen loginScreen = new LoginScreen(mDriver);
        PermissionsScreen permissionsScren = new PermissionsScreen(mDriver);



        permissionsScren.acceptPermissions();



        loginScreen.setCompanyId(company);
        mLogger.log(Status.PASS, String.format(" set company Id to : %S ",company));

        loginScreen.clickOnContinue();
        mLogger.log(Status.PASS, " user clicked on button continue");

        loginScreen.setPhoneNumber(phone);
        mLogger.log(Status.PASS, String.format(" set phone number to : %S ",phone ));
        Thread.sleep(500);


        loginScreen.searchCountryAndClick(countryName);
        // loginScreen.getCountryCell().click();
        mLogger.log(Status.PASS,String.format(" set country code to : %S ",countryName ));

        loginScreen.ClickOnGO();
        mLogger.log(Status.PASS, "user click on go button");


        if (loginScreen.isElementDisplayed(loginScreen.getUseCurrentDevice()))
            loginScreen.getUseCurrentDevice().click();
        mLogger.log(Status.PASS, "verify if account already open or no");


        loginScreen.openActivationLinkFromMail(bundleId);
        mLogger.log(Status.PASS, "open activiation link from mail");

        permissionsScren.acceptPermissions();
        mLogger.log(Status.PASS, "accept permissions if displayed");

        loginScreen.verifyWelcomePage();
        mLogger.log(Status.PASS, "accept permissions if displayed");

        loginScreen.getValidButton().click();
        mLogger.log(Status.PASS, " user is directed to chats interface");


        mDriver.terminateApp(bundleId);
        mLogger.log(Status.PASS, " close Mail app");




    }

    @AfterTest
    public void AfterLogin(String bundleId) {
        if (mDriver != null) {

            mDriver.terminateApp(bundleId);

            mDriver.quit();


        }
    }
}
