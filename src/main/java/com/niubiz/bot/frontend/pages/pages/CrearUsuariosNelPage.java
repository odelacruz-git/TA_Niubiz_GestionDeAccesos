package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.objects.AdministrarUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.objects.CrearUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.objects.GenericNelObjects;
import com.niubiz.bot.frontend.pages.objects.InicioNelObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CrearUsuariosNelPage extends BaseClass {
    private static final Logger logger = LogManager.getLogger(CrearUsuariosNelPage.class);
    private final InicioNelObjects ino = new InicioNelObjects();
    private final AdministrarUsuariosNelObjects auo = new AdministrarUsuariosNelObjects();
    private final UtilsExcel ue = new UtilsExcel();
    private Utils utils = new Utils(DriverFactory.getDriver());
    private final CrearUsuariosNelObjects cuo = new CrearUsuariosNelObjects();
    private final GenericNelObjects gno = new GenericNelObjects();
    private final WebDriver driver;

    // Constructor of the page class:
    public CrearUsuariosNelPage(WebDriver driver) throws Throwable {
        this.driver = driver;
    }

    public boolean esperarLOAD_PAGE() {
        return objetoDesaparece(driver, gno.LOAD_PAGE);
    }

    public boolean loadingPage() {
        return elementLoading(driver, gno.LOAD_PAGE);
    }

    public void validaTituloCrearUsuario() throws Exception {
        if (bolExistente(driver, cuo.TXT_TITULO_CREAR_USUARIO, 10)) {
            generateWord.setlogStep("El titulo CREAR USUARIO se muestra en pantalla");
        } else {
            generateWord.setlogStep("El titulo CREAR USUARIO no se muestra en pantalla");
            Assert.fail();
        }
    }

    public void validaExistenciaBotonRetorno(By locator) throws Exception {
        if (elementoExistente(driver, locator)) {
            generateWord.setlogStep("Validación exitosa, el botón de retorno al crear nuevo usuario se muestra correctamente");
        } else {
            generateWord.setlogStep("Validación fallida, el botón de retorno al crear nuevo usuario no se muestran");
            org.testng.Assert.fail();
        }
    }

    public void validaExistenciaSeccionesCrearUsuario() throws Exception {

        if (elementoExistentePresente(driver, cuo.BTN_INFORMACION_USUARIO) && elementoExistentePresente(driver, cuo.BTN_RUCS_CODIGOS) && elementoExistentePresente(driver, cuo.BTN_MODULOS)) {
            if (getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "font-size").equals("13px") &&
                    getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "color").equals("rgba(33, 33, 33, 1)") &&
                    getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "font-family").equals("Font-Bold")) { //#212121
                generateWord.setlogStep("La sección INFORMACION DE USUARIO se encuenta visible, las propiedades CSS de estilo coinciden");
            } else {
                generateWord.setlogStep("La sección INFORMACION DE USUARIO no cumple con las propiedades de estilo CSS - " + "\n" +
                        getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "font-size") + "\n" +
                        getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "color") + "\n" +
                        getValuesCss(driver, cuo.BTN_INFORMACION_USUARIO, "font-family").equals("Font-Bold"));
                Assert.fail();
            }
            if (getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "font-size").equals("13px") &&
                    getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "color").equals("rgba(187, 187, 187, 1)") && //#BBB
                    getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "font-family").equals("Font-Bold")) {
                generateWord.setlogStep("La sección RUCS Y CODIGOS se encuenta visible, las propiedades CSS de estilo coinciden");
            } else {
                generateWord.setlogStep("La sección RUCS Y CODIGOS no cumple con las propiedades de estilo CSS - " + "\n" +
                        getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "font-size") + "\n" +
                        getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "color") + "\n" +
                        getValuesCss(driver, cuo.BTN_RUCS_CODIGOS, "font-family"));
                Assert.fail();
            }
            if (getValuesCss(driver, cuo.BTN_MODULOS, "font-size").equals("13px") &&
                    getValuesCss(driver, cuo.BTN_MODULOS, "color").equals("rgba(187, 187, 187, 1)") &&
                    getValuesCss(driver, cuo.BTN_MODULOS, "font-family").equals("Font-Bold")) {
                generateWord.setlogStep("La sección MÓDULOS se encuenta visible, las propiedades CSS de estilo coinciden");
            } else {
                generateWord.setlogStep("La sección MÓDULOS no cumple con las propiedades de estilo CSS - " + "\n" +
                        getValuesCss(driver, cuo.BTN_MODULOS, "font-size") + "\n" +
                        getValuesCss(driver, cuo.BTN_MODULOS, "color") + "\n" +
                        getValuesCss(driver, cuo.BTN_MODULOS, "font-family").equals("Font-Bold"));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Al menos un elemento de las secciones de CREAR NUEVO USUARIO no existe");
            Assert.fail();
        }


    }

    public void validaAcordeonOcultaInformacionPerfilComercio() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        System.out.println("RUC: " + ruc);
        if (elementoExistente(driver, cuo.FORM_ACORDEON_INFO_USUARIOS)) {
            generateWord.setlogStep("Los campos de la sección SI se muestran");
            waitsElement(driver, cuo.TXTBOX_CORREO_USUARIO);
            typeText(driver, cuo.TXTBOX_CORREO_USUARIO, "testing_automation@niubiz.com");
            waitsElement(driver, cuo.TXTBOX_NOMBRES);
            typeText(driver, cuo.TXTBOX_NOMBRES, "TESTING");
            waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
            typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "AUTOMATION");
            waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
            typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "AUTOMATION");
            waitsElement(driver, cuo.LISTBOX_TIPO_DOC);
            click(driver, cuo.LISTBOX_TIPO_DOC);
            waitsElement(driver, cuo.OPTION_DNI);
            click(driver, cuo.OPTION_DNI);
            waitsElement(driver, cuo.TXTBOX_DOCUMENTO);
            typeText(driver, cuo.TXTBOX_DOCUMENTO, "12345678");
            waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
            click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
            if (!elementoExistente(driver, cuo.FORM_ACORDEON_INFO_USUARIOS) && elementoExistente(driver, cuo.FORM_ACORDEON_RUCS_CODIGOS)) {
                generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, NO se muestran, el elemento acordeón funciona correctamente");
                generateWord.setlogStep("Los campos de la sección RUCS Y CODIGOS, SI se muestran, el elemento acordeón funciona correctamente");
                waitsElement(driver, cuo.CHECKBOX_RUCS_CODIGOS(ruc));
                click(driver, cuo.CHECKBOX_RUCS_CODIGOS(ruc));
                waitsElement(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
                click(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
                if (!elementoExistente(driver, cuo.FORM_ACORDEON_RUCS_CODIGOS) && elementoExistente(driver, cuo.FORM_ACORDEON_MODULOS)) {
                    generateWord.setlogStep("Los campos de la sección RUCS Y CODIGOS, NO se muestran, el elemento acordeón funciona correctamente");
                    generateWord.setlogStep("Los campos de la MODULOS, SI se muestran, el elemento acordeón funciona correctamente");
                    waitsElement(driver, cuo.BTN_SIGUIENTE_MODULOS);
                    click(driver, cuo.BTN_SIGUIENTE_MODULOS);
                    if (!elementoExistente(driver, cuo.FORM_ACORDEON_MODULOS)) {
                        generateWord.setlogStep("Los campos de la sección MODULOS, NO se muestran, el elemento acordeón funciona correctamente");
                        generateWord.setlogStep("Las secciones con desplegables funcionan correctamente");
                    } else {
                        generateWord.setlogStep("Los campos de la sección MODULOS, se siguen mostrando, no se oculto la información del desplegable");
                        generateWord.setlogStep("Las secciones con desplegables NO funcionan correctamente");
                        Assert.fail();
                    }
                } else {
                    generateWord.setlogStep("Los campos de la sección RUCS Y CODIGOS, SI se muestran, el elemento acordeón NO funciona correctamente");
                    generateWord.setlogStep("Los campos de la sección MODULOS, NO se muestran, el elemento acordeón NO funciona correctamente");
                    Assert.fail();
                }
            } else {
                generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, SI se muestran, el elemento acordeón NO funciona correctamente");
                generateWord.setlogStep("Los campos de la sección RUCS Y CODIGOS, NO se muestran, el elemento acordeón NO funciona correctamente");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no se muestran");
            Assert.fail();
        }
    }

    public void validaAcordeonOcultaInformacionPerfilNiubiz() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        System.out.println("RUC: " + ruc);
        if (elementoExistente(driver, cuo.FORM_ACORDEON_INFO_USUARIOS)) {
            generateWord.setlogStep("Los campos de la sección SI se muestran");
            waitsElement(driver, cuo.TXTBOX_CORREO_USUARIO);
            typeText(driver, cuo.TXTBOX_CORREO_USUARIO, "testing_automation@niubiz.com");
            waitsElement(driver, cuo.TXTBOX_NOMBRES);
            typeText(driver, cuo.TXTBOX_NOMBRES, "TESTING");
            waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
            typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "AUTOMATION");
            waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
            typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "AUTOMATION");
            waitsElement(driver, cuo.LISTBOX_AREA);
            click(driver, cuo.LISTBOX_AREA);
            typeText(driver, cuo.LISTBOX_AREA, "CAPITAL HUMANO");
            waitsElement(driver, cuo.OPTION_LIST_AREA);
            click(driver, cuo.OPTION_LIST_AREA);
            waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
            click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
            if (!elementoExistente(driver, cuo.FORM_ACORDEON_INFO_USUARIOS) && elementoExistente(driver, cuo.FORM_ACORDEON_ASIGNACION_PERFIL)) {
                generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, NO se muestran, el elemento acordeón funciona correctamente");
                generateWord.setlogStep("Los campos de la sección ASIGNACION DE PERFIL, SI se muestran, el elemento acordeón funciona correctamente");
                waitsElement(driver, cuo.BTN_ASIGNACION_PERFIL);
                click(driver, cuo.BTN_ASIGNACION_PERFIL);
                if (!elementoExistente(driver, cuo.FORM_ACORDEON_ASIGNACION_PERFIL)) {
                    generateWord.setlogStep("Los campos de la sección ASIGNACION PERFIL, NO se muestran, el elemento acordeón funciona correctamente");
                    generateWord.setlogStep("Las secciones con desplegables funcionan correctamente");
                } else {
                    generateWord.setlogStep("Los campos de la sección ASIGNACION DE PERFIL, SI se muestran, el elemento acordeón NO funciona correctamente");
                    generateWord.setlogStep("Las secciones con desplegables NO funcionan correctamente");
                    Assert.fail();
                }
            } else {
                generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, SI se muestran, el elemento acordeón NO funciona correctamente");
                generateWord.setlogStep("Los campos de la sección ASIGNACION DE PERFIL, NO se muestran, el elemento acordeón NO funciona correctamente");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, NO se muestran");
            Assert.fail();
        }
    }

    public void validabExistenciayEstadoBotonGuardar(By locator, String textInButton) throws Exception {
        waitsElement(driver, locator);
        if (bolExistente(driver, locator, 10)) {
            if (getValuesCss(driver, locator, "background-color").equals("rgba(211, 211, 211, 1)") &&
                    getValuesCss(driver, locator, "color").equals("rgba(255, 255, 255, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, locator, "border-radius").equals("40px") &&
                    getValuesCss(driver, locator, "font-size").equals("13px") &&
                    getText(driver, locator).equals(textInButton)) {
                generateWord.setlogStep("El botón GUARDAR existe y se encuentra DESHABILITADO, las propiedades de estilo CSS coinciden");
            } else {
                generateWord.setlogStep("El botón GUARDAR existe y se encuentra HABILITADO, las propiedades de estilo CSS NO coinciden - " + "\n" +
                        getValuesCss(driver, locator, "background-color") + "\n" +
                        getValuesCss(driver, locator, "color") + "\n" + // Texto blanco:  #212121
                        getValuesCss(driver, locator, "border-radius") + "\n" +
                        getValuesCss(driver, locator, "font-size") + "\n" +
                        getText(driver, locator));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("El botón GUARDAR se encuentra HABILITADO");
            Assert.fail();
        }
    }

    public void validabExistenciayEstadoBotonCancelar(By locator, String textInButton) throws Exception {
        waitsElement(driver, locator);
        if (bolExistente(driver, locator, 10)) {
            if (getValuesCss(driver, locator, "background-color").equals("rgba(255, 255, 255, 1)") &&
                    getValuesCss(driver, locator, "color").equals("rgba(33, 33, 33, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, locator, "border-radius").equals("40px") &&
                    getValuesCss(driver, locator, "font-size").equals("13px") &&
                    getText(driver, locator).equals(textInButton)) {
                generateWord.setlogStep("El botón CANCELAR existe y se encuentra HABILITADO, las propiedades de estilo CSS coinciden");
            } else {
                generateWord.setlogStep("El botón CANCELAR existe pero se encuentra DESHABILITADO, las propiedades de estilo CSS NO coinciden - " + "\n" +
                        getValuesCss(driver, locator, "background-color") + "\n" +
                        getValuesCss(driver, locator, "color") + "\n" + // Texto blanco:  #212121
                        getValuesCss(driver, locator, "border-radius") + "\n" +
                        getValuesCss(driver, locator, "font-size") + "\n" +
                        getText(driver, locator));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("El botón CANCELAR se encuentra DESHABILITADO");
            Assert.fail();
        }
    }


    public void validaBotonAtrasRegresaAdmUsuarios() throws Exception {
        waitsElement(driver, cuo.BTN_HACIA_ATRAS);
        click(driver, cuo.BTN_HACIA_ATRAS);
        waitsElement(driver, auo.TXT_TITULO_ADM_USUARIOS);
        if (bolExistente(driver, auo.TXT_TITULO_ADM_USUARIOS, 15)) {
            generateWord.setlogStep("El botón hacia ATRAS, regresó al formulario ADMINISTRAR USUARIOS");
        } else {
            generateWord.setlogStep("El botón hacia ATRAS, NO regresó al formulario ADMINISTRAR USUARIOS");
            Assert.fail();
        }
    }

    public Boolean validabCSSCampos(By locator) throws Exception {
        waitsElement(driver, locator);
        if (bolExistente(driver, locator, 10)) {
            if (getValuesCss(driver, locator, "background-color").equals("rgba(255, 255, 255, 1)") &&
                    getValuesCss(driver, locator, "color").equals("rgba(33, 33, 33, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, locator, "border-radius").equals("2px") &&
                    getValuesCss(driver, locator, "font-size").equals("13px")) {
                return true;
            } else {
                return false;
            }
        } else {
            generateWord.setlogStep("El elemento NO se encuentra presente");
            return false;
        }
    }

    public void validabCSSCamposSeccionPerfilComercio() throws Exception {
        waitsElement(driver, cuo.FORM_ACORDEON_INFO_USUARIOS);
        if (bolExistente(driver, cuo.TXT_PF_LLENAR_CAMPOS, 15) && validabCSSCampos(cuo.TXTBOX_NOMBRES) && validabCSSCampos(cuo.TXTBOX_APELLIDO_PATERNO)
                && validabCSSCampos(cuo.TXTBOX_APELLIDO_MATERNO) && validabCSSCampos(cuo.LISTBOX_TIPO_DOC) && validabCSSCampos(cuo.TXTBOX_DOCUMENTO)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, se muestran correctamente");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no se muestran correctamente");
            Assert.fail();
        }

    }

    public void validabCSSCamposSeccionPerfilNiubiz() throws Exception {
        waitsElement(driver, cuo.FORM_ACORDEON_INFO_USUARIOS);
        if (validabCSSCampos(cuo.TXTBOX_NOMBRES) && validabCSSCampos(cuo.TXTBOX_APELLIDO_PATERNO)
                && validabCSSCampos(cuo.TXTBOX_APELLIDO_MATERNO) && validabCSSCampos(cuo.LISTBOX_AREA) && bolExistente(driver, cuo.BTN_AGREGAR_AREA, 15)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, se muestran correctamente");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no se muestran correctamente");
            Assert.fail();
        }

    }

    public void validaCamposObligatoriosPerfilComercio() throws Exception {
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("2"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("3"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("4"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("5"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("6"), 15)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, muestran el texto CAMPO OBLIGATORIO");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no muestran el texto CAMPO OBLIGATORIO");
            Assert.fail();
        }

    }

    public void validaCamposObligatoriosPerfilNiubiz() throws Exception {
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("2"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("3"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("4"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("5"), 15)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, muestran el texto CAMPO OBLIGATORIO");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no muestran el texto CAMPO OBLIGATORIO");
            Assert.fail();
        }
    }

    public void copiaryPegarTexto(By locator) throws Exception {
        waitsElementPresence(driver, locator);

    }

    public void validaMinimoCaracteresCorreoUsuario(By locator) throws Exception {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, "test");
        Thread.sleep(1000);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Boolean validacion1 = bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15); //valida cuando se ingresa manualmente
        Thread.sleep(1000);
        copiarTexto2(driver, locator);
        Thread.sleep(1000);
        pegarTexto2(driver, locator);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Boolean validacion2 = bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15); //Valida cuando se realiza la acción pegar
        if (validacion1 && validacion2) {
            if (getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "color").equals("rgba(255, 62, 79, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "text-align").equals("left") &&
                    getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "font-size").equals("13px")) {
                generateWord.setlogStep("Validación exitosa, se muestra el mensaje INGRESE UN CORREO VÁLIDO");
            } else {
                generateWord.setlogStep("Validación fallida, no muestra el mensaje INGRESE UN CORREO VALIDO" + "\n" +
                        getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "color") + "\n" +
                        getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "text-align") + "\n" +
                        getValuesCss(driver, cuo.INFO_CORREO_VALIDO, "font-size"));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Una de las validaciones del texto INGRESE UN CAMPO VALIDO no funcionó correctamente");
            Assert.fail();
        }


    }

    public void validaMaximoCaracteresCorreoUsuario(By locator) throws Exception {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, "PbFEjrFtPcLyLDZgJgCtQapaiwAdrCFQxzaWaSArLGYqXqDWCTiKmzGiteFzfkJQJ");
        Thread.sleep(1000);
        getAttributeText(driver, locator);
        int size1 = getAttributeText(driver, locator).length();
        copiarTexto2(driver, locator);
        Thread.sleep(1000);
        pegarTexto2(driver, locator);
        typeText(driver, locator, "textoAdicional"); //Adicionar texto luego de copiar y pegar
        int size2 = getAttributeText(driver, locator).length();
        int maxLength = Integer.parseInt(getAttribute(driver, locator, "maxlength"));
        logger.info(maxLength);
        if (size1 == 60 && size2 == 60 && maxLength == 60) {
            generateWord.setlogStep("Validación exitosa, el campo correo solo permite ingresar máximo 60 caracteres, de manera manual y pegando el texto");
        } else {
            generateWord.setlogStep("Validacion fallida, el campo correo no cumple con el maximo de 60 caracteres permitidos: " + "\n" +
                    "Validación Manual = " + size1 + " caracteres\n" +
                    "Validación Copiar + Pegar = " + size2 + " caracteres\n" +
                    "Propiedad MaxLength = " + maxLength);
            Assert.fail();
        }
    }

    public void validaTildeCorreoUsuario(By locator) throws Exception {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, "téstcontílde@niubiz.com");
        Thread.sleep(1000);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Boolean validacion1 = bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15); //valida cuando se ingresa manualmente
        Thread.sleep(1000);
        copiarTexto2(driver, locator);
        Thread.sleep(1000);
        pegarTexto2(driver, locator);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Boolean validacion2 = bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15); //Valida cuando se realiza la acción pegar
        if (validacion1 && validacion2) {
            generateWord.setlogStep("Validación exitosa, se muestra el mensaje INGRESE UN CORREO VÁLIDO, por lo tanto no acepta tildes");
        } else {
            generateWord.setlogStep("Validación fallida, no muestra el mensaje INGRESE UN CORREO VALIDOm por lo tanto permitió el ingreso de tildes");
            Assert.fail();
        }
    }

    public void validaCaracteresEspecialesCorreoUsuarioComercio() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_USUARIO);
        typeText(driver, cuo.TXTBOX_CORREO_USUARIO, "-anita(--)perez$@xxxxx2.xx");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_TIPO_DOC);
        click(driver, cuo.LISTBOX_TIPO_DOC);
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_DNI);
        click(driver, cuo.OPTION_DNI);
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_DOCUMENTO);
        typeText(driver, cuo.TXTBOX_DOCUMENTO, "12345678");
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_GUARDAR_DISABLED);
        click(driver, cuo.BTN_GUARDAR_DISABLED);
        if (bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15)) {
            generateWord.setlogStep("Validación Exitosa, se muestra el mensaje INGRESE UN CORREO VALIDO, el sistema no permite caracteres especiales antes del @");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra el mensaje INGRESE UN CORREO VALIDO");
            Assert.fail();
        }

    }

    public void validaCaracteresEspecialesCorreoUsuarioNiubiz() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_ELECTRONICO);
        typeText(driver, cuo.TXTBOX_CORREO_ELECTRONICO, "-anita(--)perez$@xxxxx2.xx");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_AREA);
        click(driver, cuo.LISTBOX_AREA);
        Thread.sleep(500);
        typeText(driver, cuo.LISTBOX_AREA, "CAPITAL HUMANO");
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_LIST_AREA);
        click(driver, cuo.OPTION_LIST_AREA);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_GUARDAR_DISABLED_NBZ);
        click(driver, cuo.BTN_GUARDAR_DISABLED_NBZ);
        if (bolExistente(driver, cuo.INFO_CORREO_VALIDO, 15)) {
            generateWord.setlogStep("Validación Exitosa, se muestra el mensaje INGRESE UN CORREO VALIDO, el sistema no permite caracteres especiales antes del @");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra el mensaje INGRESE UN CORREO VALIDO");
            Assert.fail();
        }

    }

    public void validaCaracteresEspecialesDespuesArrobaComercio() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_USUARIO);
        typeText(driver, cuo.TXTBOX_CORREO_USUARIO, "TESTMAIL2022@KNOL-POWER.NL");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_TIPO_DOC);
        click(driver, cuo.LISTBOX_TIPO_DOC);
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_DNI);
        click(driver, cuo.OPTION_DNI);
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_DOCUMENTO);
        typeText(driver, cuo.TXTBOX_DOCUMENTO, "12345678");
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_GUARDAR_DISABLED);
        click(driver, cuo.BTN_GUARDAR_DISABLED);
        if (!bolExistente(driver, cuo.INFO_CORREO_VALIDO, 5)) {
            generateWord.setlogStep("Validación Exitosa, NO se muestra el mensaje INGRESE UN CORREO VALIDO, el sistema SI permite caracteres especiales despues del @");
        } else {
            generateWord.setlogStep("Validación fallida, SI se muestra el mensaje INGRESE UN CORREO VALIDO");
            Assert.fail();
        }

    }

    public void validaCaracteresEspecialesDespuesArrobaNiubiz() throws Throwable {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_ELECTRONICO);
        typeText(driver, cuo.TXTBOX_CORREO_ELECTRONICO, "TESTMAIL2022@KNOL-POWER.NL");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_AREA);
        click(driver, cuo.LISTBOX_AREA);
        Thread.sleep(500);
        typeText(driver, cuo.LISTBOX_AREA, "CAPITAL HUMANO");
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_LIST_AREA);
        click(driver, cuo.OPTION_LIST_AREA);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_GUARDAR_DISABLED_NBZ);
        click(driver, cuo.BTN_GUARDAR_DISABLED_NBZ);
        if (!bolExistente(driver, cuo.INFO_CORREO_VALIDO, 5)) {
            generateWord.setlogStep("Validación Exitosa, No se muestra el mensaje INGRESE UN CORREO VALIDO, el sistema SI permite caracteres especiales despues del @");
        } else {
            generateWord.setlogStep("Validación fallida, SI se muestra el mensaje INGRESE UN CORREO VALIDO");
            Assert.fail();
        }
    }

    public void validaMinimoCaracteresCamposNombresyApellidos(By locator, String texto) throws Throwable {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, texto);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(500);
        if (bolExistente(driver, cuo.INFO_TEXTO_NO_VALIDO, 5)) {
            if (getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color").equals("rgba(255, 62, 79, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align").equals("left") &&
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size").equals("13px")) {
                generateWord.setlogStep("Validación exitosa, se muestra el mensaje TEXTO NO VALIDO debajo del campo NOMBRES");
            } else {
                generateWord.setlogStep("Validación fallida, no muestra el mensaje TEXTO NO VALIDO" + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size"));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Falló al validar la existencia del objeto INFO_TEXTO_NO_VALIDO");
            Assert.fail();
        }
    }

    public void validaMaximoCaracteresCamposNombresyApellidos(By locator, String texto) throws Exception {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, texto); //Ingresando 35 caracteres, validar 30
        Thread.sleep(1000);
        getAttributeText(driver, locator);
        int size1 = getAttributeText(driver, locator).length();
        int maxLength = Integer.parseInt(getAttribute(driver, locator, "maxlength"));
        logger.info(maxLength);
        if (size1 == 30 && maxLength == 30) {
            generateWord.setlogStep("Validación exitosa, el campo solo permite ingresar máximo 30 caracteres");
        } else {
            generateWord.setlogStep("Validacion fallida, el campo  no cumple con el maximo de 30 caracteres permitidos: " + "\n" +
                    "Validación = " + size1 + " caracteres\n" +
                    "Propiedad MaxLength = " + maxLength);
            Assert.fail();
        }
    }

    public void validaMCaracteresEspecialesCampos(By locator, String texto) throws Throwable {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, texto);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(500);
        if (bolExistente(driver, cuo.INFO_TEXTO_NO_VALIDO, 5)) {
            if (getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color").equals("rgba(255, 62, 79, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align").equals("left") &&
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size").equals("13px")) {
                generateWord.setlogStep("Validación exitosa, se muestra el mensaje TEXTO NO VALIDO al ingresar caracteres especiales");
            } else {
                generateWord.setlogStep("Validación fallida, no muestra el mensaje TEXTO NO VALIDO" + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size"));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Falló al validar la existencia del objeto INFO_TEXTO_NO_VALIDO");
            Assert.fail();
        }
    }

    public void validaMCaracteresNumericosCampos(By locator, String texto) throws Throwable {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, texto);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(500);
        if (bolExistente(driver, cuo.INFO_TEXTO_NO_VALIDO, 5)) {
            if (getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color").equals("rgba(255, 62, 79, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align").equals("left") &&
                    getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size").equals("13px")) {
                generateWord.setlogStep("Validación exitosa, se muestra el mensaje TEXTO NO VALIDO al ingresar caracteres numéricos");
            } else {
                generateWord.setlogStep("Validación fallida, no muestra el mensaje TEXTO NO VALIDO" + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "color") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "text-align") + "\n" +
                        getValuesCss(driver, cuo.INFO_TEXTO_NO_VALIDO, "font-size"));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Falló al validar la existencia del objeto INFO_TEXTO_NO_VALIDO");
            Assert.fail();
        }
    }

    public void validaMCaracteresTipoTextoCampos(By locator, String texto) throws Throwable {
        waitsElementPresence(driver, locator);
        typeText(driver, locator, texto);
        Thread.sleep(500);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(500);
        if (!bolExistente(driver, cuo.INFO_TEXTO_NO_VALIDO, 5)) {
            generateWord.setlogStep("Validación exitosa, NO se muestra el mensaje TEXTO NO VALIDO al ingresar caracteres tipo texto");
        } else {
            generateWord.setlogStep("Validación fallida, SI se muestra el mensaje TEXTO NO VALIDO");
            Assert.fail();
        }
    }

    public void validaMensajeCamposObligatoriosBotonSiguientePerfilComercio() throws Exception {
        waitsElementClickeable(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(1000);
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("2"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("3"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("4"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("5"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("6"), 15)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, muestran el texto CAMPO OBLIGATORIO");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no muestran el texto CAMPO OBLIGATORIO");
            Assert.fail();
        }

    }

    public void validaMensajeCamposObligatoriosBotonSiguientePerfilNiubiz() throws Exception {
        waitsElementClickeable(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(1000);
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("2"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("3"), 15) && bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("4"), 15) &&
                bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("5"), 15)) {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, muestran el texto CAMPO OBLIGATORIO");
        } else {
            generateWord.setlogStep("Los campos de la sección INFORMACION DE USUARIO, no muestran el texto CAMPO OBLIGATORIO");
            Assert.fail();
        }
    }

    public void llenaCamposInfoUsuarioPerfilComercio() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_USUARIO);
        typeText(driver, cuo.TXTBOX_CORREO_USUARIO, "test@niubiz.com");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_TIPO_DOC);
        click(driver, cuo.LISTBOX_TIPO_DOC);
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_DNI);
        click(driver, cuo.OPTION_DNI);
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_DOCUMENTO);
        typeText(driver, cuo.TXTBOX_DOCUMENTO, "12345678");
        Thread.sleep(500);
    }

    public void llenaCamposInfoUsuarioPerfilNiubiz() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_ELECTRONICO);
        typeText(driver, cuo.TXTBOX_CORREO_ELECTRONICO, "test@niubiz.com");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_AREA);
        click(driver, cuo.LISTBOX_AREA);
        Thread.sleep(500);
        typeText(driver, cuo.LISTBOX_AREA, "CAPITAL HUMANO");
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_LIST_AREA);
        click(driver, cuo.OPTION_LIST_AREA);
        Thread.sleep(500);
    }
    public void validaBotonsiguienteHabiliteModuloRUCSyCodigosPerfilComercio() throws Exception {
        llenaCamposInfoUsuarioPerfilComercio();
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        if (bolExistente(driver, cuo.FORM_ACORDEON_RUCS_CODIGOS, 10)) {
            generateWord.setlogStep("Validación Exitosa, SI se muestra visible el modulo RUCS y Códigos");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra visible el modulo RUCS y Códigos");
            Assert.fail();
        }

    }

    public void validaBotonsiguienteHabiliteModuloRUCSyCodigosPerfilNiubiz() throws Exception {
        llenaCamposInfoUsuarioPerfilNiubiz();
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        if (bolExistente(driver, cuo.FORM_ACORDEON_ASIGNACION_PERFIL, 10)) {
            generateWord.setlogStep("Validación Exitosa, SI se muestra visible el modulo ASIGNACION DE PERFIL");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra visible el modulo ASIGNACION DE PERFIL");
            Assert.fail();
        }

    }

    public void validaNoIngreseSiguienteSeccionconDatosincompletosComercio() throws Exception {
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_TIPO_DOC);
        click(driver, cuo.LISTBOX_TIPO_DOC);
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_DNI);
        click(driver, cuo.OPTION_DNI);
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_DOCUMENTO);
        typeText(driver, cuo.TXTBOX_DOCUMENTO, "12345678");
        generateWord.sendText("Se llenaron los campos, menos el correo del usuario para validación");
        generateWord.addImageToWord(driver);
        //no se llenan todos los campos para validación
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 10) && !elementDisplayed(driver,cuo.FORM_ACORDEON_RUCS_CODIGOS)) {
            generateWord.setlogStep("Validación Exitosa, el sistema no permitió pasar a la siguiente sección cuando existen datos faltantes");
        } else {
            generateWord.setlogStep("Validación fallida, el sistema si permitió pasar a la siguiente sección cuando existen datos faltantes");
            Assert.fail();
        }

    }

    public void validaNoIngreseSiguienteSeccionconDatosincompletosNiubiz() throws Exception {
        waitsElementPresence(driver, cuo.TXTBOX_CORREO_ELECTRONICO);
        typeText(driver, cuo.TXTBOX_CORREO_ELECTRONICO, "test@niubiz.com");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver, cuo.TXTBOX_NOMBRES, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_PATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_PATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.TXTBOX_APELLIDO_MATERNO);
        typeText(driver, cuo.TXTBOX_APELLIDO_MATERNO, "test");
        Thread.sleep(500);
        waitsElement(driver, cuo.LISTBOX_AREA);
        click(driver, cuo.LISTBOX_AREA);
        Thread.sleep(500);
        typeText(driver, cuo.LISTBOX_AREA, "CAPITAL HUMANO");
        Thread.sleep(500);
        waitsElement(driver, cuo.OPTION_LIST_AREA);
        click(driver, cuo.OPTION_LIST_AREA);
        Thread.sleep(500);
        generateWord.sendText("Se llenaron los campos, menos el correo del usuario para validación");
        generateWord.addImageToWord(driver);
        //no se llenan todos los campos para validación
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        if (bolExistente(driver, cuo.TXT_CAMPO_OBLIGATORIO("1"), 10) && !elementDisplayed(driver,cuo.FORM_ACORDEON_ASIGNACION_PERFIL)) {
            generateWord.setlogStep("Validación Exitosa, el sistema no permitió pasar a la siguiente sección cuando existen datos faltantes");
        } else {
            generateWord.setlogStep("Validación fallida, el sistema si permitió pasar a la siguiente sección cuando existen datos faltantes");
            Assert.fail();
        }

    }

    public void validarAlertaIngresarUnRUCParaPasarSecciónModulosComercio() throws Exception {
        llenaCamposInfoUsuarioPerfilComercio();
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(1000);
        generateWord.sendText("Se omite ingresar un RUC para validación");
        generateWord.addImageToWord(driver);
        waitsElement(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        if (bolExistente(driver, cuo.INFO_MARCA_UN_RUC, 5) && !elementDisplayed(driver,cuo.FORM_ACORDEON_MODULOS)) {
            generateWord.setlogStep("Validación Exitosa, SI se muestra el mensaje de Error DEBES MARCAR POR LO MENOS UN RUC, y no permite ingresar a la sección MODULOS");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra el mensaje de Error DEBES MARCAR POR LO MENOS UN RUC, y si permite ingresar a la sección MODULOS");
            Assert.fail();
        }

    }

    public void validarAlertaDesapareceAlIngresarUnRUCParaPasarSecciónModulosComercio() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        llenaCamposInfoUsuarioPerfilComercio();
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        waitsElement(driver, cuo.CHECKBOX_RUCS_CODIGOS(ruc));
        click(driver,cuo.CHECKBOX_RUCS_CODIGOS(ruc));
        generateWord.sendText("Se ingresa un RUC para validación");
        generateWord.addImageToWord(driver);
        waitsElement(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        Thread.sleep(1000);
        if (!bolExistente(driver, cuo.INFO_MARCA_UN_RUC, 5)) {
            generateWord.setlogStep("Validación Exitosa, NO se muestra el mensaje de Error DEBES MARCAR POR LO MENOS UN RUC, y SI permite ingresar a la sección MODULOS");
        } else {
            generateWord.setlogStep("Validación fallida, SI se muestra el mensaje de Error DEBES MARCAR POR LO MENOS UN RUC, y NO permite ingresar a la sección MODULOS");
            Assert.fail();
        }

    }

    public void validaExistenciaSubtituloRucsYCodigos() throws Throwable {
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(1000);
        if (bolExistente(driver, cuo.SUBTITULO_RUCS_CODIGOS, 5)) {
            if (getValuesCss(driver, cuo.SUBTITULO_RUCS_CODIGOS, "color").equals("rgba(55, 55, 55, 1)") && // Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.SUBTITULO_RUCS_CODIGOS, "text-align").equals("left") &&
                    getValuesCss(driver, cuo.SUBTITULO_RUCS_CODIGOS, "font-size").equals("13px")) {
                    generateWord.setlogStep("Validación exitosa, el mensaje se muestra y cumple con los estilos CSS");
            }
            else {
                generateWord.setlogStep("Validación Fallida, el mensaje no se muestra y no coincide con los estilos CSS");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("El mensaje 'Selecciona el RUC y códigos a los cuales quieres que tenga acceso el usuario.' no se muestra en pantalla");
            Assert.fail();
        }

    }

    public void validaExistenciaListaRucsyBotonesTodosySeleccionar() throws Throwable {
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(1000);
        if (bolExistente(driver, cuo.LISTA_RUCS_CODIGOS, 5) && bolExistente(driver, cuo.BTN_TODOS, 5) && bolExistente(driver, cuo.BTN_SELECCIONAR, 5)) {
            generateWord.setlogStep("Validación exitosa, SI se muestra la lista de RUCS y los botons TODOS y SELECCIONAR");
        } else {
            generateWord.setlogStep("Validación fallida, NO se muestra la lista de RUCS y los botons TODOS y SELECCIONAR");
            Assert.fail();
        }

    }

    public void clickCheckBoxRUCparaSeccionRUCSyCODIGOS() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        if (bolExistente(driver, cuo.FORM_ACORDEON_RUCS_CODIGOS, 5)){
            waitsElement(driver, cuo.CHECKBOX_RUCS_CODIGOS(ruc));
            click(driver,cuo.CHECKBOX_RUCS_CODIGOS(ruc));
        } else {
            generateWord.setlogStep("No se encuentra el elemento Acordeon de la sección RUCS y CODIGOS");
            Assert.fail();
        }

    }

    public void validaBotonesTODOSySELECCIONAR() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        if (elementoExistente(driver, cuo.BTN_TODOS_POR_RUC(ruc)) && elementoExistente(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc))) {
            if (getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "background-color").equals("rgba(3, 169, 244, 1)") && getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "background-color").equals("rgba(211, 211, 211, 1)") &&// Texto blanco:  #a6a6a6
                    getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "text-align").equals("center") && getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "text-align").equals("center") &&
                    getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "font-size").equals("11px") && getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "font-size").equals("11px")) {
                generateWord.setlogStep("Validación exitosa, los botones TODOS Y SELECCIONAR SI cumplen con los estilos CSS");
            }
            else {
                generateWord.setlogStep("Validación Fallida, los botones TODOS Y SELECCIONAR NO cumplen con los estilos CSS");
                logger.info(getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "color") + " " + getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "color")
                        + " " + getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "text-align") + " " + getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "text-align")
                        + " " + getValuesCss(driver, cuo.BTN_TODOS_POR_RUC(ruc), "font-size") + " " + getValuesCss(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc), "font-size") );
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("Los botones TODOS y SELECCIONAR NO se encuentran visibles en la página");
            Assert.fail();
        }

    }

    public void clickBotonSeleccionarSecciónRucsYCodigos() throws Throwable {
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        waitsElement(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc));
        click(driver, cuo.BTN_SELECCIONAR_POR_RUC(ruc));
    }

    public void validaPopUpBotonSeleccionar() throws Throwable {
        String perfil = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        clickBotonSeleccionarSecciónRucsYCodigos();
        if(!perfil.equals("Comercio_AccesoPersonalizado")){
            if (elementoExistente(driver, cuo.TXT_BUSQUEDA_POR_CODIGO) && elementoExistente(driver, cuo.TXT_SELECCIONE_CODIGOS)) {
                if (getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "color").equals("rgba(33, 33, 33, 1)") && getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "color").equals("rgba(3, 169, 244, 1)") &&// Texto blanco:  #a6a6a6
                        getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "text-align").equals("left") && getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "text-align").equals("left") &&
                        getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "font-size").equals("13px") && getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "font-size").equals("22px")) {
                    generateWord.setlogStep("Validación exitosa, el título y subtítulo del PopUp SI cumplen con los estilos CSS");
                }
                else {
                    generateWord.setlogStep("Validación Fallida, el título y subtítulo del PopUp NO cumplen con los estilos CSS");
                    logger.info(getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "color") + " " + getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "color")
                            + " " + getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "text-align") + " " + getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "text-align")
                            + " " + getValuesCss(driver, cuo.TXT_BUSQUEDA_POR_CODIGO, "font-size") + " " + getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "font-size") );
                    Assert.fail();
                }
            } else {
                generateWord.setlogStep("El titulo y subtitulo del PopUp NO se encuentran visibles en la página");
                Assert.fail();
            }
        }
        else{
            if (elementoExistente(driver, cuo.TXT_SELECCIONE_CODIGOS)) {
                if (getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "color").equals("rgba(3, 169, 244, 1)") &&// Texto blanco:  #a6a6a6
                        getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "text-align").equals("left") &&
                        getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "font-size").equals("22px")) {
                    generateWord.setlogStep("Validación exitosa, el título del PopUp SI cumplen con los estilos CSS");
                }
                else {
                    generateWord.setlogStep("Validación Fallida, el título del PopUp NO cumplen con los estilos CSS");
                    logger.info(getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "background-color")
                            + " " + getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "text-align")
                            + " " + getValuesCss(driver, cuo.TXT_SELECCIONE_CODIGOS, "font-size") );
                    Assert.fail();
                }
            } else {
                generateWord.setlogStep("El titulo del PopUp NO se encuentran visibles en la página");
                Assert.fail();
            }
        }
    }

    public void validaActualizacionListaBusquedaPorCodigo() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        if (elementoExistente(driver, cuo.TXT_BUSQUEDA_POR_CODIGO)){
            waitsElement(driver, cuo.INPUT_BUSQUEDA_CODIGO);
            typeText(driver, cuo.INPUT_BUSQUEDA_CODIGO,codigo);
            generateWord.sendText("Ingresa el codigo de comercio a buscar");
            generateWord.addImageToWord(driver);
            waitsElementClickeable(driver,cuo.OPCION_LISTA_CODIGOS(codigo));
            click(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
            if(elementoExistente(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo))){
                generateWord.setlogStep("Validación Exitosa, la lista de comercios se actualiza con la busqueda del código ingresado");
            }
            else {
                generateWord.setlogStep("Validación fallida, la lista de comercios no se actualiza con la busqueda del código ingresado");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("No se encuentra el subtitulo 'Búsqueda por Código'");
            Assert.fail();
        }

    }

    public void validaActualizacionGrillaCodigoComercioSeleccionado() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        if (elementoExistente(driver, cuo.TXT_BUSQUEDA_POR_CODIGO)){
            waitsElement(driver, cuo.INPUT_BUSQUEDA_CODIGO);
            typeText(driver, cuo.INPUT_BUSQUEDA_CODIGO,codigo);
            Thread.sleep(500);
            generateWord.sendText("Ingresa el codigo de comercio a buscar");
            generateWord.addImageToWord(driver);
            waitsElementClickeable(driver,cuo.OPCION_LISTA_CODIGOS(codigo));
            click(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
            Thread.sleep(500);
            waitsElement(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
            click(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
            Thread.sleep(500);
            if (elementoExistente(driver,cuo.ROW_TABLA_CODIGO_SELECCIONADO(codigo))){
                generateWord.setlogStep("Validación exitosa, la tabla que muestra el codigo de comercio seleccionado ha sido actualizado.");
            }
            else {
                generateWord.setlogStep("Validación fallida, la tabla que muestra el codigo de comercio seleccionado no ha sido actualizado.");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("No se encuentra el subtitulo 'Búsqueda por Código'");
            Assert.fail();
        }
    }

    public void validaRegistrosTablaALSeleccionarTodos() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        if (elementoExistente(driver, cuo.TXT_BUSQUEDA_POR_CODIGO)){
            waitsElement(driver, cuo.CHECKBOX_SELECCIONAR_TODOS);
            click(driver, cuo.CHECKBOX_SELECCIONAR_TODOS);
            Thread.sleep(500);
            if (elementoExistente(driver,cuo.CHECKBOX_SELECCIONAR_TODOS) && getSizeList(driver,cuo.CHECKBOX_SELECCIONAR_TODOS)>0){
                logger.info("La cantidad de elementos encontrados es :" + getSizeList(driver,cuo.CHECKBOX_SELECCIONAR_TODOS));
                generateWord.setlogStep("Validación exitosa, la tabla muestra todos los codigos de comercio al activar el checkBox 'Seleccionar Todos'");
            }
            else {
                generateWord.setlogStep("Validación fallida, la tabla no muestra todos los codigos de comercio al activar el checkBox 'Seleccionar Todos'");
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("No se encuentra el subtitulo 'Búsqueda por Código'");
            Assert.fail();
        }
    }

    public void validaBotonAceptarDeshabilitadoPopUpBusquedaCodigos() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        if (bolExistente(driver, cuo.BTN_ACEPTAR_DISABLED,5) && getValuesCss(driver,cuo.BTN_ACEPTAR_DISABLED,"background-color").equals("rgba(211, 211, 211, 1)")){
            generateWord.setlogStep("Validación exitosa, el botón ACEPTAR se encuentra deshabilitado");
        }
        else {
            generateWord.setlogStep("Validación fallida, el botón ACEPTAR no se encuentra deshabilitado");
            Assert.fail();
        }

    }

    public void validaBotonAceptarHabilitadoPopUpBusquedaCodigos() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        Thread.sleep(2000);
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        waitsElement(driver,cuo.INPUT_BUSQUEDA_CODIGO);
        typeText(driver,cuo.INPUT_BUSQUEDA_CODIGO,codigo);
        Thread.sleep(2000);
        waitsElement(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
        click(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
        Thread.sleep(2000);
        waitsElement(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
        click(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
        Thread.sleep(2000);
        if (elementoExistente(driver, cuo.BTN_ACEPTAR_ENABLE) && getValuesCss(driver,cuo.BTN_ACEPTAR_ENABLE,"background-color").equals("rgba(255, 193, 7, 1)")){
            generateWord.setlogStep("Validación exitosa, el botón ACEPTAR se encuentra habilitado");
        }
        else {
            generateWord.setlogStep("Validación fallida, el botón ACEPTAR no se encuentra habilitado");
            logger.info("La propiedad background-color es: " + getValuesCss(driver,cuo.BTN_ACEPTAR_ENABLE,"background-color"));
            Assert.fail();
        }

    }

    public void seleccionaCodigosDeAcceso() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        clickBotonSeleccionarSecciónRucsYCodigos();
        Thread.sleep(2000);
        waitsElement(driver, cuo.TXT_BUSQUEDA_POR_CODIGO);
        waitsElement(driver,cuo.INPUT_BUSQUEDA_CODIGO);
        typeText(driver,cuo.INPUT_BUSQUEDA_CODIGO,codigo);
        Thread.sleep(2000);
        waitsElement(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
        click(driver, cuo.OPCION_LISTA_CODIGOS(codigo));
        Thread.sleep(2000);
        waitsElement(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
        click(driver, cuo.RESULTADO_LISTA_CODIGOS(codigo));
        Thread.sleep(2000);
        waitsElementClickeable(driver, cuo.BTN_ACEPTAR_ENABLE);
        click(driver,cuo.BTN_ACEPTAR_ENABLE);
    }

    public void validaMensajeLuegoDeSeleccionarCodigos() throws Throwable {
        Thread.sleep(2000);
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        waitsElement(driver,cuo.TXT_CODIGOS_SELECCIONADOS(ruc));
        if (elementoExistentePresente(driver, cuo.TXT_CODIGOS_SELECCIONADOS(ruc))){
            generateWord.setlogStep("Validación exitosa, el mensaje de la cantidad de codigos seleccionas se muestra luego de dar click en ACEPTAR");
        }
        else {
            generateWord.setlogStep("Validación fallida, el mensaje de la cantidad de codigos seleccionas no se muestra luego de dar click en ACEPTAR");
            Assert.fail("El elemento es :" + cuo.TXT_CODIGOS_SELECCIONADOS(ruc));
        }

    }

    public void validaBotonSeleccionarColorNaranja() throws Throwable {
        Thread.sleep(2000);
        String ruc = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.RUC);
        waitsElement(driver,cuo.TXT_CODIGOS_SELECCIONADOS(ruc));
        if (elementoExistentePresente(driver, cuo.BTN_SELECCIONAR_ENABLE(ruc)) &&
                getValuesCss(driver,cuo.BTN_SELECCIONAR_ENABLE(ruc),"background-color").equals("rgba(255, 193, 7, 1)") &&
                getValuesCss(driver,cuo.BTN_SELECCIONAR_ENABLE(ruc),"color").equals("rgba(33, 33, 33, 1)")){
            generateWord.setlogStep("Validación exitosa, el botón SELECCIONAR se encuentra activo y cumple con los estilos CSS");
        }
        else {
            generateWord.setlogStep("Validación fallida, el botón posiblemente esté inactivo y no cumple con los estilos CSS");
            Assert.fail("El elemento es :" + cuo.BTN_SELECCIONAR_ENABLE(ruc));
        }

    }

    public void retornaAlaSeccionInformacionUsuariosyModificaCampo() throws Throwable {
        String codigo = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.CODIGO);
        Thread.sleep(2000);
        waitsElement(driver,cuo.ACORDEON_INFO_USUARIO);
        click(driver,cuo.ACORDEON_INFO_USUARIO);
        Thread.sleep(2000);
        waitsElement(driver, cuo.TXTBOX_NOMBRES);
        clear(driver, cuo.TXTBOX_NOMBRES);
        typeText(driver,cuo.TXTBOX_NOMBRES,"Prueba");
        Thread.sleep(2000);
        waitsElement(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        click(driver, cuo.BTN_SIGUIENTE_INFO_USUARIOS);
        Thread.sleep(2000);
    }

    public void validaExistenciaFormularioRUCSyCODIGOS() throws Throwable {
        Thread.sleep(2000);
        if (elementoExistentePresente(driver, cuo.FORM_ACORDEON_RUCS_CODIGOS) && elementoExistente(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS)){
            generateWord.setlogStep("Validación exitosa, el botón SIGUIENTE dejo pasar a la siguiente sección RUCS Y CODIGOS luego de modificar campos en la sección INFORMACION DE USUARIO");
        }
        else {
            generateWord.setlogStep("Validación fallida,  el botón SIGUIENTE no dejo pasar a la siguiente sección RUCS Y CODIGOS luego de modificar campos en la sección INFORMACION DE USUARIO");
            Assert.fail();
        }

    }

    public void validaExistenciaTooltipALColocarCursorEnOpcionPaginaDeInicio() throws Throwable {
        waitsElementClickeable(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver,cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        Thread.sleep(1000);
        waitsElement(driver, cuo.CHECKBOX_MODULOS_PAGINA_INICIO);
        mouseHover(driver,cuo.CHECKBOX_MODULOS_PAGINA_INICIO);
        Thread.sleep(1000);
        if (elementoExistente(driver, cuo.TOOLTIP_MODULOS_PAGINA_INICIO) &&
                getValuesCss(driver,cuo.TOOLTIP_MODULOS_PAGINA_INICIO,"background-color").equals("rgba(48, 49, 51, 1)") &&
                getValuesCss(driver,cuo.TOOLTIP_MODULOS_PAGINA_INICIO,"color").equals("rgba(255, 255, 255, 1)") &&
                getValuesCss(driver,cuo.TOOLTIP_MODULOS_PAGINA_INICIO,"font-size").equals("12px")){
            generateWord.setlogStep("Validación exitosa, el tooltip 'Todos los usuarios tienen acceso a la pantalla de inicio' si se muestra al pasar el cursor");
        }
        else {
            generateWord.setlogStep("Validación fallida, el tooltip 'Todos los usuarios tienen acceso a la pantalla de inicio' no se muestra al pasar el cursor");
            Assert.fail();
        }
    }

    public void validaExistenciaTooltipEnTodosLosIconosInformativosSecciónModulos() throws Throwable {
        waitsElementClickeable(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver,cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        Thread.sleep(1000);
        waitsElement(driver, cuo.INFO_MODULOS_MIS_VENTAS);
        mouseHover(driver,cuo.INFO_MODULOS_MIS_VENTAS);
        Thread.sleep(1000);
        Boolean t_mis_ventas = elementoExistente(driver,cuo.TOOLTIP_INFO_MODULOS_MIS_VENTAS);
        generateWord.sendDescript("Screeshot: Tooltip MIS VENTAS",true);
        generateWord.addImageToWord(driver);
        if (t_mis_ventas && validaCSSElemento(driver,cuo.TOOLTIP_INFO_MODULOS_MIS_VENTAS,"rgba(48, 49, 51, 1)","rgba(255, 255, 255, 1)","12px")) {
            waitsElement(driver, cuo.INFO_MODULOS_MIS_DEPOSITOS);
            mouseHover(driver, cuo.INFO_MODULOS_MIS_DEPOSITOS);
            Thread.sleep(1000);
            Boolean t_mis_depositos = elementoExistente(driver, cuo.TOOLTIP_INFO_MODULOS_MIS_DEPOSITOS);
            generateWord.sendDescript("Screenshot: Tooltip MIS DEPOSITOS",true);
            generateWord.addImageToWord(driver);
            if (t_mis_depositos && validaCSSElemento(driver, cuo.TOOLTIP_INFO_MODULOS_MIS_DEPOSITOS, "rgba(48, 49, 51, 1)", "rgba(255, 255, 255, 1)", "12px")) {
                waitsElement(driver, cuo.INFO_MODULOS_MIS_CANJES);
                mouseHover(driver, cuo.INFO_MODULOS_MIS_CANJES);
                Thread.sleep(1000);
                Boolean t_mis_canjes = elementoExistente(driver, cuo.TOOLTIP_INFO_MODULOS_MIS_CANJES);
                generateWord.sendDescript("Screenshot: Tooltip MIS CANJES",true);
                generateWord.addImageToWord(driver);
                if (t_mis_canjes && validaCSSElemento(driver, cuo.TOOLTIP_INFO_MODULOS_MIS_CANJES, "rgba(48, 49, 51, 1)", "rgba(255, 255, 255, 1)", "12px")) {
                    waitsElement(driver, cuo.INFO_MODULOS_COMPROBANTE_PAGO);
                    mouseHover(driver, cuo.INFO_MODULOS_COMPROBANTE_PAGO);
                    Thread.sleep(1000);
                    Boolean t_comprobante_pago = elementoExistente(driver, cuo.TOOLTIP_INFO_COMPROBANTE_PAGO);
                    generateWord.sendDescript("Screenshot: Tooltip COMPROBANTE DE PAGO",true);
                    generateWord.addImageToWord(driver);
                    if (t_comprobante_pago && validaCSSElemento(driver, cuo.TOOLTIP_INFO_COMPROBANTE_PAGO, "rgba(48, 49, 51, 1)", "rgba(255, 255, 255, 1)", "12px")) {
                        waitsElement(driver, cuo.INFO_MODULOS_ADMINISTRAR_USUARIOS);
                        mouseHover(driver, cuo.INFO_MODULOS_ADMINISTRAR_USUARIOS);
                        Thread.sleep(1000);
                        Boolean t_administrar_usuarios = elementoExistente(driver, cuo.TOOLTIP_INFO_ADMINISTRAR_USUARIOS);
                        generateWord.sendDescript("Screenshot: Tooltip ADMINISTRAR USUARIOS",true);
                        generateWord.addImageToWord(driver);
                        Thread.sleep(1000);
                        if (t_administrar_usuarios && validaCSSElemento(driver, cuo.TOOLTIP_INFO_ADMINISTRAR_USUARIOS, "rgba(48, 49, 51, 1)", "rgba(255, 255, 255, 1)", "12px")) {
                            generateWord.sendDescript("Validación Exitosa, los tooltips se muestran en cada uno de los iconos de información presentes en la sección MODULOS",true);
                        } else {
                            generateWord.setlogStep("Validación Fallida, uno o mas tooltips NO se muestran en los iconos de información presentes en la sección MODULOS");
                            Assert.fail();
                        }
                    } else {
                        generateWord.setlogStep("Validación Fallida, uno o mas tooltips NO se muestran en los iconos de información presentes en la sección MODULOS");
                        Assert.fail();
                    }
                } else {
                    generateWord.setlogStep("Validación Fallida, uno o mas tooltips NO se muestran en los iconos de información presentes en la sección MODULOS");
                    Assert.fail();
                }
            }
            else {
                generateWord.setlogStep("Validación Fallida, uno o mas tooltips NO se muestran en los iconos de información presentes en la sección MODULOS");
                Assert.fail();
            }
        }
        else {
            generateWord.setlogStep("Validación Fallida, uno o mas tooltips NO se muestran en los iconos de información presentes en la sección MODULOS");
            Assert.fail();
        }

    }

    public void validaCheckBoxActivoSoloPaginaDeInicio() throws Throwable {
        waitsElement(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        Thread.sleep(1000);
        if(!isEnabled(driver,cuo.CHECKBOX_MODULOS_PAGINA_INICIO) && !isSelected(driver,cuo.CHECKBOX_MODULOS_MIS_DEPOSITOS)
                && !isSelected(driver,cuo.CHECKBOX_MODULOS_MIS_VENTAS) && !isSelected(driver,cuo.CHECKBOX_MODULOS_MIS_CANJES)
                && !isSelected(driver,cuo.CHECKBOX_MODULOS_COMPROBANTE_PAGO) && !isSelected(driver,cuo.CHECKBOX_MODULOS_REPORTE_DEVOLUCIONES)
                && !isSelected(driver,cuo.CHECKBOX_MODULOS_REGISTRAR_DEVOLUCIONES) && !isSelected(driver,cuo.CHECKBOX_MODULOS_REGISTRAR_CUENTA_BANCARIA)
                && !isSelected(driver,cuo.CHECKBOX_MODULOS_ADMINISTRAR_USUARIOS)){
            generateWord.sendDescript("Validación Exitosa, solo el checkbox de 'Pagina de Inicio' se encuentra seleccionada y deshabilitada en la sección MODULOS",true);
        }
        else {
            generateWord.sendDescript("Validación Fallida, existe mas de 1 checkbox seleccionado en la sección MODULOS",true);
            Assert.fail();
        }
    }

    public void marcarOpcionRegistrarDevoluciones() throws Throwable {
        waitsElement(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        click(driver, cuo.BTN_SIGUIENTE_RUCS_CODIGOS);
        Thread.sleep(1000);
        waitsElement(driver, cuo.OPCION_REGISTRAR_DEVOLUCIONES);
        click(driver, cuo.OPCION_REGISTRAR_DEVOLUCIONES);
    }

    public void validaSiSeMuestraLaPreguntaAlMarcarRegistrarDevoluciones() throws Throwable {
        if (elementoExistente(driver, cuo.TEXT_PREGUNTA_REGISTRO_DEVOLUCIONES) && elementoExistente(driver, cuo.RADIO_BUTTON_OPCIONES_REGISTRO_DEVOLUCIONES)){
            generateWord.sendDescript("Validación Exitosa, se muestra la pregunta y las opciones correspondientes al marcar 'Registrar devoluciones' en la sección MODULOS",true);
        }
        else {
            generateWord.sendDescript("Validación Fallida, no se muestra la pregunta y/o las opciones correspondientes al marcar 'Registrar devoluciones' en la sección MODULOS",true);
            Assert.fail();
        }
    }

    public void validarSolicitudMontoADevolverYPermitirSeleccionarUsuariosAprobadores() throws Throwable {
        waitsElement(driver, cuo.RADIO_BUTTON_SI_REGISTRAR_DEVOLUCIONES);
        click(driver, cuo.RADIO_BUTTON_SI_REGISTRAR_DEVOLUCIONES);
        Thread.sleep(1000);
        waitsElement(driver, cuo.BOTON_SELECCIONAR_USUARIOS_APROBADORES);
        if (elementoExistente(driver, cuo.FORM_INGRESE_MONTO_DEVOLVER) && isEnabled(driver, cuo.BOTON_SELECCIONAR_USUARIOS_APROBADORES)){
            generateWord.sendDescript("Validación Exitosa, el sistema solicita ingresar el monto a devolver y permite seleccioanr los usuarios aprobadores al registrar devoluciones ",true);
        }
        else {
            generateWord.sendDescript("Validación fallida, el sistema no solicita ingresar el monto a devolver y/o no permite seleccioanr los usuarios aprobadores al registrar devoluciones ",true);
            Assert.fail();
        }
    }

}


