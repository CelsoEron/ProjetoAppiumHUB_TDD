package br.com.rsinet.hub_tdd.actions;

import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.RegisterPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class RegisterAction {

	static TouchAction action;

	public static void ExecuteRegister(AndroidDriver<MobileElement> driver) throws InterruptedException {

		
		HomePage.optionsBtn(driver).click();
		HomePage.loginBtn(driver).click();
//		HomePage.waitLnk();
		Thread.sleep(3000);
		HomePage.createLnk(driver).click();
		RegisterPage.bxUsername(driver).click();
		RegisterPage.bxUsername(driver).sendKeys("CelsoEron");
		RegisterPage.bxEmail(driver).click();
		RegisterPage.bxEmail(driver).sendKeys("celso.silva@rsinet.com.br");
		RegisterPage.bxPassword(driver).click();
		RegisterPage.bxPassword(driver).sendKeys("Test1234");
		RegisterPage.txtbx_ConfirmPassword(driver).click();
		RegisterPage.txtbx_ConfirmPassword(driver).sendKeys("Test1234");
		action = new TouchAction(driver);
		action.tap(PointOption.point(1300, 2731)).perform();
		RegisterPage.bxFirstName(driver).sendKeys("Celso Eron");
		action.tap(PointOption.point(1344, 2750)).perform();
		RegisterPage.bxLastName(driver).sendKeys("de Almeida Silva");
		RegisterPage.bxCity(driver).click();
		RegisterPage.bxCity(driver).sendKeys("Osasco");
	}
}
