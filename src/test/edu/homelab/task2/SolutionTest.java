package edu.homelab.task2;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  public void test() {
    double a = 1.0;
    int b = 2;
    // double
    System.out.println(a / b);
  }

  @Test
  public void test2() {
    float a = 1.0f;
    int b = 2;
    // float но можно представить как double => считаем что double
    System.out.println(a / b);
  }

  @Test
  public void test3() {
    int a = 1;
    int b = 2;

    System.out.println((double) a / b);
  }
}
