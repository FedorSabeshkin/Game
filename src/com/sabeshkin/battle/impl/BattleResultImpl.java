package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.BattleResult;
import com.sabeshkin.format.api.Statistic;

/**
 * Содержит информацию о результате битвы
 */
public class BattleResultImpl
    implements BattleResult {

  private final Warrior warrior;

  private final Statistic statistic;

  /**
   * Содержит информацию о результате битвы
   */
  public BattleResultImpl(Warrior warrior,
                          Statistic statistic) {
    this.warrior = warrior;
    this.statistic = statistic;
  }

  @Override
  public Warrior getWarrior() {
    return warrior;
  }

  @Override
  public Statistic getStatistic() {
    return statistic;
  }

}
