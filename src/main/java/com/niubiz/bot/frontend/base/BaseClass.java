package com.niubiz.bot.frontend.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niubiz.bot.frontend.utility.GenerateWord;
import com.niubiz.bot.frontend.utility.Sleeper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BaseClass {
    private static WebDriverWait webDriverWait;
    protected static GenerateWord generateWord = new GenerateWord();
    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    private static final Date dNow = new Date();
    private static final SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

    public BaseClass(){}

    protected static void println(String response) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonString = gson.toJson(response);
        System.out.println(prettyJsonString);
    }

    protected static String FormatterJSON(String response) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(response);
    }
    protected Boolean isDisplayed(WebDriver driver, By locator){
        try {
            System.out.println(ft.format(dNow) +  " [isDisplayed] - " + locator);
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException we){
            generateWord.sendDescript("Error : " +we,false);
            return false;
        }
    }

    protected Boolean elementDisplayed(WebDriver driver, By locator){
            System.out.println(ft.format(dNow) +  " [isDisplayed] - " + locator);
            return driver.findElement(locator).isDisplayed();
    }
    protected Boolean elementEnabled(WebDriver driver, By locator){
        System.out.println(ft.format(dNow) +  " [isEnabled] - " + locator);
        return driver.findElement(locator).isEnabled();
    }
    protected void waitForElementNotVisible(WebDriver driver, By locator, int Seg) {
        boolean response = false;
        sleep(1000);
        if (!isDisplayed(driver, locator)){
            for (int i = 1; i <= Seg; i++) {
                sleep(Integer.parseInt(i + "000"));
                if (isDisplayed(driver, locator)){
                    response = true;
                    break;
                }
                logger.info("Validando :" + locator + i + " isPresent: " + response);
            }
        }
    }

    protected List<String> getlisttext(WebDriver driver, By locator, By locator2) throws IOException {
        List<String> mydata = new ArrayList<>();
        try {
            List<WebElement> elementName = driver.findElement(locator).findElements(locator2);
            for(int i=0; i<elementName.size(); i++){
                mydata.add(elementName.get(i).getText());
                logger.info(elementName.get(i).getText());
            }
            return mydata;
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected Integer getSizeList(WebDriver driver, By locator) throws IOException {
        try {
            List<WebElement> list = driver.findElements(locator);
            return list.size();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void click(WebDriver driver, By locator) throws IOException {
        try {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(locator).click();
            logger.info(ft.format(dNow) + " [Click] - " + locator.toString());
        }catch (RuntimeException we){
            generateWord.setlogStep("No se pudo hacer click sobre el elemento");
            errorNoElementFound(driver, locator);
            Assert.fail();
            throw we;
        }
    }

    protected void clear(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).clear();
            System.out.println(ft.format(dNow) + " [Clear] - " + locator.toString());
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void typeText(WebDriver driver, By locator, String inputText) throws IOException {
        try {
            driver.findElement(locator).sendKeys(inputText);
            logger.info(ft.format(dNow) +  " [TypeText] - " + locator+ " => " + inputText);
        }catch (RuntimeException we){
            generateWord.setlogStep("No se encontró el elemento");
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected  void copiarTexto2(WebDriver driver, By locator) throws IOException {
        try {
            WebElement e = driver.findElement(locator);
            String s = Keys.chord(Keys.CONTROL, "a");
            e.sendKeys(s);
            Thread.sleep(5000);
            String c = Keys.chord(Keys.CONTROL, "c");
            e.sendKeys(c);
            Thread.sleep(5000);
            e.sendKeys(Keys.DELETE);
            Thread.sleep(5000);
            generateWord.setlogStep("Se logró copiar el texto del elemento");
        }
        catch (Exception e ){
            generateWord.setlogStep("No se logró copiar el texto del elemento");
            Assert.fail();
        }

    }
    protected  void pegarTexto2(WebDriver driver, By locator) throws IOException {
        try {
            WebElement e = driver.findElement(locator);
            Thread.sleep(5000);
            String p = Keys.chord(Keys.CONTROL, "v");
            e.sendKeys(p);
            Thread.sleep(5000);
            generateWord.setlogStep("Se logró pegar el texto del elemento");
        }
        catch (Exception e){
            generateWord.setlogStep("No se logró copiar el texto del elemento");
            Assert.fail();
        }

    }
    protected void copiarTexto(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).sendKeys(Keys.CONTROL + "a");
            driver.findElement(locator).sendKeys(Keys.CONTROL + "c");
            generateWord.setlogStep("Se seleccionó y se copió el elemento");
        }catch (RuntimeException we){
            generateWord.setlogStep("No se pudo seleccionar y copiar el elemento");
            Assert.fail();
        }
    }

    protected void limpiarTexto(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).clear();
            generateWord.setlogStep("Elemento limpiado");
        }catch (Exception e){
            generateWord.setlogStep("No se pudo limpiar el elemento");
            Assert.fail();
        }
    }

    protected void pegarTexto(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).sendKeys(Keys.CONTROL + "v");
            generateWord.setlogStep("Se pegó el texto del elemento");
        }catch (RuntimeException we){
            generateWord.setlogStep("No se pudo pegar el texto del elemento");
            Assert.fail();
        }
    }

    protected String getAttribute(WebDriver driver, By locator, String attribute) throws IOException {
        try {
            System.out.println(ft.format(dNow) +  " [GetValue] - " + locator);
            return driver.findElement(locator).getAttribute(attribute);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }


    protected String getText(WebDriver driver, By locator) throws IOException {
        try {
            System.out.println(ft.format(dNow) +  " [GetText] - " + locator);
            return driver.findElement(locator).getText();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected String getAttributeText(WebDriver driver, By locator) throws IOException {
        try {
            System.out.println(ft.format(dNow) +  " [GetText] - " + locator);
            return driver.findElement(locator).getAttribute("value");
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected String getValuesCss(WebDriver driver, By locator,String campoCss) throws IOException {
        try {
            return driver.findElement(locator).getCssValue(campoCss);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void selectByVisibleText(WebDriver driver, By locator, String text) throws IOException {
        try {
            System.out.println(ft.format(dNow) +  " [TypeText] - " + locator+ " => " + text);
            Select typeSelect = new Select(driver.findElement(locator));
            typeSelect.selectByVisibleText(text);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void selectByValue(WebDriver driver, By locator, String text) throws IOException {
        try {
            System.out.println(ft.format(dNow) +  " [TypeText] - " + locator+ " => " + text);
            Select typeSelect = new Select(driver.findElement(locator));
            typeSelect.selectByValue(text);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected static void sleep(int milisegundos) {
        System.out.println(ft.format(dNow) +  " [Sleep] - " + (milisegundos / 1000) + " seg");
        Sleeper.sleep(milisegundos);
    }

    protected static void scrollObject(WebDriver driver,By objeto,String estado) throws InterruptedException {
       // WebElement m=driver.findElement(objeto);
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
        int valor=0;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(driver.findElement(objeto), 0, 5).click().build();
        action.perform();
        switch (estado){
            case "Aceptado":{
                valor=1;
                break;
            }
            case "Rechazado":{
                valor=2;
                break;
            }
            case "Pendiente":{
                valor=3;
                break;
            }
            case "Enviado":{
                valor=4;
                break;
            }
            case "Eliminado":{
                valor=5;
                break;
            }
            case "Pendiente de supervision":{
                valor=6;
                break;
            }
            case "Aprobado por supervisor":{
                valor=7;
                break;
            }case "Rechazado por supervisor":{
                valor=8;
                break;
            }case "Exitosa":{
                valor=9;
                break;
            }
            case "Rechazada":{
                valor=10;
                break;
            }
            default: {

                System.out.println("Sin opcoones");

            }


        }
        try{
            script(driver,"document.getElementsByClassName('el-select-dropdown__item')["+valor+"].click();");

        }
        catch(Exception e){
            System.out.println("FALLÓ");
        }
        Thread.sleep(1200);
     //   driver.findElement(objeto).click();
    }

    protected static void scroll(WebDriver driver, int x, int y) {
        try {
            System.out.println(ft.format(dNow) +  " [Scroll] - X: " + x + " => Y: " + y);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
        } catch (RuntimeException t) {
            logger.error("[LOG]-Scroll: " + t);
            generateWord.sendDescript("Error-Scroll: " +t,false);
            throw t;
        }
    }

    protected static void scrollByVisibleElement(WebDriver driver, By locator) {
        try {
            System.out.println(ft.format(dNow) +  " [ScrollElement] - " + locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        } catch (RuntimeException t) {
            logger.error("[LOG]-Scroll: " + t);
            throw t;
        }
    }

    protected static void zoom(WebDriver driver, int size) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom = '" + size + "%'");
        } catch (RuntimeException t) {
            logger.error("[LOG]-zoom: " + t);
            throw t;
        }
    }

    protected static void script(WebDriver driver, String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
        System.out.println("script:"+script);
    }

    protected static String textscript(WebDriver driver, String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    protected void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void visitaURL(WebDriver driver,String url) {
        //driver.navigate().to(url);
        driver.get(url);
    }

    protected void cerrarNavegador(WebDriver driver) {
        driver.quit();
    }

    protected void deletecookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    protected void iFrame(WebDriver driver, String str_iFrame) {
        driver.switchTo().frame(str_iFrame);
    }

    protected void defaultWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //DropFile(new File(excel.getDocumento()), opp.DRAGDROG,driver, 0, 0);
    public void DropFile(File filePath, By locator, WebDriver driver, int offsetX, int offsetY) {
        if(!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        // WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
        webDriverWait = new WebDriverWait(driver, Duration.ofDays(40));
        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";
        WebElement target=driver.findElement(locator);
        WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        webDriverWait.until(ExpectedConditions.stalenessOf(input));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));

    }

    public void adjuntarArchivo(File filePath, String valor, WebDriver driver) throws Exception {
        //WebElement target=driver.findElement(locator);
        System.out.println("antes del clic");
        //click(driver,locator);
        script(driver,valor);
        System.out.println("luego del clic");
        Robot r = new Robot();
        r.setAutoDelay(2000);
        StringSelection stringselection=new StringSelection(filePath.getAbsoluteFile().toString());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

        r.setAutoDelay(1000);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);

        r.setAutoDelay(1000);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);

    }

    protected void objetoDesaparece2(WebDriver driver, By locator, int time) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
            webDriverWait = new WebDriverWait(driver, Duration.ofDays(time));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
            logger.info("Objeto "+locator+ " desapareció");
        } catch (Exception e) {
            logger.error("No desaparecio el objeto en "+ time +" segundos");
            generateWord.sendDescript("No desaparecio el objeto en "+ time +" segundos", true);
            throw e;
        }
    }

    protected boolean objetoDesaparece(WebDriver driver, By locator) {
        try {
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
         //   webDriverWait = new WebDriverWait(driver, Duration.ofDays(12));
            logger.info("Objeto "+locator+ " desapareció");
            return true;
        } catch (Exception e) {
          //  logger.error("No desaparecio el objeto en "+ time +" segundos");
            generateWord.setlogStep("No desaparecio el objeto");
            return false;
        }

    }

    protected boolean elementLoading(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            //   webDriverWait = new WebDriverWait(driver, Duration.ofDays(12));
            logger.info("El elemento LoadingPage localizado en "+locator+ " desapareció");
            return true;
        } catch (Exception e) {
            //  logger.error("No desaparecio el objeto en "+ time +" segundos");
            generateWord.setlogStep("El elemento LoadingPage localizado en" + locator + " NO desapareció");
            return false;
        }

    }




    protected void mouseHover(WebDriver driver, By locator) throws Exception {
        try {
            WebElement target=driver.findElement(locator);
            Actions builder1;
            builder1 = new Actions(driver);
            builder1.moveToElement(target).perform();
        } catch (Exception e) {
            logger.error("No se encontro el objeto: " + e.getMessage());
            generateWord.sendDescript("No se encontro el objeto: " + e.getMessage(), true);
            throw e;
        }
    }

    public void switchToLoginWindows(WebDriver driver) throws Exception {
        try {
                Thread.sleep(3000);
                String winHandleBefore = driver.getWindowHandle();
                generateWord.setlogStep("ID Ventana principal es: " + winHandleBefore);
                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                    generateWord.setlogStep("ID Windows Login: " + winHandle + " cambio OK");
                }
            }
        catch(Exception e){
                generateWord.setlogStep("Error: Al hacer switch a la ventana Login MS");
                Assert.fail(e.getMessage());
        }

    }

    public void switchToMainWindows(WebDriver driver, String mainWindow) throws Exception {
        try {
            Thread.sleep(3000);
            //Switch back to original browser (first window)
            driver.switchTo().window(mainWindow);
            //continue with original browser (first window)
            generateWord.setlogStep("Cambio exitoso a la ventana principal");
        }
        catch(Exception e){
            generateWord.setlogStep("Cambio fallido al hacer switch a la ventana principal: " + e);
            Assert.fail();
        }
    }



    public String waitUntilDonwloadCompleted(WebDriver driver) throws Exception {
        String fileName;
        String mainWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open()");
        for(String winHandle : driver.getWindowHandles()){
          driver.switchTo().window(winHandle);
        }
        driver.get("chrome://downloads");
        Thread.sleep(1000);
        try{
            fileName = (String) textscript(driver,"return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");//js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
        }
        catch (Exception e){
            fileName="";
            System.out.println("Exception: "+e.toString());
        }

        System.out.println(fileName);
        driver.close();
        driver.switchTo().window(mainWindow);
        return fileName;
    }

/*
    protected static ExtentTest stepG(String type, String descripcion) {
        try {
            return ExtentReport5.INSTANCE.stepG(type, descripcion);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected static void stepPass(WebDriver driver, String descripcion) {
        try {
            System.out.println(ft.format(dNow) +  " [StepPass] - " + descripcion);
            ExtentReport5.INSTANCE.stepPass(driver, descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepPass: " + t);
            throw t;
        } catch (Exception e) {
            logger.error("[LOG]-StepPass: " + e);
        }
    }

    protected static void stepWarning(WebDriver driver, String descripcion) throws Exception {
        try {
            System.out.println(ft.format(dNow) +  " [StepWarning] - " + descripcion);
            ExtentReport5.INSTANCE.stepWarning(driver, descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepWarning: " + t);
            throw t;
        }
    }
    protected static void stepWarningNoShoot(String descripcion) {
        try {
            System.out.println(ft.format(dNow) +  " [StepWarningNS] - " + descripcion);
            ExtentReport5.INSTANCE.stepWarningNoShoot(descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepWarning: " + t);
            throw t;
        }
    }

    protected void stepFail(WebDriver driver, String descripcion) throws Exception {
        try {
            System.out.println(ft.format(dNow) +  " [StepFail] - " + descripcion);
            ExtentReport5.INSTANCE.stepFail(driver, descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepFail: " + t);
            throw t;
        }
    }

    public static void stepFailNoShoot(String descripcion) {
        try {
            System.out.println(ft.format(dNow) +  " [StepFailNS] - " + descripcion);
            ExtentReport5.INSTANCE.stepFailNoShoot(descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepFailNoShoot: " + t);
            throw t;
        }
    }

    public static void stepPassNoShoot(String descripcion) {
        try {
            System.out.println(ft.format(dNow) +  " [StepPassNS] - " + descripcion);
            ExtentReport5.INSTANCE.stepPassNoShoot(descripcion);
        } catch (RuntimeException t) {
            logger.error("[LOG]-StepPassNoShoot: " + t);
            throw t;
        }
    }
*/
    private void errorNoElementFound(WebDriver driver, By locator) throws IOException {
        logger.error("Error : No se encontró el elemento : " + locator);
        generateWord.sendDescript("Error : No se encontró el elemento : " + locator,true);
    }
/*
    public static Exception handleError(WebDriver driver, String codigo, String msg) throws Throwable {
        stepWarning(driver, msg);
        return new FrontEndException(StringUtils.trimToEmpty(codigo), msg);
    }
*/
    protected void cargarBrowser(WebDriver driver, String url) throws Throwable {
        try {
            if (StringUtils.isNotEmpty(url)) {
                driver.get(url);
                generateWord.sendDescript("Cargo correctamente la URL: '"+url+"'",false);
                generateWord.sendBreak();
                sleep(500);
            } else {
                throw new Exception("Error al cargar la página, NO existe el parámetro URL del aplicativo ");
            }
        } catch ( NoSuchWindowException | NoSuchSessionException e ){
            generateWord.sendDescript("[Error al cargar Browser] : Navegador se cerro inesperandamente : " + e.getMessage(),true);
            throw e;
        } catch ( Throwable t ) {
            generateWord.sendDescript("[Error al cargar Browser] : " + t.getMessage(),true);
            throw t;
        }
    }
    public void presence(WebDriver driver, By locator, int time) throws Exception {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
         //   driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
        }
        catch (Exception e) {
            errorNoElementFound(driver, locator);
            throw e;
        }
    }
    public void visibility(WebDriver driver, By locator,int time) throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
            webDriverWait = new WebDriverWait(driver, Duration.ofDays(time));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
        } catch (Exception e) {
            errorNoElementFound(driver, locator);
            throw e;
        }
    }
    public boolean bolExistente(WebDriver driver, By locator,int time) throws Exception {
        try {

            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(time));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            //driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
            generateWord.setlogStep("Se encontro el objeto : " + locator);
            return true;
        } catch (Exception e) {
            generateWord.setlogStep("No se encontro el objeto luego de la espera");
            return false;
        }
    }

    public boolean elementoExistente(WebDriver driver, By locator) throws Exception {
        try {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            generateWord.setlogStep("Se encontro el elemento : " + locator);
            return true;
        } catch (Exception e) {
            generateWord.setlogStep("No se encontro el elemento luego de la espera: " + locator);
            return false;
        }
    }

    public boolean elementoExistentePresente(WebDriver driver, By locator) throws Exception {
        try {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            generateWord.setlogStep("Se encontro el elemento : " + locator);
            return true;
        } catch (Exception e) {
            generateWord.setlogStep("No se encontro el elemento luego de la espera: " + locator);
            return false;
        }
    }
    public void waits(WebDriver driver, By locator) throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
            webDriverWait = new WebDriverWait(driver, Duration.ofDays(12));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //    driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
        }
        catch (Exception e) {
            System.out.println("No se encontro el objeto luego de la espera: " + e.getMessage());
            throw e;
        }
    }

    public void waitsElement(WebDriver driver, By locator) throws Exception {
        try {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(240));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e) {
            generateWord.setlogStep("No se encontro el objeto luego de la espera");
            Assert.fail("No se encontro el objeto luego de la espera: " + e.getMessage() + locator);
            throw e;
        }
    }

    public void waitsElementPresence(WebDriver driver, By locator) throws Exception {
        try {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            generateWord.setlogStep("Elemento encontrado!");
        }
        catch (Exception e) {
            generateWord.setlogStep("No se encontro el objeto luego de la espera");
            Assert.fail("No se encontro el objeto luego de la espera: " + e.getMessage() + locator);
            throw e;
        }
    }

    public void waitsElementClickeable(WebDriver driver, By locator) throws Exception {
        try {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (Exception e) {
           generateWord.setlogStep("No se encontro el objeto luego de la espera");
           Assert.fail("No se encontro el objeto luego de la espera: " + e.getMessage() + locator);
            throw e;
        }
    }


    public void escribir(WebDriver driver,By elementBy, String str_entrada) throws Exception {
        String desc_paso="";
        try {
            WebElement element;
            element=driver.findElement(elementBy);
            element.click();
            element.clear();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(str_entrada);
            if (!(str_entrada.equals(""))) {
                desc_paso = "Se digito el valor: " + str_entrada;
            }
        } catch (Exception e) {
            System.out.println("Error en Digitar: " + e.getMessage());
            desc_paso = "Error en Digitar: " + str_entrada;
            throw e;
           // e.printStackTrace();
        }
        System.out.println(desc_paso);
    }
    public int obtenerMes(String mes) {
        int nromes = 0;
        switch (mes) {
            case "enero":
                nromes = 1;
                break;
            case "febrero":
                nromes = 2;
                break;
            case "marzo":
                nromes = 3;
                break;
            case "abril":
                nromes = 4;
                break;
            case "mayo":
                nromes = 5;
                break;
            case "junio":
                nromes = 6;
                break;
            case "julio":
                nromes = 7;
                break;
            case "agosto":
                nromes = 8;
                break;
            case "septiembre":
                nromes = 9;
                break;
            case "octubre":
                nromes = 10;
                break;
            case "noviembre":
                nromes = 11;
                break;
            case "diciembre":
                nromes = 12;
                break;
        }
        return nromes;
    }


}