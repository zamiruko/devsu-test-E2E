package com.devsu.automation.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonLoader {

    public static JsonObject loadPageElements(String filename) {
        Gson gson = new Gson();
        try {
            // Asegúrate de que la ruta al archivo JSON sea correcta.
            FileReader reader = new FileReader("src/test/resources/Pages/" + filename);
            return gson.fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filename, e);
        }
    }
}
