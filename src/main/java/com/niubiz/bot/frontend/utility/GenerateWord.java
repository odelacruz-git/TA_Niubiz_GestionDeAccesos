package com.niubiz.bot.frontend.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class GenerateWord {

    private static final String PATH_RELATIVE_WORD = "/src/main/resources/template/Evidencia.docx";
    private static final String TEMPLATE = "/src/main/resources/template/Plantilla.png"; // PLANTILLA DE IMAGEN INICIAL
    private static final String WORD_NAME_STANDAR = "Evidencia.docx";
    private static final String FILE_PATH_STANDAR = FileHelper.getProjectFolder() + "/Reports/resultadosIndividuales/"; //CARPETA BASE DE LOS DOCUMENTOS
    private static final String H_ZONE = "America/Bogota";
    private static final String WORD_EXTENSION = ".docx";

    //private static String TEMP_WORD_FILE;
    //private static XWPFDocument document;
    //private static XWPFRun run;
    //private static FileOutputStream fileOutputStream;
    public static String nameScenario = "";
    public static String logWord = "";
    public static int fila;

    public static ThreadLocal<XWPFDocument> document2 = new ThreadLocal<>();
    public static ThreadLocal<XWPFRun> run2 = new ThreadLocal<>();
    public static ThreadLocal<FileOutputStream> fileOutputStream2 = new ThreadLocal<>();
    public static ThreadLocal<String> TEMP_WORD_FILE = new ThreadLocal<>();
    public static ThreadLocal<XWPFTable> Table = new ThreadLocal<>();

    public static synchronized XWPFDocument getdocumen() {
        return document2.get();
    }
    public static synchronized XWPFRun getrun() {
        return run2.get();
    }
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

    private static XWPFTable combinarCeldas(XWPFTable table, int row, Long column){
        table.getRow(row).getCell(0).getCTTc().addNewTcPr();
        table.getRow(row).getCell(0).getCTTc().getTcPr().addNewGridSpan();
        table.getRow(row).getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(column));
        return table;
    }
    private static void formatoTextoTabla(XWPFTable table, int row, int colum, String text, int FontSize, boolean Bold, String colorRGB, Object backgroundColor, ParagraphAlignment position){
        table.getRow(row).getCell(colum).getParagraphs().get(0).setAlignment(position);
        table.getRow(row).getCell(colum).getCTTc().addNewTcPr().addNewShd().setFill(backgroundColor);
        XWPFRun k = table.getRow(row).getCell(colum).getParagraphs().get(0).createRun();
        k.setText(text);
        k.setFontFamily("Century Gothic");
        k.setFontSize(FontSize);
        k.setBold(Bold);
        k.setColor(colorRGB);
    }

    private static XWPFTable crearTabla(XWPFTable table){
        table.setWidth("100%");
        formatoTextoTabla(table,0,0,"Número CP",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).createCell();
        formatoTextoTabla(table,0,1,"Tester",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).createCell();
        formatoTextoTabla(table,0,2,"Fecha",11,true,"000080", "BFBFBF", ParagraphAlignment.CENTER);
        table.getRow(0).getCell(0).setWidth("15%");
        table.getRow(0).getCell(2).setWidth("15%");

        table.getRow(1).getCell(0).setText("");
        table.getRow(1).createCell().setText("");
        table.getRow(1).createCell().setText("");

        combinarCeldas(table,2,3L);
        formatoTextoTabla(table,2,0,"Descripción del Caso de Prueba",11,true,"000080", "BFBFBF", ParagraphAlignment.LEFT);

        combinarCeldas(table,3,3L);
        table.getRow(3).getCell(0).setText("");

        combinarCeldas(table,4,3L);
        formatoTextoTabla(table,4,0,"Evidencia de ejecución del caso",11,true,"000080","BFBFBF", ParagraphAlignment.LEFT);

        combinarCeldas(table,5,3L);
        table.getRow(5).getCell(0).setText("");
        //XWPFRun t = table.getRow(5).getCell(0).addParagraph().createRun();

        return table;
    }

    public static void startUpWord(String name) throws IOException {
        InputStream insertTemplate = null;
        XWPFParagraph paragraph;
        try {
            File fileUnique = new File(FileHelper.getProjectFolder() + PATH_RELATIVE_WORD);
            copyExistentWord(fileUnique);
            document2.set(new XWPFDocument());
            Table.set(getdocumen().createTable(6,1));
            crearTabla(Table.get());
            //paragraph = getdocumen().createParagraph();
            //run2.set(paragraph.createRun());
            run2.set(Table.get().getRow(5).getCell(0).getParagraphs().get(0).createRun());
            String carpeta = FILE_PATH_STANDAR;
            FileUtils.forceMkdir(new File(carpeta));
            TEMP_WORD_FILE.set(FileUtils.getFile(carpeta) + "/" + name + "-" + generarSecuencia() + WORD_EXTENSION);
            fileOutputStream2.set(new FileOutputStream(FileUtils.getFile(carpeta) + "/" + name + "-" + generarSecuencia() + WORD_EXTENSION));
            //insertTemplate = new FileInputStream(FileHelper.getProjectFolder() + TEMPLATE);
            //getrun().addPicture(insertTemplate, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(440), Units.toEMU(740));
            //getrun().addBreak();
        } catch (Exception e) {
            logger.error("Show " + e);
        }finally {
            if (insertTemplate != null) insertTemplate.close();
        }

        logger.info("[LOG] Word generado");
    }
    public void setlogStep(String log){
        logWord = log;
        logger.info(log);
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getlogStep(){
        return logWord;
    }

    public void setnameStep(String name){
        nameScenario = name;
    }
    public String getnameStep(){
        return nameScenario;
    }

    public void sendBreak() {
        getrun().addBreak();
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


    public void addImageToWord(WebDriver driver) throws IOException {
        InputStream inputStream = null;
        try {

            TakesScreenshot screenshot = ((TakesScreenshot) driver);

            File source = screenshot.getScreenshotAs(OutputType.FILE);

            inputStream = new FileInputStream(source);

            getrun().addPicture(inputStream, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(465), Units.toEMU(200));

            getrun().addBreak();

        } catch (IOException | InvalidFormatException ex) {

            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }

    public void addFullImageToWord(WebDriver driver) throws IOException {
        InputStream inputStream = null;
        try {
            Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(s.getImage(), "PNG", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());

            getrun().addPicture(inputStream, Document.PICTURE_TYPE_PNG, "1", Units.toEMU(200), Units.toEMU(550));

            getrun().addBreak();

        } catch (IOException | InvalidFormatException ex) {

            logger.error("Show: " + ex);
        }finally {
            if (inputStream != null) inputStream.close();
        }

    }

    public void sendText(String texto) {
        getrun().setText("Fecha : " + generarFecha() + ", Hora : " + generarHora() + " | " + texto);
        getrun().addTab();
        getrun().setFontFamily("Century Gothic");
        getrun().setFontSize(9);
        getrun().addBreak();
    }

    public void sendDescript(String texto) {
        getrun().setText(texto);
        getrun().addTab();
        getrun().setFontFamily("Century Gothic");
        getrun().setFontSize(9);
        getrun().addBreak();
    }

    public void sendDescriptCP(String CP, String Description) {

        formatoTextoTabla(Table.get(),1,0,CP,9,false,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table.get(),1,2,generarFecha(),9,false,"000000","FFFFFF", ParagraphAlignment.CENTER);
        formatoTextoTabla(Table.get(),3,0,CP + " " + Description,9,false,"000000","FFFFFF", ParagraphAlignment.LEFT);

    }

    public void sendBoldText(String texto) {
        getrun().setBold(true);
        getrun().setText("Fecha : " + generarFecha() + ", Hora : " + generarHora() + " | " + texto);
        getrun().addTab();
        getrun().setFontFamily("Century Gothic");
        getrun().setFontSize(9);
        getrun().addBreak();
    }

    public void endToWord(String status) throws IOException {
        try {

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
        } catch (Exception e) {
            logger.error("Show: " + e);
        }
        finally {
            System.out.println("");
        }
        logger.info("[LOG] Word cerrado");
    }

    private static String generarSecuencia() {

        DateFormat df = new SimpleDateFormat("d-MMM-YY_HH-mm-ss");

        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));

        return df.format(new Date());

    }


    private static String generarFecha() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));

        return df.format(new Date());

    }

    private static String generarHora() {
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(H_ZONE));

        return df.format(new Date());
    }

}
