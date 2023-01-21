package com.niubiz.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class RucUserNelObjects {
     public By TBX_RUC = By.id("ruc");
    public By BTN_INGRESAR_POR_RUC = By.xpath("//button[@type='button'][contains(.,'Ingresar')]");

    public By LIST_RUC (String nuevoRuc) {
        return By.xpath("//div[text()='"+nuevoRuc+" - ']");
    }

}

