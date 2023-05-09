package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.Power;

/**
 * Сила - Обертки над стандартным числовым типом.
 */
public class PowerImpl
    implements Power {

  private Integer currentPower;

  private Integer maxPower;

  /**
   * Сила - Обертки над стандартным числовым типом.
   */
  public PowerImpl(Integer currentPower,
                   Integer maxPower) {
    this.currentPower = currentPower;
    this.maxPower = maxPower;
  }

  /**
   * Сила - Обертки над стандартным числовым типом.
   */
  public PowerImpl(Integer currentPower) {
    this.currentPower = currentPower;
    this.maxPower = currentPower;
  }

  @Override
  public Integer getCurrentPower() {
    return currentPower;
  }

  @Override
  public void take(Power tookPower) {
    this.currentPower -= tookPower.getCurrentPower();
  }

  @Override
  public Power add(Power addingPower) {
    Integer currentPowerAfterAdd = this.currentPower + addingPower.getCurrentPower();
    return new PowerImpl(currentPowerAfterAdd, maxPower);
  }

  @Override
  public Integer divide(int divider) {
    return currentPower / divider;
  }

  @Override
  public String toString() {
    return "Current power: " + currentPower + "\nMax power: " + maxPower;
  }

}
