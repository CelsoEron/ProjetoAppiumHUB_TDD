package br.com.rsinet.hub_tdd.actions;

import java.time.Duration;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.ProductsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class SearchClickAction {

	static TouchAction action;

	public static void ExecuteClickSearch(AndroidDriver<MobileElement> driver) {
		action = new TouchAction(driver);

		HomePage.categorySpeaker(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).perform();
		ProductsPage.produto(driver).click();
	}
}
