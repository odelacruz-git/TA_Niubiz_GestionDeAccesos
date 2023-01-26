package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.pages.objects.AdministrarUsuariosNelObjects;
import com.niubiz.bot.frontend.pages.objects.GenericNelObjects;
import com.niubiz.bot.frontend.pages.objects.InicioNelObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By;

public class AdministrarUsuariosNelPage extends BaseClass {
    private static final Logger logger = LogManager.getLogger(AdministrarUsuariosNelPage.class);

    private final AdministrarUsuariosNelObjects auo = new AdministrarUsuariosNelObjects();
    private final GenericNelObjects gno = new GenericNelObjects();
    private final WebDriver driver;

    // Constructor of the page class:
    public AdministrarUsuariosNelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean esperarLOAD_PAGE() {
        return objetoDesaparece(driver,gno.LOAD_PAGE);
    }
    public boolean loadingPage() {
        return elementLoading(driver,gno.LOAD_PAGE);
    }

    public void validaPresenciaPaginaAdministrarUsuario() throws Exception {
            if (bolExistente(driver,auo.TXT_TITULO,10)){
                generateWord.setlogStep("Página Administrar usuarios presente!");
            }
            else {
                generateWord.setlogStep("Pagina Administrar usuarios no presente");
            }
    }
    public void validabExistenciaBotonDescargarReporte() throws Exception {
        if (!elementDisplayed(driver, gno.LOAD_PAGE)) {
            waitsElement(driver, auo.BTN_DESCARGAR_REPORTE);
            if (getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "background-color").equals("rgba(3, 169, 244, 1)") && //Color fondo: #03a9f4
                getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "color").equals("rgba(255, 255, 255, 1)") && // Texto blanco:  #FFFFFF
                getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "border-radius").equals("40px") &&
                getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "font-size").equals("13px") &&
                getText(driver, auo.BTN_DESCARGAR_REPORTE).equals("Descargar reporte")) {
                generateWord.setlogStep("El botón DESCARGAR REPORTE existe, las propiedades CSS de estilo coinciden correctamente");
            } else {
                generateWord.setlogStep("El botón DESCARGAR REPORTE no existe, las propiedades CSS no coinciden - " + "\n" +
                        getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "background-color") + "\n" +//Color fondo: #03a9f4
                        getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "color") + "\n" + // Texto blanco:  #FFFFFF
                        getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "border-radius") + "\n" +
                        getValuesCss(driver, auo.BTN_DESCARGAR_REPORTE, "font-size") + "\n" +
                        getText(driver, auo.BTN_DESCARGAR_REPORTE));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("El elemento 'Loading...' NO desapareció");
        }
    }

    public void validaInexistenciaBotonDescargarReporte() throws Throwable{
       if (!elementoExistente(driver,auo.BTN_DESCARGAR_REPORTE)){
           generateWord.setlogStep("Validación exitosa, el botón DESCARGAR REPORTE no se muestra");
       }
       else {
           generateWord.setlogStep("Validación fallida, el botón DESCARGAR REPORTE si se muestra");
           Assert.fail();
       }

    }

    public void validabExistenciaBotonCrearUsuario() throws Exception {
        if (!elementDisplayed(driver, gno.LOAD_PAGE)) {
            waitsElement(driver, auo.BTN_COMERCIO_CREAR_USUARIO);
            if (getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "background-color").equals("rgba(255, 193, 7, 1)") && //Color fondo: #ffc107
                    getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "color").equals("rgba(33, 33, 33, 1)") && // Texto blanco:  #212121
                    getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "border-radius").equals("40px") &&
                    getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "font-size").equals("13px") &&
                    getText(driver, auo.BTN_COMERCIO_CREAR_USUARIO).equals("Crear nuevo usuario")) {
                    generateWord.setlogStep("El botón CREAR NUEVO USUARIO si existe, las propiedades CSS de estilo coinciden");
            } else {
                generateWord.setlogStep("El botón CREAR NUEVO USUARIO no existe, las propiedades CSS de estilo no coinciden - " + "\n" +
                        getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "background-color") + "\n" +//Color fondo: #ffc107
                        getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "color") + "\n" + // Texto blanco:  #212121
                        getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "border-radius") + "\n" +
                        getValuesCss(driver, auo.BTN_COMERCIO_CREAR_USUARIO, "font-size") + "\n" +
                        getText(driver, auo.BTN_COMERCIO_CREAR_USUARIO));
                        Assert.fail();
            }
        } else {
            generateWord.setlogStep("El elemento Loading... NO desapareció");
        }
    }

    public void validabExistenciaTituloAdministrarUsuario() throws Exception {
        if (!elementDisplayed(driver, gno.LOAD_PAGE)) {
            waitsElement(driver, auo.TXT_TITULO_ADM_USUARIOS);
            if (getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "font-family").equals("Font-Bold") && //
                    getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "color").equals("rgba(33, 33, 33, 1)") && // Texto blanco: #212121
                    getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "text-align").equals("left") &&
                    getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "font-size").equals("18px") &&
                    getText(driver, auo.TXT_TITULO_ADM_USUARIOS).equals("ADMINISTRAR USUARIOS")) {
                generateWord.setlogStep("El título ADMINISTRAR USUARIOS si existe, las propiedades CSS de estilo coinciden");
            } else {
                generateWord.setlogStep("El título ADMINISTRAR USUARIOS NO existe, las propiedades CSS no coinciden - " + "\n" +
                        getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "font-family") + "\n" +
                        getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "color") + "\n" + // Texto blanco:  #212121
                        getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "text-align") + "\n" +
                        getValuesCss(driver, auo.TXT_TITULO_ADM_USUARIOS, "font-size") + "\n" +
                        getText(driver, auo.TXT_TITULO_ADM_USUARIOS));
                Assert.fail();
            }
        } else {
            generateWord.setlogStep("El elemento Loading... NO desapareció");
        }
    }

    public void validaExistenciaPlaceholder(String textoEsperado) throws Exception {
        if (!elementDisplayed(driver, gno.LOAD_PAGE)) {
            waitsElement(driver, auo.PH_BARRA_BUSQUEDA);
            if (getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size").equals("13px") &&
                getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder").equals(textoEsperado)) {
                System.out.println(getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size") + getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder"));
                generateWord.setlogStep("El placeholder en la barra de búsqueda SI existe, las propiedades CSS de estilo coinciden");
            }
            else {
                generateWord.setlogStep("El placeholder en la barra de busqueda NO existe, las propiedades CSS de estilo no coinciden - " + "\n" +
                getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size") + "\n" +
                getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder"));
            }
        } else {
            generateWord.setlogStep("El elemento Loading... NO desapareció");
        }
    }

    public void validaExistenciaPlaceholder2(String textoEsperado) throws Exception {
        if (objetoDesaparece(driver, gno.LoadingLogin)) {
            waitsElement(driver, auo.PH_BARRA_BUSQUEDA);
            if (getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size").equals("13px") &&
                    getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder").equals(textoEsperado)) {
                System.out.println(getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size") + getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder"));
                generateWord.setlogStep("El placeholder en la barra de búsqueda SI existe, las propiedades CSS de estilo coinciden");
            }
            else {
                generateWord.setlogStep("El placeholder en la barra de busqueda NO existe, las propiedades CSS de estilo no coinciden - " + "\n" +
                        getValuesCss(driver, auo.PH_BARRA_BUSQUEDA, "font-size") + "\n" +
                        getAttribute(driver, auo.PH_BARRA_BUSQUEDA, "placeholder"));
            }
        } else {
            generateWord.setlogStep("El elemento Loading... NO desapareció");
        }
    }

    public void validaInexistenciaBotonCrearUsuario() throws Throwable{
            if (!elementoExistente(driver, auo.BTN_COMERCIO_CREAR_USUARIO)){
                logger.info("Validación exitosa, el botón DESCARGAR REPORTE no se muestra");
            }
            else {
                generateWord.setlogStep("Error!: Validación fallida, el botón DESCARGAR REPORTE si se muestra");
                Assert.fail();
            }
    }

    public void clickCrearUsuario(By locator) throws Throwable {
        try {
            Thread.sleep(1000);
            waitsElementClickeable(driver, locator);
            Thread.sleep(1000);
            click(driver, locator);
            Thread.sleep(2000);
            generateWord.setlogStep("Evento Click Exitoso - OPCIÓN: 'Crear Nuevo Usuario'");
        } catch (Exception e) {
            generateWord.setlogStep("Evento Click Fallido ");
        }
    }

    public void validaExistenciaDatosMIUSUARIO(By locator) throws Exception{
        if (elementoExistente(driver, locator)){
            generateWord.setlogStep("Validación exitosa, los datos de MI USUARIO se muestra correctamente");
        }
        else {
            generateWord.setlogStep("Validación fallida, los datos de MI USUARIO no se muestran");
            Assert.fail();
        }
    }
    public void validaExistenciaDNIeEMAIL(String email) throws Exception{
        if (elementoExistente(driver, auo.TXT_DNI_EMAIL(email))){
            generateWord.setlogStep("Validación exitosa, los datos DNI y Correo se muestra correctamente");
        }
        else {
            generateWord.setlogStep("Validación fallida, los datos DNI y Correo no se muestran");
            Assert.fail();
        }
    }

    public void clickEditarUsuario(By locator) throws Throwable {
        try {
            waitsElement(driver, locator);
            click(driver, locator);
            generateWord.setlogStep("Evento Click Exitoso - OPCIÓN: 'Icono Lapiz, Editar Usuario'");
        } catch (Exception e) {
            generateWord.setlogStep("Evento Click Fallido ");
        }
    }

    public void validabExistenciayEstadoBotonCancelar(By locator, String textInButton) throws Exception {
        waitsElement(driver, locator);
        if (objetoDesaparece(driver, gno.LoadingLogin)) {
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
    }

}
