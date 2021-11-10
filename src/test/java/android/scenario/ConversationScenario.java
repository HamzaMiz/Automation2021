package android.scenario;

import IOS.screen.PermissionsScreen;
import android.screen.CallsScreen;
import android.screen.ContactScreen;
import android.screen.ConversationScreen;
import android.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ConversationScenario  extends STWScenario {
    public ConversationScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void Conversation_STC3 (String Account,String titleOfEvent) throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen conversationScreen=  new ConversationScreen(mDriver);
        ConversationScreen.GetUseCaseDescription("Conversation_STC3", Constants.Conversation_OneToOneSheetNumber,mLogger);
        dismissAlerts();
        conversationScreen.SelectContactConversation(Account);
        conversationScreen.sendsMessages();
        sendAttachments(Account,titleOfEvent);
        sendsMessageAndLongPress();
        checkOptionsOfMessage();


    }



    public void Conversation_STC2 (String Account) throws InterruptedException, MalformedURLException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC2", Constants.Conversation_OneToOneSheetNumber,mLogger);
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        dismissAlerts();
        checkOptionsOfConversationThread();
        selectContactConversation(Account);
        sendsMessages();
        ConversationScreen.back();
        checkOptionsOfLongPressConversation(Account);
        selectFirstConversation(Account);
        checkOptionsOfConversation();


    }

    public void Conversation_STC1 () throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen.GetUseCaseDescription("Conversation_STC1", Constants.Conversation_OneToOneSheetNumber,mLogger);
        dismissAlerts();
        checkOptionsOfConversationsTab();

    }


    public void conversationSTC5 (String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC5", Constants.Conversation_OneToManySheetNumber,mLogger);
        dismissAlerts();
        selectGroupConversation(GroupAccount);
        createGroupOfConversation(GroupAccount);
        checkDisplayOfPopupOnDuty();


    }

    public void conversationSTC8 (String GroupAccount, String titleOfEvent) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC8", Constants.Conversation_OneToManySheetNumber,mLogger);
        dismissAlerts();
        selectGroupConversation(GroupAccount);
        createGroupOfConversation(GroupAccount);
        sendsMessages();
        checkDisplayOfPopupOnDuty();
        sendAttachments("Lg G6",titleOfEvent);


    }
    public void conversationSTC7 (String GroupAccount) throws InterruptedException, IOException {


        ConversationScreen.GetUseCaseDescription("Conversation_STC7", Constants.Conversation_OneToManySheetNumber,mLogger);
        dismissAlerts();
        selectGroupConversation(GroupAccount);
        createGroupOfConversation(GroupAccount);
        editGroupOfConversation();
    }


    public void conversationSTC6 (String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC6", Constants.Conversation_OneToManySheetNumber,mLogger);
        dismissAlerts();
        selectGroupConversation(GroupAccount);
        createGroupOfConversation(GroupAccount);
        confirmContinuePopup();
        checkGroupOptionsFromContacts(GroupAccount);

    }



    public void conversationSTC9 (String Account1,String Account2) throws InterruptedException, MalformedURLException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC9", Constants.Conversation_OneToManySheetNumber,mLogger);
        dismissAlerts();
        createConversationOfSelectedAccounts(Account1,Account2);
        leaveConversation(Account1);

    }

    public void uploadLocation() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        ConversationScreen conversationScreen= new ConversationScreen ( mDriver);

        TimeUnit.SECONDS.sleep(1);

        // Upload location
        conversationScreen.getMessage_attachment_button().click();
        conversationScreen.getAttachment_location_item().click();

        TimeUnit.SECONDS.sleep(2);

        conversationScreen.getMapSearchButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(  conversationScreen.getMapSearchField()));

        conversationScreen.getMapSearchField().sendKeys("Tunis");
        conversationScreen.getLocationsSearchResult().get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable( conversationScreen.getMap_share_button()));
        conversationScreen.getMap_share_button().click();

        TimeUnit.SECONDS.sleep(4);
        conversationScreen.getSendTextOrAttachment().click();

    }


    public void uploadCalendar(String Account, String titleOfEvent) throws MalformedURLException, InterruptedException {
        mDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        ConversationScreen conversationScreen= new ConversationScreen ( mDriver);

        // Upload calendar
        conversationScreen.getMessage_attachment_button().click();

        conversationScreen.getAttachment_calendar().click();
        conversationScreen.getTodayButton().click();
        if (conversationScreen.isElementDisplayed(conversationScreen.getEventDetailsButton()) == false) {
            conversationScreen.createEventInCalendarForAndroid(titleOfEvent);
            conversationScreen.startActivity("com.streamwide.smartms","com.streamwide.smartms.ui.activity.MainActivity");
           openConversationFromChats(Account);
            conversationScreen.getMessage_attachment_button().click();
            conversationScreen.getAttachment_calendar().click();
            conversationScreen.getTodayButton().click();
            conversationScreen.getEventDetailsButton().click();
            conversationScreen.getSendEventButton().click();
            conversationScreen.getConfirSendButton().click();
            TimeUnit.SECONDS.sleep(2);
            conversationScreen.getSendTextOrAttachment().click();

        } else {
            conversationScreen.getEventDetailsButton().click();
            conversationScreen.getSendEventButton().click();
            conversationScreen.getConfirSendButton().click();
            TimeUnit.SECONDS.sleep(2);
            conversationScreen.getSendTextOrAttachment().click();

        }
    }

    public void uploadDocument() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        ConversationScreen conversationScreen= new ConversationScreen ( mDriver);

        conversationScreen.getMessage_attachment_button().click();

        conversationScreen.getAttachment_Document().click();
        wait.until(ExpectedConditions.elementToBeClickable(conversationScreen.getFileDocsButton())).click();

        TimeUnit.SECONDS.sleep(1);
        conversationScreen.getPdfFile().click(); // put a pdf file in documents
        TimeUnit.SECONDS.sleep(2);
        conversationScreen.getSendTextOrAttachment().click();
        TimeUnit.SECONDS.sleep(1);

    }


    public void uploadPhoto () throws InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);


        ConversationScreen.getMessage_attachment_button().click();
        ConversationScreen.getAttachment_Photo_item().click();
        ConversationScreen.getTakePhoto().click();
        wait.until(ExpectedConditions.elementToBeClickable(   ConversationScreen.getSwitchCamera())).click();

        ConversationScreen.getSwitchCamera().click();
        ConversationScreen.getSettingsOfCamera().click();
        Thread.sleep(5000);
        ConversationScreen.getOk_Item().click();
        ConversationScreen.getRecord_Photo().click();
        Thread.sleep(5000);
        ConversationScreen.getConfirm_media_result().click();
        Thread.sleep(5000);
        ConversationScreen.getSendTextOrAttachment().click();

    }

        public void uploadContact(String Account) throws MalformedURLException, InterruptedException {
            ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.getAttachment_contact_item().click();
            ConversationScreen.getSearchContactTextField().sendKeys(Account);
            ConversationScreen.ElementToClick(Account,0,1).click();
            ConversationScreen.getVcard_contact_Send_btn().click();
            ConversationScreen.getSendTextOrAttachment().click();
        }

        public void uploadVideo() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

            ConversationScreen.getMessage_attachment_button().click();
            ConversationScreen.getAttachment_Video_item().click();
            ConversationScreen.getCaptureVideo().click();
            ConversationScreen.getSwitchCamera().click();
            ConversationScreen.getRecord_Photo().click();
            Thread.sleep(5000);
            ConversationScreen.getRecord_Photo().click();
            wait.until(ExpectedConditions.elementToBeClickable( ConversationScreen.getConfirm_media_result()));
            ConversationScreen.getConfirm_media_result().click();
            Thread.sleep(5000);
            ConversationScreen.getSendTextOrAttachment().click();
            mLogger.log(Status.PASS, " 3 - A send multiple attachements to B");
            Thread.sleep(3000);
        }

    public void sendAttachments(String Account,String titleOfEvent) throws InterruptedException, MalformedURLException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        mLogger.log(Status.PASS, " A tries to send  every possible attachements + messages + voice records ");
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        //upload document
        //uploadDocument();
        //upload location
        uploadLocation();
        //upload calendar
       // uploadCalendar(Account,titleOfEvent);
        // Upload Contact

        uploadContact(Account);
        // Upload picture

            uploadPhoto();

        // Upload video
            uploadVideo();

//upload voice memo
        ConversationScreen.getVoiceRecordButton().click();
        Thread.sleep(5000);
        ConversationScreen.getSendVoiceRecord().click();
        mLogger.log(Status.PASS, " 4 - A send multiple voice records to B");



    }
    public void dismissAlerts(){
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        ConversationScreen.dismissAlert();
    }
    public void selectContactConversation(String Account) throws InterruptedException, MalformedURLException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();

        ConversationScreen.getConversationNewMessage().click();
        ConversationScreen.getSearchContact().click();

        ConversationScreen.getSearchContactTextField().sendKeys(Account);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(Account,0,1).click();
        ConversationScreen.getCheckButton().click();
        mLogger.log(Status.PASS, "1 - A open user B conversation");
    }

    public void sendsMessages(){
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable( ConversationScreen.getConversationTypeText()));

        //Send Messages
        ConversationScreen.getConversationTypeText().sendKeys("Hello");
        ConversationScreen.getSendTextOrAttachment().click();

        mLogger.log(Status.PASS, " 2- A send multiple messages to B");

    }
    public void sendsMessageAndLongPress() throws InterruptedException, MalformedURLException {
        //Send msg and Verify Long press options
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        ConversationScreen.getConversationTypeText().sendKeys("Hello");
        ConversationScreen.getSendTextOrAttachment().click();
        Thread.sleep(5000);

        ConversationScreen.LonPressOnString("Hello",0,0);
        mLogger.log(Status.PASS, " 5 - A scroll up in the thread");


    }

    public void openConversationFromChats(String Account) throws InterruptedException {
        ConversationScreen conversationScreen= new ConversationScreen ( mDriver);
        conversationScreen.getConversationSearch().click();
        conversationScreen.getConversationSearchTextField().sendKeys(Account);
        Thread.sleep(1000);
        conversationScreen.getConversationCell().get(0).click();

    }

    public void checkOptionsOfMessage() throws IOException, InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        mLogger.log(Status.PASS, " 6 - A long click on a messages");

        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMessage_details(),"Message Details");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDelete_message(),"Delete message");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCopy_text(),"Copy Text");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getFWD_BY_TOTR(),"Forward by TOTR");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getShare(),"Share");


        ConversationScreen.back();
    }
    public void checkOptionsOfConversationThread() throws IOException, InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen ( mDriver);

        tabBarScreen.getMessageItem();

        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getExternalConversation(),"External conversation tab");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMyCompanyConversation(),"My company tab");

    }
    public void checkOptionsOfLongPressConversation(String Account) throws InterruptedException, IOException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        Thread.sleep(3000);
        ConversationScreen.getConversationSearch().click();
        ConversationScreen.getConversationSearchTextField().sendKeys(Account);
        ConversationScreen.LonPressOnString(Account,0,1);

        mLogger.log(Status.PASS, "3 - Long click (or swipe left for iOS)on user B convrersation entry");

        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getDeleteConversation(),"Delete conversation");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getOpenConversation(),"Open Conversation");
        ConversationScreen.back();

    }
    public void selectFirstConversation(String Account) throws MalformedURLException, InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        ConversationScreen.ElementToClick(Account,0,1).click();
        mLogger.log(Status.PASS, "4 - Open a conversation");

    }
    public void checkOptionsOfConversation() throws IOException, InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);


        //check conversation one to one options
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getPTTOneToOne(),"PTT icon");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCallButton(),"New call icon");
        ConversationScreen.getCallButton().click();
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCall()," call ");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getVideo_Call(),"Video call");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConference_Call(),"Conference call");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getCellular_Call(),"Cellular call");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getBroadcast_Video(),"Broadcast_Video");
        ConversationScreen.back();
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMessage_attachment_button(),"Attachments icon");

        ConversationScreen.getMessage_attachment_button().click();
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_calendar()," Attachment Calendar ");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_contact_item(),"Attachment contact");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_location_item(),"Attachment location");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Document(),"Attachment Document ");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Photo_item(),"Attachment photo");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getAttachment_Video_item(),"Attachment video");





    }
    public void checkOptionsOfConversationsTab() throws IOException, InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getExternalConversation(),"External conversation tab");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getMyCompanyConversation(),"My company tab");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversation3dots(),"3 dots ");
        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getConversationSearch(),"Search ");

    }
    public void selectGroupConversation(String GroupAccount) throws InterruptedException, MalformedURLException {

        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen.getConversationNewMessage().click();

        ConversationScreen.getSearchContact().click();
        Thread.sleep(5000);
        ConversationScreen.getSearchContactTextField().sendKeys(GroupAccount);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(GroupAccount,0,1).click();
        ConversationScreen.getCheckButton().click();
    }
    public void createGroupOfConversation(String GroupAccount) throws InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        ConversationScreen.getConversationTypeText().sendKeys(GroupAccount);
        mLogger.log(Status.PASS, "4 - A types a message ");

        ConversationScreen.getSendTextOrAttachment().click();

        mLogger.log(Status.PASS, "5 - A clicks on send button ");
        mLogger.log(Status.PASS, " - A opens the group conversation ");
        Thread.sleep(2000);
    }
    public void checkDisplayOfPopupOnDuty() throws InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        CallsScreen CallsScreen= new CallsScreen ( mDriver);


        if(ConversationScreen.isElementDisplayed(CallsScreen.getPop_up_Of_OnDuty()))
        {   mLogger.log(Status.INFO,  " Pop_up_Of_OnDuty() option is displayed ");

        }else mLogger.log(Status.INFO,  " Pop_up_Of_OnDuty() option is NOT displayed ");
        Thread.sleep(2000);

    }


    public void editGroupOfConversation() throws InterruptedException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        mLogger.log(Status.INFO,  " Unable to edit group name on Android, waiting for the fix ");
        ConversationScreen.getGroupNameConversation().click();
        ConversationScreen.getEditGroupNameConversation().click();
        ConversationScreen.getEditGroupNameConversation().sendKeys("updated");
        ConversationScreen.getOk_Item().click();
        ConversationScreen.back();
    }

    public void checkGroupOptionsFromContacts(String GroupAccount) throws InterruptedException, IOException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        TabBarScreen tabScreen = new TabBarScreen(mDriver);
        ContactScreen contactScreen= new ContactScreen(mDriver);



        tabScreen.getContactItem();
        contactScreen.getSearchButton().click();
        contactScreen.getSearchContent().sendKeys(GroupAccount);
        ConversationScreen.LonPressOnString(GroupAccount,0,1);
        Thread.sleep(3000);
        ConversationScreen.CheckDisplayedOfElement(contactScreen.getNewGroupConversation(),"New conversation ");
        ConversationScreen.CheckDisplayedOfElement(contactScreen.getPTTCall(),"Push to talk ");
        ConversationScreen.CheckDisplayedOfElement(contactScreen.getConfCall(),"Conference call");

    }
    public void confirmContinuePopup() throws InterruptedException, MalformedURLException {
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        ConversationScreen.back();
        ConversationScreen.ElementToClick("Continue",0,0).click();

    }

    public void createConversationOfSelectedAccounts(String Account1, String Account2 ) throws InterruptedException, MalformedURLException {
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);
        ConversationScreen.getConversationNewMessage().click();
        ConversationScreen.getSearchContact().click();
        ConversationScreen.getSearchContactTextField().sendKeys(Account1);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(Account1,0,1).click();
        ConversationScreen.getSearchContactTextField().clear();
        ConversationScreen.getSearchContactTextField().sendKeys(Account2);
        Thread.sleep(3000);
        ConversationScreen.ElementToClick(Account2,0,1).click();
        ConversationScreen.getCheckButton().click();
        mLogger.log(Status.PASS, "1 - A open user B conversation");
        ConversationScreen.getGroupNameInput().sendKeys(Account1+Account2);
        ConversationScreen.getCreateThread().click();
    }


    public void leaveConversation(String newAdmin) throws InterruptedException, IOException {
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        tabBarScreen.getMessageItem();
        ConversationScreen ConversationScreen= new ConversationScreen ( mDriver);

        ConversationScreen.getGroupNameConversation().click();
        ConversationScreen.getExitFromConversation().click();
        if (ConversationScreen.isElementDisplayed(ConversationScreen.getOk_Item())){
            mLogger.log(Status.FAIL,  "  no network popup is displayed ");
            mLogger.addScreenCaptureFromPath(ConversationScreen.getscreenshot());

        }
        ConversationScreen.getContinueItem().click();
        ConversationScreen.getOk_Item().click();
        ConversationScreen.ElementToClick(newAdmin,0,0).click();
        ConversationScreen.getConfirmBtn().click();

        ConversationScreen.CheckDisplayedOfElement(ConversationScreen.getLeaveConversationMsg(),"You have left the conversation");

    }


    }