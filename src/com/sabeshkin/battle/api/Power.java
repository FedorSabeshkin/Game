package com.sabeshkin.battle.api;

/**
 * Сила - Обертки над стандартным числовым типом.
 */
public interface Power {

    /**
     * Хранимое значение.
     */
    Integer getCurrentPower();

    /**
     * уМеньшает силу на переданное кол-во единиц.
     */
    void take(Power tookPower);

    /**
     * уВеличивает силу на переданное кол-во единиц.
     */
    void add(Power addingPower);
}
