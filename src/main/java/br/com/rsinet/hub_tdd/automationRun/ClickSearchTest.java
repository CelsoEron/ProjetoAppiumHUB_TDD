package br.com.rsinet.hub_tdd.automationRun;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.actions.SearchClickAction;
import br.com.rsinet.hub_tdd.driverFactory.DriverManager;
import br.com.rsinet.hub_tdd.pageObject.ProductsPage;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ClickSearchTest {

	public static AndroidDriver<MobileElement> driver;

	@Before
	public void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Test
	public void ClickSearchValid() throws InterruptedException, IOException {
		test = extent.startTest("Pesquisa por cliques válida");

		SearchClickAction.ExecuteClickSearch(driver);
		Assert.assertEquals(ProductsPage.produtoText(driver).getText(), "HP ROAR MINI WIRELESS SPEAKER");
		String screenShotPath = Screenshot.capture(driver, "ClickSearchValid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void closeDriver() {
		DriverManager.closeDriver(driver);
	}
}