package android.screen.mybusiness;

import android.screen.ConversationScreen;
import android.screen.TabBarScreen;
import com.aventstack.extentreports.Status;
import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;

public class MyBusinessScreen extends STWScreen {


    //MB first view
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_switch_left_container")
    private MobileElement activityItem;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_switch_right_container")
    private MobileElement startItem;
    @AndroidFindBy(id = "fragment_my_business_operation_status_button")
    private MobileElement operationalStatusBtn;
    //search bar button(For both Activity/Start)
    @AndroidFindBy(id = "fragment_my_business_search_floating_button")
    private MobileElement searchBarBtn;
    //search bar content(For both Activity/Start)
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_my_business_search_content")
    private MobileElement searchBarContent;
    //search clear content(For both Activity/Start)
    @AndroidFindBy(id = "view_my_business_search_clear_content")
    private MobileElement searchClearContent;
    //first searched template(Start)
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "resource_process_item_title")
    private List<MobileElement> firstSearchedProcess;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_group_my_business_expandable_list_title")
    private List<MobileElement> processCategorie;

    @AndroidFindBy(id = "phone_number_input")
    private MobileElement phoneNumTextField;

    public MobileElement getPhoneNumTextField() {
        return phoneNumTextField;
    }

    //MB categories
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SUBMITTED']")
    private MobileElement submittedCategory;

    //dropdown widget

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement dropDownSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '3')]")
    private MobileElement dropDownSelectorFirstItem;

    //To handle these items (categories) with ElementToClick Method
    //ElementToClick("NAME",0,0 ).click();
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEW']")
    private MobileElement newCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DRAFT']")
    private MobileElement draftCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='IN PROGRESS']")
    private MobileElement inProgressCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMPLETED']")
    private MobileElement completedCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'CANCELED')]")
    private MobileElement canceledCategory;
    @AndroidFindBy(id = "view_group_my_business_expandable_list_title")
    private List<MobileElement> mBCategoryName;
    //Category Elements
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_group_my_business_expandable_list_filter_button")
    private List<MobileElement> categoryFilter;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "view_group_my_business_expandable_list_icon")
    private List<MobileElement> ExpandButton;
    @AndroidFindBy(id = "view_group_my_business_expandable_list_sort_button")
    private List<MobileElement> categorySortButton;
    @AndroidFindBy(id = "view_group_my_business_expandable_list_menu_button")
    private List<MobileElement> categoryOptionButton;
    @AndroidFindBy(id = "menu_process_filter_result")
    private MobileElement showResultButton;
    //Category Elements(menu btn)
    @WithTimeout(time = 35L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]")
    private MobileElement collapseCategoryButton;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
    private MobileElement readAllNotificationButton;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]")
    private MobileElement deleteAllProcessButton;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmDeleteAllProcessesButton;
    //Process Actions by long click
    @AndroidFindBy(xpath = "//android.widget.TextView[1]")
    private MobileElement openProcess;
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private MobileElement historyProcess;
    @AndroidFindBy(xpath = "//android.widget.TextView[3]")
    private MobileElement deleteProcess;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private List<AndroidElement> activityFloatingAction;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "activity_process_form_floating_action_menu")
    private MobileElement takeTheleadBtn;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmBtn;


    //Actions when opening a template
   /* @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"processOption\"]/android.widget.ImageButton")
    private MobileElement activityFloatingAction;
    // [@id='activity_process_form_floating_action_menu']*/
    // [@id='activity_process_form_floating_action_menu']
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement cancelBtn;
    //Options when opening a template
    @AndroidFindBy(id = "activity_my_business_contact_selection_floating_action_menu")
    private MobileElement contactSelectionFloating;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[2]")
    private MobileElement CollapseBtn;
    //elements in Mbcontactpicker

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
    private MobileElement contactsLabelFromMbContactPicker;
    @AndroidFindBy(id = "menu_action_filter")
    private MobileElement contactsfilterFromMbContactPicker;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
    private MobileElement allLabelFromMbContactPicker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact']")
    private MobileElement individualLabelFromMbContactPicker;

    @AndroidFindBy(id = "activity_my_business_contact_selection_previous_recipients_text_view")
    private MobileElement oldRecipientsViewFromMbContactPicker;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Group']")
    private MobileElement groupLabelFromMbContactPicker;
    @AndroidFindBy(id = "menu_action_search")
    private MobileElement searchBtnFromMbContactPicker;
    @AndroidFindBy(id = "activity_process_form_process_name_text")
    private MobileElement processNamTextFieldWithoutEdit;
    @AndroidFindBy(id = "activity_process_form_process_name_edit")
    private MobileElement processNamTextFieldWithEdit;
    @AndroidFindBy(id = "menu_action_save_process")
    private MobileElement saveBtnFromMbContactPicker;
    //floating button
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton[1]")
    private List<AndroidElement> sendProcess;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton[2]")
    private List<AndroidElement> CompleteProcess;
    //Forward process actions elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward by Team on the Run']")
    private MobileElement forwardByApp;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward by email']")
    private MobileElement forwardByMail;
    //Elements for menu when opening a process
    @AndroidFindBy(id = "menu_process_form_activity_all_actions")
    private MobileElement threeDotsMenuProcess;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Step recipients']")
    private MobileElement stepRecipientsBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chat with the recipients']")
    private MobileElement chatWithRecipients;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Process history']")
    private MobileElement processHistory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Duplicate process']")
    private MobileElement duplicateProcess;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Conference Call']")
    private MobileElement conferenceCall;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forward process']")
    private MobileElement forwardProcess;
    @AndroidFindBy(accessibility = "Navigate up") ///accessibility id
    private MobileElement backBtn;
    //Elements in Option when opening a process ( 3 dots )
    @AndroidFindBy(id = "menu_process_form_activity_all_actions")
    private MobileElement threeDots;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Process options']")
    private MobileElement processOptions;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save process']")
    private MobileElement saveProcess;
    //Elements in process options when opening a process ( 3 dots )
    @AndroidFindBy(id = "view_my_business_options_item_header_title")
    private List<MobileElement> processOptionsItems;
    @AndroidFindBy(id = "view_my_business_options_item_header_toggle")
    private List<MobileElement> processOptionsSwitchers;
    //Elements in each option item
    @AndroidFindBy(id = "view_custom_date_picker_date_piker_button")
    private List<MobileElement> datePickerIcon;
    @AndroidFindBy(id = "view_custom_date_picker_date_piker_info")
    private List<MobileElement> datePickerInfo;
    @AndroidFindBy(id = "view_custom_date_picker_date_piker")
    private List<MobileElement> dateAndTime;
    //Elements in Schedule option
    @AndroidFindBy(id = "date_picker_header")
    private MobileElement datePickerHeader;
    //contact search
    @AndroidFindBy(id = "menu_action_search")
    private MobileElement search;
    @AndroidFindBy(id = "contact_search_content")
    private MobileElement searchContent;
    @AndroidFindBy(id = "check_selected_contact")
    private MobileElement checkSelectedContact;
    @AndroidFindBy(id = "activity_my_business_contact_selection_floating_action_menu")
    private MobileElement submitProcess;
    //Filter by name elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by name']")
    private MobileElement filterByName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Started by']")
    private MobileElement startedByFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Owner']")
    private MobileElement OwnerFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Receiver']")
    private MobileElement ReceiverFilter;
    @AndroidFindBy(xpath = "menu_process_apply")
    private MobileElement applyFilter;
    //Filter by date elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by date']")
    private MobileElement filterByDate;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]")
    private MobileElement startDate;
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]]")
    private MobileElement dueDate;
    //Filter by priority elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by priority']")
    private MobileElement filterByPriority;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High priority']")
    private MobileElement highPriorityFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Medium priority']")
    private MobileElement mediumPriorityFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Low priority']")
    private MobileElement lowPriorityFilter;
    //Filter by category elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by category']")
    private MobileElement filterByCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='IOS']")
    private MobileElement iOSFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='general']")
    private MobileElement generalFilter;
    //Sort elements
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort alphabetically']")
    private MobileElement sortAlpha;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort by priority']")
    private MobileElement sortByPriority;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort by start date']")
    private MobileElement sortByStartDate;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort by due date']")
    private MobileElement sortByDueDate;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort by reception date']")
    private MobileElement sortByReceptionDate;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort by category']")
    private MobileElement sortByCategory;
    //Table Elements:
    @AndroidFindBy(id = "view_group_table_widget_row_list_title")
    private List<MobileElement> rowTable;
    @AndroidFindBy(id = "my_business_widget_content_input_field_number_edit_text")
    private MobileElement widgetNumber;
    @AndroidFindBy(id = "my_business_widget_value_currency_field_edit_text")
    private MobileElement widgetCurrency;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_name")
    private MobileElement processTitle;
    @WithTimeout(time = 5L, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_container_layout")
    private List<MobileElement> processCellInAnycategorie;
    @AndroidFindBy(id = "view_table_widget_preview")
    private MobileElement previewElement;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.TextView")
    private List<MobileElement> previewRows;
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_status")
    private List<MobileElement> processStatus;
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_sender_name")
    private List<MobileElement> processSenderName;
    @AndroidFindBy(id = "item_mybusiness_expandable_list_process_last_update_date")
    private List<MobileElement> processLastUpdateDate;
    @AndroidFindBy(xpath = "//android.widget.TextView[1]")
    private MobileElement modifyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private MobileElement deleteButton;
    @AndroidFindBy(id = "history_process_item_detail_version")
    private List<MobileElement> historyProcessDetailVersion;
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private List<MobileElement> historyProcessdateVersion;
    @AndroidFindBy(id = "content")
    private List<MobileElement> processOptionsMenuItems;
    // Items in process options after taking the lead
    @AndroidFindBy(id = "title")
    private List<MobileElement> optionItems;


    public MobileElement getDropDownSelector() {
        return dropDownSelector;
    }

    public MobileElement getDropDownSelectorFirstItem() {
        return dropDownSelectorFirstItem;
    }

    // text area wdiget
    @AndroidFindBy(id = "my_business_widget_content_input_field_edit_text")
    private List<MobileElement> textArea;
    @AndroidFindBy(id = "activity_my_business_options_repeat_toggle")
    private MobileElement repeatProcessOptionSwitcher;

    public MyBusinessScreen(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getOldRecipientsViewFromMbContactPicker() {
        return oldRecipientsViewFromMbContactPicker;
    }

    public MobileElement getSaveBtnFromMbContactPicker() {
        return saveBtnFromMbContactPicker;
    }

    public MobileElement getProcessNamTextFieldWithoutEdit() {
        return processNamTextFieldWithoutEdit;
    }

    public MobileElement getProcessNamTextFieldWithEdit() {
        return processNamTextFieldWithEdit;
    }

    public MobileElement getSearchBtnFromMbContactPicker() {
        return searchBtnFromMbContactPicker;
    }

    public MobileElement getContactsLabelFromMbContactPicker() {
        return contactsLabelFromMbContactPicker;
    }

    public MobileElement getContactsfilterFromMbContactPicker() {
        return contactsfilterFromMbContactPicker;
    }

    public MobileElement getRepeatProcessOptionSwitcher() {
        return repeatProcessOptionSwitcher;
    }

    public MobileElement getAllLabelFromMbContactPicker() {
        return allLabelFromMbContactPicker;
    }

    public MobileElement getIndividualLabelFromMbContactPicker() {
        return individualLabelFromMbContactPicker;
    }

    public MobileElement getGroupLabelFromMbContactPicker() {
        return groupLabelFromMbContactPicker;
    }

    public List<MobileElement> getTextArea() {
        return textArea;
    }

    public List<MobileElement> getOptionItems() {
        return optionItems;
    }

    public List<MobileElement> getProcessOptionsMenuItems() {
        return processOptionsMenuItems;
    }

    public List<MobileElement> getHistoryProcessDetailVersion() {
        return historyProcessDetailVersion;
    }

    public List<MobileElement> getHistoryProcessdateVersion() {
        return historyProcessdateVersion;
    }

    public List<MobileElement> getProcessOptionsSwitchers() {
        return processOptionsSwitchers;
    }

    public List<MobileElement> getProcessStatus() {
        return processStatus;
    }

    public List<MobileElement> getProcessSenderName() {
        return processSenderName;
    }

    public List<MobileElement> getProcessLastUpdateDate() {
        return processLastUpdateDate;
    }


    public MobileElement getConfirmBtn() {
        return confirmBtn;
    }

    public MobileElement getCancelBtn() {
        return cancelBtn;
    }

    public List<MobileElement> getProcessCellInAnycategorie() {
        return processCellInAnycategorie;
    }

    public MobileElement getDeleteButton() {
        return deleteButton;
    }

    public MobileElement getModifyButton() {
        return modifyButton;
    }

    public MobileElement getPreviewElement() {
        return previewElement;
    }

    public List<MobileElement> getPreviewRows() {
        return previewRows;
    }

    public MobileElement getWidgetCurrency() {
        return widgetCurrency;
    }

    public MobileElement getWidgetNumber() {
        return widgetNumber;
    }

    public List<MobileElement> getRowTable() {
        return rowTable;
    }

    public List<MobileElement> getFirstSearchedProcess() {
        return firstSearchedProcess;
    }

    public MobileElement getSortAlpha() {
        return sortAlpha;
    }

    public MobileElement getSortByPriority() {
        return sortByPriority;
    }

    public MobileElement getSortByStartDate() {
        return sortByStartDate;
    }

    public MobileElement getSortByDueDate() {
        return sortByDueDate;
    }

    public MobileElement getSortByReceptionDate() {
        return sortByReceptionDate;
    }

    public MobileElement getSortByCategory() {
        return sortByCategory;
    }

    public MobileElement getFilterByDate() {
        return filterByDate;
    }

    public MobileElement getStartDate() {
        return startDate;
    }

    public MobileElement getDueDate() {
        return dueDate;
    }

    public MobileElement getHighPriorityFilter() {
        return highPriorityFilter;
    }

    public MobileElement getFilterByPriority() {
        return filterByPriority;
    }

    public MobileElement getMediumPriorityFilter() {
        return mediumPriorityFilter;
    }

    public MobileElement getLowPriorityFilter() {
        return lowPriorityFilter;
    }

    public MobileElement getFilterByCategory() {
        return filterByCategory;
    }

    public List<MobileElement> getCategoryFilter() {
        return categoryFilter;
    }

    public MobileElement getiOSFilter() {
        return iOSFilter;
    }

    public MobileElement getGeneralFilter() {
        return generalFilter;
    }

    public List<MobileElement> getExpandButton() {
        return ExpandButton;
    }

    public List<MobileElement> getProcessCategorie() {
        return processCategorie;
    }

    public MobileElement getSubmitProcess() {
        return submitProcess;
    }

    public MobileElement getConfirmDeleteAllProcessesButton() {
        return confirmDeleteAllProcessesButton;
    }

    public MobileElement getStartedByFilter() {
        return startedByFilter;
    }

    public MobileElement getOwnerFilter() {
        return OwnerFilter;
    }

    public MobileElement getApplyFilter() {
        return applyFilter;
    }

    public MobileElement getProcessTitle() {
        return processTitle;
    }

    public List<MobileElement> getCategorySortButton() {
        return categorySortButton;
    }

    public List<MobileElement> getCategoryOptionButton() {
        return categoryOptionButton;
    }

    public MobileElement getSearchBarBtn() {
        return searchBarBtn;
    }

    public MobileElement getSearchBarContent() {
        return searchBarContent;
    }

    public MobileElement getOperationalStatusBtn() {
        return operationalStatusBtn;
    }

    public MobileElement getStepRecipientsBtn() {
        return stepRecipientsBtn;
    }

    public MobileElement getThreeDotsMenuProcess() {
        return threeDotsMenuProcess;
    }

    public MobileElement getChatWithRecipients() {
        return chatWithRecipients;
    }

    public MobileElement getProcessHistory() {
        return processHistory;
    }

    public MobileElement getDuplicateProcess() {
        return duplicateProcess;
    }

    public MobileElement getConferenceCall() {
        return conferenceCall;
    }

    public MobileElement getBackBtn() {
        return backBtn;
    }

    public MobileElement getFilterByName() {
        return filterByName;
    }

    public MobileElement getShowResultButton() {
        return showResultButton;
    }

    public MobileElement getCollapseCategoryButton() {
        return collapseCategoryButton;
    }

    public MobileElement getReadAllNotificationButton() {
        return readAllNotificationButton;
    }

    public MobileElement getDeleteAllProcessButton() {
        return deleteAllProcessButton;
    }

    public MobileElement getForwardByApp() {
        return forwardByApp;
    }

    public MobileElement getForwardByMail() {
        return forwardByMail;
    }

    public MobileElement getActivityItem() {
        return activityItem;
    }

    public MobileElement getStartItem() {
        return startItem;
    }

    public MobileElement getSubmittedCategory() {
        return submittedCategory;
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

    public MobileElement getReceiverFilter() {
        return ReceiverFilter;
    }

    public List<AndroidElement> getSendProcess() {
        return sendProcess;
    }

    public List<AndroidElement> getCompleteProcess() {
        return CompleteProcess;
    }

    public MobileElement getCollapseBtn() {
        return CollapseBtn;
    }

    public MobileElement getProcessOptions() {
        return processOptions;
    }

    public MobileElement getSaveProcess() {
        return saveProcess;
    }

    public MobileElement getForwardProcess() {
        return forwardProcess;
    }

    public MobileElement getSearch() {
        return search;
    }

    public List<AndroidElement> getActivityFloatingAction() {
        return activityFloatingAction;
    }

    public MobileElement getContactSelectionFloating() {
        return contactSelectionFloating;
    }

    public MobileElement getSearchContent() {
        return searchContent;
    }

    public MobileElement getCheckSelectedContact() {
        return checkSelectedContact;
    }

    public MobileElement getSearchClearContent() {
        return searchClearContent;
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

    public MobileElement getCompletedCategory() {
        return completedCategory;
    }

    public MobileElement getTakeTheleadBtn() {
        return takeTheleadBtn;
    }

    public MobileElement getCanceledCategory() {
        return canceledCategory;
    }

    public MobileElement getThreeDots() {
        return threeDots;
    }

    public MobileElement getDatePickerHeader() {
        return datePickerHeader;
    }

    public List<MobileElement> getDateAndTime() {
        return dateAndTime;
    }

    public List<MobileElement> getDatePickerInfo() {
        return datePickerInfo;
    }

    public List<MobileElement> getDatePickerIcon() {
        return datePickerIcon;
    }

    public List<MobileElement> getProcessOptionsItems() {
        return processOptionsItems;
    }

    public List<MobileElement> getmBCategoryName() {
        return mBCategoryName;
    }


    public void verifyToastOfMultipleMandatoryFieldsisDisplyed() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        assertNotNull(wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.xpath("//android.widget.Toast[contains(@text, 'Please fill the 3 mandatory fields highlighted in red')]"))));

    }

    public void verifyToastOfOneMandatoryFieldisDisplyed() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        assertNotNull(wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.xpath("//android.widget.Toast[contains(@text, 'Please fill the mandatory field Adresse e-mail')]"))));

    }
    public void modifyProcessName(String newProcessName){

        processNamTextFieldWithEdit.sendKeys(newProcessName);

    }

    public void deleteAllProcessesInInCancelledCategory() throws InterruptedException, MalformedURLException {
        if (isElementDisplayed(getmBCategoryName().get(5)) && !getmBCategoryName().get(5).getAttribute("name").equals("CANCELED (0)")) {


            getCategoryOptionButton().get(5).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(2000);

            //ElementToClick("DELETE",0,0).click();
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void ClickOnchatWithRecipients() throws InterruptedException {
        getChatWithRecipients().click();
        Thread.sleep(3000);

    }

    public void checkThatTheDiscussionNameIsSimilarTheProcessName(String processName) {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);
        Assert.assertEquals(processName, conversationScreen.getRecipientName().getText(), "process name and discussion name are not identical");
    }


    public void clickOnRecipientName() {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.getRecipientName().click();

    }

    public void deleteThreadProcess() throws InterruptedException {
        ConversationScreen conversationScreen = new ConversationScreen(mDriver);

        conversationScreen.longPressOnElementPosition(conversationScreen.getConversation_thread());
        Thread.sleep(3000);
        conversationScreen.getDeleteConversation().click();
        conversationScreen.getOk_Item().click();
    }

    public void deleteAllProcessesInNewCategory() throws InterruptedException, MalformedURLException {
        if (isElementDisplayed(getmBCategoryName().get(0)) && !getmBCategoryName().get(0).getAttribute("name").equals("NEW (0)")) {
            getCategoryOptionButton().get(0).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(1000);
            //clickOnElementByString("Delete");
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void deleteAllProcessesInDraftCategory() throws MalformedURLException, InterruptedException {
        if (isElementDisplayed(getmBCategoryName().get(1)) && !getmBCategoryName().get(1).getAttribute("name").equals("DRAFT (0)")) {
            getCategoryOptionButton().get(1).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(1000);

            //clickOnElementByString("Delete");
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void deleteAllProcessesInProgressCategory() throws InterruptedException, MalformedURLException {
        if (isElementDisplayed(getmBCategoryName().get(2)) && !getmBCategoryName().get(2).getAttribute("name").equals("IN PROGRESS (0)")) {
            getCategoryOptionButton().get(2).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(1000);

            //clickOnElementByString("Delete");
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void deleteAllProcessesInSubmittedCategory() throws InterruptedException, MalformedURLException {
        if (isElementDisplayed(getmBCategoryName().get(3)) && !getmBCategoryName().get(3).getAttribute("name").equals("SUBMITTED (0)")) {
            getCategoryOptionButton().get(3).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(1000);

            //clickOnElementByString("Delete");
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void deleteAllProcessesInCompletedCategory() throws MalformedURLException, InterruptedException {
        if (isElementDisplayed(getmBCategoryName().get(4)) && !getmBCategoryName().get(4).getAttribute("name").equals("COMPLETED (0)")) {
            getCategoryOptionButton().get(4).click();
            Thread.sleep(1000);

            ElementToClick("Delete All Processes", 0, 0).click();
            Thread.sleep(1000);

            //clickOnElementByString("Delete");
            getConfirmDeleteAllProcessesButton().click();
        }
    }

    public void deleteAllprocessesInAllCategories() throws MalformedURLException, InterruptedException {
        Thread.sleep(500);
        deleteAllProcessesInInCancelledCategory();
        deleteAllProcessesInNewCategory();
        deleteAllProcessesInDraftCategory();
        deleteAllProcessesInProgressCategory();
        deleteAllProcessesInSubmittedCategory();
        deleteAllProcessesInCompletedCategory();
    }

    public void openMybusiness() throws InterruptedException {

        TabBarScreen tabBarScreen = new TabBarScreen(mDriver);
        Thread.sleep(500);

        tabBarScreen.getMyBusinessItem();
    }

    public void clickOnStart() throws InterruptedException {
        Thread.sleep(500);

        getStartItem().click();

    }

    public void clickOnActivity() {
        getActivityItem().click();

    }

    public void searchProcessinStartTab(String processName) {
        getSearchBarBtn().click();
        getSearchBarContent().clear();
        getSearchBarContent().sendKeys(processName);
    }

    public void checkMybusinessPositionInTabBar() {
        Boolean iselementpresent = getActivityItem().isDisplayed();
        AssertJUnit.assertTrue("Targeted element App is not present on screen.", iselementpresent);
    }

    public void clickOnSearchResultInStartTab() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);

        getFirstSearchedProcess().get(0).click();
    }

    public void clickOnProcessFloatingActions() {
        getActivityFloatingAction().get(1).click();

    }

    public void sendProcess() throws InterruptedException {
        Thread.sleep(500);
        clickOnProcessFloatingActions();
        Thread.sleep(500);
        getSendProcess().get(1).click();
    }


    public boolean verifyPreviousRecipientsIsDisplayed() {
        boolean check = isElementDisplayed(getOldRecipientsViewFromMbContactPicker());
        mLogger.log(Status.PASS, "The previous contacts are still selected");
        return check;
    }

    public void searchContactToSubmit(String contact) throws InterruptedException {
        if (verifyPreviousRecipientsIsDisplayed() == false) {
            getSearch().click();
            getSearchContent().sendKeys(contact);
            Thread.sleep(1000);
        }
    }

    public void searchContactsToSubmit(String contact, String contact2) throws InterruptedException {
        getSearch().click();
        getSearchContent().sendKeys(contact);
        selectContactTosubmit();
        getSearchContent().sendKeys("");
        getSearchContent().sendKeys(contact2);
        selectContactTosubmit();
        Thread.sleep(1000);
    }

    public void searchGroupToSubmit(String group) throws InterruptedException {
        getSearch().click();
        getSearchContent().sendKeys(group);
        Thread.sleep(1000);

    }

    public void selectContactTosubmit() throws InterruptedException {

        if (verifyPreviousRecipientsIsDisplayed() == false) {
            Thread.sleep(100);
            getCheckSelectedContact().click();
        }
    }

    public void selectGroupToSubmit() {
        getCheckSelectedContact().click();
    }

    public void selectContactAndSubmit() {
        if (verifyPreviousRecipientsIsDisplayed() == false) {
            getCheckSelectedContact().click();
        }
        getContactSelectionFloating().click();


    }


    public void submitProcess() {
        getContactSelectionFloating().click();


    }

    public void checkIfProcessDetailsAreDisplayedInAnyCategory(String processName) throws InterruptedException, IOException {
        Thread.sleep(1300);
        Boolean elementPresent = getProcessTitle().getAttribute("name").equalsIgnoreCase(processName);

        CheckDisplayedOfElement(getProcessTitle(),"process title");
        CheckDisplayedOfElement(getProcessStatus().get(0),"process Status");
        CheckDisplayedOfElement(getProcessSenderName().get(0),"Process Sender Name");
        CheckDisplayedOfElement(getProcessLastUpdateDate().get(0),"process last update date");

        Assert.assertTrue(elementPresent,"Targeted element App is not present on screen." );
    }

    public void expandNewCategory() throws InterruptedException {
        Thread.sleep(1000);
        getExpandButton().get(0).click();

    }

    public void expandDraftCategory() {
        getExpandButton().get(1).click();

    }

    public void expandInProgressCategory() throws InterruptedException {
        Thread.sleep(1000);
        getExpandButton().get(2).click();

    }

    public void expandSubmittedCategory() {
        getExpandButton().get(3).click();

    }

    public void collapseSubmittedCategory() {
        getExpandButton().get(3).click();

    }

    public void expandCompletedCategory() {
        getExpandButton().get(4).click();

    }

    public void expandCanceledCategory() {
        getExpandButton().get(5).click();

    }

    public void checkNewCategoryIsDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(getmBCategoryName().get(0),"New category");

    }

    public void checkDraftCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getmBCategoryName().get(1),"draft category");
    }

    public void checkInProgressCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getmBCategoryName().get(2),"In progress category");
    }

    public void checkSubmittedCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getmBCategoryName().get(3),"submitted category");
    }

    public void checkCompletedCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getmBCategoryName().get(4),"completed category");
    }

    public void checkCanceledCategoryIsDisplayed() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getmBCategoryName().get(5),"cancelled category");
    }

    public void checkProcessSearchResultInStartTab() throws IOException, InterruptedException {
        CheckDisplayedOfElement(getFirstSearchedProcess().get(0),"process  ");
        CheckDisplayedOfElement(getmBCategoryName().get(0),"process category");


    }

    public void openTheFirstRecievedProcessInNewCategory() {
        getProcessCellInAnycategorie().get(0).click();
    }

    public void openTheFirstRecievedProcessInSubmittedCategory() {
        getProcessCellInAnycategorie().get(0).click();
    }

    public void clickBack() throws InterruptedException {
        Thread.sleep(1000);
        getBackBtn().click();

    }

    public void verifyTheDisplayOfFirstProcessInCancelCategory() throws InterruptedException {
        Thread.sleep(1000);
        if (isElementDisplayed(getProcessCellInAnycategorie().get(0)))
            mLogger.log(Status.PASS, " The process is displayed in Cancel category");
    }

    public void verifyDisplayOfFirstProcessInDraftCategory(String processName) throws InterruptedException, IOException {
        Thread.sleep(1000);
        if (isElementDisplayed(getProcessCellInAnycategorie().get(0)))
            mLogger.log(Status.PASS, " The process is displayed in Draftcategory");
        checkIfElementIsPresent(getProcessTitle(),"process title");
        Boolean elementPresent = getProcessTitle().getAttribute("name").equalsIgnoreCase(processName);
        checkIfElementIsPresent(getProcessStatus().get(0),"");
        checkIfElementIsPresent(getProcessSenderName().get(0),"");
        checkIfElementIsPresent(getProcessLastUpdateDate().get(0),"");

    }

    public void recieveProcessInNewCateogry(String processName, String contact) throws MalformedURLException, InterruptedException {


        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnSearchResultInStartTab();

        sendProcess();
        searchContactToSubmit(contact);
        selectContactAndSubmit();
        Thread.sleep(2000);
    }

    public void recieveProcessInsubmittedCateogry(String processName, String contact2) throws MalformedURLException, InterruptedException {


        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnSearchResultInStartTab();

        sendProcess();
        searchContactToSubmit(contact2);
        selectContactAndSubmit();
        Thread.sleep(2000);
    }

    public void recieveProcessIncompletedCateogry(String processName, String contact) throws MalformedURLException, InterruptedException {


        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnSearchResultInStartTab();

        completeProcess();
        searchContactToSubmit(contact);
        selectContactAndSubmit();
        confirmBtn();
        Thread.sleep(2000);
    }

    public void takeTheLead() {
        getTakeTheleadBtn().click();
        getConfirmBtn().click();
    }

    public void confirmBtn() {
        getConfirmBtn().click();

    }


    public void clickOnThreeDotsMenuOfProcess() throws InterruptedException {
        Thread.sleep(1000);
        getThreeDotsMenuProcess().click();
    }

    public void verifyDuplicateBtnIsNotDisplayed() {
        boolean isNotDisplayed = isElementDisplayed(getDuplicateProcess()) == false;

        Assert.assertTrue(isNotDisplayed, "error :duplicate option is displayed");
    }

    public void verifyDuplicateBtnIsDisplayed() {
        boolean isDisplayed = isElementDisplayed(getDuplicateProcess()) == true;

        Assert.assertTrue(isDisplayed, "error :duplicate option is displayed");
    }

    public void openTheFirstRecievedProcessInProgressCategory() {
        getProcessCellInAnycategorie().get(0).click();

    }

    public void openTheFirstRecievedProcessInCompletedCategory() {
        getProcessCellInAnycategorie().get(0).click();

    }

    public void goToProcessOptions() throws InterruptedException {
        Thread.sleep(1000);
        getThreeDots().click();
        getProcessOptions().click();

    }

    public void OpenProcessHistoryDetails() throws InterruptedException {
        Thread.sleep(200);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        getThreeDotsMenuProcess().click();
        wait.until(ExpectedConditions.visibilityOf( getProcessOptionsMenuItems().get(2)));
        getProcessOptionsMenuItems().get(2).click();

    }

    public void goToSaveProcess() throws InterruptedException {
        Thread.sleep(1000);
        getThreeDots().click();
        getSaveProcess().click();

    }

    public void verifyDisplayOfProcessOption(int i) {

        if ((isElementDisplayed(getProcessOptionsItems().get(i))) && (isElementDisplayed(getProcessOptionsSwitchers().get(i)))) {
            mLogger.log(Status.PASS, " schedule is displayed");
        } else Assert.fail("Schedule is not displayed");

    }

    public void activateProcessOption(int j) throws InterruptedException {
        Thread.sleep(300);
        getProcessOptionsSwitchers().get(j).click();


    }

    public void verifyProcessNameIsNotEnabled() {

        boolean IsNotEnabled = isElementDisplayed(getProcessNamTextFieldWithEdit()) == false && isElementDisplayed(getProcessNamTextFieldWithoutEdit()) == true;
        Assert.assertTrue(IsNotEnabled, "error : process name is  editable");

    }

    public void activateRepeatProcessOption() throws InterruptedException {
        Thread.sleep(600);
        getRepeatProcessOptionSwitcher().click();
    }

    public void verifyDisplayOfdetailsInSchedule() throws InterruptedException {

        Thread.sleep(1000);
        if (isElementDisplayed(getDatePickerInfo().get(0)))
            mLogger.log(Status.PASS, "status is displayed");
        else {
            mLogger.log(Status.PASS, "status is not  displayed");

        }

        if (isElementDisplayed(getDatePickerIcon().get(0)))
            mLogger.log(Status.PASS, "Date picker icon is displayed");
        else {
            mLogger.log(Status.PASS, "Date picker icon is not  displayed");

        }

        if (isElementDisplayed(getDateAndTime().get(0)))
            mLogger.log(Status.PASS, "date and time are displayed");
        else {
            mLogger.log(Status.PASS, "date and time are not  displayed");

        }
    }

    public void verifyProcessHistoryButtonisNotDisplayed() throws IOException, InterruptedException {

        CheckElementIsNotDisplayed(processHistory,"process history button is not displayed");


    }

    public void verifyProcessHistoryButtonisDisplayed() throws IOException, InterruptedException {

        CheckDisplayedOfElement(processHistory,"process history button");



    }

    public void searchProcessInStartAndOpenIt(String processName) throws InterruptedException {
        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnSearchResultInStartTab();
    }

    public void completeProcess() throws InterruptedException {
        clickOnProcessFloatingActions();
        Thread.sleep(1000);
        getCompleteProcess().get(0).click();
    }

    public void verifyDisplayOfCalender() throws InterruptedException {

        Thread.sleep(1000);

        getDatePickerIcon().get(0).click();

        if (isElementDisplayed(getDatePickerHeader()))

            mLogger.log(Status.PASS, "Calender is displayed");
        else {
            mLogger.log(Status.FAIL, "Calender is not displayed");

        }
    }

    public void openHistoryOfProcess() throws InterruptedException {
        Thread.sleep(200);
        getThreeDotsMenuProcess().click();
        getProcessOptionsMenuItems().get(1).click();
    }

    public void verifyDisplayOfStopRepeatingOption() throws InterruptedException {
        Thread.sleep(200);
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        getThreeDotsMenuProcess().click();
        wait.until(ExpectedConditions.visibilityOf( getProcessOptionsMenuItems().get(4)));

        if ((isElementDisplayed(getProcessOptionsMenuItems().get(4)))) {
            mLogger.log(Status.PASS, " Stop repeating is displayed");
        } else Assert.fail("Stop repeating is not displayed");


    }

    public void verifyProcessHistory() {

        if (isElementDisplayed(getHistoryProcessDetailVersion().get(0)) && isElementDisplayed(getHistoryProcessdateVersion().get(0))) {
            mLogger.log(Status.PASS, "version details  is displayed");
        } else Assert.fail("version details  is not displayed");
    }

    public void clickOnBackButtonAndConfirm() throws InterruptedException {
        Thread.sleep(1000);
        getBackBtn().click();
        getConfirmBtn().click();
    }

    public void clickOnBackButtonAndClickOnNo() throws InterruptedException {
        Thread.sleep(1000);
        getBackBtn().click();
        getCancelBtn().click();
    }

    public void clickOnBackButton() throws InterruptedException {
        Thread.sleep(1000);
        getBackBtn().click();

    }

    public void cancelProcess() throws InterruptedException {
        getThreeDots().click();
        Thread.sleep(1000);
        getOptionItems().get(4).click();
        getConfirmBtn().click();


    }

    public void fillTextAreaWidget() throws InterruptedException {
        Thread.sleep(1000);
        getTextArea().get(0).click();
        getTextArea().get(0).sendKeys("testing ");
    }

    public void verifyDisplayOfStartScreen() {

        if ((isElementDisplayed(getStartItem())))
             mLogger.log(Status.PASS, " Start menu is displayed");

    }

    public void verifyMbContactPickerBarElementsisDisplayed() throws InterruptedException {

        if (isElementDisplayed(getBackBtn()) && isElementDisplayed(getSearchBtnFromMbContactPicker()) && isElementDisplayed(getContactsLabelFromMbContactPicker()) && isElementDisplayed(getSaveBtnFromMbContactPicker()) && isElementDisplayed(getContactsfilterFromMbContactPicker()))
            mLogger.log(Status.PASS, "- On top: Back button + title: \"Contacts\" + Search icon + individual/group filter + Save icon" +
                    " -Middle: Contacts in multiselection mode");
        if (!isElementDisplayed(getSubmitProcess()))
            mLogger.log(Status.PASS, "At the bottom, on the right: Submit validation icon, by default the Submit icon is inactive");

        Thread.sleep(1000);
    }

    public void checkIfWaitingToBeSubmittedisDisplayed() {


    }

    public void initiateProcessFromStartTab(String processName) throws InterruptedException {
        clickOnStart();
        searchProcessinStartTab(processName);
        clickOnSearchResultInStartTab();
    }

    public void selectOptionFromDropDownWidget() {
        //dorpdown have 3 options [3 2 1]
        getDropDownSelector().click();
        //select option "3"
        getDropDownSelectorFirstItem().click();

    }

    public void verifyPreviousProcessData() {

        boolean previousProcessDataisFilled = getTextArea().get(0).getText().isEmpty() == false && getTextArea().get(0).getAttribute("text").equalsIgnoreCase("Test");
        Assert.assertTrue(previousProcessDataisFilled, "the previous data of the process is not loaded");
    }

}

