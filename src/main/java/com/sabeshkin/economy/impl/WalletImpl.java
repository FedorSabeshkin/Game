package main.java.com.sabeshkin.economy.impl;

import main.java.com.sabeshkin.economy.exception.NotEnoughMoneyException;
import main.java.com.sabeshkin.economy.api.Money;
import main.java.com.sabeshkin.economy.api.MoneyInTip;
import main.java.com.sabeshkin.economy.api.Wallet;

/**
 * Кошелек игрока.
 */
public class WalletImpl
    implements Wallet {

  public static final int DEFAULT_BALANCE = 30;

  private MoneyInTip balance;

  /**
   * Кошелек игрока.
   */
  public WalletImpl() {
    this.balance = new MoneyInTipImpl(0);
  }

  public static Wallet createDefault() {
    MoneyInTip balanceForWallet = new MoneyInTipImpl(DEFAULT_BALANCE);
    return new WalletImpl(balanceForWallet);
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
  public void pay(MoneyInTip moneyInTip) throws
      NotEnoughMoneyException {
    if (balance.isLessThan(moneyInTip)) {
      throw new NotEnoughMoneyException("Недостаточно средств на счете для совершения операции.");
    }
    balance.subtract(moneyInTip);
  }

  @Override
  public void addMoney(MoneyInTip moneyInTipForAdd) {
    balance.add(moneyInTipForAdd);
  }

  @Override
  public void subtractMoney(Money money) {

  }

}
