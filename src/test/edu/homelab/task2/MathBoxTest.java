package edu.homelab.task2;


import edu.homelab.task1.ShakerSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

//ТЕСТЫ
// 1) массив Integer,byte, short,  long);
// 2) массив double;
// 3) массив float;
// 4) символьный (char);
// 5) ссылочные типы String.
//6) массив byte
// 7) пустой массив
//8) массив short
//9) массив long
class MathBoxTest {
  @Test
  public void whenSortArrayOfIntegers() {
    var array = new Integer[]{4, 2, 3, 1, 5};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);
  }
}