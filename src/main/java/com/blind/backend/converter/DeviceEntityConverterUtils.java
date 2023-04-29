package com.blind.backend.converter;

import com.blind.backend.dto.response.AdminDeviceResponse;
import com.blind.backend.entity.DeviceEntity;

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


}
