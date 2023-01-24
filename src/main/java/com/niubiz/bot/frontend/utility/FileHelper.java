/*
    @author: Abraham Hernandez - TSOFT
*/
package com.niubiz.bot.frontend.utility;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.Scanner;

public class FileHelper {
    private FileHelper() {
    }

    public static String getProjectFolder() {

        return System.getProperty("user.dir");
    }

    public static void deleteFolderElements(String carpeta) {

        // al iniciar borrar todos los archivos png de la carpeta img
        File folder = new File(FileHelper.getProjectFolder() + carpeta);
        if (folder.exists() && folder.isDirectory()) {
            try {
                FileUtils.cleanDirectory(folder);
            } catch (Exception e) {
                System.out.println("[ERROR CRL-946] Error borrando la carpeta " + carpeta + ": " + e.getMessage());
            }
        }
    }

    public static void moveTempFiles(String sourceFrom,String sourceTo){
        File from = new File(FileHelper.getProjectFolder()+ sourceFrom);
        File to = new File(FileHelper.getProjectFolder() + sourceTo);

        try {
            Files.move(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Directory moved successfully.");
        }
        catch (IOException ex) {
            System.out.println("Error!:" + ex);
            //ex.printStackTrace();
        }
    }

    public static void actualizaHTML(String PATH) throws InterruptedException {
        //String PATH = "D:\\NIUBIZ\\Frank\\NewFramework\\elemplo2\\Selenium-Web\\Reports\\ReportHistory\\ 22-ene-23_13-26-23\\test-output\\ReportHTML\\Index.html";
        // LECTURA
        Thread.sleep(10000);
        File fichero = new File(PATH);
        Scanner s = null;
        String lineas = "";
        try {
            // Leemos el contenido del fichero
            s = new Scanner(fichero);
            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                lineas=lineas+"\n"+linea; // Guardamos las lineas en un String
                //System.out.println(linea);      // Imprimimos la linea
            }
        } catch (Exception ex) {
            System.out.println("Error durante la lectura: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Error al cerrar el HTML de lectura: " + ex2.getMessage());
            }
        }
        String[] textToReplace = {
                "<span>com.niubiz.bot.frontend.helpers.Hook.passStep(io.cucumber.java.Scenario)</span>",
                "                  <div class=\"step pass-bg\">\n" +
                        "                    <span>com.niubiz.bot.frontend.helpers.Hook.failStep(io.cucumber.java.Scenario)</span>",
                "                  <div class=\"step fail-bg\">\n"
        };

        lineas = lineas.replace(textToReplace[0],"");
        lineas = lineas.replace(textToReplace[1],textToReplace[2]);

        // ESCRITURA
        try {
            FileWriter ficheroOUT = new FileWriter(PATH);
            // Escribimos linea a linea en el fichero
            ficheroOUT.write(lineas);
            ficheroOUT.close();
        } catch (Exception ex) {
            System.out.println("Error en el guardado del HTML: " + ex.getMessage());
        }

    }
}
