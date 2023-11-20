package edu.homelab.task4.reader;

import edu.homelab.task4.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileSentenceReaderTest {

  @Test
  public void testFileSentenceReaderWithEmptySentenceFile0() throws IOException {
    // Given:
    var startPosition = 0;
    var path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text0.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();
    pair = fileSentenceReader.findSentence(path, startPosition);

    // Then:
    assertNull(pair.getKey());
    Assertions.assertEquals(pair.getValue(), -1);

  }

  @Test
  public void testFileSentenceReaderCheckStartAndEndFile1() throws IOException {
    // Given:
    var startPosition = 5;
    var path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text1.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();
    pair = fileSentenceReader.findSentence(path, startPosition);

    // Then:
    Assertions.assertEquals(pair.getKey(), "Создаем второе предложение, проверяем начало и конец предложения.");
    Assertions.assertEquals(pair.getValue(), 96);
    Assertions.assertTrue(pair.getKey().endsWith("."));
    Assertions.assertTrue(pair.getKey().substring(0, 1).matches("[А-Я]"));
  }

  @Test
  public void testFileSentenceReaderIfNotFindSentenceFile2() throws IOException {
    // Given:
    var startPosition = 5;
    var path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text2.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();
    pair = fileSentenceReader.findSentence(path, startPosition);

    // Then:
    assertNull(pair.getKey());
    Assertions.assertEquals(pair.getValue(), -1);

  }

  @Test
  public void testFileSentenceReaderEndWithQuestionMarkFile3() throws IOException {
    // Given:
    var startPosition = 3;
    var path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text3.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();
    pair = fileSentenceReader.findSentence(path, startPosition);

    // Then:
    Assertions.assertEquals(pair.getKey(), "Проверяем предложение с восклицательным знаком?");
    Assertions.assertEquals(pair.getValue(), 49);
    Assertions.assertTrue(pair.getKey().endsWith("?"));
    Assertions.assertTrue(pair.getKey().substring(0, 1).matches("[А-Я]"));
  }

  @Test
  public void testFileSentenceCheckExclamationPointFile4() throws IOException {
    // Given:
    var startPosition = 4;
    var path = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text4.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();
    pair = fileSentenceReader.findSentence(path, startPosition);

    // Then:
    Assertions.assertEquals(pair.getKey(), "Да!");
    Assertions.assertEquals(pair.getValue(), 7);
    Assertions.assertTrue(pair.getKey().endsWith("!"));
  }

  @Test
  public void testFileSentenceIfnotFindFile5() throws IOException {
    // Given:
    var startPosition = 0;
    var nonExistentFilePath = "/Users/DK/Developer/JavaProjects/myFirstProject/src/test/edu/homelab/task4/reader/test.text5.txt";
    Pair<String, Integer> pair = new Pair<>();

    // When:
    FileSentenceReader fileSentenceReader = new FileSentenceReader();

    // Then:
    assertThrows(FileNotFoundException.class, () -> {
      fileSentenceReader.findSentence(nonExistentFilePath, startPosition);
    });

  }

}