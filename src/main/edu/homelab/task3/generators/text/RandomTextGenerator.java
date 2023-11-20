package edu.homelab.task3.generators.text;

import edu.homelab.task3.generators.paragraph.ParagraphGenerator;

import static edu.homelab.task3.database.FileWordsDatabase.EMPTY;

public class RandomTextGenerator implements TextGenerator {

  private final ParagraphGenerator paragraphGenerator;

  public RandomTextGenerator(ParagraphGenerator paragraphGenerator) {
    this.paragraphGenerator = paragraphGenerator;
  }

  @Override
  public String generateText(int size, String[] words, int probability) {
    String text = EMPTY;
    boolean sizeHasBeenReached = false;
    while (!sizeHasBeenReached) {
      String paragraph = paragraphGenerator.generateParagraph(words, probability);
      int resultTextSize = paragraph.length() + text.length();
      if (resultTextSize > size) {
        sizeHasBeenReached = true;
      }
      text += paragraph;
    }
    return text;
  }
}
