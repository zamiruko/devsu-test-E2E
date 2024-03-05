package com.devsu.automation.utils;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumFunctions {

    //TIEMPO DE ESPERA PARA UN OBJECTO
    public static final int EXPLICIT_TIMEOUT = 5;
    static WebDriver driver;

    public SeleniumFunctions() {
        driver = DriverManager.driver;
    }

    public static Logger log = Logger.getLogger(SeleniumFunctions.class);

    public static String PagesFileName = "";
    public static String DataFileName = "";

    public static String PagesFilePath = "src/test/resources/Pages/";
    public static String DataFilePath = "src/test/resources/Data/";

    public static String GetFieldBy = "";
    public static String ValueToFind = "";

    //HAY QUE VER  private static Properties pro = new Properties();
    //HAY QUE VER  private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");

    public String ElementText = "";

    public static Object readJson() throws Exception {
        FileReader reader = new FileReader(PagesFilePath + PagesFileName);
        try {
            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.error("No existe el archivo" + PagesFileName);
            throw new IllegalStateException("No existe el archivo" + PagesFileName, e);
        }

    }
    public static Object readJsonData() throws Exception {
        FileReader reader = new FileReader(DataFilePath + DataFileName);
        try {
            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.error("No existe el archivo" + DataFileName);
            throw new IllegalStateException("No existe el archivo" + DataFileName, e);

        }

    }

    public static JSONObject ReadEntity(String element) throws Exception {
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static JSONObject ReadEntityData(String element) throws Exception {
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJsonData();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static By getCompleteElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }

        return result;
    }

    public static By getCompleteElementWithAddText(String element, String text) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        //SE AGREGA EL TEXTO REMPLAZANDO EL TEXTO "changehere"
        ValueToFind = ValueToFind.replace("changehere", text);

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }

        return result;
    }

    public void navigationToURL() throws Exception
    {
        //pro.load(in);
        //String url = pro.getProperty("MainAppUrlBase");
        //log.info(("Navegar a:" + url));
        //driver.get(url);
    }
    public void initializeFileJsonData(String file) throws Exception
    {
        SeleniumFunctions.DataFileName = file;
        SeleniumFunctions.readJsonData();
        log.info("Inicializa el archivo: " + file);
    }

    public void initializeFileJson(String file) throws Exception
    {
        SeleniumFunctions.PagesFileName = file;
        SeleniumFunctions.readJson();
        log.info("Inicializa el archivo: " + file);
    }

    public void clickOnElement(String element) throws Exception{
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();
        log.info("Clic en el Elemento: " + element);
    }

    public void setTextOnElement(String element, String text) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
        log.info("Agregano el texto: " + text + " en el elemento: " + element);
    }

    public void setTextOnElementFromData(String element, String pageData) throws Exception
    {
        JSONObject Entity = ReadEntityData(pageData);
        String text = (String) Entity.get(element);

        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
        log.info("Agregano el texto: " + text + " en el elemento: " + element);
    }

    public void setTextOnElementFromDataAndPlus(String element, String pageData, String text) throws Exception
    {
        JSONObject Entity = ReadEntityData(pageData);
        text = text + ((String) Entity.get(element));

        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
        log.info("Agregano el texto: " + text + " en el elemento: " + element);
    }

    public String getTextOnElementFromData(String element, String pageData) throws Exception
    {
        JSONObject Entity = ReadEntityData(pageData);
        String text = (String) Entity.get(element);

        return text;
    }

    public void selectOptionDropdownByTest(String element, String option) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        log.info(String.format("Elemento de espero: %s", element));

        Select opt = new Select(driver.findElement(SeleniumElement));
        log.info("Seleccionar opción: " + option + "by text");
        opt.selectByVisibleText(option);
    }

    public void selectOptionDropDownByIndex(String element, int option) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        log.info(String.format("Elemento de espera: %s", element));

        Select opt = new Select(driver.findElement(SeleniumElement));
        log.info("Seleccionar opción: " + option + "by text");
        opt.selectByIndex(option);
    }

    public void selectOptionDropDownByValue(String element, String option) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        log.info(String.format("Elemento de espera: %s", element));

        Select opt = new Select(driver.findElement(SeleniumElement));
        log.info("Seleccionar opción: " + option + "by text");
        opt.selectByValue(option);
    }

    public void waitForElementPresent(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait w = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        log.info("Esperando el elemento: " + element + " que este presente");
        w.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement));
    }

    public void waitForElementVisible(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait w = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        log.info("Esperando el elemento: " + element + " que este visible");
        w.until(ExpectedConditions.visibilityOfElementLocated(SeleniumElement));
    }

    public void checkCheckBox(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        boolean isChecked = driver.findElement(SeleniumElement).isSelected();
        if(!isChecked){
            log.info("Haciendo clic en la casilla de verificación para seleccionar: " + element);
            driver.findElement(SeleniumElement).click();
        }
    }
    public void UnCheckBox(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        boolean isChecked = driver.findElement(SeleniumElement).isSelected();
        if(isChecked){
            log.info("Haciendo clic en la casilla de verificación para deseleccionar: " + element);
            driver.findElement(SeleniumElement).click();
        }
    }
    public void scrollToElement(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        log.info("Dezplazarse al elemento: " + element);
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(SeleniumElement));
    }

    public void pageStatus()
    {
        String GetActual = driver.getCurrentUrl();
        System.out.println(String.format("Comprobando si la página está cargada.", GetActual));
        log.info(String.format("Comprobando si la página está cargada.", GetActual));
        new WebDriverWait(driver, EXPLICIT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public String GetTextElement(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement));
        log.info(String.format("Esperando al elemento: %s", element));

        ElementText = driver.findElement(SeleniumElement).getText();
        return ElementText;
    }

    public void checkPartialTextElementPresent(String element, String text) throws Exception
    {
        ElementText = GetTextElement(element);
        boolean isFound = ElementText.indexOf(text) != -1? true: false;
        Assert.assertTrue("El texto no está presente en el elemento: " + element + " el texto actual es: " + ElementText, isFound);
    }

    public void clickOnElementWithAddDataReplace(String element, String text) throws Exception{
        By SeleniumElement = SeleniumFunctions.getCompleteElementWithAddText(element, text);
        driver.findElement(SeleniumElement).click();
        log.info("Clic en el Elemento encontrado: " + element);
    }

}