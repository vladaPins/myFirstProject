package edu.homelab.task3.generators.utlis;

import java.util.Random;

public class RandomUtils {

  private static final Random RANDOM = new Random();

  public static int nextInt(int min, int max) {
    return RANDOM.nextInt(max - min + 1) + min;
  }

  public static int nextInt(int bound) {
    return RANDOM.nextInt(bound);
  }

  private RandomUtils() {
    // because of utility class
  }
}
