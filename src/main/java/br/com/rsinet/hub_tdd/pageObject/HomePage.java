package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	static AndroidDriver<MobileElement> driver;
	private static WebDriverWait wait;

	public static MobileElement optionsBtn(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewMenu");
	}

	public static MobileElement loginBtn(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser");
	}


	public static MobileElement createLnk(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewSingUpToday");
	}

}
