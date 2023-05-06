package com.sabeshkin.battle.impl;

public class Battle {

  public static final int PROTECT_COEFICENT = 2;

  private Hod hod;

  public Battle() {
    this.hod = null;
  }

  public Battle(Hod hod) {
    this.hod = hod;
  }

  public Hod getHod() {
    return hod;
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
                                    .divide(PROTECT_COEFICENT);
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
