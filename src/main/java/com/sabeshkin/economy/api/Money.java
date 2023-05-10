package main.java.com.sabeshkin.economy.api;

/**
 * Деньги - требуется для экономики игры. Обертка над числовым типом данных.
 */
public interface Money {

  /**
   * Получение текущего значения.
   */
  Integer getValue();

  /**
   * уВеличивает число денег на переданное кол-во единиц
   */
  void add(Money money);

  /**
   * уМеньшает число денег на переданное кол-во единиц
   */
  void subtract(Money money);


}
