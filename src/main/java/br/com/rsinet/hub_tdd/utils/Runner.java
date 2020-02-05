package br.com.rsinet.hub_tdd.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rsinet.hub_tdd.automationRun.ClickSearchTest;
import br.com.rsinet.hub_tdd.automationRun.RegisterTest;
import br.com.rsinet.hub_tdd.automationRun.TextSearchTest;

@RunWith(Suite.class)
@SuiteClasses({ ClickSearchTest.class, RegisterTest.class, TextSearchTest.class })
public class Runner {

	@BeforeClass
	public static void iniciaReport() {
		ExtentReport.iniciaReport();
	}

	@AfterClass
	public static void fecharReport() {
		ExtentReport.fechaReport();
	}

}
