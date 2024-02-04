package api_learning;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Lesion14 {
    public static void main(String[] args){
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("udid", "R58R435G6TK");
        desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

        try {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);

            // Wait for 3 seconds for the app to launch
            Thread.sleep(3000);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while creating the Appium session");
            e.printStackTrace();
        }

        // Quit the driver if it was initialized
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}