package com.sabeshkin.battle.api;

import com.sabeshkin.battle.impl.Warrior;
import java.util.Scanner;

/**
 * Комната в которой хранится личное обмундирование.
 */
public interface PersonalRoom {

  /**
   * Показывает массив обмундирования.
   */
  Warrior inRoom(Warrior warrior,
                 Scanner scanner);

}
