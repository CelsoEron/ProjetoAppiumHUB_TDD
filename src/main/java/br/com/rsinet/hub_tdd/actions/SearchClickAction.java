package br.com.rsinet.hub_tdd.actions;

import org.junit.Assert;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.ProductsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SearchClickAction {

	static TouchAction action;

	public static void ExecuteClickSearch(AndroidDriver<MobileElement> driver) {
		action = new TouchAction(driver);

		HomePage.categorySpeaker(driver).click();
		ProductsPage.produto(driver).click();
//		ProductsPage.produtoText(driver).getText();
		System.out.println(ProductsPage.produtoText(driver).getText());
		Assert.assertEquals(ProductsPage.produtoText(driver).getText(), "HP ROAR MINI WIRELESS SPEAKER");
	}
}
