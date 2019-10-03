package jb.rony.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidCalculatorTest {

	private final static String APP_PACKAGE_NAME = "com.android.calculator2";
    private final static String APP_ACTIVITY_NAME = ".Calculator";

    private AndroidDriver<MobileElement> driver;
    
    @BeforeClass
    public void before() throws MalformedURLException {
    	
    	DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        
    	/*
    	{
		  "platformName": "android",
		  "appPackage": "com.android.calculator2",
		  "appActivity": ".Calculator",
		  "deviceName": "Pixel 2 XL"
		}
		*/
    }
    
	@Test
	public void mobileCalculatorTest() {
		
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        MobileElement resultBox = driver.findElement(By.id("com.android.calculator2:id/result"));
        String result = resultBox.getText();
        
        System.out.println("Result: " + result);
        
        Assert.assertEquals(3, Integer.parseInt(result));
	}
    
    @AfterClass
    public void afterClass() throws Exception {
        driver.quit();
    }
}
