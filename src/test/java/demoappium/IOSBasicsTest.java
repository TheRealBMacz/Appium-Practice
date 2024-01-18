package demoappium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasicsTest extends IOSBaseTest{

    @Test
    public void IOSBasicsTest(){

        //Xpath, classname, IOS, iOSClassChain, , IOSPredicateString, id, accessibilityId

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //XML is slow in IOS, Native source code of IOS is not in XML
        //Since the devs are converting the native code to xml
        //Hence they developed IOS ClassChain similar to xml

        driver.findElement(AppiumBy.iOSClassChain(
                "**/XCUIElementTypeStaticText[`label == 'Text-Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"))
                .sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK"));

        //IOSNsPredicate
      /* driver.findElement(AppiumBy.
                iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")); */
        driver.findElement(AppiumBy.iOSNsPredicateString
                ("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString
        //                ("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();


    }
}
