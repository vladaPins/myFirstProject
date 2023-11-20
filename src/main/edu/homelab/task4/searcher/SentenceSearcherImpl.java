package edu.homelab.task4.searcher;

import edu.homelab.task4.occurrence.SentenceOccurrenceService;
import edu.homelab.task4.reader.SentenceReader;

import java.io.IOException;

import static edu.homelab.task4.reader.FileSentenceReader.EMPTY;
import static java.util.Objects.isNull;

@SuppressWarnings("StringConcatenationInLoop")
public class SentenceSearcherImpl implements SentenceSearcher {

  public static final String NEXTLINE = "\n";
  private final SentenceReader sentenceReader;
  private final SentenceOccurrenceService sentenceOccurrenceService;

  public SentenceSearcherImpl(SentenceReader sentenceReader, SentenceOccurrenceService sentenceOccurrenceService) {
    this.sentenceReader = sentenceReader;
    this.sentenceOccurrenceService = sentenceOccurrenceService;
  }

  @Override
  public String searchSentence(String path, String[] words) throws IOException {
    String sentences = EMPTY;
    int nextCharPosition = 0;
    int lastCharPosition = 0;

    while (true) {
      var pair = sentenceReader.findSentence(path, nextCharPosition);

      lastCharPosition = pair.getValue();
      if (lastCharPosition == -1) {
        System.out.println("Stop search because the end of file has been found.");
        return sentences;
      }

      nextCharPosition = lastCharPosition;
      var sentence = pair.getKey();
      boolean hasOccurrence = sentenceOccurrenceService.hasOccurrence(sentence, words);

      if (hasOccurrence) {
        System.out.println("Found occurrence in { " + sentence + " }");
        sentences += sentence;
        sentences += NEXTLINE;
      }
      if (isNull(pair.getKey()) && isNull(pair.getValue())) {
        System.out.println("No more sentences are available!");
        return sentences;
      }
    }
  }
}

