package com.sabeshkin;

import static com.sabeshkin.battle.impl.Warrior.createDefaultWarrior;
import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.impl.Battle;
import com.sabeshkin.battle.impl.Hod;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.format.Result;
import java.util.Scanner;

/**
 * Точка входа в игру.
 */
public class Main {

  /**
   * Точка входа в игру.
   */
  public static void main(String[] args) {
    Battle battle = new Battle();
    // create a scanner object to read input from System.in
    Scanner scanner = new Scanner(System.in);
    // create two warriors with initial health and power values
    Warrior w_1 = createDefaultWarrior();
    Warrior w_2 = createDefaultWarrior();

    // print the ids of the warriors
    log("Warrior 1 id: " + w_1.getId());
    log("Warrior 2 id: " + w_2.getId());

    boolean isBattleContinue = battle.isBattleContinue(w_1, w_2);
    while (isBattleContinue) {
      Hod hod_1 = Hod.makeHod(scanner);
      Hod hod_2 = Hod.makeHod(scanner);
      w_2 = battle.calculateDamage(hod_1, hod_2, w_1, w_2);
      w_1 = battle.calculateDamage(hod_2, hod_1, w_2, w_1);
      isBattleContinue = battle.isBattleContinue(w_1, w_2);
    }
    Result resulter = new Result();
    resulter.calculate(w_1, w_2);

    // close the scanner object
    scanner.close();
  }
}