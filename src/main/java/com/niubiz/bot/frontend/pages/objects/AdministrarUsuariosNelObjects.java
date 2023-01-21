package com.niubiz.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class AdministrarUsuariosNelObjects {
    public By BTN_DESCARGAR_REPORTE = By.xpath("//button[@class='el-button el-button--info']");
    public By TXT_TITULO = By.xpath("//h5[text()='ADMINISTRACIÓN DE USUARIOS NIUBIZ']");
    public By TXT_TITULO_ADM_USUARIOS = By.xpath("//h5[@class='layout-empty-title uppercase'][contains(.,'ADMINISTRAR USUARIOS')]");
    public By BTN_COMERCIO_CREAR_USUARIO = By.xpath("//button[@type='button'][contains(.,'Crear nuevo usuario')]");
    public By BTN_NIUBIZ_CREAR_USUARIO = By.xpath("//a[@href='/niubiz/adm-niubiz/crear'][contains(.,'CREAR NUEVO USUARIO')]");
    public  By PH_BARRA_BUSQUEDA = By.className("el-input__inner");
    public By CADM_MI_USUARIO = By.xpath("//span[contains(.,'Mi usuarioDevoluciones update Soles Testing Administrador')]");
    public By CAT_MI_USUARIO = By.xpath("//span[contains(.,'Mi usuariofpulache fpulache fpulache Acceso total')]");
    public By CAP_MI_USUARIO = By.xpath("//span[contains(.,'Mi usuariopruebaUNO devolucioness qa Acceso personalizado')]");
    public By BTN_ICON_LAPIZ = By.xpath("(//i[@class='icon omni-icon-pencil-create'])[2]");
    public  By BTN_CANCELAR = By.xpath("//button[@type='button'][contains(.,'Cancelar')]");

    public By TXT_DNI_EMAIL (String email) {
        return By.xpath("//span[contains(.,'DNI') and contains(.,'"+ email + "')]");
    }
}
