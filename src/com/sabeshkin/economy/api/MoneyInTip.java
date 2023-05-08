package com.sabeshkin.economy.api;

/**
 * Сумма, на которую выставлен счет. Обертка над числовым типом.
 */
public interface MoneyInTip {

  /**
   * Получение текущего значения.
   */
  Integer getValue();

  /**
   * Возвращает true, если переданный аргумент больше того, от которого вызывается метод.
   */
  boolean isLessThan(MoneyInTip moneyInTip);

  /**
   * уВеличивает число денег на переданное кол-во единиц
   */
  void add(MoneyInTip money);

  /**
   * уМеньшает число денег на переданное кол-во единиц
   */
  void subtract(MoneyInTip money);

}
