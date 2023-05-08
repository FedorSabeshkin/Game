package com.sabeshkin.battle.impl;

import static com.sabeshkin.battle.impl.Warrior.createDefaultWarrior;
import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.format.Result;
import com.sabeshkin.npc.api.Npc;
import com.sabeshkin.npc.impl.NpcImpl;
import java.util.Scanner;

/**
 * Реализации битвы бойцов.
 */
public class Battle {

  public static final int PROTECT_COEFFICIENT = 2;

  /**
   * Реализация логики битвы.
   */
  public void startBattle() {
    // create a scanner object to read input from System.in
    Scanner scanner = new Scanner(System.in);
    // create two warriors with initial health and power values
    Warrior w_1 = createDefaultWarrior();
    Warrior w_2 = createDefaultWarrior();
    w_1 = w_1.useOutfit();

    // print the ids of the warriors
    log("Warrior 1 id: " + w_1.getId());
    log("Warrior 2 id: " + w_2.getId());

    boolean isBattleContinue = isContinue(w_1, w_2);
    while (isBattleContinue) {
      Hod hod_1 = Hod.tryMakeHod(scanner);
      Hod hod_2 = Hod.tryMakeHod(scanner);
      w_2 = calculateDamage(hod_1, hod_2, w_1, w_2);
      w_1 = calculateDamage(hod_2, hod_1, w_2, w_1);
      isBattleContinue = isContinue(w_1, w_2);
    }
    Result resulter = new Result();
    resulter.calculate(w_1, w_2);

    // close the scanner object
    scanner.close();
  }

  /**
   * Реализация логики битвы с NPC.
   */
  public void startBattleNpc() {
    // create a scanner object to read input from System.in
    Scanner scanner = new Scanner(System.in);
    // create two warriors with initial health and power values
    Npc npc = new NpcImpl();
    Warrior w_1 = createDefaultWarrior();
    Warrior w_2 = createDefaultWarrior();
    w_1 = w_1.useOutfit();
    // print the ids of the warriors
    log("Идентификатор воина 1: " + w_1.getId());
    log("Идентификатор воина 2: " + w_2.getId());
    boolean isBattleContinue = isContinue(w_1, w_2);
    while (isBattleContinue) {
      Hod hod_1 = Hod.tryMakeHod(scanner);
      Hod hod_2 = npc.makeHod();
      w_2 = calculateDamage(hod_1, hod_2, w_1, w_2);
      w_1 = calculateDamage(hod_2, hod_1, w_2, w_1);
      isBattleContinue = isContinue(w_1, w_2);
    }
    Result resulter = new Result();
    resulter.calculate(w_1, w_2);

    // close the scanner object
    scanner.close();
  }

  /**
   * Получаем бойца после хода в котором его атакуют.
   *
   * @return боец после атаки по нему.
   */
  public Warrior calculateDamage(Hod h_1,
                                 Hod h_2,
                                 Warrior warrior_1,
                                 Warrior warrior_2) {
    boolean isProtectedPartForHit =
        h_2.getBodyPartEnumTargetForProtect() == h_1.getBodyPartEnumTargetForHit();
    if (isProtectedPartForHit) {
      Integer powerOfHit = warrior_1.getPower()
                                    .divide(PROTECT_COEFFICIENT);
      warrior_2 = warrior_2.hit(powerOfHit);
      return warrior_2;
    }
    Integer powerOfHit = warrior_1.getPower()
                                  .getCurrentPower();
    warrior_2 = warrior_2.hit(powerOfHit);
    return warrior_2;
  }

  /**
   * Проверка на то, что у боцов остались очки жизней для продолжения.
   */
  public boolean isContinue(Warrior w_1,
                            Warrior w_2) {
    return w_1.getHealth()
              .getCurrentHealth() > 0
        && w_2.getHealth()
              .getCurrentHealth() > 0;
  }

}
