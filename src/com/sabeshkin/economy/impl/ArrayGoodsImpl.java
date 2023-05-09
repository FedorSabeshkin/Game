package com.sabeshkin.economy.impl;

import com.sabeshkin.battle.api.WarriorId;
import com.sabeshkin.battle.impl.HealthImpl;
import com.sabeshkin.battle.impl.OutfitImpl;
import com.sabeshkin.battle.impl.PowerImpl;
import com.sabeshkin.battle.impl.WarriorIdImpl;
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

  public static ArrayGoods createDefault() {
    ArrayList<Good> defaultGoods = new ArrayList<>();
    WarriorId shopId = new WarriorIdImpl();
    defaultGoods.add(
        new GoodImpl(
            new MoneyInTipImpl(10),
            new OutfitImpl(shopId,
                           new HealthImpl(200),
                           new PowerImpl(0)),
            new GoodDescriptionImpl("Кольчуга")
        ));
    defaultGoods.add(
        new GoodImpl(
            new MoneyInTipImpl(10),
            new OutfitImpl(shopId,
                           new HealthImpl(10),
                           new PowerImpl(0)),
            new GoodDescriptionImpl("Шлем")
        ));
    defaultGoods.add(
        new GoodImpl(
            new MoneyInTipImpl(10),
            new OutfitImpl(shopId,
                           new HealthImpl(0),
                           new PowerImpl(10)),
            new GoodDescriptionImpl("Меч")
        ));
    return new ArrayGoodsImpl(defaultGoods);
  }

  @Override
  public Good get(int goodIndex) {
    return goods.get(goodIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int i = 0; i < goods.size(); i++) {
      Good good = goods.get(i);
      sb.append(i)
        .append(": ")
        .append(good)
        .append("\n");
    }
    return sb.toString();
  }

}
