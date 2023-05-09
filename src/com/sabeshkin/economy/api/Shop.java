package com.sabeshkin.economy.api;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.exception.NotEnoughMoneyException;
import java.util.Scanner;

/**
 * Магазин, в котором можно приобрести обмундирование.
 */
public interface Shop {

  /**
   * Купить Outfit под переданным id товара. Его стоисомть будет автоматически списанна с кошелька
   * игрока. В случае недостаточности средств будет выбрашенно исключение.
   *
   * @param outfitKey id товара.
   * @return купленное обмундирование.
   */
  Outfit buy(int outfitKey,
             Wallet wallet) throws
      NotEnoughMoneyException;

  /**
   * Показывает список товаров и предлагает сделать покупку.
   *
   * @param warrior игрок.
   * @param scanner ввод ответов.
   */
  Warrior goToShop(Warrior warrior,
                   Scanner scanner) throws
      NotEnoughMoneyException;

}
