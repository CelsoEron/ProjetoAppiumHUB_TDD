package br.com.rsinet.hub_tdd.pageObject;

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

	public static MobileElement categorySpeaker(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView");
	}

	public static MobileElement btnSearch(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewSearch");
	}

	public static MobileElement boxSearch(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/editTextSearch");
	}
	

	
}
