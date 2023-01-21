package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.utility.ExcelReader;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class Utils extends BaseClass {

    private final UtilsExcel ue = new UtilsExcel();
    private WebDriver driver;
    public Utils(WebDriver driver) throws Throwable {
        this.driver = driver;
    }

    private List<HashMap<String, String>> getConfigure() throws Throwable {
        return ExcelReader.data(ue.EXCEL_DOC, ue.PAGE_SHEET2);
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(ue.EXCEL_DOC, ue.PAGE_SHEET1);
    }
    private List<HashMap<String, String>> configure =  getConfigure();
    private List<HashMap<String, String>> data =  getData();

    public String getData(String sheet, int fila, String columna) throws Throwable {
        String salida = "";
        if (sheet.equals(ue.PAGE_SHEET2)){
            salida = configure.get(fila - 1).get(columna);
        }
        else if (sheet.equals(ue.PAGE_SHEET1)){
            salida = data.get(fila - 1).get(columna);
        }
        return salida;
    }
}
