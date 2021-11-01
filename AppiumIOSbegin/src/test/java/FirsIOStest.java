import com.google.common.annotations.VisibleForTesting;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

public class FirsIOStest extends Base{

    @Test
    public void FirstBasicIosTest() throws MalformedURLException {
        driver = preStupIOS();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
        driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("hallo");
        driver.findElementByAccessibilityId("OK").click();

        driver.findElementByAccessibilityId("Confirm / Cancel").click();
        Assert.assertTrue(driver.findElementByXPath("//*[contains(@name,'message')]").getText().
               contains("A message should be a short, complete sentence."));
        driver.findElementByAccessibilityId("Confirm").click();

    }

    @Test
    public void ScrollIOS() throws MalformedURLException, InterruptedException {
        driver = preStupIOS();
        //Scroll
        HashMap<String,Object> scroolObj = new HashMap<>();
        scroolObj.put("direction","down");
        scroolObj.put("name","Web View"); // eleement attribute, value of the attribute
        driver.executeScript("mobile:scroll",scroolObj);

        driver.findElementByAccessibilityId("Web View").click();

        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[@name='UIKitCatalog']").click();
        driver.findElementByAccessibilityId("Picker View").click();

        driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
        driver.findElementByAccessibilityId("Blue color component value").sendKeys("105");


    }

    @Test
    public void Slider() throws MalformedURLException {
        driver = preStupIOS();

        driver.findElementByAccessibilityId("Sliders").click();

        //slider
        IOSElement slider = (IOSElement)driver.findElementByXPath("//XCUIElementTypeSlider");
        slider.setValue("0%");
        slider.setValue("1%");  //1 % means 100% 40% is 0.4%
        Assert.assertEquals("100%",slider.getAttribute("value"));

    }


    //Do not run test it will fail because no longPress.app is downloaded
    @Test
    public void LongTapNO_APPLICATION_WILL_NOT_WORK_JUST_CONCEPT() throws MalformedURLException {
        driver = preStupIOS();

        //Prvo lokator od elementa na koji zelis da uradis long tap i kastujes ga u mobile element
        MobileElement elem = (MobileElement)driver.findElementByName("SomeName");

        IOSTouchAction touch = new IOSTouchAction(driver);
        touch.longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(elem)).withDuration(Duration.ofSeconds(2))).release().perform();

        //Tap Gesture 60 lesson
        MobileElement elementMobile = (MobileElement)driver.findElementByName("SomeName");
        touch.tap(TapOptions.tapOptions().
                withElement(ElementOption.element(elem))).perform();

    }

}
