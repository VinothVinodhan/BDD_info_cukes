package com.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProFile {

	Properties prop;
	String propFilePath = "Configs/env.properties";
	BufferedReader buffRead;
	final String a = "abcs";

	public ReadProFile() {

		try {
			buffRead = new BufferedReader(new FileReader(propFilePath));
			prop = new Properties();

			prop.load(buffRead);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getUrl() {
		String url = prop.getProperty("url");
		System.out.println("URL value from Prop file is: " + url);
		return url;
	}

	public String browserName() {
		String browser = prop.getProperty("browserName");
		System.out.println("Browser Name value from Prop file is: " + browser);
		return browser;
	}

	public String getDriverPath() {
		String driverPath = prop.getProperty("driverPath");
		System.out.println("Path of Driver value from Prop file is: " + driverPath);
		return driverPath;
	}

}
