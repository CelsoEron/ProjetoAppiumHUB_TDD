package br.com.rsinet.hub_tdd.automationRun;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.rsinet.hub_tdd.actions.SearchClickAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ClickSearchTest {
	public static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	@Test
	public void ClickSearchValid() throws InterruptedException {

		SearchClickAction.ExecuteClickSearch(driver);
	}

	@AfterClass
	public static void closeDriver() {

		((AndroidDriver) driver).closeApp();

	}
}