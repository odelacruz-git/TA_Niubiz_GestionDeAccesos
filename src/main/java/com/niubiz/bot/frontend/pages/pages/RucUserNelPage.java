package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.pages.objects.AdministrarUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.objects.GenericNelObjects;
import com.niubiz.bot.frontend.pages.objects.InicioNelObjects;
import com.niubiz.bot.frontend.pages.objects.RucUserNelObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class RucUserNelPage extends BaseClass {
    private static final Logger logger = LogManager.getLogger(RucUserNelPage.class);
    private final InicioNelObjects ino = new InicioNelObjects();

    private final AdministrarUsuariosNelObjects auo = new AdministrarUsuariosNelObjects();

    private final RucUserNelObjects rno = new RucUserNelObjects();
    private final GenericNelObjects gno = new GenericNelObjects();
    private final WebDriver driver;

    // Constructor of the page class:
    public RucUserNelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean esperarLOAD_PAGE() {
        return objetoDesaparece(driver,gno.LOAD_PAGE);
    }
    public boolean loadingPage() {
        return elementLoading(driver,gno.LOAD_PAGE);
    }

    public void inputRUC(String ruc) throws Exception {
        generateWord.setlogStep("El RUC ingresado es: " + ruc);
        waitsElement(driver, rno.TBX_RUC);
        click(driver, rno.TBX_RUC);
        typeText(driver, rno.TBX_RUC, ruc);
        waitsElementClickeable(driver, rno.LIST_RUC(ruc));
        click(driver, rno.LIST_RUC(ruc));
        waitsElementClickeable(driver, rno.BTN_INGRESAR_POR_RUC);
        click(driver, rno.BTN_INGRESAR_POR_RUC);
    }



}
