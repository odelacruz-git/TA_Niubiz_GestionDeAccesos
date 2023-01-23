package com.niubiz.bot.frontend.steps;

import com.niubiz.bot.frontend.helpers.DriverFactory;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.pages.pages.LoginNelPage;
import com.niubiz.bot.frontend.pages.pages.Utils;
import com.niubiz.bot.frontend.utility.GenerateWord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginNELSteps {
    private final UtilsExcel ue = new UtilsExcel();
    private LoginNelPage loginPage = new LoginNelPage(DriverFactory.getDriver());
    private Utils utils=new Utils(DriverFactory.getDriver());

    protected static GenerateWord generateWord = new GenerateWord();
    public LoginNELSteps() throws Throwable {
    }
    @Given("^el usuario se encuentra logueado a la web de Nel$")
    public void elUsuarioSeEncuentraLogueadoALaWebDeNelConPerfilProfile() throws Throwable {
        String userName = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.USER);
        String password = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PASSWORD);
        String enviroment = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.ENVIROMENT2);
        String profile = utils.getData(ue.PAGE_SHEET1, generateWord.getFila(), ue.PROFILE);
        DriverFactory.getDriver().get(enviroment);

        if (profile.equals("Niubiz_Visor") || profile.equals("Niubiz_MesaDeServicio")) {
            loginPage.doLoginNiubiz(userName, password, profile);
        } else {
            loginPage.doLogin(userName, password, profile);
        }
    }

}
