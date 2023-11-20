package edu.homelab.task6;

import java.io.Serializable;
import java.util.Objects;

public class Rabbit implements Serializable {

  private String nameRabbit;
  private Integer ageRabbit;

  public String getNameRabbit() {
    return nameRabbit;
  }

  public void setNameRabbit(String nameRabbit) {
    this.nameRabbit = nameRabbit;
  }

  public Integer getAgeRabbit() {
    return ageRabbit;
  }

  public void setAgeRabbit(Integer ageRabbit) {
    this.ageRabbit = ageRabbit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rabbit rabbit = (Rabbit) o;
    return Objects.equals(nameRabbit, rabbit.nameRabbit) && Objects.equals(ageRabbit, rabbit.ageRabbit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameRabbit, ageRabbit);
  }
}
