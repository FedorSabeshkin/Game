package com.sabeshkin.battle.impl;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.Health;
import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.api.Power;
import com.sabeshkin.battle.api.WarriorId;
import com.sabeshkin.economy.api.Wallet;
import com.sabeshkin.economy.impl.WalletImpl;

/**
 * Боец.
 */
public class Warrior {

  private Health health;

  private Power power;

  private Outfit outfit;

  private WarriorId id;

  private Wallet wallet;


  /**
   * Боец.
   */
  public Warrior(WarriorId id,
                 Health health,
                 Power power,
                 Outfit outfit,
                 Wallet wallet) {
    this.health = health;
    this.power = power;
    this.outfit = outfit;
    this.id = id;
    this.wallet = wallet;
  }

  /**
   * Боец с автогенерацией id.
   */
  public Warrior(Health health,
                 Power power,
                 Outfit outfit,
                 Wallet wallet) {
    this.health = health;
    this.power = power;
    this.outfit = outfit;
    this.id = new WarriorIdImpl();
    this.wallet = wallet;
  }

  /**
   * Боец с автогенерацией id, без обмундирования.
   */
  public Warrior(Health health,
                 Power power,
                 Wallet wallet) {
    this.health = health;
    this.power = power;
    this.id = new WarriorIdImpl();
    this.outfit = OutfitImpl.createOutfitWithZeros(id);
    this.wallet = wallet;
  }

  /**
   * Боец с обновленным здоровьем.
   */
  public Warrior(Health health,
                 Warrior prevWarriorState) {
    this.health = health;
    this.power = prevWarriorState.getPower();
    this.id = prevWarriorState.id;
    this.outfit = prevWarriorState.outfit;
    this.wallet = prevWarriorState.wallet;
  }

  /**
   * Создание бойца с дефолтными характеристиками.
   */
  public static Warrior createDefaultWarrior() {
    return new Warrior(HealthImpl.createDefaultHealth(),
                       new PowerImpl(90, 90),
                       new WalletImpl()
    );
  }

  /**
   * Здоровье.
   */
  public Health getHealth() {
    return health;
  }

  /**
   * Сила.
   */
  public Power getPower() {
    return power;
  }

  /**
   * Обмундирование.
   */
  public Outfit getOutfit() {
    return outfit;
  }

  /**
   * Идентификатор.
   */
  public WarriorId getId() {
    return id;
  }

  /**
   * Кошелек.
   */
  public Wallet getWallet() {
    return wallet;
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
    log(String.format("После атаки на %s: \n Его очки здоровья равны: %s", id, healthAfterDamage));
    return new Warrior(id,
                       healthAfterDamage,
                       power,
                       outfit,
                       wallet);
  }

  /**
   * Применяет характеристики обмундирования к бойцу.
   */
  public Warrior useOutfit() {
    Health healthAfterOutfit =
        health.treat(outfit.getHealth());
    Power powerAfterOutfit =
        power.add(outfit.getPower());
    return new Warrior(id,
                       healthAfterOutfit,
                       powerAfterOutfit,
                       outfit,
                       wallet);
  }

  /**
   * Боец с востановленным после боя здоровьем.
   */
  public Warrior treatToDefaultSize() {
    Health healthAfterOutfit = createDefaultHealth();
    return new Warrior(
        healthAfterOutfit,
        this);
  }

}