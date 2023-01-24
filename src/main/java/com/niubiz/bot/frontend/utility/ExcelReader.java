package com.niubiz.bot.frontend.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;
import static com.niubiz.bot.frontend.utility.FileHelper.moveTempFiles;


public class ExcelReader {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ExcelReader.class);
    public static FileInputStream fs = null;
    public static XSSFWorkbook newWorkbook = null;
    public static XSSFWorkbook newWorkbookDATA = null;
    public static File rutaFile = null;
    public static String File = null;
    public static String SheetName = "";
    public static String NameData = "DATA DE PRUEBA";
    public static Boolean swsave =false;
    private static ConfigReader configReader = new ConfigReader();
    private static Properties prop = configReader.init_prop();
    public ExcelReader() {
    }

    public static void cargaExcel(String rutaRelativaExcel){
        try {
            String ruta = FileHelper.getProjectFolder() + "/src/main/resources/" + rutaRelativaExcel;
            File = rutaRelativaExcel;
            rutaFile = new File(ruta);
            if (!rutaFile.exists()) throw new Exception("El archivo " + rutaFile.getName() + " no existe!");
            fs = new FileInputStream(rutaFile);
            newWorkbook = new XSSFWorkbook(fs);
            fs = new FileInputStream(rutaFile);
            newWorkbookDATA = new XSSFWorkbook(fs);
            moveTempFiles(prop.getProperty("word.temp"),configReader.lastfilecreate()+"TempDocs");
        }catch (Exception e){
            Logger.getLogger(" Shows: "+ e.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static int getNumberOfRows(String sheetName){
        int nrofilas = 0;
        try {
            XSSFSheet sheet = newWorkbook.getSheet(sheetName);
            nrofilas = sheet.getPhysicalNumberOfRows();
        }
        catch (Exception e){
            Logger.getLogger(" Shows: "+ e.getMessage());
        }
        return nrofilas;
    }

    public static String getCellValue(String sheetName, int rowNumber, String cellName){
        String valueExcel = null;
        int cellNumber = 0;
        try {
            XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

            Row headerRow = newSheet.getRow(0);
            int nroColumnas = headerRow.getPhysicalNumberOfCells();
            for (int j = 0; j < nroColumnas; j++) {
                if(headerRow.getCell(j).getStringCellValue().equals(cellName)){
                    cellNumber=j;
                    break;
                }
            }

            XSSFRow row = newSheet.getRow(rowNumber);
            XSSFCell nextCell = row.getCell(cellNumber);
            DataFormatter formatter = new DataFormatter();
            valueExcel = formatter.formatCellValue(nextCell);
        }
        catch (Exception e){
            Logger.getLogger(" Shows: "+ e.getMessage());
        }
        return valueExcel;
    }

    public static void writeCellValue(String sheetName, int rowNumber, String cellName, String resultText){
        SheetName = sheetName;
        try {
            XSSFWorkbook Workbook = newWorkbook;
            Boolean sw = true;
            int i = 0;
            int cellNumber = 0;

            while (sw){
                XSSFSheet newSheet = Workbook.getSheet(sheetName);
                CellStyle style = Workbook.createCellStyle();
                Font font = Workbook.createFont();
                style.setFont(font);

                Row headerRow = newSheet.getRow(0);
                int nroColumnas = headerRow.getPhysicalNumberOfCells();
                for (int j = 0; j < nroColumnas; j++) {
                    if(headerRow.getCell(j).getStringCellValue().equals(cellName)){
                        cellNumber=j;
                        break;
                    }
                }

                XSSFRow row = newSheet.getRow(rowNumber);
                XSSFCell nextCell = row.createCell(cellNumber);
                nextCell.setCellValue(resultText);
                sw = false;

                if(sheetName.equals(NameData) & (i == 0)){
                    Workbook = newWorkbookDATA;
                    i=i+1;
                    swsave = true;
                    sw = true;
                }
            }
        }
        catch (Exception e){
                Logger.getLogger(" Shows: "+ e.getMessage());
        }
    }

    public static void guardaExcel(String Savepath) throws IOException {
        try {
            XSSFWorkbook Workbook = newWorkbook;
            Boolean sw = true;
            int i = 0;
            File rutaFileOriginal = rutaFile;


            String ruta = FileHelper.getProjectFolder() + Savepath;


            rutaFile = new File(ruta);
            File rutaFile2 = new File(ruta+File.replace("excel/",""));
            if(!rutaFile.exists()){
                rutaFile.mkdirs();
            }
            if(!rutaFile2.exists()){
                rutaFile2.createNewFile();
            }

            while (sw){
                FileOutputStream outputStream = new FileOutputStream(rutaFile2);
                Workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
                sw=false;

                if(swsave & i == 0){
                    Workbook = newWorkbookDATA;
                    rutaFile2 = rutaFileOriginal;
                    i=i+1;
                    sw = true;
                }
            }

        }
        catch (Exception e){
            logger.error(" Shows: "+ e.getMessage());
        }finally {
            assert newWorkbook != null;
            newWorkbook.close();
            assert newWorkbookDATA != null;
            newWorkbookDATA.close();
        }
    }

}
