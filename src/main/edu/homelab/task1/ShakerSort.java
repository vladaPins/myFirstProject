package edu.homelab.task1;

public class ShakerSort {

  public static <T extends Comparable<T>> void shakerSort(T[] array) {
    if (array == null) {
      return;
    }
    T temp;
    int leftSide = 1;
    int rightSide = array.length - 1;

    do {
      for (int i = rightSide; i >= leftSide; i--) {
        if (array[i - 1].compareTo(array[i]) > 0) {
          temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
        }
      }
      leftSide++;

      for (int i = leftSide; i <= rightSide; i++) {
        if (array[i - 1].compareTo(array[i]) > 0) {
          temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
        }
      }
    }
    while (leftSide <= rightSide);
  }


}

