package com.niubiz.bot.frontend.steps;

import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.objects.AdministrarUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.objects.CrearUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.pages.AdministrarUsuariosNelPage;
import com.niubiz.bot.frontend.pages.pages.CrearUsuariosNelPage;
import com.niubiz.bot.frontend.pages.pages.InicioNelPage;
import com.niubiz.bot.frontend.pages.pages.Utils;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.java.en.*;



public class CrearUsuariosNelSteps {
    private final UtilsExcel ue = new UtilsExcel();
    private CrearUsuariosNelPage cu_page = new CrearUsuariosNelPage(DriverFactory.getDriver());
    private AdministrarUsuariosNelPage au_page = new AdministrarUsuariosNelPage(DriverFactory.getDriver());
    private InicioNelPage inicio_page = new InicioNelPage(DriverFactory.getDriver());

    private CrearUsuariosNelObjects cuo = new CrearUsuariosNelObjects();
    private AdministrarUsuariosNelObjects auo = new AdministrarUsuariosNelObjects();
    private Utils utils=new Utils(DriverFactory.getDriver());
    protected static GenerateWord generateWord = new GenerateWord();
    public CrearUsuariosNelSteps() throws Throwable {
    }

    @Then("^el usuario valida que se muestre el título 'CREAR USUARIO'$")
    public void elUsuarioValidaTituloCrearUsuario() throws Throwable {
        cu_page.validaTituloCrearUsuario();
    }

    @Then("el usuario valida que se muestre el boton de retorno")
    public void elUsuarioValidaQueSeMuestreElBotonDeRetorno() throws Throwable{
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaExistenciaBotonRetorno(cuo.BTN_NIUBIZ_BACK_CREAR_USUARIO);
        }
        else {
            cu_page.validaExistenciaBotonRetorno(cuo.BTN_COMERCIO_BACK_CREAR_USUARIO);
        }
    }

    @Then("el usuario valida que se visualice las secciones INFORMACION DE USUARIO,RUCS&CODIGO y MODULOS")
    public void elUsuarioValidaQueSeVisualiceLasSeccionesINFORMACIONDEUSUARIORUCSCODIGOYMODULOS() throws Throwable {
        cu_page.validaExistenciaSeccionesCrearUsuario();
    }

    @Then("el usuario valida que se oculten los campos dentro de la sección desplegable")
    public void elUsuarioValidaQueSeOcultenLosCamposDentroDeLaSecciónDesplegable() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaAcordeonOcultaInformacionPerfilNiubiz();
        }
        else {
            cu_page.validaAcordeonOcultaInformacionPerfilComercio();
        }
    }

    @Then("el usuario valida que el botón GUARDAR se encuentre deshabilitado")
    public void elUsuarioValidaQueElBotónGUARDARSeEncuentreDeshabilitado() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validabExistenciayEstadoBotonGuardar(cuo.BTN_GUARDAR_DISABLED_NBZ, "GUARDAR");
        }
        else {
            cu_page.validabExistenciayEstadoBotonGuardar(cuo.BTN_GUARDAR_DISABLED, "Guardar");
        }
    }

    @Then("el usuario valida que el botón CANCELAR se encuentre habilitado en todo momento")
    public void elUsuarioValidaQueElBotónCANCELARSeEncuentreHabilitadoEnTodoMomento() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validabExistenciayEstadoBotonCancelar(cuo.BTN_CANCELAR_NBZ, "CANCELAR");
        }
        else {
            cu_page.validabExistenciayEstadoBotonCancelar(cuo.BTN_CANCELAR, "Cancelar");
        }
    }

    @Then("el usuario valida que el botón ATRAS  regrese al formulario ADMINISTRACION DE USUARIOS")
    public void elUsuarioValidaQueElBotónATRASRegreseAlFormularioADMINISTRACIONDEUSUARIOS() throws Throwable {
        cu_page.validaBotonAtrasRegresaAdmUsuarios();
    }

    @Then("el usuario valida el contenido de la seccion INFORMACION DE USUARIO")
    public void elUsuarioValidaElContenidoDeLaSeccionINFORMACIONDEUSUARIO() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validabCSSCamposSeccionPerfilNiubiz();
        }
        else {
            cu_page.validabCSSCamposSeccionPerfilComercio();
        }
    }

    @Then("el usuario valida que los campos sean obligatorios en la sección INFORMACION DE USUARIO")
    public void elUsuarioValidaQueLosCamposSeanObligatoriosEnLaSecciónINFORMACIONDEUSUARIO() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaCamposObligatoriosPerfilNiubiz();
        }
        else {
            cu_page.validaCamposObligatoriosPerfilComercio();
        }
    }

    @Then("el usuario valida que se muestre el mensaje de error INGRESE UN CORREO VALIDO")
    public void elUsuarioValidaQueSeMuestreElMensajeDeErrorINGRESEUNCORREOVALIDO() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaMinimoCaracteresCorreoUsuario(cuo.TXTBOX_CORREO_ELECTRONICO);
        }
        else {
            cu_page.validaMinimoCaracteresCorreoUsuario(cuo.TXTBOX_CORREO_USUARIO);
        }

    }

    @Then("el usuario valida que el sistema no deje ingresar mas de '60' caracteres en el campo correo electronico")
    public void elUsuarioValidaQueElSistemaNoDejeIngresarMasDeCaracteresEnElCampoCorreoElectronico() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaMaximoCaracteresCorreoUsuario(cuo.TXTBOX_CORREO_ELECTRONICO);
        }
        else {
            cu_page.validaMaximoCaracteresCorreoUsuario(cuo.TXTBOX_CORREO_USUARIO);
        }
    }

    @Then("el usuario valida que el sistema no deje acepte tildes el campo correo electronico")
    public void elUsuarioValidaQueElSistemaNoDejeAcepteTildesElCampoCorreoElectronico() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaTildeCorreoUsuario(cuo.TXTBOX_CORREO_ELECTRONICO);
        }
        else {
            cu_page.validaTildeCorreoUsuario(cuo.TXTBOX_CORREO_USUARIO);
        }
    }

    @Then("el usuario valida que el sistema no permita insertar un caracter especial antes del @ en el campo correo electronico")
    public void elUsuarioValidaQueElSistemaNoPermitaInsertarUnCaracterEspecialAntesDelEnElCampoCorreoElectronico() throws Throwable{
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaCaracteresEspecialesCorreoUsuarioNiubiz();
        }
        else {
            cu_page.validaCaracteresEspecialesCorreoUsuarioComercio();
        }
    }

    @Then("el usuario valida que el sistema permita insertar un caracter especial despues del @ en el campo correo electronico")
    public void elUsuarioValidaQueElSistemaPermitaInsertarUnCaracterEspecialDespuesDelEnElCampoCorreoElectronico() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaCaracteresEspecialesDespuesArrobaNiubiz();
        }
        else {
            cu_page.validaCaracteresEspecialesDespuesArrobaComercio();
        }
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VALIDO bajo el campo NOMBRES")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVALIDOBajoElCampoNOMBRES() throws Throwable {
        cu_page.validaMinimoCaracteresCamposNombresyApellidos(cuo.TXTBOX_NOMBRES,"a1");
    }

    @Then("el usuario valida que el sistema no le permita ingresar mas de '30' caracteres en el campo NOMBRES")
    public void elUsuarioValidaQueElSistemaNoLePermitaIngresarMasDeCaracteresEnElCampoNOMBRES() throws Throwable {
        cu_page.validaMaximoCaracteresCamposNombresyApellidos(cuo.TXTBOX_NOMBRES,"LjhzCQkmpiXFrApLLADEJGifChzPhktLtbn");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresEspeciales() throws Throwable {
        cu_page.validaMCaracteresEspecialesCampos(cuo.TXTBOX_NOMBRES,"_?*TEST_*/");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresNuméricos() throws Throwable {
        cu_page.validaMCaracteresNumericosCampos(cuo.TXTBOX_NOMBRES,"123456");
    }

    @Then("el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto")
    public void elUsuarioValidaQueElSistemaNoMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresTipoTexto() throws Throwable {
        cu_page.validaMCaracteresTipoTextoCampos(cuo.TXTBOX_NOMBRES,"Test Automation");
    }

    @Then("el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO PATERNO")
    public void elUsuarioValidaQueElSistemaNoPermitaIngresarMasDeCaracteresAlfabéticosEnElCampoAPELLIDOPATERNO() throws Throwable {
        cu_page.validaMaximoCaracteresCamposNombresyApellidos(cuo.TXTBOX_APELLIDO_PATERNO,"LjhzCQkmpiXFrApLLADEJGifChzPhktLtbn");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO PATERNO")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresEspecialesEnElCampoAPELLIDOPATERNO() throws Throwable {
        cu_page.validaMCaracteresEspecialesCampos(cuo.TXTBOX_APELLIDO_PATERNO,"_?*TEST_*/");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO PATERNO")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresNuméricosEnElCampoAPELLIDOPATERNO() throws Throwable {
        cu_page.validaMCaracteresNumericosCampos(cuo.TXTBOX_APELLIDO_PATERNO,"123456");
    }

    @Then("el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO PATERNO")
    public void elUsuarioValidaQueElSistemaNoMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresTipoTextoEnElCampoAPELLIDOPATERNO() throws Throwable {
        cu_page.validaMCaracteresTipoTextoCampos(cuo.TXTBOX_APELLIDO_PATERNO, "Test Automation");
    }

    @Then("el usuario valida que el sistema no permita ingresar mas de '30' caracteres alfabéticos en el campo APELLIDO MATERNO")
    public void elUsuarioValidaQueElSistemaNoPermitaIngresarMasDeCaracteresAlfabéticosEnElCampoAPELLIDOMATERNO() throws Throwable {
        cu_page.validaMaximoCaracteresCamposNombresyApellidos(cuo.TXTBOX_APELLIDO_MATERNO,"LjhzCQkmpiXFrApLLADEJGifChzPhktLtbn");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres especiales en el campo APELLIDO MATERNO")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresEspecialesEnElCampoAPELLIDOMATERNO() throws Throwable {
        cu_page.validaMCaracteresEspecialesCampos(cuo.TXTBOX_APELLIDO_MATERNO,"_?*TEST_*/");
    }

    @Then("el usuario valida que el sistema muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres numéricos en el campo APELLIDO MATERNO")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresNuméricosEnElCampoAPELLIDOMATERNO() throws Throwable {
        cu_page.validaMCaracteresNumericosCampos(cuo.TXTBOX_APELLIDO_MATERNO,"123456");
    }

    @Then("el usuario valida que el sistema no muestre el mensaje TEXTO NO VÁLIDO al ingresar caracteres tipo texto en el campo APELLIDO MATERNO")
    public void elUsuarioValidaQueElSistemaNoMuestreElMensajeTEXTONOVÁLIDOAlIngresarCaracteresTipoTextoEnElCampoAPELLIDOMATERNO() throws Throwable {
        cu_page.validaMCaracteresTipoTextoCampos(cuo.TXTBOX_APELLIDO_MATERNO, "Test Automation");
    }

    @Then("el usuario valida que el sistema muestre el mensaje CAMPO OBLIGATORIO debajo de cada campo al seleccionar el botón SIGUIENTE")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeCAMPOOBLIGATORIODebajoDeCadaCampoAlSeleccionarElBotónSIGUIENTE() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaMensajeCamposObligatoriosBotonSiguientePerfilNiubiz();
        }
        else {
            cu_page.validaMensajeCamposObligatoriosBotonSiguientePerfilComercio();
        }

    }

    @Then("el usuario valida que el sistema muestre el siguiente modulo al llenar  los campos e ingresar al boton SIGUIENTE")
    public void elUsuarioValidaQueElSistemaMuestreElSiguienteModuloAlLlenarLosCamposEIngresarAlBotonSIGUIENTE() throws Throwable {
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        if (profile.equals("Niubiz_MesaDeServicio")) {
            cu_page.validaBotonsiguienteHabiliteModuloRUCSyCodigosPerfilNiubiz();
        }
        else {
            cu_page.validaBotonsiguienteHabiliteModuloRUCSyCodigosPerfilComercio();
        }
    }

    @Then("el usuario valida que el cursor se mueva al primer campo dado que los datos estan incompletos y no se habilita la siguiente sección")
    public void elUsuarioValidaQueElCursorSeMuevaAlPrimerCampoDadoQueLosDatosEstanIncompletosYNoSeHabilitaLaSiguienteSección() throws Throwable {
        cu_page.validaNoIngreseSiguienteSeccionconDatosincompletosComercio();
    }

    @Then("el usuario valida que el sistema muestre el mensaje DEBESMARCARALMENOSUNRUC al no ingresar un RUC en la sección RUCS Y CODIGOS")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeDEBESMARCARALMENOSUNRUCAlNoIngresarUnRUCEnLaSecciónRUCSYCODIGOS() throws Throwable {
        cu_page.validarAlertaIngresarUnRUCParaPasarSecciónModulosComercio();
    }

    @Then("el usuario valida que el sistema ya no muestre el mensaje DEBES MARCAR AL MENOS UN RUC al ingresar un RUC en la sección RUCS Y CODIGOS")
    public void elUsuarioValidaQueElSistemaYaNoMuestreElMensajeDEBESMARCARALMENOSUNRUCAlIngresarUnRUCEnLaSecciónRUCSYCODIGOS() throws Throwable {
        cu_page.validarAlertaDesapareceAlIngresarUnRUCParaPasarSecciónModulosComercio();
    }

    @And("el usuario llena los datos correctamente de la sección 'INFORMACION DE USUARIO'")
    public void elUsuarioLlenaLosDatosCorrectamenteDeLaSecciónINFORMACIONDEUSUARIO() throws Throwable {
        cu_page.llenaCamposInfoUsuarioPerfilComercio();
    }

    @Then("el usuario valida que el sistema muestre el mensaje 'SELECCIONA EL RUC Y CODIGOS A LOS CUALES QUIERES QEU TENGA ACCESO EL USUARIO'")
    public void elUsuarioValidaQueElSistemaMuestreElMensajeSELECCIONAELRUCYCODIGOSALOSCUALESQUIERESQUETENGAACCESOELUSUARIO() throws Throwable {
        cu_page.validaExistenciaSubtituloRucsYCodigos();
    }

    @Then("el usuario valida que el sistema muestre una lista con RUCS y los botones TODOS Y SELECCIONAR")
    public void elUsuarioValidaQueElSistemaMuestreUnaListaConRUCSYLosBotonesTODOSYSELECCIONAR() throws Throwable {
        cu_page.validaExistenciaListaRucsyBotonesTodosySeleccionar();
    }

    @And("el usuario selecciona un RUC de la sección 'RUCS Y CODIGOS'")
    public void elUsuarioSeleccionaUnRUCDeLaSecciónRUCSYCODIGOS() throws Throwable {
        cu_page.clickCheckBoxRUCparaSeccionRUCSyCODIGOS();
    }

    @Then("el usuario valida que el sistema muestre habilitado los botones 'TODOS Y SELECCIONAR'")
    public void elUsuarioValidaQueElSistemaMuestreHabilitadoLosBotonesTODOSYSELECCIONAR() throws Throwable {
        cu_page.validaBotonesTODOSySELECCIONAR();
    }

    @Then("el usuario valida que el sistema muestre un popup que contenta un titulo y subtitulo al interactuar con el botón 'SELECCIONAR'")
    public void elUsuarioValidaQueElSistemaMuestreUnPopupQueContentaUnTituloYSubtituloAlInteractuarConElBotónSELECCIONAR() throws Throwable {
        cu_page.validaPopUpBotonSeleccionar();
    }


    @Then("el usuario valida que el sistema actualice la lista de comercios al buscar por codigo")
    public void elUsuarioValidaQueElSistemaActualiceLaListaDeComerciosAlBuscarPorCodigo() throws Throwable {
        cu_page.validaActualizacionListaBusquedaPorCodigo();
    }

    @Then("el usuario valida que el sistema actualice la grilla de la tabla con el codigo de comercio seleccionado")
    public void elUsuarioValidaQueElSistemaActualiceLaGrillaDeLaTablaConElCodigoDeComercioSeleccionado() throws Throwable {
        cu_page.validaActualizacionGrillaCodigoComercioSeleccionado();
    }

    @Then("el usuario valida que el sistema muestre todos los codigos en la tabla de codigos seleccionados")
    public void elUsuarioValidaQueElSistemaMuestreTodosLosCodigosEnLaTablaDeCodigosSeleccionados() throws Throwable {
        cu_page.validaRegistrosTablaALSeleccionarTodos();
    }

    @Then("el usuario valida que el sistema muestre deshabilitado el boton ACEPTAR al no seleccionar algún comercio")
    public void elUsuarioValidaQueElSistemaMuestreDeshabilitadoElBotonACEPTARAlNoSeleccionarAlgúnComercio() throws Throwable {
        cu_page.validaBotonAceptarDeshabilitadoPopUpBusquedaCodigos();
    }

    @Then("el usuario valida que el sistema muestre habilitado el boton ACEPTAR al seleccionar un comercio")
    public void elUsuarioValidaQueElSistemaMuestreHabilitadoElBotonACEPTARAlSeleccionarUnComercio() throws Throwable {
        cu_page.validaBotonAceptarHabilitadoPopUpBusquedaCodigos();
    }

    @Then("el usuario valida que el sistema muestre la cantidad de codigos marcados al seleccionar el boton ACEPTAR")
    public void elUsuarioValidaQueElSistemaMuestreLaCantidadDeCodigosMarcadosAlSeleccionarElBotonACEPTAR() throws Throwable {
        cu_page.validaMensajeLuegoDeSeleccionarCodigos();
    }

    @And("el usuario selecciona el codigo de comercio a los que dara acceso")
    public void elUsuarioSeleccionaElCodigoDeComercioALosQueDaraAcceso() throws Throwable {
        cu_page.seleccionaCodigosDeAcceso();
    }

    @Then("el usuario valida que el sistema muestre el botón SELECCIONAR de color naranja")
    public void elUsuarioValidaQueElSistemaMuestreElBotónSELECCIONARDeColorNaranja() throws Throwable {
        cu_page.validaBotonSeleccionarColorNaranja();
    }

    @And("el usuario regresa a la sección INFORMACION DE USUARIO y modifica un campo")
    public void elUsuarioRegresaALaSecciónINFORMACIONDEUSUARIOYModificaUnCampo() throws Throwable {
        cu_page.retornaAlaSeccionInformacionUsuariosyModificaCampo();
    }

    @Then("el usuario valida que el sistema no bloquee el pasar a la siguiente sección")
    public void elUsuarioValidaQueElSistemaNoBloqueeElPasarALaSiguienteSección() throws Throwable {
        cu_page.validaExistenciaFormularioRUCSyCODIGOS();
    }
}
