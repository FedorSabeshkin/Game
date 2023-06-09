package main.java.com.sabeshkin.battle.impl;

import main.java.com.sabeshkin.battle.api.Health;

/**
 * Здоровье - Обертки над стандартным числовым типом.
 */
public class HealthImpl
    implements Health {

  private Integer currentHealth;

  private Integer maxHealth;

  private static final int DEFAULT_HEALTH = 100;

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
    this.maxHealth = currentHealth;
  }

  /**
   * Дефолтное значение здоровья.
   */
  public static HealthImpl createDefaultHealth() {
    return new HealthImpl(DEFAULT_HEALTH, 100);
  }

  public Integer getCurrentHealth() {
    return currentHealth;
  }

  @Override
  public Health damage(Health damage) {
    Integer newCurrentHealth = this.currentHealth - damage.getCurrentHealth();
    if (newCurrentHealth < 0) {
      newCurrentHealth = 0;
    }
    return new HealthImpl(
        newCurrentHealth,
        this.maxHealth);
  }

  @Override
  public Health treat(Health addingHealth) {
    Integer newCurrentHealth = this.currentHealth + addingHealth.getCurrentHealth();
    return new HealthImpl(
        newCurrentHealth,
        this.maxHealth);
  }

  @Override
  public String toString() {
    return currentHealth.toString();
  }

}