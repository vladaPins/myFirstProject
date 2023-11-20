package edu.homelab.task4;

import edu.homelab.task4.utils.PathsProvider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Solution {

  public static final String OUT_PATH = "/Users/DK/Developer/JavaProjects/myFirstProject/src/main/edu/homelab/task4/data/output/output.txt";
  public static final String[] WORDS = {
      "юный", "денег", "шопот", "мысль",
      "успешность", "успешности", "тест", "моя", "мысль"
  };

  public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    PathsProvider pathProvider = new PathsProvider();
    List<String> paths = pathProvider.getPaths();

    List<Future<String>> futures = new ArrayList<>();
    for (String path : paths) {
      Callable<String> task = new Task(path, WORDS);
      Future<String> result = executor.submit(task);
      futures.add(result);
    }
    executor.shutdown();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUT_PATH))) {
      for (Future<String> future : futures) {
        String out = future.get();
        if (out.length() > 1) {
          writer.write(out);
          writer.newLine();
        }
      }
    }
  }
}