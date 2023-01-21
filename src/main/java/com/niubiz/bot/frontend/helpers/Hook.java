package com.niubiz.bot.frontend.helpers;

import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.utility.ConfigReader;
import com.niubiz.bot.frontend.utility.ExcelReader;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Hook {

	//private static LoginPageSteps lpe;
	private static GenerateWord generateWord = new GenerateWord();

	private final UtilsExcel ue = new UtilsExcel();

	public Hook() throws Throwable {
	}

	private void setData(int row, int cell, String result) throws Throwable {
		ExcelReader.writeCellValue(ue.EXCEL_DOC, ue.PAGE_SHEET1, row, cell, result);
	}
	private List<HashMap<String, String>> getDataInit() throws Throwable {
		return ExcelReader.data(ue.EXCEL_DOC, ue.PAGE_SHEET1);
	}

	private static final Logger logger = LogManager.getLogger(Hook.class);

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	private int stepNumber = 0;
	private List<PickleStepTestStep> testStepTitles;
	private List<HashMap<String, String>> data = getDataInit();

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser(Scenario scenario) throws IOException {
		generateWord.startUpWord(scenario.getName());
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@Before(order=2)
	public void describe(Scenario scenario) throws Throwable {
		String[] arrayScenarioName = scenario.getName().split("_");
		generateWord.setFila(Integer.parseInt(arrayScenarioName[0]));
		String CP = data.get(Integer.parseInt(arrayScenarioName[0])-1).get(ue.CP);
		String DESCRIPT = data.get(Integer.parseInt(arrayScenarioName[0])-1).get(ue.DESCRIPTION);
		generateWord.sendDescriptCP(CP,DESCRIPT);
		generateWord.sendBreak();
		gettestStepTitles(scenario);
	}
	private void gettestStepTitles(Scenario scenario) {
		try {
			// Get the delegate from the scenario
			Field delegate = scenario.getClass().getDeclaredField("delegate");
			delegate.setAccessible(true);
			TestCaseState testCaseState = (TestCaseState) delegate.get(scenario);

			// Get the test case from the delegate
			Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
			testCaseField.setAccessible(true);
			TestCase testCase = (TestCase) testCaseField.get(testCaseState);

			testStepTitles = testCase.getTestSteps()
					.stream()
					.filter(step -> step instanceof PickleStepTestStep)
					.map(step -> (PickleStepTestStep) step)
					.collect(Collectors.toList());

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}


	@BeforeStep
	public void printStep(Scenario scenario) {
		String nameStep = getScenarioStep(scenario);
		logger.info("Name Step: " + getScenarioStep(scenario));
		generateWord.setnameStep(nameStep);
		generateWord.sendText(generateWord.getnameStep());
		generateWord.sendBreak();
	}
	private String getScenarioStep(Scenario scenario) {
		String currentStepText = "Error: Step Text Unavailable";
		try {
			currentStepText = "Step #" + (stepNumber+1) + " " + testStepTitles.get(stepNumber).getStepText();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return currentStepText;
	}

	@AfterStep()
	public void img(Scenario scenario) throws IOException {
		if (!scenario.isFailed()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] sourcePath = FileUtils.readFileToByteArray(src);
			scenario.attach(sourcePath, "image/png", "");
			logger.info("Status de Scenario: " + scenario.getStatus());
			generateWord.addImageToWord(driver);
		}
		stepNumber++;
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void endStep(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			// take screenshot: aquí debemos añadir código para añadir a word algún error.
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.log("Captura de pantalla del error...");
			scenario.attach(sourcePath, "image/png", "");
			logger.info("Status de Scenario: " + scenario.getStatus());
			generateWord.addImageToWord(driver);
			generateWord.sendDescript("Estado: ERROR! - " + generateWord.getlogStep());

		} else if (!scenario.isFailed()) {
			generateWord.sendDescript("Estado: OK - " + generateWord.getlogStep());
		}
		generateWord.endToWord(String.valueOf(scenario.getStatus())); //CIERRA Y GUARDA EL ARCHIVO FINAL

		//Guarda resultados del excel
		//String scenarioName = scenario.getName();
		//String[] parts = scenarioName.split("_");
		//setData(Integer.parseInt(parts[0]), 51, String.valueOf(scenario.getStatus())); //Elegir bien la columna donde guardará los resultados
	}




}
