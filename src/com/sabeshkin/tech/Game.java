package com.sabeshkin.tech;

import com.sabeshkin.battle.api.PersonalRoom;
import com.sabeshkin.battle.impl.Battle;
import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.battle.impl.PersonalRoomImpl;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.api.Shop;
import com.sabeshkin.economy.exception.NotEnoughMoneyException;
import com.sabeshkin.economy.impl.ShopImpl;
import com.sabeshkin.format.api.Statistic;
import com.sabeshkin.format.impl.StatisticImpl;
import com.sabeshkin.timer.api.Timer;
import com.sabeshkin.timer.impl.TimerImpl;
import java.util.Scanner;

/**
 * Класс контейнер для реализации логики игры.
 */
public class Game {

  private Warrior warrior;

  private Statistic statistic;

  private final Shop shop;

  private final PersonalRoom personalRoom;

  private final Timer timer;


  /**
   * Класс контейнер для реализации логики игры.
   */
  public Game() {
    this.warrior = Warrior.createDefaultWarrior();
    this.statistic = new StatisticImpl();
    this.shop = ShopImpl.createDefault();
    this.personalRoom = new PersonalRoomImpl();
    this.timer = new TimerImpl();
  }

  /**
   * Выполняет проверку времени проведенного в игре и запускает выбор комнат игроком.
   */
  public void start() {
    while (!timer.isEnd()) {
      selectAction();
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
        BattleResult battleResult = battle.startWithNpc(warrior,
                                                        statistic,
                                                        scanner);
        warrior = battleResult.getWarrior()
                              .treatToDefaultSize();
        statistic = battleResult.getStatistic();
      case "М":
        warrior = shop.goToShop(warrior, scanner);
      case "Л":
        personalRoom.showOutfits(warrior, scanner);
      case "С":
        statistic.show();
      case "X":
        System.exit(0);
    }
    scanner.close();
  }

}
