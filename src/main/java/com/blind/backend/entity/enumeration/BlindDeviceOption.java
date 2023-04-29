package com.blind.backend.entity.enumeration;

public enum BlindDeviceOption {

    OPEN_BLIND(1, 0),
    CLOSE_BLIND(0, 1),
    CLOSE_BLIND_WHEN_LIGHT(0, 1);

    private final Integer openBlind;

    private final Integer caseForBlind;


    BlindDeviceOption(Integer openBlind, Integer caseForBlind) {
        this.openBlind = openBlind;
        this.caseForBlind = caseForBlind;
    }
}
