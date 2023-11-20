package edu.homelab.task6.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonReader {

  public Map<String, Object> readJson(String file) {
   String fieldName;
    String fieldValue;
    Map<String, Object> fieldsAndValues = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] lineWords = line.split(":");
        if (lineWords.length == 2) {
          fieldName = lineWords[0].replaceAll("\"", "").trim();
          fieldValue = lineWords[1].replaceAll("\"", "").trim();
          fieldsAndValues.put(fieldName, fieldValue);
          try {
            int fieldValueInt = Integer.parseInt(fieldValue);
            fieldsAndValues.put(fieldName, fieldValueInt);
          } catch (NumberFormatException e) {

          }
//
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return fieldsAndValues;
  }
}
