package edu.homelab.task4.reader;

import edu.homelab.task4.exceptions.FileNotFoundRuntimeException;
import edu.homelab.task4.exceptions.IORuntimeException;
import edu.homelab.task4.utils.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSentenceReader implements SentenceReader {

  public static final String START_SYMBOLS = "[\\u0410-\\u042F]";
  public static final String END_SYMBOLS = "[.|!|?]";
  public static final String EMPTY = "";

  @Override
  public Pair<String, Integer> findSentence(String path, int startPosition) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

      // skip number of symbols
      int position = 0;
      int code = bufferedReader.read();
      while ((position < startPosition)) {
        if (code == -1) {
          Pair<String, Integer> pair = new Pair<>();
          pair.setValue(-1);
          return pair;
        }
        code = bufferedReader.read();
        position++;
      }

      // find start of new sentence
      boolean isSentenceStarted = false;
      while (!isSentenceStarted) {
        if (code == -1) {
          Pair<String, Integer> pair = new Pair<>();
          pair.setValue(-1);
          return pair;
        }
        String symbol = EMPTY + (char) code;
        if (symbol.matches(START_SYMBOLS)) {
          isSentenceStarted = true;
        } else {
          System.out.println("Skip symbol: " + symbol);
          code = bufferedReader.read();
          position++;
        }
      }

      // build sentence until the end
      StringBuilder sentence = new StringBuilder();
      boolean isSentenceCreated = false;
      System.out.println("Start sentence with: " + EMPTY + (char) code);
      while (!isSentenceCreated) {
        if (code == -1) {
          Pair<String, Integer> pair = new Pair<>();
          pair.setValue(-1);
          return pair;
        }

        String symbol = EMPTY + (char) code;
        sentence.append(symbol);

        if (symbol.matches(END_SYMBOLS)) {
          System.out.println("End sentence with: " + EMPTY + (char) code);
          isSentenceCreated = true;
        } else {
          code = bufferedReader.read();
        }
        position++;
      }
      System.out.println("Next sentence searching from " + position);

      // return new sentence with lastPosition. will be used in the next calls
      Pair<String, Integer> pair = new Pair<>();
      pair.setKey(sentence.toString());
      pair.setValue(position);
      return pair;

    } catch (FileNotFoundException e) {
      throw new FileNotFoundRuntimeException(e);

    } catch (IOException e) {
      throw new IORuntimeException(e);
    }
  }
}


















