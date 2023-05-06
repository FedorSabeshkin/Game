package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.Health;

/**
 * Здоровье - Обертки над стандартным числовым типом.
 */
public class HealthImpl
    implements Health {

  private Integer currentHealth;

  private Integer maxHealth;

  /**
   * Здоровье - Обертки над стандартным числовым типом.
   */
  public HealthImpl(Integer currentHealth,
                    Integer maxHealth) {
    this.currentHealth = currentHealth;
    this.maxHealth = maxHealth;
  }

  /**
   * Используется при вычитании из текущего значения здоровья другого игрока.
   */
  public HealthImpl(Integer currentHealth) {
    this.currentHealth = currentHealth;
    this.maxHealth = null;
  }


  public Integer getCurrentHealth() {
    return currentHealth;
  }

  @Override
  public Health damage(Health damage) {
    Integer newCurrentHealth = this.currentHealth - damage.getCurrentHealth();
    return new HealthImpl(
        newCurrentHealth,
        this.maxHealth);
  }

  @Override
  public void treat(Health addingHealth) {
    this.currentHealth += addingHealth.getCurrentHealth();
  }

  @Override
  public String toString() {
    return "Current health: " + currentHealth + "\nMax health: " + maxHealth;
  }

}