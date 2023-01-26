package com.niubiz.bot.frontend.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				/*,"html:target/cucumber-reports/cucumber-pretty.html",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"*/
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				},
		glue = {"com.niubiz.bot.frontend.steps", //Ingresar donde se localizan los steps del feature
				"com.niubiz.bot.frontend.helpers"},
		monochrome = true,
		publish = false,
		snippets = CucumberOptions.SnippetType.CAMELCASE,

		features = { "src/main/resources/features/" } //Ingresar el feature o carpeta de features a ejecutar
		,tags = "@seccion_modulos"

)

public class RunParallel extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}