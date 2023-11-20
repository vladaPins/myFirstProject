package edu.homelab.task3.generators.files;

import edu.homelab.task3.generators.text.TextGenerator;

import java.io.*;

public class NewFilesGenerator implements FilesGenerator {

  private final TextGenerator textGenerator;

  public NewFilesGenerator(TextGenerator textGenerator) {
    this.textGenerator = textGenerator;
  }

  @Override
  public void getFiles(String path, int n, int size, String[] words, int probability) {
    //  Создаем каталог
    File directory = new File(path);
    if (!directory.exists()) {
      boolean created = directory.mkdirs();
      if (created) {
        System.out.println("Каталог успешно создан.");
      } else {
        System.out.println("Не удалось создать каталог.");
      }
    } else {
      System.out.println("Каталог уже существует.");
    }

    // Создаем n файлов в этом каталоге
    for (int i = 0; i < n; i++) {
      int numOfFile = i + 1;
      String fileName = "файл" + numOfFile + ".txt";
      String filePath = path + File.separator + fileName;

      try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        byte[] data = new byte[size];
        fileOutputStream.write(data);
      } catch (IOException e) {
        e.printStackTrace();
      }

      String allText = textGenerator.generateText(size, words, probability);

// ====================================================================================================================
//      // создаем текст для конкретного файла
//      // Генерируем случайное целое число в диапазоне от 0 до 20
//      Random randomParagraph = new Random();
//      int randomNumberParagraph = randomParagraph.nextInt(5);
//
//      String allText = "";
//      for (int j = 0; j <= randomNumberParagraph; j++) {
//        Random randomSentences = new Random();// Генерируем случайное целое число в диапазоне от 0 до 20
//        int randomNumberSentences = randomSentences.nextInt(20);
//
//        String paragraph = "";
//        for (int k = 0; k <= randomNumberSentences; k++) {
//          Random randomWords = new Random();// Генерируем случайное целое число в диапазоне от 0 до 15
//          int randomNumberWords = randomWords.nextInt(15);
//          //StringBuilder sentences = new StringBuilder();
//          String sentences = "";
//          for (int m = 0; m <= randomNumberWords; m++) {
//            Random random = new Random();
//            String randomWord = getRandomWord(words); // Получаем случайное слово из HashSet
//            sentences = sentences.concat(randomWord).concat(" ");  // добавляем слово в предложение
//          }
//
//          sentences = sentences.trim().concat(". ");//убираем пробелы в начале и вконце, добавляем точку с пробелом вконце
//          sentences = sentences.substring(0, 1).toUpperCase() + sentences.substring(1);  // Сделаем первую букву заглавной
//          paragraph = paragraph.concat(sentences);//добавляем предложение в параграф
//
//        }
//        allText = allText.concat(paragraph);//добавляем параграф в текст
//        allText = allText.concat("\n\n");
//      }
// ====================================================================================================================

      // Записываем текст
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));) {
        bufferedWriter.write(allText);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

















