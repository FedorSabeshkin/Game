package com.sabeshkin.economy.excception;

/**
 * Исключение, выбрасываемое, когда пытается быть списанна сумма, меньше той, что находится в
 * наличии.
 */
public class NotEnoughMoneyException
    extends Exception {

  public NotEnoughMoneyException(String message) {
    super(message);
  }

}
