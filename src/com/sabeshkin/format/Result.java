package com.sabeshkin.format;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.impl.Warrior;

/**
 * Расчитывает итог боя.
 */
public class Result {

  /**
   * Расчитывает итог боя.
   */
  public void calculate(Warrior w_1, Warrior w_2) {
    boolean isParitet =
        w_1.getHealth().getCurrentHealth() <= 0
            && w_2.getHealth().getCurrentHealth() <= 0;
    if (isParitet) {
      log("Ничья");
      return;
    }
    boolean isFirstWin = w_1.getHealth().getCurrentHealth() > w_2.getHealth().getCurrentHealth();
    if (isFirstWin) {
      log("Победа!");
      return;
    }
    log("Поражение. Будут новые победы.");
  }

}
