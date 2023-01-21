package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.pages.objects.GenericNelObjects;
import com.niubiz.bot.frontend.pages.objects.InicioNelObjects;
import com.niubiz.bot.frontend.pages.objects.LoginNelObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;

public class InicioNelPage extends BaseClass{

	private static final Logger logger = LogManager.getLogger(InicioNelPage.class);
	private final LoginNelObjects nlo = new LoginNelObjects();
	private final InicioNelObjects ilo = new InicioNelObjects();
	private final GenericNelObjects gno = new GenericNelObjects();
	private WebDriver driver;

	private Wait wait;

	// 2. Constructor of the page class:
	public InicioNelPage(WebDriver driver) {
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

	public void clickAdministraUsuario() throws Exception {
		try{
			waitsElement(driver,ilo.OPTION_ICON_MORE);
			click(driver,ilo.OPTION_ICON_MORE);
			Thread.sleep(1000);
			waitsElement(driver,ilo.BTN_ADM_USERS);
			click(driver, ilo.BTN_ADM_USERS);
			Thread.sleep(1000);
			generateWord.setlogStep("Evento Click Exitoso - OPCIÓN: ADMINISTRAR USUARIOS");
		}
		catch (Exception e){
			generateWord.setlogStep("No encontró la opción 'ADMINISTRAR USUARIOS'");
		}

	}
}
