package com.sabeshkin.battle.impl;

import java.util.Scanner;

public class Hod {

  private Warrior beatingWarriorId;
  private Warrior protectiveWarriorId;
  private BodyPartEnum bodyPartTargetForHit;
  private BodyPartEnum bodyPartTargetForProtect;

  public Hod(Warrior beatingWarriorId, Warrior protectiveWarriorId,
      BodyPartEnum bodyPartTargetForHit, BodyPartEnum bodyPartTargetForProtect) {
    this.beatingWarriorId = beatingWarriorId;
    this.protectiveWarriorId = protectiveWarriorId;
    this.bodyPartTargetForHit = bodyPartTargetForHit;
    this.bodyPartTargetForProtect = bodyPartTargetForProtect;
  }

  public Hod(BodyPartEnum bodyPartTargetForHit, BodyPartEnum bodyPartTargetForProtect) {
    this.bodyPartTargetForHit = bodyPartTargetForHit;
    this.bodyPartTargetForProtect = bodyPartTargetForProtect;
    this.beatingWarriorId = null;
    this.protectiveWarriorId = null;
  }


  public Warrior getBeatingWarriorId() {
    return beatingWarriorId;
  }

  public Warrior getProtectiveWarriorId() {
    return protectiveWarriorId;
  }

  public BodyPartEnum getBodyPartEnumTargetForHit() {
    return bodyPartTargetForHit;
  }

  public BodyPartEnum getBodyPartEnumTargetForProtect() {
    return bodyPartTargetForProtect;
  }

  /**
   * Выполнение хода игроком.
   */
  public static Hod makeHod(Scanner scanner) {
    // ask warrior  to choose a body part to hit and a body part to protect
    System.out.println
        ("Warrior, choose a body part to hit (HEAD, BODY or LEGS):");
    BodyPartEnum bodyPartTargetForHit2 =
        BodyPartEnum.valueOf(scanner.nextLine().toUpperCase());
    System.out.println
        ("Warrior, choose a body part to protect (HEAD, BODY or LEGS):");
    BodyPartEnum bodyPartTargetForProtect2 =
        BodyPartEnum.valueOf(
            scanner.nextLine().toUpperCase());
    return new Hod(
        bodyPartTargetForHit2, bodyPartTargetForProtect2);
  }

}
