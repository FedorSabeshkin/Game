package com.sabeshkin.battle.api;

import com.sabeshkin.battle.impl.Warrior;
import com.sabeshkin.format.api.Statistic;

/**
 * Содержит информацию о результате битвы
 */
public interface BattleResult {

  /**
   * Возвращает бойца после проведенных манипуляций с
   * его кошельком - зачисления или снятия по результатм битвы.
   */
  Warrior getWarrior();

  /**
   * Возвращает обновленную статистику, с учетом последнего боя.
   */
  Statistic getStatistic();
}
