package scenario;


import framework.Branding;
import framework.Platforms;
import screen.ConversationScreen;
import framework.Constants;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.PermissionsScreen;

import java.io.IOException;
import java.net.MalformedURLException;

import static framework.Utility.mBranding;
import static framework.Utility.mPlatform;

public class ConversationScenario extends STWScenario {

    public ConversationScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void conversationSTC3(String account,String bundleId,String titleOfEvent) throws InterruptedException, MalformedURLException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC3", Constants.Conversation_OneToOneSheetNumber, mLogger);


        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        //conversationScreen.dismissAlerts();

        conversationScreen.deleteConversationOfUser(account);
        conversationScreen.SelectContactConversation(account);
        conversationScreen.sendsMessageAndSwipeLeftOrLongPress();

        conversationScreen.checkOptionsOfMessage();

        conversationScreen.sendsMessages();

        conversationScreen.sendAttachments(account, bundleId, titleOfEvent);



    }


    public void conversationSTC2(String Account) throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen.GetUseCaseDescription("Conversation_STC2", Constants.Conversation_OneToOneSheetNumber, mLogger);

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

        permissionsScreen.acceptPermissions();
        conversationScreen.dismissAlerts();

        conversationScreen.SelectContactConversation(Account);

        conversationScreen.sendsMessages();
        conversationScreen.back();

        conversationScreen.conversationSwipeLeft(Account);

        conversationScreen.checkOptionsOfConversationThread();

        conversationScreen.selectFirstConversation(Account);
        if(Platforms.IOS.equals(mPlatform)) {
            if(Branding.TOTR.equals(mBranding))
            conversationScreen.selectFirstConversation(Account);
        }
        conversationScreen.checkOptionsOfConversation();


    }

    public void conversationSTC1() throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen.GetUseCaseDescription("Conversation_STC1", Constants.Conversation_OneToOneSheetNumber, mLogger);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);

        permissionsScreen.acceptPermissions();

        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.dismissAlerts();
        conversationScreen.checkOptionsOfConversationsTab();


    }

    public void conversationSTC5(String GroupAccount) throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen.GetUseCaseDescription("Conversation_STC5", Constants.Conversation_OneToManySheetNumber, mLogger);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        conversationScreen.dismissAlerts();
        conversationScreen.selectGroupConversation(GroupAccount);


        conversationScreen.createGroupOfConversation(GroupAccount);

        conversationScreen.sendsMessages();


    }


    public void conversationSTC8(String GroupAccount,String contactAttachment,String bundleId,String titleOfEvent) throws InterruptedException, MalformedURLException, IOException {
        ConversationScreen.GetUseCaseDescription("Conversation_STC8", Constants.Conversation_OneToManySheetNumber, mLogger);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.dismissAlerts();

        conversationScreen.selectGroupConversation(GroupAccount);


        conversationScreen.createGroupOfConversation(GroupAccount);
        conversationScreen.sendsMessages();


        conversationScreen.sendAttachments(contactAttachment, bundleId, titleOfEvent);


    }


    public void conversationSTC7(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC7", Constants.Conversation_OneToManySheetNumber, mLogger);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.dismissAlerts();

        conversationScreen.selectGroupConversation(GroupAccount);


        conversationScreen.createGroupOfConversation(GroupAccount);

        conversationScreen.editGroupOfConversation(GroupAccount);


    }

    public void conversationSTC9(String Account1, String Account2) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC9", Constants.Conversation_OneToManySheetNumber, mLogger);
        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        conversationScreen.dismissAlerts();
        conversationScreen.createConversationOfSelectedAccounts(Account1, Account2);
        conversationScreen.leaveConversation(Account1);


    }



    public void conversationSTC6(String GroupAccount) throws InterruptedException, IOException {

        ConversationScreen.GetUseCaseDescription("Conversation_STC6", Constants.Conversation_OneToManySheetNumber, mLogger);

        PermissionsScreen permissionsScreen = new PermissionsScreen(mDriver);
        permissionsScreen.acceptPermissions();
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        conversationScreen.dismissAlerts();

        conversationScreen.selectGroupConversation(GroupAccount);

        conversationScreen.createGroupOfConversation(GroupAccount);

        conversationScreen.back();
        conversationScreen.checkGroupOptionsFromContacts(GroupAccount);


    }



}
