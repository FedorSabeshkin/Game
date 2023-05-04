package com.sabeshkin.battle.impl;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.Health;
import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.api.Power;
import com.sabeshkin.battle.api.WarriorId;

/**
 * Боец.
 */
public class Warrior {

  private Health health;
  private Power power;
  private Outfit outfit;
  private WarriorId id;

  public Warrior(WarriorId id, Health health, Power power, Outfit outfit) {
    this.health = health;
    this.power = power;
    this.outfit = outfit;
    this.id = id;
  }

  public Warrior(Health health, Power power, Outfit outfit) {
    this.health = health;
    this.power = power;
    this.outfit = outfit;
    this.id = new WarriorIdImpl();
  }

  public Warrior(HealthImpl health, PowerImpl power) {
    this.health = health;
    this.power = power;
    this.outfit = null;
    this.id = new WarriorIdImpl();
  }

  public static Warrior createDefaultWarrior() {
    return new Warrior(new HealthImpl(100, 100), new PowerImpl(100, 100)
    );
  }

  public Health getHealth() {
    return health;
  }

  public Power getPower() {
    return power;
  }

  public Outfit getOutfit() {
    return outfit;
  }

  public WarriorId getId() {
    return id;
  }

  /**
   * Получаем бойца после атаки по нему.
   *
   * @param attackPower сила атаки.
   * @return боец после атаки по нему.
   */
  public Warrior hit(Integer attackPower) {
    Health healthAfterDamage =
        health.damage(
            new HealthImpl(attackPower));
    log(String.format("После атаки на {} его очки здоровья равны {}", id, healthAfterDamage));
    return new Warrior(id,
        healthAfterDamage,
        power,
        outfit);
  }
}