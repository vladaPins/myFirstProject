package edu.homelab.task2;

import java.util.Arrays;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Integer[] array = {2, 1, 7, 8, 4, 10, 7};
    // Double[] array = {2.2, 4.8, 3.0, 5.7};
    String arrayAsString = Arrays.toString(array);
    System.out.println("Иссходный массив: " + arrayAsString);

    MathBox<Integer> mathBox = new MathBox<>(array);

    // Вызываем методы
    System.out.println("Before any manipulation: " + mathBox);

    double sum = mathBox.summator();
    System.out.println("Сумма элементов: " + sum); // Повторно вызываем toString() для отображения измененного состояния

    int divisor = 5;
    Set<Double> splitter = mathBox.splitter(divisor);
    System.out.println("Результат деления: " + splitter); // Повторно вызываем toString() для отображения измененного состояния

    Integer toDelete = 1;
    mathBox.deleteDuplicate(toDelete);
    System.out.println("After deleteDuplicate: " + mathBox);

    mathBox.addObject(toDelete);
    mathBox.deleteObject(toDelete);
    System.out.println("Dump: " + mathBox.dump());
    System.out.println("ToString: " + mathBox);
  }
}
