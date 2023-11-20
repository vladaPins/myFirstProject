package edu.homelab.task4.reader;

import edu.homelab.task4.utils.Pair;

import java.io.IOException;

public interface SentenceReader {
  Pair<String, Integer> findSentence(String path, int startPosition) throws IOException;
}
