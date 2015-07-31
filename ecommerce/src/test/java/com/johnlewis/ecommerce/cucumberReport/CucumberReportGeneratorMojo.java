//package com.johnlewis.ecommerce.cucumberReport;
//
//import net.masterthought.cucumber.ReportBuilder;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.filefilter.FileFileFilter;
//import org.apache.commons.io.filefilter.RegexFileFilter;
//import org.apache.maven.plugin.AbstractMojo;
//import org.apache.maven.plugin.MojoExecutionException;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @goal generate
// * 
// * @phase verify
// */
//public class CucumberReportGeneratorMojo extends AbstractMojo {
//
//	/**
//	 * Name of the project.
//	 * 
//	 * @parameter expression="${project.name}"
//	 * @required
//	 */
//	private String projectName;
//
//	/**
//	 * Location of the file.
//	 * 
//	 * @parameter expression="${project.build.directory}/cucumber-reports"
//	 * @required
//	 */
//	private File outputDirectory;
//
//	/**
//	 * Location of the file, or directory. If a directory is specified then
//	 * recursively look for files with an extension of json.
//	 * 
//	 * @parameter expression="${project.build.directory}/cucumber.json"
//	 * @required
//	 */
//	private File jsonLocation;
//
//	/**
//	 * Enable Flash Charts.
//	 * 
//	 * @parameter expression="true"
//	 * @required
//	 */
//	private Boolean enableFlashCharts;
//
//	/**
//	 * Skipped tests are reported as failures
//	 * 
//	 * @parameter expression="true"
//	 * @required
//	 */
//	private Boolean skippedFails;
//
//	/**
//	 * Undefined tests are reported as failures
//	 * 
//	 * @parameter expression="true"
//	 * @required
//	 */
//	private Boolean undefinedFails;
//
//	/**
//	 * BuildNumber
//	 * 
//	 * @parameter expression="1"
//	 * @required
//	 */
//	private String buildNumber;
//
//	public void execute() throws MojoExecutionException {
//		if (!outputDirectory.exists()) {
//			outputDirectory.mkdirs();
//		}
//
//		List<String> list = buildFileList();
//
//		ReportBuilder reportBuilder;
//
//		try {
//			System.out.println("About to generate");
//			reportBuilder = new ReportBuilder(list, outputDirectory, "",
//					buildNumber, projectName, skippedFails, undefinedFails,
//					enableFlashCharts, false, false, "", enableFlashCharts);
//			reportBuilder.generateReports();
//
//			boolean buildResult = reportBuilder.getBuildStatus();
//			if (!buildResult) {
//				throw new MojoExecutionException(
//						"BUILD FAILED - Check Report For Details");
//			}
//		} catch (Exception e) {
//			throw new MojoExecutionException("Error Found:", e);
//		}
//	}
//
//	private List<String> buildFileList() throws MojoExecutionException {
//		List<String> list = new ArrayList<String>();
//		if (!jsonLocation.exists()) {
//			throw new MojoExecutionException("The file or directory ["
//					+ jsonLocation + "] does not exist.");
//		}
//		if (jsonLocation.isDirectory()) {
//			Collection<File> files = FileUtils.listFiles(jsonLocation,
//					new RegexFileFilter("^(.*)?\\.json$"), FileFileFilter.FILE);
//			for (File file : files) {
//				list.add(file.getAbsolutePath());
//			}
//			return list;
//		}
//		list.add(jsonLocation.getAbsolutePath());
//		return list;
//	}
//}
