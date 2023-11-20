package edu.homelab.task4.searcher;

import edu.homelab.task4.occurrence.SentenceOccurrenceService;
import edu.homelab.task4.reader.SentenceReader;
import edu.homelab.task4.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class SentenceSearcherImplTest {

  @Test
  public void testSearchSentenceWithOccurrence() throws IOException {
    // Given:
    var words = new String[]{"Влады", "Дима", "Милада", "baba", "deda"};
    var path = "./text.txt";
    Pair<String, Integer> pair = new Pair<>();
    pair.setKey("Это мое тестовое предложение.");
    pair.setValue(42);

    Pair<String, Integer> endOfFile = new Pair<>();
    endOfFile.setValue(-1);

    var sentenceOccurrenceService = Mockito.mock(SentenceOccurrenceService.class);
    Mockito
        .when(sentenceOccurrenceService.hasOccurrence(Mockito.eq("Это мое тестовое предложение."), Mockito.eq(words)))
        .thenReturn(true);

    var sentenceReader = Mockito.mock(SentenceReader.class);
    Mockito
        .when(sentenceReader.findSentence(Mockito.eq(path), Mockito.eq(0)))
        .thenReturn(pair);
    Mockito
        .when(sentenceReader.findSentence(Mockito.eq(path), Mockito.eq(42)))
        .thenReturn(endOfFile);

    // When:
    SentenceSearcher sentenceSearcher = new SentenceSearcherImpl(sentenceReader, sentenceOccurrenceService);
    String sentence = sentenceSearcher.searchSentence(path, words);

    // Then:
    Assertions.assertTrue(sentence.substring(0, 1).matches("[А-Я]"));
    Assertions.assertTrue(sentence.endsWith(".\n"));
  }

  @Test
  public void testSearchSentenceWithoutOccurrence() throws IOException {
    // Given:
    var words = new String[]{"Влады", "Дима", "Милада", "baba", "deda"};
    var path = "./text.txt";
    Pair<String, Integer> pair = new Pair<>();
    pair.setKey("Это мое тестовое предложение.");
    pair.setValue(-1);

    var sentenceOccurrenceService = Mockito.mock(SentenceOccurrenceService.class);
    Mockito
        .when(sentenceOccurrenceService.hasOccurrence(Mockito.eq("Это мое тестовое предложение."), Mockito.eq(words)))
        .thenReturn(false);

    var sentenceReader = Mockito.mock(SentenceReader.class);
    Mockito
        .when(sentenceReader.findSentence(Mockito.eq(path), Mockito.eq(0)))
        .thenReturn(pair);

    // When:
    SentenceSearcher sentenceSearcher = new SentenceSearcherImpl(sentenceReader, sentenceOccurrenceService);
    String sentence = sentenceSearcher.searchSentence(path, words);

    // Then:
    Assertions.assertTrue(sentence.substring(0, 1).matches("[А-Я]"));
    Assertions.assertTrue(sentence.endsWith("."));
  }
}