package edu.homelab.task3.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileWordsDatabase implements WordsDatabase {

  public static final String FILE = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task3/words";
  public static final String EMPTY = "";
  public static final String LATINS = "[^a-zA-Z]";
  public static final String SPACE = "\\s+";
  public static final int MIN_LENGTH = 1;
  public static final int MAX_LENGTH = 16;
  public static final int MAX_WORDS = 1000;

  @Override
  public String[] getWords() {
    Set<String> words = new HashSet<>();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        // Разбиваем строку на слова, используя пробел в качестве разделителя
        String[] lineWords = line.split(SPACE);
        for (String word : lineWords) {
          // Удаляем символы пунктуации из слова и цифры
          String cleanWord = word.replaceAll(LATINS, EMPTY);
          cleanWord = cleanWord.toLowerCase();
          if (cleanWord.length() > MIN_LENGTH && cleanWord.length() < MAX_LENGTH & words.size() < MAX_WORDS) {
            words.add(cleanWord);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return words.toArray(new String[0]);
  }
}





