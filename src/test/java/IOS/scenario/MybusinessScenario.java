package IOS.scenario;

import IOS.screen.ConversationScreen;
import IOS.screen.Mybusiness.*;
import IOS.screen.PermissionsScreen;
import IOS.screen.Settings.OptionScreen;
import IOS.screen.Settings.SettingsMoreScreen;
import IOS.screen.Settings.SettingsScreen;
import IOS.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.screen.STWScreen;
import framework.tester.STWAppiumTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class MybusinessScenario extends STWScenario {



    public MybusinessScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }





/* public void goToMyBusiness() throws InterruptedException {
        Thread.sleep(1000);
        tabBarScreen.getMybusinessItem().click();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

    }*/


    public void MyBusiness_STC1()  {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

        STWScreen.GetUseCaseDescription("MyBusiness_STC1", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();

        tabBarScreen.checkItemPositionInTabbar(3, "My Business");
        mLogger.log(Status.PASS, "  My Business icon button is displayed between the Channels and More buttons");
    }


    public void MyBusiness_STC2(String processName, String contact) throws InterruptedException, IOException {
        //mDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        STWScreen.GetUseCaseDescription("MyBusiness_STC2", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS,"Open my business");

        myBusinessScreen.deleteAllProcesses();
        mLogger.log(Status.PASS,"delete all process");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS,"click on start");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS,String.format("Search %s :",processName));

        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS,"click on first process in the search result");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS,"click on send process");

        myBusinessScreen.searchContactToSubmit(contact);  // submit process to Oneself
        mLogger.log(Status.PASS,String.format("Search contact %S :",contact));

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS,String.format("select the  contact %S :",contact));

        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS,"click on submit ");

        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS,"click on activity ");

        myBusinessScreen.clickOnNewCategoryOptions();
        mLogger.log(Status.PASS,"click on new cateogry options ");

        myBusinessScreen.expandNewCategory();

        mLogger.log(Status.PASS,"click on expand category ");

        myBusinessScreen.checkIfProcessIsReceivedInNew(processName);
        mLogger.log(Status.PASS,"process is well recieved in new category ");


    }


    public void MyBusiness_STC4() throws InterruptedException, IOException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);

        STWScreen.GetUseCaseDescription("MyBusiness_STC4", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);
        mLogger.log(Status.PASS, " User opens the app");
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " user go to my business");

        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, " user click on activity");

        myBusinessScreen.checkIfNewCategoryIsDisplayed();
        mLogger.log(Status.PASS, " new category is displayed");

        myBusinessScreen.checkIfDraftCategoryIsDisplayed();
        mLogger.log(Status.PASS, " draft category is displayed");

        myBusinessScreen.checkIfInProgressCategoryIsDisplayed();
        mLogger.log(Status.PASS, " in progress category is displayed");

        myBusinessScreen.checkIfSubmittedCategoryIsDisplayed();
        mLogger.log(Status.PASS, " submitted category is displayed");

        myBusinessScreen.checkIfCompletedCategoryIsDisplayed();
        mLogger.log(Status.PASS, " completed category is displayed");

        myBusinessScreen.checkIfCanceledCategoryIsDisplayed();
        mLogger.log(Status.PASS, " canceled category is displayed");


    }


    public void MyBusiness_STC5(String processName) throws InterruptedException, IOException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        screen.myBusiness.MyBusinessScreen myBusinessScreen1 = new screen.myBusiness.MyBusinessScreen(mDriver);
        SoftAssert softAssert = new SoftAssert();

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC5", Constants.MyBusiness_GeneralPresentaionSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " user opens my business");


        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, " user click on start tab");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS, String.format(" user search the process: %s",processName));

        myBusinessScreen1.checkProcessSearchResultInStartTab(processName);
        mLogger.log(Status.PASS, " The matched process is displayed with their category");

        softAssert.assertAll();


    }

    public void MyBusiness_STC7(String widgetName) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        ContactWidget contactWidget = new ContactWidget(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC7", Constants.MyBusiness_WidgetSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the the name: $s",widgetName));

        contactWidget.clickOnUseMyInfo();

        mLogger.log(Status.PASS, " the user click on use my info");

        contactWidget.checkIfContactFieldAreFilled();

        mLogger.log(Status.PASS, " the contact fields are filled");

    }


    public void MyBusiness_STC15(String widgetName, String contact, String bundleId, String title) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        UploadFileWidget uploadFileWidget = new UploadFileWidget(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC15", Constants.MyBusiness_WidgetSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));


        uploadFileWidget.uploadVideo();
        mLogger.log(Status.PASS, " user upload a video with sucess  ");

        uploadFileWidget.uploadContact(contact);

        mLogger.log(Status.PASS, " user upload a contact with sucess ");

        uploadFileWidget.uploadPicture();

        mLogger.log(Status.PASS, " user upload a picture with sucess ");

        uploadFileWidget.uploadCalendar(bundleId, title);
        mLogger.log(Status.PASS, " user upload a calendar with sucess ");

        uploadFileWidget.uploadLocation();
        mLogger.log(Status.PASS, " user upload a location with sucess ");

        uploadFileWidget.uploadDocument();
        mLogger.log(Status.PASS, " user upload a document with sucess ");


        uploadFileWidget.checkAttachementsDisplayed();
        mLogger.log(Status.PASS, " user check  all the attachement , all the attachement are displayed ");



    }


    public void MyBusiness_STC16(String widgetName) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        StarAndStopWidget starAndStopWidget = new StarAndStopWidget(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC16", Constants.MyBusiness_WidgetSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));

        starAndStopWidget.clickStartButton();
        mLogger.log(Status.PASS, String.format(" user click start button"));

        starAndStopWidget.clickStopButton();
        mLogger.log(Status.PASS, String.format(" user click stop button"));

        starAndStopWidget.VerifyDetails();
        mLogger.log(Status.PASS, String.format(" start information is filled in and stop information is filled in"));


    }

    public void MyBusiness_STC17(String widgetName ) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        AdressWidget adressWidget = new AdressWidget(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC17", Constants.MyBusiness_WidgetSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        myBusinessScreen.deleteAllProcesses();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));


        adressWidget.searchLocation("Santa");
        mLogger.log(Status.PASS, String.format(" User search for a location"));


        adressWidget.clickOnLocationFromSearchResult();
        mLogger.log(Status.PASS, String.format(" User click on location  from search result "));

        TimeUnit.SECONDS.sleep(2);
        adressWidget.clickOnShareLocation();
        mLogger.log(Status.PASS, String.format(" User click on button to share the location "));
        adressWidget.verifyTheFieldPopulated();
        mLogger.log(Status.PASS, String.format(" The address widget fields are auto-filled with the selected location\n" +
                " The Address, Zip Code, City and Country will be populated if the info is available when selecting a location"));



    }





    public void MyBusiness_STC19(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("myBusiness_STC19", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);


        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 2: User A presses on Start button");
        myBusinessScreen.searchProcessStart(processName);
        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 3: User A Clicks on Process ");
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactToSubmit();// submit process to another user
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 4: User A submit process to another user ");
        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandSubmittedCategory();
        myBusinessScreen.checkIfProcessIsInSubmitted(processName);
        mLogger.log(Status.PASS, "Step 5: User A checks if the process is submitted ");
    }

    public void Mybusiness_STC20(String processName, String contact,String contact2) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC20", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.recieveProcessInsubmittedCateogry(processName, contact2);
        mLogger.log(Status.PASS,  String.format(" User send  process %S: to %S",processName,contact2));

        myBusinessScreen.openRecievedProcessInSubmittedCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recived in submitted category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen.verifyDuplicateBtnIsDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is displayed "));

        myBusinessScreen.closeProcessOptions();
        mLogger.log(Status.PASS,  String.format(" User close process options"));

        mDriver.navigate().back();
        myBusinessScreen.recieveProcessIncompletedCateogry(processName,contact);
        mLogger.log(Status.PASS,  String.format(" User recieve a process in completed category"));

        myBusinessScreen.openRecievedProcessInCompletedCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recived in completed category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots options "));

        myBusinessScreen.verifyDuplicateBtnIsDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is displayed "));



    }

    public void Mybusiness_STC21(String processName, String contact) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC21", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.recieveProcessInNewCateogry(processName, contact);

        myBusinessScreen.openRecievedProcessInNewCategory();
        mLogger.log(Status.PASS,  String.format(" User opens the process recieved in new category"));

        myBusinessScreen.takeTheLead();
        mLogger.log(Status.PASS,  String.format(" User take the lead"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen.verifyDuplicateBtnIsNotDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is not displayed"));

        myBusinessScreen.closeProcessOptions();
        mDriver.navigate().back();
        myBusinessScreen.expandInProgressCategory();
        myBusinessScreen.openInProgressCategoryFirstProcess();
        mLogger.log(Status.PASS,  String.format(" User opens the process  in inprogress category"));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS,  String.format(" User click on three dots menu"));

        myBusinessScreen.verifyDuplicateBtnIsNotDisplayed();
        mLogger.log(Status.PASS,  String.format(" duplicate option is not displayed"));



    }

    public void MyBusiness_STC24(String processName) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("myBusiness_STC24", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 2: User A presses on Start button");
        myBusinessScreen.searchProcessStart(processName);
        myBusinessScreen.clickOnFirstSearchResultInStart();
        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        myBusinessScreen.clickOnProcessOptionsInThreeDots();
        mLogger.log(Status.PASS, "Step 3: User A goes to process options in three dots menu");
        Thread.sleep(1000);
        myBusinessScreen.activateScheduleOption();
        mLogger.log(Status.PASS, "Step 4: User A activates the schedule option");
        myBusinessScreen.verifyDisplayOfDetailsInSchedule();
        mLogger.log(Status.PASS, "Step 5: User A verifies the display of the schedule");
        myBusinessScreen.verifyDisplayOfCalender();
        mLogger.log(Status.PASS, "Step 6: User A verifies the display of the calender");
    }

    public void MyBusiness_STC25(String widgetName, String contact) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC25", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        myBusinessScreen.deleteAllProcesses();

        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user search the process of the widget and open the process with the name : %s",widgetName));

        myBusinessScreen.openDropDownSelectorAndSave();
        mLogger.log(Status.PASS, String.format(" user opens drown widget and select an option "));

        TimeUnit.SECONDS.sleep(2);
        myBusinessScreen.clearTextFully(myBusinessScreen.getTextFieldInput());
        myBusinessScreen.getTextFieldInput().sendKeys("Test");
        mLogger.log(Status.PASS, String.format(" user write something in text area "));

        myBusinessScreen.hideKeyboardWithDone();
        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, String.format(" user  click complete the process "));

        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactToSubmit();
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, String.format(" user   complete the process to himself "));

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, String.format(" user   click yes on confirm popup to confirm the completion "));

        myBusinessScreen.cancelSearch();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" user   initiate the same process again "));
        myBusinessScreen.openDropDownSelectorAndSave();
        mLogger.log(Status.PASS, String.format(" user   select the same option from dropdown list again "));

        TimeUnit.SECONDS.sleep(2);
        myBusinessScreen.verifyPreviousProcessData();
        mLogger.log(Status.PASS, String.format(" user check the previous data of the process and previous data are displayed "));





    }




    public void MyBusiness_STC26(String widgetName) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC26", Constants.MyBusiness_InitiateProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, String.format(" user go to my business "));

        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.initiateProcessFromStartTab(widgetName);
        mLogger.log(Status.PASS, String.format(" open the process named %s:  ",widgetName));

        myBusinessScreen.verifyProcessNameIsNotEnabled();
        myBusinessScreen.verifyToastOfNoRightToEditisDisplyed();
        mLogger.log(Status.PASS, String.format(" user verify A toast message will be dislayed \"No Right to edit Process name\" "));

    }

    public void Mybusiness_STC27_28(String processName, String contact) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC27", Constants.MyBusiness_CancelProcessSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User A goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact);
        myBusinessScreen.selectContactToSubmit();
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 3: User A sends the process to himself ");
        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandNewCategory();
        myBusinessScreen.openRecievedProcessInNewCategory();
        mLogger.log(Status.PASS, "Step 4: User A opens the process in New category ");
        myBusinessScreen.takeTheLead();
        mLogger.log(Status.PASS, "Step 5: User A takes the lead ");
        myBusinessScreen.cancelProcess();
        mLogger.log(Status.PASS, "Step 6: User A cancels the process ");
        myBusinessScreen.expandCanceledCategory();
        myBusinessScreen.checkIfProcessIsInCanceled(processName);
        myBusinessScreen.verifyDisplayDetailsInCanceledProcess();
        mLogger.log(Status.PASS, "Step 7: User A checks if process with details is in Canceled tab ");
    }


    public void MyBusiness_STC29(String processName) throws MalformedURLException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);


        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC29", Constants.MyBusiness_CompleteProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, String.format(" user open my business "));

        myBusinessScreen.deleteAllProcesses();

        myBusinessScreen.initiateProcessFromStartTab(processName);
        mLogger.log(Status.PASS, String.format(" user initiate process with the name :%s ",processName));

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, String.format(" user click complete process "));

        myBusinessScreen.verifyToastOfMultipleMandatoryFieldsisDisplyed();
        mLogger.log(Status.PASS, String.format("  A toast message is displayed : \"X fields not filled\" where the X represents the number of fields that were not filled in. "));

        myBusinessScreen.getTextFieldInput().sendKeys("test");
        mLogger.log(Status.PASS, String.format("  user insert text in text field widget"));

        myBusinessScreen.hideKeyboardWithDone();
        myBusinessScreen.getPhoneNumberFieldInput().sendKeys("90000000");
        mLogger.log(Status.PASS, String.format("  user insert number in phone widget"));

        myBusinessScreen.hideKeyboardWithDone();
        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, String.format("  user click on complete process"));

        myBusinessScreen.verifyToastOfOneMandatoryFieldisDisplyed();
        mLogger.log(Status.PASS, String.format("  A toast message is displayed : \"[Field Name] not filled\" where the [Field Name] is the name of the field that is not filled in."));



    }
    public void Mybusiness_STC30(String processName, String contact) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC30", Constants.MyBusiness_CompleteProcessSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, " searhch process in start and open it ");

        myBusinessScreen.completeProcess();
        mLogger.log(Status.PASS, " user click on complete process ");

        myBusinessScreen.searchContactToSubmit(contact);
        mLogger.log(Status.PASS, String.format( " user search contact %S: ",contact));

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, String.format( " user select the contact %S: ",contact));

        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, " user click on submit process ");

        myBusinessScreen.confirmBtn();
        mLogger.log(Status.PASS, " user click on confirm from the popup ");

        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandCompletedCategory();
        mLogger.log(Status.PASS, " user expand  complete category ");

        myBusinessScreen.checkIfCompletedByMeisDisplayed();
        mLogger.log(Status.PASS, " user check ' completed by me ' is displayed ");

        myBusinessScreen.openInCompletedCategoryFirstProcess();
        mLogger.log(Status.PASS, " user open the process in  the completed category ");

        myBusinessScreen.openHistoryofprocess();
        mLogger.log(Status.PASS, " user open the history of process  ");

        myBusinessScreen.verifyProcessHistory();
        mLogger.log(Status.PASS, " process history is displayed   ");


    }

    public void Mybusiness_STC33(String processName, String contact, String group) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC33", Constants.MyBusiness_SubmitProcessSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, " search process in start tab ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, " Process initiator  clicks on the floating button then Send process ");

        myBusinessScreen.verifyMbContactPickerBarElementsisDisplayed();
        mLogger.log(Status.PASS, " The adding recipient page is displayed and it has the following structure (iOS):\n" +
                "- On top: Back button, label \"Back\" + title: \"Contacts\" + 3 dots (by clicking in it : Conatct, Group, Save process, Close)\n" +
                "- Middle: Individual/Group Filter + Contacts in multiselection mode, by default no contact is selected ");

        myBusinessScreen.searchContactToSubmit(contact);

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, "  Process initiator  selects a contact ");

        myBusinessScreen.clearTextFully(myBusinessScreen.getSearchBarMBContactPicker());
        myBusinessScreen.clearTextFully(myBusinessScreen.getSearchBarMBContactPicker());

        myBusinessScreen.searchGroupToSubmit(group);
        mLogger.log(Status.PASS, " user search group ");

        myBusinessScreen.selectGroupToSubmit();
        mLogger.log(Status.PASS, "  Process initiator  selects a group ");


         mDriver.navigate().back();
        myBusinessScreen.sendProcess();

        mLogger.log(Status.PASS, "  user clicked send process ");

        myBusinessScreen.verifyPreviousRecipientsIsDisplayed();
        mLogger.log(Status.PASS, " Process initiator  clicks on the floating button then Send process ");


    }

    public void Mybusiness_STC36(String processName, String contact, String bundleId) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC36", Constants.MyBusiness_SubmitProcessSheetNumber, mLogger);

    try {
    tabBarScreen.goToMyBusiness();
    mLogger.log(Status.PASS, " User goes to My Business");

    myBusinessScreen.deleteAllProcesses();
    myBusinessScreen.enableAnddisableAirplanemode();
    mLogger.log(Status.PASS, " User turn off wifi");


    myBusinessScreen.openApp(bundleId);

    mLogger.log(Status.PASS, " User reopen totr");
    if (myBusinessScreen.isElementDisplayed(permissionsScreen.getOkBtn()))
        permissionsScreen.getOkBtn().click();

    tabBarScreen.goToMyBusiness();
    mLogger.log(Status.PASS, " User goes to My Business");

    myBusinessScreen.searchProcessInStartAndOpenIt(processName);
    mLogger.log(Status.PASS, " User search process and open it ");

    myBusinessScreen.sendProcess();
    mLogger.log(Status.PASS, " User send process  ");

    myBusinessScreen.searchContactToSubmit(contact);
    mLogger.log(Status.PASS, " search  contact  ");

    myBusinessScreen.selectContactToSubmit();
    mLogger.log(Status.PASS, " select contact  ");

    myBusinessScreen.submitProcess();
    mLogger.log(Status.PASS, " submit the   process  ");

    permissionsScreen.conifrmNoAvailableNetworkPopup();
    mLogger.log(Status.PASS, " the popup of no network is displayed  ");

    myBusinessScreen.clickOnActivity();
    mLogger.log(Status.PASS, " user go to activity  ");

    myBusinessScreen.expandSubmittedCategory();
    mLogger.log(Status.PASS, " user expand the submit category  ");

    myBusinessScreen.checkIfWaitingToBeSubmittedisDisplayed();
    mLogger.log(Status.PASS, " waiting to be submitted is displayed   ");

        }
        catch (Throwable throwable ) {

            Assert.fail("error", throwable.getCause());
        }
        finally {
        myBusinessScreen.enableAnddisableAirplanemode();
            }

}


    public void MyBusiness_STC63(String processName, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("myBusiness_STC63", Constants.MyBusiness_HistorySheetNumber, mLogger);


        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");
        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        myBusinessScreen.clickOnProcessOptionsInThreeDots();
        mLogger.log(Status.PASS, "Step 3: User A opens process options ");
        myBusinessScreen.activateScheduleOption();
        mLogger.log(Status.PASS, "Step 4: User A activates schedule option ");
        mDriver.navigate().back();
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact2);
        myBusinessScreen.selectContactToSubmit();

        myBusinessScreen.submitProcess();
        myBusinessScreen.clickOnActivity();
        Thread.sleep(2000);
        myBusinessScreen.expandSubmittedCategory();
        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 6: User A opens process in submitted tab ");
        myBusinessScreen.OpenProcessHistoryDetails();
        myBusinessScreen.verifyProcessHistoryDetails();
        mLogger.log(Status.PASS, "Step 7: User A verifies process history details ");

    }

    public void Mybusiness_STC64(String processName, String contact2) throws InterruptedException, IOException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC64", Constants.MyBusiness_HistorySheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.clickOnStart();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches and opens a process ");
        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        myBusinessScreen.clickOnProcessOptionsInThreeDots();
        mLogger.log(Status.PASS, "Step 3: User A opens process options ");
        myBusinessScreen.activateRepeatProcessOption();
        mLogger.log(Status.PASS, "Step 4: User A activates repeated option ");
        mDriver.navigate().back();
        myBusinessScreen.sendProcess();
        myBusinessScreen.searchContactToSubmit(contact2);
        myBusinessScreen.selectContactToSubmit();
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 5: User A submits process to another user");
        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandSubmittedCategory();
        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 6: User A opens process in submitted tab ");
        myBusinessScreen.verifyDisplayOfStopRepeatingOption();
        mLogger.log(Status.PASS, "Step 7: User A verifies the display of stop repreated option");
    }

    public void Mybusiness_STC37() throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC37", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);

        tabBarScreen.goToMore();
        settingsMoreScreen.clickOnSettings();
        mLogger.log(Status.PASS, " User goes to settings");


        settingsScreen.clickOnOptions();
        mLogger.log(Status.PASS, " User click options");

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
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC38", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User A goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches for a process and opens it ");
        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 3: User A fills in a text area widget in process ");
        myBusinessScreen.clickOnBackButtonAndClickOnNo();
        mLogger.log(Status.PASS, "Step 3: User A clicks on Back button and clicks on NO");
        myBusinessScreen.verifyDisplayOfStartScreen();
        mLogger.log(Status.PASS, "Step 4: User A checks that Start screen is displayed and the process in not saved");
        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 5: User A searches for a process and opens it ");
        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 6: User A fills in a text area widget in process ");
        myBusinessScreen.clickOnBackButtonAndConfirm();
        mLogger.log(Status.PASS, "Step 7: User A clicks on Back button and clicks on Yes");
        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandDraftCategory();
        myBusinessScreen.checkIfProcessIsInDraft(processName);
        mLogger.log(Status.PASS, "Step 8: User A checks that the process is saved in Draft");

    }

    public void Mybusiness_STC39(String processName) throws IOException, InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC39", Constants.MyBusiness_InProgressProcessSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, "Step 2: User A searches for a process and opens it ");
        myBusinessScreen.fillTextAreaWidget();
        mLogger.log(Status.PASS, "Step 3: User A fills in a text area widget in process ");
        mDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        TimeUnit.MINUTES.sleep(2);
        myBusinessScreen.clickOnBackButtonAndClickOnNo();
        mLogger.log(Status.PASS, "Step 4: User A clicks on Back button and clicks on NO");
        myBusinessScreen.clickOnActivity();
        myBusinessScreen.expandDraftCategory();
        myBusinessScreen.checkIfProcessIsInDraft(processName);
        mLogger.log(Status.PASS, "Step 7: User A checks that the process is saved in Draft");
    }


    public void Mybusiness_STC60(String processName, String contact) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC60", Constants.MyBusiness_HistorySheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, " User goes to My Business");

        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.searchProcessInStartAndOpenIt(processName);
        mLogger.log(Status.PASS, String.format(" User search process %s :",processName));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, String.format(" User click three dots options "));

        myBusinessScreen.verifyProcessHistoryButtonisNotDisplayed();

        mLogger.log(Status.PASS, String.format(" process history is not displayed  "));

    }

    public void Mybusiness_STC61(String processName, String contact2) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC61", Constants.MyBusiness_HistorySheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        myBusinessScreen.deleteAllProcesses();
        myBusinessScreen.recieveProcessInsubmittedCateogry(processName, contact2);
        mLogger.log(Status.PASS, String.format(" User recieved a process in submitted category "));

        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, String.format(" User open a process recieved in submitted category "));

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, String.format(" User click three dots options "));

        myBusinessScreen.verifyProcessHistoryButtonisDisplayed();
        mLogger.log(Status.PASS, String.format(" process history is  displayed  "));


    }

    public void myBusiness_STC45(String processName, String contact2) throws InterruptedException, MalformedURLException {

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC45", Constants.MyBusines_ConversationSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllProcesses();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");        myBusinessScreen.searchProcessStart(processName);
        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 6: Send process  ");

        myBusinessScreen.searchContactToSubmit(contact2);
        mLogger.log(Status.PASS, "Step 7: Search contact to submit  ");

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, "Step 8: Select contact to submit  ");
        Thread.sleep(5000);

        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 9: Submit the process  ");
        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, "Step 10: Click on activity   ");
        myBusinessScreen.expandSubmittedCategory();
        mLogger.log(Status.PASS, "Step 11: Expand submitted category   ");
        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 12: Open in submited category first process   ");
        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 13: Click on three dots menu of process   ");
        myBusinessScreen.clickOnChatWithRecipients();
        mLogger.log(Status.PASS, "Step 14 : Click on chat with recipents  ");
        conversationScreen.writeMessage("Hello");
        mLogger.log(Status.PASS, "Step 15: Write a message ");

        conversationScreen.sendMessage();
        mLogger.log(Status.PASS, "Step 16: Send a message ");

        for (int i = 1; i <= 2; i++) {

            mDriver.navigate().back();
            Thread.sleep(3000);
        }

        tabBarScreen.getChatsItem().click();
        conversationScreen.swipe(conversationScreen.getConversationPreview(), "left");
        mLogger.log(Status.PASS, "Step 17: Swipe to the left ");

        conversationScreen.deleteConversation();
        mLogger.log(Status.PASS, "Step 18: Delete a conversation ");

        Thread.sleep(2000);
        conversationScreen.confirmDelete();
        mLogger.log(Status.PASS, "Step 19: Confirm the delete ");



    }

    public void myBusiness_STC46(String processName, String contact2) throws InterruptedException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC46", Constants.MyBusines_ConversationSheetNumber, mLogger);
        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllProcesses();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");
        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");        myBusinessScreen.searchProcessStart(processName);
        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 6: Send process  ");

        myBusinessScreen.searchContactToSubmit(contact2);
        mLogger.log(Status.PASS, "Step 7: Search contact to submit  ");

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, "Step 8: Select contact to submit  ");
        Thread.sleep(5000);

        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 9: Submit the process  ");
        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, "Step 10: Click on activity   ");
        myBusinessScreen.expandSubmittedCategory();
        mLogger.log(Status.PASS, "Step 11: Expand submitted category   ");
        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 12: Open in submited category first process   ");
        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 13: Click on three dots menu of process   ");
        myBusinessScreen.clickOnChatWithRecipients();
        mLogger.log(Status.PASS, "Step 14 : Click on chat with recipents  ");
        conversationScreen.writeMessage("Hello");
        mLogger.log(Status.PASS, "Step 15: Write a message ");

        conversationScreen.sendMessage();
        mLogger.log(Status.PASS, "Step 16: Send a message ");

        for (int i = 1; i <= 2; i++) {

            mDriver.navigate().back();
            Thread.sleep(3000);
        }

        tabBarScreen.getChatsItem().click();
        conversationScreen.openConversation();
        mLogger.log(Status.PASS, "Step 17: Open the conversation  ");

        //Expected Result
        conversationScreen.checkIfTwoElementsAreIdentical(processName, conversationScreen.getTitleOfConversation().getText());

    }

    public void myBusiness_STC43(String processName, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC43", Constants.MyBusines_ConversationSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllProcesses();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");

        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 6: Send process  ");

        myBusinessScreen.searchContactToSubmit(contact2);
        mLogger.log(Status.PASS, "Step 7: Search contact to submit  ");

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, "Step 8: Select contact to submit  ");

        Thread.sleep(5000);
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 9: Submit the process  ");

        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, "Step 10: Click on activity   ");


        myBusinessScreen.expandSubmittedCategory();
        mLogger.log(Status.PASS, "Step 11: Expand submitted category   ");

        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 12: Open in submited category first process   ");

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 13: Click on three dots menu of process   ");

        myBusinessScreen. clickOnChatWithRecipients();
        mLogger.log(Status.PASS, "Step 14: Click on chat with recipients   ");


        conversationScreen.clickOnTileOfConversation();
        mLogger.log(Status.PASS, "Step 15: Click on title of conversation   ");

        //Expected Result
        if (conversationScreen.getLeaveConversationButton().getAttribute("accessible").equals("true")) {
            Assert.fail("The exit button is activated");
        }

    }


    public void myBusiness_STC47(String processName, String contact2) throws InterruptedException, MalformedURLException {
        MyBusinessScreen myBusinessScreen = new MyBusinessScreen(mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        myBusinessScreen.GetUseCaseDescription("MyBusiness_STC47", Constants.MyBusines_ConversationSheetNumber, mLogger);

        tabBarScreen.goToMyBusiness();
        mLogger.log(Status.PASS, "Step 1: User goes to My Business");

        myBusinessScreen.deleteAllProcesses();
        mLogger.log(Status.PASS, "Step 2: Delete all categories");

        myBusinessScreen.clickOnStart();
        mLogger.log(Status.PASS, "Step 3: Click On start process ");

        myBusinessScreen.searchProcessStart(processName);
        mLogger.log(Status.PASS, "Step 4: Search processName ");

        myBusinessScreen.clickOnFirstSearchResultInStart();
        mLogger.log(Status.PASS, "Step 5: click on search result  ");

        myBusinessScreen.clearInput(myBusinessScreen.getProcessNamTextField());
        mLogger.log(Status.PASS, "Step 6: Clear input 'processName'  ");

        String  newPocessName = myBusinessScreen.generateFakeName();
        myBusinessScreen.modifyProcessName(newPocessName);
        mLogger.log(Status.PASS, "Step 7: Modify processName ");

        myBusinessScreen.hideKeyboardIos();
        myBusinessScreen.sendProcess();
        mLogger.log(Status.PASS, "Step 9: SendProcess ");

        myBusinessScreen.searchContactToSubmit(contact2);
        mLogger.log(Status.PASS, "Step 10 : Search contact to submit ");

        myBusinessScreen.selectContactToSubmit();
        mLogger.log(Status.PASS, "Step 11 : Select contact to submit ");

        Thread.sleep(5000);
        myBusinessScreen.submitProcess();
        mLogger.log(Status.PASS, "Step 11 : Submit the process");

        myBusinessScreen.clickOnActivity();
        mLogger.log(Status.PASS, "Step 12: Click on activity");

        myBusinessScreen.expandSubmittedCategory();
        mLogger.log(Status.PASS, "Step 11: Expand submitted category   ");

        myBusinessScreen.openInSubmitedCategoryFirstprocess();
        mLogger.log(Status.PASS, "Step 12: Open in submited category first process   ");

        myBusinessScreen.clickOnThreeDotsMenuOfProcess();
        mLogger.log(Status.PASS, "Step 13: Click on three dots menu of process   ");


        myBusinessScreen.clickOnChatWithRecipients();
        mLogger.log(Status.PASS, "Step 14 : Click on chat with recipents  ");

        //Expected Result
        conversationScreen.checkIfTwoElementsAreIdentical(newPocessName, conversationScreen.getTitleOfConversation().getText());
        }


    @AfterMethod
    public void stopAppiumServer() {

        mDriver.close();

    }
}