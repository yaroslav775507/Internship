package org.example;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task_3 {
    public static String testsFile = "tests.json";
    public static String valuesFile = "values.json";

    public static void main(String[] args) {
        try {
            // Читаем содержимое tests.json
            JSONObject testsJson = (JSONObject) new JSONParser().parse(new FileReader(testsFile));

            // Читаем содержимое values.json
            JSONObject valuesJson = (JSONObject) new JSONParser().parse(new FileReader(valuesFile));

            // Обновляем значения в структуре tests.json на основе значений из values.json
            updateValues(testsJson, valuesJson);

            // Записываем обновленную структуру в report.json
            FileWriter fileWriter = new FileWriter("report.json");
            fileWriter.write(testsJson.toJSONString());
            fileWriter.close();

            System.out.println("Отчет успешно сгенерирован в файле report.json");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateValues(JSONObject testsJson, JSONObject valuesJson) throws JSONException {
        // Проверяем, есть ли поле "values" в testsJson
        if (testsJson.containsKey("values")) {
            // Получаем массив значений "values" из testsJson
            JSONArray valuesArray = (JSONArray) testsJson.get("values");

            // Обходим каждый элемент массива
            for (Object obj : valuesArray) {
                JSONObject value = (JSONObject) obj;

                // Получаем id значения
                long id = (long) value.get("id");
                String val = (String) value.get("");

                // Проверяем, есть ли значение с таким id в valuesJson
                if (valuesJson.containsKey(String.valueOf(id))) {
                    // Получаем значение с нужным id из valuesJson
                    String result = (String) valuesJson.get(String.valueOf(id));
                    // Обновляем значение в testsJson
                    value.put("value", result);
                    if (valuesJson.containsKey(String.valueOf(id))) {
                        String value1 = (String) valuesJson.get(String.valueOf(id));
                        testsJson.put("value", value1);
                    }
                }
            }

        }

        // Проверяем, есть ли поле "values" в дочерних структурах testsJson
        for (Object obj : testsJson.values()) {
            if (obj instanceof JSONObject) {
                JSONObject childTestJson = (JSONObject) obj;
                updateValues(childTestJson, valuesJson);
            }
        }
    }
}
