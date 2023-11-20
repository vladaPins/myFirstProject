package edu.homelab.task3.generators.punctuations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomPunctuationGeneratorTest {

  @Test
  public void getGeneratePunctuation() {
    var punctuations = Arrays.asList('.', '!', '?');
    var randomPunctuationGenerator = new RandomPunctuationGenerator();
    var result = randomPunctuationGenerator.generatePunctuation();

    assertTrue(punctuations.contains(result));
  }
}