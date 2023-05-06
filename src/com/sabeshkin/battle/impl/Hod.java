package com.sabeshkin.battle.impl;

import static com.sabeshkin.format.Formatter.log;

import java.util.Scanner;

/**
 * DTO с информацией о сделанном бойцами выборе во время хода.
 */
public class Hod {

  private BodyPartEnum bodyPartTargetForHit;

  private BodyPartEnum bodyPartTargetForProtect;

  /**
   * DTO с информацией о сделанном бойцами выборе во время хода.
   */
  public Hod(BodyPartEnum bodyPartTargetForHit,
             BodyPartEnum bodyPartTargetForProtect) {
    this.bodyPartTargetForHit = bodyPartTargetForHit;
    this.bodyPartTargetForProtect = bodyPartTargetForProtect;
  }

  /**
   * Получение части тела которую выбрали для Атаки.
   */
  public BodyPartEnum getBodyPartEnumTargetForHit() {
    return bodyPartTargetForHit;
  }

  /**
   * Получение части тела которую выбрали для Защиты.
   */
  public BodyPartEnum getBodyPartEnumTargetForProtect() {
    return bodyPartTargetForProtect;
  }

  /**
   * Выполнение хода игроком.
   */
  public static Hod makeHod(Scanner scanner) {
    // ask warrior  to choose a body part to hit and a body part to protect
    log("Воин, выбери часть тела противника для Атаки (HEAD, TORSO или LEGS):");
    BodyPartEnum bodyPartTargetForHit2 =
        BodyPartEnum.valueOf(scanner.nextLine()
                                    .toUpperCase());
    log("Воин, выбери часть своего тела для Защиты (HEAD, TORSO или LEGS):");
    BodyPartEnum bodyPartTargetForProtect2 =
        BodyPartEnum.valueOf(
            scanner.nextLine()
                   .toUpperCase());
    return new Hod(
        bodyPartTargetForHit2, bodyPartTargetForProtect2);
  }

  /**
   * Выполнение хода игроком с обработкой ошибки неверного аргумента.
   */
  public static Hod tryMakeHod(Scanner scanner) {
    try {
      return makeHod(scanner);
    } catch (IllegalArgumentException exception) {
      log("Введена неверная часть тела. Допустимые значения: HEAD, TORSO или LEGS. \n "
              + "Было введено: " + exception.getMessage() + "\n "
              + "Попробуйте выбрать часть тела еще раз.");
      return tryMakeHod(scanner);
    }
  }

}
