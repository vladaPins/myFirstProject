package edu.homelab.task3.generators.sentence;

import edu.homelab.task3.generators.punctuations.PunctuationGenerator;
import edu.homelab.task3.generators.words.WordGenerator;

import static edu.homelab.task3.database.FileWordsDatabase.EMPTY;
import static edu.homelab.task3.generators.utlis.RandomUtils.nextInt;
import static edu.homelab.task3.generators.utlis.WordUtils.capitalize;

public class RandomSentenceGenerator implements SentenceGenerator {

  public static final int MAX_WORDS_IN_SENTENCE = 15;
  public static final String SPACE = " ";

  private final PunctuationGenerator punctuationGenerator;
  private final WordGenerator wordGenerator;

  public RandomSentenceGenerator(PunctuationGenerator punctuationGenerator,
                                 WordGenerator wordGenerator) {
    this.punctuationGenerator = punctuationGenerator;
    this.wordGenerator = wordGenerator;
  }

  @Override
  public String generateSentence(String[] words, int probability) {
    int numberOfWords = nextInt(1, MAX_WORDS_IN_SENTENCE);
    String sentence = EMPTY;
    sentence += capitalize(wordGenerator.generateWord(words, probability));
    sentence += SPACE;
    numberOfWords--;
    for (int i = 0; i < numberOfWords; i++) {
      sentence += wordGenerator.generateWord(words, probability);
      sentence += SPACE;
    }
    sentence = sentence.trim();
    sentence += punctuationGenerator.generatePunctuation();
    sentence += SPACE;
    return sentence;
  }
}
