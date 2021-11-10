package scenario;

import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import screen.ConversationScreen;

import java.io.IOException;

public class PerformanceScenarios extends STWScenario {


    public PerformanceScenarios(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    public void batchMessages(String account,int numberoFMessages) throws IOException, InterruptedException {
        ConversationScreen conversationScreen= new ConversationScreen(mDriver);


        conversationScreen.SelectContactConversation(account);
        conversationScreen.sendMultiplesMessages(numberoFMessages);


    }
}
