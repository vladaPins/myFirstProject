package edu.homelab.task2;

import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ObjectBox<T> {

  private final int hashCode = new Random().nextInt();
  protected final Set<T> buffer;

  public ObjectBox() {
    buffer = new TreeSet<>();
  }

  public void addObject(T obj) {
    buffer.add(obj);
  }

  public void deleteObject(T obj) {
    buffer.remove(obj);
  }

  @Override
  public String toString() {
    return buffer.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ObjectBox<?> objectBox = (ObjectBox<?>) o;
    return hashCode == objectBox.hashCode && Objects.equals(buffer, objectBox.buffer);
  }

  @Override
  public int hashCode() {
    return hashCode;
  }

  public String dump() {
    StringBuilder result = new StringBuilder();
    for (Object obj : buffer) {
      result.append(obj.toString()).append(" ");
    }
    return result.toString();
  }
}