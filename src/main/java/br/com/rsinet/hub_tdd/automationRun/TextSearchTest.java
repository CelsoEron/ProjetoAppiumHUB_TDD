package br.com.rsinet.hub_tdd.automationRun;

import java.io.IOException;

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
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TextSearchTest {
	public static AndroidDriver<MobileElement> driver;

	@Before
	public void startDriver() throws Exception {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Produto");
	}

	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Test
	public void TextSearchValid() throws Exception {
		test = extent.startTest("Pesquisa por texto válida");

		HomePage.btnSearch(driver).click();
		HomePage.boxSearch(driver).sendKeys(Constant.produto());
		HomePage.btnSearch(driver).click();
		ProductsPage.produtoSearchTxt(driver).click();

		Assert.assertEquals(ProductsPage.produtoText(driver).getText(), "HP PAVILION 15T TOUCH LAPTOP");
		String screenShotPath = Screenshot.capture(driver, "TextSearchValid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void TextSearchInvalid() throws IOException {
		test = extent.startTest("Pesquisa por texto inválida");

		HomePage.btnSearch(driver).click();
		HomePage.boxSearch(driver).sendKeys("iPhone");
		HomePage.btnSearch(driver).click();
		Assert.assertTrue(ProductsPage.notFoundMessage(driver).getText().contains("No results for "));
		String screenShotPath = Screenshot.capture(driver, "TextSearchInvalid");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void closeDriver() {
		DriverManager.closeDriver(driver);
	}
}