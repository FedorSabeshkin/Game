package main.java.com.sabeshkin.timer.impl;

import main.java.com.sabeshkin.timer.api.Timer;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Для отслеживания времени проводимого в игре.
 */
public class TimerImpl
    implements Timer {

  public static final int MAX_MINUTES_IN_GAME = 30;


  private final LocalDateTime endGameTime;

  /**
   * Для отслеживания времени проводимого в игре.
   */
  public TimerImpl() {
    LocalDateTime startGameTime = LocalDateTime.now();
    this.endGameTime = startGameTime.plusMinutes(MAX_MINUTES_IN_GAME);
  }

  @Override
  public boolean isEnd() {
    return endGameTime.isBefore(LocalDateTime.now());
  }

  @Override
  public long showTimeLeft() {
    return Duration.between(
                       LocalDateTime.now(),
                       endGameTime)
                   .toMinutes();
  }

}
