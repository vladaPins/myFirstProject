package edu.homelab.task6;

import edu.homelab.task6.deserializer.JsonDeserializer;
import edu.homelab.task6.serializer.FileSerializerImpl;
import edu.homelab.task6.utils.ReflectionUtils;
import edu.homelab.task6.writer.FileWriterImpl;

public class Solution {
  public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

    String path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task6/output/rabbit.v";

    Rabbit rabbit = new Rabbit();
    rabbit.setNameRabbit("Любимчик");
    rabbit.setAgeRabbit(25);

    System.out.println("Объект до сериализации: ");
    System.out.println(ReflectionUtils.getClassName(rabbit) + ReflectionUtils.getObjectFields(rabbit));
    FileSerializerImpl serializer = new FileSerializerImpl();
    String json = serializer.serialize(rabbit);
    var fileWriter = new FileWriterImpl();
    fileWriter.writeStringToFile(json, path);

    JsonDeserializer deserializer = new JsonDeserializer();
    Object deserializedObject = deserializer.deSerialize(path);

    System.out.println("Дессириализованный объект: ");
    System.out.println(ReflectionUtils.getClassName(deserializedObject) + ReflectionUtils.getObjectFields(deserializedObject));

    if (rabbit.equals(deserializedObject)) {
      System.out.println("Дессирилизовался объект правильно");
    } else System.out.println("Дессирилизовался объект не правильно");

  }
}
