package com.sabeshkin.timer.api;

/**
 * Для отслеживания времени проводимого в игре.
 */
public interface Timer {

  /**
   * Если время разрешенное для проведения в игре истекло, тогда true.
   */
  boolean isEnd();

  /**
   * Показать оставшееся время.
   */
  long showTimeLeft();

}
