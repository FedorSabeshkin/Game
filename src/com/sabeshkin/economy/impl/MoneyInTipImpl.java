package com.sabeshkin.economy.impl;

import com.sabeshkin.economy.api.Money;
import com.sabeshkin.economy.api.MoneyInTip;

/**
 * Сумма, на которую выставлен счет. Обертка над числовым типом.
 */
public class MoneyInTipImpl
    implements MoneyInTip {

  private Integer value;

  /**
   * Сумма, на которую выставлен счет. Обертка над числовым типом.
   */
  public MoneyInTipImpl(Integer value) {
    this.value = value;
  }

  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public boolean isLessThan(MoneyInTip moneyInTip) {
    return value < moneyInTip.getValue();
  }

  @Override
  public void subtract(MoneyInTip money) {
    value -= money.getValue();
  }

  @Override
  public void add(MoneyInTip money) {
    value += money.getValue();
  }

}
