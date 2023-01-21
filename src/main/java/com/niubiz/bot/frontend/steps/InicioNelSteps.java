package com.niubiz.bot.frontend.steps;

import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.pages.InicioNelPage;
import com.niubiz.bot.frontend.pages.pages.LoginNelPage;
import com.niubiz.bot.frontend.pages.pages.Utils;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.java.en.When;

public class InicioNelSteps {
    private final UtilsExcel ue = new UtilsExcel();
    private final InicioNelPage inicio_page = new InicioNelPage(DriverFactory.getDriver());
    private Utils utils=new Utils(DriverFactory.getDriver());

    protected static GenerateWord generateWord = new GenerateWord();
    public InicioNelSteps() throws Throwable {
    }
    @When("^el usuario ubica los tres puntos e ingresa a la opción 'Administrar usuarios'$")
    public void elUsuarioUbicaLostresPuntoseIngresaOpcionAdministrarUsuarios() throws Throwable {
        inicio_page.clickAdministraUsuario();
    }

}
