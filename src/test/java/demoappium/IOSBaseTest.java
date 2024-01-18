package demoappium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class IOSBaseTest {
    public IOSDriver driver;
    public AppiumDriverLocalService serviceBuilder;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("iPhone 13 Pro");
        xcuiTestOptions.setPlatformVersion("15.5");
        xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
        xcuiTestOptions.setApp("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\UIKitCatalog.apk");
        driver  = new IOSDriver(new URL("http://127.0.0.1:4723"),xcuiTestOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //IOS Long Press Action
    @Test
    public void IOSLongPressAction(WebElement element){
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("duration",5);
        driver.executeScript("mobile:touchAndHold",param);
    }

    //IOS Scroll Press Action
    @Test
    public void IOSScrollAction(WebElement element){
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("direction","down");

        driver.executeScript("mobile:scroll",param);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}
