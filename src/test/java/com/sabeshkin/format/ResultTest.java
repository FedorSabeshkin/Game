package test.java.com.sabeshkin.format;

import static org.junit.jupiter.api.Assertions.*;

import main.java.com.sabeshkin.battle.impl.Warrior;
import main.java.com.sabeshkin.economy.api.MoneyInTip;
import main.java.com.sabeshkin.economy.impl.MoneyInTipImpl;
import main.java.com.sabeshkin.format.Result;
import org.junit.jupiter.api.Test;

class ResultTest {

  @Test
  void calculateLoose() {
    Result result = new Result();
    Warrior w_1_looser = Warrior.createDefaultWarrior();
    Warrior w_2 = Warrior.createDefaultWarrior();
    w_1_looser = w_1_looser.hit(100);
    Warrior finalW_1 = w_1_looser;
    assertDoesNotThrow(() -> result.calculate(finalW_1, w_2));
  }

  @Test
  void calculateWin() {
    Result result = new Result();
    Warrior w_1_winner = Warrior.createDefaultWarrior();
    Warrior w_2 = Warrior.createDefaultWarrior();
    w_2 = w_2.hit(100);
    Warrior finalW_2 = w_2;
    assertDoesNotThrow(() -> result.calculate(w_1_winner, finalW_2));
  }

  @Test
  void calculateStandoff() {
    Result result = new Result();
    Warrior w_1 = Warrior.createDefaultWarrior();
    Warrior w_2 = Warrior.createDefaultWarrior();
    addDefaultMoneyInTip(w_1);
    addDefaultMoneyInTip(w_2);
    assertDoesNotThrow(() -> result.calculate(w_1, w_2));
  }

  private void addDefaultMoneyInTip(Warrior w) {
    MoneyInTip defaultMoneyInTip = new MoneyInTipImpl(100);
    w.getWallet()
     .addMoney(defaultMoneyInTip);
  }

}