package com.niubiz.bot.frontend.pages.pages;

import com.niubiz.bot.frontend.base.BaseClass;
import com.niubiz.bot.frontend.pages.excel.UtilsExcel;
import com.niubiz.bot.frontend.utility.ExcelReader;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils extends BaseClass {

    private UtilsExcel ue = new UtilsExcel();
    private WebDriver driver;
    public Utils(WebDriver driver) throws Throwable {
        this.driver = driver;
    }
    public String getData(String sheet, int fila, String columna) throws Throwable {
        return ExcelReader.getCellValue(sheet, fila, columna);
    }

    /*public String getNewRUC(int FilaData, Boolean sw) throws Throwable {
        //ExcelReader.cargaExcel("excel/PLANTILLA_DATA2.xlsx");

        List<String> list = new ArrayList<String>();
        List<String> listIndex = new ArrayList<String>();
        int nroFilas = ExcelReader.getNumberOfRows(ue.PAGE_SHEET3);
        for(int i=0; i< nroFilas;i++){
            if(ExcelReader.getCellValue(ue.PAGE_SHEET3,i,ue.FLG).equals("0")){
                listIndex.add(String.valueOf(i));
                list.add(ExcelReader.getCellValue(ue.PAGE_SHEET3,i,ue.RUC).replace("'",""));
            }
        }

        int random = (int)Math.floor(Math.random()*(list.size()+1));
        //System.out.println(list.size());
        //System.out.println(random);
        if(sw) {
            ExcelReader.writeCellValue(ue.PAGE_SHEET3, Integer.parseInt(listIndex.get(random)), ue.FLG, "1");
            ExcelReader.writeCellValue(ue.PAGE_SHEET1, FilaData, ue.COMENTARIO, "Se obtuvo un RUC valido y se agregó el flag en data de prueba");
        }
        else {
            ExcelReader.writeCellValue(ue.PAGE_SHEET1, FilaData, ue.COMENTARIO, "Se obtuvo un RUC valido pero no se agregó flag en data de prueba");
        }
        String RUC=list.get(random);

        ExcelReader.writeCellValue(ue.PAGE_SHEET1,FilaData,ue.RUC,RUC);
        System.out.println("Fila: "+FilaData+" RUC: "+RUC);

        //ExcelReader.guardaExcel(configReader.lastfilecreate()+"ExcelFile/");
        return RUC;
    }*/
}
