package main.java.com.sabeshkin.npc.impl;

import main.java.com.sabeshkin.battle.impl.BodyPartEnum;
import main.java.com.sabeshkin.battle.impl.Hod;
import main.java.com.sabeshkin.npc.api.Npc;
import java.util.Random;

/**
 * Класс реализующий поведение второго игрока - бот.
 */
public class NpcImpl
    implements Npc {

  /**
   * Выполнение случайного хода.
   */
  @Override
  public Hod makeHod() {
    BodyPartEnum bodyPartForHit = getRandomBodyPart();
    BodyPartEnum bodyPartForProtect = getRandomBodyPart();
    return new Hod(bodyPartForHit, bodyPartForProtect);
  }

  /**
   * Получение случайной части тела.
   */
  public BodyPartEnum getRandomBodyPart() {
    int randomId = getRandomIntId();
    return BodyPartEnum.getById(randomId);
  }

  /**
   * Получение случайного int Id.
   */
  public int getRandomIntId() {
    return getRandomNumberUsingInts(0, BodyPartEnum.values().length);
  }

  /**
   * Получение случайного числа в заданном диапазоне. Включая min и исключая max.
   */
  private int getRandomNumberUsingInts(int min,
                                       int max) {
    Random random = new Random();
    return random.ints(min, max)
                 .findFirst()
                 .getAsInt();
  }

}
