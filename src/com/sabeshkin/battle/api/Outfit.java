package com.sabeshkin.battle.api;

/**
 * Обмундирование бойца.
 */
public interface Outfit {

  /**
   * Id владельца - боец/магазин.
   */
  WarriorId getWarriorId();

  /**
   * Единицы здоровья, которые будут добавлены бойцу.
   */
  Health getHealth();

  /**
   * Единицы силы, которые будут добавлены бойцу.
   */
  Power getPower();

}
