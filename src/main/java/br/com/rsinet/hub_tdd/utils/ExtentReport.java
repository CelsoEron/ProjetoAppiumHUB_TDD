package br.com.rsinet.hub_tdd.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	 

    private static ExtentReports extent;
    private static ExtentTest test;

 

    public static void iniciaReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentScreenshot.html", true);
    }

 

    public static void fechaReport() {
        extent.flush();
    }

 

    public static ExtentTest getTest() {
        return test;
    }

 

    public static ExtentReports getExtent() {
        return extent;
    }
}