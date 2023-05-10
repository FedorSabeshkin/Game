package main.java.com.sabeshkin.economy.impl;

import main.java.com.sabeshkin.format.api.Description;

/**
 * Описание товара.
 */
public class GoodDescriptionImpl
    implements Description {

  private final String description;

  /**
   * Описание товара.
   */
  public GoodDescriptionImpl(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return description;
  }

}
