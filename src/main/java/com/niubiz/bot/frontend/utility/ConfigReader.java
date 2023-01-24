package com.niubiz.bot.frontend.utility;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	public String lastfilecreate() throws Throwable {
		String lastfilecreate = "";
		prop = new Properties();
		FileInputStream ip = new FileInputStream("./src/main/resources/extent.properties");
		prop.load(ip);
		String sCarpAct = System.getProperty("user.dir")+ "/"+ prop.getProperty("basefolder.name");
		File carpeta = new File(sCarpAct);
		File[] archivos = carpeta.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if(archivos != null){
			Arrays.sort(archivos, Comparator.comparing(o -> sdf.format(o.lastModified())));
			lastfilecreate = "/"+ prop.getProperty("basefolder.name") + archivos[(archivos.length)-1].getName() + "/";
		}
		else {
			Assert.fail("No hay elementos dentro de la carpeta actual");
		}
		return lastfilecreate;
	}

}
