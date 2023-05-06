package com.sabeshkin.battle.impl;

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
    System.out.println("Warrior, choose a body part to hit (HEAD, BODY or LEGS):");
    BodyPartEnum bodyPartTargetForHit2 =
        BodyPartEnum.valueOf(scanner.nextLine()
                                    .toUpperCase());
    System.out.println("Warrior, choose a body part to protect (HEAD, BODY or LEGS):");
    BodyPartEnum bodyPartTargetForProtect2 =
        BodyPartEnum.valueOf(
            scanner.nextLine()
                   .toUpperCase());
    return new Hod(
        bodyPartTargetForHit2, bodyPartTargetForProtect2);
  }

}
