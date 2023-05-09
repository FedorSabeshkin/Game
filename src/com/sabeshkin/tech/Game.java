package com.sabeshkin.tech;

import com.sabeshkin.battle.impl.Battle;
import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.api.Shop;
import com.sabeshkin.economy.exception.NotEnoughMoneyException;
import com.sabeshkin.economy.impl.ShopImpl;
import com.sabeshkin.format.api.Statistic;
import com.sabeshkin.format.impl.StatisticImpl;
import java.util.Scanner;

/**
 * Класс контейнер для реализации логики игры.
 */
public class Game {

  private Warrior warrior;

  private Statistic statistic;

  private final Shop shop;

  /**
   * Класс контейнер для реализации логики игры.
   */
  public Game() {
    this.warrior = Warrior.createDefaultWarrior();
    this.statistic = new StatisticImpl();
    this.shop = ShopImpl.createDefault();
  }

  /**
   * Выполняет проверку времени проведенного в игре и запускает выбор комнат игроком.
   */
  public void start() {
    // Добавить класс Timer с методом .isEnd(), который проверяет завершилась ли игра.
    while (DateT) {

    }
  }

  /**
   * Получение следующей команды из терминала и ее выполнение.
   */
  private void selectAction() throws
      NotEnoughMoneyException {
    Scanner scanner = new Scanner(System.in);
    String in = scanner.nextLine()
                       .toUpperCase();
    switch (in) {
      case "Б":
        Battle battle = new Battle();
        BattleResult battleResult = battle.startWithNpc(warrior,
                                                        statistic,
                                                        scanner);
        warrior = battleResult.getWarrior()
                              .treatToDefaultSize();
        statistic = battleResult.getStatistic();
      case "М":
        warrior = shop.goToShop(warrior, scanner);
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
