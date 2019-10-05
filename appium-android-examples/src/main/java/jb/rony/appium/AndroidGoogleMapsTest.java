package jb.rony.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class AndroidGoogleMapsTest {

	private final static String APP_PACKAGE_NAME = "com.google.android.apps.maps";
    private final static String APP_ACTIVITY_NAME = "com.google.android.maps.MapsActivity";

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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
    	/*
    	{
		  "platformName": "android",
		  "appPackage": "com.google.android.apps.maps",
		  "appActivity": "com.google.android.maps.MapsActivity",
		  "deviceName": "Pixel 2 XL"
		}
		*/
    }
    
	@Test
	public void googleMapsTest() throws Exception {
		
        String searchFor = "John Bryce";
        String addressShouldContain = "Tel Aviv";
		
//        String searchFor = "Statue of Liberty";
//        String addressShouldContain = "New York";
        
//        String searchFor = "Eiffel Tower";
//        String addressShouldContain = "Paris";
        
        // 1. If 'Sign in' offer is shown - click 'SKIP'
		List<MobileElement> buttons = driver.findElements(By.xpath("//android.widget.Button[@text='SKIP']"));
        
        if (buttons.size() > 0) {
        	buttons.get(0).click();
        }
        
        // 2. Click top search bar
        driver.findElement(By.xpath("//android.widget.TextView[@text='Search here']")).click();
        
        // 3. Type the value of locationName into the 'Search here' box 
        System.out.println("Search Google Maps for: " + searchFor);
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search here']")).sendKeys(searchFor);
        
        Thread.sleep(2000);

        // 4. Read the location name and address of the first search result, and print them
        List<MobileElement> resultElements = driver.findElements(By.xpath("//android.widget.LinearLayout[count(android.widget.TextView)=2]"));
        MobileElement firstResultElement = resultElements.get(0);
        List<MobileElement> textElements = firstResultElement.findElements(By.className("android.widget.TextView"));
        String placeName = textElements.get(0).getText();
        String placeAddress = textElements.get(1).getText();
        
        System.out.println("Place name: " + placeName);
        System.out.println("Place address: " + placeAddress);
        
        // 5. Verify the first location address contains the value of addressShouldContain
        Assert.assertTrue(placeAddress.contains(addressShouldContain), "Address should contain '" + addressShouldContain + "'");
	}
    
    @AfterClass
    public void afterClass() throws Exception {
        //driver.quit();
    }
}
