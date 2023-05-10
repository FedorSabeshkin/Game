package main.java.com.sabeshkin.economy.impl;

import main.java.com.sabeshkin.battle.api.Outfit;
import main.java.com.sabeshkin.economy.api.Good;
import main.java.com.sabeshkin.economy.api.MoneyInTip;
import main.java.com.sabeshkin.format.api.Description;
import java.util.Objects;

/**
 * Товар на полке в магазине
 */
public class GoodImpl
    implements Good {

  private final MoneyInTip price;

  private final Outfit outfit;

  private final Description goodDescription;

  /**
   * Товар на полке в магазине
   */
  public GoodImpl(MoneyInTip price,
                  Outfit outfit,
                  Description goodDescription) {
    this.price = price;
    this.outfit = outfit;
    this.goodDescription = goodDescription;
  }

  @Override
  public MoneyInTip getPrice() {
    return price;
  }

  @Override
  public Outfit getOutfit() {
    return outfit;
  }

  @Override
  public Description getDescription() {
    return goodDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodImpl good = (GoodImpl) o;
    return Objects.equals(price, good.price) && Objects.equals(outfit,
                                                               good.outfit)
        && Objects.equals(goodDescription, good.goodDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, outfit, goodDescription);
  }

  @Override
  public String toString() {
    return "Цена=" + price +
        "\nОбмундирование=" + outfit +
        "\nОписание=" + goodDescription;
  }

}
