package br.com.rsinet.hub_tdd.automationRun;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.actions.RegisterAction;
import br.com.rsinet.hub_tdd.utils.ExtentReport;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RegisterTest {

	public static AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@BeforeClass
	public static void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	@Test
	public void RegisterValid() throws InterruptedException, IOException {
		test = extent.startTest("Registro válido");

		RegisterAction.ExecuteRegister(driver);
		String screenShotPath = Screenshot.capture(driver, "RegisterValid");
	}

	@Test
	public void RegisterInvalid() throws IOException {
		
		test = extent.startTest("Registro inválido");

		RegisterAction.ExecuteInvalidRegister(driver);
		String screenShotPath = Screenshot.capture(driver, "RegisterInvalid");
	}

	@AfterClass
	public static void closeDriver() {

		driver.close();

	}
	
}
