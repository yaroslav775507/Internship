package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static String testsFile = "tests.json";
    public static  String valuesFile = "values.json";
    public static void main(String[] args) {
        try {
            // Чтение файла tests.json
            JSONParser parser = new JSONParser();
            JSONArray testsArray = (JSONArray) parser.parse(new FileReader(testsFile));

            // Чтение файла values.json
            JSONObject valuesObject = (JSONObject) parser.parse(new FileReader(valuesFile));

            // Заполнение значений value в структуре tests.json
            fillValues(testsArray, valuesObject);

            // Запись результата в файл report.json
            FileWriter fileWriter = new FileWriter("report.json");
            fileWriter.write(testsArray.toJSONString());
            fileWriter.close();

            System.out.println("Файл report.json успешно создан.");
        } catch (IOException | ParseException e) {
            System.out.println("Ошибка при чтении или записи файла.");
            e.printStackTrace();
        }
    }

    private static void fillValues(Object obj, JSONObject valuesObject) {
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.containsKey("id")) {
                long id = (long) jsonObject.get("id");
                if (valuesObject.containsKey(String.valueOf(id))) {
                    String value = (String) valuesObject.get(String.valueOf(id));
                    jsonObject.put("value", value);
                }
            }
            if (jsonObject.containsKey("values")) {
                JSONArray valuesArray = (JSONArray) jsonObject.get("values");
                fillValues(valuesArray, valuesObject);
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            for (Object arrayObj : jsonArray) {
                fillValues(arrayObj, valuesObject);
            }
        }

    }
}
