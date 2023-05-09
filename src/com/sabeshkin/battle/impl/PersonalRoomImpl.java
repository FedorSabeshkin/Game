package com.sabeshkin.battle.impl;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.api.PersonalRoom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Комната в которой хранится личное обмундирование.
 */
public class PersonalRoomImpl
    implements PersonalRoom {

  private Outfit[] outfits;

  @Override
  public Warrior inRoom(Warrior warrior,
                        Scanner scanner) {
    outfits = warrior.getBaggageOutfits()
                     .toArray(new Outfit[warrior.getBaggageOutfits()
                                                .size()]);
    showOutfits(outfits);
    log("Введите id обмундирования что бы его надеть.");
    String answer = scanner.nextLine()
                           .toUpperCase()
                           .trim();
    if (answer.equals("<")) {
      return warrior;
    }
    return tryChangePrevOutfitToSelected(warrior, answer, scanner);
  }

  private void showOutfits(Outfit[] outfits) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < outfits.length; i++) {
      sb.append(i)
        .append(": ")
        .append(outfits[i])
        .append("\n");
    }
    log(sb.toString());
  }

  /**
   * Замена надетого outfit на новый.
   *
   * @param warrior боец.
   * @param answer  введенный пользователем ответ.
   * @return боец одетый в выбранный outfit.
   */
  private Warrior tryChangePrevOutfitToSelected(Warrior warrior,
                                                String answer,
                                                Scanner scanner) {
    try {
      int outfitKey = Integer.parseInt(answer);
      Outfit selectedOutfit = outfits[outfitKey];
      return changePrevOutfitToSelected(warrior, selectedOutfit);
    } catch (
        NumberFormatException | ArrayIndexOutOfBoundsException exception) {
      log("Вы ввели неверный индекс обмундирования. "
              + "Попробуйте снова выбрать из того, что представлен в списке");
      return inRoom(warrior, scanner);
    }
  }

  /**
   * Дает бойцу выбранное обмундирование и снимает существующее.
   *
   * @param warrior        боец.
   * @param selectedOutfit выбранный outfit.
   * @return боец одетый в выбранный outfit.
   */
  private Warrior changePrevOutfitToSelected(Warrior warrior,
                                             Outfit selectedOutfit) {
    Outfit prevOutfit = warrior.getOutfit();
    warrior.getBaggageOutfits()
           .add(prevOutfit);
    warrior.getBaggageOutfits()
           .remove(selectedOutfit);
    return new Warrior(selectedOutfit, warrior);
  }

}
