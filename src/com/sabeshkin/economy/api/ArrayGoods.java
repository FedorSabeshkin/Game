package com.sabeshkin.economy.api;

/**
 * Массив товаров.
 */
public interface ArrayGoods {

  /**
   * Получение товара по индексу.
   *
   * @param goodIndex индекс товара в массиве.
   * @return товар.
   */
  Good get(int goodIndex) throws
      IndexOutOfBoundsException;

}
