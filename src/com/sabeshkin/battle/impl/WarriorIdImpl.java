package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.WarriorId;

import java.util.Objects;
import java.util.UUID;

/**
 * Идентификатор бойца.
 */
public class WarriorIdImpl
    implements WarriorId {

  private final UUID id;

  /**
   * Идентификатор бойца.
   */
  public WarriorIdImpl() {
    id = UUID.randomUUID();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WarriorIdImpl warriorId = (WarriorIdImpl) o;
    return Objects.equals(id, warriorId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return id.toString();
  }

}
