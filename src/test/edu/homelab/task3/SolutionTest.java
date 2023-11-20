package edu.homelab.task3;

import edu.homelab.task3.database.FileWordsDatabase;
import edu.homelab.task3.database.WordsDatabase;
import edu.homelab.task3.generators.files.FilesGenerator;
import edu.homelab.task3.generators.files.NewFilesGenerator;
import edu.homelab.task3.generators.sentence.RandomSentenceGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


//проверяем:
// в файле предложение состоит из 1-15 слов
// слова состоят только из латинских букв
// размер файла не превышает size
// предложения начинаются с заглавной буквы
// предложения заканчиваются одним из символов пунктуации
// нужное количество файлов успешно создается
// слова в предложении генерируются с учетом probability
// слова разделяются пробелами
// удаляются ненужные символы
// есть перенос строки после каждого абзаца

@ExtendWith(MockitoExtension.class)
class SolutionTest {

  private final WordsDatabase wordsDatabase = new FileWordsDatabase();
  private final String[] words = wordsDatabase.getWords();
  private final String path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task3";
  private final int n = 3;
  private final int size = 5000;
  private final int probability = 2; // число от 0 до 100
  //private final FilesGenerator filesGenerator = new NewFilesGenerator(textGenerator);

//  @Test
//  public void generateSentence() {
//    // Given:
//    int probability = 0;
//    String[] words = new String[]{"vlada", "dima", "milada", "baba", "deda"};
//
//    // When:
//    RandomSentenceGenerator randomSentenceGenerator = new RandomSentenceGenerator(punctuationGenerator, wordGenerator);
//    randomSentenceGenerator.generateSentence(words, probability);
//
//    // Then:
//
//  }
}
// Assertions.assertArrayEquals


//  @Test
//      FilesGenerator.getFiles(path, n, size, words, probability);
//    ParagraphGenerator.generateParagraph(String[]words,int probability);

//    RandomSentenceGenerator.generateSentence();
//    RandomTextGenerator.generateText();
//    RandomUtils.nextInt();
//    RandomUtils.nextInt();
//
//
//    Assertions.assertArrayEquals(new Byte[]{-128, -50, 0, 20, 127}, array);
//  }


