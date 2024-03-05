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
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class SeleniumFunctions {

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

    public void waitForElementPresent(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.elementToBeClickable(SeleniumElement));
        log.info("Esperando el elemento: " + element + " que este presente");
    }


    public void scrollToElement(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        log.info("Dezplazarse al elemento: " + element);
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(SeleniumElement));
    }

    public String GetTextElement(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement));
        log.info(String.format("Esperando al elemento: %s", element));

        ElementText = driver.findElement(SeleniumElement).getText();
        return ElementText;
    }

    public void acceptAlert() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        log.info("Alerta aceptada");
    }

    public int countElementsOfElement(String element) throws Exception{
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        List<WebElement> elementsOnElement = driver.findElements(SeleniumElement);
        int elementsNumber = elementsOnElement.size();

        return elementsNumber;
    }

}