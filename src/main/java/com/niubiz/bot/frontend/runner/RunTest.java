package com.niubiz.bot.frontend.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import org.testng.annotations.Test;

@CucumberOptions(
		plugin = {
				"pretty"
				/*,"html:target/cucumber-reports/cucumber-pretty.html",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"*/
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
		},
		glue={
				"com.niubiz.bot.frontend.steps", //Ingresar donde se localizan los steps del feature
				"com.niubiz.bot.frontend.helpers"
		},
		monochrome = true,
		publish = false,
		snippets = SnippetType.CAMELCASE,
		features={"src/main/resources/features/"}, //Ingresar el feature o carpeta de features a ejecutar
		tags = "@acordeon_secciones"
	)

@Test
public class RunTest extends AbstractTestNGCucumberTests {
	/*@BeforeTest
	public static void test() throws IOException, InvalidFormatException{
		DataToFeature.overrideFeatureFiles("./src/main/resources/features/e2e/All2.feature");
	}*/
	//@AfterTest
}

