package com.sabeshkin.battle.impl;

import com.sabeshkin.battle.api.BodyParts;

public enum BodyPartEnum implements BodyParts {

    HEAD("Head"),
    TORSO("Torso"),
    LEGS("Legs");

    private final String selected;

    BodyPartEnum(String selected) {
        this.selected = selected;
    }

    @Override
    public String getSelected() {
        return selected;
    }
}
