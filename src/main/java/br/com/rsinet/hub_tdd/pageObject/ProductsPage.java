package br.com.rsinet.hub_tdd.pageObject;

import org.apache.xmlbeans.impl.jam.mutable.MElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {

	static AndroidDriver<MobileElement> driver;

	public static MobileElement produto(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath(
				"//android.widget.RelativeLayout[@content-desc=\"Speakers\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]");
	}

	public static MobileElement produtoText(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
	}

	public static MobileElement produtoSearchTxt(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath(
				"//android.widget.RelativeLayout[@content-desc=\"Search\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]");
	}

	public static MobileElement notFoundMessage(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
	}
	
	public static MobileElement btnFilter(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewFilter");
	}
	
	
	public static MobileElement bxColor(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[9]/android.widget.LinearLayout/android.widget.TextView");
	}
	
	public static MobileElement bxManufacturer(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
	}
	
	public static MobileElement slcPurple(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.View[3]");
	}
	
	public static MobileElement slcBose(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]");
	}
	
	public static MobileElement bxWireless(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[5]/android.widget.LinearLayout");
	}
	
	public static MobileElement slcBluetooh(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]");
	}
	
	public static MobileElement btnApply(AndroidDriver<?> driver) {
		return  (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewApply");
	}
	

}
