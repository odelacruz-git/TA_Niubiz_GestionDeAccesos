package com.niubiz.bot.frontend.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.niubiz.bot.frontend.utility.FileHelper.moveTempFiles;

public class GenerateWordFinal {

    private static final ConfigReader configReader = new ConfigReader();
    private static final Properties prop = configReader.init_prop();
    private static final String PATH_RELATIVE_WORD = prop.getProperty("word.portada");
    private static final String WORD_TEMP = FileHelper.getProjectFolder() + prop.getProperty("word.temp"); //CARPETA TEMPORAL DE LOS DOCUMENTOS
    private static final String WORD_NAME_STANDAR = WORD_TEMP +"/0_Portada.docx";
    private static final String H_ZONE = "America/Bogota";
    private static final String WORD_EXTENSION = ".docx";
    private static String TestUser = System.getProperty("user.name");

    public static XWPFDocument document2;
    public static FileOutputStream fileOutputStream2;
    public static String TEMP_WORD_FILE;
    private static int COUNT=1;
    private static int COUNT2=0;
    private static int COUNT3=1;
    private static List<Integer> list_numbercase = new ArrayList<Integer>();
    private static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    private static final Logger logger = LogManager.getLogger(GenerateWordFinal.class);

    private static void combinarCeldas(XWPFTable table, int row, Long column){
        table.getRow(row).getCell(0).getCTTc().addNewTcPr();
        table.getRow(row).getCell(0).getCTTc().getTcPr().addNewGridSpan();
        table.getRow(row).getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(column));
    }
    private static void formatoTextoTabla(XWPFTable table, int row, int colum, int paragraphs, String text, int FontSize, boolean Bold, String colorRGB, Object backgroundColor, ParagraphAlignment position){
        table.getRow(row).getCell(colum).getParagraphs().get(paragraphs).setAlignment(position);
        table.getRow(row).getCell(colum).getCTTc().addNewTcPr().addNewShd().setFill(backgroundColor);
        table.getRow(row).getCell(colum).getParagraphs().get(paragraphs).setSpacingAfter(0);
        XWPFRun k = table.getRow(row).getCell(colum).getParagraphs().get(paragraphs).createRun();
        k.setText(text);
        k.setFontFamily("Arial");
        k.setFontSize(FontSize);
        k.setBold(Bold);
        k.setColor(colorRGB);
        if(row==3){
            table.getRow(row).getCell(colum).getParagraphs().get(paragraphs).setStyle("CDP");
        }
    }

    private static void crearTabla(XWPFTable table){
        table.setWidth("100%");
        formatoTextoTabla(table,0,0,0,"Número CP",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).createCell();
        formatoTextoTabla(table,0,1,0,"Fecha",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).createCell();
        formatoTextoTabla(table,0,2,0,"Tester",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).createCell();
        formatoTextoTabla(table,0,3,0,"Estado",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);

        table.getRow(0).getCell(0).setWidth("17%");
        table.getRow(0).getCell(1).setWidth("17%");
        table.getRow(0).getCell(3).setWidth("17%");

        table.getRow(1).getCell(0).setText("");
        table.getRow(1).createCell().setText("");
        table.getRow(1).createCell().setText("");
        table.getRow(1).createCell().setText("");

        combinarCeldas(table,2,4L);
        formatoTextoTabla(table,2,0,0,"Descripción del Caso de Prueba",11,true,"000080", "BFBFBF", ParagraphAlignment.LEFT);

        combinarCeldas(table,3,4L);
        table.getRow(3).getCell(0).setText("");

        combinarCeldas(table,4,4L);
        formatoTextoTabla(table,4,0,0,"Dato de prueba",11,true,"000080","BFBFBF", ParagraphAlignment.LEFT);

        combinarCeldas(table,5,4L);
        table.getRow(5).getCell(0).setText("");

        combinarCeldas(table,6,4L);
        formatoTextoTabla(table,6,0,0,"Evidencia de ejecución del caso",11,true,"000080","BFBFBF", ParagraphAlignment.LEFT);

        combinarCeldas(table,7,4L);
        table.getRow(7).getCell(0).setText("");
        //XWPFRun t = table.getRow(5).getCell(0).addParagraph().createRun();

    }

    public static void startUpFinalWord() throws IOException {
        //Enviar el numero al documento general
        try {
            InputStream stream = new FileInputStream(new File(FileHelper.getProjectFolder()+PATH_RELATIVE_WORD));
            document2 = new XWPFDocument(stream);
            String carpeta = WORD_TEMP;
            FileUtils.forceMkdir(new File(carpeta));
            TEMP_WORD_FILE = FileUtils.getFile(carpeta) + "/Reporte" + "-" + generarSecuencia() + WORD_EXTENSION;
            fileOutputStream2 = new FileOutputStream(TEMP_WORD_FILE);

        } catch (Exception e) {
            logger.error("Error!: " + e);
        }
        logger.info("[LOG] Word Final generado");
    }

    public static void generaTabla(){
        XWPFTable Tabla = document2.createTable(8,1);
        document2.createParagraph().setPageBreak(true);
        crearTabla(Tabla);
    }

    public static void agregaNCP(Integer i){
        list_numbercase.add(i);
    }

    public static int sizeNCP(){
        return list_numbercase.size();
    }

    public static void ordenaNCP(int NCP) throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Esperando para obtener todas sesiones de los Scenarios");
        if(NCP==list_numbercase.get(COUNT-1)){
            System.out.println("NCP: "+NCP);

            if((COUNT!=COUNT3)||(COUNT==1)){
                Collections.sort(list_numbercase);
            }

            for(int i=0; i<list_numbercase.size();i++){
                if(i==COUNT-1){
                    hm.put(list_numbercase.get(i),COUNT);
                    generaTabla();
                    COUNT=COUNT+1;
                }
            }
            COUNT3=COUNT3+1;

            System.out.println("HM: "+hm);
        }
        Thread.sleep(2000);
        /*int ntablas = document2.getTables().size()-1;
        if(!(sizeNCP() == ntablas)){
            System.out.println("NCP: "+sizeNCP()+" NTABLAS:"+ntablas);
            Thread.sleep(3000);
        }*/
    }

    public static void sendBreak(XWPFTable Table) {
        Table.getRow(7).getCell(0).addParagraph().setSpacingAfter(0);
    }

    public static void addImageElementToWord(int Numbercase, WebDriver driver, By locator) throws IOException {
        // obtener i en base al numero N:Numbercase
        int i=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(i);
        InputStream inputStream = null;
        try {
            XWPFRun k = Table.getRow(7).getCell(0).addParagraph().createRun();
            WebElement element=driver.findElement(locator);
            Screenshot Screenshot_webele = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(Screenshot_webele.getImage(), "PNG", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "IMG"+COUNT2, Units.toEMU(420), Units.toEMU(200));
            //sendBreak(Table);
            COUNT2=COUNT2+1;

        } catch (IOException | InvalidFormatException ex) {
            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }
    public static void addImageToWord(int Numbercase, WebDriver driver) throws IOException {
        // obtener i en base al numero N:Numbercase
        int i=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(i);

        InputStream inputStream = null;
        try {
            XWPFRun k = Table.getRow(7).getCell(0).addParagraph().createRun();
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            inputStream = new FileInputStream(source);
            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "IMG"+COUNT2, Units.toEMU(420), Units.toEMU(200));
            //sendBreak(Table);
            COUNT2=COUNT2+1;
        } catch (IOException | InvalidFormatException ex) {
            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }
    }

    public static void addFullImageToWord(int Numbercase, WebDriver driver) throws IOException {
        // obtener i en base al numero N:Numbercase
        int i=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(i);
        InputStream inputStream = null;
        try {
            XWPFRun k = Table.getRow(7).getCell(0).addParagraph().createRun();

            Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(s.getImage(), "PNG", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());

            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "IMG"+COUNT2,Units.toEMU(465),Units.toEMU(440));
            //sendBreak(Table);
            COUNT2=COUNT2+1;

        } catch (IOException | InvalidFormatException ex) {

            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }

    public static void sendText(int Numbercase, String texto) {
        // obtener i en base al numero N:Numbercase
        int n=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(n);
        int i=Table.getRow(7).getCell(0).getParagraphs().size();
        formatoTextoTabla(Table,7,0,i-1,
                texto+ " | " + "Hora: " + generarHora(),
                10,true, "000000","FFFFFF", ParagraphAlignment.LEFT);
        sendBreak(Table);
    }

    public static void sendDescript(int Numbercase, String texto, Boolean bold) {
        // obtener i en base al numero N:Numbercase
        int n=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(n);

        int i=Table.getRow(7).getCell(0).getParagraphs().size();
        if(i>1){
            sendBreak(Table);
            i=i+1;
        }
        formatoTextoTabla(Table,7,0,i-1,
                texto,
                10,bold, "000000","FFFFFF", ParagraphAlignment.LEFT);


    }

    public static void sendCP(int Numbercase,String CP, String Description) {
        // obtener i en base al numero N:Numbercase
        int n=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(n);

        formatoTextoTabla(Table,1,0,0, CP,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table,1,2,0, TestUser,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table,1,1,0, generarFecha(),10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table,3,0,0,CP + " " + Description,10,false,"000000","FFFFFF", ParagraphAlignment.LEFT);

    }

    public static void setStatusTable(int Numbercase, String status) throws InterruptedException {
        // obtener i en base al numero N:Numbercase
        int n=hm.get(Numbercase);
        XWPFTable Table = document2.getTables().get(n);
        formatoTextoTabla(Table,1,3,0,status,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);

        Thread.sleep(3000);
    }

    public static void endToFinalWord(String carpetaBase) throws IOException {
        try {
            indice("[Listado]");
            document2.write(fileOutputStream2);
            fileOutputStream2.close();
            Thread.sleep(2000);
            moveTempFiles(prop.getProperty("word.temp"),carpetaBase);

        } catch (FileNotFoundException e) {
            logger.error("Show: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("[LOG] Word cerrado");
    }

    public static void indice(String searchValue){
        document2.createTOC();
        addCustomHeadingStyle(document2, "Módulo", 1);
        addCustomHeadingStyle(document2, "Funcionalidad", 2);
        addCustomHeadingStyle(document2, "CDP", 3);

        for (XWPFParagraph paragraph : document2.getParagraphs()) {
            if (StringUtils.contains(paragraph.getText(), searchValue)) {
                int size = paragraph.getRuns().size();
                for (int i = 0; i < size; i++) {
                    paragraph.removeRun(0);
                }
                CTP ctP = paragraph.getCTP();
                CTSimpleField toc = ctP.addNewFldSimple();
                toc.setInstr("TOC \\h");
                toc.setDirty(STOnOff.TRUE);
            }
        }
    }

    private static void addCustomHeadingStyle(XWPFDocument docxDocument, String strStyleId, int headingLevel) {

        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);

        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        // is a null op if already defined
        XWPFStyles styles = docxDocument.createStyles();

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);

    }

    private static String generarSecuencia() {
        DateFormat df = new SimpleDateFormat("d-MMM-yy_HH-mm-ss");
        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));
        return df.format(new Date());
    }

    private static String generarFecha() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));
        return df.format(new Date());
    }

    private static String generarHora() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));
        return df.format(new Date());
    }

}
