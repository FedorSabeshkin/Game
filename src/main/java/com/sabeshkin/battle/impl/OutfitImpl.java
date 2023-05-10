package main.java.com.sabeshkin.battle.impl;

import main.java.com.sabeshkin.battle.api.Outfit;
import main.java.com.sabeshkin.battle.api.WarriorId;
import main.java.com.sabeshkin.battle.api.Health;
import main.java.com.sabeshkin.battle.api.Power;
import java.util.Objects;

/**
 * Обмундирование бойца.
 */
public class OutfitImpl
    implements Outfit {

  private final WarriorId ownerId;

  private final Health healthForAdd;

  private final Power powerForAdd;

  /**
   * Обмундирование бойца.
   */
  public OutfitImpl(WarriorId ownerId,
                    Health healthForAdd,
                    Power powerForAdd) {
    this.ownerId = ownerId;
    this.healthForAdd = healthForAdd;
    this.powerForAdd = powerForAdd;
  }

  /**
   * Создает Outfit не несущий никакого преимущества.
   */
  public static Outfit createOutfitWithZeros(WarriorId ownerId) {
    return new OutfitImpl(ownerId,
                          new HealthImpl(0),
                          new PowerImpl(0,
                                        0));
  }


  @Override
  public WarriorId getWarriorId() {
    return ownerId;
  }

  @Override
  public Health getHealth() {
    return healthForAdd;
  }

  @Override
  public Power getPower() {
    return powerForAdd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutfitImpl outfit = (OutfitImpl) o;
    return Objects.equals(ownerId, outfit.ownerId) && Objects.equals(healthForAdd,
                                                                     outfit.healthForAdd)
        && Objects.equals(powerForAdd, outfit.powerForAdd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, healthForAdd, powerForAdd);
  }

  @Override
  public String toString() {
    return "Здоровье+" + healthForAdd.getCurrentHealth() +
        "\n Сила+" + powerForAdd.getCurrentPower();
  }

}
