//package com.johnlewis.ecommerce.cucumberReport;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import net.masterthought.cucumber.ReportBuilder;
//import org.apache.commons.io.FileUtils;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//import org.junit.Test;
//
//public class GeneratePoshReport {
//	public GeneratePoshReport() {
//	}
//
//	@Test
//	public void generatePoshReport() throws Throwable {
//		String reportPath = "target/cucumber-html-reports";
//		DateTimeFormatter dateFormat = DateTimeFormat
//				.forPattern("yyyy-MM-dd_HHmmss");
//		String currentTimeStamp = dateFormat.print(new DateTime());
//		File reportPickupDirectory = new File(reportPath);
//		File reportOutputDirectory = new File(reportPath + "_"
//				+ currentTimeStamp);
//
//		List<String> jsonReportFiles = new ArrayList<String>();
//		jsonReportFiles.add("target/Regression.json");
//		//jsonReportFiles.add("target/MVP.json");
//		 //jsonReportFiles.add("target/SVP.json");
//
//		String buildNumber = "suma report";
//		String buildProjectName = "";
//		String pluginURLPath = "";
//		Boolean skippedFails = true;
//		Boolean undefinedFails = true;
//		Boolean flashCharts = true;
//		Boolean runWithJenkins = false;
//		Boolean artificatsEnabled = false;
//		String artifactsConfig = "";
//		boolean highCharts = false;
//
//		ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles,
//				reportPickupDirectory, pluginURLPath, buildNumber,
//				buildProjectName, skippedFails, undefinedFails, flashCharts,
//				runWithJenkins, artificatsEnabled, artifactsConfig, highCharts);
//		reportBuilder.generateReports();
//
//		try {
//			if (reportOutputDirectory.mkdir())
//				FileUtils.copyDirectory(reportPickupDirectory,
//						reportOutputDirectory);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
