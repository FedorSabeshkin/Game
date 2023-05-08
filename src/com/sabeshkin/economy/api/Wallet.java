package com.sabeshkin.economy.api;

import com.sabeshkin.battle.api.WarriorId;
import com.sabeshkin.economy.excception.NotEnoughMoneyException;

/**
 * Кошелек игрока.
 */
public interface Wallet {

  /**
   * Получить текущий баланс.
   */
  MoneyInTip getBalance();

  /**
   * Оплатить услуги.
   *
   * @param moneyRecipient кому следует перечислить деньги.
   * @param moneyInTip     сумма, на которую выставлен счет.
   */
  void payTo(WarriorId moneyRecipient,
             MoneyInTip moneyInTip) throws
      NotEnoughMoneyException;

  /**
   * Пополнение кошелька. Например, после победы в бою.
   *
   * @param money деньги которые будут зачисленны на счет.
   */
  void addMoney(Money money);

}
