package com.niubiz.bot.frontend.helpers;

import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.utility.ConfigReader;
import com.niubiz.bot.frontend.utility.ExcelReader;
import com.niubiz.bot.frontend.utility.GenerateWord;
import com.niubiz.bot.frontend.utility.GenerateWordFinal;
import static com.niubiz.bot.frontend.utility.FileHelper.*;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Hook {

	private static GenerateWord generateWord = new GenerateWord();
	private static UtilsExcel ue = new UtilsExcel();

	public Hook() throws Throwable {
	}

	private static final Logger logger = LogManager.getLogger(Hook.class);
	private DriverFactory driverFactory;
	private WebDriver driver;
	private static ConfigReader configReader = new ConfigReader();
	Properties prop;
	private int stepNumber = 0;
	private List<PickleStepTestStep> testStepTitles;

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
	private String getScenarioStep(Scenario scenario) {
		String currentStepText = "Error: Step Text Unavailable";
		try {
			currentStepText = "Step #" + (stepNumber+1) + " " + testStepTitles.get(stepNumber).getStepText();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return currentStepText;
	}

	@BeforeAll
	public static void beforetest() throws IOException {
		ExcelReader.cargaExcel("excel/PLANTILLA_DATA.xlsx");
		GenerateWordFinal.startUpFinalWord();
	}

	@Before(order = 0)
	public void getProperty() {
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser(Scenario scenario) throws IOException {
		GenerateWord.startUpWord(scenario.getName());
		String browserName = prop.getProperty("hook.browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@Before(order=2)
	public void creaTabla(Scenario scenario) throws InterruptedException {
		GenerateWordFinal.ordenaNCP(Integer.parseInt(scenario.getName().split("_")[0]));
	}

	@Before(order=3)
	public void describe(Scenario scenario) throws Throwable {
		String[] arrayScenarioName = scenario.getName().split("_");
		generateWord.setFila(Integer.parseInt(arrayScenarioName[0]));
		String CP = ExcelReader.getCellValue(ue.PAGE_SHEET1,Integer.parseInt(arrayScenarioName[0]),ue.CP);
		String DESCRIPT = ExcelReader.getCellValue(ue.PAGE_SHEET1,Integer.parseInt(arrayScenarioName[0]),ue.DESCRIPTION);
		generateWord.sendCP(CP, DESCRIPT);
		gettestStepTitles(scenario);
	}

	@BeforeStep
	public void printStep(Scenario scenario) {
		String nameStep = getScenarioStep(scenario);
		generateWord.setnameStep(nameStep);
		generateWord.sendText(generateWord.getnameStep());
		generateWord.sendBreak();
	}

	@AfterStep()
	public void passStep(Scenario scenario) throws IOException {
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
	public void quitBrowser() throws InterruptedException {
		/*try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.findElement(By.xpath("//div[@class='sapUiHLayoutChildWrapper']//span[@class='sapUiIcon sapUiIconMirrorInRTL sapMBtnCustomIcon sapMBtnIcon sapMBtnIconLeft' and @role='presentation']")).click();
			driver.findElement(By.xpath("//div[@class='sapMSLITitleOnly' and .='Cerrar todo']")).click();
			driver.findElement(By.xpath("//span[@class='sapMBtnContent']//bdi[.='No']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			Thread.sleep(1000);
		}catch (Exception e){
			logger.warn("No se encontró opción 'Cerrar Todo'");
		}*/
		driver.quit();
	}

	@After(order = 1)
	public void failStep(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			//String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.log("Captura de pantalla tras el error...");
			scenario.attach(sourcePath, "image/png", "");
			logger.info("Status de Scenario: " + scenario.getStatus());
			generateWord.sendBreak();
			generateWord.sendDescript(generateWord.getlogStep(),true);
			generateWord.addImageToWord(driver);
		}
		ExcelReader.writeCellValue(ue.PAGE_SHEET1,generateWord.getFila(),ue.RESULTADO,String.valueOf(scenario.getStatus()));
		generateWord.endToWord(String.valueOf(scenario.getStatus())); //CIERRA Y GUARDA EL ARCHIVO INDIVIDUAL
	}
	@AfterAll
	public static void aftertest() throws Throwable {
		String carpetaguardado = configReader.lastfilecreate();
		ExcelReader.guardaExcel(carpetaguardado+"ExcelFile/");
		//WordMerge wm = new WordMerge(configReader.lastfilecreate()+"WordFile/");
		//wm.doMergeAll();
		GenerateWordFinal.endToFinalWord(carpetaguardado+"WordFile/");
		//actualizaHTML(carpetaguardado+"test-output/ReportHTML/Index.html");
	}
}
