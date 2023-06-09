package main.java.com.sabeshkin.format.impl;

import static main.java.com.sabeshkin.format.Formatter.log;

import main.java.com.sabeshkin.format.api.Statistic;

/**
 * Хранит информацию о статистике по игре.
 */
public class StatisticImpl
    implements Statistic {

  private int winAmount;

  private int looseAmount;

  private int standoffAmount;

  /**
   * Хранит информацию о статистике по игре.
   */
  public StatisticImpl(int winAmount,
                       int looseAmount,
                       int standoffAmount) {
    this.winAmount = winAmount;
    this.looseAmount = looseAmount;
    this.standoffAmount = standoffAmount;
  }

  /**
   * Хранит информацию о статистике по игре.
   */
  public StatisticImpl() {
    this.winAmount = 0;
    this.looseAmount = 0;
    this.standoffAmount = 0;
  }

  @Override
  public void show() {
    log(toString());
  }

  @Override
  public void addOneStandoff() {
    standoffAmount++;
  }

  @Override
  public void addOneWin() {
    winAmount++;
  }

  @Override
  public void addOneLoose() {
    looseAmount++;
  }

  @Override
  public String toString() {
    return "Статистика \n" +
        "Победы=" + winAmount +
        "\nПоражения=" + looseAmount +
        "\nНичьи=" + standoffAmount;
  }

}
