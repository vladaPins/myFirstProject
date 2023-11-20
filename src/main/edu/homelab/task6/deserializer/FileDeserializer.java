package edu.homelab.task6.deserializer;

public interface FileDeserializer {
  Object deSerialize(String file) throws NoSuchFieldException, IllegalAccessException;
}
