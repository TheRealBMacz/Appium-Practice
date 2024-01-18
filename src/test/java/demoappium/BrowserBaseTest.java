package demoappium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\bthathar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel 2 XL API 31");
        uiAutomator2Options.setChromedriverExecutable("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
        uiAutomator2Options.setCapability("browserName","Chrome");
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}
