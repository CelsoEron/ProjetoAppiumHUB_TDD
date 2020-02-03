package br.com.rsinet.hub_tdd.driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> startDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		caps.setCapability("deviceName", "10.1.1.170:5555");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.Advantage.aShopping");
		caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");

		driver = new AndroidDriver<MobileElement>(url, caps);

		return driver;

	}

	public static void closeApp(WebDriver driver) {
		if (driver != null)

			driver.close();
		driver.quit();

	}
}
