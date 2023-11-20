package edu.homelab.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class ShakerSortTest {
  //ТЕСТЫ
  // 1) целые числа (Integer,byte, short,  long);
  // 2) числа с плавающей точкой ( double, float);
  // 3) логический (boolean);
  // 4) символьный (char);
  // 5) ссылочные типы String.
  // 6) 2 элемента
  // 7) пустой массив


  //1)целые числа (Integer,byte, short,  long);
  @Test
  public void whenSortArrayOfIntegers() {
    var array = new Integer[]{4, 2, 3, 1, 5};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, array);
  }

  @Test
  public void whenSortArrayOfByte() {
    var array = new Byte[]{0, -128, -50, 20, 127};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Byte[]{-128, -50, 0, 20, 127}, array);
  }

  @Test
  public void whenSortArrayOfShort() {
    var array = new Short[]{32767, 32676, 0, -1, -32768};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Short[]{-32768, -1, 0, 32676, 32767}, array);
  }

  @Test
  public void whenSortArrayOfLong() {
    var array = new Long[]{-9223372036854775808L, 9223372036854775807L, 0L, 1L, 32768L};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Long[]{-9223372036854775808L, 0L, 1L, 32768L, 9223372036854775807L}, array);
  }

  // 2) числа с плавающей точкой ( double, float);
  @Test
  public void whenSortArrayOfDouble() {
    var array = new Double[]{4.5, 2.7, 3.8, 1.9, 5.1};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Double[]{1.9, 2.7, 3.8, 4.5, 5.1}, array);
  }

  @Test
  public void whenSortArrayOfFloat() {
    var array = new Float[]{1.4e-45f, 3.4e+38f, 0f, 1.4e-45f, -1f};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Float[]{1.4e-45f, 1.4e-45f, -1f, 0f, 3.4e+38f}, array);
  }

  // 3) логический (boolean);
  @Test
  public void whenSortArrayOfBoo() {
    var array = new Boolean[]{
        1 < 2, // true
        false,
        5 < 3, // false
        false,
        true
    };
    ShakerSort.shakerSort(array);

    // false, false, false, true, true

    Assertions.assertArrayEquals(new Boolean[]{
        "2".equals("3"),
        2 == 3,
        false,
        true == true,
        false != true
    }, array);
  }

  @Test
  public void test() {
    Boolean[] actual = {1 < 2};
    Boolean[] expected = { "John".equals("John")};

    Assertions.assertArrayEquals(expected, actual);
  }


  // 4) символьный (char);
  @Test
  public void whenSortArrayOfChar() {
    var array = new Character[]{'H', 'e', 'l', 'l', 'o'};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Character[]{'e', 'H', 'l', 'l', 'o'}, array);
  }

  // 5) ссылочные типы String.

  @Test
  public void whenSortArrayOfString() {
    var array = new String[]{"Холодная осень", "теплый март", "Холодная весна", "Холодная", "36 градусов Жары"};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new String[]{  "36 градусов Жары", "Холодная","Холодная весна","Холодная осень", "теплый март"}, array);
  }

  // 6) 2 элемента
  @Test
  public void whenSortArrayOf2Elements() {
    var array = new Integer[]{30, -5};
    ShakerSort.shakerSort(array);

    Assertions.assertArrayEquals(new Integer[]{-5,  30}, array);
  }

  // 7) пустой массив
  @Test
  public void whenSortArrayNotThrowsException() {
    Integer[] array = null;
    ShakerSort.shakerSort(array);

    Assertions.assertNull(array);
  }
}