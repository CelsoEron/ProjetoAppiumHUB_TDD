package br.com.rsinet.hub_tdd.utils;

public class Constant {

	public static String Path_TestData = "target\\ExcelFile\\";
	public static String File_TestData = "TestData.xlsx";

	public static String produto() throws Exception {
		return ExcelUtils.getCellData(0, 0);
	}

}