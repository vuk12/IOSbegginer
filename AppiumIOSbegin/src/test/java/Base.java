import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static IOSDriver driver;

    public static IOSDriver preStupIOS() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        // Check ios version for emulator Iphone device
        //use comand        xcrun xctrace list devices
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"15.0");

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12 Pro");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT,50000);
        cap.setCapability("commandTimeouts","12000");
        cap.setCapability(MobileCapabilityType.APP,"/Users/test/IdeaProjects/AppiumIOSbegin/src/main/resources/UIKitCatalog.app");

        return driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"),cap);
    }


}
