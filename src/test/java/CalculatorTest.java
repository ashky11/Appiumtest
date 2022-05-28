import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		OpenCalculator();
	} catch (Exception exp) {
		// TODO Auto-generated catch block
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
	}	
	}	
	public static void OpenCalculator() throws Exception {
	//add desired capabilities
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("devicename", "Pixel_2_emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9.0.0");
		cap.setCapability("udid", "emulator-5554");
		
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
	
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
	
		System.out.println("application started");
		
		MobileElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
	MobileElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
	MobileElement Plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
	MobileElement equals = driver.findElement(By.id("com.android.calculator2:id/eq")); 
	//MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
	MobileElement result = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
	
	three.click();
	Plus.click();
	five.click();
	equals.click();
	
	String res = ((RemoteWebElement) result).getText();
	
	System.out.println("result is : "+res);
	
	System.out.println("completed...!");
	}
	}


