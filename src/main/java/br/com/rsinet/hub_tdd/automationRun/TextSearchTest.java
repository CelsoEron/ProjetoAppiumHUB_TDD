package br.com.rsinet.hub_tdd.automationRun;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.actions.TextSearchAction;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TextSearchTest {
	public static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void startReport() throws MalformedURLException {
		ExtentReport.iniciaReport();
	}

	@Before
	public void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Test
	public void TextSearchValid() throws IOException {
		test = extent.startTest("Pesquisa por texto válida");

		TextSearchAction.ExecuteValidTextSearch(driver);
		String screenShotPath = Screenshot.capture(driver, "TextSearchValid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void TextSearchInvalid() throws IOException {
		test = extent.startTest("Pesquisa por texto inválida");

		TextSearchAction.ExecuteInvalidTextSearch(driver);
		String screenShotPath = Screenshot.capture(driver, "TextSearchInvalid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void closeDriver() {

		((AndroidDriver) driver).closeApp();

	}

	@AfterClass
	public static void closeReport() {
		ExtentReport.fechaReport();
	}
}