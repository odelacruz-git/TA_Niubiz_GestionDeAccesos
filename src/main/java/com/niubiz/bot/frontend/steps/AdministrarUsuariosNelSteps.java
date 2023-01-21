package com.niubiz.bot.frontend.steps;

import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.objects.AdministrarUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.pages.AdministrarUsuariosNelPage;
import com.niubiz.bot.frontend.pages.pages.InicioNelPage;
import com.niubiz.bot.frontend.pages.pages.Utils;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class AdministrarUsuariosNelSteps {
    private final UtilsExcel ue = new UtilsExcel();
    private AdministrarUsuariosNelPage au_page = new AdministrarUsuariosNelPage(DriverFactory.getDriver());
    private AdministrarUsuariosNelObjects auo = new AdministrarUsuariosNelObjects();
    private Utils utils=new Utils(DriverFactory.getDriver());
    protected static GenerateWord generateWord = new GenerateWord();
    public AdministrarUsuariosNelSteps() throws Throwable {
    }

    @Then("^el usuario valida que se muestre el Botón 'DESCARGAR REPORTE'$")
    public void elUsuarioValidaQueSeMuestreElBotónDESCARGARREPORTE() throws Throwable {
        au_page.validabExistenciaBotonDescargarReporte();
    }

    @When("^el usuario valida que se encuentre en la pagina 'Administrar Usuarios'")
    public void elUsuarioValidaQueSeEncuentreEnLaPaginaAdministrarUsuarios() throws Throwable {
        au_page.validaPresenciaPaginaAdministrarUsuario();
    }

    @Then("^el usuario valida que NO se muestre el Botón 'DESCARGAR REPORTE'")
    public void elUsuarioValidaQueNOSeMuestreElBotónDESCARGARREPORTE() throws Throwable{
        au_page.validaInexistenciaBotonDescargarReporte();
    }

    @Then("el usuario valida que se muestre el Botón 'CREAR USUARIO'")
    public void elUsuarioValidaQueSeMuestreElBotónCREARUSUARIO() throws Throwable {
        au_page.validabExistenciaBotonCrearUsuario();
    }

    @And("el usuario ingresa a la opción 'CREAR NUEVO USUARIO'")
    public void elUsuarioIngresaALaOpciónCrearNuevoUsuario() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            au_page.clickCrearUsuario(auo.BTN_NIUBIZ_CREAR_USUARIO);
        }
        else {
            au_page.clickCrearUsuario(auo.BTN_COMERCIO_CREAR_USUARIO);
        }
    }
    @Then("el usuario valida que se muestre el título 'ADMINISTRAR USUARIOS'")
    public void elUsuarioValidaQueSeMuestreElTítuloADMINISTRARUSUARIOS() throws Throwable {
        au_page.validabExistenciaTituloAdministrarUsuario();
    }

    @Then("el usuario valida que se muestre el placeholder en la barra de busqueda")
    public void elUsuarioValidaQueSeMuestreElPlaceholderEnLaBarraDeBusqueda() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            au_page.validaExistenciaPlaceholder2("Nombres o apellidos");
        }
        else {
            au_page.validaExistenciaPlaceholder("Buscar por nombres y apellidos");
        }

    }

    @Then("el usuario valida que se muestre datos de 'MI USUARIO'")
    public void elUsuarioValidaQueSeMuestreDatosDeMIUSUARIO() throws Throwable{
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Comercio_Administrador")) {
            au_page.validaExistenciaDatosMIUSUARIO(auo.CADM_MI_USUARIO);
        }
        else if (profile.equals("Comercio_AccesoTotal")){
            au_page.validaExistenciaDatosMIUSUARIO(auo.CAT_MI_USUARIO);
        }
        else if (profile.equals("Comercio_AccesoPersonalizado")) {
            au_page.validaExistenciaDatosMIUSUARIO(auo.CAP_MI_USUARIO);
        }
    }

    @Then("el usuario valida que se muestre datos de DNI y EMAIL")
    public void elUsuarioValidaQueSeMuestreDatosDeDNIYEMAIL() throws Throwable {
        String email = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.USER);
        au_page.validaExistenciaDNIeEMAIL(email);
    }

    @And("el usuario ingresa a editar un usuario en el icono lapiz")
    public void elUsuarioIngresaAEditarUnUsuarioEnElIconoLapiz() throws Throwable {
        au_page.clickEditarUsuario(auo.BTN_ICON_LAPIZ);
    }

    @Then("el usuario valida que el botón CANCELAR se encuentre habilitado")
    public void elUsuarioValidaQueElBotónCANCELARSeEncuentreHabilitado() throws Throwable{
        au_page.validabExistenciayEstadoBotonCancelar(auo.BTN_CANCELAR, "Cancelar");
    }
}
