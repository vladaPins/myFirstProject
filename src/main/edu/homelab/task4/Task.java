package edu.homelab.task4;

import edu.homelab.task4.occurrence.SentenceOccurrenceServiceImpl;
import edu.homelab.task4.searcher.SentenceSearcher;
import edu.homelab.task4.searcher.SentenceSearcherImpl;
import edu.homelab.task4.reader.SentenceReader;

import java.io.IOException;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

  private final String[] wordsForComparison;
  private final String path;


  public Task(String path, String[] wordsForComparison) {
    this.path = path;
    this.wordsForComparison = wordsForComparison;
  }

  @Override
  public String call() throws Exception {
    String foundWordSentence = "Тест";
    //TextSearcherInFile textSearcherInFile = new TextSearcherInFile();
    SentenceReader sentenceReader = null;
    SentenceOccurrenceServiceImpl sentenceOccurrenceService = null;
    SentenceSearcher sentenceSearcher = new SentenceSearcherImpl(sentenceReader,sentenceOccurrenceService);

    try {
      System.out.println("запускаем ReadText");
      foundWordSentence = sentenceSearcher.searchSentence(path, wordsForComparison);
      System.out.println(foundWordSentence);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return foundWordSentence;
  }
}