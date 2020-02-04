package br.com.rsinet.hub_tdd.actions;

import java.time.Duration;

import org.junit.Assert;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.RegisterPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RegisterAction {

	static TouchAction action;

	static String user = "CelsoEron30";

	public static void ExecuteRegister(AndroidDriver<MobileElement> driver) {
		action = new TouchAction(driver);

		HomePage.optionsBtn(driver).click();
		HomePage.loginBtn(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).perform();
		HomePage.createLnk(driver).click();
		RegisterPage.bxUsername(driver).click();
		RegisterPage.bxUsername(driver).sendKeys(user);
		RegisterPage.bxEmail(driver).click();
		RegisterPage.bxEmail(driver).sendKeys("celso.silva@rsinet.com.br");
		RegisterPage.bxPassword(driver).click();
		RegisterPage.bxPassword(driver).sendKeys("Test1234");
		RegisterPage.bxConfirmPassword(driver).click();
		RegisterPage.bxConfirmPassword(driver).sendKeys("Test1234");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_ENTER));
		RegisterPage.bxFirstName(driver).sendKeys("Celso Eron");
		action.tap(PointOption.point(1300, 2731)).perform();
		RegisterPage.bxPhoneNumber(driver).sendKeys("11111111");
		RegisterPage.bxLastName(driver).click();
		RegisterPage.bxLastName(driver).sendKeys("de Almeida Silva");
		action.tap(PointOption.point(1300, 2731)).perform();
		action.tap(PointOption.point(1214, 2201)).perform();
		RegisterPage.bxState(driver).sendKeys("Paulo Sao");
		RegisterPage.bxCountry(driver).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Brazil" + "\").instance(0))")
				.click();
		RegisterPage.bxPhoneNumber(driver).click();
		action.tap(PointOption.point(1214, 2201)).perform();
		action.tap(PointOption.point(1300, 2731)).perform();
		RegisterPage.bxAdress(driver).sendKeys("Rua da rua");
		action.tap(PointOption.point(1300, 2731)).perform();
		RegisterPage.bxCity(driver).click();
		RegisterPage.bxCity(driver).sendKeys("Cidade dade");
		RegisterPage.bxZip(driver).click();
		RegisterPage.bxZip(driver).sendKeys("0000000");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "REGISTER" + "\").instance(0))");
		RegisterPage.btnRegister(driver).click();

		HomePage.optionsBtn(driver).click();

		Assert.assertTrue(HomePage.usernameCheck(driver).getText().contains(user));
	}

	public static void ExecuteInvalidRegister(AndroidDriver<MobileElement> driver) {
		action = new TouchAction(driver);

		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		HomePage.optionsBtn(driver).click();
		HomePage.loginBtn(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).perform();
		HomePage.createLnk(driver).click();
		RegisterPage.bxUsername(driver).click();
		RegisterPage.bxUsername(driver).sendKeys("CelsoEron1");
		RegisterPage.bxEmail(driver).click();
		RegisterPage.bxEmail(driver).sendKeys("celso.silva@rsinet.com.br");
		RegisterPage.bxPassword(driver).click();
		RegisterPage.bxPassword(driver).sendKeys("Test1234");
		RegisterPage.bxConfirmPassword(driver).click();
		RegisterPage.bxConfirmPassword(driver).sendKeys("Test12341");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		RegisterPage.bxFirstName(driver).sendKeys("Celso Eron");
		RegisterPage.bxLastName(driver).click();
		RegisterPage.bxLastName(driver).sendKeys("de Almeida Silva");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		RegisterPage.bxState(driver).sendKeys("Paulo Sao");
		RegisterPage.bxCountry(driver).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Brazil" + "\").instance(0))")
				.click();
		RegisterPage.bxPhoneNumber(driver).click();
		RegisterPage.bxPhoneNumber(driver).sendKeys("11111111");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		RegisterPage.bxState(driver).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		RegisterPage.bxAdress(driver).sendKeys("Rua da rua");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		RegisterPage.bxCity(driver).click();
		RegisterPage.bxCity(driver).sendKeys("Cidade dade");
		RegisterPage.bxZip(driver).click();
		RegisterPage.bxZip(driver).sendKeys("0000000");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "REGISTER" + "\").instance(0))");
		Assert.assertFalse(RegisterPage.btnRegister(driver).isEnabled());
	}
}
