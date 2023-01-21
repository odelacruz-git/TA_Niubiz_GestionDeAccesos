package com.niubiz.bot.frontend.steps;

import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.pages.LoginNelPage;
import com.niubiz.bot.frontend.pages.pages.RucUserNelPage;
import com.niubiz.bot.frontend.pages.pages.Utils;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class RucUserNelSteps {
    private final UtilsExcel ue = new UtilsExcel();
    private LoginNelPage loginPage = new LoginNelPage(DriverFactory.getDriver());
    private RucUserNelPage ru_page = new RucUserNelPage(DriverFactory.getDriver());
    private Utils utils=new Utils(DriverFactory.getDriver());

    protected static GenerateWord generateWord = new GenerateWord();
    public RucUserNelSteps() throws Throwable {
    }
    @When("el usuario ingresa el RUC de prueba")
    public void elUsuarioIngresaElRUCDePrueba() throws  Throwable{
        String ruc = utils.getData(ue.PAGE_SHEET1,generateWord.getFila(),ue.RUC);
        ru_page.inputRUC(ruc);
    }

}
