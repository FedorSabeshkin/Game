package com.sabeshkin.economy.api;

import com.sabeshkin.economy.exception.NotEnoughMoneyException;

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
   * @param moneyInTip     сумма, на которую выставлен счет.
   */
  void pay(MoneyInTip moneyInTip) throws
      NotEnoughMoneyException;

  /**
   * Пополнение кошелька. Например, после Победы в бою.
   *
   * @param money деньги которые будут зачисленны на счет.
   */
  void addMoney(MoneyInTip money);

  /**
   * Снятие денег со счета кошелька. Например, после Проигрыша в бою.
   *
   * @param money деньги которые будут зачисленны на счет.
   */
  void subtractMoney(Money money);

}
