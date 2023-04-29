package com.blind.backend.service;

public interface DeviceService {

    void updateDeviceSetting(String openBlind, String caseForBlind);

    boolean deviceByCodeExist(String deviceCode);
}
