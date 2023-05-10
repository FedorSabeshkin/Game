package main.java.com.sabeshkin.economy.exception;

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
