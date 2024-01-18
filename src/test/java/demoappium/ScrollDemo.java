package demoappium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends  BaseTest{


    @Test
    public void scrollDemoTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Where to scroll is known prior use this code
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //Use to scroll when there is no prior idea
        scrollToEndOfScreen();
    }
}
