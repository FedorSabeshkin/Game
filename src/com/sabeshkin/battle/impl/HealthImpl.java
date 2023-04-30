package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.Health;

public class HealthImpl implements Health {
    private Integer currentHealth;
    private Integer maxHealth;

    public HealthImpl(Integer currentHealth, Integer maxHealth) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void damage(Health damage) {
        this.currentHealth -= damage.getCurrentHealth();
    }

    @Override
    public void treat(Health addingHealth) {
        this.currentHealth += addingHealth.getCurrentHealth();
    }

    @Override
    public String toString() {
        return "Current health: " + currentHealth + "\nMax health: " + maxHealth;
    }
}