package com.sabeshkin.format;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.battle.impl.BattleResultImpl;
import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.economy.api.MoneyInTip;
import com.sabeshkin.economy.api.Wallet;
import com.sabeshkin.economy.exception.NotEnoughMoneyException;
import com.sabeshkin.economy.impl.MoneyInTipImpl;
import com.sabeshkin.format.api.Statistic;

/**
 * Расчитывает итог боя.
 */
public class Result {

  private final MoneyInTip loosePrice;

  private final MoneyInTip reward;

  /**
   * Расчитывает итог боя.
   */
  public Result() {
    this.loosePrice = new MoneyInTipImpl(10);
    this.reward = new MoneyInTipImpl(10);
  }

  /**
   * Расчитывает итог боя.
   */
  public BattleResult calculate(Warrior w_1,
                                Warrior w_2,
                                Statistic statistic) {
    boolean isStandoff = isStandoff(w_1, w_2);
    if (isStandoff) {
      w_1 = payLoose(w_1);
      statistic.addOneStandoff();
      log("Ничья");
      return new BattleResultImpl(w_1, statistic);
    }
    boolean isFirstWin = isFirstWin(w_1, w_2);
    if (isFirstWin) {
      w_1 = win(w_1);
      statistic.addOneWin();
      return new BattleResultImpl(w_1, statistic);
    }
    w_1 = payLoose(w_1);
    statistic.addOneLoose();
    log("Поражение. Будут новые победы.");
    return new BattleResultImpl(w_1, statistic);
  }

  /**
   * Расчитывает итог боя.
   */
  public void calculate(Warrior w_1,
                        Warrior w_2) {
    boolean isStandoff = isStandoff(w_1, w_2);
    if (isStandoff) {
      payLoose(w_1);
      log("Ничья");
      return;
    }
    boolean isFirstWin = isFirstWin(w_1, w_2);
    if (isFirstWin) {
      win(w_1);
      return;
    }
    payLoose(w_1);
    log("Поражение. Будут новые победы.");
  }

  /**
   * Обработка в случае Победы.
   */
  private Warrior win(Warrior w_1) {
    Wallet warriorWallet = w_1.getWallet();
    warriorWallet.addMoney(reward);
    log("Победа!");
    showSelfBalance(warriorWallet);
    return w_1;
  }

  private void showSelfBalance(Wallet warriorWallet) {
    log(String.format("Ваш баланс: %s", warriorWallet.getBalance()));
  }

  /**
   * Обработка в случае Ничьей/Проигрыша.
   */
  private Warrior payLoose(Warrior w_1) {
    Wallet warriorWallet = w_1.getWallet();
    try {
      warriorWallet.pay(loosePrice);
      showSelfBalance(warriorWallet);
      return w_1;
    } catch (NotEnoughMoneyException exception) {
      log("Вы проиграли все деньги. Игра оконченна.");
    }
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
