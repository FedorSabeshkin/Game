package com.sabeshkin.economy.impl;

import com.sabeshkin.battle.api.WarriorId;
import com.sabeshkin.economy.api.Money;
import com.sabeshkin.economy.api.MoneyInTip;
import com.sabeshkin.economy.api.Wallet;
import com.sabeshkin.economy.excception.NotEnoughMoneyException;

/**
 * Кошелек игрока.
 */
public class WalletImpl
    implements Wallet {

  private MoneyInTip balance;

  /**
   * Кошелек игрока.
   */
  public WalletImpl() {
    this.balance = new MoneyInTipImpl(0);
  }

  /**
   * Кошелек игрока.
   */
  public WalletImpl(MoneyInTip balance) {
    this.balance = balance;
  }

  @Override
  public MoneyInTip getBalance() {
    return balance;
  }

  @Override
  public void payTo(WarriorId moneyRecipient,
                    MoneyInTip moneyInTip) throws
      NotEnoughMoneyException {
    if (balance.isLessThan(moneyInTip)) {
      throw new NotEnoughMoneyException("Недостаточно средств на счете для совершения операции.");
    }
    balance.subtract(moneyInTip);
  }

  @Override
  public void addMoney(Money money) {
    MoneyInTip moneyInTipForAdd = new MoneyInTipImpl(money.getValue());
    balance.add(moneyInTipForAdd);
  }

}
