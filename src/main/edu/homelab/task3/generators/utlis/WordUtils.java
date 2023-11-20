package edu.homelab.task3.generators.utlis;

public class WordUtils {

  public static String capitalize(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }

  private WordUtils() {
    // because of utility class
  }
}
