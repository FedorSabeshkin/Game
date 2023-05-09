package com.sabeshkin.battle.impl;

import static com.sabeshkin.format.Formatter.log;

import com.sabeshkin.battle.api.Outfit;
import com.sabeshkin.battle.api.PersonalRoom;
import java.util.Scanner;

/**
 * Комната в которой хранится личное обмундирование.
 */
public class PersonalRoomImpl
    implements PersonalRoom {

  private Outfit[] outfits;

  @Override
  public Warrior showOutfits(Warrior warrior,
                             Scanner scanner) {
    outfits = warrior.getBaggageOutfits()
                     .toArray(new Outfit[warrior.getBaggageOutfits()
                                                .size()]);
    log(outfits);
    log("Введите id обмундирования что бы его надеть.");
    String answer = scanner.nextLine()
                           .toUpperCase()
                           .trim();
    if (answer.equals("<")) {
      return warrior;
    }
    return tryChangePrevOutfitToSelected(warrior, answer, scanner);
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
      return showOutfits(warrior, scanner);
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
    return new Warrior(selectedOutfit, warrior);
  }

}
