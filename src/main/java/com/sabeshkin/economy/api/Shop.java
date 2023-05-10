package main.java.com.sabeshkin.economy.api;

import main.java.com.sabeshkin.economy.exception.NotEnoughMoneyException;
import main.java.com.sabeshkin.battle.api.Outfit;
import main.java.com.sabeshkin.battle.impl.Warrior;
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
                   Scanner scanner) ;

}
