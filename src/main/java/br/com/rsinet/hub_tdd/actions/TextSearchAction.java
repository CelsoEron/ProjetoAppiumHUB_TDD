package br.com.rsinet.hub_tdd.actions;

import org.junit.Assert;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.ProductsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TextSearchAction {
	static TouchAction action;

	public static void ExecuteValidTextSearch(AndroidDriver<MobileElement> driver) {

		HomePage.btnSearch(driver).click();
		HomePage.boxSearch(driver).sendKeys("HP");
		HomePage.btnSearch(driver).click();
		ProductsPage.produtoSearchTxt(driver).click();
		Assert.assertEquals(ProductsPage.produtoText(driver).getText(), "HP PAVILION 15T TOUCH LAPTOP");
	}

	public static void ExecuteInvalidTextSearch(AndroidDriver<MobileElement> driver) {

		HomePage.btnSearch(driver).click();
		HomePage.boxSearch(driver).sendKeys("iPhone");
		HomePage.btnSearch(driver).click();

		Assert.assertTrue(ProductsPage.notFoundMessage(driver).getText().contains("No results for "));
	}
}