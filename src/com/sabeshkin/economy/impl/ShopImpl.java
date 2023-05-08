package com.sabeshkin.economy.impl;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.impl.WarriorIdImpl;
import com.sabeshkin.economy.api.ArrayGoods;
import com.sabeshkin.economy.api.MoneyInTip;
import com.sabeshkin.economy.api.Shop;
import com.sabeshkin.economy.api.Wallet;
import com.sabeshkin.economy.excception.NotEnoughMoneyException;
import java.util.Objects;

/**
 * Магазин, в котором можно приобрести обмундирование.
 */
public class ShopImpl
    implements Shop {

  private ArrayGoods goods;

  /**
   * Магазин, в котором можно приобрести обмундирование.
   *
   * @param goods массив товаров.
   */
  public ShopImpl(ArrayGoods goods) {
    this.goods = goods;
  }

  @Override
  public Outfit buy(int outfitKey,
                    Wallet wallet) throws
      NotEnoughMoneyException {
    MoneyInTip moneyInTip = goods.get(outfitKey)
                                 .getPrice();
    wallet.payTo(new WarriorIdImpl(), moneyInTip);
    return goods.get(outfitKey)
                .getOutfit();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShopImpl shop = (ShopImpl) o;
    return Objects.equals(goods, shop.goods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goods);
  }

  @Override
  public String toString() {
    return "В магазине представленны: "
        + goods;
  }

}
