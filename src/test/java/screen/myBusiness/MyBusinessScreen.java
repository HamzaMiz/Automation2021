package screen.myBusiness;

import android.screen.ConversationScreen;
import com.aventstack.extentreports.Status;
import framework.Branding;
import framework.Platforms;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import screen.TabBarScreen;
import screen.settings.OptionScreen;
import screen.settings.SettingsMoreScreen;
import screen.settings.SettingsScreen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class MyBusinessScreen extends STWScreen {


    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search\"])[1]", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][1]", priority = 2)
    @AndroidFindBy(id = "view_my_business_search_content")
    private MobileElement activitySearchBar;

    //search bar button(For both Activity/Start)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "fragment_my_business_search_floating_button")
    @AndroidFindBy(id="my_business_search")
    private MobileElement searchBtn;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[contains(@name, 'Search')]", priority = 2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][2]", priority = 1)
    @AndroidFindBy(id = "view_my_business_search_content")
    private MobileElement startSearchBar;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[cd] 'ResourcesViewController_categoryName' AND visible == 1")
    private List <MobileElement> categoryName;

    @AndroidFindBy(id = "view_group_my_business_expandable_list_title")
    private List<MobileElement> categoryNameAndroid;


    @iOSXCUITFindBy(accessibility = "processNameTextField")
    private MobileElement processNamTextField;
    @AndroidFindBy(id = "activity_process_form_process_name_text")
    private MobileElement processNamTextFieldWithoutEdit;
    @AndroidFindBy(id = "activity_process_form_process_name_edit")
    private MobileElement processNamTextFieldWithEdit;


    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement activitySearchBarCancelBtn;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancelSearchBtn;


    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "ResourcesTableViewCell_processName")
    private MobileElement processSearchResult;


    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "wrapperView1_0")
    @AndroidFindBy(id = "activity_my_business_contact_selection_floating_action_menu")
    @AndroidFindBy(id = "activity_process_form_floating_action_menu")
    private MobileElement processFloatingAction;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private List<AndroidElement> processFloatingActionAndroid;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "wrapperView1_2")
    private MobileElement sendProcess;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton[1]")
    private List<AndroidElement> sendProcessAndroid;
    @WithTimeout(time = 6L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"ContactCell_name\"])[2]")
    private MobileElement contactCellName;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Please fill the 3 mandatory fields highlighted in red\"`]")
    private MobileElement mandatoryFieldsToast;



    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_customBarButtonItem")
    private MobileElement backBtnFromMbContactPicker;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_moreBarButton")
    private MobileElement moreBtnFromMbContactPicker;
    @iOSXCUITFindBy(accessibility = "text_1")
    private MobileElement textFieldInput;
    @iOSXCUITFindBy(accessibility = "PhoneTextFieldCell_phoneNumTextField")
    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumberFieldInput;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Save\"`]")
    private MobileElement saveBtn;
    @iOSXCUITFindBy(accessibility = "DropDownCell_selectorButton")
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement dropdownSelector;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '3')]")
    private MobileElement dropDownSelectorFirstItem;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save process\"]")
    private MobileElement saveProcessInsideMoreFromMbContactPicker;
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    private MobileElement closeInsideMoreFromMbContactPicker;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Contacts\"]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Contacts\"`]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    private MobileElement contactsLabelFromMbContactPicker;

    @AndroidFindBy(id = "menu_action_search")
    private MobileElement searchBtnFromMbContactPicker;
    @AndroidFindBy(id = "txtTitle")
    private MobileElement contactsfilterFromMbContactPicker;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    private MobileElement allLabelFromMbContactPicker;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_filterBarButtonindividuals")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact']")
    private MobileElement individualLabelFromMbContactPicker;
   @iOSXCUITFindBy(accessibility = "MBPickerViewController_filterBarButtonGroups")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Group']")
    private MobileElement groupLabelFromMbContactPicker;
    @AndroidFindBy(id = "menu_action_save_process")
    private MobileElement saveBtnFromMbContactPicker;
    //
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`]", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]", priority = 2)
    private MobileElement close;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ResourceCreationViewController_moreBarButton\"]", priority = 1)
    @iOSXCUITFindBy(accessibility = "ResourceCreationViewController_moreBarButton", priority = 2)
    @AndroidFindBy(id = "menu_process_form_activity_all_actions")
    private MobileElement threeDotsMenuOfProcess;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'titleVersionLabel_')]")
    private List<MobileElement> historyVersions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Process history\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Process history']")
    private MobileElement processHistoryFromProcessOptions;
    @AndroidFindBy(id = "content")
    private List<MobileElement> processOptionsMenuItems;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Step recipients\"]")
    private MobileElement StepRecipientsFromProcessOptions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Forward process\"]")
    private MobileElement forwardProcessFromProcessOptions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Duplicate process\"]")
    private MobileElement DuplicateProcessFromProcessOptions;
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Duplicate process\"`]", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Duplicate process\"]", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Duplicate process']")
    private MobileElement duplicateProcess;
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_okButton")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmPopup;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_oldRecipientsView")
    @AndroidFindBy(id = "activity_my_business_contact_selection_previous_recipients_text_view")
    private MobileElement oldRecipientsViewFromMbContactPicker;
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"ConversationList deselect\" AND name == \"ContactCellPiker_checkbox\"")
    private MobileElement contactCheckBox;
    @iOSXCUITFindBy(accessibility = "MyBusinessCell_processTitle")
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_name")
    private MobileElement processTitleIncategories;
    @iOSXCUITFindBy(accessibility = "ResourcesTableViewCell_processName")
    private MobileElement processTitleInStarttab;
    //contact search
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`]")
    @AndroidFindBy(id = "contact_search_content")
    private MobileElement searchBarMBContactPicker;

    @AndroidFindBy(id = "menu_action_search")
    private MobileElement searchBtnMBContactPicker;
    ;
    // contact filter indivuduals or group
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_filterBarButtonindividuals")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact']")
    private MobileElement invidividualsMBContactPicker;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_filterBarButtonGroups")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Group']")
    private MobileElement groupsMBContactPicker;


    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement contactCell;
    @AndroidFindBy(id = "check_selected_contact")
    private MobileElement checkSelectedContact;

    @iOSXCUITFindBy(accessibility = "wrapperView1_1")
    private MobileElement completeProcess;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton[2]")
    private List<AndroidElement> completeProcessAndroid;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement startSearchBarCancelBtn;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Activity")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Activity\"]")
    @AndroidFindBy(id = "view_switch_left_container")
    private MobileElement activityItem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Start",priority=2)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Start\"`]",priority = 1)
    @AndroidFindBy(id = "view_switch_right_container")
    @AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Start\"]",priority = 1)
    private MobileElement startItem;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_0",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_0\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'NEW (0)')]")
    private MobileElement newCategory;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_1",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_1\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'DRAFT (0)')]")
    private MobileElement draftCategory;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_2",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_2\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'IN PROGRESS (0)')]")
    private MobileElement inProgressCategory;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_3",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_3\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'SUBMITTED (0)')]")
    private MobileElement submittedCategory;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_4",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_4\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'COMPLETED (0)')]")
    private MobileElement completedCategory;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_5",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrangeBtn_5\"`][1]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[starts-with(@name, 'CANCELED (0)')]")
    private MobileElement canceledCategory;
    //New category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_0")
    private MobileElement newCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_0")
    private MobileElement newCategorySortButton;
    //@FindBy(how= How.XPATH, xpath="(//XCUIElementTypeCell[@name=\"MBPickerViewController_0_0\"])[2]/XCUIElementTypeButton[2]")
    //WebElement contactCell;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_0", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_0\"])[1]", priority = 1)
    private MobileElement newCategoryOptionButton;
    @AndroidFindBy(id = "view_group_my_business_expandable_list_menu_button")
    private List<MobileElement> categoryOptionButton;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_group_my_business_expandable_list_icon")
    private List<MobileElement> expandButton;


    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_container_layout")
    private List<MobileElement> processCellInAnycategorie;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_0_0", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'MyBusinessViewController_0_0')]", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"MyBusinessViewController_0_0\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther",priority = 2)
    private MobileElement newCategoryFirstProcess;
    //Draft category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_1")
    private MobileElement draftCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_1")
    private MobileElement draftCategorySortButton;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_1", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_1\"])[1]", priority = 1)
    private MobileElement draftCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_1_0")
    private MobileElement draftCategoryFirstProcess;
    //inProgress category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_2")
    private MobileElement inProgressCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_2")
    private MobileElement inProgressCategorySortButton;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_2", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_2\"])[1]", priority = 1)
    private MobileElement inProgressCategoryOptionButton;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_2_0")
    private MobileElement inProgressCategoryFirstProcess;
    //Submitted category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_3")
    private MobileElement submittedCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_3")
    private MobileElement submittedCategorySortButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_3", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_3\"])[1]", priority = 1)
    private MobileElement submittedCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_3_0")
    private MobileElement submittedCategoryFirstProcess;
    //Completed category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_4")
    private MobileElement completedCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_4")
    private MobileElement completedCategorySortButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_4", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_4\"])[1]", priority = 1)
    private MobileElement completedCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_4_0")
    private MobileElement completedCategoryFirstProcess;
    //Canceled category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_5")
    private MobileElement canceledCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_5")
    private MobileElement canceledCategorySortButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "moreFilter_5", priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_5\"])[1]", priority = 1)
    private MobileElement canceledCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_5_0")
    private MobileElement canceledCategoryFirstProcess;
    //Process Actions by swipe
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"MyBusinessViewController_buttonOpen\"])")
    private MobileElement openProcess;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"MyBusinessViewController_buttonDelete\"])")
    private MobileElement deleteProcess;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"MyBusinessViewController_buttonHistorique\"])")
    private MobileElement historyProcess;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"MyBusinessViewController_buttonEdit\"])")
    private MobileElement editProcess;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"MyBusinessViewController_buttonFarward\"])")
    private MobileElement forwardProcess;
    /*  //Forward process actions elements
      @iOSXCUITFindBy(iOSClassChain = "")
      private MobileElement forwardByApp;
      @iOSXCUITFindBy(iOSClassChain = "")
      private MobileElement forwardByMail;
  */
    //Option button elements
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"MyBusinessViewController_setSectionAction\"`]")
    private MobileElement collapseCategory;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_markReadProcessAction")
    private MobileElement ReadAllCategory;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_deleteAction")
    private MobileElement deleteAllProcesses;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "MyBusinessCell_processDetail")
    private MobileElement statusbyMeLabel;

    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_status")
    private List<MobileElement> processStatus;

    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_sender_name")
    private List<MobileElement> processSenderName;
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_last_update_date")
    private List<MobileElement> processLastUpdateDate;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CustomAlertView_ok\"]", priority = 1)
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmDeleteAllProcesses;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CustomAlertView_ok\"]", priority = 1)
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmPopUp;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_cancelAction")
    private MobileElement cancelbTn;
    //Filters screen elements
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_showFilterButtonItem")
    private MobileElement ShowResults;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_cancelButtonItem")
    private MobileElement cancel;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_0_0")
    private MobileElement filterByName;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_0_1")
    private MobileElement filterByDate;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_0_2")
    private MobileElement filterByPriority;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_0_3")
    private MobileElement filterBycategory;
    @iOSXCUITFindBy(accessibility = "FilterProcessViewController_deleteButton")
    private MobileElement resetFilters;
    //Filter by name elements
    @iOSXCUITFindBy(accessibility = "TypeOfFilterProcessViewController_0_0")
    private MobileElement startedByFilter;
    @iOSXCUITFindBy(accessibility = "TypeOfFilterProcessViewController_0_1")
    private MobileElement OwnerFilter;
    @iOSXCUITFindBy(accessibility = "TypeOfFilterProcessViewController_0_2")
    private MobileElement ReceveiverFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Apply\"`]")
    private MobileElement applyFilter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Back\"`]")
    private MobileElement cancelFilter;
    // process options after clicking on the three dots menu of an opened process
    @iOSXCUITFindBy(accessibility = "Process options")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Process options']")
    private MobileElement processOptions;
    //Elements in each option item

    @AndroidFindBy(id = "view_my_business_options_item_header_toggle")
    private List<MobileElement> processOptionsSwitchers;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Schedule\"`]")
    private MobileElement scheduleSwitcher;
    @AndroidFindBy(id = "date_picker_header")
    private MobileElement datePickerHeader;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Due Date\"`]")
    private MobileElement duedateSwitcher;
    @iOSXCUITFindBy(accessibility = "PriorityCell_switchPriority")
    private MobileElement prioritySwitcher;
    @iOSXCUITFindBy(accessibility = "Start Date and Time")
    private MobileElement startDateTime;
    @AndroidFindBy(id = "view_custom_date_picker_date_piker_button")
    private List<MobileElement> datePickerIcon;
    @AndroidFindBy(id = "view_custom_date_picker_date_piker_info")
    private List<MobileElement> datePickerInfo;
    @AndroidFindBy(id = "view_custom_date_picker_date_piker")
    private List<MobileElement> dateAndTime;
    @iOSXCUITFindBy(accessibility = "TextFieldCellDate_btnClick")
    private MobileElement calenderIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    private MobileElement saveCalender;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
    private MobileElement cancelCalender;
    //Element of edit group of conversation
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "recipient_names")
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_titleView",priority = 1)
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label")
    private MobileElement groupNameConversation;
 @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
 @AndroidFindBy(id = "recipient_names")
    @iOSXCUITFindBy(accessibility = "STWMessagesViewController_titleView")
    @iOSXCUITFindBy(accessibility = "CustomNavigationBarTitleView_title_label",priority = 1)
    private MobileElement conversationTitle;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ProcessDataSource_0_0\"]/XCUIElementTypeOther/XCUIElementTypeTextView",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"ProcessDataSource_0_0\"`]/XCUIElementTypeOther/XCUIElementTypeTextView",priority = 2)
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextView\"")
    private MobileElement textArea;
    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> textAreaAndroid;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ResourceCreationViewController__backButton")
    @AndroidFindBy(accessibility = "Navigate up",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",priority = 0)
    private MobileElement backButton;

    @iOSXCUITFindBy(accessibility = "You are about to exit the process. Save your process?")
    private MobileElement saveProcessconfirmPopUp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"No\"]")
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesBtn;
    // options available after clicking on "process options " after clicking on three dots menu of an opened process
    //Table widget
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"table_0\"`]")
    //**/XCUIElementTypeTextField[`name == "table_0"`]
    private List<MobileElement> widgetNumberInsideTable;
    @iOSXCUITFindBy(id = "number_0")
    private MobileElement widgetNumberOutsideTable;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"CurrencyCell_currencyTextField\"`]")
    //**/XCUIElementTypeTextField[`name == "CurrencyCell_currencyTextField"`]
    private List<MobileElement> widgetCurrency;
    // Elements displayed when Schedule option is activated
    @iOSXCUITFindBy(accessibility = "Preview table")
    private MobileElement previewRows;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"headerExpandButton_0\"`]")
    //**/XCUIElementTypeButton[`label == "headerExpandButton_0"`]
    private List<MobileElement> rowTable;
    @iOSXCUITFindBy(accessibility = "ResourcesTableViewCell_processName")
    private MobileElement firstSearchedProcess;

    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "resource_process_item_title")
    private List<MobileElement> firstSearchedProcessForAndroid;
    @iOSXCUITFindBy(accessibility = "Next:")
    private MobileElement nextButton;
    // elements in text area widget
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RESULT\"`]")
    private MobileElement stepProcess;
    @iOSXCUITFindBy(accessibility = "Process history")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Process history']")
    private MobileElement processHistory;
    @iOSXCUITFindBy(accessibility = "Step recipients")
    private MobileElement stepRecipients;
    @iOSXCUITFindBy(accessibility = "Chat with recipients")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chat with the recipients']")
    private MobileElement chatWithRecipients;
    @iOSXCUITFindBy(accessibility = "Save process")
    private MobileElement saveProcess;
    @iOSXCUITFindBy(accessibility = "Untake the lead")
    private MobileElement untakeTheLead;
    @iOSXCUITFindBy(accessibility = "Cancel process")
    private MobileElement cancelProcess;
    @AndroidFindBy(id = "title")
    private List<MobileElement> optionItems;
    @iOSXCUITFindBy(accessibility = "Conference Call")
    private MobileElement conferenceCall;
    @iOSXCUITFindBy(accessibility = "titleVersionLabel_0")
    private MobileElement historyProcessDetailVersion;
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private List<MobileElement> historyProcessdateVersion;
    @AndroidFindBy(id = "history_process_item_detail_version")
    private List<MobileElement> historyProcessDetailVersionAndroid;
    @iOSXCUITFindBy(accessibility = "OptionsProcessViewController_switchRepeat")
    @AndroidFindBy(id = "activity_my_business_options_repeat_toggle")
    private MobileElement repeatProcessOptionSwitcher;

    @iOSXCUITFindBy(accessibility = "Stop Repeating")
    private MobileElement stopRepeatingOption;
    @iOSXCUITFindBy(id = "item_mybusiness_expandable_list_process_sender_name")
    private MobileElement senderName;
    @iOSXCUITFindBy(id = "item_mybusiness_expandable_list_process_status")
    private MobileElement canceledBy;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"No available network\"`]")
    private MobileElement noNetworkPopupTitle;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == \"OK\"`]",priority = 2)
    private MobileElement okBtn;

    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"ConversationListViewController_buttonDeletes\"])[2]")
    private MobileElement deleteConversationBtn;

    private String  newPocessName;
    public MyBusinessScreen(AppiumDriver driver) {

        super(driver);
         newPocessName = this.getFakeName();

    }


    // Elements in three dots menu in a process after taking the lead


    public MobileElement getStartSearchBarCancelBtn() {
        return startSearchBarCancelBtn;
    }

    public MobileElement getContactCellName() {
        return contactCellName;
    }

    public MobileElement getMandatoryToast() {
        return mandatoryFieldsToast;
    }

    public MobileElement getTextFieldInput() {
        return textFieldInput;
    }

    public MobileElement getPhoneNumberFieldInput() {
        return phoneNumberFieldInput;
    }

    public MobileElement getSaveBtn() {
        return saveBtn;
    }

    public MobileElement getDropdownSelector() {
        return dropdownSelector;
    }

    public MobileElement getProcessTitleIncategories() {
        return processTitleIncategories;
    }

    public MobileElement getProcessTitleInStarttab() {
        return processTitleInStarttab;
    }

    public MobileElement getContactCell() {
        return contactCell;
    }

    public MobileElement getSenderName() {
        return senderName;
    }

    public MobileElement getCanceledBy() {
        return canceledBy;
    }


    public MobileElement getStopRepeatingOption() {
        return stopRepeatingOption;
    }

    public MobileElement getRepeatProcessOptionSwitcher() {
        return repeatProcessOptionSwitcher;
    }

    public MobileElement getHistoryProcessDetailVersion() {
        return historyProcessDetailVersion;
    }

    public MobileElement getProcessHistory() {
        return processHistory;
    }

    public MobileElement getStepRecipients() {
        return stepRecipients;
    }

    public MobileElement getChatWithRecipients() {
        return chatWithRecipients;
    }

    public List<MobileElement> getTextAreaAndroid() {
        return textAreaAndroid;
    }

    public MobileElement getSaveProcess() {
        return saveProcess;
    }

    public MobileElement getUntakeTheLead() {
        return untakeTheLead;
    }

    public MobileElement getCancelProcess() {
        return cancelProcess;
    }

    public MobileElement getConferenceCall() {
        return conferenceCall;
    }

    public MobileElement getTextArea() {
        return textArea;
    }

    public MobileElement getBackButton() {
        return backButton;
    }

    public MobileElement getSaveProcessconfirmPopUp() {
        return saveProcessconfirmPopUp;
    }

    public MobileElement getYesBtn() {
        return yesBtn;
    }

    public MobileElement getNoBtn() {
        return noBtn;
    }


    public MobileElement getCancelSearchBtn() {
        return cancelSearchBtn;
    }

    public MobileElement getBackBtnFromMbContactPicker() {
        return backBtnFromMbContactPicker;
    }

    public MobileElement getMoreBtnFromMbContactPicker() {
        return moreBtnFromMbContactPicker;
    }

    public MobileElement getSaveProcessInsideMoreFromMbContactPicker() {
        return saveProcessInsideMoreFromMbContactPicker;
    }

    public MobileElement getCloseInsideMoreFromMbContactPicker() {
        return closeInsideMoreFromMbContactPicker;
    }

    public MobileElement getContactsLabelFromMbContactPicker() {
        return contactsLabelFromMbContactPicker;
    }

    public MobileElement getInvidividualsMBContactPicker() {
        return invidividualsMBContactPicker;
    }

    public MobileElement getGroupsMBContactPicker() {
        return groupsMBContactPicker;
    }

    public MobileElement getStartDateTime() {
        return startDateTime;
    }

    public MobileElement getCalenderIcon() {
        return calenderIcon;
    }

    public MobileElement getSaveCalender() {
        return saveCalender;
    }

    public MobileElement getCancelCalender() {
        return cancelCalender;
    }


    public MobileElement getProcessOptions() {
        return processOptions;
    }

    public MobileElement getScheduleSwitcher() {
        return scheduleSwitcher;
    }

    public MobileElement getDuedateSwitcher() {
        return duedateSwitcher;
    }

    public MobileElement getPrioritySwitcher() {
        return prioritySwitcher;
    }

    public MobileElement getProcessHistoryFromProcessOptions() {
        return processHistoryFromProcessOptions;
    }

    public MobileElement getStepRecipientsFromProcessOptions() {
        return StepRecipientsFromProcessOptions;
    }

    public MobileElement getForwardProcessFromProcessOptions() {
        return forwardProcessFromProcessOptions;
    }

    public MobileElement getDuplicateProcessFromProcessOptions() {
        return DuplicateProcessFromProcessOptions;
    }

    public List<MobileElement> getHistoryVersions() {
        return historyVersions;
    }

    public MobileElement getStatusbyMeLabel() {
        return statusbyMeLabel;
    }

    public MobileElement getProcessSearchResult() {
        return processSearchResult;
    }


    public MobileElement getClose() {
        return close;
    }

    public MobileElement getThreeDotsMenuOfProcess() {
        return threeDotsMenuOfProcess;
    }

    public List<MobileElement> getOptionItems() {
        return optionItems;
    }

    public MobileElement getTakeTheLeadConfirmBtn() {
        return confirmPopup;
    }

    public MobileElement getDuplicateProcess() {
        return duplicateProcess;
    }

    public MobileElement getConfirmPopup() {
        return confirmPopup;
    }

    public MobileElement getSearchBarMBContactPicker() {
        return searchBarMBContactPicker;
    }

    public MobileElement getOldRecipientsView() {
        return oldRecipientsViewFromMbContactPicker;
    }

    public MobileElement getContactCheckBox() {
        return contactCheckBox;
    }

    public MobileElement getProcessTitle() {
        return processTitleIncategories;
    }

    public MobileElement getActivitySearchBarCancelBtn() {
        return activitySearchBarCancelBtn;
    }


    public MobileElement getSubmitProcess() {
        return sendProcess;
    }

    public MobileElement getCompleteProcess() {
        return completeProcess;
    }

    public MobileElement getConfirmDeleteAllProcesses() {
        return confirmDeleteAllProcesses;
    }

    public List<MobileElement> getWidgetNumberInsideTable() {
        return widgetNumberInsideTable;
    }

    public MobileElement getWidgetNumberOutsideTable() {
        return widgetNumberOutsideTable;
    }

    public List<MobileElement> getWidgetCurrency() {
        return widgetCurrency;
    }

    public MobileElement getPreviewRows() {
        return previewRows;
    }

    public List<MobileElement> getRowTable() {
        return rowTable;
    }

    public MobileElement getFirstSearchedProcess() {
        return firstSearchedProcess;
    }

    public MobileElement getNextButton() {
        return nextButton;
    }

    public MobileElement getStepProcess() {
        return stepProcess;
    }

    public MobileElement getActivitySearchBar() {
        return activitySearchBar;
    }

    public MobileElement getStartSearchBar() {
        return startSearchBar;
    }

    /* public MobileElement getForwardByApp() {
         return forwardByApp;
     }

     public MobileElement getForwardByMail() {
         return forwardByMail;
     }
 */
    public MobileElement getCollapseCategory() {
        return collapseCategory;
    }

    public MobileElement getDeleteAllProcesses() {
        return deleteAllProcesses;
    }

    public MobileElement getCancelbTn() {
        return cancelbTn;
    }

    public MobileElement getActivityItem() {
        return activityItem;
    }

    public MobileElement getStartItem() {
        return startItem;
    }

    public MobileElement getNewCategory() {
        return newCategory;
    }

    public MobileElement getDraftCategory() {
        return draftCategory;
    }

    public MobileElement getInProgressCategory() {
        return inProgressCategory;
    }

    public MobileElement getSubmittedCategory() {
        return submittedCategory;
    }

    public MobileElement getCompletedCategory() {
        return completedCategory;
    }

    public MobileElement getCanceledCategory() {
        return canceledCategory;
    }

    public MobileElement getNewCategoryFiltre() {
        return newCategoryFiltre;
    }

    public MobileElement getNewCategorySortButton() {
        return newCategorySortButton;
    }

    public MobileElement getNewCategoryOptionButton() {
        return newCategoryOptionButton;
    }

    public MobileElement getNewCategoryFirstProcess() {
        return newCategoryFirstProcess;
    }

    public MobileElement getDraftCategoryFiltre() {
        return draftCategoryFiltre;
    }

    public MobileElement getDraftCategorySortButton() {
        return draftCategorySortButton;
    }

    public MobileElement getDraftCategoryOptionButton() {
        return draftCategoryOptionButton;
    }

    public MobileElement getDraftCategoryFirstProcess() {
        return draftCategoryFirstProcess;
    }

    public MobileElement getInProgressCategoryFiltre() {
        return inProgressCategoryFiltre;
    }

    public MobileElement getInProgressCategorySortButton() {
        return inProgressCategorySortButton;
    }

    public MobileElement getInProgressCategoryOptionButton() {
        return inProgressCategoryOptionButton;
    }

    public MobileElement getInProgressCategoryFirstProcess() {
        return inProgressCategoryFirstProcess;
    }

    public MobileElement getSubmittedCategoryFiltre() {
        return submittedCategoryFiltre;
    }

    public MobileElement getSubmittedCategorySortButton() {
        return submittedCategorySortButton;
    }

    public MobileElement getSubmittedCategoryOptionButton() {
        return submittedCategoryOptionButton;
    }

    public MobileElement getSubmittedCategoryFirstProcess() {
        return submittedCategoryFirstProcess;
    }

    public MobileElement getCompletedCategoryFiltre() {
        return completedCategoryFiltre;
    }

    public MobileElement getCompletedCategorySortButton() {
        return completedCategorySortButton;
    }

    public MobileElement getCompletedCategoryOptionButton() {
        return completedCategoryOptionButton;
    }

    public MobileElement getCompletedCategoryFirstProcess() {
        return completedCategoryFirstProcess;
    }

    public MobileElement getCanceledCategoryFiltre() {
        return canceledCategoryFiltre;
    }

    public MobileElement getCanceledCategorySortButton() {
        return canceledCategorySortButton;
    }

    public MobileElement getCanceledCategoryOptionButton() {
        return canceledCategoryOptionButton;
    }

    public MobileElement getCanceledCategoryFirstProcess() {
        return canceledCategoryFirstProcess;
    }

    public MobileElement getOpenProcess() {
        return openProcess;
    }

    public MobileElement getDeleteProcess() {
        return deleteProcess;
    }

    public MobileElement getHistoryProcess() {
        return historyProcess;
    }

    public MobileElement getEditProcess() {
        return editProcess;
    }

    public MobileElement getForwardProcess() {
        return forwardProcess;
    }


    public void modifyProcessName(String newProcessName) {

        if (mPlatform.equals(Platforms.ANDROID)) {

            processNamTextFieldWithEdit.sendKeys(newProcessName);

        } else {
            processNamTextField.sendKeys(newProcessName);
        }

    }

    public void verifyToastOfMultipleMandatoryFieldsisDisplyed() {

        if (mPlatform.equals(Platforms.ANDROID)) {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            assertNotNull(wait.until(ExpectedConditions
                    .presenceOfElementLocated(MobileBy.xpath("//android.widget.Toast[contains(@text, 'Please fill the 3 mandatory fields highlighted in red')]"))));

        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            assertNotNull(wait.until(ExpectedConditions
                    .presenceOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Please fill the 3 mandatory fields highlighted in red\"`]"))));

        }

    }

    public void verifyToastOfOneMandatoryFieldisDisplyed() {

        if (mPlatform.equals(Platforms.ANDROID)) {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            assertNotNull(wait.until(ExpectedConditions
                    .presenceOfElementLocated(MobileBy.xpath("//android.widget.Toast[contains(@text, 'Please fill the mandatory field Adresse e-mail')]"))));

        } else {
            WebDriverWait wait = new WebDriverWait(mDriver, 5);

            assertNotNull(wait.until(ExpectedConditions
                    .presenceOfElementLocated(MobileBy.AccessibilityId("Please fill the mandatory field Adresse e-mail"))));
        }


    }

    public void clickOnStart() {
        waitForElementToBeClickable(startItem);

        startItem.click();

    }

    public void checkProcessSearchResultInStartTab(String processName) throws IOException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            hideKeyboard();
            CheckDisplayedOfElement(firstSearchedProcessForAndroid.get(0), "process  ");
            CheckDisplayedOfElement(categoryNameAndroid.get(0), "process category");
        } else {
            checkSearchProcessResult(processName);
            CheckDisplayedOfElement(categoryName.get(0), "process category ");
        }
    }

    public void initiateProcessFromStartTab(String processName) throws InterruptedException {

        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnFirstSearchResultInStart();
    }

    public void checkSearchProcessResult(String processName) {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(processTitleInStarttab));
        SoftAssert softAssert = new SoftAssert();
        Boolean iselementpresent = processTitleInStarttab.getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

        softAssert.assertTrue(iselementpresent, "Targeted element App is not present on screen.");
        // mLogger.log(Status.PASS, "4.b - The matched process is displayed with their categorie");

    }

    public void searchProcessinStartTab(String processName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 10);
        if (mPlatform.equals(Platforms.ANDROID)) {

            searchBtn.click();
            startSearchBar.clear();
            startSearchBar.sendKeys(processName);
        } else {

            scrollDown(2, 1000);

            wait.until(ExpectedConditions.elementToBeClickable(startSearchBar));

            clearTextFully(startSearchBar);

                Actions a = new Actions(mDriver);
                a.sendKeys(processName);
                a.perform();
                hideKeyboardIos();

        }

    }

    public void deleteAllProcessesInNewCategory() throws InterruptedException, MalformedURLException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            if (isElementDisplayed(categoryNameAndroid.get(0)) && !categoryNameAndroid.get(0).getAttribute("name").equals("NEW (0)")) {
                categoryOptionButton.get(0).click();
                Thread.sleep(1000);

                ElementToClick("Delete All Processes", 0, 0).click();
                Thread.sleep(1000);
                //clickOnElementByString("Delete");
                confirmDeleteAllProcesses.click();
            }

        } else {
            if (  newCategoryOptionButton.isEnabled()) {
                newCategoryOptionButton.click();
                deleteAllProcesses.click();
                confirmDeleteAllProcesses.click();
            }
        }


    }

    public void deleteAllProcessesInDraftCategory() throws InterruptedException, MalformedURLException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(categoryNameAndroid.get(1)) && !categoryNameAndroid.get(1).getAttribute("name").equals("DRAFT (0)")) {
             categoryOptionButton.get(1).click();
             Thread.sleep(1000);

             ElementToClick("Delete All Processes", 0, 0).click();
             Thread.sleep(1000);

             //clickOnElementByString("Delete");
             confirmDeleteAllProcesses.click();
            }
            } else {
                Thread.sleep(3000);
                if ( draftCategoryOptionButton.isEnabled()) {
                    draftCategoryOptionButton.click();
                    deleteAllProcesses.click();
                    confirmDeleteAllProcesses.click();
                }

            }
        }




    public void deleteAllProcessesInInProgressCategory() throws InterruptedException, MalformedURLException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(categoryNameAndroid.get(2)) && !categoryNameAndroid.get(2).getAttribute("name").equals("IN PROGRESS (0)")) {
                categoryOptionButton.get(2).click();
                Thread.sleep(1000);

                ElementToClick("Delete All Processes", 0, 0).click();
                Thread.sleep(1000);

                //clickOnElementByString("Delete");
                confirmDeleteAllProcesses.click();
            }

        } else {
            if (inProgressCategoryOptionButton.isEnabled()) {
                inProgressCategoryOptionButton.click();
                deleteAllProcesses.click();
                confirmDeleteAllProcesses.click();
            }
        }


    }

    public void deleteAllProcessesInSubmittedCategory() throws InterruptedException, MalformedURLException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(categoryNameAndroid.get(3)) && !categoryNameAndroid.get(3).getAttribute("name").equals("SUBMITTED (0)")) {
                categoryOptionButton.get(3).click();
                Thread.sleep(1000);

                ElementToClick("Delete All Processes", 0, 0).click();
                Thread.sleep(1000);

                //clickOnElementByString("Delete");
                confirmDeleteAllProcesses.click();
            }

        } else {

            if ( submittedCategoryOptionButton.isEnabled()) {
                submittedCategoryOptionButton.click();
                deleteAllProcesses.click();
                confirmDeleteAllProcesses.click();
            }
        }


    }

    public void returnBackTochats() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    TabBarScreen tabBarScreen =  new TabBarScreen(mDriver);
                    for (int i = 1; i <= 2; i++) {

                     tabBarScreen.back();
                    }
                    tabBarScreen.goToChats();

                        } else {

                    TabBarScreen tabBarScreen =  new TabBarScreen(mDriver);
                    for (int i = 1; i <= 2; i++) {
                        Thread.sleep(3000);
                        mDriver.navigate().back();
                    }
                    tabBarScreen.goToChats();
                        }

    }

    public void returnBackToMYBusiness() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            TabBarScreen tabBarScreen =  new TabBarScreen(mDriver);
            for (int i = 1; i <= 2; i++) {

                mDriver.navigate().back();
            }
            tabBarScreen.goToMyBusiness();

        } else {

            TabBarScreen tabBarScreen =  new TabBarScreen(mDriver);
            for (int i = 1; i <= 2; i++) {
                mDriver.navigate().back();
            }
            tabBarScreen.goToMyBusiness();
        }

    }

    public void writePhoneNumber(){

                if (mPlatform.equals(Platforms.ANDROID)) {

                 phoneNumberFieldInput.sendKeys("90000000");

                } else {

                    phoneNumberFieldInput.sendKeys("90000000");
                 hideKeyboardWithDone();

                }
    }

    public void deleteAllProcessesInCompletedCategory() throws InterruptedException, MalformedURLException {


        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(categoryNameAndroid.get(4)) && !categoryNameAndroid.get(4).getAttribute("name").equals("COMPLETED (0)")) {
                categoryOptionButton.get(4).click();
                Thread.sleep(1000);

                ElementToClick("Delete All Processes", 0, 0).click();
                Thread.sleep(1000);

                //clickOnElementByString("Delete");
                confirmDeleteAllProcesses.click();
            }

        } else {
            Thread.sleep(3000);

            if ( completedCategoryOptionButton.isEnabled()) {
                completedCategoryOptionButton
                        .click();
                deleteAllProcesses.click();
                confirmDeleteAllProcesses.click();
            }
        }

    }

    public void deleteAllProcessesInCanceledCategory() throws InterruptedException, MalformedURLException {


        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(categoryNameAndroid.get(5)) && !categoryNameAndroid.get(5).getAttribute("name").equals("CANCELED (0)")) {


                categoryOptionButton.get(5).click();
                Thread.sleep(1000);

                ElementToClick("Delete All Processes", 0, 0).click();
                Thread.sleep(2000);

                //ElementToClick("DELETE",0,0).click();
                confirmDeleteAllProcesses.click();
            }

        } else {
            Thread.sleep(2000);
            if (canceledCategoryOptionButton.isEnabled()) {
                canceledCategoryOptionButton.click();
                waitForElementToBeClickable(deleteAllProcesses);
                deleteAllProcesses.click();
                confirmDeleteAllProcesses.click();
            }
        }
    }


    public void deleteAllProcesses() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 20);
        TabBarScreen tabBarScreen= new TabBarScreen(mDriver);
        tabBarScreen.goToMyBusiness();
        deleteAllProcessesInCanceledCategory();
        deleteAllProcessesInNewCategory();
        deleteAllProcessesInDraftCategory();
        deleteAllProcessesInInProgressCategory();
        deleteAllProcessesInSubmittedCategory();
        deleteAllProcessesInCompletedCategory();

    }

    public void clickOnFirstSearchResultInStart() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            firstSearchedProcessForAndroid.get(0).click();
        } else {
        waitForElementToBeClickable(processSearchResult);
        processSearchResult.click();
        }

    }

    public void openHistoryofprocess() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            Thread.sleep(200);
            clickOnThreeDotsMenuOfProcess();
            processHistoryFromProcessOptions.click();
        } else {
            clickOnThreeDotsMenuOfProcess();
            Thread.sleep(500);
            processHistoryFromProcessOptions.click();
        }

    }

    public void confirmBtn() {
        waitForElementToBeClickable(confirmPopup);
        confirmPopup.click();

    }

    public void clickOnProcessFloatingActions() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            processFloatingActionAndroid.get(1).click();
        } else {
            waitForElementToBeClickable(processFloatingAction);
            processFloatingAction.click();
        }


    }

    public void sendProcess() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(500);
            clickOnProcessFloatingActions();
            Thread.sleep(500);
            sendProcessAndroid.get(1).click();

        } else {

            clickOnProcessFloatingActions();
            Thread.sleep(1000);
            waitForElementToBeClickable(sendProcess);
            sendProcess.click();
        }


    }

    public void completeProcess() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            clickOnProcessFloatingActions();
            Thread.sleep(1000);
            completeProcessAndroid.get(0).click();

        } else {
            clickOnProcessFloatingActions();
            completeProcess.click();
        }


    }

    public void searchContactToSubmit(String contact) throws InterruptedException, IOException {

        if (mPlatform.equals(Platforms.ANDROID)) {


            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker)) {
                searchBtnMBContactPicker.click();
                searchBarMBContactPicker.sendKeys(contact);
                Thread.sleep(1000);
            }

        } else {

            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker)) {
                clickOnIndividuals();
                scrollDown(1, 500);
                if (!searchBarMBContactPicker.getText().isEmpty()){
                clearTextFully(searchBarMBContactPicker);}

                searchBarMBContactPicker.sendKeys(contact);
                hideKeyboardIos();
            }
        }
    }


    public void clickOnRecipientName() {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.getRecipientName().click();

    }

    public void checkExitButtonIsNotDislayedorDisabled() throws IOException, InterruptedException {
        screen.ConversationScreen  conversationScreen= new screen.ConversationScreen(mDriver);

        if (mPlatform.equals(Platforms.ANDROID)) {
            CheckElementIsNotDisplayed(conversationScreen.getExitFromConversation(),"exit button");
        }
        else {


                if( (isElementEnabled(conversationScreen.getExitFromConversation()))== false)
                mLogger.log(Status.PASS, "The ios exit button is disabled   ");
                else{
                    mLogger.log(Status.PASS, "The ios exit button is enabled   ");
                    Assert.fail();

                }

}




    }



    public void checkEditConversationNameIsNotDisplayed() throws IOException, InterruptedException {
        screen.ConversationScreen conversationScreen = new screen.ConversationScreen(mDriver);
        CheckElementIsNotDisplayed(conversationScreen.getEditGroupNameConversation(),"edit button");
    }

    public void checkAddUserIsNotDisplayed() throws IOException, InterruptedException {
        screen.ConversationScreen conversationScreen = new screen.ConversationScreen(mDriver);
        CheckElementIsNotDisplayed(conversationScreen.getAddContactFromConversation(),"add button");
    }

    public void searchGroupToSubmit(String group) throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (isElementDisplayed(oldRecipientsViewFromMbContactPicker)== false) {
                clickOnGroups();

                searchBtnMBContactPicker.click();
                searchBarMBContactPicker.sendKeys(group);
                Thread.sleep(500);
            }
        } else {
            if (isElementDisplayed(oldRecipientsViewFromMbContactPicker) == false) {
                clickOnGroups();
                scrollDown(1, 500);
                searchBarMBContactPicker.click();
                searchBarMBContactPicker.clear();

                Actions a = new Actions(mDriver);
                a.sendKeys(group);
                a.perform();
                // getSearchBarMBContactPicker().sendKeys(group);

                hideKeyboardIos();
            }
        }
    }
    public String getFakeName(){
        String  newPocessName = generateFakeName();

        return newPocessName;

    }
    public void modifyProcessName() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                   clearInput(processNamTextFieldWithEdit);
                    mLogger.log(Status.PASS, "Step 6: Clear input 'processName'  ");

                   modifyProcessName(newPocessName);

                        } else {
                  clearTextFully(processNamTextField);
                    mLogger.log(Status.PASS, "Step 6: Clear input 'processName'  ");

                   modifyProcessName(newPocessName);

                    hideKeyboardWithNext();

                    Thread.sleep(1000);
                        }
    }

    public void checkIfConversationNameIsModified(){




        if (mPlatform.equals(Platforms.ANDROID)) {
            boolean identical =  newPocessName.equalsIgnoreCase(groupNameConversation.getText());
            Assert.assertTrue( identical,"are not identical");

            mLogger.log(Status.PASS, "conversations name are equal ");

                } else {
            boolean identical =  newPocessName.equalsIgnoreCase(conversationTitle.getAttribute("label"));
            Assert.assertTrue( identical,"are not identical");

            mLogger.log(Status.PASS, "conversations name are equal ");
                }


    }

    public void checkIfConversationNameIsIdentical(String processName){

        if (mPlatform.equals(Platforms.ANDROID)) {
            boolean identical =  processName.equalsIgnoreCase(groupNameConversation.getText());
            Assert.assertTrue( identical,"are not identical");

            mLogger.log(Status.PASS, "conversations name are equal ");

        } else {
            boolean identical =  processName.equalsIgnoreCase(conversationTitle.getAttribute("label"));
            Assert.assertTrue( identical,"are not identical");

            mLogger.log(Status.PASS, "conversations name are equal ");
        }
    }

    public void selectContactToSubmit() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker)) {
                Thread.sleep(100);
                checkSelectedContact.click();
            }

        } else {
            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker))
                clickOnElementPositionForContactCell(contactCell, 5, 5);
        }
    }


    public void selectGroupToSubmit() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker)) {
                Thread.sleep(100);
                checkSelectedContact.click();
            }

        } else {
            if (!isElementDisplayed(oldRecipientsViewFromMbContactPicker))
                clickOnElementPositionForContactCell(contactCell, 5, 5);
        }
    }

    public void submitProcessAfterSelectionOfContacts() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            processFloatingAction.click();

        } else {

waitForElementToBeClickable(processFloatingAction);
processFloatingAction.click();
        }

    }

    public void clickOnActivity() throws InterruptedException {
        Thread.sleep(1000);

        activityItem.click();
    }

    public void expandNewCategory() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(1000);

            expandButton.get(0).click();


        } else {

            newCategoryOptionButton.click();
            waitForElementToBeClickable(collapseCategory);
            collapseCategory.click();
        }

    }

    public void collapseNewCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {
            expandButton.get(0).click();


        } else {
            newCategoryOptionButton.click();
            collapseCategory.click();
        }

    }

    public void expandDraftCategory() {
        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(1).click();

        } else {
            draftCategoryOptionButton.click();
            collapseCategory.click();
        }

    }

    public void verifyDisplayDetailsInCanceledProcess() throws IOException, InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(getProcessTitle(),"process title");
                    CheckDisplayedOfElement(processStatus.get(0),"process Status");
                    CheckDisplayedOfElement(processSenderName.get(0),"Process Sender Name");
                    CheckDisplayedOfElement(processLastUpdateDate.get(0),"process last update date");


                } else {
                    CheckDisplayedOfElement(statusbyMeLabel, "Status: canceled by [initiator name]");

                }

    }

    public void collapseDraftCategory() {
        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(1).click();

        } else {
            draftCategoryOptionButton.click();
            collapseCategory.click();
        }

    }

    public void expandInProgressCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(2).click();

        } else {
         waitForElementToBeClickable(inProgressCategoryOptionButton);
            inProgressCategoryOptionButton.click();

         waitForElementToBeClickable(collapseCategory);

         collapseCategory.click();
        }

    }

    public void collapseInProgressCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(2).click();

        } else {
         waitForElementToBeClickable(inProgressCategoryOptionButton);

         inProgressCategoryOptionButton.click();
            collapseCategory.click();
        }
    }

    public void expandSubmittedCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(3).click();

        } else {
         waitForElementToBeClickable(submittedCategoryOptionButton);
            submittedCategoryOptionButton.click();
            collapseCategory.click();
        }
    }

    public void collapseSubmittedCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(3).click();

        } else {
            submittedCategoryOptionButton.click();
            collapseCategory.click();
        }

    }


    public void expandCompletedCategory() {
        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(4).click();

        } else {

            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(completedCategoryOptionButton));
            completedCategoryOptionButton.click();
            collapseCategory.click();
        }


    }

    public void collapseCompletedCategory() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            expandButton.get(4).click();

        } else {

            WebDriverWait wait = new WebDriverWait(mDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(completedCategoryOptionButton));
            completedCategoryOptionButton.click();
            collapseCategory.click();
        }
    }

    public void expandCanceledCategory() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            expandButton.get(5).click();


        } else {
            waitForElementToBeClickable(canceledCategoryOptionButton);
            canceledCategoryOptionButton.click();
            waitForElementToBeClickable(collapseCategory);
            collapseCategory.click();
        }

    }

    public void collapseCanceledCategory() throws InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {
            expandButton.get(5).click();


        } else {
        }
        Thread.sleep(1000);
        canceledCategoryOptionButton.click();
        collapseCategory.click();
    }

    public void clickOnNewCategoryOptions() {

        newCategoryOptionButton.click();
    }

    public void clickOnSubmittedCategoryOptions() {

       submittedCategoryOptionButton.click();
    }


    public void checkIfProcessIsReceivedInNew(String processName) throws IOException, InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            CheckDisplayedOfElement(processCellInAnycategorie.get(0),"process is displayed");

            Boolean iselementpresent = processTitleIncategories.getText().equalsIgnoreCase(processName);
            //iselementpresent will be true so assertion will pass and so test method will pass too.

            assertTrue(iselementpresent, "Targeted element App is not present on screen.");
        }
                 else {
            clickOnActivity();
            mLogger.log(Status.PASS,"click on activity ");

            clickOnNewCategoryOptions();
            mLogger.log(Status.PASS,"click on new cateogry options ");

            expandNewCategory();
            mLogger.log(Status.PASS,"click on expand category ");

            CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

            Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);

        assertTrue(iselementpresent, "Targeted element App is not present on screen.");
    }
                }



    public void checkIfProcessIsInDraft(String processName) throws IOException, InterruptedException {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(processCellInAnycategorie.get(0),"process is displayed");

                    Boolean iselementpresent = processTitleIncategories.getText().equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");

                } else {
                    CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

                    Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");
                        }

    }

    public void checkIfProcessIsInProgress(String processName) throws IOException, InterruptedException {
        CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

        Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

        assertTrue(iselementpresent, "Targeted element App is not present on screen.");
    }

    public void checkIfProcessIsInSubmitted(String processName) throws IOException, InterruptedException {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

                    Boolean iselementpresent = processTitleIncategories.getText().equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");

                        } else {
                    expandSubmittedCategory();
                    CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

                    Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");
                        }

    }

    public void checkIfProcessIsInCompleted(String processName) throws IOException, InterruptedException {
        CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

        Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

        assertTrue(iselementpresent, "Targeted element App is not present on screen.");
    }

    public void checkIfProcessIsInCanceled(String processName) throws IOException, InterruptedException {


                if (mPlatform.equals(Platforms.ANDROID)) {

                    CheckDisplayedOfElement(processCellInAnycategorie.get(0),"process is displayed");
                    CheckDisplayedOfElement(processTitleIncategories,"process is displayed");
                    Boolean iselementpresent = processTitleIncategories.getText().equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");
                } else
                    {
                    CheckDisplayedOfElement(processTitleIncategories,"process is displayed");

                    Boolean iselementpresent = processTitleIncategories.getAttribute("label").equalsIgnoreCase(processName);
                    //iselementpresent will be true so assertion will pass and so test method will pass too.

                    assertTrue(iselementpresent, "Targeted element App is not present on screen.");
                        }

    }


    public void checkIfProcessDetailsAreDisplayedInAnyCategory(String processName) throws InterruptedException, IOException {
        Thread.sleep(1300);
        Boolean elementPresent = processTitleIncategories.getAttribute("name").equalsIgnoreCase(processName);

        CheckDisplayedOfElement(processTitleIncategories,"process title");
        CheckDisplayedOfElement(processStatus.get(0),"process Status");
        CheckDisplayedOfElement(processSenderName.get(0),"Process Sender Name");
        CheckDisplayedOfElement(processLastUpdateDate.get(0),"process last update date");

        Assert.assertTrue(elementPresent,"Targeted element App is not present on screen." );
    }

    public void checkIfNewCategoryIsDisplayed() throws IOException, InterruptedException {
                if (mPlatform.equals(Platforms.ANDROID)) {

                    CheckDisplayedOfElement(categoryNameAndroid.get(0),"New category");

                } else {

                    CheckDisplayedOfElement(newCategory, "New category");

                }



    }

    public void checkIfDraftCategoryIsDisplayed() throws IOException, InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(categoryNameAndroid.get(1),"draft category");


                } else {
                    CheckDisplayedOfElement(draftCategory, "draft category");

                }

    }

    public void checkIfInProgressCategoryIsDisplayed() throws IOException, InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    CheckDisplayedOfElement(categoryNameAndroid.get(2),"In progress categor");

                } else {
                    CheckDisplayedOfElement(inProgressCategory, "In progress category");

                }
    }

    public void checkIfSubmittedCategoryIsDisplayed() throws IOException, InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(categoryNameAndroid.get(3),"submitted category");


                } else {
                    CheckDisplayedOfElement(submittedCategory, "submitted category");

                }

    }

    public void checkIfCompletedCategoryIsDisplayed() throws IOException, InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            CheckDisplayedOfElement(categoryNameAndroid.get(4),"completed category");


        } else {
            CheckDisplayedOfElement(completedCategory, "completed category");

        }


    }

    public void checkIfCanceledCategoryIsDisplayed() throws IOException, InterruptedException {
                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(categoryNameAndroid.get(5),"canceled category");


                } else {
                    CheckDisplayedOfElement(canceledCategory, "canceled category");

                }

    }

    public void checkIfCompletedByMeisDisplayed() throws IOException, InterruptedException {

        if (mPlatform.equals(Platforms.ANDROID)) {

            CheckDisplayedOfElement(processStatus.get(0),"Status: Completed by [initiator name]");

        } else {
            CheckDisplayedOfElement(statusbyMeLabel, "Status: Completed by [initiator name]");

        }



    }

    public void checkIfWaitingToBeSubmittedisDisplayed() {

        if (mPlatform.equals(Platforms.ANDROID)) {

           boolean isDisplayed=isElementDisplayed(processStatus.get(0)) && processStatus.get(0).getText().equalsIgnoreCase("Waiting to be submitted! ");
                ;
            mLogger.log(Status.PASS, "The following informations are displayed:\n" +
                    "- Status: Waiting to be submitted!\n");
            assertTrue(isDisplayed, "The following informations are not displayed:\\n\" +\n" +
                    "                    \"- Status: Waiting to be submitted!\\n");

        } else {

            boolean isDisplayed = isElementDisplayed(statusbyMeLabel) && statusbyMeLabel.getAttribute("value").equalsIgnoreCase("Waiting to be submitted!");
            mLogger.log(Status.PASS, "The following informations are displayed:\n" +
                    "- Status: Waiting to be submitted!\n");
            assertTrue(isDisplayed, "The following informations are not displayed:\\n\" +\n" +
                    "                    \"- Status: Waiting to be submitted!\\n");
                }

    }

    public void verifyMbContactPickerBarElementsisDisplayed() throws InterruptedException, IOException {
               if (mPlatform.equals(Platforms.ANDROID)) {

                   WebDriverWait wait = new WebDriverWait(mDriver, 5);

                   wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(backButton)));
                   CheckDisplayedOfElement(backButton,"back button");
                   CheckDisplayedOfElement(searchBtnFromMbContactPicker,"Search  button in the contacts selection");
                   CheckDisplayedOfElement(contactsLabelFromMbContactPicker,"the contacts label");
                   CheckDisplayedOfElement(saveBtnFromMbContactPicker,"the save button");
                   CheckDisplayedOfElement(contactsfilterFromMbContactPicker,"the contact filters ");
                   mLogger.log(Status.PASS, "- On top: Back button + title: \"Contacts\" + Search icon + individual/group filter + Save icon" +
                               " -Middle: Contacts in multiselection mode");


                           if (branding.equals(Branding.TOTR)) {
                               if (!isElementDisplayed(processFloatingAction))
                                   mLogger.log(Status.PASS, "At the bottom, on the right: Submit validation icon, by default the Submit icon is inactive");

                                   } else {

                               if(isElementEnabled(processFloatingAction) == false)
                                   mLogger.log(Status.PASS, "At the bottom, on the right: Submit validation icon, by default the Submit icon is inactive\"  ");
                               else{
                                   mLogger.log(Status.PASS, "submit icon is active by default   ");
                                   Assert.fail();

                               }
                                   }


                   Thread.sleep(1000);

                       } else {


                   CheckDisplayedOfElement(backBtnFromMbContactPicker,"back button");
                   CheckDisplayedOfElement(moreBtnFromMbContactPicker,"More  button in the contacts selection");
                   CheckDisplayedOfElement(contactsLabelFromMbContactPicker,"the contact label");
                   CheckDisplayedOfElement(groupsMBContactPicker,"group button");
                   CheckDisplayedOfElement(invidividualsMBContactPicker," individuals button ");

                   CheckElementIsNotDisplayed(sendProcess,"send button");
                   moreBtnFromMbContactPicker.click();

                   CheckDisplayedOfElement(saveProcessInsideMoreFromMbContactPicker,"save button");
                   CheckDisplayedOfElement(closeInsideMoreFromMbContactPicker,"close  button in the contacts selection");


                   Thread.sleep(1000);
                   closeInsideMoreFromMbContactPicker.click();
                       }



    }

    public void verifyPreviousRecipientsIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(oldRecipientsViewFromMbContactPicker, "The previous contacts");

    }

    public void clickOnIndividuals() {
             if (mPlatform.equals(Platforms.ANDROID)) {
              contactsfilterFromMbContactPicker.click();
              invidividualsMBContactPicker.click();

             } else {
              invidividualsMBContactPicker.click();

             }
    }

    public void clickOnGroups() {
             if (mPlatform.equals(Platforms.ANDROID)) {
                 contactsfilterFromMbContactPicker.click();

                 groupsMBContactPicker.click();

                     } else {
              groupsMBContactPicker.click();

             }

    }

    public void recieveProcessInNewCateogry(String processName, String contact) throws InterruptedException, IOException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    clickOnStart();
                    searchProcessinStartTab(processName);
                    clickOnFirstSearchResultInStart();
                    sendProcess();
                    searchContactToSubmit(contact); // submit process to Oneself
                    selectContactToSubmit();
                    submitProcessAfterSelectionOfContacts();
                    clickOnActivity();

                        } else {
                    clickOnStart();
                    searchProcessinStartTab(processName);
                    clickOnFirstSearchResultInStart();
                    sendProcess();
                    searchContactToSubmit(contact); // submit process to Oneself
                    selectContactToSubmit();
                    submitProcessAfterSelectionOfContacts();
                    clickOnActivity();

                    expandNewCategory();
                        }

    }

    public void recieveProcessInsubmittedCateogry(String processName, String contact2) throws InterruptedException, IOException {

               if (mPlatform.equals(Platforms.ANDROID)) {
                   clickOnStart();
                   searchProcessinStartTab(processName);
                   clickOnFirstSearchResultInStart();
                   sendProcess();

                   searchContactToSubmit(contact2); // submit process to Oneself
                   selectContactToSubmit();
                   submitProcessAfterSelectionOfContacts();
                   clickOnActivity();


                       } else {

                   clickOnStart();
                   searchProcessinStartTab(processName);
                   clickOnFirstSearchResultInStart();
                   sendProcess();

                   searchContactToSubmit(contact2); // submit process to Oneself
                   selectContactToSubmit();
                   submitProcessAfterSelectionOfContacts();
                   clickOnActivity();
                   expandSubmittedCategory();
                       }

    }

    public void recieveProcessIncompletedCateogry(String processName, String contact) throws InterruptedException, IOException {

               if (mPlatform.equals(Platforms.ANDROID)) {
                   clickOnStart();
                   searchProcessInStartAndOpenIt(processName);
                   completeProcess();
                   searchContactToSubmit(contact);
                   selectContactToSubmit();
                   submitProcessAfterSelectionOfContacts();
                   confirmBtn();
                   clickOnActivity();

                       } else {

                   clickOnStart();
                   searchProcessInStartAndOpenIt(processName);
                   completeProcess();
                   searchContactToSubmit(contact);
                   selectContactToSubmit();
                   submitProcessAfterSelectionOfContacts();
                   confirmBtn();
                   clickOnActivity();
                   expandCompletedCategory();
                       }



    }

    public void deleteConversation() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);

                    conversationScreen.longPressOnElementPosition(conversationScreen.getProcessConversationThreadIcon().get(0));
                    Thread.sleep(3000);
                    conversationScreen.getDeleteConversation().click();
                    conversationScreen.getOk_Item().click();
                        } else {
                    screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);
                    Thread.sleep(3000);
                    swipe(conversationScreen.getConversationPreview(), "left");
                    waitForElementToBeClickable(deleteConversationBtn);
                    deleteConversationBtn.click();

                    waitForElementToBeClickable(okBtn);
                    okBtn.click();
                        }


    }

    public void confirmDelete() {
        screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);

        conversationScreen.confirmDelete();
    }

    public int getConversationSize(){
        screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);
        int conversationIdsize =conversationScreen.getProcessConversationThreadIcon().size();

        return  conversationIdsize;
    }

    public void  checkIfConversationIsDeleted(int conversationIdsize){

        if (mPlatform.equals(Platforms.ANDROID)) {
            screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);

            if (isElementExist( conversationScreen.getProcessConversationThreadIcon(),conversationIdsize)) {
                        Assert.fail("Thread appears");
                    }

                        } else {
            screen.ConversationScreen  conversationScreen   = new screen.ConversationScreen(mDriver);


            if (isElementExist( conversationScreen.getProcessConversationThreadIcon(), conversationIdsize)) {
                Assert.fail("the discussion still exists");
            }
                        }



    }

    public void openRecievedProcessInNewCategory() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    processCellInAnycategorie.get(0).click();

                        } else {
                    waitForElementToBeClickable(newCategoryFirstProcess);
                    newCategoryFirstProcess.click();
                        }

    }

    public void openRecievedProcessInSubmittedCategory() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {

            processCellInAnycategorie.get(0).click();

        } else {
            waitForElementToBeClickable(submittedCategoryFirstProcess);

            submittedCategoryFirstProcess.click();

        }

    }
                public void openFirestProcessInSubmittedCategory(){

                if (mPlatform.equals(Platforms.ANDROID)) {

                    processCellInAnycategorie.get(0).click();

                } else {
                    submittedCategoryFirstProcess.click();

                }

        }

    public void openRecievedProcessInCompletedCategory() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    waitForElementToBeClickable(processCellInAnycategorie.get(0));

                    processCellInAnycategorie.get(0).click();


                } else {
                    waitForElementToBeClickable(completedCategoryFirstProcess);
                    completedCategoryFirstProcess.click();

                }
    }

    public void searchProcessInStartAndOpenIt(String processName) throws InterruptedException {
        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnFirstSearchResultInStart();


    }



    public void conifrmNoAvailableNetworkPopup() {

        if (mPlatform.equals(Platforms.ANDROID)) {

            confirmBtn();
        } else {

            if (isElementDisplayed(noNetworkPopupTitle)) {
                okBtn.click();

            }
        }

    }

    public void returnToApp(String bundleId){
        if (mPlatform.equals(Platforms.IOS))
            openApp(bundleId);


    }
    public void turnDataOff(){
        if (mPlatform.equals(Platforms.ANDROID)) {

            disableWifiAndData();
                } else {

            enableAnddisableAirplanemode();
                }

    }

    public void turnDataOn(){
        if (mPlatform.equals(Platforms.ANDROID)) {

            enableWifiAndData();
        } else {

            enableAnddisableAirplanemode();
        }

    }

    public void openInProgressCategoryFirstProcess() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    processCellInAnycategorie.get(0).click();


                } else {
                    inProgressCategoryFirstProcess.click();

                }

    }





    public void verifyDisplayOfStopRepeatingOption() throws InterruptedException, IOException {


                if (mPlatform.equals(Platforms.ANDROID)) {

                    Thread.sleep(200);
                    WebDriverWait wait = new WebDriverWait(mDriver, 5);
                    wait.until(ExpectedConditions.visibilityOf(threeDotsMenuOfProcess));
                    clickOnThreeDotsMenuOfProcess();
                    wait.until(ExpectedConditions.visibilityOf(processOptionsMenuItems.get(4)));

                    CheckDisplayedOfElement(processOptionsMenuItems.get(4), "stop repeating");
                    processOptionsMenuItems.get(4).click();
                    waitForElementToBeClickable(confirmPopUp);
                    confirmPopUp.click();
                }
                    else
                        {
                        clickOnThreeDotsMenuOfProcess();
                        CheckDisplayedOfElement(stopRepeatingOption, "Stop repeating");

                            stopRepeatingOption.click();
                            waitForElementToBeClickable(confirmPopUp);
                            confirmPopUp.click();
                    }
                }


    public void takeTheLead() {
        waitForElementToBeClickable(processFloatingAction);
        processFloatingAction.click();
        waitForElementToBeClickable(confirmPopup);

        confirmPopup.click();

    }


    public void clickOnThreeDotsMenuOfProcess() throws InterruptedException {
        waitForElementToBeClickable(threeDotsMenuOfProcess);
        threeDotsMenuOfProcess.click();


    }
    public void clickBack() throws InterruptedException {
        Thread.sleep(1000);
        backButton.click();

    }


    public void emptySearchFieldInContactSelection() throws InterruptedException {
                if (mPlatform.equals(Platforms.ANDROID)) {

                  clickBack();

                } else {
                    clearTextFully(searchBarMBContactPicker);
                   clearTextFully(searchBarMBContactPicker);
                        }
    }

    public void clickOnProcessOptionsInThreeDots() throws InterruptedException {
        Thread.sleep(1000);
        processOptions.click();

    }

    public void activateRepeatProcessOption() throws InterruptedException {
        Thread.sleep(600);
        repeatProcessOptionSwitcher.click();
        Thread.sleep(600);

    }

    public void activateScheduleOption() throws InterruptedException {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    Thread.sleep(300);
                    processOptionsSwitchers.get(2).click();

                        } else {
                    Thread.sleep(1000);

                    scheduleSwitcher.click();
                        }


    }

    public void verifyDisplayOfDetailsInSchedule() throws InterruptedException, IOException {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    Thread.sleep(1000);
                    CheckDisplayedOfElement(datePickerInfo.get(0),"date Picker Info");

                        CheckDisplayedOfElement(datePickerIcon.get(0),"date picker icon");

                         CheckDisplayedOfElement(dateAndTime.get(0),"date and time ");


                    } else {
                        Thread.sleep(1000);



                    CheckDisplayedOfElement(startDateTime,"Start Date and Time is not  displayed");

                    CheckDisplayedOfElement(calenderIcon,"Calender icon is not  displayed");



                    }
                        }




    public void OpenProcessHistoryDetails() throws InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    Thread.sleep(200);
                    WebDriverWait wait = new WebDriverWait(mDriver, 5);

                    clickOnThreeDotsMenuOfProcess();
                    wait.until(ExpectedConditions.visibilityOf( processOptionsMenuItems.get(2)));
                    processOptionsMenuItems.get(2).click();

                        } else {
                    Thread.sleep(200);
                    clickOnThreeDotsMenuOfProcess();
                    processHistoryFromProcessOptions.click();
                        }


    }

    public void verifyProcessHistoryDetails() throws InterruptedException, IOException {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    CheckDisplayedOfElement(historyProcessDetailVersionAndroid.get(0),"version details  ");
                        } else {
                    CheckDisplayedOfElement(historyProcessDetailVersion, "version details  ");
                    String historyProcessDetails = historyProcessDetailVersion.getAttribute("value");

                    {
                        if (historyProcessDetails.startsWith("Scheduled for"))
                            mLogger.log(Status.PASS, " 'Scheduled for' is displayed ");
                        else {
                            mLogger.log(Status.FAIL, " 'Scheduled for' is not displayed ");


                            Assert.fail();

                        }

                    }
                }}


    public void verifyDisplayOfCalender() throws InterruptedException, IOException {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    Thread.sleep(1000);

                    datePickerIcon.get(0).click();

                    CheckDisplayedOfElement(datePickerHeader,"Calender");




                        } else {
                    Thread.sleep(1000);
                    calenderIcon.click();
                    CheckDisplayedOfElement(saveCalender,"Calender");


                        }

    }

    public void cancelSearch() {
       cancelSearchBtn.click();
    }

    public void closeProcessOptions() {
                if (mPlatform.equals(Platforms.ANDROID)) {
                    mDriver.navigate().back();
                    mDriver.navigate().back();
                    if(isElementDisplayed(confirmBtn))
                    confirmBtn.click();

                } else {
                    close.click();
                    mDriver.navigate().back();

                }
    }

    public void verifyDuplicateBtnIsNotDisplayed() throws IOException, InterruptedException {

                CheckElementIsNotDisplayed(duplicateProcess,"duplicate ");
    }

    public void verifyDuplicateBtnIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(duplicateProcess,"duplicate  ");


    }

    public void clickOnChatWithRecipients() throws InterruptedException {
        waitForElementToBeClickable(chatWithRecipients);
        chatWithRecipients.click();
        Thread.sleep(3000);

    }


    public void verifyProcessHistory() throws IOException, InterruptedException {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    CheckDisplayedOfElement(historyProcessdateVersion.get(0),"process history date ");
                    CheckDisplayedOfElement(historyProcessDetailVersionAndroid.get(0),"process history version");

                        } else {
                    Thread.sleep(3000);
                    int versionNumber = 2;
                    int historyVersionsSize = historyVersions.size();
                    if(versionNumber==historyVersionsSize)
                      mLogger.log(Status.PASS, "Two events having the same information and version are listed on the history");
                    else
                        mLogger.log(Status.FAIL, "Two events NOT having the same information and version are listed on the history");
                    Assert.assertEquals(historyVersionsSize, versionNumber);

                }


    }

    public void verifyProcessHistoryButtonisNotDisplayed() throws IOException, InterruptedException {


                    CheckElementIsNotDisplayed(processHistoryFromProcessOptions,"process history button is not displayed");


    }


    public void verifyProcessHistoryButtonisDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(processHistoryFromProcessOptions,"process history button");


    }

    public void verifyChatWithRecipientisDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(chatWithRecipients,"chat with reciepients button");


    }

    public MobileElement getProcessNamTextField() {
        return processNamTextField;
    }

    public MobileElement getProcessNamTextFieldWithoutEdit() {
        return processNamTextFieldWithoutEdit;
    }

    public MobileElement getProcessNamTextFieldWithEdit() {
        return processNamTextFieldWithEdit;
    }

    public void verifyProcessNameIsNotEnabled() {

                if (mPlatform.equals(Platforms.ANDROID)) {
                    boolean IsNotEnabled = isElementDisplayed(processNamTextFieldWithEdit) == false && isElementDisplayed(processNamTextFieldWithoutEdit) == true;
                    Assert.assertTrue(IsNotEnabled, "error : process name is  editable");

                        } else {
                    boolean IsNotEnabled = isElementEnabled(processNamTextField) == false;
                    Assert.assertTrue(IsNotEnabled, "error : process name is  editable");
                        }

                verifyToastOfNoRightToEditisDisplyed();
    }

    public void verifyToastOfNoRightToEditisDisplyed() {

                if (mPlatform.equals(Platforms.ANDROID)) {

                    WebDriverWait wait = new WebDriverWait(mDriver, 5);
                    processNamTextFieldWithoutEdit.click();
                    assertNotNull(wait.until(ExpectedConditions
                            .presenceOfElementLocated(MobileBy.xpath("//android.widget.Toast[contains(@text, 'No Right to edit Process name')]"))));
                        } else {
                    WebDriverWait wait = new WebDriverWait(mDriver, 5);
                    processNamTextField.click();
                    assertNotNull(wait.until(ExpectedConditions
                            .presenceOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"No Right to edit Process name\"`]"))));
                        }


    }


    public void writeTextInTextWidget(){
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        if (mPlatform.equals(Platforms.ANDROID)) {
                    wait.until(ExpectedConditions.elementToBeClickable(textAreaAndroid.get(0)));
                 textAreaAndroid.get(0).clear();
            textAreaAndroid.get(0).sendKeys("Test");

                        } else {

                clearTextFully(textFieldInput);
            textFieldInput.sendKeys("Test");
                        }
    }

    public void openDropDownSelectorAndSave() {
        if (mPlatform.equals(Platforms.ANDROID)) {
            //dorpdown have 3 options [3 2 1]
            dropdownSelector.click();
            //select option "3"
            dropDownSelectorFirstItem.click();

                } else {
            dropdownSelector.click();
            waitForElementToBeClickable(saveBtn);
            saveBtn.click();
                }

    }

    public void selectOptionFromDropDownWidget() {
        //dorpdown have 3 options [3 2 1]
        dropdownSelector.click();
        //select option "3"
       dropDownSelectorFirstItem.click();

    }

    public void cancelProcess() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            clickOnThreeDotsMenuOfProcess();
            Thread.sleep(1000);
            optionItems.get(4).click();
            yesBtn.click();
        } else {
            clickOnThreeDotsMenuOfProcess();
            Thread.sleep(1000);
           cancelProcess.click();

            confirmBtn();

        }

    }

    public void fillTextAreaWidget() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(1000);
            textAreaAndroid.get(0).click();
            textAreaAndroid.get(0).sendKeys("testing ");
        } else {

            Thread.sleep(1000);
            textArea.click();
            textArea.sendKeys("testing");
            hideKeyboardWithDone();
        }
    }

    public void clickOnBackButtonAndClickOnNo() throws InterruptedException {


        if(isElementDisplayed(backButton))
        backButton.click();
        Thread.sleep(2000);
        if (branding.equals(Branding.TOTR)){
        if(isElementDisplayed(noBtn))
            noBtn.click();}
    }

    public void verifyDisplayOfStartScreen() throws IOException, InterruptedException {


       CheckDisplayedOfElement(startItem,"start page");

    }
    public void verifyProcessAutosavingIsActivated() throws InterruptedException, IOException {
        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        SettingsMoreScreen settingsMoreScreen = new SettingsMoreScreen(mDriver);
        SettingsScreen settingsScreen = new SettingsScreen(mDriver);
        OptionScreen optionScreen = new OptionScreen(mDriver);

        tabBarScreen.goToMore();
        settingsMoreScreen.clickOnSettings();


        settingsScreen.clickOnOptions();


        if (mPlatform.equals(Platforms.ANDROID))
            optionScreen.scrollToAnElementByText(mDriver, "Process QR code");

        if (mPlatform.equals(Platforms.ANDROID)) {

            String processAutoSavingStatus = optionScreen.getProcessAutoSavingSwitcher().getAttribute("checked");

            if (isElementDisplayed(optionScreen.getProcessAutoSaving()) && isElementDisplayed(optionScreen.getProcessAutoSavingSwitcher()))
            {
                if(processAutoSavingStatus.equalsIgnoreCase("true"))
                    mLogger.log(Status.PASS, " switcher ON");
                else{
                    optionScreen.getProcessAutoSavingSwitcher().click();

                }


            }
        } else {
           scrollFromElementToAnother(optionScreen.getmPublic(),optionScreen.getProcessQrCode());

            String processAutoSavingStatus =optionScreen.getProcessAutoSavingSwitcher() .getAttribute("value");

            if (isElementDisplayed(optionScreen.getProcessAutoSaving()) && isElementDisplayed(optionScreen.getProcessAutoSavingSwitcher())) {
                if(processAutoSavingStatus.contentEquals("1"))
                    mLogger.log(Status.PASS, "switcher ON");
                else{
                    optionScreen.getProcessAutoSavingSwitcher().click();

                }

            }
        }

    }
    public void clickOnBackButtonAndConfirm() throws InterruptedException {
        if (mPlatform.equals(Platforms.ANDROID)) {
            Thread.sleep(1000);
            backButton.click();
            yesBtn.click();
        } else {
            Thread.sleep(1000);
            backButton.click();
            yesBtn.click();
        }

    }

    public void verifyPreviousProcessData() {


                if (mPlatform.equals(Platforms.ANDROID)) {
                    boolean previousProcessDataisFilled = textAreaAndroid.get(0).getText().isEmpty() == false && textAreaAndroid.get(0).getAttribute("text").equalsIgnoreCase("Test");
                    Assert.assertTrue(previousProcessDataisFilled, "the previous data of the process is not loaded");

                        } else {
                    boolean previousProcessDataisFilled = textFieldInput.getText().isEmpty() == false && textFieldInput.getAttribute("label").equalsIgnoreCase("Test");
                    Assert.assertTrue(previousProcessDataisFilled, "the previous data of the process is not loaded");
                        }


    }
    //Table methods

    public void fillFirstRowTable(String a, String d) {
        getRowTable().get(0).click();
        getWidgetNumberInsideTable().get(0).sendKeys(a);
        getNextButton().click();
        getWidgetCurrency().get(1).click();
        getWidgetCurrency().get(1).sendKeys(d);
        getNextButton().click();
        getRowTable().get(0).click();
    }

    public void fillSecondRowTable(String b, String c) {
        getRowTable().get(1).click();
        getWidgetNumberInsideTable().get(0).sendKeys(b);
        getNextButton().click();
        getWidgetCurrency().get(1).click();
        getWidgetCurrency().get(1).sendKeys(c);
        getNextButton().click();
        getRowTable().get(1).click();
    }

    public void fillThirdRowTable(String c, String a) {
        getRowTable().get(2).click();
        getWidgetNumberInsideTable().get(0).sendKeys(c);
        getNextButton().click();
        getWidgetCurrency().get(1).click();
        getWidgetCurrency().get(1).sendKeys(a);
        getNextButton().click();
        getRowTable().get(2).click();
    }

    public void getNextStepProcess() {
        getStepProcess().click();
    }

}
