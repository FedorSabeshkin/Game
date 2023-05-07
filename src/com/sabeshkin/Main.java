package com.sabeshkin;

import com.sabeshkin.battle.impl.Battle;

/**
 * Точка входа в игру.
 */
public class Main {

  /**
   * Точка входа в игру.
   */
  public static void main(String[] args) {
    Battle battle = new Battle();
    battle.startBattleNpc();
  }

}