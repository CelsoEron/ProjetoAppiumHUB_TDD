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
import br.com.rsinet.hub_tdd.pageObject.ProductsPage;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class ClickSearchTest {

	public static AndroidDriver<MobileElement> driver;
	static TouchAction action;

	@Before
	public void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Test
	public void ClickSearchValid() throws InterruptedException, IOException {
		test = extent.startTest("Pesquisa por cliques válida");
		action = new TouchAction(driver);

		HomePage.categorySpeaker(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).perform();
		ProductsPage.produto(driver).click();
		Assert.assertEquals(ProductsPage.produtoText(driver).getText(), "HP ROAR MINI WIRELESS SPEAKER");
		String screenShotPath = Screenshot.capture(driver, "ClickSearchValid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void ClickSearchInvalid() throws IOException {
		test = extent.startTest("Pesquisa por cliques inválida");
		action = new TouchAction(driver);

		HomePage.categorySpeaker(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		ProductsPage.btnFilter(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		ProductsPage.bxManufacturer(driver).click();
		ProductsPage.slcBose(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		ProductsPage.bxColor(driver).click();
		ProductsPage.slcPurple(driver).click();
		ProductsPage.bxWireless(driver).click();
		ProductsPage.slcBluetooh(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).perform();
		ProductsPage.btnApply(driver).click();
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).perform();

		Assert.assertTrue(ProductsPage.notFoundMessage(driver).getText().contains("No results"));
		String screenShotPath = Screenshot.capture(driver, "ClickSearchInvalid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));

	}

	@After
	public void closeDriver() {
		DriverManager.closeDriver(driver);
	}
}