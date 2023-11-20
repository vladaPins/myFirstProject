package edu.homelab.task4.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathsProvider {

  private static final String FILE_PATHS = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task4/data/input/paths.txt";

  public List<String> getPaths() {
    List<String> paths = new ArrayList<>();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATHS))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        paths.add(line);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return paths;
  }


}