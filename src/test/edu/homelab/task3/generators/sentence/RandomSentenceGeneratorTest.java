package edu.homelab.task3.generators.sentence;

import edu.homelab.task3.generators.punctuations.PunctuationGenerator;
import edu.homelab.task3.generators.words.WordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomSentenceGeneratorTest {

  @Test
  public void generateSentence() {
    // Given:
    var probability = 0;
    var words = new String[]{"vlada", "dima", "milada", "baba", "deda"};

    var punctuationGenerator = Mockito.mock(PunctuationGenerator.class);
    Mockito
        .when(punctuationGenerator.generatePunctuation())
        .thenReturn('!');

    var wordGenerator = Mockito.mock(WordGenerator.class);
    Mockito
        .when(wordGenerator.generateWord(Mockito.eq(words), Mockito.eq(probability)))
        .thenReturn("superman");

    // When:
    var randomSentenceGenerator = new RandomSentenceGenerator(punctuationGenerator, wordGenerator);
    var result = randomSentenceGenerator.generateSentence(words, probability);

    // Then:
    Assertions.assertTrue(result.substring(0, 1).matches("[A-Z]"));
    Assertions.assertTrue(result.endsWith("! "));
  }
}