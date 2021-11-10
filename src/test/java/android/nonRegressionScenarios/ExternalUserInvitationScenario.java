package android.nonRegressionScenarios;

import android.screen.ContactScreen;
import android.screen.ExternalUserInvitationScreen;
import android.screen.TabBarScreen;
import framework.scenario.STWScenario;
import framework.tester.STWAppiumTest;
import org.testng.Assert;

public class ExternalUserInvitationScenario extends STWScenario {
    public ExternalUserInvitationScenario(STWAppiumTest stwAppiumTest, String title, String description) {
        super(stwAppiumTest, title, description);
    }

    TabBarScreen tabBarScreen =  new TabBarScreen(mDriver);
    ContactScreen contactScreen =new ContactScreen(mDriver);
    ExternalUserInvitationScreen externalUserInvitationScreen=new ExternalUserInvitationScreen(mDriver);



    public void addExternalUser(String firstName,String lastName,String phoneNumber,String email,String details) throws InterruptedException {
        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();
        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);
        externalUserInvitationScreen.getEmail().sendKeys(email);
       // externalUserInvitationScreen.getEmailInvitationMode().click();
        externalUserInvitationScreen.getDetails().sendKeys(details);
        externalUserInvitationScreen.getSendInvitationButton().click();
        Thread.sleep(3000);
    }


    public void BusinessProcess4636TC1() throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        //SCENARIO 1:  Display of the form

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        Assert.assertTrue(externalUserInvitationScreen.getPhoneAdressBookButton().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getFirstName().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getLastName().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getEmail().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getPhoneNumber().isDisplayed());

        externalUserInvitationScreen.scrollUp(1,0);

        Assert.assertTrue( externalUserInvitationScreen.getSmsInvitationMode().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getEmailInvitationMode().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getDetails().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getSendInvitationButton().isDisplayed());
        Assert.assertTrue(externalUserInvitationScreen.getBackButton().isDisplayed());

    }

    public void BusinessProcess4636TC2(String firstName,String lastName,String phoneNumber,String email) throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        //SCENARIO 2:  Mandatory field is not fill in

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        //Test if send invitation button is active when all fields are filled
        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);
        externalUserInvitationScreen.getEmail().sendKeys(email);
       // externalUserInvitationScreen.getDetails().sendKeys("Details");
        Assert.assertTrue(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be enabled");

        //to check if FirstName is mandatory
        externalUserInvitationScreen.getFirstName().click();
        externalUserInvitationScreen.getFirstName().clear();
        externalUserInvitationScreen.getLastName().click();
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"First name is missing","Wrong error message for FirstName");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled,FirstName is mandatory");
        externalUserInvitationScreen.getFirstName().sendKeys(firstName);

        //to check if LastName is mandatory
        externalUserInvitationScreen.getLastName().click();
        externalUserInvitationScreen.getLastName().clear();
        externalUserInvitationScreen.getPhoneNumber().click();
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"Last name is missing","Wrong error message for LastName");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled,LastName is mandatory");
        externalUserInvitationScreen.getLastName().sendKeys(lastName);

        //to check if PhoneNumber is mandatory
        externalUserInvitationScreen.getPhoneNumber().click();
        externalUserInvitationScreen.getPhoneNumber().clear();
        externalUserInvitationScreen.getEmail().click();
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"Phone Number is missing","Wrong error message for phoneNumber");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled,PhoneNumber is mandatory");
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);

        //to check if mail is mandatory when emailInvitationMode is enabled
        if (!externalUserInvitationScreen.getSendInvitationButton().isEnabled())
            externalUserInvitationScreen.getSendInvitationButton().click();
        externalUserInvitationScreen.getEmail().click();
        externalUserInvitationScreen.getEmail().clear();
        mDriver.hideKeyboard();
        externalUserInvitationScreen.getDetails().click();
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"Email address is missing","Wrong error message for email");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled,Mail is mandatory when EmailInvitationMode is enabled");

    }



    public void BusinessProcess4636TC3(String firstName,String lastName,String phoneNumber,String email) throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        //SCENARIO 3:Wrong Email or phone number format

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);

        //To verify if error message is showed and SendInvitationButton is disabled when wrong phone number
        externalUserInvitationScreen.getPhoneNumber().click();
        externalUserInvitationScreen.getPhoneNumber().sendKeys("2333");// wrong phone number
        mDriver.hideKeyboard();// hide keyboard so we can click on the next element
        externalUserInvitationScreen.getEmail().click();//click on the next field
        externalUserInvitationScreen.getEmail().sendKeys(email);
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"Invalid phone number","Wrong error message for phone number");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled");



        //To verify if error message is showed and SendInvitationButton is disabled when wrong email
        externalUserInvitationScreen.getPhoneNumber().clear();
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);
        externalUserInvitationScreen.getEmail().clear();
        externalUserInvitationScreen.getEmail().sendKeys("gmail.com");//wrong email
        externalUserInvitationScreen.getPhoneNumber().click();
        mDriver.hideKeyboard();
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"Invalid email address","Wrong error message for email");
        Assert.assertFalse(externalUserInvitationScreen.getSendInvitationButton().isEnabled(),"error SendInvitationButton should be disabled");

    }



    public void BusinessProcess4636TC4(String firstName,String lastName,String phoneNumber,String email) throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        //Scenario 4: forbidden email domain
        //Note:yahoo.com is a forbidden email domain in the webAdmin /superAdmin

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);//you have to enter a non existing phone number
        externalUserInvitationScreen.getEmail().sendKeys(email);//forbidden email domain
        externalUserInvitationScreen.getSendInvitationButton().click();
        Thread.sleep(5000);
        System.out.println(externalUserInvitationScreen.getTextInputErrorMessage().getText());
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"The email domain is not allowed","Wrong error message for email");

    }


    public void BusinessProcess4636TC5(String firstName,String lastName,String phoneNumber,String email) throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        // Scenario 5: forbidden phone number country code
        //Note:(+49 Germany)is a forbidden phone country code in the webAdmin /superAdmin

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);
        externalUserInvitationScreen.getCountryCode().click();
        externalUserInvitationScreen.getScrollCountry().click();
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);//forbidden phone country code number
        externalUserInvitationScreen.getEmail().click();
        externalUserInvitationScreen.getEmail().sendKeys(email);
        externalUserInvitationScreen.getSendInvitationButton().click();
        Thread.sleep(5000);
        System.out.println(externalUserInvitationScreen.getTextInputErrorMessage().getText());
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorMessage().getText(),"The phone number country code is not allowed","Wrong error message for phone");



    }



    public void BusinessProcess4636TC6(String firstName,String lastName,String phoneNumber,String email) throws InterruptedException {
        //Story: Fill in manually the External users invitation form
        //Scenario 6 : Forbidden email domain and phone number country code
        //Note:(+49 Germany)is a forbidden phone country code in the webAdmin /superAdmin
        //Note:yahoo.com is a forbidden email domain in the webAdmin /superAdmin

        tabBarScreen.getContactItem();
        contactScreen.getExternalUserInvitationButton().click();

        externalUserInvitationScreen.getFirstName().sendKeys(firstName);
        externalUserInvitationScreen.getLastName().sendKeys(lastName);
        externalUserInvitationScreen.getCountryCode().click();
        externalUserInvitationScreen.getScrollCountry().click();
        externalUserInvitationScreen.getPhoneNumber().sendKeys(phoneNumber);//forbidden phone country code number
        externalUserInvitationScreen.getEmail().click();
        externalUserInvitationScreen.getEmail().sendKeys(email);//forbidden email domain
        externalUserInvitationScreen.getSendInvitationButton().click();
        Thread.sleep(5000);
        System.out.println(externalUserInvitationScreen.getTextInputErrorsMessagesList().get(0).getText());//phone number
        System.out.println(externalUserInvitationScreen.getTextInputErrorsMessagesList().get(1).getText());//email
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorsMessagesList().get(0).getText(),"The phone number country code is not allowed","Wrong error message for phone");
        Assert.assertEquals(externalUserInvitationScreen.getTextInputErrorsMessagesList().get(1).getText(),"The email domain is not allowed","Wrong error message for email");
    }



}
