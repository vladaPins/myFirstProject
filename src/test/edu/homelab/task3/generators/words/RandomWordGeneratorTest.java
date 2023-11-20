package edu.homelab.task3.generators.words;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomWordGeneratorTest {

  @Test
  public void checkGeneratorWordWith100probability() {
    var probability = 100;
    var words = new String[]{"vlada", "dima", "milada", "baba", "deda"};
    var randomWordGenerator = new RandomWordGenerator();

    var isSameObjectsResult = Objects.equals(
        randomWordGenerator.generateWord(words, probability),
        randomWordGenerator.generateWord(words, probability)
    );

    assertTrue(isSameObjectsResult);
  }


  @Test
  public void checkGeneratorWordWith0probability() {
    var probability = 0;
    var words = new String[]{"vlada", "dima", "milada", "baba", "deda"};
    var randomWordGenerator = new RandomWordGenerator();

    var isNotSameResult = Objects.equals(
        randomWordGenerator.generateWord(words, probability),
        randomWordGenerator.generateWord(words, probability)
    );

    assertFalse(isNotSameResult);
  }
}