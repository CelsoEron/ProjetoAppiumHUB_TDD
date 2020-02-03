package br.com.rsinet.hub_tdd.automationRun;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.rsinet.hub_tdd.actions.RegisterAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RegisterTest {

	public static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	@Test
	public void RegisterValid() throws InterruptedException {

		RegisterAction.ExecuteRegister(driver);
	}

	@AfterClass
	public static void closeDriver() {

		driver.close();

	}
}
