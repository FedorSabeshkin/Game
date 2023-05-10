package main.java.com.sabeshkin.battle.api;

import main.java.com.sabeshkin.battle.impl.Warrior;
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
