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
    battle.startBattle();
  }

}