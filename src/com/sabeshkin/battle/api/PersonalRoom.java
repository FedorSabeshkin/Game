package com.sabeshkin.battle.api;

/**
 * Комната в которой хранится личное обмундирование.
 */
public interface PersonalRoom {

  /**
   * Показывает массив обмундирования.
   */
  void showOutfits();

  /**
   * Дает бойцу выбранное обмундирование и снимает существующее.
   */
  void dressOutfit(int outfitKey);

}
