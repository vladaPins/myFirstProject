package edu.homelab.task6.deserializer;

import edu.homelab.task6.reader.JsonReader;
import edu.homelab.task6.utils.ReflectionUtils;

import java.util.Map;

public class JsonDeserializer implements FileDeserializer {

  private final JsonReader reader = new JsonReader();

  @Override
  public Object deSerialize(String file) throws NoSuchFieldException, IllegalAccessException {
    String className = null;

    Map<String, Object> json = reader.readJson(file);
    for (String field : json.keySet()) {
      if (field.equals("className")) {
        className = (String) json.get(field);
        break;
      }
    }

    if (className == null) {
      System.out.println("Невозможно дессирилизовать объект, не найдено имя класа");
      return null;
    }

    Object deserializedObject = ReflectionUtils.createNewObject(className);
    ReflectionUtils.updateFieldIfExists(deserializedObject, json);

    return deserializedObject;
  }
}

