package com.sabeshkin.economy.impl;

import com.sabeshkin.format.Description;

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
