package com.sabeshkin.tech;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.battle.api.PersonalRoom;
import com.sabeshkin.battle.impl.Battle;
import com.sabeshkin.battle.impl.PersonalRoomImpl;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.api.Shop;
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

  private final String INSTRUCTION = "Введите: \n"
      + "\"Б\" что бы начать битву \n"
      + "\"М\" что бы войти в магазин\n"
      + "\"Л\" что бы войти в комнату с личным обмундированием\n"
      + "\"C\" что бы посмотреть статистику\n"
      + "\"X\" что бы выйти из игры\n"
      + "У вас осталось %s минут на игру. ";

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
    log("Вы попали в мир битв.");
    Scanner scanner = new Scanner(System.in);
    while (!timer.isEnd()) {
      selectAction(scanner);
    }
    log("Время для игры истекло.");
    scanner.close();
    System.exit(0);
  }

  /**
   * Получение следующей команды из терминала и ее выполнение.
   */
  private void selectAction(Scanner scanner) {
    log(String.format(INSTRUCTION, timer.showTimeLeft()));
    String in = scanner.nextLine()
                       .toUpperCase();
    switch (in) {
      case "Б": {
        Battle battle = new Battle();
        BattleResult battleResult = battle.startWithNpc(warrior,
                                                        statistic,
                                                        scanner);
        warrior = battleResult.getWarrior()
                              .treatToDefaultSize();
        statistic = battleResult.getStatistic();
        break;
      }
      case "М": {
        warrior = shop.goToShop(warrior, scanner);
        break;
      }
      case "Л": {
        personalRoom.inRoom(warrior, scanner);
        break;
      }
      case "С": {
        statistic.show();
        break;
      }
      case "Х":
        System.exit(0);
      default: {
        log("Вы ввели неверную команду, попробуйте еще раз");
        selectAction(scanner);
      }
    }
  }

}
