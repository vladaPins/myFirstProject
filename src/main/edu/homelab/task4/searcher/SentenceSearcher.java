package edu.homelab.task4.searcher;

import java.io.IOException;

public interface SentenceSearcher {
  String searchSentence(String path, String[] wordsForComparison) throws IOException;
}
