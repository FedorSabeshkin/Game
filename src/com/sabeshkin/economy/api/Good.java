package com.sabeshkin.economy.api;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.format.api.Description;

/**
 * Товар на полке в магазине
 */
public interface Good {

  /**
   * Цена товара.
   */
  MoneyInTip getPrice();

  /**
   * Обмундирование.
   */
  Outfit getOutfit();

  /**
   * Описание товара.
   */
  Description getDescription();

}
