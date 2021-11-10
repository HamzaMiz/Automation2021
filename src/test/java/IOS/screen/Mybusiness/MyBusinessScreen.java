package IOS.screen.Mybusiness;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class MyBusinessScreen extends STWScreen {


    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search\"])[1]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][1]",priority = 2)
    private MobileElement activitySearchBar;
    @iOSXCUITFindBy(accessibility = "processNameTextField")
    private MobileElement processNamTextField;
    @FindBy(name = "ResourcesViewController_categoryName")
    private MobileElement categoryName;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement activitySearchBarCancelBtn;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancelSearchBtn;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[contains(@name, 'Search')]",priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`][2]",priority = 2)
    private MobileElement startSearchBar;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "ResourcesTableViewCell_processName")
    private MobileElement processSearchResult;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "wrapperView1_0")
    private MobileElement processAction;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "wrapperView1_2")
    private MobileElement submitProcess;
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
    private MobileElement phoneNumberFieldInput;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Save\"`]")
    private MobileElement saveBtn;
    @iOSXCUITFindBy(accessibility = "DropDownCell_selectorButton")
    private MobileElement dropdownSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save process\"]")
    private MobileElement saveProcessInsideMoreFromMbContactPicker;
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    private MobileElement closeInsideMoreFromMbContactPicker;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Contacts\"]")
    private MobileElement contactsLabelFromMbContactPicker;
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`]",priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]", priority = 2)
    private MobileElement close;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ResourceCreationViewController_moreBarButton\"]", priority = 1)
    @iOSXCUITFindBy(accessibility = "ResourceCreationViewController_moreBarButton",priority = 2)
    private MobileElement threeDotsMenuOfProcess;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'titleVersionLabel')]")
    private List<MobileElement> historyVersions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Process history\"]")
    private MobileElement processHistoryFromProcessOptions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Step recipients\"]")
    private MobileElement StepRecipientsFromProcessOptions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Forward process\"]")
    private MobileElement forwardProcessFromProcessOptions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Duplicate process\"]")
    private MobileElement DuplicateProcessFromProcessOptions;
    @WithTimeout(time = 1L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Duplicate process\"`]",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Duplicate process\"]", priority = 1)
    private MobileElement DuplicateProcess;
    @iOSXCUITFindBy(accessibility = "AskMeAgainAlertView_okButton")
    private MobileElement confirmPopup;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_oldRecipientsView")
    private MobileElement OldRecipientsView;
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"ConversationList deselect\" AND name == \"ContactCellPiker_checkbox\"")
    private MobileElement contactCheckBox;
    @iOSXCUITFindBy(accessibility = "MyBusinessCell_processTitle")
    private MobileElement processTitleIncategories;
    @iOSXCUITFindBy(accessibility = "ResourcesTableViewCell_processName")
    private MobileElement processTitleInStarttab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Search\"`]")
    private MobileElement searchBarMBContactPicker;
    @iOSXCUITFindBy(accessibility = "MBPickerViewController_filterBarButtonindividuals")
    private MobileElement invidividualsMBContactPicker;
    @iOSXCUITFindBy(accessibility =  "MBPickerViewController_filterBarButtonGroups")
    private MobileElement groupsMBContactPicker;
    @WithTimeout(time = 15L, chronoUnit = ChronoUnit.SECONDS)
   @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement contactCell;
    @iOSXCUITFindBy(accessibility = "wrapperView1_1")
    private MobileElement completeProcess;
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement startSearchBarCancelBtn;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "Activity")
    private MobileElement activityItem;
    @iOSXCUITFindBy(accessibility = "Start")
    private MobileElement startItem;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "arrangeBtn_0")
    private MobileElement newCategory;
    @iOSXCUITFindBy(accessibility = "arrangeBtn_1")
    private MobileElement draftCategory;
    @iOSXCUITFindBy(accessibility = "arrangeBtn_2")
    private MobileElement inProgressCategory;
    @iOSXCUITFindBy(accessibility = "arrangeBtn_3")
    private MobileElement submittedCategory;
    @iOSXCUITFindBy(accessibility = "arrangeBtn_4")
    private MobileElement completedCategory;
    @iOSXCUITFindBy(accessibility = "arrangeBtn_5")
    private MobileElement canceledCategory;
    //New category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_0")
    private MobileElement newCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_0")
    private MobileElement newCategorySortButton;

    //@FindBy(how= How.XPATH, xpath="(//XCUIElementTypeCell[@name=\"MBPickerViewController_0_0\"])[2]/XCUIElementTypeButton[2]")
    //WebElement contactCell;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_0",priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_0\"])[1]", priority = 1)
    private MobileElement newCategoryOptionButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_0_0", priority=0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'MyBusinessViewController_0_0')]", priority = 1)
    private MobileElement newCategoryFirstProcess;
    //Draft category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_1")
    private MobileElement draftCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_1")
    private MobileElement draftCategorySortButton;
    @WithTimeout(time = 2L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_1",priority = 2)
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
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_2",priority = 2)
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
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_3",priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_3\"])[1]", priority = 1)
    private MobileElement submittedCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_3_0")
    private MobileElement submittedCategoryFirstProcess;
    //Completed category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_4")
    private MobileElement completedCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_4")
    private MobileElement completedCategorySortButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_4",priority = 2)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"moreFilter_4\"])[1]", priority = 1)
    private MobileElement completedCategoryOptionButton;
    @iOSXCUITFindBy(accessibility = "MyBusinessViewController_4_0")
    private MobileElement completedCategoryFirstProcess;
    //Canceled category Elements
    @iOSXCUITFindBy(accessibility = "toolFilter_5")
    private MobileElement canceledCategoryFiltre;
    @iOSXCUITFindBy(accessibility = "filter_5")
    private MobileElement canceledCategorySortButton;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "moreFilter_5",priority = 2)
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
    private MobileElement StatusbyMeLabel;
    @WithTimeout(time = 3L, chronoUnit = ChronoUnit.SECONDS)
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE )
    @iOSXCUITFindBy(accessibility = "CustomAlertView_ok",priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CustomAlertView_ok\"]", priority = 1)
    private MobileElement confirmDeleteAllProcesses;
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
    private MobileElement processOptions;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Schedule\"`]")
    private MobileElement scheduleSwitcher;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == \"Due Date\"`]")
    private MobileElement duedateSwitcher;
    @iOSXCUITFindBy(accessibility = "PriorityCell_switchPriority")
    private MobileElement prioritySwitcher;
    @iOSXCUITFindBy(accessibility = "Start Date and Time")
    private MobileElement startDateTime;
    @iOSXCUITFindBy(accessibility = "TextFieldCellDate_btnClick")
    private MobileElement calenderIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    private MobileElement saveCalender;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
    private MobileElement cancelCalender;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ProcessDataSource_0_0\"]/XCUIElementTypeOther/XCUIElementTypeTextView")
    private MobileElement textArea;
    @iOSXCUITFindBy(accessibility = "ResourceCreationViewController__backButton")
    private MobileElement backButton;
    @iOSXCUITFindBy(accessibility = "You are about to exit the process. Save your process?")
    private MobileElement confirmPopUp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"No\"]")
    private MobileElement noBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
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
    @iOSXCUITFindBy(accessibility = "Next:")
    private MobileElement nextButton;


// elements in text area widget
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RESULT\"`]")
    private MobileElement stepProcess;
    @iOSXCUITFindBy(accessibility = "Process history")
    private MobileElement processHistory;
    @iOSXCUITFindBy(accessibility = "Step recipients")
    private MobileElement stepRecipients;
    @iOSXCUITFindBy(accessibility = "Chat with recipients")
    private MobileElement chatWithRecipients;
    @iOSXCUITFindBy(accessibility = "Save process")
    private MobileElement saveProcess;
    @iOSXCUITFindBy(accessibility = "Untake the lead")
    private MobileElement untakeTheLead;
    @iOSXCUITFindBy(accessibility = "Cancel process")
    private MobileElement cancelProcess;
    @iOSXCUITFindBy(accessibility = "Conference Call")
    private MobileElement conferenceCall;
    @iOSXCUITFindBy(accessibility = "HistoryTableViewController_0_0")
    private MobileElement historyProcessDetailVersion;
    @iOSXCUITFindBy(accessibility = "OptionsProcessViewController_switchRepeat")
    private MobileElement repeatProcessOptionSwitcher;
    @iOSXCUITFindBy(accessibility = "Stop Repeating")
    private MobileElement stopRepeatingOption;
    @iOSXCUITFindBy(id = "item_mybusiness_expandable_list_process_sender_name")
    private MobileElement senderName;
    @iOSXCUITFindBy(id = "item_mybusiness_expandable_list_process_status")
    private MobileElement canceledBy;


   // Elements in three dots menu in a process after taking the lead

    public MyBusinessScreen(AppiumDriver driver) {

        super(driver);

    }

    public MobileElement getProcessNamTextField() {
        return processNamTextField;
    }

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

    public MobileElement getSenderName(){return senderName;}
    public MobileElement getCanceledBy(){return canceledBy;}

 public MobileElement getStopRepeatingOption(){return stopRepeatingOption;}
public MobileElement getRepeatProcessOptionSwitcher(){return repeatProcessOptionSwitcher;}
public MobileElement getHistoryProcessDetailVersion(){return historyProcessDetailVersion;}
    public MobileElement getProcessHistory(){return processHistory;}
    public MobileElement getStepRecipients(){return stepRecipients;}
    public MobileElement getChatWithRecipients(){return chatWithRecipients;}
    public MobileElement getSaveProcess(){return saveProcess;}
    public MobileElement getUntakeTheLead(){return untakeTheLead;}
    public MobileElement getCancelProcess(){return cancelProcess;}
    public MobileElement getConferenceCall(){return conferenceCall;}
    public MobileElement getTextArea(){return textArea;}
    public MobileElement getBackButton(){return backButton;}
    public MobileElement getConfirmPopUp(){return confirmPopUp;}
    public MobileElement getYesBtn(){return yesBtn;}
    public MobileElement getNoBtn(){return noBtn;}


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

    public MobileElement getStartDateTime(){return startDateTime;}
    public MobileElement getCalenderIcon(){return calenderIcon;}
    public MobileElement getSaveCalender(){return saveCalender;}
    public MobileElement getCancelCalender(){return cancelCalender;}

    public MobileElement getCategoryName() {
        return categoryName;
    }
    public MobileElement getProcessOptions(){return  processOptions;}
    public MobileElement getScheduleSwitcher(){return scheduleSwitcher;}
    public MobileElement getDuedateSwitcher(){return duedateSwitcher;}
    public MobileElement getPrioritySwitcher(){return prioritySwitcher;}
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
        return StatusbyMeLabel;
    }

    public MobileElement getProcessSearchResult() {
        return processSearchResult;
    }

    public MobileElement getProcessAction() {
        return processAction;
    }

    public MobileElement getClose() {
        return close;
    }

    public MobileElement getThreeDotsMenuOfProcess() {
        return threeDotsMenuOfProcess;
    }

    public MobileElement getTakeTheLeadConfirmBtn() {
        return confirmPopup;
    }

    public MobileElement getDuplicateProcess() {
        return DuplicateProcess;
    }

    public MobileElement getConfirmPopup() {
        return confirmPopup;
    }

    public MobileElement getSearchBarMBContactPicker() {
        return searchBarMBContactPicker;
    }

    public MobileElement getOldRecipientsView() {
        return OldRecipientsView;
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
        return submitProcess;
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
    public void modifyProcessName(String newProcessName){

        processNamTextField.sendKeys(newProcessName);

    }




    public void verifyToastOfMultipleMandatoryFieldsisDisplyed() {
        WebDriverWait wait = new WebDriverWait(mDriver,5 );

        assertNotNull(wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Please fill the 3 mandatory fields highlighted in red\"`]"))));

    }

    public void verifyToastOfOneMandatoryFieldisDisplyed() {
        WebDriverWait wait = new WebDriverWait(mDriver,5 );

        assertNotNull(wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.AccessibilityId("Please fill the mandatory field Adresse e-mail"))));

    }

    public void clickOnStart() {

        getStartItem().click();
        //mLogger.log(Status.PASS, "Step 2: User A presses on Start button");
    }

    public void checkCategoryIsDisplayed() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(isElementDisplayed(getCategoryName()),"The matched process is not displayed with their categorie");


    }


    public void initiateProcessFromStartTab(String processName) throws InterruptedException {

        clickOnStart();
        searchProcessStart(processName);
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

    public void searchProcessStart(String processName) throws InterruptedException {


      scrollDown(1, 1000);
        //mLogger.log(Status.PASS, "Step 3:  User A puling down the process list  (for iOS) ");

        if (isElementDisplayed(getStartSearchBar())) {
            //getStartSearchBar().click();
            clearTextFully(getStartSearchBar());

            Actions a = new Actions(mDriver);
            a.sendKeys(processName);
            a.perform();
            //getStartSearchBar().sendKeys(processName);
            hideKeyboardIos();
        }
    }

    public void deleteAllProcessesInNewCategory() {

        if ((isElementDisplayed(getNewCategoryOptionButton())) && getNewCategoryOptionButton().isEnabled()) {
            getNewCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }

    }

    public void deleteAllProcessesInDraftCategory() {

        if ((isElementDisplayed(getDraftCategoryOptionButton())) && getDraftCategoryOptionButton().isEnabled()) {
            getDraftCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }
    }

    public void deleteAllProcessesInInProgressCategory() {

        if (isElementDisplayed(getInProgressCategoryOptionButton()) && getInProgressCategoryOptionButton().isEnabled()) {
            getInProgressCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }
    }

    public void deleteAllProcessesInSubmittedCategory() {

        if ((isElementDisplayed(getSubmittedCategoryOptionButton())) && getSubmittedCategoryOptionButton().isEnabled()) {
            getSubmittedCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }
    }

    public void deleteAllProcessesInCompletedCategory() {

        if ((isElementDisplayed(getCompletedCategoryOptionButton())) && getCompletedCategoryOptionButton().isEnabled()) {
            getCompletedCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }
    }

    public void deleteAllProcessesInCanceledCategory() {

        if ((isElementDisplayed(getCanceledCategoryOptionButton())) && getCanceledCategoryOptionButton().isEnabled()) {
            getCanceledCategoryOptionButton().click();
            getDeleteAllProcesses().click();
            getConfirmDeleteAllProcesses().click();
        }
    }

    public void deleteAllProcesses() {
        if ( getNewCategoryOptionButton().isEnabled() || getDraftCategoryOptionButton().isEnabled() ||getInProgressCategoryOptionButton().isEnabled() ||getSubmittedCategoryOptionButton().isEnabled() || getCompletedCategoryOptionButton().isEnabled() || getCanceledCategoryOptionButton().isEnabled()) {
            deleteAllProcessesInNewCategory();
            deleteAllProcessesInDraftCategory();
            deleteAllProcessesInInProgressCategory();
            deleteAllProcessesInSubmittedCategory();
            deleteAllProcessesInCompletedCategory();
            deleteAllProcessesInCanceledCategory();
        }
    }

    public void clickOnFirstSearchResultInStart() throws InterruptedException {
        Thread.sleep(1000);
        getProcessSearchResult().click();
    }

    public void openHistoryofprocess() throws InterruptedException {
        clickOnThreeDotsMenuOfProcess();
        Thread.sleep(500);
        getProcessHistoryFromProcessOptions().click();
    }

    public void confirmBtn() {
        getConfirmPopup().click();

    }

    public void clickOnProcessFloatingActions() {

        getProcessAction().click();
    }

    public void sendProcess() throws InterruptedException {
        clickOnProcessFloatingActions();
        Thread.sleep(1000);
        getSubmitProcess().click();

    }

    public void completeProcess() {
        clickOnProcessFloatingActions();
        getCompleteProcess().click();

    }

    public void searchContactToSubmit(String contact) throws InterruptedException {

        if (!isElementDisplayed(getOldRecipientsView())) {
            clickOnIndividuals();
            scrollDown(1, 500);
            clearTextFully(getSearchBarMBContactPicker());

         /*   Actions a = new Actions(mDriver);
            a.sendKeys(contact);
            a.perform();*/
           getSearchBarMBContactPicker().sendKeys(contact);
            hideKeyboardIos();
        }
    }

    public void searchGroupToSubmit(String group) throws InterruptedException {

        if (!isElementDisplayed(getOldRecipientsView())) {
            clickOnGroups();
            getSearchBarMBContactPicker().clear();
            scrollDown(1, 500);
            getSearchBarMBContactPicker().click();
            getSearchBarMBContactPicker().clear();

            Actions a = new Actions(mDriver);
            a.sendKeys(group);
            a.perform();
           // getSearchBarMBContactPicker().sendKeys(group);

            hideKeyboardIos();
        }
    }

    public void selectContactToSubmit() throws InterruptedException {
        //TouchAction action = new TouchAction(mDriver);

        if (!isElementDisplayed(getOldRecipientsView()))
            //action.tap(TapOptions.tapOptions().withElement(ElementOption.element(contactCell))).perform();
            clickOnElementPositionForContactCell (contactCell,5,5);
    }

    public void selectGroupToSubmit() {

        if (!isElementDisplayed(getOldRecipientsView()))
            clickOnElementPositionForContactCell (contactCell,5,5);
    }

    public void submitProcess() throws InterruptedException {
        Thread.sleep(2000);
        getProcessAction().click();
    }

    public void clickOnActivity() throws InterruptedException {
        Thread.sleep(1000);

        getActivityItem().click();
    }

    public void expandNewCategory() {

        getNewCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void collapseNewCategory() {

        getNewCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void expandDraftCategory() {

        getDraftCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void verifyDisplayDetailsInCanceledProcess() throws IOException, InterruptedException {
        Boolean verifyDetails =  checkIfElementIsPresent(getCanceledBy(),"canceled by") == true && checkIfElementIsPresent(getSenderName(),"sendername")== true;
        Assert.assertTrue(verifyDetails, "Canceled By me is not displayed in Canceled process");
    }

    public void collapseDraftCategory() {

        getDraftCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void expandInProgressCategory() {

        getInProgressCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void collapseInProgressCategory() {

        getInProgressCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void expandSubmittedCategory() {

        getSubmittedCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void collapseSubmittedCategory() {

        getSubmittedCategoryOptionButton().click();
        getCollapseCategory().click();
    }


    public void expandCompletedCategory() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
       wait.until(ExpectedConditions.visibilityOf(completedCategoryOptionButton));
        getCompletedCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void collapseCompletedCategory() {

        getCompletedCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void expandCanceledCategory()throws InterruptedException {
        Thread.sleep(1000);
        getCanceledCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void collapseCanceledCategory() {

        getCanceledCategoryOptionButton().click();
        getCollapseCategory().click();
    }

    public void clickOnNewCategoryOptions() {

        getNewCategoryOptionButton().click();
    }

    public void clickOnSubmittedCategoryOptions() {

        getSubmittedCategoryOptionButton().click();
    }


    public void checkIfProcessIsReceivedInNew(String processName) throws IOException, InterruptedException {


        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

        assertTrue(iselementpresent,"Targeted element App is not present on screen." );
    }



    public void checkIfProcessIsInDraft(String processName) throws IOException, InterruptedException {

        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

       assertTrue(iselementpresent,"Targeted element App is not present on screen." );
    }

    public void checkIfProcessIsInProgress(String processName) throws IOException, InterruptedException {
        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

       assertTrue(iselementpresent,"Targeted element App is not present on screen.");
    }

    public void checkIfProcessIsInSubmitted(String processName) throws IOException, InterruptedException {
        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

       assertTrue(iselementpresent,"Targeted element App is not present on screen.");
    }

    public void checkIfProcessIsInCompleted(String processName) throws IOException, InterruptedException {
        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

       assertTrue(iselementpresent,"Targeted element App is not present on screen.");
    }

    public void checkIfProcessIsInCanceled(String processName) throws IOException, InterruptedException {
        checkIfElementIsPresent(getProcessTitle(),"process title");

        Boolean iselementpresent = getProcessTitle().getAttribute("label").equalsIgnoreCase(processName);
        //iselementpresent will be true so assertion will pass and so test method will pass too.

      assertTrue(iselementpresent,"Targeted element App is not present on screen." );
    }

    public void checkIfNewCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(newCategory,"New category");


    }

    public void checkIfDraftCategoryIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(draftCategory,"draft category");

    }

    public void checkIfInProgressCategoryIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(inProgressCategory,"In progress category");
    }

    public void checkIfSubmittedCategoryIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(submittedCategory,"submitted category");

    }

    public void checkIfCompletedCategoryIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(completedCategory,"completed category");


    }

    public void checkIfCanceledCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(canceledCategory,"canceled category");

    }

    public void checkIfCompletedByMeisDisplayed() throws IOException, InterruptedException {


        CheckDisplayedOfElement(getStatusbyMeLabel(),"Status: Completed by [initiator name]");

    }

    public void checkIfWaitingToBeSubmittedisDisplayed() {


        boolean isDisplayed =isElementDisplayed(getStatusbyMeLabel()) && getStatusbyMeLabel().getAttribute("value").equalsIgnoreCase("Waiting to be submitted!");

        assertTrue(isDisplayed,"The following informations are not displayed:\\n\" +\n" +
                "                    \"- Status: Waiting to be submitted!\\n" );
    }

    public void verifyMbContactPickerBarElementsisDisplayed() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();


        boolean isDisplayed=isElementDisplayed(getBackBtnFromMbContactPicker()) && isElementDisplayed(getMoreBtnFromMbContactPicker()) && isElementDisplayed(getContactsLabelFromMbContactPicker()) && isElementDisplayed(getGroupsMBContactPicker()) && isElementDisplayed(getInvidividualsMBContactPicker());

        softAssert.assertTrue(isDisplayed,"The adding recipient page is not displayed");


        boolean SubmitIconisNotDisplayed =isElementDisplayed(getSubmitProcess()) == false;
        softAssert.assertTrue(SubmitIconisNotDisplayed," the Submit icon is active");

        getMoreBtnFromMbContactPicker().click();
        boolean saveAndcloseButtonisDisplayed =isElementDisplayed(getSaveProcessInsideMoreFromMbContactPicker()) && isElementDisplayed(getCloseInsideMoreFromMbContactPicker());
        softAssert.assertTrue(saveAndcloseButtonisDisplayed," The adding recipient page is not displayed and it has the following structure (iOS):\\n\" +\n" +
                "                    \" 3 dots (by clicking in it : Save process, Close)\"");

        Thread.sleep(1000);
        getCloseInsideMoreFromMbContactPicker().click();
        softAssert.assertAll();
    }

    public void verifyPreviousRecipientsIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(getOldRecipientsView(),"The previous contacts");

    }

    public void clickOnIndividuals() {
        getInvidividualsMBContactPicker().click();
    }

    public void clickOnGroups() {
        getGroupsMBContactPicker().click();
    }

    public void recieveProcessInNewCateogry(String processName, String contact) throws InterruptedException {
        clickOnStart();
        searchProcessStart(processName);
        clickOnFirstSearchResultInStart();
        sendProcess();
        searchContactToSubmit(contact); // submit process to Oneself
        selectContactToSubmit();
        submitProcess();
        clickOnActivity();
        clickOnNewCategoryOptions();
        expandNewCategory();
    }

    public void recieveProcessInsubmittedCateogry(String processName, String contact2) throws InterruptedException {
        clickOnStart();
        searchProcessStart(processName);
        clickOnFirstSearchResultInStart();
        sendProcess();

        searchContactToSubmit(contact2); // submit process to Oneself
        selectContactToSubmit();
        submitProcess();
        clickOnActivity();
        clickOnSubmittedCategoryOptions();
        expandSubmittedCategory();
    }

    public void recieveProcessIncompletedCateogry(String processName, String contact) throws InterruptedException {
        clickOnStart();
        searchProcessInStartAndOpenIt(processName);
        completeProcess();
        searchContactToSubmit(contact);
        selectContactToSubmit();
        submitProcess();
        confirmBtn();
        clickOnActivity();
        expandCompletedCategory();

    }

    public void openRecievedProcessInNewCategory() throws InterruptedException {
        Thread.sleep(1000);
        mDriver.getPageSource();
        isElementDisplayed(getNewCategoryFirstProcess());
        getNewCategoryFirstProcess().click();
    }
    public void openRecievedProcessInSubmittedCategory() throws InterruptedException {
        getSubmittedCategoryFirstProcess().click();
    }

    public void openRecievedProcessInCompletedCategory() throws InterruptedException {
        getCompletedCategoryFirstProcess().click();
    }

    public void searchProcessInStartAndOpenIt(String processName) throws InterruptedException {
        clickOnStart();
        searchProcessStart(processName);
        clickOnFirstSearchResultInStart();


    }

    public void openInProgressCategoryFirstProcess() throws InterruptedException {
        Thread.sleep(1000);
        getInProgressCategoryFirstProcess().click();

    }

    public void openInCompletedCategoryFirstProcess() throws InterruptedException {
        Thread.sleep(1000);
        getCompletedCategoryFirstProcess().click();

    }

    public void openInSubmitedCategoryFirstprocess() throws InterruptedException {
        Thread.sleep(1000);
        getSubmittedCategoryFirstProcess().click();
    }
    public void verifyDisplayOfStopRepeatingOption() throws InterruptedException, IOException {
        Thread.sleep(200);
        clickOnThreeDotsMenuOfProcess();
        CheckDisplayedOfElement(getStopRepeatingOption(),"Stop repeating");
    }
    public void takeTheLead() {
        getProcessAction().click();
        getConfirmPopup().click();
    }


    public void clickOnThreeDotsMenuOfProcess() throws InterruptedException {
        Thread.sleep(1000);
        getThreeDotsMenuOfProcess().click();
    }

    public void clickOnProcessOptionsInThreeDots() throws InterruptedException {
        Thread.sleep(1000);
        getProcessOptions().click();

    }
    public void activateRepeatProcessOption() throws InterruptedException {
        Thread.sleep(600);
        getRepeatProcessOptionSwitcher().click();
    }
    public void activateScheduleOption() throws InterruptedException {
        Thread.sleep(1000);
        getScheduleSwitcher().click();

    }

    public void verifyDisplayOfDetailsInSchedule() throws InterruptedException {

        Thread.sleep(1000);

        boolean StartDateAndTimeisDisplayed = isElementDisplayed(getStartDateTime());

        assertTrue(StartDateAndTimeisDisplayed,"Start Date and Time is not  displayed");


        boolean calendarIsDisplayed = isElementDisplayed(getStartDateTime());

        assertTrue(calendarIsDisplayed,"Calender icon is not  displayed");

    }

    public void OpenProcessHistoryDetails() throws InterruptedException {
        Thread.sleep(200);
        clickOnThreeDotsMenuOfProcess();
        getProcessHistoryFromProcessOptions().click();

    }
    public void verifyProcessHistoryDetails() throws InterruptedException {
        Thread.sleep(200);
        if (isElementDisplayed(getHistoryProcessDetailVersion()) && isElementDisplayed(getHistoryProcessDetailVersion())) {
      }else Assert.fail("version details  is not displayed");
    }
    public void verifyDisplayOfCalender() throws InterruptedException {
        Thread.sleep(1000);
        getCalenderIcon().click();

        boolean calendarIsDisplayed = isElementDisplayed(getSaveCalender());


        assertTrue(calendarIsDisplayed,"Calender is displayed");
    }

    public void cancelSearch() {
        getCancelSearchBtn().click();
    }

    public void closeProcessOptions() {
        getClose().click();
    }

    public void verifyDuplicateBtnIsNotDisplayed() {
        boolean isNotDisplayed = isElementDisplayed(getDuplicateProcess()) == false;

        Assert.assertTrue(isNotDisplayed, "error :duplicate option is displayed");

    }

    public void verifyDuplicateBtnIsDisplayed() {
        boolean isDisplayed = isElementDisplayed(getDuplicateProcess()) == true;

        Assert.assertTrue(isDisplayed, "error :duplicate option is not displayed");

    }

    public void clickOnChatWithRecipients() throws InterruptedException {
        // getChatWithRecipients().click();
        getChatWithRecipients().click();
        Thread.sleep(3000);

    }


    public void verifyProcessHistory() {
        int versionNumber = 2;
        int historyVersionsSize = getHistoryVersions().size();
        Assert.assertEquals(historyVersionsSize, versionNumber);
      //  mLogger.log(Status.PASS, "Two events having the same information and version are listed on the history");


    }

    public void verifyProcessHistoryButtonisNotDisplayed() {
        boolean isNotDisplayed = !isElementDisplayed(getProcessHistoryFromProcessOptions());
        Assert.assertTrue(isNotDisplayed, "error :process history is displayed");

    }


    public void verifyProcessHistoryButtonisDisplayed() {
        boolean isDisplayed = isElementDisplayed(getProcessHistoryFromProcessOptions());
        Assert.assertTrue(isDisplayed, "error : process history is not displayed");

    }

    public void verifyProcessNameIsNotEnabled() {
        boolean IsNotEnabled = isElementEnabled(getProcessNamTextField()) == false;
        Assert.assertTrue(IsNotEnabled, "error : process name is  editable");

    }

    public void verifyToastOfNoRightToEditisDisplyed() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        processNamTextField.click();
        assertNotNull(wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"No Right to edit Process name\"`]"))));

    }


    public void openDropDownSelectorAndSave() {

        getDropdownSelector().click();
        getSaveBtn().click();
    }


    public void cancelProcess() throws InterruptedException {
        clickOnThreeDotsMenuOfProcess();
        Thread.sleep(1000);
        getCancelProcess().click();
        confirmBtn();


    }

    public void fillTextAreaWidget() throws InterruptedException {
        Thread.sleep(1000);
        getTextArea().click();
        getTextArea().sendKeys("testing");
        hideKeyboardWithDone();
    }

    public void clickOnBackButtonAndClickOnNo() throws InterruptedException {

        getBackButton().click();
        Thread.sleep(2000);
        getNoBtn().click();
    }

    public void verifyDisplayOfStartScreen() {

        boolean isDisplayed = isElementDisplayed(getStartItem());
        assertTrue(isDisplayed,"star screen is not displayed");

    }

    public void clickOnBackButtonAndConfirm() throws InterruptedException {
        Thread.sleep(1000);
        getBackButton().click();
        getYesBtn().click();
    }

    public void verifyPreviousProcessData() {

        boolean previousProcessDataisFilled = getTextFieldInput().getText().isEmpty() == false && getTextFieldInput().getAttribute("label").equalsIgnoreCase("Test");
        Assert.assertTrue(previousProcessDataisFilled, "the previous data of the process is not loaded");
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
    public void getNextStepProcess()
    {
        getStepProcess().click();
    }

}
