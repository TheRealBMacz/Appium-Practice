package demoappium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel 2 XL API 31"); //EMULATOR
       // uiAutomator2Options.setDeviceName("Android Phone"); -- REAL ANDROID PHONE
        uiAutomator2Options.setChromedriverExecutable("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
        //uiAutomator2Options.setApp("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        uiAutomator2Options.setApp("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\General-Store.apk");
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //LONG PRESS ACTION
    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),"duration",2000));
    }

    //SCROLL TO END OF SCREEN
    public void scrollToEndOfScreen(){
        boolean canScrollMore;
        do{
            canScrollMore   = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    //SWIPE ACTION
    public void swipeAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
               "elementId",((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    //GET FORMATTED AMOUNT FROM STRING

    public double getFormattedAmountFromString(String amount){
      return   Double.parseDouble(amount.trim().substring(1));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}
