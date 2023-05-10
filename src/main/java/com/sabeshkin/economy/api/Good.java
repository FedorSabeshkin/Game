package main.java.com.sabeshkin.economy.api;

import main.java.com.sabeshkin.battle.api.Outfit;
import main.java.com.sabeshkin.format.api.Description;

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
