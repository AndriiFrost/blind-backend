package com.blind.backend.converter;

import com.blind.backend.dto.request.DeviceUpdateRequest;
import com.blind.backend.dto.response.AdminDeviceResponse;
import com.blind.backend.dto.response.DeviceResponse;
import com.blind.backend.entity.DeviceEntity;
import java.util.Objects;

public final class DeviceEntityConverterUtils {

    private DeviceEntityConverterUtils() {
    }

    public static AdminDeviceResponse convertDeviceToAdminResponse(DeviceEntity deviceEntity) {
        return AdminDeviceResponse.builder()
                .id(deviceEntity.getDeviceId())
                .blindDeviceOption(deviceEntity.getBlindDeviceOption())
                .specialDeviceTopicSubName(deviceEntity.getSpecialDeviceTopicSubName())
                .specialDeviceCode(deviceEntity.getSpecialDeviceCode())
                .specialDevicePasswordCode(deviceEntity.getSpecialDevicePasswordCode())
                .build();
    }

    public static DeviceResponse convertDeviceToDeviceResponse(DeviceEntity deviceEntity) {
        return DeviceResponse.builder()
                .id(deviceEntity.getDeviceId())
                .blindDeviceOption(deviceEntity.getBlindDeviceOption())
                .deviceName(deviceEntity.getDeviceName())
                .deviceDescription(deviceEntity.getDeviceDescription())
                .temperatureForSensor(deviceEntity.getTemperatureForSensor())
                .build();
    }

    public static DeviceEntity updateDevice(DeviceEntity deviceToUpdate, DeviceUpdateRequest deviceUpdateRequest) {
        deviceToUpdate.setDeviceDescription(Objects.requireNonNullElse(deviceUpdateRequest.getDeviceDescription(),
                deviceToUpdate.getDeviceDescription()));
        deviceToUpdate.setDeviceName(Objects.requireNonNullElse(deviceUpdateRequest.getDeviceName(),
                deviceToUpdate.getDeviceName()));
        deviceToUpdate.setBlindDeviceOption(Objects.requireNonNullElse(deviceUpdateRequest.getBlindDeviceOption(),
                deviceToUpdate.getBlindDeviceOption()));
        deviceToUpdate.setTemperatureForSensor(Objects.requireNonNullElse(deviceUpdateRequest.getTemperatureForSensor(),
                deviceToUpdate.getTemperatureForSensor()));
        return deviceToUpdate;
    }
}
