package com.sabeshkin.economy.impl;

import com.sabeshkin.economy.api.ArrayGoods;
import com.sabeshkin.economy.api.Good;
import java.util.ArrayList;

/**
 * Массив товаров.
 */
public class ArrayGoodsImpl
    implements ArrayGoods {

  private final ArrayList<Good> goods;

  /**
   * Массив товаров.
   */
  public ArrayGoodsImpl(ArrayList<Good> goods) {
    this.goods = goods;
  }

  @Override
  public Good get(int goodIndex) {
    return goods.get(goodIndex);
  }

  @Override
  public String toString() {
    return "Массив товаров:"
        + goods;
  }

}
