package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.Power;

public class PowerImpl implements Power {

  private Integer currentPower;
  private Integer maxPower;

  public PowerImpl(Integer currentPower, Integer maxPower) {
    this.currentPower = currentPower;
    this.maxPower = maxPower;
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
  public void add(Power addingPower) {
    this.currentPower += addingPower.getCurrentPower();
  }

  @Override
  public Integer divide(int divider) {
    return currentPower/divider;
  }

  @Override
  public String toString() {
    return "Current power: " + currentPower + "\nMax power: " + maxPower;
  }
}
