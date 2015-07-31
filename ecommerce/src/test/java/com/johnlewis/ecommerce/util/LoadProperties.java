package com.johnlewis.ecommerce.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * This loads the properties files with environment specific properties
 * 
 * @author mmahadevan
 * 
 */
public class LoadProperties {
	private static final Logger LOG = Logger.getLogger(LoadProperties.class);

	private Properties orProperties;
	private Properties configProperties;

	private String envFileName = "config.properties";

	/**
	 * This method initialises the properties load
	 */
	public void init() {
		try {
			LOG.debug("Loading environment specific properties file");
			configProperties = getPropertiesFromClasspath(envFileName);
		} catch (Exception e) {
			LOG.error("Error loading properties files", e);
		}
	}

	/**
	 * This loads the properties file from the classpath
	 * 
	 * @param propFileName
	 *            name of the file
	 * @return properties
	 * @throws IOException
	 */
	private Properties getPropertiesFromClasspath(String propFileName)
			throws IOException {
		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(propFileName);

		if (inputStream == null) {
			throw new FileNotFoundException("Property file '" + propFileName
					+ "' not found in the classpath");
		}

		props.load(inputStream);

		return props;
	}

	// Setters and getters

	public Properties getOrProperties() {
		return orProperties;
	}

	public void setOrProperties(Properties orProperties) {
		this.orProperties = orProperties;
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties config) {
		configProperties = config;
	}

	// END Setters and getters
}
