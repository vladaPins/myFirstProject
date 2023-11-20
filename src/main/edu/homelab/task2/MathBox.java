package edu.homelab.task2;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox<T> {

  public MathBox(T[] array) {
    buffer.addAll(Arrays.asList(array));
  }

  // Метод суммирующий элементы коллекции
  public double summator() {
    double sum = 0.0;
    for (T element : buffer) {
      sum += element.doubleValue();
    }
    return sum;
  }

  // Метод выполняющий поочередное деление всех хранящихся
  // в объекте элементов на делитель, являющийся аргументом метода.
  public Set<Double> splitter(int divider) {
    Set<Double> result = new TreeSet<>();
    for (T element : buffer) {
      double elementAsDouble = element.doubleValue();
      result.add(elementAsDouble / divider);
    }
    return result;
  }

  // Метод, получающий на вход Integer и при наличии удаляющий его
  public void deleteDuplicate(T duplicate) {
    boolean isDeleted = buffer.remove(duplicate);
    if (isDeleted) {
      System.out.printf("Элемент %s был удален\n", duplicate);
    } else {
      System.out.printf("Элемент %s НЕ был удален\n", duplicate);
    }
  }
}
