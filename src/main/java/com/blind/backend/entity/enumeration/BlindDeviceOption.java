package com.blind.backend.entity.enumeration;

import lombok.Getter;

@Getter
public enum BlindDeviceOption {

    OPEN_BLIND(1),
    CLOSE_BLIND(2),
    OPEN_BLIND_WHEN_LIGHT(3),
    CLOSE_BLIND_WHEN_LIGHT(4),
    OPEN_BLIND_WHEN_TEMPERATURE_HIGHER(5),
    CLOSE_BLIND_WHEN_TEMPERATURE_HIGHER(6);

    private final Integer caseForBlind;

    BlindDeviceOption(Integer caseForBlind) {
        this.caseForBlind = caseForBlind;
    }
}
