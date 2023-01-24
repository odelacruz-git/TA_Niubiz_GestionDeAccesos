package com.niubiz.bot.frontend.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;


public class GenerateWord {

    private static final ConfigReader configReader = new ConfigReader();
    private static final Properties prop = configReader.init_prop();
    private static final String PATH_RELATIVE_WORD = prop.getProperty("word.portada");
    //private static final String TEMPLATE = "/src/main/resources/template/Plantilla.png"; // PLANTILLA DE IMAGEN INICIAL
    private static final String WORD_TEMP = FileHelper.getProjectFolder() + prop.getProperty("word.temp"); //CARPETA TEMPORAL DE LOS DOCUMENTOS
    private static final String WORD_NAME_STANDAR = WORD_TEMP +"/0_Portada.docx";
    private static final String H_ZONE = "America/Bogota";
    private static final String WORD_EXTENSION = ".docx";
    private final String TestUser = System.getProperty("user.name");

    //private static String TEMP_WORD_FILE;
    //private static XWPFDocument document;
    //private static XWPFRun run;
    //private static FileOutputStream fileOutputStream;

    public static ThreadLocal<String> nameScenario = new ThreadLocal<>();
    public static ThreadLocal<String> logWord = new ThreadLocal<>();
    public static ThreadLocal<Integer> fila = new ThreadLocal<>();

    public static ThreadLocal<XWPFDocument> document2 = new ThreadLocal<>();
    //public static ThreadLocal<XWPFRun> run2 = new ThreadLocal<>();
    public static ThreadLocal<FileOutputStream> fileOutputStream2 = new ThreadLocal<>();
    public static ThreadLocal<String> TEMP_WORD_FILE = new ThreadLocal<>();
    public static ThreadLocal<XWPFTable> Table = new ThreadLocal<>();

    public static synchronized String getnameScenario() {
        return nameScenario.get();
    }
    public static synchronized String getlogWord() {
        return logWord.get();
    }
    public static synchronized Integer getsfila() {
        return fila.get();
    }

    public static synchronized XWPFDocument getdocumen() {
        return document2.get();
    }
    public static XWPFParagraph paragraph;
    /*public static synchronized XWPFRun getrun() {
        return run2.get();
    }*/
    public static synchronized XWPFTable gettable() {
        return Table.get();
    }
    public static synchronized FileOutputStream getFileOutputStream() {
        return fileOutputStream2.get();
    }
    public static synchronized String getTempWordFile() {
        return TEMP_WORD_FILE.get();
    }

    private static final Logger logger = LogManager.getLogger(GenerateWord.class);

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

    public static void startUpWord(String name) throws IOException {
        //Envia el numero de N al documento general
        GenerateWordFinal.agregaNCP(Integer.parseInt(name.split("_")[0]));

        InputStream insertTemplate = null;

        //XWPFParagraph paragraph;
        try {
            InputStream stream = new FileInputStream(new File(FileHelper.getProjectFolder()+PATH_RELATIVE_WORD));
            XWPFDocument template = new XWPFDocument(stream);

            //OPCPackage srcPackage = OPCPackage.open(stream);
            //document2.set(new XWPFDocument(stream));
            document2.set(new XWPFDocument());

            XWPFStyles newStyles = getdocumen().createStyles();
            newStyles.setStyles(template.getStyle());

            Table.set(getdocumen().createTable(8,1));
            crearTabla(Table.get());
            //run2.set(paragraph.createRun());
            //run2.set(Table.get().getRow(7).getCell(0).getParagraphs().get(0).createRun());
            String carpeta = WORD_TEMP;
            FileUtils.forceMkdir(new File(carpeta));
            TEMP_WORD_FILE.set(FileUtils.getFile(carpeta) + "/" + name + "-" + generarSecuencia() + WORD_EXTENSION);
            fileOutputStream2.set(new FileOutputStream(getTempWordFile()));
            //insertTemplate = new FileInputStream(FileHelper.getProjectFolder() + TEMPLATE);
            //getrun().addPicture(insertTemplate, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(440), Units.toEMU(740));
            //getrun().addBreak();
            //copyExistentWord(new File(FileHelper.getProjectFolder() + PATH_RELATIVE_WORD));

        } catch (Exception e) {
            System.out.println(e);
            logger.error("Show " + e);
        }finally {
            if (insertTemplate != null) insertTemplate.close();
        }

        logger.info("[LOG] Word generado");
    }
    public void setlogStep(String log){
        logWord.set(log);
    }
    public String getlogStep(){
        return getlogWord();
    }

    public void setnameStep(String name){
        nameScenario.set(name);
    }
    public String getnameStep(){
        return getnameScenario();
    }

    public void setFila(int fil) {
        fila.set(fil);
    }
    public int getFila() {
        return getsfila();
    }

    public static void copyExistentWord(File file) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        boolean threw = true;
        try {
        File fileUnique = new File(file.getPath());
        File copyFile = new File(WORD_NAME_STANDAR);
        input = new FileInputStream(fileUnique);
        output = new FileOutputStream(copyFile);
        byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            threw = false;
        } catch (Exception e) {
            logger.error("Show: " + e);
        }finally {
            IOUtils.closeQuietly(input);
            assert output != null;
            output.close();
        }
    }

    public void sendBreak() {
        Table.get().getRow(7).getCell(0).addParagraph().setSpacingAfter(0);
        //XWPFRun k = Table.get().getRow(7).getCell(0).addParagraph().createRun();
        //k.addBreak();
        //countparagraph.set(i+1);
        //getrun().addBreak();
    }
    public void addImageElementToWord(WebDriver driver, By locator) throws IOException {
        GenerateWordFinal.addImageElementToWord(getFila(),driver,locator);
        InputStream inputStream = null;
        try {
            XWPFRun k = Table.get().getRow(7).getCell(0).addParagraph().createRun();
            WebElement element=driver.findElement(locator);
            Screenshot Screenshot_webele = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(Screenshot_webele.getImage(), "PNG", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(420), Units.toEMU(200));
            sendBreak();

        } catch (IOException | InvalidFormatException ex) {
            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }
    public void addImageToWord(WebDriver driver) throws IOException {
        GenerateWordFinal.addImageToWord(getFila(),driver);
        InputStream inputStream = null;
        try {
            XWPFRun k = Table.get().getRow(7).getCell(0).addParagraph().createRun();
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            inputStream = new FileInputStream(source);
            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(420), Units.toEMU(200));
            sendBreak();
        } catch (IOException | InvalidFormatException ex) {
            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }
    }

    public void addFullImageToWord(WebDriver driver) throws IOException {
        GenerateWordFinal.addFullImageToWord(getFila(),driver);
        InputStream inputStream = null;
        try {
            XWPFRun k = Table.get().getRow(7).getCell(0).addParagraph().createRun();

            Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(s.getImage(), "PNG", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());

            k.addPicture(inputStream, Document.PICTURE_TYPE_PNG, "1",Units.toEMU(465),Units.toEMU(440));

            sendBreak();

        } catch (IOException | InvalidFormatException ex) {

            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }

    public void sendText(String texto) {
        GenerateWordFinal.sendText(getFila(),texto);
        //int i=getscountparagraph();
        int i=Table.get().getRow(7).getCell(0).getParagraphs().size();
        if(i>1){
            sendBreak();
            i=i+1;
        }
        formatoTextoTabla(Table.get(),7,0,i-1,
                texto+ " | " + "Hora: " + generarHora(),
                10,true, "000000","FFFFFF", ParagraphAlignment.LEFT);
        logger.info(texto);
    }

    public void sendDescript(String texto, Boolean bold) {
        GenerateWordFinal.sendDescript(getFila(),texto,bold);
        int i=Table.get().getRow(7).getCell(0).getParagraphs().size();
        if(i>1){
            sendBreak();
            i=i+1;
        }
        formatoTextoTabla(Table.get(),7,0,i-1,
                texto,
                10,bold, "000000","FFFFFF", ParagraphAlignment.LEFT);

        logger.info(texto);
    }

    public void sendCP(String CP, String Description) {
        GenerateWordFinal.sendCP(getFila(),CP,Description);

        formatoTextoTabla(Table.get(),1,0,0, CP,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table.get(),1,2,0, TestUser,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table.get(),1,1,0, generarFecha(),10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table.get(),3,0,0,CP + " " + Description,10,false,"000000","FFFFFF", ParagraphAlignment.LEFT);

    }

    public void endToWord(String status) throws IOException {
        try {
            GenerateWordFinal.setStatusTable(getFila(),status);

            formatoTextoTabla(Table.get(),1,3,0,status,10,true,"000000","FFFFFF", ParagraphAlignment.CENTER);
            //WordMergef.add(getFila(),getdocumen().getDocument().getBody());
            //WordMerge.add(getFila(),getdocumen());

            //getdocumen().createParagraph().createRun().addBreak();
            //getdocumen().createParagraph().createRun().addBreak(BreakType.PAGE);
            //getdocumen().createParagraph().setPageBreak(true);
            getdocumen().write(getFileOutputStream());
            getFileOutputStream().close();
            File fileWithNewName = new File(getTempWordFile().split("\\.docx")[0] + "-" + status.toUpperCase() + WORD_EXTENSION);
            if (new File(getTempWordFile()).renameTo(fileWithNewName)) {
                logger.info("[LOG] WORD: Evidencia renombrada - Se añadió el estado final del escenario");
            } else {
                logger.warn("[LOG] WORD: Evidencia no pudo ser renombrada - No Se añadió el estado final del escenario");
            }
            /*
            File file = new File(FileHelper.getProjectFolder() + "/Evidencia.docx");
            if (file.exists()) {
                return;
            }*/
        } catch (FileNotFoundException | InterruptedException e) {
            logger.error("Show: " + e);
        }
        logger.info("[LOG] Word cerrado");
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
