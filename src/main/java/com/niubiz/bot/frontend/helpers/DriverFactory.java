package com.niubiz.bot.frontend.helpers;

import com.niubiz.bot.frontend.utility.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	private static ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();;
	public static void generarRuta(String ruta) {
		File directorio = new File(ruta);
		if(!directorio.exists()) {
			directorio.mkdirs();
		}
	}
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) throws MalformedURLException {

		logger.info("[LOG] browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			// Setting new download directory path
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Use File.separator as it will work on any OS
			generarRuta(System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
			prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.extensions_to_open", "xml");
			prefs.put("safebrowsing.enabled", true);

			// Adding cpabilities to ChromeOptions
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments(
					"--verbose",
					"--disable-web-security",
					"--ignore-certificate-errors",
					"--allow-running-insecure-content",
					"--allow-insecure-localhost",
					"--no-sandbox",
					"--disable-gpu",
					"enable-automation",
					"--disable-infobars",
					"--disable-dev-shm-usage",
					"--disable-browser-side-navigation"
					//,"--headless"
			);
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.setExperimentalOption("prefs", prefs);
			chromeOptions.setCapability("goog:loggingPrefs", logPrefs);

			String grid = prop.getProperty("hook.grid");
			if(grid.equals("true")){
				chromeOptions.addArguments("--headless");
				URL url = new URL(prop.getProperty("hook.url")+"/wd/hub");
				tlDriver.set(new RemoteWebDriver(url,chromeOptions));
				Dimension dimension = new Dimension(1920, 1080);
				getDriver().manage().window().setSize(dimension);
			}
			else {
				tlDriver.set(new ChromeDriver(chromeOptions));
			}
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			tlDriver.set(new FirefoxDriver(firefoxOptions));
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Por favor, pase el valor correcto del navegador: " + browser);
		}

		long DELAY = Long.parseLong(prop.getProperty("hook.delay"));

		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(DELAY));
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
