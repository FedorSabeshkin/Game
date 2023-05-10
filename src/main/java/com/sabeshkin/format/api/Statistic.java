package main.java.com.sabeshkin.format.api;

/**
 * Хранит информацию о статистике по игре.
 */
public interface Statistic {

  /**
   * Показывает статистику.
   */
  void show();

  /**
   * Добавить ничью.
   */
  void addOneStandoff();

  /**
   * Добавить победу.
   */
  void addOneWin();

  /**
   * Добавить поражение.
   */
  void addOneLoose();

}
