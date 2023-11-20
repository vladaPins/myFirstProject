package edu.homelab.task3.generators.paragraph;

import edu.homelab.task3.generators.sentence.SentenceGenerator;

import static edu.homelab.task3.database.FileWordsDatabase.EMPTY;
import static edu.homelab.task3.generators.utlis.RandomUtils.nextInt;

public class RandomParagraphGenerator implements ParagraphGenerator {

  public static final int MAX_SENTENCES_IN_PARAGRAPH = 20;
  public static final String NEXT_LINE = "\n";
  private final SentenceGenerator sentenceGenerator;

  public RandomParagraphGenerator(SentenceGenerator sentenceGenerator) {
    this.sentenceGenerator = sentenceGenerator;
  }

  @Override
  public String generateParagraph(String[] words, int probability) {
    String paragraph = EMPTY;
    int numberOfSentences = nextInt(1, MAX_SENTENCES_IN_PARAGRAPH);
    for (int i = 0; i < numberOfSentences; i++) {
      paragraph += sentenceGenerator.generateSentence(words, probability);
    }
    paragraph += NEXT_LINE;
    return paragraph;
  }
}
