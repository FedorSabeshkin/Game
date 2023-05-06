package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.Health;
import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.api.Power;
import com.sabeshkin.battle.api.WarriorId;
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
    return "OutfitImpl{" +
        "ownerId=" + ownerId +
        ", healthForAdd=" + healthForAdd +
        ", powerForAdd=" + powerForAdd +
        '}';
  }

}
