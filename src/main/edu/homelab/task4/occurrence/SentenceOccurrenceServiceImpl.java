package edu.homelab.task4.occurrence;

import java.util.HashSet;

public class SentenceOccurrenceServiceImpl implements SentenceOccurrenceService {

  public static final String SPACE = " ";

  @Override
  public boolean hasOccurrence(String sentence, String[] words) {
    boolean wordFound = false;
    String[] wordArray = sentence.split(SPACE);
    HashSet<String> sentenceSet = new HashSet<>();

    for (String word : wordArray) {
      String cleanedWord = word.replaceAll("[,|.]", "");
      cleanedWord = cleanedWord.toLowerCase();
      sentenceSet.add(cleanedWord);
    }

    for (String word : words) {
      if (sentenceSet.contains(word.toLowerCase())) {
        wordFound = true;
        System.out.println("Word { " + word + " } has been found!");
        break;
      }
    }
    return wordFound;
  }
}





