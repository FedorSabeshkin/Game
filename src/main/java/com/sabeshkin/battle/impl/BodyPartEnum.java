package main.java.com.sabeshkin.battle.impl;

import main.java.com.sabeshkin.battle.api.BodyParts;

public enum BodyPartEnum
    implements BodyParts {

  HEAD(0, "Head"),
  TORSO(1, "Torso"),
  LEGS(2, "Legs");

  private final String selected;

  private final Integer id;

  BodyPartEnum(Integer id,
               String selected) {
    this.id = id;
    this.selected = selected;
  }

  /**
   * Получение значения Enum по его id.
   */
  public static BodyPartEnum getById(int id) {
    switch (id) {
      case 0:
        return HEAD;
      case 1:
        return TORSO;
      case 2:
        return LEGS;
      default:
        throw new IndexOutOfBoundsException();
    }
  }
}
