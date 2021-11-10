package android.scenario;

import android.screen.ConversationScreen;
import android.screen.TabBarScreen;
import android.screen.mybusiness.AdressWidget;
import android.screen.mybusiness.ContactWidget;
import android.screen.mybusiness.MyBusinessScreen;
import android.screen.mybusiness.StarAndStopWidget;
import android.screen.settings.OptionScreen;
import android.screen.settings.SettingsMoreScreen;
import android.screen.settings.SettingsScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static framework.screen.STWScreen.GetUseCaseDescription;

public class MyBusinessScenario extends STWScenario {



    public MyBusinessScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }




    public void MyBusiness_STC1() throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC1", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();

        myBusinessScreen.checkMybusinessPositionInTabBar();

        mLogger.log(Status.PASS, "  My Business icon button is displayed between the Channels and More buttons");

    }


    public void doMyBusiness_STC2(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC2", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS,"Open my business");
        myBusinessScreen.deleteAllprocessesInAllCategories();
        mLogger.log(Status.PASS,"delete all process");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS,"click on start");
        myBusinessScreen.searchProcessinStartTab(processName);
        mLogger.log(Status.PASS,String.format("Search %s :",processName));

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS,"click on first process in the search result");

        myBusinessScreen.clickOnProcessFloatingActions();


        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS,"click on send process");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS,String.format("Search contact :%S ",contact));

        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS,String.format("select the  contact :%S and submit ",contact));


        myBusinessScreen.checkIfProcessDetailsAreDisplayedInAnyCategory(processName);
        mLogger.log(Status.PASS,"process is well recieved in new category ");

    }

    public void MyBusiness_STC4() throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC4", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);
        mLogger.log(Status.PASS, " User opens the app");

        myBusinessScreen.openMybusiness();

        mLogger.log(Status.PASS, " User goes to My Business");

        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, " user click on activity");

        myBusinessScreen.checkNewCategoryIsDisplayed();
        mLogger.log(Status.PASS, " new category is displayed");

        myBusinessScreen.checkDraftCategoryIsDisplayed();
        mLogger.log(Status.PASS, " draft category is displayed");

        myBusinessScreen.checkInProgressCategoryIsDisplayed();
        mLogger.log(Status.PASS, " in progress category is displayed");

        myBusinessScreen.checkSubmittedCategoryIsDisplayed();
        mLogger.log(Status.PASS, " submitted category is displayed");

        myBusinessScreen.checkCompletedCategoryIsDisplayed();
        mLogger.log(Status.PASS, " completed category is displayed");

        myBusinessScreen.checkCanceledCategoryIsDisplayed();
        mLogger.log(Status.PASS, " canceled category is displayed");


    }

    public void MyBusiness_STC5(String processName) throws InterruptedException, IOException {

        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC5", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);
        mLogger.log(Status.PASS, " User opens the app");
        myBusinessScreen.openMybusiness();

        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, " user click on start tab");

        myBusinessScreen.searchProcessinStartTab(processName);
        mLogger.log(Status.PASS, String.format(" user search the process: %s",processName));

        myBusinessScreen.hideKeyboard();

        myBusinessScreen.checkProcessSearchResultInStartTab();
        mLogger.log(Status.PASS, " The matched process is displayed with their category");


    }

    public void MyBusiness_STC7(String widgetName) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        ContactWidget contactWidget = new ContactWidget(mDriver);

        GetUseCaseDescription("MyBusiness_STC7", Constants.MyBusiness_WidgetSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessinStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget with the name: $s",widgetName));

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, String.format(" user  open the process with the the name: $s",widgetName));

        contactWidget.clickOnUseMyInfo();
        mLogger.log(Status.PASS, " the user click on use my info");


        contactWidget.checkIfContactFieldAreFilled();

        mLogger.log(Status.PASS, " the contact fields are filled");

    }

   /* public void MyBusiness_STC15(String widgetName) throws InterruptedException, MalformedURLException {
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC15", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        initiateProcessFromStartTab(widgetName);
       *//* uploadFileWidget.uploadVideo();
        uploadFileWidget.uploadContact(contact);
        uploadFileWidget.uploadPicture();
        uploadFileWidget.uploadCalendar(bundleId,title);
        uploadFileWidget.uploadLocation();
        uploadFileWidget.uploadDocument();

        uploadFileWidget.checkAttachementsDisplayed();*//*
        uploadFileWidget.uploadPicture();


    }*/

    public void MyBusiness_STC16(String widgetName) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        StarAndStopWidget starAndStopWidget = new StarAndStopWidget(mDriver);
        TabBarScreen  tabBarScreen = new TabBarScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC16", Constants.MyBusiness_WidgetSheetNumber, mLogger);
        tabBarScreen.getMyBusinessItem();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));

        starAndStopWidget.clickStartButton();
        mLogger.log(Status.PASS, String.format(" user click start button"));

        starAndStopWidget.clickStopButton();
        mLogger.log(Status.PASS, String.format(" user click stop button"));

        Thread.sleep(1000);
        starAndStopWidget.verifyDetails();
        mLogger.log(Status.PASS, String.format(" start information is filled in and stop information is filled in"));



    }

    public void myBusiness_STC17(String widgetName) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        AdressWidget adressWidget = new AdressWidget(mDriver);
        TabBarScreen  tabBarScreen = new TabBarScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC17", Constants.MyBusiness_WidgetSheetNumber, mLogger);
        tabBarScreen.getMyBusinessItem();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));

        adressWidget.searchLocation("Santa");
        mLogger.log(Status.PASS, String.format(" User search for a location"));

        adressWidget.clickOnLocationFromSearchResult();
        TimeUnit.SECONDS.sleep(1);
        adressWidget.clickOnShareLocation();
        mLogger.log(Status.PASS, String.format(" User click on button to share the location "));

        TimeUnit.SECONDS.sleep(1);
        adressWidget.verifyTheFieldPopulated();
        mLogger.log(Status.PASS, String.format(" The address widget fields are auto-filled with the selected location\n" +
                " The Address, Zip Code, City and Country will be populated if the info is available when selecting a location"));


    }

    public void MyBusiness_STC19(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("myBusiness_STC19", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen. clickOnStart();
        mLogger.log(Status.PASS, "Step 2: User A presses on Start button");

        myBusinessScreen.searchProcessinStartTab(processName);
        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 3: User A Clicks on Process ");

        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 4: User A submit process to another user ");

        myBusinessScreen.clickOnActivity();
        myBusinessScreen.checkIfProcessDetailsAreDisplayedInAnyCategory(processName);
        mLogger.log(Status.PASS, "Step 5: User A checks if the process is submitted ");

    }


    public void Mybusiness_STC20(String processName, String contact, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC20", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.recieveProcessInsubmittedCateogry(processName, contact2);
        mLogger.log(Status.PASS,  String.format(" User send  process %S: to %S",processName,contact2));

        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recived in submitted category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen. verifyDuplicateBtnIsDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is displayed "));

        mDriver.navigate().back();
        mDriver.navigate().back();
        myBusinessScreen.recieveProcessIncompletedCateogry(processName, contact);
        mLogger.log(Status.PASS,  String.format(" User recieve a process in completed category"));

        myBusinessScreen.collapseSubmittedCategory();
        myBusinessScreen.openTheFirstRecievedProcessInCompletedCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recived in completed category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots options "));

        myBusinessScreen.verifyDuplicateBtnIsDisplayed();

        mLogger.log(Status.PASS,  String.format(" duplicate option is displayed "));

    }


    public void Mybusiness_STC21(String processName, String contact) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC21", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, " User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.recieveProcessInNewCateogry(processName, contact);

        myBusinessScreen.expandNewCategory();
        myBusinessScreen.openTheFirstRecievedProcessInNewCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recieved in new category"));

        myBusinessScreen.takeTheLead();
        mLogger.log(Status.PASS,  String.format(" User take the lead"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen.verifyDuplicateBtnIsNotDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is not displayed"));


        // expandInProgressCategory();
        myBusinessScreen.openTheFirstRecievedProcessInProgressCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process  in inprogress category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen.verifyDuplicateBtnIsNotDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is not displayed"));


    }

    public void MyBusiness_STC24(String processName, int i, int j) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("myBusiness_STC24", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 2: User A presses on Start button");

        myBusinessScreen.searchProcessinStartTab(processName);
        myBusinessScreen.clickOnSearchResultInStartTab();
        myBusinessScreen.goToProcessOptions();
        mLogger.log(Status.PASS, "Step 3: User A goes to process options in three dots menu");

        myBusinessScreen.verifyDisplayOfProcessOption(2);

        myBusinessScreen.activateProcessOption(2);
        mLogger.log(Status.PASS, "Step 4: User A activates the schedule option");

        myBusinessScreen.verifyDisplayOfdetailsInSchedule();
        mLogger.log(Status.PASS, "Step 5: User A verifies the display of the schedule");

        myBusinessScreen.verifyDisplayOfCalender();

        mLogger.log(Status.PASS, "Step 6: User A verifies the display of the calender");

    }

    public void MyBusiness_STC25(String widgetName, String contact) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
            TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        GetUseCaseDescription("MyBusiness_STC25", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
            tabBarScreen.getMyBusinessItem();
            myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));

        myBusinessScreen.selectOptionFromDropDownWidget();
        mLogger.log(Status.PASS, String.format(" user opens drown widget and select an option "));

        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.elementToBeClickable(myBusinessScreen.getTextArea().get(0)));
        myBusinessScreen.getTextArea().get(0).clear();
        myBusinessScreen.getTextArea().get(0).sendKeys("Test");
        mLogger.log(Status.PASS, String.format(" user write something in text area "));

        myBusinessScreen.completeProcess();
        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactTosubmit();
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, String.format(" user   complete the process to himself "));

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, String.format(" user   click yes on confirm popup to confirm the completion "));


        TimeUnit.SECONDS.sleep(1);
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user   initiate the same process again "));

        myBusinessScreen.selectOptionFromDropDownWidget();
        mLogger.log(Status.PASS, String.format(" user   select the same option from dropdown list again "));

        TimeUnit.SECONDS.sleep(2);
        myBusinessScreen.verifyPreviousProcessData();
        mLogger.log(Status.PASS, String.format(" user check the previous data of the process and previous data are displayed "));


    }

    public void MyBusiness_STC26(String widgetName) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC26", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
        tabBarScreen.getMyBusinessItem();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" open the process named %s:  ",widgetName));

        myBusinessScreen.verifyProcessNameIsNotEnabled();
        mLogger.log(Status.PASS, String.format(" user verify A toast message will be dislayed \"No Right to edit Process name\" "));



    }


    public void mybusiness_STC27_28(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC27", Constants.MyBusiness_CancelProcessSheetNumber, mLogger);
        myBusinessScreen. openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User A goes to My Business");

        myBusinessScreen. deleteAllprocessesInAllCategories();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessinStartTab(processName);
        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");

        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 3: User A sends the process to himself ");

        myBusinessScreen.clickOnActivity();
        myBusinessScreen.openTheFirstRecievedProcessInNewCategory();
        mLogger.log(Status.PASS, "Step 4: User A opens the process in New category ");

        myBusinessScreen.takeTheLead();
        mLogger.log(Status.PASS, "Step 5: User A takes the lead ");

        myBusinessScreen.cancelProcess();
        mLogger.log(Status.PASS, "Step 6: User A cancels the process ");

        myBusinessScreen.verifyTheDisplayOfFirstProcessInCancelCategory();
        myBusinessScreen.checkIfProcessDetailsAreDisplayedInAnyCategory(processName);
        mLogger.log(Status.PASS, "Step 7: User A checks if process with details is in Canceled tab ");



    }

    public void MyBusiness_STC29(String widgetName) throws  InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC29", Constants.MyBusiness_CompleteProcessSheetNumber, mLogger);
        tabBarScreen.getMyBusinessItem();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user initiate process with the name :%s ",widgetName));

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, String.format(" user click complete process "));


        myBusinessScreen.verifyToastOfMultipleMandatoryFieldsisDisplyed();
        mLogger.log(Status.PASS, String.format("  A toast message is displayed : \"X fields not filled\" where the X represents the number of fields that were not filled in. "));

        myBusinessScreen.getTextArea().get(1).sendKeys("test");
        mLogger.log(Status.PASS, String.format("  user insert text in text field widget"));

        myBusinessScreen.getPhoneNumTextField().sendKeys("90000000");
        mLogger.log(Status.PASS, String.format("  user insert number in phone widget"));

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, String.format("  user click on complete process"));


        myBusinessScreen.verifyToastOfOneMandatoryFieldisDisplyed();
        mLogger.log(Status.PASS, String.format("  A toast message is displayed : \"[Field Name] not filled\" where the [Field Name] is the name of the field that is not filled in."));


    }


    public void Mybusiness_STC30(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC30", Constants.MyBusiness_CompleteProcessSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, " searhch process in start and open it ");

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, " user click on complete process ");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS, String.format( " user search contact %S: ",contact));

        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, String.format( " user select the contact %S: ",contact));

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, " user click on confirm from the popup ");

        myBusinessScreen.clickOnActivity();
        myBusinessScreen.checkIfProcessDetailsAreDisplayedInAnyCategory(processName);
        mLogger.log(Status.PASS, " user check ' completed by me ' is displayed ");

        myBusinessScreen.openTheFirstRecievedProcessInCompletedCategory();
        mLogger.log(Status.PASS, " user open the process in  the completed category ");

        myBusinessScreen.openHistoryOfProcess();
        mLogger.log(Status.PASS, " user open the history of process  ");

        myBusinessScreen.verifyProcessHistory();
        mLogger.log(Status.PASS, " process history is displayed   ");

    }

    public void Mybusiness_STC33(String processName, String contact, String group) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC33", Constants.MyBusiness_SubmitProcessSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, " search process in start tab ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, " Process initiator  clicks on the floating button then Send process ");

        myBusinessScreen.verifyMbContactPickerBarElementsisDisplayed();
        mLogger.log(Status.PASS, " The adding recipient page is displayed and it has the following structure (iOS):\n" +
                "- On top: Back button, label \"Back\" + title: \"Contacts\" + 3 dots (by clicking in it : Conatct, Group, Save process, Close)\n" +
                "- Middle: Individual/Group Filter + Contacts in multiselection mode, by default no contact is selected ");

        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactTosubmit();
        mLogger.log(Status.PASS, "  Process initiator  selects a contact ");

        myBusinessScreen.clickBack();
        myBusinessScreen.searchGroupToSubmit(group);
        mLogger.log(Status.PASS, " user search group ");

        myBusinessScreen.selectGroupToSubmit();
        mLogger.log(Status.PASS, "  Process initiator  selects a group ");

        myBusinessScreen.clickBack();
        myBusinessScreen.clickBack();
        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "  user clicked send process ");

        myBusinessScreen.verifyPreviousRecipientsIsDisplayed();
        mLogger.log(Status.PASS, " Process initiator  clicks on the floating button then Send process ");


    }


    public void Mybusiness_STC36(String processName, String contact2) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("Mybusiness_STC36", Constants.MyBusiness_SubmitProcessSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();

        myBusinessScreen.deleteAllprocessesInAllCategories();
        //myBusinessScreen.setNetworkConnection(false, false, false);
       // myBusinessScreen.setAndroidDeviceAirplaneMode(true);
        myBusinessScreen.disableWifiAndData();
        mLogger.log(Status.PASS, " User turn off wifi");

        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, " User search process and open it ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, " User send process  ");

        myBusinessScreen.searchContactToSubmit(contact2);
        mLogger.log(Status.PASS, " search  contact  ");

        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, " select contact  ");
        mLogger.log(Status.PASS, " submit the   process  ");

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, " the popup of no network is displayed  ");

        myBusinessScreen.checkIfWaitingToBeSubmittedisDisplayed();
        mLogger.log(Status.PASS, " waiting to be submitted is displayed   ");

      //  myBusinessScreen.setNetworkConnection(false, true, false);
        //myBusinessScreen.setAndroidDeviceAirplaneMode(false);
        myBusinessScreen.enableWifiAndData();

       // myBusinessScreen.enableBluetooth();


    }

    public void Mybusiness_STC37() throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC37", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);

        tabBarScreen.getMoreItem();
        settingsMoreScreen.clickOnSettings();
        mLogger.log(Status.PASS, " User goes to settings");

        settingsScreen.clickOnOptions();
        mLogger.log(Status.PASS, " User click options");

        optionScreen.scrollToAnElementByText(mDriver, "Process QR code");
        optionScreen.verifyProcessAutosavingIsDisplayed();
        mLogger.log(Status.PASS, " Check that the following content is displayed :\n" +
                "Option title: \"Process Auto-Saving\"\n" +
                "Info label: \"Your edited processes are auto-saved as In Progress each 2 minutes\"\n" +
                "ON/OFF button\n");

        optionScreen.verifyProcessAutosavingIsActivatedByDefault();
        mLogger.log(Status.PASS, "  Check that by default , Process Auto-Saving option is ON");


    }

    public void Mybusiness_STC38(String processName) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC38", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User A goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessinStartTab(processName);
        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 2: User A searches for a process and opens it ");

        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 3: User A fills in a text area widget in process ");

        myBusinessScreen.clickOnBackButtonAndClickOnNo();
        mLogger.log(Status.PASS, "Step 3: User A clicks on Back button and clicks on NO");

        myBusinessScreen.verifyDisplayOfStartScreen();
        mLogger.log(Status.PASS, "Step 4: User A checks that Start screen is displayed and the process in not saved");

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 5: User A searches for a process and opens it ");

        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 6: User A fills in a text area widget in process ");

        myBusinessScreen.clickOnBackButtonAndConfirm();
        mLogger.log(Status.PASS, "Step 7: User A clicks on Back button and clicks on Yes");

        myBusinessScreen.verifyDisplayOfFirstProcessInDraftCategory(processName);
        mLogger.log(Status.PASS, "Step 8: User A checks that the process is saved in Draft");

    }

    public void Mybusiness_STC39(String processName) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC39", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches for a process and opens it ");

        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 3: User A fills in a text area widget in process ");

        mDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        TimeUnit.MINUTES.sleep(2);
        myBusinessScreen.clickOnBackButton();
        mLogger.log(Status.PASS, "Step 4: User A clicks on Back button and clicks on NO");

        myBusinessScreen.clickOnActivity();
        myBusinessScreen.verifyDisplayOfFirstProcessInDraftCategory(processName);
        mLogger.log(Status.PASS, "Step 7: User A checks that the process is saved in Draft");

    }


    public void Mybusiness_STC43(String processName, String contact) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessinStartTab(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");

        myBusinessScreen. clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen. sendProcess();
        mLogger.log(Status.PASS, "Step 6: Send process  ");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS, "Step 7: Search contact to submit  ");

        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 8: Select contact and submit  ");

        Thread.sleep(5000);
        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, "Step 9: Open the first recieved process in submitted category  ");

        myBusinessScreen. clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 10: Click on three dots menu of process  ");

        myBusinessScreen.ClickOnchatWithRecipients();
        mLogger.log(Status.PASS, "Step 11: Click on chat with recipients  ");

        myBusinessScreen.clickOnRecipientName();
        mLogger.log(Status.PASS, "Step 12: Click on  recipient name  ");



    }

    public void doMybusiness_stc47(String processName, String contact) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);


        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen. deleteAllprocessesInAllCategories();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessinStartTab(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");


        myBusinessScreen.clearInput(myBusinessScreen.getProcessNamTextFieldWithEdit());
        mLogger.log(Status.PASS, "Step 6: Clear input 'processName'  ");

        String  newPocessName = myBusinessScreen.generateFakeName();
        myBusinessScreen.modifyProcessName(newPocessName);
        mLogger.log(Status.PASS, "Step 7: Modify processName ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 9: SendProcess ");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS, "Step 10 : Search contact to submit ");


        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 11 : Select contact and submit ");


        Thread.sleep(5000);
        Thread.sleep(5000);

        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, "Step 12 : Open the first recieved process  ");

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 13 : Click on three dots menu of process  ");

        myBusinessScreen.ClickOnchatWithRecipients();
        mLogger.log(Status.PASS, "Step 14 : Click on chat with recipents  ");



        conversationScreen.checkIfTwoElementsAreIdentical(newPocessName,conversationScreen.getGroupNameConversation().getText());
    }

    public void doMybusiness_STC45(String processName, String contact) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        GetUseCaseDescription("MyBusiness_STC45", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen. deleteAllprocessesInAllCategories();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessinStartTab(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 9: SendProcess ");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS, "Step 10 : Search contact to submit ");
        myBusinessScreen.searchContactToSubmit(contact);


        Thread.sleep(5000);
        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, "Step 11 : Open the first recieved process  ");

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 12 : Click on three dots menu of process  ");

        myBusinessScreen.ClickOnchatWithRecipients();
        mLogger.log(Status.PASS, "Step 13 : Click on chat with recipents  ");
        for (int i = 1; i <= 2; i++) {

            mDriver.navigate().back();
            Thread.sleep(3000);
        }

        tabBarScreen.getMessageItem();
        Thread.sleep(3000);
        myBusinessScreen.deleteThreadProcess();
        Thread.sleep(3000);





    }


    public void doMybusiness_STC46(String processName, String contact, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);



            Thread.sleep(5000);
            //Steps
        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen. deleteAllprocessesInAllCategories();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 3: Search process in start and open it");

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, "Step 4: Complete proces");

        myBusinessScreen.searchContactsToSubmit(contact, contact2);
        mLogger.log(Status.PASS, "Step 5: Search contacts");

        myBusinessScreen.getContactSelectionFloating().click();
        mLogger.log(Status.PASS, "Step 6: Get contacts selection on floating");

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, "Step 7: Confirm");

        Thread.sleep(3000);
            myBusinessScreen.openTheFirstRecievedProcessInCompletedCategory();
        mLogger.log(Status.PASS, "Step 8: Open the first recieved process in completed category");

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 9: Click on three dots menu of process");

        myBusinessScreen.ClickOnchatWithRecipients();
        mLogger.log(Status.PASS, "Step 10: Click on chat with recipents");

        //Expected Result
            myBusinessScreen.checkThatTheDiscussionNameIsSimilarTheProcessName(processName);


    }


    public void Mybusiness_STC60(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);


        GetUseCaseDescription("MyBusiness_STC60", Constants.MyBusiness_HistorySheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, " User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, String.format(" User search process %s :",processName));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        myBusinessScreen.verifyProcessHistoryButtonisNotDisplayed();
        mLogger.log(Status.PASS, String.format(" process history is not displayed  "));



    }

    public void Mybusiness_STC61(String processName, String contact2) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC61", Constants.MyBusiness_HistorySheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.recieveProcessInsubmittedCateogry(processName, contact2);
        mLogger.log(Status.PASS, String.format(" User recieved a process in submitted category "));

        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, String.format(" User open a process recieved in submitted category "));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, String.format(" User click three dots options "));

        myBusinessScreen.verifyProcessHistoryButtonisDisplayed();
        mLogger.log(Status.PASS, String.format(" process history is  displayed  "));



    }

    public void Mybusiness_STC63(String processName, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("myBusiness_STC63", Constants.MyBusiness_HistorySheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessinStartTab(processName);

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");

        myBusinessScreen.goToProcessOptions();
        mLogger.log(Status.PASS, "Step 3: User A opens process options ");

        myBusinessScreen.verifyDisplayOfProcessOption(2);
        myBusinessScreen.activateProcessOption(2);
        mLogger.log(Status.PASS, "Step 4: User A activates schedule option ");

        myBusinessScreen.clickBack();
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact2);
        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 5: User A submits process to another user");

        Thread.sleep(2000);
        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, "Step 6: User A opens process in submitted tab ");

        myBusinessScreen.OpenProcessHistoryDetails();
        myBusinessScreen.verifyProcessHistory();
        mLogger.log(Status.PASS, "Step 7: User A verifies process history details ");

    }


    public void Mybusiness_STC64(String processName, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        GetUseCaseDescription("MyBusiness_STC64", Constants.MyBusiness_HistorySheetNumber, mLogger);

        myBusinessScreen.openMybusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllprocessesInAllCategories();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessinStartTab(processName);

        myBusinessScreen.clickOnSearchResultInStartTab();
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");

        myBusinessScreen.goToProcessOptions();
        mLogger.log(Status.PASS, "Step 3: User A opens process options ");

        myBusinessScreen.activateRepeatProcessOption();
        mLogger.log(Status.PASS, "Step 4: User A activates repeated option ");

        myBusinessScreen.clickBack();
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact2);
        myBusinessScreen.selectContactAndSubmit();
        mLogger.log(Status.PASS, "Step 5: User A submits process to another user");

        Thread.sleep(2000);
        myBusinessScreen.openTheFirstRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS, "Step 6: User A opens process in submitted tab ");

        myBusinessScreen.verifyDisplayOfStopRepeatingOption();
        mLogger.log(Status.PASS, "Step 7: User A verifies the display of stop repreated option");

    }


}



