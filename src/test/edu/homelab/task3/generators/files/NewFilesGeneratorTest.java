package edu.homelab.task3.generators.files;

import edu.homelab.task3.generators.punctuations.PunctuationGenerator;
import edu.homelab.task3.generators.sentence.RandomSentenceGenerator;
import edu.homelab.task3.generators.text.TextGenerator;
import edu.homelab.task3.generators.words.WordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class NewFilesGeneratorTest {

  //файл успешно создается
  //текст записывается

  @Test
  public void checkNumberOfFilesCreated() throws IOException {
    //Given
    var filePath = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task3/generators";
    var numberOfFiles = 2;
    var size = 1000;

    //When
    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
    byte[] data = new byte[size];
    fileOutputStream.write(data);
    //Then
    assertNotNull(fileOutputStream);
  }

  @Test
  public void newFilesGenerator() throws IOException {
    // Given:


   var words = new String[]{"vlada", "dima", "milada", "baba", "deda"};
    var size = 2000;
    var probability = 50;
    var filePath = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task3/generators/файл1.txt";

    var textGenerator = Mockito.mock(TextGenerator.class);
    Mockito
        .when(textGenerator.generateText(Mockito.eq(size),Mockito.eq(words),Mockito.eq(probability)))
        .thenReturn("All good result!");


    // When:
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
    var allText = textGenerator.generateText(size, words, probability);
 bufferedWriter.write(allText);
    File file = new File(filePath);

    // Then:

    assertTrue(file.exists());
    try {
      String content = new String(Files.readAllBytes(Paths.get(filePath)));
      assertEquals(allText, content);
    } catch (IOException e) {
      e.printStackTrace();
      fail("Error reading the file content.");
    }
  }
}

