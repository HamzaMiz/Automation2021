package framework.screen;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableList;
import framework.Platforms;
import framework.Utility;
import framework.utils.ImageResizer;
import framework.utils.extentReports.ExtentTestManager;
import io.appium.java_client.*;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class STWScreen {


   public  String mPlatform;
    public  String branding=  Utility.mBranding;
    public  AppiumDriver mDriver;
    public ExtentTest mLogger;



    private static final int TIMEOUT = 10;



    public STWScreen(AppiumDriver driver) {

        if (driver == null) {
            System.out.println(" driver is null");
        }

        this.mDriver = driver;
        if (driver instanceof AndroidDriver) {
            mPlatform = Platforms.ANDROID;
        } else {
            mPlatform = Platforms.IOS;
        }

        // PageFactory.initElements(new AppiumFieldDecorator(this.mDriver), this);

        PageFactory.initElements((FieldDecorator) (new AppiumFieldDecorator((SearchContext) mDriver)), this);
        this.mLogger= ExtentTestManager.getTest();




    }



    /**
     * method to go back by Android Native back click
     */
    public void back() {
        if (Platforms.ANDROID.equals(mPlatform)) {
            ((AndroidDriver) mDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        } else
            mDriver.navigate().back();
    }

    public void startActivity(String Package, String Activity) {
        ((AndroidDriver) mDriver).startActivity(new Activity(Package, Activity));
    }

    /**
     * method to hide keyboard
     */
    public void hideKeyboard() {
        ((AppiumDriver) mDriver).hideKeyboard();
    }

    public void hideKeyboardIos() throws InterruptedException {
        if (mPlatform.equals(Platforms.IOS)){
        try {
            ClickOnbuttonWithString("Search");

        } catch (NoSuchElementException e) {
            ClickOnbuttonWithStringWithXpath("Search");

        }}
    }

    public void hideKeyboardWithDone() {
        try {
            ClickOnbuttonWithStringWithXpath("Done");
        } catch (NoSuchElementException | InterruptedException e) {
            ClickOnbuttonWithString("Done");

        }
    }
    public void hideKeyboardWithNext() throws InterruptedException {

        MobileElement el1 = (MobileElement) mDriver.findElementByAccessibilityId("Next:");
        el1.click();


    }

    public void hideKeyboardWithReturn() throws InterruptedException {
        try {
            ClickOnbuttonWithString("return");

        } catch (NoSuchElementException ex ) {
            ClickOnbuttonWithStringWithXpath("return");

        }
    }

    /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(double xPosition, double yPosition) {
        JavascriptExecutor js = mDriver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }


    /**
     * method to swipe on the element on provided coordinates
     *
     * @param direction direction of swipe
     * @param element   element to swipe on
     */
    public void swipe(Object element, String direction) {
        JavascriptExecutor js = mDriver;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("direction", direction);

        params.put("element", element);
        js.executeScript("mobile: swipe", params);
    }
    public void swipeWithDuration(Object element, Object direction,Double duration) {
        JavascriptExecutor js = mDriver;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("direction", direction);
        params.put("duration", duration);

        params.put("element", element);
        js.executeScript("mobile: swipe", params);
    }


    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText() {
        try {
            Alert alert = mDriver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }

    /* *
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false*/
    public boolean isAlertPresent() {
        try {
            // WebDriverWait wait = new WebDriverWait(mDriver, TIMEOUT);
            // wait.until(ExpectedConditions.alertIsPresent());
            mDriver.switchTo().alert();
            return true;
        } catch (Exception e) {
            // throw e;
            return false;
        }
    }

    /**
     * method to Accept Alert if alert is present
     */
    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(mDriver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        mDriver.switchTo().alert().accept();
    }


    /**
     * method to Dismiss Alert if alert is present
     */

    public void dismissAlert() {
         // WebDriverWait wait = new WebDriverWait(mDriver, TIMEOUT);
       //  wait.until(ExpectedConditions.alertIsPresent());
        if (isAlertPresent())
            mDriver.switchTo().alert().dismiss();
    }

    /**
     * method to get network settings
     */
    public void getNetworkConnection() {
        if (Platforms.ANDROID.equals(mPlatform)) {
            System.out.println(((AndroidDriver) mDriver).getConnection());
        }
    }


    /**
     * method to set network settings
     *
     * @param airplaneMode pass true to activate airplane mode else false
     * @param wifi         pass true to activate wifi mode else false
     * @param data         pass true to activate data mode else false
     */
    public void setNetworkConnection(boolean airplaneMode, boolean wifi, boolean data) {

        if (Platforms.ANDROID.equals(mPlatform)) {
            long mode = 1L;

            if (wifi) {
                mode = 2L;
            } else if (data) {
                mode = 4L;
            }

            ConnectionState connectionState = new ConnectionState(mode);
            ((AndroidDriver) mDriver).setConnection(connectionState);
            System.out.println("Your current connection settings are :" + ((AndroidDriver) mDriver).getConnection());
        }
    }

    public void disableWifiAndData(){

        ((AndroidDriver)mDriver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());

    }

    public void enableWifiAndData(){

        ((AndroidDriver)mDriver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());

    }


    public void setAndroidDeviceAirplaneMode(boolean status) {

        try {

            String airplaneModeStatus = "";

            if (status) {

                airplaneModeStatus = "1";

            } else {

                airplaneModeStatus = "0";

            }

            String sdkPath = System. getenv ("ANDROID_HOME") + "/platform-tools/";

            Runtime. getRuntime ().exec(sdkPath + "adb shell settings put global airplane_mode_on " + airplaneModeStatus);

            Thread. sleep (1000);

            Process process = Runtime. getRuntime ()

                    .exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");

            process.waitFor();

            Thread. sleep (4000);

            if (status) {

                mLogger.info("Android device Airplane mode status is set to ON");

            } else {

                mLogger.info("Android device Airplane mode status is set to OFF");

            }

        } catch (Exception e) {

            System. out .println(e.getMessage());

            mLogger.fail("Unable to set android device Airplane mode.");

        }

    }

    public void disableBluetooth() throws IOException {
        String commandString = "adb shell settings put global bluetooth_on 0";
        Runtime.getRuntime().exec(commandString);

    }

    public void enableBluetooth() throws IOException {
        String commandString = "adb shell settings put global bluetooth_on 1";
        Runtime.getRuntime().exec(commandString);

    }

    public void setwifiConnectionForIos() {
        openApp("com.apple.Preferences");

        mDriver.findElement(By.id("Wi-Fi")).click();
        mDriver.findElement(By.xpath("//XCUIElementTypeSwitch[@name=\"Wi-Fi\"]")).click();
    }

    public void enableAnddisableAirplanemode() {
        openApp("com.apple.Preferences");

        mDriver.findElement(By.xpath("//XCUIElementTypeSwitch[@name=\"Airplane Mode\"]")).click();
    }
    public void setNetworkConnectionForIos(boolean airplaneMode, boolean wifi, boolean data) {

        long mode = 1L;

            if (wifi) {
                mode = 2L;
            } else if (data) {
                mode = 4L;
            }

            ConnectionState connectionState = new ConnectionState(mode);
        connectionState.isWiFiEnabled();
            System.out.println("Your current connection settings are :" + ((AndroidDriver) mDriver).getConnection());
    }

    public void openApp(String bundleID) {
        JavascriptExecutor js = (JavascriptExecutor) mDriver;
        HashMap<String, String>
                swipeObject = new HashMap<String, String>();
        swipeObject.put("bundleId", bundleID);
        js.executeScript("mobile: launchApp", swipeObject);

    }

    /**
     * method to add event in calender for the app ios
     *
     * @param title insert title of the event in calender
     */
    public void createEventInCalendarForIos(String title) {
        openApp("com.apple.mobilecal");
        mDriver.findElement(By.id("Add")).click();
        Actions a = new Actions(mDriver);
        a.sendKeys(title);
        a.perform();
        mDriver.findElement(By.id("Return")).click();
        mDriver.findElement(By.id("Add")).click();


    }

    public void createEventInCalendarForAndroid(String title) {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);

        startActivity("com.samsung.android.calendar","com.samsung.android.app.calendar.activity.MainActivity");

        wait.until(elementToBeClickable(By.id("com.samsung.android.calendar:id/floating_action_button")));
        mDriver.findElement(By.id("com.samsung.android.calendar:id/floating_action_button")).click();
        Actions a = new Actions(mDriver);
        a.sendKeys(title);
        a.perform();
        mDriver.findElement(By.id("com.samsung.android.calendar:id/add_app_bar_menu_done")).click();
    }

    public void tapOnElementCell(MobileElement element,double xPct, double yPct){

       // String selector = "type == 'XCUIElementTypeStaticText' AND name MATCHES[cd] 'ContactCell_name' AND label LIKE[cd] '" + contactName + "' " ;
       // MobileElement  element = (MobileElement) mDriver.findElement(MobileBy.iOSNsPredicateString(selector));
        Rectangle elRect = element.getRect();
        Point point = new Point(
                elRect.x + (int)(elRect.getWidth() * xPct),
                elRect.y + (int)(elRect.getHeight() * yPct)
        );

        // int x =elRect.x + (int)(elRect.getWidth() * xPct);
        //    int y = elRect.y + (int)(elRect.getHeight() * yPct);


        //action.tap(PointOption.point(point)).release().perform();

        new TouchAction(mDriver).tap(PointOption.point(point)).perform();

        //   new TouchAction(mDriver).press(PointOption.point(point)).perform();
        //   new TouchAction(mDriver).tap(PointOption.point(point)).perform();
    }
    public void tapOnElementPosition(MobileElement element,double xPct, double yPct){

        Rectangle elRect = element.getRect();
        Point point = new Point(
                elRect.x + (int)(elRect.getWidth() * xPct),
                elRect.y + (int)(elRect.getHeight() * yPct)
        );

       // int x =elRect.x + (int)(elRect.getWidth() * xPct);
            //    int y = elRect.y + (int)(elRect.getHeight() * yPct);


        //action.tap(PointOption.point(point)).release().perform();

        new TouchAction(mDriver).tap(PointOption.point(point)).perform();

        //   new TouchAction(mDriver).press(PointOption.point(point)).perform();
     //   new TouchAction(mDriver).tap(PointOption.point(point)).perform();
    }

    public void clickOnElementPositionForContactCell(MobileElement element,int a , int b) {


        Point point = element.getLocation();
        int x = point.x + a; // add number to x
        int y = point.y  - b;// add number to y

        new TouchAction(mDriver).tap(PointOption.point(x, y)).perform();


    }

    public void longPressOnElementButton(MobileElement element,double xPct, double yPct) {


        Rectangle elRect = element.getRect();
        Point point = new Point(
                elRect.x + (int)(elRect.getWidth() * xPct),
                elRect.y + (int)(elRect.getHeight() * yPct)
        );

        // int x =elRect.x + (int)(elRect.getWidth() * xPct);
        //    int y = elRect.y + (int)(elRect.getHeight() * yPct);


        //action.tap(PointOption.point(point)).release().perform();

        new TouchAction(mDriver).press(PointOption.point(point)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();;


    }

    public void longPressOnElementPosition(MobileElement element) {


        Point point = element.getLocation();
        int x = point.x + 11;
        int y = point.y + element.getSize().getHeight() - 7;
        new TouchAction(mDriver).longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(6000)))
                .perform();
    }
    protected void tapAtPoint(Point point) {
        AppiumDriver<MobileElement> d = mDriver;
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 0);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(200)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        d.perform(ImmutableList.of(tap));
    }

    public void tapElement(WebElement el) {
        tapElementAt(el, 0.5, 0.5);
    }

    protected void tapElementAt(WebElement el, double xPct, double yPct) {
        Rectangle elRect = el.getRect();
        Point point = new Point(
                elRect.x + (int)(elRect.getWidth() * xPct),
                elRect.y + (int)(elRect.getHeight() * yPct)
        );
        tapAtPoint(point);
    }


    public void ToClickFromChildClassbyXpath(String MainClass, String ChildClass, int indexNumber) {
        TouchAction action = new TouchAction(mDriver);
        WebElement parentElement = mDriver.findElementByClassName(MainClass);
        List<WebElement> childElements = parentElement.findElements(By.className(ChildClass));
        WebElement source = childElements.get(indexNumber);
        action.tap(tapOptions().withElement(element(source))).perform();
    }

    /**
     * method to get all the context handles at particular screen
     */
    public void getContext() {
        ((AppiumDriver) mDriver).getContextHandles();
    }

    public Boolean isElementExist(List<MobileElement> element , int elementSize) {

        int size = element.size();
        return (size > elementSize);
    }

    static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
    }

    /**
     * method to open notifications on Android
     */

    public void openNotifications() {
        ((AndroidDriver) mDriver).openNotifications();
    }

    /**
     * method to launchApp
     */

    public void launchApp() {
        ((AppiumDriver) mDriver).launchApp();
    }

    /**
     * method to scroll down on screen from java-client 6
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollDown(int swipeTimes, int durationForSwipe) {
        Dimension dimension = mDriver.manage().window().getSize();

        for (int i = 1; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.3);
            int end = (int) (dimension.getHeight() * 0.5);
            int x = (int) (dimension.getWidth() * 0.5);


            new TouchAction<>( mDriver).longPress(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    public WebElement scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }


    /**
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void holdAndScrollDown(int swipeTimes, int durationForSwipe, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = mDriver.manage().window().getSize();

        for (int i = 1; i <= swipeTimes; i++) {

            int anchor = (int) (size.width * anchorPercentage);
            int startPoint = (int) (size.height * startPercentage);
            int endPoint = (int) (size.height * endPercentage);

            new TouchAction<>(mDriver)
                    .longPress(PointOption.point(anchor, startPoint)).moveTo(PointOption.point(anchor, endPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();


        }
    }


    /**
     * method to scroll up on screen from java-client 6
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollUp(int swipeTimes, int durationForSwipe) {
        Dimension dimension = mDriver.manage().window().getSize();

        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.5);
            int end = (int) (dimension.getHeight() * 0.2);
            int x = (int) (dimension.getWidth() * 0.5);


            new TouchAction((AppiumDriver) mDriver).longPress(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    // Method to export use cases from Sanity.xls
    public static void GetUseCaseDescription(String UseCaseID, int FragmentNumber, ExtentTest mLogger) {
        //  Report.mLogger.log(Status.INFO, "Expected result: <br> ");

        try {
            // File f= new File("src/test/java");

// Specify the path of file
            File src = new File("SanityCheckList.xlsx");

            // load file
            FileInputStream fis = new FileInputStream(src);

            // Load workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // Load sheet- Here we are loading first sheetonly
            XSSFSheet sh1 = wb.getSheetAt(FragmentNumber);

// getRow() specify which row we want to read.

// and getCell() specify which column to read.
// getStringCellValue() specify that we are reading String data.

            int LastRowCount = sh1.getLastRowNum();

            for (int i = 0; i < LastRowCount; i++) {
                String TestId = sh1.getRow(i).getCell(1).getStringCellValue();

                if (TestId.equals(UseCaseID)) {
                    mLogger.log(Status.INFO, "Test case ID: <br> " + sh1.getRow(i).getCell(1).getStringCellValue() + "<br>");


                    mLogger.log(Status.INFO, "Preconditions:<br>  " + sh1.getRow(i).getCell(4).getStringCellValue() + "<br>");

                    mLogger.log(Status.INFO, "Steps: <br> " + sh1.getRow(i).getCell(5).getStringCellValue() + "<br>");

                    mLogger.log(Status.INFO, "Expected result: <br> " + sh1.getRow(i).getCell(6).getStringCellValue() + "<br>");

                }

            }


        } catch (Exception e) {

            System.out.println("Cannot create this " + e.getMessage());

        }

    }

    // Method to export use cases from NonRegression.xls
    public static void GetUseCaseDescriptionFromNonRegression(String UseCaseID, int FragmentNumber, ExtentTest mLogger) {
        //  Report.mLogger.log(Status.INFO, "Expected result: <br> ");

        try {
            // File f= new File("src/test/java");

// Specify the path of file
            File src = new File("NonRegression.xlsx");

            // load file
            FileInputStream fis = new FileInputStream(src);

            // Load workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // Load sheet- Here we are loading first sheetonly
            XSSFSheet sh1 = wb.getSheetAt(FragmentNumber);

// getRow() specify which row we want to read.

// and getCell() specify which column to read.
// getStringCellValue() specify that we are reading String data.

            int LastRowCount = sh1.getLastRowNum();

            for (int i = 0; i < LastRowCount; i++) {
                String TestId = sh1.getRow(i).getCell(1).getStringCellValue();

                if (TestId.equals(UseCaseID)) {
                    mLogger.log(Status.INFO, "Test case ID: <br> " + sh1.getRow(i).getCell(1).getStringCellValue() + "<br>");


                    mLogger.log(Status.INFO, "Preconditions:<br>  " + sh1.getRow(i).getCell(4).getStringCellValue() + "<br>");

                    mLogger.log(Status.INFO, "Steps: <br> " + sh1.getRow(i).getCell(5).getStringCellValue() + "<br>");

                    mLogger.log(Status.INFO, "Expected result: <br> " + sh1.getRow(i).getCell(6).getStringCellValue() + "<br>");

                }

            }


        } catch (Exception e) {

            System.out.println("Cannot create this " + e.getMessage());

        }

    }

    public final MobileElement ElementToClick(String StringToclick, int FirstInstance, int SecondInstance)
            throws MalformedURLException, InterruptedException {

        MobileElement ElementToClick = (MobileElement) mDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(" + FirstInstance + ")).scrollIntoView(new UiSelector().textContains(\""
                        + StringToclick + "\").instance(" + SecondInstance + "))"));

        return ElementToClick;
    }

    public final MobileElement clickOnElementByString(String StringToclick)
            throws MalformedURLException, InterruptedException {

        MobileElement ElementToClick = (MobileElement) mDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"" + StringToclick + "\")"));
        ElementToClick.click();

        return ElementToClick;
    }

    public void waitForElementToBeClickable(MobileElement element){

        WebDriverWait wait = new WebDriverWait(mDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void waitForElementToBeVisible(MobileElement element){

        WebDriverWait wait = new WebDriverWait(mDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void clickOnElement(MobileElement element)
            throws MalformedURLException, InterruptedException {

        element.click();

    }


    public final void ScrollToElementByText(String element) {
        RemoteWebElement parent = (RemoteWebElement) mDriver.findElement(By.className("XCUIElementTypeTable")

        ); //identifying the parent Table
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);

// Use the predicate that provides the value of the label attribute

        scrollObject.put("predicateString", "name CONTAINS '" + element + "' OR name == '" + element + "' OR label CONTAINS '" + element + "' OR value CONTAINS '"+ element +"'");
        mDriver.executeScript("mobile:scroll", scrollObject);  // scroll to the target element

    }

    public void scrollToMobileElement(String elementName, String direction) {

        final int maximumScrolls = 5;

        for (int i = 0; i < maximumScrolls; i++) {
            try {
                String selector = "type == 'XCUIElementTypeStaticText' AND value ENDSWITH[cd] '" + elementName + "'";
                String selector2="name CONTAINS[c] '" + elementName + "' OR name == '" + elementName + "' OR label CONTAINS[c] '" + elementName + "' OR value CONTAINS[c] '"+ elementName +"'";

                if (mDriver.findElements(MobileBy.iOSNsPredicateString(selector)).size() > 0)
                    // PredicateString & label is the locator strategy that I used. It can be changed to others as needed for your app.

                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            scroll(direction);
        }
    }
    private void scroll(String direction) {
        final HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        mDriver.executeScript("mobile:scroll", scrollObject);
    }

    public List<MobileElement> findElementsByPredicateString(String predicateString) {
        return mDriver.findElements(MobileBy.iOSNsPredicateString(predicateString));
    }

    public final void TapOnElementByText(MobileElement elementId) {
        JavascriptExecutor js = (JavascriptExecutor) mDriver;


        ; //identifying the parent Table

        HashMap<String, String> tapObject = new HashMap<String, String>();
      //  Point point = elementId.getLocation();
      //  int x = point.x + 80;
      //  int y = point.y + 15;

        tapObject.put("x", String.valueOf(elementId.getSize().getWidth()/2));
        tapObject.put("y", String.valueOf(elementId.getSize().getHeight()/2));

        tapObject.put("element", elementId.getId());

        // Use the predicate that provides the value of the label attribute

        js.executeScript("mobile:tap", tapObject);  // scroll to the target element

    }


    public static boolean isClickable(MobileElement element)
    {
        try
        {
            element.click();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public boolean isNotClickable(WebElement... elements) {
        List<WebElement> elementsChecked = new ArrayList<>();
        List<WebElement> elementsToCheckByClass = new ArrayList<>();
        List<WebElement> elementsToCheckByClick = new ArrayList<>();
        List<WebElement> elementsToCheckBySendKeys = new ArrayList<>();

        for (WebElement checkedElement : elements) {
            mLogger.info("Checking, that element [" + checkedElement + "] is not clickable by isEnabled()");
            if (checkedElement.isEnabled()) {
                elementsToCheckByClass.add(checkedElement);
            } else {
                elementsChecked.add(checkedElement);
            }
        }
        if (!elementsToCheckByClass.isEmpty()) {
            for (WebElement checkedByClassElement : elementsToCheckByClass) {
                mLogger.info("Checking, that element [" + checkedByClassElement + "] is not clickable by class");
                String classOfElement = checkedByClassElement.getAttribute("class");
                List<String> classes = new ArrayList<>(Arrays.asList(classOfElement.split(" ")));
                if (!classes.contains("select2-container-disabled")) {
                    elementsToCheckByClick.add(checkedByClassElement);
                } else {
                    elementsChecked.add(checkedByClassElement);
                }
            }
        }
        if (!elementsToCheckByClick.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(mDriver, 1);
            for (WebElement checkedByClickElement : elementsToCheckByClick) {
                mLogger.info("Checking, that element [" + checkedByClickElement + "] is not clickable by clicking it");
                try {
                    wait.until(elementToBeClickable(checkedByClickElement));
                    elementsToCheckBySendKeys.add(checkedByClickElement);
                } catch (Exception e) {
                    elementsChecked.add(checkedByClickElement);
                }
            }
        }
        if (!elementsToCheckBySendKeys.isEmpty()) {
            for (WebElement checkedBySendKeysElement : elementsToCheckBySendKeys) {
                mLogger.info("Checking, that element [" + checkedBySendKeysElement + "] is not clickable by sending keys");
                try {
                    checkedBySendKeysElement.sendKeys("checking");
                    return false;
                } catch (Exception e) {
                    elementsChecked.add(checkedBySendKeysElement);
                }
            }
        }
        return elementsChecked.size() == elements.length;
    }

    public final void selectorToClick(String SecondDevice) {
        String selector = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] '" + SecondDevice + "' AND visible == 1";
        WebDriverWait wait = new WebDriverWait(mDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(mDriver.findElement(MobileBy.iOSNsPredicateString(selector)))).click();
    }

    public final void TextToClick(String text) {
        String selector = "//*[starts-with(., '"+text+"') and contains(., '"+text+"')]";
        mDriver.findElement(MobileBy.xpath(selector)).click();
    }
    public final void clickOnCell(String contact) {
        String selector = "type == 'XCUIElementTypeCell' AND value BEGINSWITH[c] '" + contact + "'";
        mDriver.findElement(MobileBy.iOSNsPredicateString(selector)).click();
    }

    public final void ClickOnString(String name) {
        String selector = "type == 'XCUIElementTypeStaticText' AND label BEGINSWITH[cd] '" + name + "' ";
        mDriver.findElement(MobileBy.iOSNsPredicateString(selector)).click();
    }


    public final void ClickOnbuttonWithString(String buttonName) {

        String selector = "type == 'XCUIElementTypeButton' AND (name CONTAINS '" + buttonName + "' OR name == '" + buttonName + "' OR label == '" + buttonName + "' OR label CONTAINS '" + buttonName + "')  AND visible == 1";
        mDriver.findElement(MobileBy.iOSNsPredicateString(selector)).click();
    }

    public final void ClickOnbuttonWithStringWithXpath(String buttonName) throws InterruptedException {

        String selector = "//XCUIElementTypeButton[@name="+buttonName+"]";
        mDriver.findElement(MobileBy.xpath(selector)).click();
    }

    public final void ClickOnbuttonWithStringWithAccessibility(String buttonName) throws InterruptedException {

        String selector = ""+buttonName+"";
        mDriver.findElement(MobileBy.AccessibilityId(selector)).click();
    }

    public final void ContactNameToClick(String contactName) {
        String selector = "type == 'XCUIElementTypeStaticText' AND name LIKE[cd] 'ContactCell_name' AND label LIKE[cd] '" + contactName + "'";
        mDriver.findElement(MobileBy.iOSNsPredicateString(selector)).click();
    }

    public void LonPressOnString(String StringToclick, int FirstInstance, int SecondInstance)
            throws MalformedURLException, InterruptedException {

        MobileElement ElementToClick = (MobileElement) mDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(" + FirstInstance + ")).scrollIntoView(new UiSelector().textContains(\""
                        + StringToclick + "\").instance(" + SecondInstance + "))"));

        TouchAction t = new TouchAction(mDriver);
        t.longPress(element(ElementToClick)).release().perform();


    }

    public void LonPressOnElement(MobileElement ElementToClick)
            throws MalformedURLException, InterruptedException {


        TouchAction t = new TouchAction(mDriver);
        // t.longPress(element(ElementToClick)).release().perform();
        t.longPress(longPressOptions().withElement(element(ElementToClick)).withDuration(ofSeconds(8))).release().perform();

    }

    public void PressOnElement(String name) throws MalformedURLException, InterruptedException {

        String selector = "type == 'XCUIElementTypeButton' AND name LIKE[cd] '" + name + "' ";
        MobileElement element = (MobileElement) mDriver.findElement(MobileBy.iOSNsPredicateString(selector));


        tapOnElementPosition(element,0.5,0.5);

    }



    public  String getscreenshot() throws IOException, InterruptedException, MalformedURLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date = new Date();
        String fileName = sdf.format(date);
        File des = mDriver.getScreenshotAs(OutputType.FILE);
        int scaledWidth = 320;
        int scaledHeight = 500;
        if (Platforms.ANDROID.equals(mPlatform)) {
            FileUtils.copyFile(des, new File(System.getProperty("user.dir") + "//screenshots//android.AndroidSanity//" + fileName + ".png"));

        } else {
            FileUtils.copyFile(des, new File(System.getProperty("user.dir") + "//screenshots//IOS.IosSanity//" + fileName + ".png"));
            ImageResizer.resize(System.getProperty("user.dir") + "//screenshots//IOS.IosSanity//" + fileName + ".png", System.getProperty("user.dir") + "//screenshots//IOS.IosSanity//" + fileName + ".png", scaledWidth, scaledHeight);

        }

        if (Platforms.ANDROID.equals(mPlatform)) {
            return "screenshots/android.AndroidSanity/" + fileName + ".png";

        } else
            return "screenshots/IOS.IosSanity/" + fileName + ".png";


    }

    public boolean isElementDisplayed(MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(mDriver, 2);
            return wait.until((ExpectedConditions.visibilityOf(element))).isDisplayed();

           // return element.isDisplayed();

        } catch (Exception e) {
            //System.out.println(e);

            return false;
        }
    }


    public boolean isElementEnabled(MobileElement element)  {

        if(element.isEnabled()){
            return true;
        }else
        return false;
    }


    public void clearTextFully(MobileElement element) {
        int stringLength = element.getText().length();

        try {

            for (int i = 0; i < stringLength; i++) {
                element.sendKeys(Keys.DELETE);

            }
        } catch (Exception e) {
                clearInput( element);
                  }



    }

    public void CheckDisplayedOfElement(MobileElement element, String item) throws IOException, InterruptedException {
        if (isElementDisplayed(element)) {
            mLogger.log(Status.PASS, item + "  option is displayed ");

        } else {
            String ScreenshotPath = getscreenshot();

           // mLogger.log(Status.FAIL, item + "  option is not displayed");
            ExtentTestManager.getTest().fail(item + "  option is not displayed,",
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build());

        }
    }
    public void CheckElementIsNotDisplayed(MobileElement element, String item) throws IOException, InterruptedException {
        if (!isElementDisplayed(element)) {
            mLogger.log(Status.PASS, item + "  option is  not displayed ");

        } else {
            String ScreenshotPath = getscreenshot();

            // mLogger.log(Status.FAIL, item + "  option is not displayed");
            ExtentTestManager.getTest().fail(item + "  option should not be displayed ",
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build());

        }
    }

    public void scrollFromElementToAnother(MobileElement source, MobileElement destination) throws IOException, InterruptedException {

            TouchAction touchAction = new TouchAction(mDriver);
            touchAction.longPress(element(source)).moveTo(element(destination)).release().perform();
    }

    public void CheckDisplayedOfText(String message , String texttoCompare, String item) throws IOException, InterruptedException {
        if (message.equals(texttoCompare)) {
            mLogger.log(Status.PASS, item + "");
        } else {
            String ScreenshotPath = getscreenshot();

            // mLogger.log(Status.FAIL, item + "  option is not displayed");
            ExtentTestManager.getTest().fail(texttoCompare + "is not displayed",
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build());

        }
    }

    public void GetItemFromNotificationBar(String item)
            throws MalformedURLException, InterruptedException {

        ((AndroidDriver) mDriver).openNotifications();
        Thread.sleep(2000);
        if (isElementDisplayed(ElementToClick("CLEAR", 0, 0))) {
            ElementToClick("CLEAR", 0, 0).click();
            Thread.sleep(2000);

            ((AndroidDriver) mDriver).openNotifications();
            Thread.sleep(2000);
            //driver.findElementById("android:id/expand_button").click();
        }
        if (isElementDisplayed(ElementToClick(item, 0, 0))) {
            ElementToClick(item, 0, 0).click();

        } else ((AndroidDriver<?>) mDriver).pressKey(new KeyEvent(AndroidKey.BACK));


    }

    public boolean DisplayOfStringClick(String StringToclick, int FirstInstance, int SecondInstance)
            throws MalformedURLException, InterruptedException {

        List<AndroidElement> allTitleElements = ((AndroidDriver<AndroidElement>) mDriver).findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(" + FirstInstance + ")).scrollIntoView(new UiSelector().textContains(\""
                        + StringToclick + "\").instance(" + SecondInstance + "))");

        if (allTitleElements.size() > 0)
            return true;
        else
            return false;
    }

    public void CheckDisplayedOfString(String item, int firstinstance, int secondInstance, ExtentTest mLogger) throws IOException, InterruptedException {
        if (DisplayOfStringClick(item, firstinstance, secondInstance)) {
            mLogger.log(Status.PASS, item + "  string is displayed ");
        } else {
            mLogger.log(Status.FAIL, item + "  string is not displayed");
            String ScreenshotPath = getscreenshot();
            System.out.println("Here where Screenshot is captured");

            mLogger.addScreenCaptureFromPath(ScreenshotPath);
        }
    }


    public void scrollToElement(AppiumDriver driver, MobileElement element, boolean scrollDown) {
        String direction;
        direction = scrollDown ? "down" : "up";
        HashMap<String, Object> scrollObject = new HashMap();
        scrollObject.put("direction", direction);
        scrollObject.put("element", element);

        driver.executeScript("mobile: scrollTo", scrollObject);
    }


    //Press by coordinates
    public void pressByCoordinates(int x, int y, long seconds) {
        new TouchAction(mDriver)
                .press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = mDriver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(mDriver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    public  void tapCenterofScreen(double startPercentage, double endPercentage) {
        Dimension size = mDriver.manage().window().getSize();
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        PointOption<?> option = PointOption.point(startPoint, endPoint);
        new TouchAction(mDriver).tap(option).perform();
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = mDriver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(mDriver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }

    //Swipe by elements
    public void swipeByElements(MobileElement startElement, MobileElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(mDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    //Multitouch action by using an android element
    public void multiTouchByElement(MobileElement androidElement) {
        TouchAction press = new TouchAction(mDriver)
                .press(element(androidElement))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release();

        new MultiTouchAction(mDriver)
                .add(press)
                .perform();
    }


    public Boolean checkIfElementIsPresent(MobileElement element,String item) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        try {
            if (wait.until(ExpectedConditions.visibilityOf(element)) != null) {
                Assert.assertTrue(element.isDisplayed());
//do something if present
                System.out.println("Element  present, we are good here!");

            }
        } catch (Exception e) {
            String ScreenshotPath = getscreenshot();

            // mLogger.log(Status.FAIL, item + "  option is not displayed");
            ExtentTestManager.getTest().fail(item + "  option is not displayed,",
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build());
            System.out.println("Element not present");

        }
        return true;
    }





    public final MobileElement SelectedString(String SecondDevice) {
        String selector = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] '" + SecondDevice + "' AND visible == 1";
        return (MobileElement) mDriver.findElement(MobileBy.iOSNsPredicateString(selector));
    }

    public final MobileElement elementIOSbyxpath(String Account) {
        return (MobileElement) mDriver.findElementByXPath("//XCUIElementTypeTextField[@name=\"" + Account + "\"]");
    }


    public void checkIfTwoElementsAreIdentical(String element1, String element2) {
        Assert.assertEquals(element1, element2, element1 + " and " + element2 + "are not identical");
    }

    public String generateFakeName() {
        Faker faker = new Faker();
       return faker.name().name().toLowerCase(Locale.ROOT);
    }
    public void clearInput(MobileElement element)
    {
        try {
            element.clear();
        } catch (Exception e) {
            element.sendKeys("");
        }
    }




    public static final  void swipeRightElementToClickIOSByAcces(AppiumDriver driver, MobileElement source,MobileElement Destination)
            throws MalformedURLException, InterruptedException {

        int bottomX = source.getLocation().getX()+10;
        int x= Destination.getLocation().getX();
        int y= Destination.getLocation().getY();

        TouchAction t = new TouchAction(driver);

        t.longPress(element(source,bottomX, bottomX)).waitAction().moveTo(element(Destination, x,y)).release()
                .perform();


    }

}

