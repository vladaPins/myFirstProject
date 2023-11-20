package edu.homelab.task4.occurrence;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SentenceOccurrenceServiceImplTest {
  @Test
  public void testSentenceOccurenceWordNotFound() throws IOException {
    // Given:
    String[] words = {"Любовь", "Деньги", "улыбка", "дети"};
    var sentence = "Нет вхождения слова в предложении.";
    // When:
    SentenceOccurrenceServiceImpl sentenceOccurrenceService = new SentenceOccurrenceServiceImpl();
    Boolean wordFound = sentenceOccurrenceService.hasOccurrence(sentence, words);


    // Then:
    assertFalse(wordFound);

  }

  @Test
  public void testSentenceOccurenceWorFound() throws IOException {
    // Given:
    String[] words = {"Любовь", "Деньги", "улыбка", "дети"};
    var sentence = "Есть вхождение слова ДЕНЬГИ в предложение.";
    // When:
    SentenceOccurrenceServiceImpl sentenceOccurrenceService = new SentenceOccurrenceServiceImpl();
    Boolean wordFound = sentenceOccurrenceService.hasOccurrence(sentence, words);


    // Then:
    assertTrue(wordFound);

  }

  @Test
  public void testSentenceOccurenceWorFoundWithPunctuation() throws IOException {
    // Given:
    String[] words = {"Любовь", "Деньги", "улыбка", "дети"};
    var sentence = "Есть вхождение слова любОвь.";
    // When:
    SentenceOccurrenceServiceImpl sentenceOccurrenceService = new SentenceOccurrenceServiceImpl();
    Boolean wordFound = sentenceOccurrenceService.hasOccurrence(sentence, words);


    // Then:
    assertTrue(wordFound);

  }

  @Test
  public void testSentenceOccurenceWordNotFound2() throws IOException {
    // Given:
    String[] words = {"Любовь", "Деньги", "улыбка", "дети"};
    var sentence = "Нет вхождения слова улыбки.";
    // When:
    SentenceOccurrenceServiceImpl sentenceOccurrenceService = new SentenceOccurrenceServiceImpl();
    Boolean wordFound = sentenceOccurrenceService.hasOccurrence(sentence, words);


    // Then:
    assertTrue(wordFound);

  }
}