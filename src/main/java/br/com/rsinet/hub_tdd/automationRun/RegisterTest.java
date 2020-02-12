package br.com.rsinet.hub_tdd.automationRun;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.driverFactory.DriverManager;
import br.com.rsinet.hub_tdd.pageObject.HomePage;
import br.com.rsinet.hub_tdd.pageObject.RegisterPage;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;

public class RegisterTest {

	public static AndroidDriver<MobileElement> driver;
	static TouchAction action;
	static String user = "CelsoEX0";

	@Before
	public void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Test
	public void RegisterValid() throws InterruptedException, IOException {
		test = extent.startTest("Registro válido");
		action = new TouchAction(driver);

		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
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
		RegisterPage.bxCity(driver).sendKeys("Cidade dade");
		RegisterPage.bxZip(driver).click();
		RegisterPage.bxZip(driver).sendKeys("0000000");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "REGISTER" + "\").instance(0))");
		RegisterPage.btnRegister(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).perform();
		HomePage.optionsBtn(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).perform();
		Assert.assertTrue(HomePage.usernameCheck(driver).getText().contains(user));
		String screenShotPath = Screenshot.capture(driver, "RegisterValid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void RegisterInvalid() throws IOException {
		test = extent.startTest("Registro inválido");
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
		RegisterPage.bxCity(driver).sendKeys("Cidade dade");
		RegisterPage.bxZip(driver).click();
		RegisterPage.bxZip(driver).sendKeys("0000000");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "REGISTER" + "\").instance(0))");
		Assert.assertFalse(RegisterPage.btnRegister(driver).isEnabled());
		String screenShotPath = Screenshot.capture(driver, "RegisterInvalid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void closeDriver() {
		DriverManager.closeDriver(driver);
	}
}
