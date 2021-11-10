package android.screen;

import framework.screen.STWScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabBarScreen extends STWScreen {

    String Parent = "android.widget.HorizontalScrollView";
    String child = "android.widget.LinearLayout";


    public TabBarScreen(AppiumDriver driver) {
        super(driver);
    }

    public void getContactItem() {
        ToClickFromChildClassbyXpath(Parent, child, 0);
    }


    public void getMessageItem() {
        ToClickFromChildClassbyXpath(Parent, child, 1);
    }


    public void getChannelsItem() {
        ToClickFromChildClassbyXpath(Parent, child, 2);
    }


    public void getMyBusinessItem() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.id("tab_icon")));

        ToClickFromChildClassbyXpath(Parent, child, 3);
    }

    public void getMoreItem() {
        WebDriverWait wait = new WebDriverWait(mDriver, 5);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.id("tab_icon")));
        ToClickFromChildClassbyXpath(Parent, child, 4);
    }

    public void getSchedulingItem() { ToClickFromChildClassbyXpath(Parent, child, 0); }


    public void clickOnMoreButton() {


        getMoreItem();
    }
}
