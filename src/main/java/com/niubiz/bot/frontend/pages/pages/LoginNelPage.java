package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.pages.objects.GenericNelObjects;
import com.niubiz.bot.frontend.pages.objects.InicioNelObjects;
import com.niubiz.bot.frontend.pages.objects.LoginNelObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.niubiz.bot.frontend.base.BaseClass;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.io.IOException;

public class LoginNelPage extends BaseClass{

	private static final Logger logger = LogManager.getLogger(LoginNelPage.class);
	private final LoginNelObjects nlo = new LoginNelObjects();
	private final InicioNelObjects ino = new InicioNelObjects();
	private final GenericNelObjects gno = new GenericNelObjects();
	private WebDriver driver;

	private Wait wait;

	// 2. Constructor of the page class:
	public LoginNelPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {

		//return driver.findElement(forgotPwdLink).isDisplayed();
		return true;
	}

	public void enterUserName(String username) throws IOException {
		typeText(driver, nlo.EMAIL, username);
	}

	public void enterPassword(String pwd) throws IOException {
		typeText(driver, nlo.PASSWORD, pwd);
	}

	public void clickOnLogin() throws IOException {
		click(driver,nlo.BTN_INGRESAR);
	}
	public boolean esperarLOAD_PAGE() {
		return objetoDesaparece(driver,gno.LOAD_PAGE);
	}

	public boolean esperarLoadingLogin() {
		return objetoDesaparece(driver, gno.LoadingLogin);
	}

	public void doLogin(String uss, String pwd, String prf) throws Exception {
		logger.info("[LOG] login con: " + uss + " y " + pwd + " con perfil " + prf);
		Thread.sleep(1000);
		if(elementoExistente(driver, nlo.BTN_OCULTA_ENCUESTA) && elementoExistente(driver,nlo.BTN_CERRAR_COOKIES)){
			//click(driver, nlo.BTN_CERRAR_COOKIES);
			//Thread.sleep(1000);
			click(driver, nlo.BTN_OCULTA_ENCUESTA);
		}
		Thread.sleep(1000);
		waitsElement(driver, nlo.EMAIL);
		typeText(driver, nlo.EMAIL, uss);
		Thread.sleep(1000);
		waitsElement(driver, nlo.PASSWORD);
		typeText(driver, nlo.PASSWORD, pwd);
		Thread.sleep(1000);
		waitsElementClickeable(driver, nlo.BTN_INGRESAR);
		click(driver, nlo.BTN_INGRESAR);
		Thread.sleep(1000);
		if(bolExistente(driver, gno.LOGO_NIUBIZ, 120)){
			generateWord.setlogStep("Usuario logueado Exitosamente");
		}
		else {
			generateWord.setlogStep("Logueo fallido!");
			Assert.fail();
		}
	}

	public void doLoginNiubiz(String uss, String pwd, String prf) throws Exception {
		logger.info("[LOG] login con: " + uss + " y " + pwd + " con perfil " + prf);
		String mainWindow = driver.getWindowHandle();
		waitsElement(driver, nlo.LOADER);
		generateWord.setlogStep(mainWindow);
		switchToLoginWindows(driver);
		Thread.sleep(1000);
		waitsElement(driver,nlo.EMAIL2);
		typeText(driver, nlo.EMAIL2, uss);
		Thread.sleep(1000);
		waitsElement(driver, nlo.BTN_SIGUIENTE);
		click(driver, nlo.BTN_SIGUIENTE);
		Thread.sleep(1000);
		waitsElement(driver, nlo.PASSWORD2);
		Thread.sleep(1000);
		typeText(driver, nlo.PASSWORD2, pwd);
		Thread.sleep(1000);
		waitsElement(driver,nlo.BTN_INICIAR_SESION);
		click(driver, nlo.BTN_INICIAR_SESION);
		Thread.sleep(1000);
		waitsElement(driver,nlo.BTN_SI);
		Thread.sleep(1000);
		click(driver,nlo.BTN_SI);
		switchToMainWindows(driver, mainWindow);
		waitsElement(driver,nlo.BTN_OCULTA_ENCUESTA);
		click(driver, nlo.BTN_OCULTA_ENCUESTA);
		logger.info("Ventana de encuesta minimizada");
		if(bolExistente(driver, gno.LOGO_NIUBIZ, 120)){
				generateWord.setlogStep("Usuario logueado Exitosamente");
			}
		else {
				generateWord.setlogStep("Logueo fallido!");
				Assert.fail();
			}
		}

}
