package br.com.rsinet.hub_tdd.automationRun;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.hub_tdd.actions.TextSearchAction;
import br.com.rsinet.hub_tdd.utils.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TextSearchTest {
	public static AndroidDriver<MobileElement> driver;

	@Before
	public void startDriver() throws MalformedURLException {

		driver = br.com.rsinet.hub_tdd.driverFactory.DriverManager.startDriver();
	}

	@Test
	public void TextSearchValid() {

		TextSearchAction.ExecuteValidTextSearch(driver);
		Screenshot.captureScreenShot(driver);
	}

	@Test
	public void TextSearchInvalid() throws InterruptedException {

		TextSearchAction.ExecuteInvalidTextSearch(driver);
		Screenshot.captureScreenShot(driver);
	}

	@After
	public void closeDriver() {

		((AndroidDriver) driver).closeApp();

	}
}