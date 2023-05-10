package main.java.com.sabeshkin.economy.impl;

import main.java.com.sabeshkin.economy.api.Money;

/**
 * Деньги - требуется для экономики игры. Обертка над числовым типом данных.
 */
public class MoneyImpl
    implements Money {

  private Integer value;

  /**
   * Деньги - требуется для экономики игры. Обертка над числовым типом данных.
   */
  public MoneyImpl(Integer value) {
    this.value = value;
  }

  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public void subtract(Money money) {
    value -= money.getValue();
  }

  @Override
  public void add(Money money) {
    value += money.getValue();
  }

  @Override
  public String toString() {
    return value.toString();
  }

}
