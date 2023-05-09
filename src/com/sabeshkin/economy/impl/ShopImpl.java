package com.sabeshkin.economy.impl;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.api.ArrayGoods;
import com.sabeshkin.economy.api.MoneyInTip;
import com.sabeshkin.economy.api.Shop;
import com.sabeshkin.economy.api.Wallet;
import com.sabeshkin.economy.exception.NotEnoughMoneyException;
import java.util.Objects;
import java.util.Scanner;

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

  public static ShopImpl createDefault() {
    ArrayGoods arrayGoods = ArrayGoodsImpl.createDefault();
    return new ShopImpl(arrayGoods);
  }

  @Override
  public Outfit buy(int outfitKey,
                    Wallet wallet) throws
      NotEnoughMoneyException {
    MoneyInTip moneyInTip = goods.get(outfitKey)
                                 .getPrice();
    wallet.pay(moneyInTip);
    return goods.get(outfitKey)
                .getOutfit();
  }

  @Override
  public Warrior goToShop(Warrior warrior,
                          Scanner scanner) {
    log(toString());
    log("Введите id товара для его покупки");
    String answer = scanner.nextLine()
                           .toUpperCase()
                           .trim();
    if (answer.equals("<")) {
      return warrior;
    }
    // Обработать исключения неправильного ввода напоминалокой о допустимых символах
    int outfitKey = Integer.parseInt(answer);
    return tryBuy(outfitKey, warrior, scanner);
  }

  /**
   * Попытка купить товар. Обрабатывается ситуациия нехватки средств.
   */
  private Warrior tryBuy(int outfitKey,
                         Warrior warrior,
                         Scanner scanner) {
    try {
      Outfit outfit = buy(outfitKey, warrior.getWallet());
      log("Покупка успешно совершена.");
      log("На бойца надето новое обмундирование.");
      return warrior.dress(outfit);
    } catch (NotEnoughMoneyException exception) {
      log("У вас недостаточно средств для покупки. "
              + "Выберите другой товар или выйдите из магазина.");
      return goToShop(warrior,
                      scanner);
    }
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
