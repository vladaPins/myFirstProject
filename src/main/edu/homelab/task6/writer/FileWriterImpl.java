package edu.homelab.task6.writer;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

  @Override
  public void writeStringToFile(String str, String path) {
    if (str.length() > 0) {
      try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
        writer.write(str);
        System.out.println("Объект записан в формате json в файл " + path);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
