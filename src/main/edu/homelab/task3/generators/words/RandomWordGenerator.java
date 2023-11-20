package edu.homelab.task3.generators.words;

import static edu.homelab.task3.generators.utlis.RandomUtils.nextInt;

public class RandomWordGenerator implements WordGenerator {

  public static final int MAX_PERCENT = 100;
  private String prevWord;

  @Override
  public String generateWord(String[] words, int probability) {
    int nextWord = nextInt(words.length);
    if (prevWord == null) {
      prevWord = words[nextWord];
    } else {
      int bound = nextInt(MAX_PERCENT);
      if (probability < bound) {
        prevWord = words[nextWord];
      }
    }
    return prevWord;
  }
}
