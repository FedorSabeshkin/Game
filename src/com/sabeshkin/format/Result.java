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
  public void calculate(Warrior w_1,
                        Warrior w_2) {
    boolean isStandoff = isStandoff(w_1, w_2);
    if (isStandoff) {
      log("Ничья");
      return;
    }
    boolean isFirstWin = isFirstWin(w_1, w_2);
    if (isFirstWin) {
      log("Победа!");
      return;
    }
    log("Поражение. Будут новые победы.");
  }

  /**
   * Проверка на ничью.
   */
  private boolean isStandoff(Warrior w_1,
                             Warrior w_2) {
    return w_1.getHealth()
              .getCurrentHealth() <= 0
        && w_2.getHealth()
              .getCurrentHealth() <= 0;
  }

  /**
   * Проверка что победил первый боец.
   */
  private boolean isFirstWin(Warrior w_1,
                             Warrior w_2) {
    return w_1.getHealth()
              .getCurrentHealth() > w_2.getHealth()
                                       .getCurrentHealth();
  }

}
