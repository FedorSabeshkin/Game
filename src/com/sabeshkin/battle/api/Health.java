package com.sabeshkin.battle.api;

/**
 * Здоровье - Обертки над стандартным числовым типом.
 */
public interface Health {

  /**
   * Хранимое значение.
   */
  Integer getCurrentHealth();

  /**
   * уМеньшает здоровье на переbodyданное кол-во единиц.
   */
  Health damage(Health damage);

  /**
   * уВеличивает здоровье на переданное кол-во единиц.
   */
  void treat(Health addingHealth);

}
