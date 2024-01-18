package demoappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Miscellaneous extends BaseTest{


    @Test
    public void MiscellaneousTests(){
        //NAVIGATE DIRECTLY TO REQUIRED SCREEN USING ACTIVITY
        //adb shell dumpsys window | grep -E 'mCurrentFocus' - MAC
        //adb shell dumpsys window | find "mCurrentFocus" - Windows
        //log:  mCurrentFocus=Window{4742c76 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
       // driver.startActivity(activity); ---Deprecated.
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        //ROTATE TO LANDSCAPE MODE
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String popupText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText().trim();
        Assert.assertEquals(popupText,"WiFi settings");

        //CLIPBOARD TEXT
        driver.setClipboardText("Wifi Network");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //KEY EVENTS
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
