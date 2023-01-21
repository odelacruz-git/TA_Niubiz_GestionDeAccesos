package com.niubiz.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class LoginNelObjects {

    public By LOADER = By.xpath("//div[@class='loading']//div[@class='loader']");
    public By EMAIL = By.id("txtEmail");
    public By PASSWORD = By.xpath("//input[@type='password']");
    public By BTN_INGRESAR = By.xpath("//button[@class='el-button el-button--fullWidth el-button--primary']");
    //public By LOADING_MAIN_PAGE = By.xpath("//div[@class='loading']//div[@class='loader']");
    public By BTN_SKIP_ENCUESTA = By.xpath("//button[@type='button'][contains(.,'Skip')]");
    public By BTN_OCULTA_ENCUESTA = By.xpath("//span[contains(@class,'_hj-BfLwc__styles__openStateToggleIcon _hj-mtJG6__styles__surveyIcons')]");
    //Usando Login con perfil Niubiz
    public By EMAIL2 = By.id("i0116");
    public  By PASSWORD2 = By.id("i0118");
    public  By BTN_NO = By.xpath("//input[@type='button'][contains(@id,'Back')]");
    public  By BTN_SI = By.id("idSIButton9");
    public  By BTN_INICIAR_SESION = By.id("idSIButton9");
    public  By BTN_SIGUIENTE = By.id("idSIButton9");


}

