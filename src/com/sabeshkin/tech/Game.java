package com.sabeshkin.tech;

import com.sabeshkin.battle.impl.Battle;
import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.format.api.Statistic;
import com.sabeshkin.format.impl.StatisticImpl;
import java.util.Scanner;

/**
 * Класс контейнер для реализации логики игры.
 */
public class Game {

  private Warrior warrior;

  private Statistic statistic;

  /**
   * Класс контейнер для реализации логики игры.
   */
  public Game() {
    this.warrior = Warrior.createDefaultWarrior();
    this.statistic = new StatisticImpl();
  }

  /**
   * Выполняет проверку времени проведенного в игре и запускает выбор комнат игроком.
   */
  public void start() {
    while (DateT) {

    }
  }

  /**
   * Получение следующей команды из терминала и ее выполнение.
   */
  private void selectAction() {
    Scanner scanner = new Scanner(System.in);
    String in = scanner.nextLine()
                       .toUpperCase();
    switch (in) {
      case "Б":
        Battle battle = new Battle();
        BattleResult battleResult = battle.startWithNpc(warrior, statistic, scanner);
        warrior = battleResult.getWarrior()
                              .treatToDefaultSize();
        statistic = battleResult.getStatistic();
      case "М":
        warrior = shop.showGoods(warrior, scanner);
      case "Л":
        personalRoom.in(warrior, scanner);
      case "С":
        statistic.show();
      case "X":
        System.exit(0);
    }
    scanner.close();
  }

}