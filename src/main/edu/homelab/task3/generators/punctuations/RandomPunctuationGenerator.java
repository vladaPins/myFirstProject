package edu.homelab.task3.generators.punctuations;

import static edu.homelab.task3.generators.utlis.RandomUtils.nextInt;

public class RandomPunctuationGenerator implements PunctuationGenerator {

  private final char[] punctuations = new char[]{'.', '!', '?'};

  @Override
  public char generatePunctuation() {
    int nextPunctuation = nextInt(punctuations.length);
    return punctuations[nextPunctuation];
  }
}
